package com.axelor.gst.Service;

import com.axelor.gst.db.Invoice;

public interface InvoiceService {
   

	public Invoice calculateInvoiceAmount(Invoice invoice);
}
