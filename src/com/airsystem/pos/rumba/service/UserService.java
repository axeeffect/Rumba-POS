package com.airsystem.pos.rumba.service;

import java.util.List;

import com.airsystem.pos.rumba.bean.User;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */
public interface UserService {

	public List<User> findAllUser();
}