package com.axelor.gst.MethodImplementation;

import com.axelor.common.StringUtils;
import com.axelor.gst.ServiceMethod.SequenceService;
import com.axelor.gst.db.Sequence;
import com.axelor.gst.db.repo.SequenceRepository;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class SequenceImpl implements SequenceService {
	
	@Inject SequenceRepository sequenceRepo;

	@Override
	public String getNextNo(Sequence sequence) {

		StringBuilder builder = new StringBuilder();

		if (StringUtils.notEmpty(sequence.getPrefix()))
			builder.append(sequence.getPrefix());

		for (int i = 0; i < sequence.getPadding(); i++) {
			if (i == sequence.getPadding() - 1) {
				builder.append("1");

			} else {
				builder.append("0");
			}
		}

		if (StringUtils.notEmpty(sequence.getSuffix())) {
			builder.append(sequence.getSuffix());
		}
		return builder.toString();
	}

	@Override
	public void updateNextNo(Sequence sequence) {
		StringBuilder newNumber = new StringBuilder();
		String oldNumber = sequence.getNextNumber();
		newNumber.append(sequence.getPrefix());
		long number = Long.parseLong(oldNumber.substring(sequence.getPrefix().length(),sequence.getPrefix().length() + sequence.getPadding())) + 1;
		long numSize = String.valueOf(number).length();
		for (int i = 0; i < sequence.getPadding(); i++)
			newNumber.append((i == sequence.getPadding() - numSize) ? number : "0");
		if (sequence.getSuffix() != null)
			newNumber.append(sequence.getSuffix());
		sequence.setNextNumber(newNumber.toString());
		sequenceRepo.save(sequence);
	}

}