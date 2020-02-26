package uk.co.diegesis.edward.GT1;

import java.util.ArrayList;

public class ThreadManager {
	
	ArrayList<MyThread> threads = null;
	MySynchronisedData msData = null;
	
	int numOfThreads = DataClass.THREAD_NUM;
	
	public void runMyThreads(){
		threads = new ArrayList<MyThread>();
		msData = new MySynchronisedData();
		
		for(int i = 0; i < numOfThreads; i++) {
			threads.add(new MyThread(msData));
		}
		for(MyThread t: threads) {
			t.start();
		}
		System.out.println("All threads started.");
		
		try {
			System.out.println("Going into 20 second sleep...");
			Thread.sleep(DataClass.MAIN_THREAD_SLEEP);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished sleep.");
		
		for(MyThread t: threads) {
			t.setExit();
		}
		
		boolean allExited;
		do {
			allExited = true;
			for(MyThread t: threads) {
				allExited &= !t.getIsStarted();
			}
		} while (!allExited);
		
		System.out.println("All threads exited.");
		System.out.println("Result: " + msData.myProtectedInt);
		
	}

}
