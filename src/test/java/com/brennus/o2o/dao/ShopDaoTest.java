package com.brennus.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.brennus.o2o.BaseTest;
import com.brennus.o2o.dao.ShopDao;
import com.brennus.o2o.entity.Area;
import com.brennus.o2o.entity.PersonInfo;
import com.brennus.o2o.entity.Shop;
import com.brennus.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{
	@Autowired
	private ShopDao shopDao;
	
	
	@Test
	public void testQueryShopListAndCount() {
		Shop shopCondition = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(1L);
		shopCondition.setOwner(owner);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 1, 5);
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("店铺列表大小" + shopList.size());
		System.out.println("店铺总数" + count);
	}
	
	
	@Test
	@Ignore
	public void testQueryByShopId() {
		long shopId = 1;
		Shop shop = shopDao.queryByShopId(shopId);
		System.out.println("areaID" + shop.getArea().getAreaId());
		System.out.println("areaName" + shop.getArea().getAreaName());
	}

	@Test
	@Ignore
	public void testInsertShop() throws Exception {
		Shop shop = new Shop();
		
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		
		owner.setUserId(1L);
		area.setAreaId(2L);
		shopCategory.setShopCategoryId(1L);
		
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		
		shop.setShopName("mytest1");
		shop.setShopDesc("mytest1");
		shop.setShopAddr("testaddr1");
		shop.setPhone("13810524526");
		shop.setShopImg("test1");
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(0);
		shop.setAdvice("审核中");
		
		
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}
	
	@Test
	@Ignore
	public void testUpdateShop() throws Exception {
		Shop shop = new Shop();
		
		shop.setShopId(1L);
		shop.setShopName("ghghghgh");
		shop.setShopDesc("myhghghghgh1");
		shop.setShopAddr("ter1");
		shop.setLastEditTime(new Date());

		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
	}

}
