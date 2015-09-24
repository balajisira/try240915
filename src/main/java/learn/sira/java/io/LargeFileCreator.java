package learn.sira.java.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class LargeFileCreator {
public static void main(String[] args) {
	long limit = 10000000l*10;
	String filePath = "c:/dev/work/files/hugeData_3_"+(limit/1000000)+".txt";
	File dataFile = new File(filePath);
	FileOutputStream fileOutputStream;
	try {
		Date startTime =new Date();
		System.out.println("Start Time :"+startTime);
		fileOutputStream = new FileOutputStream(dataFile);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		String dataLine ="column 1\tcolumn 2\tcolumn 3\tcolumn 4\tcolumn 5\tcolumn 6\tcolumn 7\t";
		int milCounter=0;
		for (long counter = 0l ; counter<limit ; counter++) {
			bufferedOutputStream.write((counter+"\t"+dataLine+"\n").getBytes());
			if(counter %1000000 == 0){
				milCounter++;
				System.out.println("Written :"+ milCounter + " million Records");
			}
		}
		Date endTime =new Date();
		System.out.println("END Time :"+ endTime);
		String processedMessage = "Processed in :"+(endTime.getTime()-startTime.getTime())/1000+ " Seconds";
		System.out.println(processedMessage);
	//	bufferedOutputStream.write(processedMessage.getBytes());
		bufferedOutputStream.close();
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
