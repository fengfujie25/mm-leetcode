package com.maomao.leetcode.solution.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  二叉树的右视图
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fujie.feng
 * @Date 2020-04-22
 */
public class RightSideView {

    /**
     * BFS
     * 广度优先
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.getLeftNode() != null) {
                    queue.offer(treeNode.getLeftNode());
                }
                if (treeNode.getRightNode() != null) {
                    queue.offer(treeNode.getRightNode());
                }
                if (i == size - 1) {
                    result.add(treeNode.getValue());
                }
            }
        }
        return result;
    }

    private static List<Integer> result = new ArrayList<>();

    /**
     * DFS
     * 深度优先
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        if (root == null) return result;
        dfs(root, 0);
        return result;
    }

    /**
     * 按照 「根结点 -> 右子树 -> 左子树」 的顺序访问， 就可以保证每层都是最先访问最右边的节点的。
     *
     * （与先序遍历 「根结点 -> 左子树 -> 右子树」 正好相反，先序遍历每层最先访问的是最左边的节点）
     * @param node
     * @param depth
     */
    private void dfs(TreeNode node, int depth) {
        if (node == null)  return;
        if (depth == result.size()) {
            result.add(node.getValue());
        }
        depth++;
        dfs(node.getRightNode(), depth);
        dfs(node.getLeftNode(), depth);
    }
}
