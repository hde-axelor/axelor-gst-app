package com.axelor.gst.xml;


import com.axelor.data.Listener;
import com.axelor.data.xml.XMLImporter;
import com.axelor.db.Model;
import com.axelor.gst.Service.XMLImportService;

public class XMLImport implements XMLImportService {

	@Override
	public void xmlTest() {

		XMLImporter importer = new XMLImporter(
				"/home/axelor/Projects/axelor-gst-app/modules/axelor-gst/data-demo/xml-config.xml",
				"/home/axelor/Projects/axelor-gst-app/modules/axelor-gst/data-demo/xml");

		importer.addListener(new Listener() {

			@Override
			public void imported(Integer total, Integer success) {
				// TODO Auto-generated method stub
				System.out.println("Total Records : " + total);
				System.out.println("Success Records : " + success);
			}

			@Override
			public void imported(Model bean) {
			}

			@Override
			public void handle(Model bean, Exception e) {
			}
		});
		importer.run();
	}

}
