package uk.co.diegesis.edward.GT1;

public class MyThread extends Thread {
	
	private boolean isStarted = true;
	private boolean isExiting = false;
	
	private MySynchronisedData msData = null;
	
	public MyThread(MySynchronisedData msData) {
		this.msData = msData;
	}
	
	public void run() { 
		
        while(!isExiting) {
        	try { 
                Thread.sleep(DataClass.THREAD_SLEEP);
                
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            }
        	
        	msData.incrementMyValue();
        }
        
        isStarted = false;
        return;
    }
	
	public void setExit() {
		isExiting = true;
		return;
	}
	
	public boolean getIsStarted() {
		return isStarted;
	}

}
