package com.hy.demo.algorithm.exhaustive;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: wanghai
 * @Date:2020/1/15 13:50
 * @Copyright:reach-life
 * @Description:运算符填充
 * 计算四则运算表达式的值
 */
public class OperationFilling {

    public static void operationFilling() {
        char[] operators = {'+','-','*','/'};
        int temp = 0;
        int ans = 0;
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < operators.length ; i++) {
            for (int j = 0; j < operators.length ; j++) {
                for (int k = 0; k < operators.length; k++) {
                    for (int l = 0; l < operators.length; l++) {
                        String s = String.format("5 %s 5 %s 5 %s 5 %s 5 = 5",operators[i],operators[j],operators[k],operators[l]);
                        String expression = String.format("5%s5%s5%s5%s5",operators[i],operators[j],operators[k],operators[l]);
                        if (calcExpression(expression) == 5) {
                            System.out.println(s);
                        }
                        ret.add(s);
                        if (operators[i] == '+' || operators[i] == '-') {
                            ans  = temp + 5;
                            if (operators[i] == '+') {
                                ans += 5;
                            }
                            if (operators[i] == '-') {
                                ans -= 5;
                            }
                        } else {
                            if (operators[i] == '*') {
                                ans = 5;
                            }
                            if (operators[i] == '-') {
                                ans -= 5;
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * 计算表达式
     * @param expression
     * @return
     */
    public static int calcExpression(String expression) {
        //数字栈
        Stack<Integer> numStack = new Stack<>();
        //符号栈
        Stack<Character> charStack = new Stack<>();
        char[] charArray = expression.toCharArray();
        for (int i = 0; i < charArray.length ; i++) {
            if (Character.isDigit(charArray[i])) {
                numStack.push(charArray[i] - '0');
            } else {
                if (charStack.isEmpty()) {
                    charStack.push(charArray[i]);
                } else {
                    //用当前元素符号和栈顶元素符号比较优先级
                    for(;;) {
                        if (comparePriority(charArray[i],charStack.lastElement())) {
                            charStack.push(charArray[i]);
                            break;
                        } else {
                            char sign = charStack.pop();
                            int right = numStack.pop();
                            int left  = numStack.pop();
                            numStack.push(calculate(left,sign,right));
                            if (charStack.isEmpty()) {
                                charStack.push(charArray[i]);
                                break;
                            }
                        }
                    }
                }
            }
        }

        while (!charStack.isEmpty()) {
            char sign = charStack.pop();
            int right = numStack.pop();
            int left = numStack.pop();
            numStack.push(calculate(left,sign,right));
        }
        return numStack.lastElement();
    }

    public static int calculate(int left,char sign,int right) {
        int ans = 0;
        switch (sign) {
            case '+':
                ans = left + right;
                break;
            case '-':
                ans = left - right;
                break;
            case '*':
                ans = left * right;
                break;
            case '/':
                ans = left / right;
                break;
        }
        return ans;
    }

    /**
     *
     * @param ch1
     * @param ch2
     * @return true:ch1 > ch2
     */
    public static boolean comparePriority(char ch1,char ch2) {
        if (ch1 == '+' || ch1 == '-') {
            return false;
        }
        if (ch1 == '*' || ch1 == '/') {
            if (ch2 == '+' || ch2 == '-') {
                return true;
            }
            if (ch2 == '*' || ch2 == '/') {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        operationFilling();
    }
}
