/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: MergeTwoLists_21 <br/>
 * Function: <br/>
 * Date: 2019年10月25日 17:35 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class MergeTwoLists_21 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        MergeTwoLists_21 solution = new MergeTwoLists_21();
        System.out.println(solution.mergeTwoLists(new ListNode(1), new ListNode(2)));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1) {
            return l2;
        }
        if(null == l2){
            return l1;
        }
        ListNode result = null;
        ListNode tmpNode, currentNode = null;
        while(null != l1 && null != l2) {
            if(l1.val < l2.val) {
                tmpNode = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                tmpNode = new ListNode(l2.val);
                l2 =  l2.next;
            }
            if(null == currentNode){
                currentNode = tmpNode;
                result = currentNode;
            }else {
                currentNode.next = tmpNode;
                currentNode = tmpNode;
            }
        }
        currentNode.next = null == l1 ? l2 : l1;
        return result;
    }

}
