$(function() {
	
	var shopId = getQueryString('shopId');
	var shopInfoUrl = '/o2o/shopadmin/getshopmanagementinfo?shopId=' + shopId;
	var shopInfoFullUrl = "/o2o/shopadmin/getshopbyid?shopId=" + shopId;
	
	$.getJSON(shopInfoUrl, function(data) {
		if (data.redirect) {
			window.location.href = data.url;
		} else {
			if (data.shopId != undefined && data.shopId != null) {
				shopId = data.shopId;
			}
			$('#shopInfo')
			.attr('href', '/o2o/shopadmin/shopoperation?shopId=' + shopId);
			
			
			$.getJSON(shopInfoFullUrl, function(data1) {
			var shop = data1.shop;
			$('#shop-name').text(shop.shopName);
			$('#shop-addr').text(shop.shopAddr);
			$('#shop-desc').text(shop.shopDesc);
			$('#shop-desc1').text(shop.shopDesc);
			$('#shop-cover-pic').attr('src', shop.shopImg);
			
			});
		}
	});
});
		
		