package com.zhongying.demo.service;

import java.util.List;

import com.zhongying.demo.model.token.AppToken;

public interface AppTokenService {

	void addAppToken(AppToken appToken);

	void deleteAppToken(AppToken appToken);

	AppToken findByToken(String access_token);

	boolean isValid(String access_token);

	List<AppToken> findAllTokens();

	void deleteAllTokens();
}
