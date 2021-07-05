package com.axelor.gst.Service;

import com.axelor.gst.db.InvoiceLine;

public interface InvoiceLineService {
    
	public InvoiceLine calculateInvoiceLine(InvoiceLine invoiceLine);
}
