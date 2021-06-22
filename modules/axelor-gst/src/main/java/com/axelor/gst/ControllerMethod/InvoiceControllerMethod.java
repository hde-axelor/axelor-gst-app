package com.axelor.gst.ControllerMethod;

import com.axelor.gst.ServiceMethod.CalculateInvoice;
import com.axelor.gst.db.Invoice;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;

public class InvoiceControllerMethod {

	@Inject
	CalculateInvoice calculateInvoice;

	public void invoice(ActionRequest request, ActionResponse response) {

		Invoice invoice = request.getContext().asType(Invoice.class);

		invoice = calculateInvoice.calculateInvoiceAmount(invoice);
        
		 response.setValues(invoice);
		
	}

}
