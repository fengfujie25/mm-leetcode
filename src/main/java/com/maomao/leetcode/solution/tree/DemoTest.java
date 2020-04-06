package com.maomao.leetcode.solution.tree;

/**
 * @auther: fujie.feng
 * @DateT: 2019-07-25
 */
public class DemoTest {

    public static void main(String[] args) {
        GeneralBinaryTree generalBinaryTree = new GeneralBinaryTree();
        TreeNode node = generalBinaryTree.initTree(new int[]{6,5,7,4,8,2,9});
        System.out.println(generalBinaryTree.getNodeNumsForKLevel(node, 3));
    }
}
