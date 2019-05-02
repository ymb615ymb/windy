package com.ymb.windy.datasource1.mapper;

import com.ymb.windy.datasource1.entity.User;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserMapping {

	public void saveUser(User user);

    public List<User> queryAllUser();
}
