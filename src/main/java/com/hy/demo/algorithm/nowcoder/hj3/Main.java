package com.hy.demo.algorithm.nowcoder.hj3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author: wanghai
 * @Date:2021/8/6 10:31
 * @Copyright:www.letus.com
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<Integer> array = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                array.add(sc.nextInt());
            }
            array = array.stream()
                    .distinct()
                    .collect(Collectors.toList());
            array = array
                    .stream()
                    .sorted(Comparator.comparing(Integer::intValue))
                    .collect(Collectors.toList());
            for (int i = 0; i < array.size(); i++) {
                System.out.println(array.get(i));
            }
        }
    }

}
