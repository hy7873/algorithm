package com.hy.demo.algorithm.dailyProblem;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/10/2.
 * 求一个集合的子集
 * 每个集合的子集有2^n个
 * 比如一个三个元素的集合子集有8个
 * 而一个三位二进制数也刚好可以表示8个数字（000）（001）（010）（011）....
 * 有1的地方正好可以表示这个元素在这个子集中，这样构成8个子集
 */
public class SubList {

    public static <T> List<List<T>> getSubset(List<T> L) {
        List<List<T>> lists = new ArrayList<>();
        if (L == null || L.size() == 0) {
            return null;
        }
        for (int i = 0; i < Math.pow(2,L.size()); i++) {
            List<T> list = new ArrayList<>();
            int index = i;
            for (int j = 0; j < L.size();j++) {
                if ((index & 1) == 1){
                    list.add(L.get(j));
                }
                index >>= 1;
            }
            //System.out.println(list);
            lists.add(list);
        }
        return lists;
    }

    public void test() {
        List<Integer> L = Arrays.asList(2,3,5,6,7);
        getSubset(L);
    }


    public void test1() {
        for (int i = 1; i <= 1000; i++) {
            if ((i & (i - 1)) == 0) {
                System.out.println(i);
            }
        }
    }



}
