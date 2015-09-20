<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>



<%@include file="/WEB-INF/jsp/init.jsp" %>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>


<portlet:actionURL var="addBillURL">
	<portlet:param name="action" value="addBill" />
</portlet:actionURL>

<aui:form action="${addBillURL }" name="fm" id="fm" >
	<aui:fieldset>
	
	
		<table class="table table-striped">
		      <caption>Liste des livres disponibles en boutique:</caption>
		      <thead>
		        <tr>
		          <th><liferay-ui:message key="title" /></th>
		          <th><liferay-ui:message key="quantity" /></th>
		          <th><liferay-ui:message key="price" /></th>
		        </tr>
		      </thead>
		      <tbody>
		      
				<c:forEach  items="${bill.arcticleBills }" var="articleBill" varStatus="status">
			        <tr>
			          <td>${articleBill.name }</td>
			          <td ><aui:input name="arcticleBills[${status.index }].quantity" label="" cssClass="quantity" value="0"></aui:input></td>
			          <td><a class="price">${articleBill.price }</a> €</td>
			        </tr>
		        </c:forEach>
		        <tr>
		          <td><b>Frais de livraison :</b></td>
		          <td></td>
		          <td><a class="price" id="<portlet:namespace />shippingPrice">${bill.shippingPrice}</a> €</td>
		        </tr>
		        <tr>
		          <td><b>Prix total :</b></td>
		          <td></td>
		          <td><a class="price" id="<portlet:namespace />totalPrice"></a> €</td>
		        </tr>
		      </tbody>
		      
		</table>
		
		<h3>Adresse de facturation</h3>
		
		<aui:row>
			<aui:col span="4">
				<aui:input name="facurationAddress.name" label="name" cssClass="">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
			<aui:col span="8">
				<aui:input name="receptionAddress.email" label="email" cssClass="longInput">
					<aui:validator name="required" />
					<aui:validator name="email" />
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="4">
				<aui:input name="facurationAddress.complement" label="Complement d'adresse (Optionnel)" cssClass=""/>

			</aui:col>
			<aui:col span="8">
				<aui:input name="facurationAddress.street" label="street" cssClass="longInput">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="4">
				<aui:input name="facurationAddress.postalCode" label="postal-code" cssClass="">
					<aui:validator name="required" />
					<aui:validator name="digits" />
				</aui:input>
			</aui:col>
			<aui:col span="8">
				<aui:input name="facurationAddress.city" label="city" cssClass="longInput" >
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
		</aui:row>
		
		
		<h3>Adresse d'envoi</h3>
		
		<aui:row>
			<aui:col span="4">
				<aui:input name="receptionAddress.name" label="name" cssClass="">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
			<aui:col span="8">
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="4">
				<aui:input name="receptionAddress.complement" label="Complement d'adresse (Optionnel)" cssClass=""/>

			</aui:col>
			<aui:col span="8">
				<aui:input name="receptionAddress.street" label="street" cssClass="longInput">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="4">
				<aui:input name="receptionAddress.postalCode" label="postal-code" cssClass="">
					<aui:validator name="required" />
					<aui:validator name="digits" />
				</aui:input>
			</aui:col>
			<aui:col span="8">
				<aui:input name="receptionAddress.city" label="city" cssClass="longInput" >
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
		</aui:row>
		
		<div id="payment-form"></div>

		<aui:button name="command" type="submit" label="Commander" cssClass="saveButton"></aui:button>
	</aui:fieldset>
</aui:form>

<script src="https://js.braintreegateway.com/v2/braintree.js"></script>
<script>

braintree.setup( "${bill.token}" , "dropin", {
  container: "payment-form"
});
</script>

<script type="text/javascript">
AUI().use('aui-base', 'aui-node', 'aui-form-validator', function(A) {


	var quantityFields = A.all(".quantity");
	A.one("#<portlet:namespace />totalPrice").html(parseInt(A.one("#<portlet:namespace />shippingPrice").getHTML()));
	
	quantityFields.each(function() {
		
		this.on('input', function() {
			var price = parseInt(A.one("#<portlet:namespace />shippingPrice").getHTML());
			quantityFields.each(function() {
				if(isNaN(parseInt(this.get('value')) )) {} else {

					var grandfather = this.get("parentNode.parentNode.parentNode");
					price = price + (parseInt(this.get('value')) * parseInt(grandfather.one(".price").html()));
					console.info(parseInt(this.get('value')));
				}
			});

			A.one("#<portlet:namespace />totalPrice").html(price);
		});
	});	
});

</script>
    