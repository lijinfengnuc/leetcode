/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Q95 <br/>
 * Function: <br/>
 * Date: 2020年05月11日 17:18 <br/>
 *
 * @author lijinfeng
 */

public class Q95 {

    public static void main(String[] args) {
        Q95 q = new Q95();
        System.out.println(q.generateTrees(3));
    }

    public List<TreeNode> generateTrees(int n) {
        if(n < 1) {
            return new ArrayList<>();
        }
        //dp[i]表示由 1 ... i 为节点所组成的所有二叉搜索树
        List<TreeNode>[] dp = new ArrayList[n];
        dp[0] = Collections.singletonList(new TreeNode(1));
        for(int i = 1; i < n; i++) {
            List<TreeNode> lastTreeNodes = dp[i-1];
            List<TreeNode> currentTreeNodes = new ArrayList<>();
            //遍历所有的树
            for(TreeNode treeNode : lastTreeNodes) {
                currentTreeNodes.add(buildTree(treeNode, null, i));
                TreeNode currentNode = treeNode;
                //遍历根节点以及所有的右子节点
                while(null != currentNode) {
                    //替换当前树的当前节点，生成新的树
                    currentTreeNodes.add(buildTree(treeNode, currentNode, i));
                    currentNode = currentNode.right;
                }
            }
        }
        return dp[n-1];
    }

    //构建tree基于新的树，将其中的
    private TreeNode buildTree(TreeNode tree, TreeNode currentNode, int i){
        TreeNode newTree = new TreeNode(null == currentNode ? i : tree.val);
        LinkedList stack = new LinkedList();

        return newTree;
    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

}
