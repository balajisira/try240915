package learn.sira.java.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class LargeFileCreatorThread extends Thread{
	private long fileSize;
	private String filePath ;
	public static void main(String[] args) {
		LargeFileCreatorThread creatorThread = new LargeFileCreatorThread();
		System.out.println("###################START########################");
		creatorThread.run();
		System.out.println("####################END#########################");
	}
	
	
public long getFileSize() {
		return fileSize;
	}


	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


public  void run() {
	File dataFile = new File(filePath);
	FileOutputStream fileOutputStream;
	long c = fileSize;
	try {
		Date startTime =new Date();
		System.out.println(this.getName() +"\t:\tStart Time :"+startTime);
		System.out.println(this.getName() +"\t:\tProcessiog  "+filePath);
		
		fileOutputStream = new FileOutputStream(dataFile);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		String dataLine ="column 1\tcolumn 2\tcolumn 3\tcolumn 4\tcolumn 5\tcolumn 6\tcolumn 7\t";
		int milCounter=0;
		for (long counter = 0l ; counter<c ; counter++) {
			bufferedOutputStream.write((this.getName()+"\t"+counter+"\t"+dataLine+"\n").getBytes());
			if(counter %1000000 == 0){
				milCounter++;
				System.out.println(this.getName() +"\t:\tWritten :"+ milCounter + " million Records");
			}
		}
		Date endTime =new Date();
		System.out.println(this.getName() +"\t:\tEND Time :"+ endTime);
		String processedMessage = "Processed in :"+(endTime.getTime()-startTime.getTime())/1000+ " Seconds";
		System.out.println(processedMessage);
		bufferedOutputStream.write(processedMessage.getBytes());
		bufferedOutputStream.close();
		System.out.println(this.getName() +"\t:\tProcessing Completed ");
//		FileSize.printFileSize(dataFile);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
