﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="com.third.controller.weixin.WXConstant" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common"%>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <title>臻品欣赏</title>
    <template:wxcss/>
	<%@ include file="inc/stat.jsp"%>
  </head>
  <body>
    <%@ include file="inc/nav2.jsp"%>
	<div class="container wx_container">
		<div class="row wx_row">
			<div class="col-xs-12 col-md-12 col-lg-12">
				<img class="wx_img" src="${pageContext.request.contextPath}/wx/img/selected1.jpg"/>
				<img class="wx_img" src="${pageContext.request.contextPath}/wx/img/selected2.png"/>
				<img class="wx_img" src="${pageContext.request.contextPath}/wx/img/selected3.png"/>
				<img class="wx_img" src="${pageContext.request.contextPath}/wx/img/selected4.jpg"/>
				<img class="wx_img" src="${pageContext.request.contextPath}/wx/img/selected5.jpg"/>
				<img class="wx_img" src="${pageContext.request.contextPath}/wx/img/selected6.jpg"/>
				<img class="wx_img" src="${pageContext.request.contextPath}/wx/img/selected7.jpg"/>
			</div>
		</div>
	</div>
  </body>
</html>