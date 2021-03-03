package com.horasan.thread;

public class Runner1 extends Thread{
	@Override
	public void run() {
		for(int a = 0; a < 10; a++) {
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Runner1: " + a);
		}
	}
	
}
