package com.brennus.o2o.service;

import java.util.List;

import com.brennus.o2o.dto.ImageHolder;
import com.brennus.o2o.dto.ProductExecution;
import com.brennus.o2o.entity.Product;
import com.brennus.o2o.exceptions.ProductOperationException;

public interface ProductService {
	ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);

	Product getProductById(long productId);

	ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
			throws ProductOperationException;

	ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
			throws ProductOperationException;
	
}
