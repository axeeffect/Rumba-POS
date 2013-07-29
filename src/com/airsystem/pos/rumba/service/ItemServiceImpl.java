package com.airsystem.pos.rumba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airsystem.pos.rumba.bean.Item;
import com.airsystem.pos.rumba.dao.ItemDao;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;

	@Override
	public List<Item> findAllItem() {
		return itemDao.findAll();
	}

	@Override
	public Item findItemById(String id) {
		return itemDao.findById(id);
	}

	@Transactional(readOnly = false)
	public Item saveItem(Item item) {
		return itemDao.save(item);
	}

	@Transactional(readOnly = false)
	public void deleteItem(String id) {
		itemDao.deleteById(id);
	}
}