package com.hy.demo.algorithm.leetcode.mergeLists;

import com.hy.demo.dataStructure.list.ListNode;

/**
 * @Author: wanghai
 * @Date:2019/12/16 11:34
 * @Copyright:reach-life
 * @Description:
 */
public class MergeLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode ans = null;
        for (int i = 0; i < lists.length - 1 ; i++) {
            ListNode temp;
            if (i == 0) {
                ans = lists[0];
                temp = lists[1];
            } else {
                temp = lists[i + 1];
            }
            ans = mergeTwoList(ans,temp);
        }
        return ans;
    }


    public static ListNode mergeTwoList(ListNode l1,ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.data < l2.data) {
            l1.next = mergeTwoList(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.initListNode(2,3,5,8);
        ListNode l2 = ListNode.initListNode(1,2,5,8,10);
        ListNode l3 = ListNode.initListNode(2,3,5,8,9);
        ListNode[] lists = {l1,l2,l3};
        ListNode l = mergeKLists(lists);
        ListNode.printListNode(l);
    }

}
