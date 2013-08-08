package com.airsystem.pos.rumba.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.airsystem.pos.rumba.bean.Item;
import com.airsystem.pos.rumba.service.ItemService;
import com.airsystem.pos.rumba.util.Constant;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public String itemPage(ModelMap modelMap) {
		modelMap.put("mode", Constant.MODE_CREATE);
		modelMap.put("item", itemService.findAllItem());

		return "item";
	}

	@RequestMapping(value = "/item", method = RequestMethod.POST)
	public String itemSubmitPage(@RequestParam int mode, @ModelAttribute Item item, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:item";
		}

		if (mode == Constant.MODE_CREATE) {
			item = itemService.saveItem(item);
		} else if (mode == Constant.MODE_UPDATE) {
			item = itemService.saveItem(item);
		}

		return "redirect:item";
	}

	@RequestMapping(value = "/item/cancel", method = RequestMethod.GET)
	public String itemCancelPage() {
		return "redirect:/item";
	}

	@RequestMapping(value = "/item/edit", method = RequestMethod.GET)
	public String itemEditPage(@ModelAttribute Item item, ModelMap modelMap) {
		if (StringUtils.isNotBlank(item.getKode())) {
			item = itemService.findItemById(item.getKode());

			if (item != null) {
				modelMap.put("mode", Constant.MODE_UPDATE);
				modelMap.put("item", item);
			}
		}

		return "item";
	}

	@RequestMapping(value = "/item/delete", method = RequestMethod.GET)
	public String itemDeletePage(@ModelAttribute Item item) {
		if (StringUtils.isNotBlank(item.getKode())) {
			itemService.deleteItem(item.getKode());
		}

		return "redirect:/item";
	}
}