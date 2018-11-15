package com.ybd.service;

import com.zhongying.demo.algorithm.sort.BubbleSort;
import com.zhongying.demo.algorithm.sort.QuickSort;
import com.zhongying.demo.util.JacksonUtil;
import org.junit.Test;

/**
 * Created by Administrator on 2018/11/15.
 */
public class TestMain {

    @Test
    public void test1() {
        int[] a = {2,3,5,1,8,-1,-9};
        a = BubbleSort.bubbleSort(a);
        System.out.println(JacksonUtil.bean2Json(a));
    }

    @Test
    public void test2() {
        int[] a = {2,3,5,1,8,-1,-9};
        QuickSort.quickSort(a,0,a.length - 1);
        System.out.println(JacksonUtil.bean2Json(a));
    }

}
