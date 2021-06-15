package com.axelor.gst.ServiceMethod;

import com.axelor.gst.db.Invoice;

public interface CalculateInvoice {
   

	public Invoice calculateInvoiceAmount(Invoice invoice);
}
