package com.maomao.leetcode.solution.solution.easy;


/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * @auther: fujie.feng
 * @DateT: 2019-12-27
 */
public class ZSolution {

//    public String convert(String s, int numRows) {
//        if (numRows == 1) return s;
//
//        List<StringBuilder> rows = new ArrayList<>();
//        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
//            rows.add(new StringBuilder());
//        }
//
//        int curRow = 0;
//        boolean goingDown = false;
//
//        for (char c : s.toCharArray()) {
//            rows.get(curRow).append(c);
//
//            if (curRow == 0 || curRow == numRows - 1) {
//                goingDown = !goingDown;
//            }
//            curRow += goingDown ? 1 : -1;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (StringBuilder row : rows) {
//            sb.append(row);
//        }
//        return sb.toString();
//    }

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 1) return s;

        StringBuilder sb = new StringBuilder();

        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    sb.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
//        ZSolution z = new ZSolution();
//
//        String str = "abcdefghijklmnopqrstuvwxyz";
//
//        System.out.println(z.convert(str, 4));


        String srt = "1,1,11,1,1,2,2,4";
        System.out.println(srt.split(",").length);
    }
}
