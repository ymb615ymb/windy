package com.ymb.windy.datasource1.service;

import com.ymb.windy.datasource1.entity.User;
import java.util.List;

public interface UserService {

	public void saveUser(User user);

    public List<User> queryAllUser();
}
