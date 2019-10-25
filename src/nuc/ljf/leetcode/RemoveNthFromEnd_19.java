/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: RemoveNthFromEnd_19 <br/>
 * Function: <br/>
 * Date: 2019年10月25日 12:58 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class RemoveNthFromEnd_19 {

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        RemoveNthFromEnd_19 solution = new RemoveNthFromEnd_19();
        System.out.println(solution.removeNthFromEnd(new ListNode(3), 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preNode = null, postNode = null;
        ListNode currentNode = head;
        for(int i = 1; null != currentNode; i++, currentNode = currentNode.next){
            if(i >= n+1) {
                preNode = i == n + 1 ? head : preNode.next;
            }
            if(n != 1 && i >= n-1) {
                postNode = i == n - 1 ? head : postNode.next;
            }
        }
        if(null == preNode) {
            return postNode;
        }else{
            preNode.next = postNode;
            return head;
        }
    }

}
