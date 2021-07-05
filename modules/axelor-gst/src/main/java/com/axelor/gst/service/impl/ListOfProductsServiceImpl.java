package com.axelor.gst.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.axelor.gst.Service.ListofProductsService;
import com.axelor.gst.db.InvoiceLine;
import com.axelor.gst.db.Product;
import com.axelor.gst.db.repo.ProductRepository;
import com.google.inject.Inject;

public class ListOfProductsServiceImpl implements ListofProductsService {

	@Inject
	ProductRepository productRepo;

	@Override
	public List<InvoiceLine> productList(List<Integer> products) {

		List<InvoiceLine> invoiceProducts = new ArrayList<InvoiceLine>();

		for (int id : products) {
			Product product = productRepo.find((long) id);

			InvoiceLine invoiceLine = new InvoiceLine();

			invoiceLine.setCgst(BigDecimal.ZERO);
			invoiceLine.setSgst(BigDecimal.ZERO);

			invoiceLine.setProduct(product);
			invoiceLine.setItem(product.getCode());
			invoiceLine.setHsbn(product.getHsbn());
			invoiceLine.setPrice(product.getSalePrice());
			invoiceLine.setGstRate(product.getGstRate());

			invoiceLine.setNetAmount(invoiceLine.getPrice().multiply(new BigDecimal(invoiceLine.getQty())));

			invoiceLine
					.setGrossAmount(invoiceLine.getNetAmount().add(invoiceLine.getIgst().add(invoiceLine.getCgst())));

			invoiceProducts.add(invoiceLine);

		}

		return invoiceProducts;
	}

}
