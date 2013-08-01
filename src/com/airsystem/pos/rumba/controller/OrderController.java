package com.airsystem.pos.rumba.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.airsystem.pos.rumba.util.Constant;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Controller
public class OrderController {

	@RequestMapping(value = "/order")
	public String orderPage(ModelMap modelMap) {
		modelMap.put("mode", Constant.MODE_ADD_CART);

		return "order";
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String orderCartPage(@RequestParam int mode, @RequestParam String nama,
								@RequestParam String harga, @RequestParam String jumlah,
								@RequestParam String total, ModelMap modelMap) {
		if (mode == Constant.MODE_ADD_CART) {
			List<Object> carts = new ArrayList<Object>();
			Map<Object, Object> cartMap = new HashMap<Object, Object>();

			int hargaItem  = Integer.parseInt(harga);
			int jumlahItem = Integer.parseInt(jumlah);
			total = String.valueOf(jumlahItem * hargaItem);

			cartMap.put("nama", nama);
			cartMap.put("harga", harga);
			cartMap.put("jumlah", jumlah);
			cartMap.put("total", total);
			carts.add(cartMap);

			modelMap.put("mode", Constant.MODE_ADD_CART);
			modelMap.put("cart", carts);
		}

		return "order";
	}
}