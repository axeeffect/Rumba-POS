package com.airsystem.pos.rumba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Controller
public class ItemController {

	// @Autowired
	// private ItemService itemService;

	@RequestMapping("/item")
	public ModelAndView itemPage() {
		// Map<String, Object> model = new HashMap<String, Object>();
		// model.put("item", itemService.findItemById());

		return new ModelAndView("item");
	}
}