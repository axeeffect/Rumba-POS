package com.airsystem.pos.rumba.controller;

import org.apache.commons.lang.StringUtils;
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

	//FIXME: How to get ALL data of Item ?
	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public String open(@ModelAttribute Item item, ModelMap modelMap) {
		if (StringUtils.isNotBlank(item.getKode())) {
			item = itemService.findItemById(item.getKode());

			if (item != null) {
				modelMap.put("item", item);
			}
		}

		return "item";
	}

	@RequestMapping(value = "/item/add-item", method = RequestMethod.POST)
	public String save(@ModelAttribute Item item, BindingResult result) {
		if (result.hasErrors()) {
			return "item";
		}

		item = itemService.saveItem(item);

		return "item";
	}
}