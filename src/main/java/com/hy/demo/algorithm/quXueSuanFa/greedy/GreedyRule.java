package com.hy.demo.algorithm.quXueSuanFa.greedy;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/4/22 17:08
 * @Copyright:reach-life
 * @Description:贪心法则：海盗船问题
 */
public class GreedyRule {

    public static List<Integer> getMaxDiamond(List<Integer> diamonds, int capacity) {
        Collections.sort(diamonds);
        List<Integer> maxDiamond = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < diamonds.size(); i++) {
            temp += diamonds.get(i);
            if (temp <= capacity) {
                maxDiamond.add(diamonds.get(i));
            } else {
                break;
            }
        }
        return maxDiamond;
    }

    public static void main(String[] args) {
        List<Integer> diamonds = Arrays.asList(20,3,1,5,10,11);
        int capacity = 18;
        List<Integer> maxDiamond = getMaxDiamond(diamonds,capacity);
        System.out.println(new Gson().toJson(maxDiamond));
    }

}
