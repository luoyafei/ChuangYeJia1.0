/**
 * 
 */
function removeP() {
	if(confirm("确定要将该商品删除吗？删除后将无法恢复！确认请继续")) {
		$.post('removeProduct!justDoIt.action', {
			item : "<s:property value='#request.product.productId' />"
		}, function(data, textStatus) {
			if(textStatus == "success") {
				if(data.success) {
					alert("删除成功！");
					window.history.back();
				} else {
					alert("删除失败！");
				}
			}
		}, 'json');
	}
}