package com.Study.Reactor;

import com.google.common.base.Supplier;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import org.apache.flink.api.java.tuple.Tuple2;


public class reatorDemo {
    public static void main(String[] args) throws Exception {

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String value) {
                System.out.println(value);
            }
        };

        // 为了简约，现在用 Java 8 风格
        Function<Integer, String> transformation = integer -> "" + integer;

        Supplier<Integer> supplier = () -> 123;

        BiConsumer<Consumer<String>, String> biConsumer = (callback, value) -> {
            for (int i = 0; i < 10; i++) {
                // 对要运行的最后逻辑运行做惰性求值
                callback.accept(value);
            }
        };

        // 注意生产者到双向消费者执行过程
        biConsumer.accept(
                consumer,
                transformation.apply(
                        supplier.get()
                )
        );
    }
}
