package com.brennus.o2o.util;

public class PathUtil {
	public static String getImgBasePath() {
		String basePath = "/Users/baixueyan/Dev";
		//String basePath = "/home/dev";
		return basePath;
	}
	
	public static String getShopImagePath(long shopId) {
		String imagePath = "/upload/images/item/shop/" + shopId + "/";
		return imagePath;
		
	}

}
