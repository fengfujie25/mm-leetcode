package com.maomao.leetcode.solution.tree;

/**
 * @auther: fujie.feng
 * @DateT: 2019-07-25
 */
public class GeneralBinaryTree extends AbstractBinaryTreeFactory {

    protected AbstractBinaryTreeFactory factory() {
        return new GeneralBinaryTree();
    }

    protected TreeNode add(TreeNode node, int value) {
        TreeNode current = new TreeNode(value);

        if (node == null) {
            return current;
        }

        if (node.getValue() < value) {
            if (node.getRightNode() != null) {
                node.setRightNode(add(node.getRightNode(), value));
            } else {
                node.setRightNode(current);
            }
        } else {
            if (node.getLeftNode() != null) {
                node.setLeftNode(add(node.getLeftNode(), value));
            } else {
                node.setLeftNode(current);
            }
        }
        return node;
    }

    protected Class<? extends TreeNode> add(Class<? extends TreeNode> node, int value) {
        return null;
    }

    /**
     * 获取第k层节点数
     * @param root
     * @param k
     * @return
     */
    public int getNodeNumsForKLevel(TreeNode root, int k) {
        if (root == null || k < 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int leftNum = getNodeNumsForKLevel(root.getLeftNode(), k - 1);
        int rightNum = getNodeNumsForKLevel(root.getRightNode(), k - 1);
        return leftNum + rightNum;
    }

//    private boolean insert(SearchNode<T> curr, SearchNode<T> insertNode, SearchNode<T> parent, boolean currIsLeft) {
//        if (curr == null) {
//            curr = insertNode;
//            if (currIsLeft) {
//                parent.setLeft(curr);
//            } else {
//                parent.setRight(curr);
//            }
//        } else {
//            int result = curr.getValue().compareTo(insertNode.getValue());
//            // 如果当前值大于插入的值
//            if (result > 0) {
//                return insert((SearchNode<T>)curr.getLeft(), insertNode, curr, true);
//            } else if (result < 0) {
//                return insert((SearchNode<T>)curr.getRight(), insertNode, curr, false);
//            }else {
//                curr.freq++;
//            }
//        }
//        return true;
//    }

}
