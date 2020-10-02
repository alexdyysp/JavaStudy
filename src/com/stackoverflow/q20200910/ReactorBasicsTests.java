package com.stackoverflow.q20200910;


import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author daiyuanyang
 * @Date 2020/9/10 5:49 下午
 */
public class ReactorBasicsTests {

//    @Test
//    public void testMatching() {
//        Mono<List<String>> matched = matching(
//                Arrays.asList("fruit", "vegetable", "meat"),
//                Arrays.asList("apple", "orange", "carrot", "meat"));
//        StepVerifier.create(matched)
//                .consumeNextWith(list -> {
//                    assertThat(list).containsExactlyInAnyOrder(
//                            "fruit+apple", "fruit+orange", "vegetable+carrot", "meat+meat");
//                })
//                .expectComplete()
//                .verify();
//    }

    /**
     * Items are matched when:
     * 1) they are equal (meat equals to meat)
     * 2) item is parent of child item (fruit is parent of apple)
     */
    public Mono<List<String>> matching(List<String> list1, List<String> list2) {
        Flux<String> items1 = Flux.fromIterable(list1);
        Flux<String> items2 = Flux.fromIterable(list2);
        List<String> matched = new ArrayList<>();

        return items1
                .flatMap(item1 -> items2
                        .flatMap(item2 -> {
                            // Check if item1 is equal to item2
                            Mono<Void> isEqual = Mono.fromSupplier(() -> {
                                if (item1.equals(item2)) {
                                    matched.add(item1 + "+" + item2);
                                }
                                return null; // I have to return something to compile the code
                            }).then();

                            // Check if item1 is parent of item2
                            Mono<Void> isParent = this.getParents(item2).hasElement(item1)
                                    .flatMap(booleanValue -> {
                                        if (booleanValue) {
                                            matched.add(item1 + "+" + item2);
                                        }
                                        return Mono.empty();
                                    });

                            return isEqual.then(isParent).then();
                        })
                ).then(Flux.fromIterable(matched).collectList());
    }

    /** This method simulates reactive database repository request that returns Flux<String> **/
    public Flux<String> getParents(String item) {
        if (item.equals("apple") || item.equals("orange")) return Flux.just("fruit", "food");
        else if (item.equals("carrot")) return Flux.just("vegetable", "food");
        return Flux.empty();
    }

}
