package com.hy.demo.algorithm.leetcode.addTwoNumbers;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/10/28 13:17
 * @Copyright:reach-life
 * @Description:求两个数的和
 */
public class AddTwoNumbers {

    public static List<Integer> addTwoNumbers(List<Integer> list1,List<Integer> list2) {
        List<Integer> retList = new ArrayList<>();
        int m = list1.size() > list2.size() ? list1.size() : list2.size();
        int tempResult;
        int tempIncr = 0;
        int sum;
        List<Integer> tempList;
        if (list1.size() < list2.size()) {
            tempList = list1;
            list1 = list2;
            list2 = tempList;
        }
        if (list1.size() >= list2.size()) {
            for (int i = 0; i < list1.size() ; i++) {
                if (i < list2.size()) {
                    sum = list1.get(i) + list2.get(i) + tempIncr;
                    tempResult = sum % 10;
                    retList.add(tempResult);
                    if (sum >= 10) {
                        tempIncr = 1;
                    } else {
                        tempIncr = 0;
                    }
                } else {
                    sum = list1.get(i) + tempIncr;
                    tempResult = sum % 10;
                    retList.add(tempResult);
                    if (sum >= 10) {
                        tempIncr = 1;
                    } else {
                        tempIncr = 0;
                    }
                }
            }
            if (tempIncr > 0) {
                retList.add(tempIncr);
            }
        }
        return retList;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(2,9,5);
        List<Integer> list2 = Arrays.asList(7,9,8,2);
        System.out.println(new Gson().toJson(addTwoNumbers(list1,list2)));
    }



}
