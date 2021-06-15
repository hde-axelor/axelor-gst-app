package com.axelor.gst.ControllerMethod;

import java.util.List;

import com.axelor.gst.ServiceMethod.ListofProducts;
import com.axelor.gst.db.InvoiceLine;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;

public class ListOfProductController {

	   @Inject ListofProducts listOfProducts;
	
	  @SuppressWarnings("unchecked")
	public void invoiceProducts(ActionRequest request , ActionResponse response) {
		  
		List<Integer> id = (List<Integer>) request.getContext().get("products");
		  List<InvoiceLine> plist = listOfProducts.productList(id);
		  response.setValue("invoiceItems", plist);
		  
		 
		  
	  }
}
