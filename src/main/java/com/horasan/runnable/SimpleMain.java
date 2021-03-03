package com.horasan.runnable;

public class SimpleMain {

	public static void main(String[] args) {
		
		// multithreading, not parallel computing.
		Thread t1 = new Thread(new Runner1());
		Thread t2 = new Thread(new Runner2());
		
		t1.start();
		t2.start();

	}

}
