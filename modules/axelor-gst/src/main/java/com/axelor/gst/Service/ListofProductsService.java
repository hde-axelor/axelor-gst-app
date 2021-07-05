package com.axelor.gst.Service;

import java.util.List;

import com.axelor.gst.db.InvoiceLine;

public interface ListofProductsService {
   
	    public List<InvoiceLine> productList(List<Integer> products);
}
