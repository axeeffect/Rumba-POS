package com.airsystem.pos.rumba.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Entity
@Table(name = "user", catalog = "rumba")
public class User implements Serializable {

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}