package com.ksyche.web.spider.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bj58.wf.util.StringUtil;

public class CommUtil {

	public static double get(String name){
		Pattern p=Pattern.compile("[0-9]+(.[0-9]{1,3})?"); 
		Matcher m=p.matcher(name); 
		m.find();
		String group = m.group();
		if(StringUtil.isBlank(group)){
			return 0;
		}
		return Double.parseDouble(group);
	}
	
}
