package com.ksyche.tools.util.checker;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class IDCardChecker {

	/*
	 * 闰年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))
	 * 平年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))
	 */
	private static final Pattern LEAP_YEAR_AGE_PATTERN_15 = Pattern.compile("^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	private static final Pattern LEAP_YEAR_AGE_PATTERN_18 = Pattern.compile("^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	private static final Pattern COMMON_YEAR_AGE_PATTERN_15 = Pattern.compile("^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	private static final Pattern COMMON_YEAR_AGE_PATTERN_18 = Pattern.compile("^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	
	private static final String CHECK_CODE = "10X98765432";
	
	private static final Map<Integer, String> area = new HashMap<Integer, String>();

	static {
		initArea();
	}

	private static void initArea() {
		area.put(11, "北京");
		area.put(12, "天津");
		area.put(13, "河北");
		area.put(14, "山西");
		area.put(15, "内蒙古");
		area.put(21, "辽宁");
		area.put(22, "吉林");
		area.put(23, "黑龙江");
		area.put(31, "上海");
		area.put(32, "江苏");
		area.put(33, "浙江");
		area.put(34, "安徽");
		area.put(35, "福建");
		area.put(36, "江西");
		area.put(37, "山东");
		area.put(41, "河南");
		area.put(42, "湖北");
		area.put(43, "湖南");
		area.put(44, "广东");
		area.put(45, "广西");
		area.put(46, "海南");
		area.put(50, "重庆");
		area.put(51, "四川");
		area.put(52, "贵州");
		area.put(53, "云南");
		area.put(54, "西藏");
		area.put(61, "陕西");
		area.put(62, "甘肃");
		area.put(63, "青海");
		area.put(64, "宁夏");
		area.put(65, "新疆");
		area.put(71, "台湾");
		area.put(81, "香港");
		area.put(82, "澳门");
		area.put(91, "国外");
	}

	public static boolean checkID(String id) {
		if (!(id.length() == 15 || id.length() == 18)) {
			return false;
		}

		if (!area.containsKey(Integer.parseInt(id.substring(0, 2)))) {
			return false;
		}

		int year = Integer.parseInt(id.substring(2, 6)) + 1900;
		if (id.length() == 15) { //老身份证  测试出生日期的合法性
			if (year % 4 == 0||(year% 100 == 0 &&year % 4 == 0 )){
				return LEAP_YEAR_AGE_PATTERN_15.matcher(id).matches();
			} else{
				return COMMON_YEAR_AGE_PATTERN_15.matcher(id).matches();
			}
		} else if (id.length() == 18) { //新省份证  测试出生日期的合法性
			boolean result = false;
			if (year % 4 == 0 || (year % 100 == 0 && year % 4 == 0)) {
				result = LEAP_YEAR_AGE_PATTERN_18.matcher(id).matches();
			} else {
				result = COMMON_YEAR_AGE_PATTERN_18.matcher(id).matches();
			}
			
			if (result) { // 计算校验位
				int[] ids = new int[17];
				for (int i = 0; i < (id.length()-1); i++) {
					ids[i] = Integer.parseInt(id.substring(i, i + 1));
				}
				int sum = (ids[0] + ids[10]) * 7
						+ (ids[1] + ids[11]) * 9
						+ (ids[2] + ids[12]) * 10
						+ (ids[3] + ids[13]) * 5
						+ (ids[4] + ids[14]) * 8
						+ (ids[5] + ids[15]) * 4
						+ (ids[6] + ids[16]) * 2
						+ ids[7] * 1
						+ ids[8] * 6
						+ ids[9] * 3;
				int y = sum % 11;
				String code = CHECK_CODE.substring(y, y + 1);// 判断校验位
				return code.equalsIgnoreCase(String.valueOf(id.substring(17, 18)));
			}
		}
		
		return false;
	}

}
