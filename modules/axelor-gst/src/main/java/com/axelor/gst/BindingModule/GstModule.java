package com.axelor.gst.BindingModule;


import com.axelor.gst.MethodImplementation.SequenceImpl;

import com.axelor.app.AxelorModule;
import com.axelor.gst.MethodImplementation.InvoiceImpl;
import com.axelor.gst.MethodImplementation.InvoiceLineImpl;
import com.axelor.gst.MethodImplementation.ListOfProductsImpl;
import com.axelor.gst.ServiceMethod.CalculateInvoice;
import com.axelor.gst.ServiceMethod.InvoiceLineService;
import com.axelor.gst.ServiceMethod.ListofProducts;
import com.axelor.gst.ServiceMethod.SequenceService;
import com.axelor.gst.db.repo.InvoiceRepository;
import com.axelor.gst.db.repo.PartyRepository;
import com.axelor.gst.repo.InvoiceRepo;
import com.axelor.gst.repo.Partyrepo;





public class GstModule extends AxelorModule {
	
	@Override
	 protected void configure() {
		
		 bind(InvoiceLineService.class).to(InvoiceLineImpl.class);
		 bind(SequenceService.class).to(SequenceImpl.class);
		 bind(PartyRepository.class).to(Partyrepo.class);
		 bind(InvoiceRepository.class).to(InvoiceRepo.class);
		 bind(CalculateInvoice.class).to(InvoiceImpl.class);
		 bind(ListofProducts.class).to(ListOfProductsImpl.class);
	 }
}
