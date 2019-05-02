package com.ymb.windy.datasource1.controller;

import com.ymb.windy.datasource1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ymb.windy.datasource1.entity.User;

import java.util.List;

/**
 * 多数据源事务
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user/saveUser")
	public String saveUser() {
		User user = new User();
		user.setUserName("姚美斌");
		userService.saveUser(user);
		return "success";
	}

	@RequestMapping("/user/getAllUser")
	public List<User> getAllUser(){

		return userService.queryAllUser();
	}

}
