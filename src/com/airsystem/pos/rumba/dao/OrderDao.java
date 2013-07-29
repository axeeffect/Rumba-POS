package com.airsystem.pos.rumba.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.airsystem.pos.rumba.bean.Order;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Repository(value = "orderDao")
public class OrderDao extends AbstractDao<Order, Serializable> {

	public OrderDao() {
		this.beanClass = Order.class;
	}
}