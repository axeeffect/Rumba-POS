package com.airsystem.pos.rumba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airsystem.pos.rumba.bean.Item;
import com.airsystem.pos.rumba.service.ItemService;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public String open(ModelMap modelMap) {
		modelMap.put("item", itemService.findAllItem());

		return "item";
	}

	@RequestMapping(value = "/item", method = RequestMethod.POST)
	public String save(@ModelAttribute Item item, BindingResult result, ModelMap modelMap) {
		if (result.hasErrors()) {
			return "/menu";
		}

		item = itemService.saveItem(item);

		if (item != null) {
			modelMap.put("item", itemService.findAllItem());
		}
		
		return "item";
	}
}