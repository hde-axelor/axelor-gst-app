package com.axelor.gst.MethodImplementation;

import java.math.BigDecimal;

import javax.persistence.PersistenceException;

import com.axelor.gst.ServiceMethod.InvoiceLineService;
import com.axelor.gst.db.InvoiceLine;

public class InvoiceLineImpl implements InvoiceLineService {

	@Override
	public InvoiceLine calculateInvoiceLine(InvoiceLine invoiceLine) {

		invoiceLine.setNetAmount(invoiceLine.getPrice().multiply(new BigDecimal(invoiceLine.getQty())));

		try {

			if (invoiceLine.getInvoice().getCompany().getAddress().getState()
					.equals(invoiceLine.getInvoice().getInvoiceAddress().getState())) {

				invoiceLine.setCgst(BigDecimal.ZERO);
				invoiceLine.setSgst(BigDecimal.ZERO);

				invoiceLine.setSgst(
						(invoiceLine.getNetAmount().multiply(invoiceLine.getGstRate()).divide(new BigDecimal(100)))
								.divide(new BigDecimal(2)));
				invoiceLine.setCgst(
						(invoiceLine.getNetAmount().multiply(invoiceLine.getGstRate()).divide(new BigDecimal(100)))
								.divide(new BigDecimal(2)));

			} else {

				invoiceLine.setIgst(
						invoiceLine.getNetAmount().multiply(invoiceLine.getGstRate()).divide(new BigDecimal(100)));
			}

			invoiceLine
					.setGrossAmount(invoiceLine.getNetAmount().add(invoiceLine.getIgst().add(invoiceLine.getCgst())));

			return invoiceLine;
		} catch (Exception e) {
			throw new PersistenceException("Please Fill The Party Contact Details First");
		}
	}

}
