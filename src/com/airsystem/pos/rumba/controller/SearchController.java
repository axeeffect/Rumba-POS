package com.airsystem.pos.rumba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airsystem.pos.rumba.service.ItemService;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Controller
public class SearchController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchWindow(ModelMap modelMap) {
		modelMap.put("item", itemService.findAllItem());

		return "search";
	}
}