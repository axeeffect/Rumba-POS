package com.airsystem.pos.rumba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airsystem.pos.rumba.bean.User;
import com.airsystem.pos.rumba.dao.UserDao;
import com.airsystem.pos.rumba.service.UserService;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findAllUser() {
		return userDao.findAll();
	}
}