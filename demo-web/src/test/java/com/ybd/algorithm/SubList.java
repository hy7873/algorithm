package com.ybd.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/10/2.
 * 求一个集合的子集
 */
public class SubList {

    public static List<List<Integer>> getSubset(List<Integer> L) {
        List<List<Integer>> lists = new ArrayList<>();
        if (L == null || L.size() == 0) {
            return null;
        }
        for (int i = 0; i < Math.pow(2,L.size()); i++) {
            List<Integer> list = new ArrayList<>();
            int index = i;
            for (int j = 0; j < L.size();j++) {
                if ((index & 1) == 1){
                    list.add(L.get(j));
                }
                index >>= 1;
            }
            System.out.println(list);
            lists.add(list);
        }
        return lists;
    }

    @Test
    public void test() {
        List<Integer> L = Arrays.asList(2,3,5,6,7);
        getSubset(L);
    }


    @Test
    public void test1() {
        for (int i = 1; i <= 1000; i++) {
            if ((i & (i - 1)) == 0) {
                System.out.println(i);
            }
        }
    }



}
