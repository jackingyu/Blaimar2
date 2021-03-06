<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="addedTabPanel">
	<div id="userlist-tb">
		<a id="createuser" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="ACC.usergroup.create"></a>
		<div class="searchcondition">
			<form id="searchUserForm">
				<span><spring:message code="userlist.id" /></span> <input name="userId"></input>
				<span><spring:message code="userlist.name" /></span> <input name="name"></input> 
				<span><spring:message code="userlist.store" /></span> 
				   <select class="easyui-combobox width-80" name="store">
	    			    <option value="xx">店铺</option>
	    			    <option value="xx">测试</option>
	    			    <option value="xx">深林之子</option>
		            </select>
				<a href="#" class="easyui-linkbutton" plain="true" id="searchUserBtn"><spring:message
						code="form.select" /></a>
			</form>
		</div>
	</div>
	<table id="userListGrid" style="width: 600px; height: 390px;"
		title="<spring:message code="userlist.title"/>">
		<thead>
			<tr>
				<th field="userId" class="column-100"><spring:message
						code="userlist.column.id" /></th>
				<th field="name" class="column-100"><spring:message
						code="userlist.column.name" /></th>
			</tr>
		</thead>
	</table>
	<jsp:include page="userEditorPanel.jsp" flush="true" />
</div>
<script type="text/javascript">
   ACC.userlist.initEvent();
</script>