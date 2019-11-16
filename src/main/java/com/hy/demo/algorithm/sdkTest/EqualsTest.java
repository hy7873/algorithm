package com.hy.demo.algorithm.sdkTest;

import org.junit.Test;

/**
 * @Author: wanghai
 * @Date:2019/11/15 17:12
 * @Copyright:reach-life
 * @Description:
 */
public class EqualsTest {

    @Test
    public void test1() {
        Integer a = 1;
        Integer b = new Integer(1);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode() + "---》" + b.hashCode());
    }
}
