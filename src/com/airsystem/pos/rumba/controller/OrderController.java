package com.airsystem.pos.rumba.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airsystem.pos.rumba.bean.Detail;
import com.airsystem.pos.rumba.bean.Item;
import com.airsystem.pos.rumba.bean.Order;
import com.airsystem.pos.rumba.controller.model.ItemDispatcher;
import com.airsystem.pos.rumba.service.OrderService;
import com.airsystem.pos.rumba.util.Constant;
import com.airsystem.pos.rumba.util.DateUtil;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Controller
public class OrderController {
	
	private static final String URI_ORDER = "order";
	
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

		return URI_ORDER;
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String orderAddPage(String tanggal,
							   ItemDispatcher item,
							   ModelMap modelMap) {
		
		if(carts == null) {
			carts = new ArrayList<Object>();
		}
		
		boolean isEqual = false;
		for(Object obj : carts) {
			if(obj.equals(item) ) {
				isEqual = true;
				break;
			}
		}
		
		if(!isEqual) {
			carts.add(item);
		}
		
		modelMap.put("mode", Constant.MODE_ORDER);
		modelMap.put("tanggal", tanggal);
		modelMap.put("jumlah", jumlah);
		modelMap.put("cart", carts);
		
		return URI_ORDER;
	}
	
	@RequestMapping(value = "/order/delete", method = RequestMethod.GET)
	public String orderDeletePage(String orderCode) {
		
		for(Object item : carts) {
			ItemDispatcher temp = (ItemDispatcher) item;
			if(temp.getKode().equals(orderCode) ) {
				carts.remove(item);
				break;
			}
		}
		
		return "redirect:/order";
	}

	@RequestMapping(value = "/order/submit", method = RequestMethod.POST)
	public String orderSubmitPage(String tanggal, ModelMap modelMap) {
		
		if(carts == null || carts.isEmpty() ) {
			return "redirect:/order";
		}
		
		Order order = new Order();
		Date tanggalOrder = DateUtil.convertStringToDate(tanggal);
		order.setTanggal(tanggalOrder);
		orderService.saveOrder(order);
		
		for(Object object : carts) {
			ItemDispatcher newItem = (ItemDispatcher) object;
			Item item = orderService.findItemById(newItem.getKode() );
			
			if (item != null) {
				int updateStok = item.getJumlah() - newItem.getPesanInt();
				item.setJumlah(updateStok);
				orderService.saveItem(item);
				
				Detail detail = new Detail();
				detail.setItem(item);
				detail.setOrder(order);
				detail.setJumlah(newItem.getPesanInt() );
				detail.setTotal(newItem.getTotal() );
				orderService.saveDetail(detail);
			}
		}
		
		if (carts != null) {
			carts.clear();
		}
		
		return "redirect:/order";
	}
}