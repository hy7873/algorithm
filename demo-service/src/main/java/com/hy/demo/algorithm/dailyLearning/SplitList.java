package com.hy.demo.algorithm.dailyLearning;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/4/17 23:14
 * @Copyright:reach-life
 * @Description: 拆分一个list为N份
 */
public class SplitList {

    public static <E> List<List<E>> splitList(List<E> list,int n) {
        List<List<E>> retList = new ArrayList<>();
        int size = list.size();
        //计算出每页的个数
        int pageCount = size % n == 0 ? size / n : size / n + 1;
        //计算总页数
        int pages = size % pageCount == 0 ? size / pageCount : size / pageCount + 1;
        List<E> subList = null;
        for (int i = 1; i <= pages; i++) {
            if (i < pages) {
                subList = list.subList( (i - 1) * pageCount , i * pageCount);
            } else {
                subList = list.subList( (i - 1) * pageCount , list.size());
            }
            retList.add(subList);
        }
        System.out.println("字列表数：" + retList.size());
        System.out.println("结果：" + new Gson().toJson(retList));
        return retList;
    }


    public static void main(String[] args) {
        int size = 101;
        int n = 50;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        splitList(list,n);
    }

}
