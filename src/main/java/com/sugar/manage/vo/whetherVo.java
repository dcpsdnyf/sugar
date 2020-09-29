package com.sugar.manage.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * 此类用来进行判断
 *
 * @author 刘隆超,
 * @date 2020/9/28,
 * @time 17:38,
 * @email 779875923@qq.com
 */
public class whetherVo {
	/*是否展示标签页*/
	public static Map<String,String> isShowLabel = new HashMap<>();

	static {
		isShowLabel.put("卢丽娜","卢丽娜");
		isShowLabel.put("张洋洋","张洋洋");
		isShowLabel.put("姜仲一","姜仲一");

	}
}
