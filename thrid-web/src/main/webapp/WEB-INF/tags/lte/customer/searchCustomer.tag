<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/lte/common"%>

<div class="modal fade" id="customerSearchPanel">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">
					<spring:message code="lte.order.customer.title"></spring:message>
				</h4>
			</div>
			<div class="modal-body">
			   <div class="row">
                <div class="col-xs-3">
				<label><spring:message code="lte.order.customer.cellphone"></spring:message></label>
				<input id="searchCustomer-cellphone" class="form-control"  type="text">
				</div>
				<div class="col-xs-3">
				<label><spring:message code="lte.order.customer.name"></spring:message></label>
				<input id="searchCustomer-name" class="form-control" type="text">
				</div>
				</div>
				<button id="searchCustomerBtn" type="button" class="btn btn-block btn-default">
					<spring:message code="lte.order.customer.search"></spring:message>
				</button>
				<table id="customerSearchGrid" class="table table-bordered table-striped dataTable">
					<thead>
						<tr>
							<th>
								<spring:message code="lte.order.customer.cellphone"></spring:message>
							</th>
							<th>
								<spring:message code="lte.order.customer.name"></spring:message>
							</th>
							<th>
								<spring:message code="lte.order.customer.weddingdate"></spring:message>
							</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
			
			<div class="modal-footer">
			<button type="button" class="btn btn-default pull-left" data-dismiss="modal">
				<spring:message code="lte.close"></spring:message>
			</button>
			<button id="searchCustomer-select" type="button" class="btn btn-primary" data-dismiss="modal">
				<spring:message code="lte.save"></spring:message>
			</button>
		</div>
		</div>
	</div>
</div>
