package com.tip.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
 public static String formatDate(Date date) {
	 
     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
     String strDate = formatter.format(date);
     return strDate;
 }
 public static String getCurrentDateAsStr() {
	 
	 Date date = new Date();
	 return formatDate(date);
 }
}
