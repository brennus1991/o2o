package com.brennus.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.brennus.o2o.entity.ProductCategory;

public interface ProductCategoryDao {
	
	List<ProductCategory> queryProductCategoryList(long shopId);

	int batchInsertProductCategory(List<ProductCategory> productCategory);
	
	int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);
}
