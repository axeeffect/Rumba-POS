package com.airsystem.pos.rumba.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.airsystem.pos.rumba.bean.Detail;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Repository(value = "detailDao")
public class DetailDao extends AbstractDao<Detail, Serializable> {

	public DetailDao() {
		this.beanClass = Detail.class;
	}
}