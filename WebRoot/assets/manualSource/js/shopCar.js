	function operateShopCar() {
		
		var checkAll = document.getElementById("checkAll");
		var checkOnes = document.getElementsByClassName("checkOne");
		var commodityOneTotals = document.getElementsByClassName("commodityOneTotal");
		var commodityCountInput = document.getElementsByClassName("commodityCountInput");
		var priceTotal = document.getElementById("priceTotal");
		var selectedTotal = document.getElementById("selectedTotal");
		var trSpans = document.getElementsByClassName("trSpan");
		var commodityOperations = document.getElementsByClassName("commodityOperation");
		var tbodySpan = document.getElementById("tbodySpan");
		var deleteSelect = document.getElementById("deleteSelect");
		var commodityCountInput = document.getElementsByClassName("commodityCountInput");
		var commodityPrices = document.getElementsByClassName("commodityPrice");
		var commodityReduces = document.getElementsByClassName("commodityReduce");
		var commodityAdds = document.getElementsByClassName("commodityAdd");
		var produceItem = document.getElementsByClassName("produceItem");
		
		/**
		 * -功能按钮
		 */
		for(var i = 0; i < commodityReduces.length; i++) {
			(function(x) {
				commodityReduces[x].onclick = function() {
					if(parseInt(commodityCountInput[x].value) >= 2) {
						--commodityCountInput[x].value;	
						operateCommodityOneTotal();
					}
				}
	        })(i)
		}
		
		/**
		 * +功能按钮
		 */
		for(var i = 0; i < commodityAdds.length; i++) {
			(function(x) {
				commodityAdds[x].onclick = function() {
					++commodityCountInput[x].value;
					operateCommodityOneTotal();
				}
	        })(i)
		}
		/**
		 * 输入个数
		 */
		for(var i = 0; i < commodityCountInput.length; i++) {
			(function(x) {
	        	commodityCountInput[i].onkeyup = function() {
	        		var content = commodityCountInput[x].value;
	        		try {
	        			parseInt(content);
	        		} catch(e) {
	        			content = 1;
	        		}
	        		if(content < 1) {
	        			content = 1;
	        		}
	        		if(isNaN(content)) {
	        			content = 1;
	        		}
	        		commodityCountInput[x].value = content;
	        		operateCommodityOneTotal();
				}
	        })(i)
		}
		
		function operateCommodityOneTotal() {
			for(var i = 0; i < commodityOneTotals.length; i++) {
				commodityOneTotals[i].innerHTML = (parseFloat(commodityPrices[i].innerHTML) * parseInt(commodityCountInput[i].value)).toFixed(2);
			}
			setPriceTotal();
		}
		
		
		for(var i = 0; i < commodityOperations.length; i++) {
	        (function(x) {
	        	commodityOperations[i].onclick = function () {
					if(confirm("是否将该产品从购物车中删除？")) {
						//alert(produceItem[x].value);
						//tbodySpan.removeChild(trSpans[x]);
						//setPriceTotal();
						var deleteProductId = new Array();
						deleteProductId.push(produceItem[x].value);
						var PId = function(ids) {
							this.ids = ids;
						}
						var p = new PId(deleteProductId);
						$.post("shopCarAction!deleteItem.action", {
							deleteProductId : JSON.stringify(p)
						}, function(data, textStatus) {
				        	if(textStatus == "success") {
				        		if(data.success) {
				        			 location.reload();
				        		} else {
				        			alert(data.reason);
				        		}
				        	} else {
				        		alert("请刷新重试！");
				        	}
				        }, 'json');
					}
             	}
	        })(i)
		}

		deleteSelect.onclick = function() {
			if(confirm("是否将选中的产品全部删除？")) {
				removeSelected();
				setPriceTotal();
			}
		}
		function removeSelected() {
			for(var i = 0; i < checkOnes.length; i++) {
				if(checkOnes[i].checked) {
					tbodySpan.removeChild(trSpans[i]);
				}
			}
			if(!isRemoveSelected()) {
				removeSelected();
			} else {
				return;
			}
		}
		/**
		 * 辅助函数，用于扫描是否将选中需要删除的产品删除完毕
		 */
		function isRemoveSelected() {
			for(var i = 0; i < checkOnes.length; i++) {
				if(checkOnes[i].checked) {
					return false;
				}
			}
			return true;
		}

		for(var i = 0; i < checkOnes.length; i++) {
				checkOnes[i].addEventListener("click", checkOneClick, false);
		}
		function checkOneClick() {
			setPriceTotal();
		}
		
		checkAll.addEventListener("click", function (event) {
			for(var i = 0; i < checkOnes.length; i++) {
				checkOnes[i].checked = !checkOnes[i].checked;
			}
			setPriceTotal();
		}, false);
		
		/**
		 * 更改总计的金额 以及 选中商品的数量
		 */
		function setPriceTotal() {
			var priceTotalMoney = 0;
			var selectedCount = 0;
			for(var i = 0; i < checkOnes.length; i++) {
				if(checkOnes[i].checked) {
					priceTotalMoney += parseFloat(commodityOneTotals[i].innerHTML);
					selectedCount += parseInt(commodityCountInput[i].value);
				}
			}
			priceTotal.innerHTML = (priceTotalMoney).toFixed(2);
			selectedTotal.innerText = (selectedCount).toFixed(2);
		}
	}
