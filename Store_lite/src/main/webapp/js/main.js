/**
 * 
 */
$(document).ready(function() {
			$("#content").load("getNewProducts.do");

		});
		
		function changeBackgrndLoadPage() {
			var currentColor = document.getElementById('menu').style.backgroundColor;
			if (currentColor != "") {
				var count = document.getElementById("content")
						.getElementsByTagName("div").length;
				for (var i = 0; count > i; i++) {
					document.getElementById("content").getElementsByTagName(
							"div")[i].style.backgroundColor = currentColor;

				}

			} else {
			}

		}
		
		function changeBackgrnd(id) {
			var elem = document.getElementById(id).value;
			var color = elem;
			var count = document.body.getElementsByTagName("div").length;
			for (var i = 0; count > i; i++) {
				document.getElementsByTagName("div")[i].style.backgroundColor = color;
			}
		}

		function changeButtonColor(buttonId) {
			resetButton();
			document.getElementById(buttonId).style.backgroundColor = "rgb(78, 238, 148)";
		}

		function nextPage(buttonId) {
			var buttonValue = document.getElementById(buttonId).value;
			changeButtonColor(buttonId);
			switch (buttonValue) {
			case "Main":
				$("#content").load("getNewProducts.do");

				break;
				
			case "Catalogue":
				var url = "getProductList.do";

				$.ajax({

					url : "getProductList.do",
					data : {
						getMain : status,
						name : name
					},
					type : "get",
					success : function(data) {
						$('#content').html(data);
						changeBackgrndLoadPage();
					}
				})

				break;
				
			case "Shopping cart":
				var url = "shoppingCart.do";
				$.ajax({
					url : url,
					data : {
						getShoppingCart : "genShoppingCart"
					},
					type : "GET"
				}).done(function(data) {
					$("#content").html(data);
					changeBackgrndLoadPage();
				});
				break;
			}
		}
		
		function resetButton() {
			var buttons = document.getElementsByTagName("input");
			var buttonsCount = buttons.length;
			for (var i = 0; buttonsCount > i; i = i + 1) {
				var buttonId = buttons[i].id;
				var currentColor = document.getElementById(buttonId).style.backgroundColor;
				if (currentColor == "rgb(78, 238, 148)") {
					document.getElementById(buttonId).style.backgroundColor = "rgb( 230, 185, 129)";
					break;
				}
			}
		}