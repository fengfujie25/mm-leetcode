package com.maomao.leetcode.solution.solution.easy;

/**
 * 面试题05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fujie.feng
 * @Date 2020-04-25
 */
public class ReplaceSpace {

	public String replaceSpace(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		char[] array = new char[s.length() * 3];
		int size = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				array[size++] = '%';
				array[size++] = '2';
				array[size++] = '0';
			} else {
				array[size++] = c;
			}
		}
		return new String(array, 0, size);
	}

	public String replaceSpace2(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		int count = 0;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				count++;
			}
		}
		if (count == 0) {
			return s;
		}

		char[] array = new char[chars.length + 2 * count];
		int size = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				array[size++] = '%';
				array[size++] = '2';
				array[size++] = '0';
			} else {
				array[size++] = c;
			}
		}
		return new String(array, 0, size);

	}
}
