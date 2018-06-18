package com.brennus.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.brennus.o2o.BaseTest;
import com.brennus.o2o.dto.WechatAuthExecution;
import com.brennus.o2o.entity.PersonInfo;
import com.brennus.o2o.entity.WechatAuth;
import com.brennus.o2o.enums.WechatAuthStateEnum;

public class WechatAuthServiceTest extends BaseTest{
	@Autowired
	private WechatAuthService wechatAuthService;
	
	@Test
	public void testRegister() {
		WechatAuth wechatAuth = new WechatAuth();
		PersonInfo personInfo = new PersonInfo();
		String openId = "dasasdasdasdsdassf";
		
		personInfo.setCreateTime(new Date());
		personInfo.setName("ceshiyicai");
		personInfo.setUserType(1);
		
		wechatAuth.setPersonInfo(personInfo);
		wechatAuth.setOpenId(openId);
		wechatAuth.setCreateTime(new Date());
		
		WechatAuthExecution wae = wechatAuthService.register(wechatAuth, null);
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(), wae.getState());
		
		wechatAuth = wechatAuthService.getWechatAuthByOpenId(openId);
		System.out.println(wechatAuth.getPersonInfo().getName());
	}

}
