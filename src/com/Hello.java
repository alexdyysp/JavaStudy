package com;

import java.util.Map;
import java.util.TreeMap;

public class Hello {
    /*

    The `TreeMap<K,V>` in the jdk `java.util` package can meet your needs. Whatever key you delete , the sort will never change.

If you want to define yourself sort method, just use its custom `comparator` to over-write construction method `TreeMap(Comparator<? super K> comparator)` to achieve key sorting.

```java
public static void main(String[] args) {
    Map<Integer, String> map = new TreeMap<Integer, String>();
    map.put(0, "A");
    map.put(1, "B");
    map.put(2, "C");
    map.put(3, "D");
    // whatever key you delete , the sort will not change...
    for (Map.Entry<Integer, String> entry : resultMap.entrySet()) {
        System.out.println(entry.getKey() + " " + entry.getValue());
    }
}

```

     */
    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<Integer, String>();
        map.put(0, "A");
        map.put(1, "B");
        map.put(2, "C");
        map.put(3, "D");
        //Map<String, String> resultMap = sortMapByKey(map);    //按Key进行排序
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
