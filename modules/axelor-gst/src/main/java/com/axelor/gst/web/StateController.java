package com.axelor.gst.web;

import javax.persistence.PersistenceException;

import com.axelor.gst.xml.XMLImport;
import com.axelor.inject.Beans;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class StateController {

	public void importXmlData(ActionRequest request, ActionResponse response) {
		try {
			Beans.get(XMLImport.class).xmlTest();
		} catch (Exception e) {
			throw new PersistenceException("Model not found");
		}

		response.setFlash("Successful");

	}

}
