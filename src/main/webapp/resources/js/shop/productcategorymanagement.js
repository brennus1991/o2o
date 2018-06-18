$(function() {
	var shopId = 1;
	var listUrl = '/o2o/shopadmin/getproductcategorylist?shopId=' + shopId;
	var addUrl = '/o2o/shopadmin/addproductcategorys';
	var deleteUrl = '/o2o/shopadmin/removeproductcategory';

	function getList() {
		$
				.getJSON(
						listUrl,
						function(data) {
							if (data.success) {
								var dataList = data.data;
								$('.category-wrap').html('');
								var tempHtml = '';
								dataList
										.map(function(item, index) {
											tempHtml += ''
													+ '<div class="row row-product-category now">'
													+ '<div class="col-33 product-category-name">'
													+ item.productCategoryName
													+ '</div>'
													+ '<div class="col-33">'
													+ item.priority
													+ '</div>'
													+ '<div class="col-33"><a href="#" class="button button-fill button-danger" data-id="'
													+ item.productCategoryId
													+ '">删除</a></div>'
													+ '</div>';
										});
								$('.category-wrap').append(tempHtml);
							}
						});
	}
	getList();
	$('#new').click(function() {
				var tempHtml = '<div class="row row-product-category temp">'
						+ '<div class="col-33"><input class="category-input category" type="text" placeholder="分类名"></div>'
						+ '<div class="col-33"><input class="category-input priority" type="number" placeholder="优先级"></div>'
						+ '<div class="col-33"><a href="#" class="button button-fill button-danger">删除</a></div>'
						+ '</div>';
				$('.category-wrap1').append(tempHtml);
			});
	$('#submit').click(function() {
		var tempArr = $('.temp');
		var productCategoryList = [];
		tempArr.map(function(index, item) {
			var tempObj = {};
			tempObj.productCategoryName = $(item).find('.category').val();
			tempObj.priority = $(item).find('.priority').val();
			if (tempObj.productCategoryName && tempObj.priority) {
				productCategoryList.push(tempObj);
			}
		});
		$.ajax({
			url : addUrl,
			type : 'POST',
			data : JSON.stringify(productCategoryList),
			contentType : 'application/json',
			success : function(data) {
				if (data.success) {
					$.toast('提交成功！');
					getList();
				} else {
					$.toast('提交失败！');
				}
			}
		});
	});
	
	$('.category-wrap').on('click', '.row-product-category.now .button',
			function(e) {
				var target = e.currentTarget;
				$.confirm('确定么?', function() {
					$.ajax({
						url : deleteUrl,
						type : 'POST',
						data : {
							productCategoryId : target.dataset.id,
							shopId : shopId
						},
						dataType : 'json',
						success : function(data) {
							if (data.success) {
								$.toast('删除成功！');
								getList();
							} else {
								$.toast('删除失败！');
							}
						}
					});
				});
			});

	$('.category-wrap1').on('click', '.row-product-category.temp .button',
			function(e) {
				console.log($(this).parent().parent());
				$(this).parent().parent().remove();

			});
});