package com.axelor.gst.db.repo;

import javax.persistence.PersistenceException;

import com.axelor.gst.Service.SequenceService;
import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.Sequence;
import com.axelor.inject.Beans;
import com.axelor.meta.db.MetaModel;
import com.axelor.meta.db.repo.MetaModelRepository;
import com.google.inject.Inject;

public class InvoiceRepo extends InvoiceRepository{
        
	@Inject SequenceRepository sequenceRepository;
	@Inject SequenceService sequenceService;
	
	@Override
	    public Invoice save(Invoice invoice) {
	    
		try {
		if(invoice.getReference() == null) {
			
			MetaModel model = Beans.get(MetaModelRepository.class).findByName(invoice.getClass().getSimpleName());
			Sequence  sequenceInvoice = sequenceRepository.findByModel(model);
			
			invoice.setReference(sequenceInvoice.getNextNumber());
			sequenceService.updateNextNo(sequenceInvoice);
			
			
		}
			return super.save(invoice);
		} catch(Exception e) {
			throw new PersistenceException("Model Not Found");
	}
		  
	}
}