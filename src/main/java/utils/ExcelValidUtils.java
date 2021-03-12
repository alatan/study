package utils;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;


/**
 * Excel输入校验工具类
 */
public class ExcelValidUtils {
	
	private static final String ERROR_MSG_NULL = "数据校验错误：%s应为空（第%s行）";
	private static final String ERROR_MSG_NOT_NULL = "数据校验错误：%s不能为空（第%s行）";
	private static final String ERROR_MSG_NOT_DATE = "数据校验错误：%s日期格式错误（第%s行）";
	private static final String ERROR_MSG_NOT_TIME = "数据校验错误：%s时间格式错误（第%s行）";
	private static final String ERROR_MSG_NOT_DIGITAL = "数据校验错误：%s必须为数字，保留2位小数（第%s行）";
	private static final String ERROR_MSG_NOT_ILLEGAL_CHARACTER = "数据校验错误：%s存在非法字符（第%s行）";
	private static final String ERROR_MSG_NOT_MATCH = "数据校验错误：%s取值范围不正确，必须为列表[%s]的某一项或组合项（第%s行）";
	
	private static final Pattern PATTERN_DIGITAL_ZERO = Pattern.compile("^(\\d{1,2}(\\.\\d{1,2})?|100)$");
//	private static final Pattern PATTERN_DIGITAL_TWO = Pattern.compile("(^[1-9](\\d+)?(\\.\\d{1,2})?$)|(^\\d\\.\\d{0,2}$)");
	private static final Pattern PATTERN_DIGITAL_TWO = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
	private static final Pattern PATTERN_DIGITAL_FOUR = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,4})?$");

	private static final char[] ILLEGAL_CHARACTERS = {'\f', '\n', '\r', '\t', '\'', '"','&','<','>'};
	
	/**
	 * 校验空行
	 * @param array
	 * @return
	 */
	public static boolean isArrayElementNull(String[] array) {
		boolean isNull = true;
		for (String str : array) {
			if (StringUtils.isNotBlank(str)) {
				isNull = false;
				break;
			}
		}
		return isNull;
	}
	
	/**
	 * 校验必须为空
	 * @param str
	 * @param desc
	 * @param rowNbr
	 * @param errorMsgs
	 * @
	 */
	public static void validateNull(String str, String desc, int rowNbr, List<String> errorMsgs)  {
		if (!StringUtils.isBlank(str)) {
			errorMsgs.add(String.format(ERROR_MSG_NULL, desc, rowNbr));
		}
	}
	
	/**
	 * 校验不能为空
	 * @param str
	 * @param desc
	 * @param rowNbr
	 * @param errorMsgs
	 * @
	 */
	public static void validateNotNull(String str, String desc, int rowNbr, List<String> errorMsgs)  {
		if (StringUtils.isBlank(str)) {
			errorMsgs.add(String.format(ERROR_MSG_NOT_NULL, desc, rowNbr));
		}
	}
	
	/**
	 * 校验日期格式
	 * @param str
	 * @param desc
	 * @param rowNbr
	 * @param errorMsgs
	 */
	public static void validateDate(String str, String desc, int rowNbr, List<String> errorMsgs)  {
		Date date = DateUtil.parseDate(str);
		if(date == null){
			errorMsgs.add(String.format(ERROR_MSG_NOT_DATE, desc, rowNbr));
		}
	}
	
	/**
	 * 校验时间格式
	 * @param str
	 * @param desc
	 * @param rowNbr
	 * @param errorMsgs
	 */
	public static void validateTime(String str, String desc, int rowNbr, List<String> errorMsgs)  {
		Date time = DateUtil.parseTime(str);
		if(time  == null){
			errorMsgs.add(String.format(ERROR_MSG_NOT_TIME, desc, rowNbr));
		}
	}
	
	/**
	 * 校验必须匹配
	 * @param str
	 * @param desc
	 * @param rowNbr
	 * @param errorMsgs
	 * @param set
	 * @param isMultiple
	 */
	public static void validateNotMatch(String str, String desc, int rowNbr, List<String> errorMsgs, Set<String> set, boolean isMultiple) {
		// 数据必须是列表中的元素
		boolean isMatch = false;
		boolean defaultMatchRule = true;
		if(isMultiple){
			if(StringUtils.isNotBlank(str)){
				String[] inputArray = str.split(",");
				if(inputArray.length > 0){
					defaultMatchRule = false;
					for(String current : inputArray){
						for (String element : set) {
							if (equalTrimWhiteSpace(current, element)) {
								isMatch = true;
								break;
							}else{
								isMatch = false;
							}
						}
						if (!isMatch) {
							break;
						}
					}
				}
			}
		}
		
		if(defaultMatchRule){
			for (String element : set) {
				if (StringUtils.isNotBlank(str) && equalTrimWhiteSpace(str, element)) {
					isMatch = true;
					break;
				}
			}
		}

		if (!isMatch) {
			String strDataSet = StringUtils.join(set, ",");
			errorMsgs.add(String.format(ERROR_MSG_NOT_MATCH, desc, strDataSet, rowNbr));
		}
	}

	
	/**
	 * 校验数字
	 * @param str
	 * @param desc
	 * @param rowNbr
	 * @param errorMsgs
	 * @param digit
	 */
	public static void validateIsDigital(String str, String desc, int rowNbr, List<String> errorMsgs,int digit) {
		boolean isMatch = false;
		if(digit == 0){
			 isMatch = PATTERN_DIGITAL_ZERO.matcher(str).matches();
		}else if(digit == 2){
			 isMatch = PATTERN_DIGITAL_TWO.matcher(str).matches();
		}else if(digit == 4){
			 isMatch = PATTERN_DIGITAL_FOUR.matcher(str).matches();
		}
		if (!isMatch) {
			errorMsgs.add(String.format(ERROR_MSG_NOT_DIGITAL, desc, rowNbr));
		}
	}
	
	/**
	 * 校验特殊字符
	 * @param str
	 * @param desc
	 * @param rowNbr
	 * @param errorMsgs
	 */
	public static void validateIllegalCharacter(String str, String desc, int rowNbr, List<String> errorMsgs) {
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if (ArrayUtils.contains(ILLEGAL_CHARACTERS, c)) {
				errorMsgs.add(String.format(ERROR_MSG_NOT_ILLEGAL_CHARACTER, desc, rowNbr));
				break;
			}
		}
    }
	
	/**
	 * 比较字符串
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean equalTrimWhiteSpace(String a, String b) {
		return a.trim().equals(b.trim());
	}

	public static void main(String[] args) {
		String str = "a&sd";

		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if (ArrayUtils.contains(ILLEGAL_CHARACTERS, c)) {
				System.err.println("ERROR");
				break;
			}
		}
	}

}
