package com.axelor.gst.web;

import com.axelor.gst.Service.SequenceService;
import com.axelor.gst.db.Sequence;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;

public class SequenceController {

	@Inject
	SequenceService sequenceService;

	public void getNextNumber(ActionRequest request, ActionResponse response) {

		Sequence sequence = request.getContext().asType(Sequence.class);

		String str = sequenceService.getNextNo(sequence);

		response.setValue("nextNumber", str);

	}

}
