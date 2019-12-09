package com.hy.demo.algorithm.leetcode.validBraces;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: wanghai
 * @Date:2019/12/8 20:12
 * @Copyright:reach-life
 * @Description:
 */
public class ValidBraces {

    static Map<Character,Character> characterMap = new HashMap<>();

    static {
        characterMap.put('}','{');
        characterMap.put(']','[');
        characterMap.put(')','(');
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (characterMap.containsKey(c)) {
                //闭括号
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != characterMap.get(c)) {
                    return false;
                }
            } else {
                //开括号
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{([])}"));
    }

}
