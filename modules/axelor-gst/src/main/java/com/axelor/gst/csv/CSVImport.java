package com.axelor.gst.csv;

import java.io.File;
import java.io.IOException;
import com.axelor.data.ImportTask;
import com.axelor.data.csv.CSVImporter;
import com.axelor.gst.Service.CSVImportService;

public class CSVImport implements CSVImportService {

	@Override
	public void testCsv() {

		CSVImporter csvImporter = new CSVImporter(
				"/home/axelor/Projects/axelor-gst-app/modules/axelor-gst/data-demo/input-config.xml");

		File file = new File("/home/axelor/Projects/axelor-gst-app/modules/axelor-gst/data-demo/inputs/gst_city.csv");

		csvImporter.run(new ImportTask() {

			@Override
			public void configure() throws IOException {
				input("[gst]", file);

			}
		});

	}

}
