package com.axelor.gst.Service;

import com.axelor.gst.db.Sequence;

public interface SequenceService {
    
	 public String getNextNo(Sequence sequence); 
	 public void updateNextNo(Sequence sequence);
	 
}
