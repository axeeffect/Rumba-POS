package com.airsystem.pos.rumba.service;

import com.airsystem.pos.rumba.util.Constraint;
import com.airsystem.pos.rumba.util.QueryResolver;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */
public interface BaseService {

	public QueryResolver searchData(String selectClause, String fromClause, Constraint constraint);
}