package com.airsystem.pos.rumba.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */
public class ApplicationDate {

	public static String DATE_FORMAT = "yyyy-MM-dd";

	public static String convertDateToString(Date date) {
		return convertDateToString(date, DATE_FORMAT);
	}

	public static String convertDateToString(Date date, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);

		return (date == null) ? "" : dateFormat.format(date);
	}

	public static Date convertStringToDate(String strDate) {
		return convertStringToDate(strDate, DATE_FORMAT);
	}

	public static Date convertStringToDate(String strDate, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);

		try {
			return dateFormat.parse(StringUtils.trim(strDate));
		} catch (ParseException e) {
			e.getMessage();

			return null;
		}
	}
}