package com.maomao.leetcode.solution.solution;

/**
 * @author fujie.feng
 * @Date 2020-04-03
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        String str1 = String.valueOf(x);


        return str1.equals(new StringBuffer(str1).reverse());
    }


    public static void main(String[] args) {
        String s = String.valueOf(122);

        StringBuffer sb = new StringBuffer(s);
        System.out.println(sb.toString());
        System.out.println(sb.reverse().toString());


//        System.out.println(new StringBuffer(s).reverse());
//        System.out.println(s);
    }
}
