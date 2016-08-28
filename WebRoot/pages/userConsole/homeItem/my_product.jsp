<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

	

<div role="tabpanel" class="tab-pane" id="messages">
	<div style="width: 100%;">
		<div class="" style="width: 100%;height: 100px;">
			<div style="overflow-y: auto;" id="productField">
				<a class="uk-thumbnail productHref">
					<img src="" alt="" class="productConver" style="width: 200px;height: 100px;">
						<div class="uk-thumbnail-caption productName" style="width: 200px;white-space: nowrap;overflow: hidden;">
						尚未创建产品
						</div>
				</a>
			</div>
		</div>
	</div>
</div>
	
	

<script type="text/javascript">
	$(document).ready(function() {
		$.post('getProductsInConsoleForUser!getProductsInConsoleForUser.action', {
			fromConsole : true
		}, function(data, textStatus) {
			if(textStatus == 'success') {
				
				if(data.success) {
					for(var i = 0; i < data.ps.length-1; i++) {
						$("#productField").append($(".productHref").clone().attr("class", "uk-thumbnail productFieldClone"));
					}
					for(var i = 0;i < data.ps.length; i++) {
						
						if(i === 0) {
							$(".productHref").eq(i).attr("href", "getProductItem?item="+data.ps[i].productId);
							$(".productName").eq(i).text(data.ps[i].productName);
							$(".productConver").eq(i).attr("src", data.ps[i].productCover);
						} else {
							$(".productFieldClone").eq(i-1).attr("href", "getProductItem?item="+data.ps[i].productId);
							$(".productName").eq(i).text(data.ps[i].productName);
							$(".productConver").eq(i).attr("src", data.ps[i].productCover);
						}
						
					}
				} else {
					alert("获取产品出错，请刷新重试");
				}
			} else {
				alert("网络出错！请刷新重试！");
			}
		}, 'json');
	});
</script>
	




