package com.maomao.leetcode.solution.tree;



/**
 * @auther: fujie.feng
 * @DateT: 2019-07-25
 */
public abstract class AbstractBinaryTreeFactory {


    protected abstract AbstractBinaryTreeFactory factory();

    protected abstract TreeNode add(TreeNode node, int value);

    protected abstract Class<? extends TreeNode> add(Class<? extends TreeNode> node, int value);

    /**
     * 初始化treeNode
     * @param data
     */
//    protected Class<? extends TreeNode> initTree(int[] data) {
//        if (data == null) {
//            return null;
//        }
//        AbstractBinaryTreeFactory factory = factory();
//        Class<? extends TreeNode> root = null;
//        for (int i = 0; i < data.length; i++) {
//            root = factory.add(root, data[i]);
//        }
//        return root;
//    }

    protected TreeNode initTree(int[] data) {
        if (data == null) {
            return null;
        }
        AbstractBinaryTreeFactory factory = factory();
        TreeNode root = null;
        for (int i = 0; i < data.length; i++) {
            root = factory.add(root, data[i]);
        }
        return root;
    }
}
