package com.airsystem.pos.rumba.util;

import java.util.List;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */
public class QueryResolver {

	private List<Object> results;

	public QueryResolver() {
	}

	public QueryResolver(List<Object> results) {
		this.results = results;
	}

	public List<Object> getResults() {
		return results;
	}

	public void setResults(List<Object> results) {
		this.results = results;
	}
}