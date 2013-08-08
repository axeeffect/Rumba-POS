package com.airsystem.pos.rumba.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.airsystem.pos.rumba.bean.User;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Repository(value = "userDao")
public class UserDao extends AbstractDao<User, Serializable> {

	public UserDao() {
		this.beanClass = User.class;
	}
}