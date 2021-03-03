package com.horasan.runnable;

public class Runner1 implements Runnable {
	
	@Override
	public void run() {
		for(int a = 0; a < 10; a++) {
			System.out.println("Runner1: " + a);
		}
		
	}

}
