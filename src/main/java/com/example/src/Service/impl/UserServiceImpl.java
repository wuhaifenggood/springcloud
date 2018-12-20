package com.example.src.Service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.src.Po.User;
import com.example.src.Dao.UserDao;
import com.example.src.Service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	UserDao userdao;
	
	public User selectOne(long id) {
		return userdao.selectOne(id);
	}
}
