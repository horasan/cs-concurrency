package com.horasan.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleMainReentrant {

	public static int counter = 0;

	public static void increment() {

		lock.lock(); // BEGIN: same as syncronized keyword

		try {
			for (int a = 0; a < 100; a++) {
				counter++;
			}
		} finally {
			// if for loop throw an exception then we must release the lock.
			lock.unlock(); // END: same as syncronized keyword
		}

	}

	public static Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				increment();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				increment();

			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Current value: "  + counter);

	}

}
