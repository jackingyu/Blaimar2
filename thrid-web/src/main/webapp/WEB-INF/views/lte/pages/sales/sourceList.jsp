<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/lte/template"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/lte/common"%>
<%@ taglib prefix="customer" tagdir="/WEB-INF/tags/lte/customer"%>


<template:page>
	<jsp:attribute name="pageScripts">
	   <script src="${lteResourcePath}/js/acc.storesourcelist.js"></script>
	   <script src="${lteResourcePath}/js/acc.message.js"></script>
	</jsp:attribute>
	<jsp:body>
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="row">
       <div class="col-lg-8 col-md-8 col-sm-6 col-xs-6">
      <h1>
        <spring:message code="lte.sourcelist.title"></spring:message>
      </h1>
      <small><spring:message code="lte.sourcelist.hint"></spring:message></small>
      </div>
      </div>
    </section>
    <section class="content-header">
     <form id="sourceListForm">
       <div class="row">
     
        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
         <label><spring:message code="lte.sourcelist.partner"></spring:message></label>
         <common:selection2 id="sourcePKs" data="${sources}" multiple="true" name="sourcePKs"></common:selection2>
        </div>
        
        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
         <label><spring:message code="lte.sourcelist.store"></spring:message></label>
         <common:selection id="storeCode" data="${stores}" name="storeCode"></common:selection>
        </div>
        
        <div class="col-lg-1 col-md-1">
        <a class="btn btn-app" id="assignSource2StoreBtn">
          <i class="fa fa-edit"></i>  <spring:message code="lte.create"></spring:message>
         </a>
       </div>
        <div class="col-lg-1 col-md-1">
         <a onclick="ACC.storesourcelist.query()" class="btn btn-app">
          <i class="fa fa-search"></i>  <spring:message code="lte.search"></spring:message>
       </a>
       </div>
      
       </div>
       </form>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title"><spring:message code="lte.report.results"></spring:message></h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="sourceGrid" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th><spring:message code="lte.sourcelist.name"></spring:message></th>
                  <th><spring:message code="lte.operation"></spring:message></th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
          </div>
        </div>
    </section>
    <customer:sourceDetailsPanel></customer:sourceDetailsPanel>
    <common:message></common:message>
  </jsp:body>
</template:page>