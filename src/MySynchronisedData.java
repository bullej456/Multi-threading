package uk.co.diegesis.edward.GT1;

public class MySynchronisedData {
	
	long myProtectedInt = 0;
	
	public synchronized void incrementMyValue() {
		myProtectedInt++;
		System.out.println(myProtectedInt);
	}

	public synchronized void decrementMyValue() {
		myProtectedInt--;
		System.out.println(myProtectedInt);
	}
}
