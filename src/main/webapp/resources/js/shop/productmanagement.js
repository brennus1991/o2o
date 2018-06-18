$(function() {
	var shopId = 1;
	//var shopId = getQueryString('shopId');
	//var listUrl = '/o2o/shopadmin/getproductlistbyshop?pageIndex=1&pageSize=9999&shopId='+ shopId;
	var listUrl = '/o2o/shopadmin/getproductlistbyshop?pageIndex=1&pageSize=9999';
	var deleteUrl = '/o2o/shopadmin/modifyproduct';

	function getList() {
		$.getJSON(listUrl, function(data) {
			if (data.success) {
				var productList = data.productList;
				var tempHtml = '';
				productList.map(function(item, index) {
					var textOp = "下架";
					var contraryStatus = 0;
					if (item.enableStatus == 0) {
						textOp = "上架";
						contraryStatus = 1;
					} else {
						contraryStatus = 0;
					}
					tempHtml += '' + '<div class="row row-product">'
							+ '<div class="col-33">'
							+ item.productName
							+ '</div>'
							+ '<div class="col-33">'
							+ item.priority
							+ '</div>'
							+ '<div class="col-33">'
							+ '<a href="#" class="edit" data-id="'
							+ item.productId
							+ '" data-status="'
							+ item.enableStatus
							+ '">编辑</a>'
							+ '<a href="#" class="delete" data-id="'
							+ item.productId
							+ '" data-status="'
							+ contraryStatus
							+ '">'
							+ textOp
							+ '</a>'
							+ '<a href="#" class="preview" data-id="'
							+ item.productId
							+ '" data-status="'
							+ item.enableStatus
							+ '">预览</a>'
							+ '</div>'
							+ '</div>';
				});
				$('.product-wrap').html(tempHtml);
			}
		});
	}

	function handleList1() {
		$
				.getJSON(
						listUrl,
						function(data) {
							if (data.success) {
								var productList = data.productList;
								var tempHtml = '';

								productList
										.map(function(item, index) {

											tempHtml += '<li><a href="#" class="item-link item-content" data-id="'
												+ item.productId + '"><div class="item-inner"><div class="item-title">'
													+ item.productName
													+ '</div></div></a></li>';
										});
								$('.shop-wrap1').html(tempHtml);
							}
						});
	}

	//getList();
	handleList1();

	function deleteItem(id, enableStatus) {
		var product = {};
		product.productId = id;
		product.enableStatus = enableStatus;
		$.confirm('确定么?', function() {
			$.ajax({
				url : deleteUrl,
				type : 'POST',
				data : {
					productStr : JSON.stringify(product),
					statusChange : true
				},
				dataType : 'json',
				success : function(data) {
					if (data.success) {
						$.toast('操作成功！');
						getList();
					} else {
						$.toast('操作失败！');
					}
				}
			});
		});
	}

	$('.shop-wrap1')
			.on(
					'click',
					'a',
					function(e) {
						var target = $(e.currentTarget);
						
						var buttons1 = [
					        {
					          text: "请选择",
					          label: true
					        },
					        {
					          text: '编辑',
					          bold: true,
					          color: 'danger',
					          onClick: function() {
					        	  window.location.href = '/o2o/shopadmin/productoperation?productId='
										+ e.currentTarget.dataset.id;
					          }
					        },
					        {
					          text: '下架',
					          onClick: function() {
					            $.alert("你选择了“下架“");
					          }
					        },
					        {
						          text: '预览',
						          onClick: function() {
						            $.alert("你选择了“预览“");
						          }
						        }
					        
					      ];
					      var buttons2 = [
					        {
					          text: '取消',
					          bg: 'danger'
					        }
					      ];
					      var groups = [buttons1, buttons2];
					      $.actions(groups);
					});
	
	$('.product-wrap')
	.on(
			'click',
			'a',
			function(e) {
				var target = $(e.currentTarget);
				if (target.hasClass('edit')) {
					window.location.href = '/o2o/shopadmin/productoperation?productId='
							+ e.currentTarget.dataset.id;
				} else if (target.hasClass('delete')) {
					deleteItem(e.currentTarget.dataset.id,
							e.currentTarget.dataset.status);
				} else if (target.hasClass('preview')) {
					window.location.href = '/o2o/frontend/productoperation?productId='
							+ e.currentTarget.dataset.id;
				}
			});
	

	$('#new').click(function() {
		window.location.href = '/o2o/shopadmin/productoperation';
	});
});