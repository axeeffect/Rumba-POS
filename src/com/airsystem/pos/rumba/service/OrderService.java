package com.airsystem.pos.rumba.service;

import com.airsystem.pos.rumba.bean.Detail;
import com.airsystem.pos.rumba.bean.Item;
import com.airsystem.pos.rumba.bean.Order;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */
public interface OrderService {

	public Item findItemById(String id);

	public Item saveItem(Item item);

	public Order saveOrder(Order order);

	public Detail saveDetail(Detail detail);
}