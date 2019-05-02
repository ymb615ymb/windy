package com.ymb.windy.datasource1.service.impl;

import com.ymb.windy.datasource1.entity.User;
import com.ymb.windy.datasource1.service.UserService;
import com.ymb.windy.datasource1.mapper.UserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapping userMapping;

	@Transactional
	@Override
	public void saveUser(User user) {

		userMapping.saveUser(user);
	}

	@Transactional
	@Override
	public List<User> queryAllUser() {

		return userMapping.queryAllUser();
	}
}
