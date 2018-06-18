package com.brennus.o2o.service;

import java.util.List;

import com.brennus.o2o.dto.ProductCategoryExecution;
import com.brennus.o2o.entity.ProductCategory;
import com.brennus.o2o.exceptions.ProductCategoryOperationException;

public interface ProductCategoryService {
	
	List<ProductCategory> getProductCategoryList(long shopId);
	
	ProductCategoryExecution batchAddProductCategory(
			List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;
	
	ProductCategoryExecution deleteProductCategory(long productCategoryId,
			long shopId) throws ProductCategoryOperationException;

}
