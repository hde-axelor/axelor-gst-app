package com.axelor.gst.ServiceMethod;

import com.axelor.gst.db.Sequence;

public interface SequenceService {
    
	 public String getNextNo(Sequence sequence); 
	 public void updateNextNo(Sequence sequence);
	 
}
