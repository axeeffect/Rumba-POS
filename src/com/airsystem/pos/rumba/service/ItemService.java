package com.airsystem.pos.rumba.service;

import java.util.List;

import com.airsystem.pos.rumba.bean.Item;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */
public interface ItemService {

	public List<Item> findAllItem();

	public Item findItemById(String id);

	public Item saveItem(Item item);

	public void deleteItem(String id);
}