package com.horasan.thread;

public class Runner2 extends Thread{
	@Override
	public void run() {
		for(int a = 0; a < 10; a++) {
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Runner2: " + a);
		}
	}
	
}

