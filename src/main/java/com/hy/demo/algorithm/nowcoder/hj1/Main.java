package com.hy.demo.algorithm.nowcoder.hj1;

import java.util.Scanner;

/**
 * @Author: wanghai
 * @Date:2021/8/2 10:27
 * @Copyright:www.letus.com
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] array = s.split(" ");
            int len = array.length;
            System.out.println(array[len - 1].length());
        }
    }


}
