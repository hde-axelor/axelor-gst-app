package com.axelor.gst.db.repo;

import javax.persistence.PersistenceException;

import com.axelor.gst.Service.SequenceService;
import com.axelor.gst.db.Party;
import com.axelor.gst.db.Sequence;
import com.axelor.inject.Beans;
import com.axelor.meta.db.MetaModel;
import com.axelor.meta.db.repo.MetaModelRepository;
import com.google.inject.Inject;

public class Partyrepo extends PartyRepository {

	@Inject
	SequenceRepository SequenceRepository;
	
	@Inject SequenceService sequenceService;

	@Override
	public Party save(Party party) {
		try {
			if (party.getReference() == null) {
				MetaModel model = Beans.get(MetaModelRepository.class).findByName(party.getClass().getSimpleName());
				Sequence sequenceParty = SequenceRepository.findByModel(model);
				party.setReference(sequenceParty.getNextNumber());
				sequenceService.updateNextNo(sequenceParty);
				
			}

			return super.save(party);
		} catch (Exception e) {
			throw new PersistenceException("Model not found");
		}
	}
	
	

}
