package com.hy.demo.algorithm.dailyProblem;

import com.hy.demo.util.JacksonUtil;
import org.junit.Test;

/**
 *
 	Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.
	For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
	10 = max(10, 5, 2)
	7 = max(5, 2, 7)
	8 = max(2, 7, 8)
	8 = max(7, 8, 7)
	Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
*/
public class DailyProblem_18 {


    @Test
    public void test1() {
       int a[] = {10, 5, 2, 7, 8, 7};
       int k = 4;
       System.out.println("array = " + JacksonUtil.bean2Json(implTest1(a, k)));
    }
    
    private int[] implTest1(int[] a,int k) {
    	int[] array = new int[a.length - k + 1];
    	int[] f_array = new int[k];
    	for (int i = 0; i < a.length - k + 1; i++) {
			for (int j = 0; j < k; j++) {
				f_array[j] = a[j + i];
			}
			int max = maxInArray(f_array);
			array[i] = max;
		}
    	return array;
    }
    
    private int maxInArray(int[] array) {
    	int max = array[0];
    	for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
    	return max;
    }

}
