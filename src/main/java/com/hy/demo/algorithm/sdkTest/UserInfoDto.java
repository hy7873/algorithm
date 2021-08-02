package com.hy.demo.algorithm.sdkTest;

import java.io.Serializable;

/**
 * 用户实体
 *
 * @author Michael
 * @email ${email}
 * @date 2019-11-13 16:32:52
 */
public class UserInfoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	private Integer id;

	/**
	 * 用户名称
	 */
	private String userName = "";

	private String realName;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
}
