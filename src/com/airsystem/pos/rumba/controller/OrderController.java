package com.airsystem.pos.rumba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Controller
public class OrderController {

	@RequestMapping("/order")
	public String orderPage() {
		return "order";
	}
}