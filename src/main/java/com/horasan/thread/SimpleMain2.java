package com.horasan.thread;

public class SimpleMain2 {
	public static void main(String[] args) {
		Thread t1 = new Runner1(); //sleeps 10 ms
		Thread t2 = new Runner2(); //sleeps 1000 ms
		
		t1.start();
		t2.start();
		
		
		try {
			t1.join(); // wait until t1 is in DEAD (TERMINATED) status.
			System.out.println("Status of thread 1: " + t1.getState().name());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Thread 1 is guaranteed but not thread 2.");
	}
}
