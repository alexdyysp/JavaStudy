package com.Study.Reactor.Practice;

import java.util.ArrayList;
import java.util.List;

public class RecommandList {

    // 没有缓存，从推荐系统调用
    public List<Integer> getuserFavouriteFromRecommand (Integer userId){
        List<Integer> userFavourite = new ArrayList<>();
        for(int i=0; i<10; i++){
            userFavourite.add(((int) (Math.random()*100)) + userId * 100 );
        }
        return userFavourite;
    }

    // 代表已有缓存
    public List<Integer> getuserFavouriteFromCache (Integer userId){
        List<Integer> userFavourite = new ArrayList<>();
        for(int i=0; i<10; i++){
            userFavourite.add(((int) (Math.random()*100)) + userId * 1000 );
        }
        return userFavourite;
    }

    public static void main(String[] args){
        RecommandList recommandList = new RecommandList();
        recommandList.getuserFavouriteFromRecommand(112).forEach(System.out::println);
        recommandList.getuserFavouriteFromCache(112).forEach(System.out::println);

    }
}
