package com.axelor.gst.MethodImplementation;

import java.math.BigDecimal;
import java.util.List;

import com.axelor.gst.ServiceMethod.CalculateInvoice;
import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceLine;;

public class InvoiceImpl implements CalculateInvoice {

	@Override
	public Invoice calculateInvoiceAmount(Invoice invoice) {

		BigDecimal netAmount = BigDecimal.ZERO;
		BigDecimal netIgst = BigDecimal.ZERO;
		BigDecimal netCgst = BigDecimal.ZERO;
		BigDecimal netSgst = BigDecimal.ZERO;
		BigDecimal grossAmount = BigDecimal.ZERO;

		List<InvoiceLine> itemList = invoice.getInvoiceItems();
		for (InvoiceLine item : itemList) {

			netAmount = netAmount.add(item.getNetAmount());
			netIgst = netIgst.add(item.getIgst());
			netCgst = netCgst.add(item.getCgst());
			netSgst = netSgst.add(item.getSgst());
			grossAmount = grossAmount.add(item.getGrossAmount());
		}
		invoice.setNetAmount(netAmount);
		invoice.setNetCgst(netCgst);
		invoice.setNetIgst(netIgst);
		invoice.setNetSgst(netSgst);
		invoice.setGrossAmount(grossAmount);

		return invoice;
	}

}
