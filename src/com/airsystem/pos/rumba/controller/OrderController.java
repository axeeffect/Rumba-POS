package com.airsystem.pos.rumba.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.airsystem.pos.rumba.bean.Detail;
import com.airsystem.pos.rumba.bean.Item;
import com.airsystem.pos.rumba.bean.Order;
import com.airsystem.pos.rumba.service.OrderService;
import com.airsystem.pos.rumba.util.Constant;
import com.airsystem.pos.rumba.util.DateUtil;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Controller
public class OrderController {

	private String tanggal;

	private String kode;

	private String jumlah;

	private int pesanItem;

	private long total;

	private List<Object> carts;

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String orderPage(ModelMap modelMap) {
		if (carts != null && carts.size() != 0) {
			modelMap.put("tanggal", tanggal);
			modelMap.put("cart", carts);
		}

		return "order";
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String orderAddPage(@RequestParam String tanggal, @RequestParam String kode,
							   @RequestParam String jumlah,	 @RequestParam String nama,
							   @RequestParam String harga,	 @RequestParam String pesan, ModelMap modelMap) {
		this.tanggal = tanggal;
		this.kode 	 = kode;
		this.jumlah  = jumlah;

		int hargaItem = Integer.parseInt(harga);
		pesanItem	  = Integer.parseInt(pesan);
		total = pesanItem * hargaItem;

		Map<String, Object> cartMap = new HashMap<String, Object>();
		cartMap.put("nama", nama);
		cartMap.put("harga", harga);
		cartMap.put("pesan", pesan);
		cartMap.put("total", total);

		if (carts != null) {
			carts.add(cartMap);
		} else {
			carts = new ArrayList<Object>();
			carts.add(cartMap);
		}

		modelMap.put("mode", Constant.MODE_ORDER);
		modelMap.put("tanggal", tanggal);
		modelMap.put("jumlah", jumlah);
		modelMap.put("cart", carts);

		return "order";
	}

	@RequestMapping(value = "/order/delete", method = RequestMethod.GET)
	public String orderDeletePage() {
		carts.remove(0);

		return "redirect:/order";
	}

	@RequestMapping(value = "/order/submit", method = RequestMethod.POST)
	public String orderSubmitPage(@ModelAttribute Item item, @ModelAttribute Order order,
								  @ModelAttribute Detail detail, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/order";
		}

		item = orderService.findItemById(kode);
		if (item != null) {
			int stok 	   = Integer.parseInt(jumlah);
			int updateStok = stok - pesanItem;

			Date tanggalOrder = DateUtil.convertStringToDate(tanggal);

			item.setJumlah(updateStok);
			order.setTanggal(tanggalOrder);
			detail.setItem(item);
			detail.setOrder(order);
			detail.setJumlah(pesanItem);
			detail.setTotal(total);

			orderService.saveItem(item);
			orderService.saveOrder(order);
			orderService.saveDetail(detail);
		}

		if (carts != null) {
			carts.clear();
		}

		return "redirect:/order";
	}
}