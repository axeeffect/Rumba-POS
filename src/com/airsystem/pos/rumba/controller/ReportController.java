package com.airsystem.pos.rumba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airsystem.pos.rumba.service.BaseService;
import com.airsystem.pos.rumba.service.ItemService;
import com.airsystem.pos.rumba.util.Constraint;
import com.airsystem.pos.rumba.util.QueryResolver;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Controller
public class ReportController {

	@Autowired
	private BaseService baseService;

	@Autowired
	private ItemService itemService;

	private QueryResolver queryResolver;

	@RequestMapping(value = "/report/sales", method = RequestMethod.GET)
	public String reportSalesPage(ModelMap modelMap) {
		if (queryResolver != null && !queryResolver.getResults().isEmpty()) {
			modelMap.put("order", queryResolver.getResults());
		}

		return "report/sales";
	}

	@RequestMapping(value = "/report/stock", method = RequestMethod.GET)
	public String reportStokPage(ModelMap modelMap) {
		modelMap.put("stock", itemService.findAllItem());

		return "report/stock";
	}

	@RequestMapping(value = "/report/sales/print", method = RequestMethod.GET)
	public String reportSalesPrintPagePost(String startdate, String enddate) {
		StringBuilder sbConstraint = new StringBuilder();
		sbConstraint.append("order.tanggal between '");
		sbConstraint.append(startdate);
		sbConstraint.append("' and '");
		sbConstraint.append(enddate);
		sbConstraint.append("'");

		Constraint constraint = new Constraint();
		constraint.setWhereClause(sbConstraint.toString());

		queryResolver = baseService.searchData("order", "Order order", constraint);

		return "redirect:/report/sales";
	}
}