package com.horasan.thread;

public class SimpleMain2 {
	public static void main(String[] args) {
		Thread t1 = new Runner1();
		Thread t2 = new Runner2();
		
		t1.start();
		t2.start();
	}
}
