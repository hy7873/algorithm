package com.hy.demo.algorithm.daily.problem;


import java.math.BigDecimal;

/**
 *
 This problem was asked by Google.

 The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.

 Hint: The basic equation of a circle is x2 + y2 = r2.

 We will be sending the solution tomorrow, along with tomorrow's question. As always, feel free to shoot us an email if there's anything we can help with.
 */
public class DailyProblem_14 {


    public void test1() {
        int num = 100000000;
        double distance = 0;
        int hitPot = 0;
        for (int i = 0;i < num;i++) {
            double x = 2 * Math.random();
            double y = 2 * Math.random();
            //System.out.println("(" + x + "," + y +")");
            distance = Math.sqrt(Math.pow((x - 1),2) + Math.pow((y - 1),2));
            if (distance < 1) {
                hitPot ++;
            }
        }
        BigDecimal b = new BigDecimal(hitPot).divide(new BigDecimal(num),8,BigDecimal.ROUND_DOWN).multiply(new BigDecimal(4));
        double PI = b.doubleValue();
        System.out.println( "hitPot = " +hitPot + "  PI = " + PI);
    }

}
