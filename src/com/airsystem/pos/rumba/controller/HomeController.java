package com.airsystem.pos.rumba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Controller
public class HomeController {

	@RequestMapping("/")
	public String homePage() {
		return "home";
	}

	@RequestMapping("/menu")
	public String menuPage() {
		return "menu";
	}
}