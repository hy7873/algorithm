package com.hy.demo.algorithm.zigzagConversion;

/**
 * @Author: wanghai
 * @Date:2019/11/8 10:49
 * @Copyright:reach-life
 * @Description:
 */
public class ZigZagConversion {

    /**
     * 遍历字符串，将字符串填入正确的行
     * @param s
     * @param numRows
     * @return
     */
    public static String conversionStr(String s,int numRows) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows ; i++) {
            res[i] = new StringBuilder();
        }

        int rowNum = 0,flag = -1;
        for (int i = 0; i < len ; i++) {
            res[rowNum].append(s.charAt(i));
            if (rowNum == 0 || rowNum == numRows - 1) {
                //行数变化方向反转
                flag = (-1) * flag;
            }
            rowNum += flag;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            System.out.println(res[i]);
            stringBuilder.append(res[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        System.out.println(conversionStr(s,3));
    }

}
