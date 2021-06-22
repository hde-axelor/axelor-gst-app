package com.axelor.gst.MethodImplementation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceLine;

public class InvoiceImplTest {

	@Test
	public void testCalculateInvoiceAmount() {

		InvoiceImpl inv = new InvoiceImpl();

		Invoice invoiceExpected = new Invoice();

		InvoiceLine invoiceLine = new InvoiceLine();
		InvoiceLine invoiceLine1 = new InvoiceLine();

		List<InvoiceLine> items = new ArrayList<InvoiceLine>();

		items.add(invoiceLine);
		items.add(invoiceLine1);

		invoiceLine.setItem("pen");
		invoiceLine1.setItem("Pencil");

		invoiceExpected.setInvoiceItems(items);

		Invoice actual = inv.calculateInvoiceAmount(invoiceExpected);

		assertEquals(invoiceExpected, actual);
		assertNotNull(invoiceExpected);

	}

	@Test
	public void SecondTestCalculateInvoiceAmount() {

		InvoiceImpl inv = new InvoiceImpl();

		Invoice invoiceExpected = new Invoice();

		
		List<InvoiceLine> items = new ArrayList<InvoiceLine>();

		invoiceExpected.setInvoiceItems(items);

		Invoice actual = inv.calculateInvoiceAmount(invoiceExpected);
		
		assertEquals(invoiceExpected, actual);
		

	}
}
