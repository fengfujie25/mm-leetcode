package com.maomao.leetcode.solution.solution;

/**
 * 最后一个单词的长度
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 *  
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fujie.feng
 * @Date 2020-04-09
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        //解法二
        String[] result = s.split(" ");
        return result.length == 0 ? 0 : result[result.length - 1].length();

        //解法一
//        int result = 0;
//        int end = s.length() - 1;
//        while (end >= 0) {
//            if (s.charAt(end--) != ' ') {
//                result++;
//            } else {
//                if (result > 0) {
//                    return result;
//                }
//            }
//        }
//        return result;
    }

    public static void main(String[] args) {
        LengthOfLastWord l = new LengthOfLastWord();
        System.out.println(l.lengthOfLastWord("hello world"));
    }
}
