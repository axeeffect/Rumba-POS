package com.airsystem.pos.rumba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Controller
public class UserController {

	@RequestMapping("/")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/menu")
	public String menuPage() {
		return "menu";
	}

	@RequestMapping("/setting")
	public String settingPage() {
		return "setting";
	}
}