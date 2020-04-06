package com.maomao.leetcode.solution.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: fujie.feng
 * @DateT: 2019-07-25
 */
public class Solution {

    private static Map<String, Integer> map = new HashMap<>();

    private static int sum = 0;

    public static int numEquivDominoPairs(int[][] dominoes) {

        for (int i = 0; i < dominoes.length; i++) {
            int a = dominoes[i][0];
            int b = dominoes[i][1];
            if (a > b) {
                a = dominoes[i][1];
                b = dominoes[i][0];
            }
            String key = String.valueOf(a) + String.valueOf(b);
            if (map.containsKey(key)) {
                int value = map.get(key);
                value++;
                map.put(key, value);
            } else {
                map.put(key, 1);
            }
        }

        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                sum = entry.getValue();
                return sum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] dominoes = new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}};
        System.out.println(Solution.numEquivDominoPairs(dominoes));
    }
}
