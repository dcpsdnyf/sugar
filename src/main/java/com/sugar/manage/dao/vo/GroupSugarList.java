package com.sugar.manage.dao.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 对项目信息进行分组
 *
 * @author 刘隆超,
 * @date 2020/9/11,
 * @time 11:49,
 * @email 779875923@qq.com
 */
@Data
public class GroupSugarList implements Serializable {

	private static final long serialVersionUID = 1L;

	//产品类型
	private List<String> productType;
	//平台名称
	private List<String> platformName;
	//集团名称
	private List<String> groupName;
}
