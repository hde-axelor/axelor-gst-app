package com.axelor.gst.ServiceMethod;

import java.util.List;

import com.axelor.gst.db.InvoiceLine;

public interface ListofProducts {
   
	    public List<InvoiceLine> productList(List<Integer> products);
}
