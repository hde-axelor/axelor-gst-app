package com.axelor.gst.web;

import com.axelor.gst.Service.InvoiceService;
import com.axelor.gst.db.Invoice;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;

public class InvoiceController {

	@Inject
	InvoiceService calculateInvoice;

	public void invoice(ActionRequest request, ActionResponse response) {

		Invoice invoice = request.getContext().asType(Invoice.class);

		invoice = calculateInvoice.calculateInvoiceAmount(invoice);
        
		 response.setValues(invoice);
		
	}

}
