package com.bufigol.toolboxes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bufigol.constants.INT_CONST_FILEPATHS;

public class UniversalCSVReaderAndWriter {
	public static List<Map<String, String>> readCSV(String filePath) {
		List<Map<String, String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line = br.readLine();
			String[] headers = line.split(";");
			String[] values = TextToolbox.emptyTextArrayInizializer(headers.length);
			while (((line = br.readLine()) != null) || (line == "")) {
				String[] paso = line.split(";");

				Logger.logInfo(line, INT_CONST_FILEPATHS.LOG_PATH);
				for (int i = 0; i < paso.length; i++) {
					values[i] = TextToolbox.removerCaracteresEspeciales(paso[i]);
				}
				Map<String, String> record = new HashMap<>();
				for (int i = 0; i < headers.length; i++) {
					record.put(headers[i], values[i]);
				}
				records.add(record);
			}
		} catch (IOException e) {
			;
			e.printStackTrace();
		}
		return records;
	}

}
