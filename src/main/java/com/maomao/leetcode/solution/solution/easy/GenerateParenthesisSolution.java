package com.maomao.leetcode.solution.solution.easy;

import java.util.ArrayList;
import java.util.List;

/**
 *  括号生成
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fujie.feng
 * @Date 2020-04-09
 */
public class GenerateParenthesisSolution {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String cur) {
        if (left == 0 && right == 0) {
            res.add(cur);
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, cur + "(");
        }
        if (right > left) {
            dfs(left, right - 1, cur + ")");
        }
    }
}
