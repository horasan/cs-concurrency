package com.horasan.wait_and_notify;

public class SimpleMain5 {

	public static void main(String[] args) {
		Processor p = new Processor();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					p.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					p.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		t1.start();
		t2.start();

	}

}
