package com.brennus.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.brennus.o2o.BaseTest;
import com.brennus.o2o.dto.ImageHolder;
import com.brennus.o2o.dto.ProductExecution;
import com.brennus.o2o.entity.Product;
import com.brennus.o2o.entity.ProductCategory;
import com.brennus.o2o.entity.Shop;
import com.brennus.o2o.enums.ProductStateEnum;
import com.brennus.o2o.exceptions.ProductOperationException;

public class ProductServiceTest extends BaseTest{
	@Autowired
	private ProductService productService;
	
	@Test
	@Ignore
	public void testAddProduct() throws ProductOperationException, FileNotFoundException {

	//创建 shopId 为 1 且 productCategoryId 为 1 的商品实例并给其成员变量赋值
	Product product = new Product();
	Shop shop = new Shop();
	shop.setShopId(1L);
	ProductCategory pc = new ProductCategory ();
	pc.setProductCategoryId(1L);
	product.setShop (shop);
	product.setProductCategory (pc);
	product.setProductName("测试商品 1");
	product.setProductDesc("测试商品 1");
	product.setPriority (20);
	product.setCreateTime (new Date());
	product.setEnableStatus (ProductStateEnum.SUCCESS.getState());

	//创建缩略图文件流
	File thumbnailFile = new File("/Users/baixueyan/Desktop/M记素材/1440.png");
	InputStream is = new FileInputStream (thumbnailFile);
	ImageHolder thumbnail = new ImageHolder (thumbnailFile.getName(), is);

	//创建两个商品详情图文件流并将他们添加到详情图列表中
	File productImg1 = new File("/Users/baixueyan/Desktop/M记素材/1440.png");
	InputStream is1 = new FileInputStream (productImg1) ;
	File productImg2 = new File ("/Users/baixueyan/Desktop/M记素材/502953.png");
	InputStream is2 = new FileInputStream (productImg2);
	
	List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
	productImgList.add(new ImageHolder(productImg1.getName(),is1));
	productImgList.add(new ImageHolder(productImg2.getName(),is2));
	
	ProductExecution pe = productService.addProduct(product, thumbnail, productImgList);
	assertEquals (ProductStateEnum.SUCCESS.getState(), pe.getState());
	}
	
	
	@Test
	public void testModifyProduct() throws ProductOperationException, FileNotFoundException {

	//创建 shopId 为 1 且 productCategoryId 为 1 的商品实例并给其成员变量赋值
	Product product = new Product();
	Shop shop = new Shop();
	shop.setShopId(1L);
	ProductCategory pc = new ProductCategory ();
	pc.setProductCategoryId(1L);
	product.setProductId(1L);
	product.setShop (shop);
	product.setProductCategory (pc);
	product.setProductName("正式商品 1");
	product.setProductDesc("正式商品 1");
	product.setPriority (23);


	//创建缩略图文件流
	File thumbnailFile = new File("/Users/baixueyan/Desktop/M记素材/1440.png");
	InputStream is = new FileInputStream (thumbnailFile);
	ImageHolder thumbnail = new ImageHolder (thumbnailFile.getName(), is);

	//创建两个商品详情图文件流并将他们添加到详情图列表中
	File productImg1 = new File("/Users/baixueyan/Desktop/M记素材/1440.png");
	InputStream is1 = new FileInputStream (productImg1) ;
	File productImg2 = new File ("/Users/baixueyan/Desktop/M记素材/502953.png");
	InputStream is2 = new FileInputStream (productImg2);
	
	List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
	productImgList.add(new ImageHolder(productImg1.getName(),is1));
	productImgList.add(new ImageHolder(productImg2.getName(),is2));
	
	ProductExecution pe = productService.modifyProduct(product, thumbnail, productImgList);
	assertEquals (ProductStateEnum.SUCCESS.getState(), pe.getState());
	}
	
}
