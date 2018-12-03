package com.zhongying.demo.algorithm.topN;

import com.google.gson.Gson;

/**
 * Created by wanghai on 2018/12/3.
 * 从10亿个数据中找出最大的前一千个
 *
 */
public class TopN {

    /**
     * 父节点
     * @param n
     * @return
     */
    private int parent(int n) {
        return (n - 1) / 2;
    }

    /**
     * 左孩子
     * @param n
     * @return
     */
    private int left(int n) {
        return 2*n + 1;
    }

    /**
     * 右孩子
     * @param n
     * @return
     */
    private int right(int n) {
        return 2*n + 2;
    }


    /**
     * 构建堆
     * @param n
     * @param data
     */
    private void buildHeap(int n,int[] data) {
        for (int i = 1; i < n; i++) {
            int t = i;
            while (t != 0 && data[parent(t)] > data[t]) {
                int temp = data[t];
                data[t] = data[parent(t)];
                data[parent(t)] = temp;
                t = parent(t);
            }
        }
    }

    /**
     *  调整data
     */
    private void adjust(int i,int n,int[] data) {
        if (data[i] < data[0]) {
            return;
        }
        //置换堆顶
        int temp = data[i];
        data[i] = data[0];
        data[0] = temp;
        //调整堆
        int t = 0;
        while ( (left(t) < n && data[t] > data[left(t)]) || (right(t) < n && data[t] > data[right(t)])) {
            if (right(t) < n && data[right(t)] < data[left(t)]) {
                //右孩子更小置换右孩子
                temp = data[t];
                data[t] = data[right(t)];
                data[right(t)] = temp;
                t = right(t);
            } else {
                //否则置换左孩子
                temp = data[t];
                data[t] = data[left(t)];
                data[left(t)] = temp;
                t = left(t);
            }
        }
    }

    public void findTopN(int n,int[] data) {
        buildHeap(n,data);
        for (int i = n; i < data.length; i++) {
            adjust(i,n,data);
        }
        System.out.println(new Gson().toJson(data));
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{56, 30, 71, 18, 29, 93, 44, 75, 20, 65, 68, 34};
        TopN topN = new TopN();
        topN.findTopN(2,arr1);
    }

}
