package com.alice.testProgram;

import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.List;

public class testList {
    @Cacheable(cacheManager = "cacheManager")
    public void getList(){

    }
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println( list);
        list.subList(0,1);
        System.out.println(list.subList(0,1));
    }
}
