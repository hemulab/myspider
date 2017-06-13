package com.ksyche.tools.util.checker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChecker {
	
	/**
	 * email正则
	 */
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^([a-z0-9A-Z_]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	
	/**
	 * 手机正则
	 */
	private static final Pattern MOBILE_PATTERN = Pattern.compile("^(13|15|18|17|14)\\d{9}$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	
	/**
	 * 电话正则
	 */
	private static final Pattern TEL_PATTERN = Pattern.compile("(^[0-9]{3,4}-[0-9]{7,8}-[0-9]{3,4}$)|(^[0-9]{3,4}-[0-9]{7,8}$)|(^[0-9]{7,8}-[0-9]{3,4}$)|(^[0-9]{7,15}$)", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	
	/**
	 * 域名正则
	 */
//	private static final Pattern DOMAIN_PATTERN = Pattern.compile("http://([^/]+)/*", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	private static final Pattern DOMAIN_PATTERN = Pattern.compile("^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	
	private static final Pattern DRG_DOMAIN_PATTERN = Pattern.compile("(http[s]?://)?[a-zA-Z0-9_\\.]+\\.darengong\\.com([\\w-./?%&=\u4E00-\u9FFF]*)?$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	
	/**
	 * 邮政编码正则
	 */
	private static final Pattern ZIPCODE_PATTERN = Pattern.compile("^[0-9]{6}$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	
	/**
	 * 路径规则
	 */
	private static final Pattern PATH_PATTERN = Pattern.compile("(\\d|[a-zA-Z]|_|/|\\.)+", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	
	private static final Pattern USERNAME_PATTERN = Pattern.compile("(_|[a-zA-Z]|\\d|[\u4E00-\u9FFF]){2,20}", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	
	private static final Pattern DRG_PATTERN = Pattern.compile(".*(达人工|darengong).*", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	
	/**
	 * md5密码
	 */
	private static final Pattern PWD_PATTERN = Pattern.compile("^[a-z0-9]{32}", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	
	
	/**
	 * qq号码规则
	 */
	private static final Pattern QQ_PATTERN = Pattern.compile("^[0-9]{4,12}$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	
	/**
	 * 字母和数字
	 */
	private static final Pattern NUM_LETTER_PATTERN = Pattern.compile("^[a-z0-9]+$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	
	
	/**
	 * 检测数字
	 */
	private static final Pattern NUM_PATTERN = Pattern.compile("^[0-9]+$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	
	/**
	 * 检测字母
	 */
	private static final Pattern LETTER_PATTERN = Pattern.compile("^[a-z]+$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	
	/**
	 * jsonp callback值
	 */
	private static final Pattern JSONP_CALLBACK_PATTERN = Pattern.compile("^jsonp[0-9]+$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);

	private static final Pattern DATE_YEAR_MONTH_PATTERN = Pattern.compile("^[0-9]{4}年[0-9]{2}月$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	
	/**
	 * 小写字母和数字
	 */
	private static final Pattern NUM_LETTER_PATTERN2 = Pattern.compile("^[a-z0-9]+$", Pattern.UNICODE_CASE|Pattern.DOTALL);

	
	
	/**
	 * 正则验证方法
	 * 
	 * @param regexstr
	 * @param str
	 * @return
	 */
	public static boolean check(String regexStr, String str) {
		if(regexStr == null || str == null) {
			return false;
		}
		
		Pattern regex = Pattern.compile(regexStr, Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
		Matcher matcher = regex.matcher(str);
		return matcher.matches();
	}

	/**
	 * 验证邮箱
	 * 
	 * @param mail
	 * @return
	 */
	public static boolean checkEmail(String email) {
		if(email == null) {
			return false;
		}
		
		return EMAIL_PATTERN.matcher(email).matches();
	}

	/**
	 * 验证手机
	 * 
	 * @param mobile
	 * @return
	 */
	public static boolean checkMobile(String mobile) {
		if(mobile == null) {
			return false;
		}
		
		return MOBILE_PATTERN.matcher(mobile).matches();
	}

	/**
	 * 验证电话
	 * 
	 * @param Tel
	 * @return
	 */
	public static boolean checkTel(String tel) {
		if(tel == null) {
			return false;
		}
		
		return TEL_PATTERN.matcher(tel).matches();
	}
	
	/**
	 * 验证域名
	 * @param domain
	 * @return
	 */
	public static boolean checkDomain(String domain) {
		if(domain == null) {
			return false;
		}
		
		return DOMAIN_PATTERN.matcher(domain).matches();
	}
	
	/**
	 * 检测是否是达人工相关的域名
	 * @param domain
	 * @return
	 */
	public static boolean checkDRGDomain(String domain) {
		if(domain == null || domain.trim().equals("")) {
			return false;
		}
		
		return DRG_DOMAIN_PATTERN.matcher(domain).matches();
	}

	/**
	 * 验证邮政编码
	 * @param zipcode
	 * @return
	 */
	public static boolean checkZipCode(String zipcode) {
		if(zipcode == null) {
			return false;
		}
		
		return ZIPCODE_PATTERN.matcher(zipcode).matches();
	}

	/**
	 * 验证用户名
	 * @param userName
	 * @return
	 */
	public static boolean checkUserName(String userName) {
		if(userName == null) {
			return false;
		}
		
		boolean rst = USERNAME_PATTERN.matcher(userName).matches();
		if(rst) {
			int count = 0;
			for(int i=0; i<userName.length(); i++){  
				if (userName.charAt(i)>=0x4E00 && userName.charAt(i)<=0x9FFF){  
					count+=2;
				} else {
					count++;
				}
			}
			
			return count>=4 && !DRG_PATTERN.matcher(userName).matches();
		}
		return rst;
	}
	
	/**
	 * 检测路径
	 * @param path 路径
	 * @return
	 */
	public static boolean checkPath(String path) {
		if(path == null) {
			return false;
		}
		
		return PATH_PATTERN.matcher(path).matches();
	}
	
	/**
	 * 检测路径
	 * @param path 路径
	 * @return
	 */
	public static boolean checkPWD(String pwd) {
		if(pwd == null) {
			return false;
		}
		
		return PWD_PATTERN.matcher(pwd).matches();
	}
	
	public static boolean checkQQ(String qq) {
		if(qq == null || qq.trim().equals("")){
			return false;
		}
		return QQ_PATTERN.matcher(qq).matches();
	}
	
	/**
	 * 检测字母和数字
	 * @param numLetter
	 * @return
	 */
	public static boolean checkNumLetter(String numLetter) {
		if(numLetter == null) {
			return false;
		}
		
		return NUM_LETTER_PATTERN.matcher(numLetter).matches();
	}
	/**
	 * 检测小写字母和数字
	 * @param numLetter
	 * @return
	 */
	public static boolean checkNumLetter2(String numLetter) {
		if(numLetter == null) {
			return false;
		}
		
		return NUM_LETTER_PATTERN2.matcher(numLetter).matches();
	}
	
	/**
	 * 检测数字
	 * @param numLetter
	 * @return
	 */
	public static boolean checkNum(String num) {
		if(num == null) {
			return false;
		}
		
		return NUM_PATTERN.matcher(num).matches();
	}
	
	/**
	 * 检测字母
	 * @param numLetter
	 * @return
	 */
	public static boolean checkLetter(String letter) {
		if(letter == null) {
			return false;
		}
		
		return LETTER_PATTERN.matcher(letter).matches();
	}
	
	/**
	 * jsonp参数检测
	 * @param param
	 * @return
	 */
	public static boolean checkJsonpParam(String param) {
		if(param == null) {
			return false;
		}
		
		return JSONP_CALLBACK_PATTERN.matcher(param).matches();
	}
	/**
	 * 验证日期{yyyy年MM月}格式
	 * @param param
	 * @return
	 */
	public static boolean checkDateYearMonth(String param) {
		if(param == null) return false;
		return DATE_YEAR_MONTH_PATTERN.matcher(param).matches();
	}
}
