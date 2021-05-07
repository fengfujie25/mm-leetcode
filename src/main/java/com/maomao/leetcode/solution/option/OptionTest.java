package com.maomao.leetcode.solution.option;

import lombok.Data;

import java.util.Optional;

/**
 * @author fujie.feng
 * @Date 2021-05-07
 */
public class OptionTest {

	public static void main(String[] args) {

		User user = null;

//		user = Optional.ofNullable(user).orElse(createUser());
//
//		System.out.println(user);

		user = Optional.ofNullable(user).orElseGet(() -> createUser());

		System.out.println(user);
	}

	public static User createUser() {
		User user = new User();
		user.setAge(10);
		user.setName("maomao");
		return user;
	}

	@Data
	public static class User {
		private String name;
		private int age;
	}

}
