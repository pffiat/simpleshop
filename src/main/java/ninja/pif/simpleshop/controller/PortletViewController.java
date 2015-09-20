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

package ninja.pif.simpleshop.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;

import ninja.pif.simpleshop.model.Bill;
import ninja.pif.simpleshop.service.BillService;
import ninja.pif.simpleshop.util.MailConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.ParamUtil;
import com.samskivert.mustache.Mustache;

@Controller
@RequestMapping("VIEW")
public class PortletViewController {
	
	Log log = LogFactoryUtil.getLog(getClass());
	
	@Autowired
	BillService billService;

	@RenderMapping
	public String showDefaultView(RenderRequest renderRequest,  @ModelAttribute(value="bill") Bill bill, BindingResult bindingResult) {
		
		renderRequest.setAttribute("bill", bill);
		
		return "simpleshop/view";
	}	
	


	@ActionMapping(params= "action=addBill")
	public void updateEmployerCategory(ActionRequest actionRequest, ActionResponse actionResponse,
		@ModelAttribute(value="bill") Bill bill, BindingResult bindingResult) {
		
		String nonce = ParamUtil.getString(actionRequest, "payment_method_nonce");
		billService.add(bill);
		
		log.info("nonce " + nonce);
		
//		TransactionRequest transactionRequest = new TransactionRequest()
//	    .amount(new BigDecimal("100.00"))
//	    .paymentMethodNonce(nonce);
//		
//		
//
//		Result<Transaction> result = new BraintreeGateway(
//			  Environment.SANDBOX,
//			  BraintreeConstants.MERCHAND_ID,
//			  BraintreeConstants.PUBLIC_KEY,
//			  BraintreeConstants.PRIVATE_KEY
//			).transaction().sale(transactionRequest);
//		
//		log.info("result.isSuccess()" + result.isSuccess());
		
		
		String location = actionRequest.getPortletSession().getPortletContext().getRealPath("")+"/WEB-INF/classes";
		

		String templateBodyCustomer = location + "/mail-to-customer.mustache";
		String templateBodyExpeditor = location + "/mail-to-expeditor.mustache";
		
		try {
			String mailBodyCustomer = Mustache.compiler().compile(new FileReader(templateBodyCustomer)).execute(bill);
			
			String mailBodyExpeditor = Mustache.compiler().compile(new FileReader(templateBodyExpeditor)).execute(bill);

			log.info("mailBodyCustomer : " + mailBodyCustomer);
			log.info("mailBodyExpeditor : " + mailBodyExpeditor);
					 
			String subject="Commande numéro " + bill.getCommandeId() + " sur albert-gabrieleff.com";	
			InternetAddress from;
			try {
				from = new InternetAddress(MailConstants.ADDRESS_NO_REPLY, MailConstants.NAME_NO_REPLY);	

				//for the customer 
				InternetAddress to = new InternetAddress(bill.getFacurationAddress().getEmail(), bill.getFacurationAddress().getName());
				MailMessage mailMessage = new MailMessage(from, to, subject, mailBodyCustomer, false);
				MailServiceUtil.sendEmail(mailMessage);
				
				//for the expeditor
				to = new InternetAddress(MailConstants.ADDRESS_EXPEDITOR, MailConstants.NAME_EXPEDITOR);
				mailMessage = new MailMessage(from, to, subject, mailBodyExpeditor, false);
				mailMessage.setCC(new InternetAddress(MailConstants.ADDRESS_CC_EXPEDITOR, MailConstants.NAME_CC_EXPEDITOR));
				MailServiceUtil.sendEmail(mailMessage);
				
				
				
			}
			catch (UnsupportedEncodingException e) {
				log.error(e);
			}
			
		} catch (FileNotFoundException e1) {
			log.error("file not found");
		}
		
		
	}	
	
	/**
	 * Create a model object for the admin staff management view : this metohd will be called before the
	 * execute of any action or render method.
	 * 
	 * @return a adminStaffManagementModel model Object
	 */

	@ModelAttribute("bill")
	public Bill getBill() {
		return new Bill();
	}

	/**
	* bind request parameter to the "ipe" object
	*
	* @param binder
	* the spring framework binder object
	*/
	@InitBinder("bill")
	public void initBinderIPE(WebDataBinder binder) {		
	}	

}