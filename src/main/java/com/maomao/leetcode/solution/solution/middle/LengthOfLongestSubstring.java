package com.maomao.leetcode.solution.solution.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @author fujie.feng
 * @Date 2020-05-02
 */
public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int index = -1, ans = 0;

		for (int i = 0; i < n; i++) {
			//左指针向右移动 并移除一个字符
			if (i != 0) {
				set.remove(s.charAt(i - 1));
			}

			while (index + 1 < n && !set.contains(s.charAt(index + 1))) {
				set.add(s.charAt(index + 1));
				++index;
			}
			ans = Math.max(ans, index - i + 1);
		}
		return ans;
	}
}
