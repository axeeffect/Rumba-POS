package com.airsystem.pos.rumba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airsystem.pos.rumba.bean.Detail;
import com.airsystem.pos.rumba.bean.Item;
import com.airsystem.pos.rumba.bean.Order;
import com.airsystem.pos.rumba.dao.DetailDao;
import com.airsystem.pos.rumba.dao.ItemDao;
import com.airsystem.pos.rumba.dao.OrderDao;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ItemDao itemDao;

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private DetailDao detailDao;

	@Override
	public Item findItemById(String id) {
		return itemDao.findById(id);
	}

	@Transactional(readOnly = false)
	public Item saveItem(Item item) {
		return itemDao.save(item);
	}

	@Transactional(readOnly = false)
	public Order saveOrder(Order order) {
		return orderDao.save(order);
	}

	@Transactional(readOnly = false)
	public Detail saveDetail(Detail detail) {
		return detailDao.save(detail);
	}
}