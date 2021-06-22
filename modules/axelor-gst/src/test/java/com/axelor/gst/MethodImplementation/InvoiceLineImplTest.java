package com.axelor.gst.MethodImplementation;


import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.axelor.gst.db.Address;
import com.axelor.gst.db.Company;
import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceLine;
import com.axelor.gst.db.State;
 
public class InvoiceLineImplTest {

	@Test
	public void test() {

		InvoiceLineImpl inv = new InvoiceLineImpl();

		InvoiceLine invoiceLineExpected = new InvoiceLine();

		invoiceLineExpected.setItem("Test Item");

		invoiceLineExpected.setGstRate(new BigDecimal(4));

		invoiceLineExpected.setNetAmount(new BigDecimal(100));

		Invoice invoice = new Invoice();
		Address address = new Address();
		State state = new State();
		Company company = new Company();

		invoice.setInvoiceAddress(address);
		invoice.setCompany(company);

		state.setName("Bengaluru");

		address.setState(state);

		company.setAddress(address);
		company.setName("Hitachi");

		invoiceLineExpected.setInvoice(invoice);

		InvoiceLine invoiceLineActual = inv.calculateInvoiceLine(invoiceLineExpected);

		assertEquals(invoiceLineActual, invoiceLineExpected);

	}

	@Test
	public void elsePartTest() {

		InvoiceLineImpl inv = new InvoiceLineImpl();
		InvoiceLine invoiceLineExpected = new InvoiceLine();

		invoiceLineExpected.setItem("Test case 2");
		invoiceLineExpected.setNetAmount(new BigDecimal(200));
		invoiceLineExpected.setGstRate(new BigDecimal(6));

		Invoice invoice = new Invoice();

		Address address = new Address();
		Address address1 = new Address();

		State state = new State();
		State state1 = new State();

		state.setName("Uttar Prades");
		state1.setName("Karnataka");

		address.setState(state);
		invoice.setInvoiceAddress(address);

		Company company = new Company();
		
		address1.setState(state1);
		company.setAddress(address1);
		company.setName("Samsung");
		invoice.setCompany(company);

		invoiceLineExpected.setInvoice(invoice);

		InvoiceLine actual = inv.calculateInvoiceLine(invoiceLineExpected);

		assertEquals(actual, invoiceLineExpected);

	}

}