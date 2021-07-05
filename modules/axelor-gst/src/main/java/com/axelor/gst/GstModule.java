package com.axelor.gst;


import com.axelor.gst.Service.InvoiceService;
import com.axelor.gst.Service.CSVImportService;
import com.axelor.gst.Service.InvoiceLineService;
import com.axelor.gst.Service.ListofProductsService;
import com.axelor.gst.Service.SequenceService;
import com.axelor.gst.Service.XMLImportService;
import com.axelor.gst.csv.CSVImport;
import com.axelor.app.AxelorModule;
import com.axelor.gst.db.repo.InvoiceRepo;
import com.axelor.gst.db.repo.InvoiceRepository;
import com.axelor.gst.db.repo.PartyRepository;
import com.axelor.gst.db.repo.Partyrepo;
import com.axelor.gst.service.impl.InvoiceServiceImpl;
import com.axelor.gst.service.impl.InvoiceLineServiceImpl;
import com.axelor.gst.service.impl.ListOfProductsServiceImpl;
import com.axelor.gst.service.impl.SequenceServiceImpl;
import com.axelor.gst.xml.XMLImport;





public class GstModule extends AxelorModule {
	
	@Override
	 protected void configure() {
		
		 bind(InvoiceLineService.class).to(InvoiceLineServiceImpl.class);
		 bind(SequenceService.class).to(SequenceServiceImpl.class);
		 bind(PartyRepository.class).to(Partyrepo.class);
		 bind(InvoiceRepository.class).to(InvoiceRepo.class);
		 bind(InvoiceService.class).to(InvoiceServiceImpl.class);
		 bind(ListofProductsService.class).to(ListOfProductsServiceImpl.class);
		 bind(CSVImportService.class).to(CSVImport.class);
		 bind(XMLImportService.class).to(XMLImport.class);
	 }
}
