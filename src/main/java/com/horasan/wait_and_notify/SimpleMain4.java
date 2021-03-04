package com.horasan.wait_and_notify;

public class SimpleMain4 {

	public static void main(String[] args) {
		
		ProducerConsumer pc = new ProducerConsumer();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.consume();
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
					pc.produce();
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
