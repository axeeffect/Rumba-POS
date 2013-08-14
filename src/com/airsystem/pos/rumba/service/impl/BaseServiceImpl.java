package com.airsystem.pos.rumba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airsystem.pos.rumba.dao.GenericDao;
import com.airsystem.pos.rumba.service.BaseService;
import com.airsystem.pos.rumba.util.Constraint;
import com.airsystem.pos.rumba.util.QueryResolver;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Service("baseService")
@Transactional
public class BaseServiceImpl implements BaseService {

	@Autowired
	private GenericDao genericDao;

	@Override
	public QueryResolver searchData(String selectClause, String fromClause, Constraint constraint) {
		return genericDao.searchHQL(selectClause, fromClause, constraint);
	}
}