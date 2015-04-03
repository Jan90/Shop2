/**
 * 
 */
function removeProduct(productIndex) {
		var url = "shoppingCart.do";
		$.ajax({
			url : url,
			data : {
				productIndex : productIndex
			},
			type : "get"
		}).done(function(data) {
			$("#content").html(data);
		});
	}