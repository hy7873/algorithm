package com.hy.demo.algorithm.dailyProblem;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/2/27 10:34
 * @Copyright:reach-life
 * @Description:Let's define a "sevenish" number to be one which is either a power of 7, or the sum of unique powers of 7. The first few sevenish numbers are 1, 7, 8, 49, and so on. Create an algorithm to find the nth sevenish number.
 * 七次数
 */
public class SevenishNumber {

    public static Double getSevenishN(int n) {
        if (n == 1) {
            return 1.0;
        }
        if (n == 2) {
            return 7.0;
        }
       double pow = Math.pow(7,n - 1);
        List<Double> listPow = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            pow = Math.pow(7,i);
            listPow.add(pow);
        }
        List<List<Double>> lists = SubList.getSubset(listPow);
        for(Iterator<List<Double>> it = lists.iterator();it.hasNext();) {
            List<Double> listItem = it.next();
            if (listItem.size() == 1 || listItem.size() == 0) {
                it.remove();
            }
        }
        List<Double> listSum = new ArrayList<>();
        for (List<Double> listItem : lists) {
            listSum.add(getListSum(listItem));
        }
        listSum.addAll(listPow);
        Collections.sort(listSum);
        System.out.println(new Gson().toJson(listSum));
        return listSum.size() >= n ? listSum.get(n - 1) : 0.0;
    }

    public static Double getListSum(List<Double> list) {
        double b = 0;
        for (int i = 0; i < list.size(); i++) {
            b += list.get(i);
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + getSevenishN(6));
    }




}
