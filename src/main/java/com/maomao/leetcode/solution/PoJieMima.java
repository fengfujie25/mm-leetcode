package com.maomao.leetcode.solution;


import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author fujie.feng
 * @Date 2020-11-03
 */
public class PoJieMima {

	public static void main(String[] args) {
//		String data = "39";
//		for (int i = 1; i <= 100000000; i++) {
//			try {
//				data = new String(DigestUtils.md2Hex(data).getBytes("gbk"), "utf-8");
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//		}
		String data = "94b1cf2c8f4aa239dd69e90f0850b2f9" + "yVvdcU4symmpMcwaSZ/YTfeBbke/Rz4McFQc9A";
		data = MD4.MD4(data);
		System.out.println(data);
//		System.out.println(data);
	}
}
