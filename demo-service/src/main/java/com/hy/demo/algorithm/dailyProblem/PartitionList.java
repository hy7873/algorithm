package com.hy.demo.algorithm.dailyProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/2/13 13:50
 * @Copyright:reach-life
 * @Description:
 * Given a linked list of numbers and a pivot k, partition the linked list so that all nodes less than k come before nodes greater than or equal to k.
    For example, given the linked list 5 -> 1 -> 8 -> 0 -> 3 and k = 3, the solution could be 1 -> 0 -> 5 -> 8 -> 3.
 */
public class PartitionList {

    public static List<Integer> partitionList(List<Integer> originList,int k) {
        List<Integer> destiList = new ArrayList<>();
        List<Integer> greaterList = new ArrayList<>();
        List<Integer> lessList = new ArrayList<>();
        for (int i = 0; i < originList.size(); i++) {
            if (originList.get(i) >= k) {
                greaterList.add(originList.get(i));
            } else {
                lessList.add(originList.get(i));
            }
        }
        destiList.addAll(lessList);
        destiList.addAll(greaterList);
        return destiList;
    }

    public static void main(String[] args) {
        List<Integer> originList = Arrays.asList(5,1,8,0,3);
        List<Integer> destiList = partitionList(originList,3);
        System.out.println(destiList);
    }

}
