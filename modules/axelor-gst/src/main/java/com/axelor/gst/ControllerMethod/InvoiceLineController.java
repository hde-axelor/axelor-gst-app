package com.axelor.gst.ControllerMethod;

import com.axelor.gst.ServiceMethod.InvoiceLineService;
import com.axelor.gst.db.Address;
import com.axelor.gst.db.Company;
import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceLine;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;

public class InvoiceLineController {

	@Inject
	InvoiceLineService invoiceLineService;

	public void calculateAmount(ActionRequest request, ActionResponse response) {

		InvoiceLine invoiceLine = request.getContext().asType(InvoiceLine.class);

		Company company = (Company) request.getContext().getParent().get("company");
		Address invoiceAddress = (Address) request.getContext().getParent().get("invoiceAddress");
		Address shippingAddress = (Address)request.getContext().getParent().get("shippingAddress");
		
		Invoice invoice = new Invoice();
		invoice.setCompany(company);
		invoice.setInvoiceAddress(invoiceAddress);
		invoice.setShippingAddress(shippingAddress);
		invoiceLine.setInvoice(invoice);

		invoiceLine = invoiceLineService.calculateInvoiceLine(invoiceLine);

		response.setValue("product", invoiceLine.getProduct());
		response.setValue("qty", invoiceLine.getQty());
		response.setValue("price", invoiceLine.getPrice());
		response.setValue("hsbn", invoiceLine.getHsbn());
		response.setValue("netAmount", invoiceLine.getNetAmount());
		response.setValue("gstRate", invoiceLine.getGstRate());
		response.setValue("igst", invoiceLine.getIgst());
		response.setValue("sgst", invoiceLine.getSgst());
		response.setValue("cgst", invoiceLine.getCgst());
		response.setValue("grossAmount", invoiceLine.getGrossAmount());

	}
}
