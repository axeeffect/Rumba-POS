package com.airsystem.pos.rumba.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.airsystem.pos.rumba.bean.Item;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Repository(value = "itemDao")
public class ItemDao extends AbstractDao<Item, Serializable> {

	public ItemDao() {
		this.beanClass = Item.class;
	}
}