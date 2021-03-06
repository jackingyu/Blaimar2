ACC.orderlist = {
	init:function() {
		$("#createorder").unbind();
		$("#createorder").on("click",function(){
			ACC.order.create();
		});
		
		$("#searchOrderBtn").unbind();
		$("#searchOrderBtn").on("click",function(){
			var searchForm = $("#searchOrderForm").form();
			if($("#orderListGrid").datagrid("options").url==null)
		    	$("#orderListGrid").datagrid({url:ACC.config.contextPath+"/getOrderList",
				 queryParams:serializeObject(searchForm),pageNumber:1});
			else
				$("#orderListGrid").datagrid("load",serializeObject(searchForm));
		});
		
		$("#exportOrderBtn").unbind();
		$("#exportOrderBtn").on("click",function(){
			ACC.orderlist.exportOrder();
		});
		
		$("#orderListGrid").datagrid({
		//	url:ACC.config.contextPath+"/getOrderList",
			singleSelect:true,
            toolbar:'#orderlist-tb',
            pagination:true,
            rownumbers:true,
            idField:"pk",
            onDblClickRow: function(rowIndex,value) {
		           ACC.order.modify(value);
		           $('#tabs').tabs('getSelected').scrollTo("#orderPanelPosition",500);
            }
		});
		
		var ctime = getCurrentDate();

		$("#searchOrderForm-orderStartDate").datebox({
			   value:ctime
		});
		
		$("#searchOrderForm-orderEndDate").datebox({
			   value:ctime
		 });
		
	    $("#searchOrderForm-orderStartDate").datebox().datebox('calendar').calendar({
				validator: function(date){
					//var now = new Date();
					var enddate =  $('#searchOrderForm-orderEndDate').datebox("getValue");
					return Date.parse(date) <= Date.parse(enddate) ;
				}
		});
	    
		 $("#searchOrderForm-orderEndDate").datebox().datebox('calendar').calendar({
				validator: function(date){
					//var now = new Date();
					var begindate =  $('#searchOrderForm-orderStartDate').datebox("getValue");
					return Date.parse(date) >= Date.parse(begindate);
				}
		});
		
	},
	exportOrder:function(){
		$.ajax({
			type : "get",
			url : ACC.config.contextPath + "/exportOrder",
			success : function(data) {
				window.location.href = ACC.config.contextPath+"/"+data;
			}
		});
	}
}




