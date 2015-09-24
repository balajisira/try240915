package learn.sira.java.io;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class LargeFileCreatorProcessor {
public static void main(String[] args) {
	int threadNumber = 0;
	String threadName ;
	Set<LargeFileCreatorThread> threadSet = new HashSet<LargeFileCreatorThread>();
		for (int counter = 0; counter < 10; counter++) {
			LargeFileCreatorThread thread = new LargeFileCreatorThread();
			threadName = "_"+counter;
			thread.setName(threadName);
			thread.setFileSize(20000000l); ///file size for each thread 
			thread.setFilePath ("c:/dev/work/files/parallel_hugeData_"+(thread.getFileSize()/1000000)+"_.txt");
			threadSet.add(thread);
		}
		for (LargeFileCreatorThread largeFileCreatorThread : threadSet) {
			largeFileCreatorThread.start();
			}
		
		
}
}
