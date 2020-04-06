package com.maomao.leetcode.solution.solution;

/**
 * @author fujie.feng
 * @Date 2020-03-27
 */
public class NumberOfSteps {

    public static int numberOfSteps(int num) {
        int count = 0;

        while (num > 0) {
            num = num % 2 == 0 ?  num >> 1 : num - 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 123;
        System.out.println(NumberOfSteps.numberOfSteps(num));
    }

}
