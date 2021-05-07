package com.maomao.leetcode.solution;

import ch.qos.logback.core.util.StringCollectionUtil;

/**
 * select * from tbl where col1 = ? and (col2 = ? or col3 like ?) and col4 = ' 你是怎么了 ? 快起来呀' and col5 = ?
 *
 *
 * select * from tbl where col1 = $1 and (col2 = $2 or col3 like $3) and col4 = ' 你是怎么了 ? 快起来呀' and col5 = $4
 *
 * @author fujie.feng
 * @Date 2021-01-28
 */
public class SqlConvert {


	public static void main(String[] args) {
		SqlConvert convert = new SqlConvert();
		convert.convert("select * from tbl where col1 = ? and (col2 = ? or col3 like ?) and col4 = ' 你是怎么了 ? 快起来呀' and col5 = ?", 0);

		String sql = "select * from tbl where col1 = ? and (col2 = ? or col3 like ?) and col4 = ' 你是怎么了 ? 快起来呀' and col5 = ?";


	}

	public String convert(String sql, int index) {
		if (sql == null || sql.length() == 0) {
			return "";
		}
		int len = sql.length();
		char[] c = new char[len*2];

		int current = 0;
		for (int i = 0; i < len; i++) {

			if (i > 2 && sql.charAt(i) == '?' && sql.charAt(i - 2) == '=') {
				c[current++] = '$';
				c[current++] = String.valueOf(index++).charAt(0);
			} else {
				c[current++] = sql.charAt(i);
			}
		}

		String result = new String(c, 0, current);
		System.out.println(result);
		return result;
	}
}
