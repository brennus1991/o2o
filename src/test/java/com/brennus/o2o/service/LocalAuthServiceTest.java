package com.brennus.o2o.service;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.brennus.o2o.BaseTest;
import com.brennus.o2o.dto.LocalAuthExecution;
import com.brennus.o2o.entity.LocalAuth;
import com.brennus.o2o.entity.PersonInfo;
import com.brennus.o2o.enums.WechatAuthStateEnum;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalAuthServiceTest extends BaseTest{
	@Autowired
	private LocalAuthService localAuthService;
	
	@Test
	@Ignore
	public void testABindLocalAuth() {
		LocalAuth localAuth = new LocalAuth();
		PersonInfo personInfo = new PersonInfo();
		String username = "testusrename";
		String password = "testpassword";
		
		personInfo.setUserId(1L);
		
		localAuth.setPersonInfo(personInfo);
		localAuth.setUserName(username);
		localAuth.setPassword(password);
		
		LocalAuthExecution lae = localAuthService.bindLocalAuth(localAuth);
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(), lae.getState());
		
		localAuth = localAuthService.getLocalAuthByUserId(personInfo.getUserId());
		
		System.out.println("昵称"+localAuth.getPersonInfo().getName());
		System.out.println("密码"+localAuth.getPassword());
	}
	
	@Test
	public void testBModifyLocalAuth() {
		long userId = 1;
		String username = "testusrename";
		String password = "testpassword";
		String newPassword = "testnewpassword";
		
		LocalAuthExecution lae = localAuthService.modifyLocalAuth(userId, username, password, newPassword);
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(), lae.getState());
		
		LocalAuth localAuth = localAuthService.getLocalAuthByUserNameAndPwd(username, newPassword);
		System.out.println("昵称"+localAuth.getPersonInfo().getName());
	}

}
