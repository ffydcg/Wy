package com.em.service;



import com.em.model.UserInfo;
public interface UserService {
UserInfo login(UserInfo userInfo);
int resetPwd(UserInfo userInfo);
}
