/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: AddTwoNumbers_2 <br/>
 * Function: <br/>
 * Date: 2019年10月12日 09:50 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class AddTwoNumbers_2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        AddTwoNumbers_2 solution = new AddTwoNumbers_2();
        System.out.println(solution.addTwoNumbers(new ListNode(2), new ListNode(3)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode curr = null;
        boolean isUp = false;
        ListNode currL1 = l1;
        ListNode currL2 = l2;
        for(; isUp || (null != currL1 || null != currL2) ;) {
            int val = 0;
            if(isUp) {
                val = getVal(currL1)+getVal(currL2)+1;
            }else{
                val = getVal(currL1)+getVal(currL2);
            }
            ListNode tmp = new ListNode(val%10);
            if(currL1 == l1){
                result = tmp;
            }else{
                curr.next = tmp;
            }
            curr = tmp;
            isUp = val >= 10;
            currL1 = getNext(currL1);
            currL2 = getNext(currL2);
        }
        return result;
    }

    private int getVal(ListNode listNode){
        return null == listNode ? 0 : listNode.val;
    }

    private ListNode getNext(ListNode listNode){
        return null == listNode ? null : listNode.next;
    }

}
