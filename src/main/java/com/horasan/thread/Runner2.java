package com.horasan.thread;

public class Runner2 extends Thread{
	@Override
	public void run() {
		for(int a = 0; a < 10; a++) {
			System.out.println("Runner2: " + a);
		}
	}
	
}

