package com.maomao.leetcode.solution.solution.easy;

import com.maomao.leetcode.solution.algorithm.Solution;

/**
 * 面试题 08.11. 硬币
 *
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 *
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * 说明：
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= n (总金额) <= 1000000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fujie.feng
 * @Date 2020-04-23
 */
public class WaysToChange {

//    private static int mod = 1000000007;
//
//    public int waysToChange(int n) {
//        int ans = 0;
//        for (int i = 0; i * 25 < n; i++) {
//            int rest = n - i * 25;
//            int a = rest / 10;
//            int b = rest % 10 / 5;
//            ans = (ans + (a + 1) * (a + b + 1) % mod) % mod;
//        }
//        return ans;
//    }

    public int waysToChange(int n) {
        int[] dp = new int[n + 1];

        int[] coins = new int[]{1,5,10,25};


        //刚好可以用一个硬币凑成的情况，是一种情况
        // while i == coin :
        //dp[i] = dp[i - coin] => dp[0]
        dp[0] = 1;

        /**
         * dp方程：dp[i] += dp[i - coin];
         */

        for(int i = 1; i <= n; i++) {
            for(int coin: coins) {
                if(i - coin < 0) break;
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }

}
