package com.pytap.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ecin520
 * @date 2020/5/15 23:23
 */
public class DateUtil {
	public static String getDateFormat() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(new Date());
	}
}
