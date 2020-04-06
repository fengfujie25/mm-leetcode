package com.maomao.leetcode.solution.solution;

/**
 * @author fujie.feng
 * @Date 2020-03-27
 */
public class HasGroupsSizeXSolution {

    public boolean hasGroupSizeX(int[] deck) {
        int[] counts = new int[10000];
        for (int i : deck) {
            counts[i]++;
        }

        int gcd = counts[deck[0]];
        for (int cnt : counts) {
            if (cnt == 0) continue;

            gcd = gcd(gcd, cnt);
            if (gcd < 2) return false;

        }
        return true;
    }

    private int gcd(int gcd, int cnt) {
        return gcd % cnt == 0 ? cnt : gcd(gcd % cnt,cnt);
    }

    public static void main(String[] args) {
        int[] deck = new int[]{1,2,3,4,4,3,2,1,5,5};
        HasGroupsSizeXSolution hasGroupsSizeXSolution = new HasGroupsSizeXSolution();
        System.out.println(hasGroupsSizeXSolution.hasGroupSizeX(deck));

    }
}
