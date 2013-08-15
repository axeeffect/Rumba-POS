package com.airsystem.pos.rumba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airsystem.pos.rumba.service.BaseService;
import com.airsystem.pos.rumba.util.Constraint;
import com.airsystem.pos.rumba.util.QueryResolver;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Controller
public class SearchController {

	@Autowired
	private BaseService baseService;

	private QueryResolver queryResolver;

	@RequestMapping(value = "/item/search", method = RequestMethod.GET)
	public String searchWindow(ModelMap modelMap) {
		Constraint constraint = new Constraint();
		constraint.setWhereClause("item.jumlah != 0");

		queryResolver = baseService.searchData("item", "Item item", constraint);

		modelMap.put("search", queryResolver.getResults());

		return "search";
	}
}