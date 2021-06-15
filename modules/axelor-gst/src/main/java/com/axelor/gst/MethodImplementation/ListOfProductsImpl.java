package com.axelor.gst.MethodImplementation;

import java.util.ArrayList;
import java.util.List;

import com.axelor.gst.ServiceMethod.ListofProducts;
import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceLine;
import com.axelor.gst.db.Product;
import com.axelor.gst.db.repo.ProductRepository;
import com.google.inject.Inject;

public class ListOfProductsImpl implements ListofProducts {

	@Inject
	ProductRepository productRepo;

	@Override
	public List<InvoiceLine> productList(List<Integer> products) {
		
		
		List<InvoiceLine> invoiceProducts = new ArrayList<InvoiceLine>();

		for (int id : products) {
			Product product = productRepo.find((long) id);
			
			InvoiceLine invoiceLine = new InvoiceLine();
			invoiceLine.setProduct(product);
			invoiceLine.setItem(product.getCode());
			invoiceLine.setHsbn(product.getHsbn());
			invoiceLine.setPrice(product.getSalePrice());
			invoiceLine.setGstRate(product.getGstRate());
			invoiceProducts.add(invoiceLine);
		}

		return invoiceProducts;
	}
}
