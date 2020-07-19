# Stream 流编程
- 概念：是一个高级迭代器，关注于高效处理数据，pipline中处理数据
不是数据结构

## 外部迭代与内部迭代

## 中间操作/终止操作和惰性求值
```java 1.8
int sum2 = IntStream.of(nums).map(i->i*2).sum();
```
- map()是中间操作
- sum()是终止操作


```java 1.8
int sum3 = IntStream.of(nums).map(StreamDemo1::doublenum).sum();
```
- 惰性求值：终止没有调用的情况下，中间操作不会执行

## 流创建

|   | 方法  |
| --- | --- | 
| 集合 | Collection.stream/parallelStream |
| 数组 | Arrays.stream |
| 数字Stream | IntStream/LongStream.range/rangeClosed <br> Random.ints/longs/doubles |
| 自定义创建 | Stream.generate/iterate |

```javascript 1.8
// 从集合创建
List<String> list = new ArrayList<>();
list.stream();
list.parallelStream();

// 从数组创建
Arrays.stream(new int[]{2,3,5});

// 创建数字流
IntStream.of(1,2,3);
IntStream.rangeClosed(1,10);

// 使用Random创建一个无限流
new Random().ints().limit(10);
Random random = new Random();
Stream.generate(() -> random.nextInt()).limit(20);
```

## 中间操作

- 返回stream的操作
    - 有状态/无状态
    
| 操作 | 方法 |
| ---- | ---- |
| 无状态操作 | map/mapToXxx <br> flatMap/flatMapToXxx <br> filter <br> peek <br> unordered|
| 有状态操作 | distinct <br> sorted <br> limit/skip|

- filter: 过滤条件
- flatMap: A->B属性（是个集合），最终得到所有的A属性元素里面的所有B属性集合
- peek: 用于debug，是个中间操作和forEach是终止操作


## 终止操作

- 短路操作
    + 场景：无限流

| 操作 | 方法 |
| ---- | ---- |
| 非短路操作 | forEach/forEachOrder <br> collect/toArray <br> reduce <br> min/max/count |
| 短路操作   | findFirst/findAny <br> allMatch/anyMatch/noneMatch  |


## 并行流
不需要关心多线程与拆分任务

## 收集器
- 分组
收集器就是流的最终操作
收集集合类
再处理最终数据

## 运行机制
维护一个链
1. 所有操作链式调用，一个元素只迭代一次
2. 每一个中间操作返回一个新的流
    - 流中有一个属性sourceStage指向同一个地方，即链表头Head
3. Head->nextStage->nextStage->....->null
4. 有状态操作会截断无状态操作的链式调用，单独处理
5. 并行环境下，有状态的中间操作不一定能并行操作
6. parallel/sequential 也是中间操作操作(返回stream)，但是不创建流，仅仅修改head的并行标志

fork/join与阻塞