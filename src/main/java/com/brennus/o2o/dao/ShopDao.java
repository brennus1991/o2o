package com.brennus.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.brennus.o2o.entity.Shop;

public interface ShopDao {
	
	/**
	 * 分页查询店铺,可输入的条件有：店铺名（模糊），店铺状态，店铺Id,店铺类别,区域ID
	 * 
	 * @param shopCondition
	 * @param rowIndex
	 * @param pageSize
	 * @return
	 */
	List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition,
			@Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);
	
	int queryShopCount(@Param("shopCondition") Shop shopCondition);
	
	Shop queryByShopId(long shopId);
	
	int insertShop(Shop shop);
	
	int updateShop(Shop shop);
}
