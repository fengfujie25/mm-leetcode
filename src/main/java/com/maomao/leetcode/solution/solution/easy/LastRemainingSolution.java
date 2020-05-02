package com.maomao.leetcode.solution.solution.easy;

/**
 * @author fujie.feng
 * @Date 2020-03-30
 */
public class LastRemainingSolution {

    public int lastRemaining(int n, int m) {

        int f = 0;

        for (int i = 2; i <= n; i++) {
            f = (m + f) % i;
        }
        return f;
    }

    public int f(int n, int m) {
        if (n == 1) return 0;
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    public static void main(String[] args) {
        LastRemainingSolution l = new LastRemainingSolution();
        System.out.println(l.lastRemaining(5, 3));
    }
}
