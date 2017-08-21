package com.em.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.em.mapper.UserInfoMapper;
import com.em.model.UserInfo;
import com.em.service.UserService;
@Service(value="userService")
public class UserServiceImpl implements UserService {
   @Autowired
    private UserInfoMapper userInfoMapper;
	public UserInfo login(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.selectOne(userInfo);
	}
	@Override
	public int resetPwd(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.updateByPrimaryKeySelective(userInfo);
	}

}
