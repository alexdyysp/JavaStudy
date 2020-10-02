package com.Study.Basic.Optional;

import lombok.Data;
import org.junit.Test;
import sun.jvm.hotspot.debugger.Page;

import java.util.Optional;

/**
 * @Author daiyuanyang
 * @Date 2020/9/19 10:48 下午
 */
public class TestOptional {

    @Data
    class Page{
        int limit;
        int offset;

    }

    @Data
    class A{
        Page page;
    }

    @Test
    public void optionalTest(){
        A a = new A();
        Page page = new Page();
        page.setLimit(1);
        a.setPage(page);
        System.out.println(Optional.ofNullable(a.getPage().getLimit() + a.getPage().getOffset()).orElseGet(()->0));
        System.out.println(Optional.ofNullable(a.getPage().getOffset() + a.getPage().getLimit()).orElseGet(()->0));

    }
}
