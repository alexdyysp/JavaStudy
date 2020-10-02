package com.Study.Stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo2 {

    class A{
        int to;
        int from;

        public A(int to, int from){
            this.to = to;
            this.from = from;
        }
    }

    @Test
    public void test(){
        List<A> list = Lists.newArrayList(new A(1,2), new A(1,3));
        list.stream().collect(Collectors.toMap(e->e.to, e->e.from, (v1,v2)->v1));
    }
}
