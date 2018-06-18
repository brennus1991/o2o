package com.brennus.o2o.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.brennus.o2o.dto.WechatAuthExecution;
import com.brennus.o2o.entity.WechatAuth;
import com.brennus.o2o.exceptions.WechatAuthOperationException;

public interface WechatAuthService {

	/**
	 * 
	 * @param openId
	 * @return
	 */
	WechatAuth getWechatAuthByOpenId(String openId);

	/**
	 * 
	 * @param wechatAuth
	 * @param profileImg
	 * @return
	 * @throws RuntimeException
	 */
	WechatAuthExecution register(WechatAuth wechatAuth,
			CommonsMultipartFile profileImg) throws WechatAuthOperationException;

}
