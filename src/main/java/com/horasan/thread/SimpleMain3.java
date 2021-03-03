package com.horasan.thread;

public class SimpleMain3 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new DaemonWorker());
		t1.setDaemon(true);
		
		Thread t2 = new Thread(new UserWorker());
		t2.setDaemon(false);
		
		t1.start();
		t2.start();
		
		

	}

}
