package com.airsystem.pos.rumba.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airsystem.pos.rumba.bean.Detail;
import com.airsystem.pos.rumba.bean.Item;
import com.airsystem.pos.rumba.bean.Order;
import com.airsystem.pos.rumba.controller.model.OrderDispatcher;
import com.airsystem.pos.rumba.service.OrderService;
import com.airsystem.pos.rumba.util.ApplicationDate;
import com.airsystem.pos.rumba.util.Constant;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Controller
public class OrderController {

	private static final String URI_ORDER 		   = "order";

	private static final String URI_REDIRECT_ORDER = new StringBuilder("redirect:/").append(URI_ORDER).toString();

	private OrderDispatcher orderDispatcher;

	private List<Object> carts;

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String orderPage(ModelMap modelMap) {
		if (carts != null && !carts.isEmpty()) {
			modelMap.put("tanggal", orderDispatcher.getTanggal());
			modelMap.put("cart", carts);
		}

		return URI_ORDER;
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String orderAddPage(OrderDispatcher orderTemp, ModelMap modelMap) {
		if (carts == null) {
			carts = new ArrayList<Object>();
		}

		boolean isEqual = false;
		for (Object cart : carts) {
			if (cart.equals(orderTemp)) {
				isEqual = true;

				break;
			}
		}

		if (!isEqual) {
			carts.add(orderTemp);
		}

		this.orderDispatcher = orderTemp;
		modelMap.put("mode", Constant.MODE_ORDER);
		modelMap.put("tanggal", orderTemp.getTanggal());
		modelMap.put("cart", carts);

		return URI_ORDER;
	}

	@RequestMapping(value = "/order/delete", method = RequestMethod.GET)
	public String orderDeletePage(String id) {
		for (Object cart : carts) {
			orderDispatcher = (OrderDispatcher) cart;

			if (orderDispatcher.getKode().equals(id)) {
				carts.remove(cart);

				break;
			}
		}

		return URI_REDIRECT_ORDER;
	}

	@RequestMapping(value = "/order/submit", method = RequestMethod.POST)
	public String orderSubmitPage(@ModelAttribute Item item, @ModelAttribute Order order) {
		if (carts == null || carts.isEmpty()) {
			return URI_REDIRECT_ORDER;
		}

		Date tanggalOrder = ApplicationDate.convertStringToDate(orderDispatcher.getTanggal());
		order.setTanggal(tanggalOrder);
		orderService.saveOrder(order);

		for (Object object : carts) {
			orderDispatcher = (OrderDispatcher) object;

			item = orderService.findItemById(orderDispatcher.getKode());
			if (item != null) {
				int updateStock = item.getJumlah() - orderDispatcher.getPesanItem();
				item.setJumlah(updateStock);
				orderService.saveItem(item);

				Detail detail = new Detail();
				detail.setItem(item);
				detail.setOrder(order);
				detail.setJumlah(orderDispatcher.getPesanItem());
				detail.setTotal(orderDispatcher.getTotal());
				orderService.saveDetail(detail);
			}
		}

		if (carts != null) {
			carts.clear();
		}

		return URI_REDIRECT_ORDER;
	}
}