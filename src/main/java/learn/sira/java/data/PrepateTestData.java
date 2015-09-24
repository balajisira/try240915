package learn.sira.java.data;

import java.util.HashMap;
import java.util.Map;

public class PrepateTestData {

	public static Map<Integer, ReportData>generateDataMap(int count){
		Map<Integer, ReportData> dataMap = new HashMap<Integer, ReportData>();
		for (int counter = 0; counter < count; counter++) {
			dataMap.put(counter, ReportData.getTestReportData(counter));
		}
		return dataMap;
	}
}
