package learn.sira.java.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import learn.sira.java.data.PrepateTestData;
import learn.sira.java.data.ReportData;

public class LargeFileProcessor {

	private String inputFilePath;
	private String outPuFilePath;
	long processingSLA;
	
	private FileOutputStream fileOutputStream;
	private BufferedReader bufferedReader;
	public static void main(String[] args) {
		
		Date start = new Date();
		LargeFileProcessor fileProcessor = new LargeFileProcessor();
		String basePath ="c:/dev/work/files/";
				
		fileProcessor.setInputFilePath(basePath+"hugeData_3_100.txt");
		fileProcessor.setOutPuFilePath(basePath+"hugeData_3_100_processed.txt");
		try {
			fileProcessor.doAllTheStuffRequiredBeforeCallingUsefullMethod_simply_init();
			fileProcessor.processFile();
			fileProcessor.doCleanUpStuff();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date end = new Date();
		long processingTime = end.getTime() - start.getTime();
		System.out.println("DONE Processing in (Milli Sec) :" +processingTime);
	}
	private void doCleanUpStuff() throws IOException {
		bufferedReader.close();
		fileOutputStream.close();
		
	}
	private void doAllTheStuffRequiredBeforeCallingUsefullMethod_simply_init() throws FileNotFoundException{
		prepareFileInputStream(inputFilePath);
		prepareFileOuputStream(outPuFilePath);
	}
	
	public void processFile(){
		try {
			String data = bufferedReader.readLine();
			long flushCounter = 0;
			Map<Integer, ReportData> dataMap = PrepateTestData.generateDataMap(30);
			while ((data = bufferedReader.readLine()) != null) {
				StringTokenizer stringTokenizer = new StringTokenizer(data, "\t");
				StringBuffer processedDataString =new StringBuffer();
				Map dataRecordMap = new HashMap<Integer, String>();
				int i = 1;
				while (stringTokenizer.hasMoreElements()) {
					dataRecordMap.put(i, stringTokenizer.nextElement());
					i++;
					
				}
				String keyString = (String)dataRecordMap.get(1);
				if(keyString== null )break;
				Integer key = new Integer(keyString)%30;
				ReportData dataObject = dataMap.get(key);
				
				processedDataString.append(dataRecordMap.get(2)).append("\t");
				processedDataString.append(dataObject.getId()).append("\t");
				processedDataString.append(dataRecordMap.get(3)).append("\t");
				processedDataString.append(dataObject.getcData4()).append("\t");
				processedDataString.append(dataRecordMap.get(4)).append("\t");
				processedDataString.append(dataObject.getcData2()).append("\t");
				processedDataString.append(dataObject.getName()).append("\t");
				processedDataString.append(dataRecordMap.get(4)).append("\t");
				processedDataString.append(dataRecordMap.get(5)).append("\t");
				processedDataString.append(dataRecordMap.get(6)).append("\t");
				
				processedDataString.append("\n");				
				fileOutputStream.write(processedDataString.toString().getBytes());
				if(flushCounter % 500000 ==0){
				fileOutputStream.flush();
				}
				flushCounter++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private String  addEOL(String data) {
		return data= data+"\n"; 		
	}

	private void prepareFileInputStream(String inputPath) throws FileNotFoundException{
		bufferedReader = new BufferedReader(new FileReader(inputPath));
	}
	
	private void prepareFileOuputStream(String outPutPath) throws FileNotFoundException{
		fileOutputStream = new FileOutputStream(outPutPath);
	}
	public String getInputFilePath() {
		return inputFilePath;
	}
	public void setInputFilePath(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}
	public String getOutPuFilePath() {
		return outPuFilePath;
	}
	public void setOutPuFilePath(String outPuFilePath) {
		this.outPuFilePath = outPuFilePath;
	}
	public long getProcessingSLA() {
		return processingSLA;
	}
	public void setProcessingSLA(long processingSLA) {
		this.processingSLA = processingSLA;
	}
	public FileOutputStream getFileOutputStream() {
		return fileOutputStream;
	}
	public void setFileOutputStream(FileOutputStream fileOutputStream) {
		this.fileOutputStream = fileOutputStream;
	}
	public BufferedReader getBufferedReader() {
		return bufferedReader;
	}
	public void setBufferedReader(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}
	
}
