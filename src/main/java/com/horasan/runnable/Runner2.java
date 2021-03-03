package com.horasan.runnable;

public class Runner2 implements Runnable {
	
	@Override
	public void run() {
		for(int a = 0; a < 10; a++) {
			System.out.println("Runner2: " + a);
		}
		
	}

}