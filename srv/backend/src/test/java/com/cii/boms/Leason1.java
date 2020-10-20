package com.cii.boms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-14 20:37
 * @since 1.0
 */
public class Leason1 {


    private static List<Integer> list = new LinkedList<>();

    private static Set<Integer> set = new HashSet<>();

    private static Map<String,Object> map = new HashMap<>();

    public static void main(String[] args) throws JsonProcessingException {

        for (int i = 1; i <= 10; i++) {
            list.add(i);
            set.add(i);
        }
        for (int i = 1; i <= 10; i++) {
            list.add(i);
            set.add(i);
        }

        System.out.println("========list=======");
        for (int j=0;j<list.size();j++){
            System.out.println(list.get(j));
        }

        System.out.println("========set=======");

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("========map=====");

        map.put("name","davidcun");
        map.put("age",23);

        System.out.println(map.get("name"));
        System.out.println(map.get("age"));

    }

    public static void test(NiaoLei nl) {

        nl.fei();
    }

}
