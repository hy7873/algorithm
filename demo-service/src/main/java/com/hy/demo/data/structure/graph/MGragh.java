package com.hy.demo.data.structure.graph;

import java.math.BigDecimal;

/**
 * @Author: wanghai
 * @Date:2019/2/14 14:25
 * @Copyright:reach-life
 * @Description: 数据结构，图的实现
 */
public class MGragh {

    static final int MAX = 65535;//两个顶点之间没有路径时的长度
    int verticks;//顶点
    int sides;
    int[][] arc;//存储图的二维数组
    String[] vex;//

    MGragh(int verticks) {
        this.verticks = verticks;
        this.sides = 0;
        for (int i = verticks - 1; i > 0 ; i--) {
            this.sides += i;
        }
        this.arc = new int[verticks][verticks];
        this.vex = new String[verticks];
        for (int i = 0; i < verticks; i++) {
            for (int j = 0; j < verticks; j++) {
                if (i != j) {
                    this.arc[i][j] = MAX;
                } else {
                    this.arc[i][j] = 0;
                }
            }
        }
    }


    public void addGraph() {
         //顶点数据
         this.vex[0] = "beijing";
         this.vex[1] = "shanghai";
         this.vex[2] = "tianjing";
         this.vex[3] = "chengdu";
         this.vex[4] = "changsha";
         this.vex[5] = "chongqing";

         //边的权值
        for (int i = 0; i < verticks; i++) {
            for (int j = 0; j < i; j++) {
                int n = (int)(Math.random() * 100);
                if (n > 0) {
                    this.arc[i][j] = this.arc[j][i] = n;
                } else {
                    this.arc[i][j] = this.arc[j][i] = MAX;
                }
            }
        }
    }

    public void printGraph() {
        for (int i = 0; i < verticks; i++) {
            if (i == 0) {
                System.out.println("*   ");
                for (int x = 0; x < verticks; x++) {
                    System.out.println(vex[x] + "  ");
                }
                System.out.println();
                System.out.println("==============================================================");
            }
            System.out.println(vex[i] + "   ");
            for (int j = 0; j < verticks; j++) {
                System.out.println(arc[i][j]);
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BigDecimal b = BigDecimal.ZERO;
        System.out.println(b.doubleValue() == 0);
    }

}
