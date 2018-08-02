package com.zhongying.demo.model.token;

import java.io.Serializable;

public class AppToken implements Serializable {

	private static final long serialVersionUID = 1L;

	private String transactionId;

	private String userId;

	private String imei;// 设备号

	private String useragent;// 代理

	private String location;// 位置

	private String access_token;

	private String access_token_expiry;

	private String create_time;

	private String lastaccesstime;// 最后请求时间

	private long request_count;// 请求次数

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getUseragent() {
		return useragent;
	}

	public void setUseragent(String useragent) {
		this.useragent = useragent;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getAccess_token_expiry() {
		return access_token_expiry;
	}

	public void setAccess_token_expiry(String access_token_expiry) {
		this.access_token_expiry = access_token_expiry;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getLastaccesstime() {
		return lastaccesstime;
	}

	public void setLastaccesstime(String lastaccesstime) {
		this.lastaccesstime = lastaccesstime;
	}

	public long getRequest_count() {
		return request_count;
	}

	public void setRequest_count(long request_count) {
		this.request_count = request_count;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}
