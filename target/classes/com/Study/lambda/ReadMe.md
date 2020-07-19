# Lambda
返回实现指定接口的对象实例

## jdk8接口新特性
接口内部只有一个可实现的方法

1. @FunctionalInterface
    - 注解：接口是函数接口，不能有两个方法
    - 接口设计尽量小，单一责任原则

2. **默认方法** default 
    - 默认要实现的方法
    - 重要特性
    
## 函数接口

|      |      |      |      |
| ---- | ---- | ---- | ---- |
| 接口 | 输入参数 | 返回类型 | 说明 |
| Predicate<T>| T | boolean | 断言 |
| Consumer<T> | T | / | 消费一个数据 |
| Function<T,R> | T | R | 输入T输出R的函数 |
| Supplier<T> | / | T | 提供一个数据 |
| UnaryOperator<T> | T | T | 一元函数(输入输出类型相同) |
| BiFunction<T,U,R> | (T,U) | R | 2个输入函数 |
| BinaryOperator<T> | (T,T) | T | 二元函数（输入输出类型相通）|

## 方法引用
### 静态
### 非静态

## 类型推断

## 变量引用
```java 1.8
List<String> list = new ArrayList();
Consumer<String> con = s->System.println.out(s->list);
```
list传值，只传递右边对象

## 级联和柯里化
- x+y的级联表达式
```java 1.8
Function<Integer, Function<Integer, Integer>> fun = x->y->x+y;
fun.apply(2).apply(3);
```
- 柯里化：把多个参数的函数转换为只有一个参数的函数
    - 目的：函数标准化
- 高阶函数：返回函数的函数

# Stream 流编程
