package com.hy.demo.algorithm.sdkTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/11/11 14:39
 * @Copyright:reach-life
 * @Description:
 */
public class StreamTest {

    @Test
    public void testMap() {
        List<Integer> list = Arrays.asList(2,3,5);
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

}
