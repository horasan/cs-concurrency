package com.horasan.thread;

public class DaemonWorker implements Runnable{

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Daemon is working in an infinite loop!");
		}
		
	}

}
