package com.Study.Reactor.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author daiyuanyang
 * @Date 2020/10/2 11:51 下午
 */
public class Repo {
    public Map<Integer, Integer> dict = new HashMap<>();

    {
        for(int i=0; i<20; i++){
            this.dict.put(i, i * 10);
        }
    }

    public Integer getById(Integer id){
        return this.dict.get(id);
    }

    public boolean isValid(Integer id){
        return this.dict.containsKey(id);
    }

    public static void main(String[] args) {
        Repo repo = new Repo();
        System.out.println(repo.getById(2));
    }
}
