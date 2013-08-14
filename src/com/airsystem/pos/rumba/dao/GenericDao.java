package com.airsystem.pos.rumba.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.airsystem.pos.rumba.util.Constraint;
import com.airsystem.pos.rumba.util.QueryResolver;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Repository("genericDao")
public class GenericDao {

	protected final Logger log = Logger.getLogger(getClass().getSimpleName());

	@Autowired
	protected SessionFactory sessionFactory;

	public QueryResolver searchHQL(String selectClause, String fromClause, Constraint constraint, boolean isCacheQuery) {
		StringBuffer hql = new StringBuffer();

		hql.append("select ").append(selectClause);
		hql.append(" from ").append(fromClause);

		Map<String, Object> parameters = null;

		if (constraint != null) {
			if (StringUtils.isNotBlank(constraint.getWhereClause())) {
				hql.append(" where ").append(constraint.getWhereClause());
			}

			parameters = constraint.getParameters();
		}

		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());

		if (parameters != null) {
			for (String key : parameters.keySet()) {
				query.setParameter(key, parameters.get(key));
			}
		}

		List<?> queries = query.setCacheable(isCacheQuery).list();

		List<Object> results = new ArrayList<Object>();
		for (Object result : queries) {
			Object object = (Object) result;
			results.add(object);
		}

		return new QueryResolver(results);
	}

	public QueryResolver searchHQL(String selectClause, String fromClause, Constraint constraint) {
		return searchHQL(selectClause, fromClause, constraint, false);
	}
}