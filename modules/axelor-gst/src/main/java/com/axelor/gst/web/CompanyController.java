package com.axelor.gst.web;

import javax.persistence.PersistenceException;

import com.axelor.gst.csv.CSVImport;
import com.axelor.inject.Beans;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class CompanyController {
	
	


	public void importData(ActionRequest request, ActionResponse response) {
		try {
			Beans.get(CSVImport.class).testCsv();
		} catch (Exception e) {
			throw new PersistenceException("Data not Found");
		}
		
		response.setFlash("Successful");
	}
}
