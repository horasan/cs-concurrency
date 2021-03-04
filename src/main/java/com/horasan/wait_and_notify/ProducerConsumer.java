package com.horasan.wait_and_notify;

public class ProducerConsumer {
	public void produce() throws InterruptedException {
		
		synchronized(this) {
			System.out.println("in produce 1");
			wait(); // released the intrisinc (monitor) lock. Now in WAITING state.
			System.out.println("in produce 2");
		}

	}
	public void consume() throws InterruptedException {
		
		Thread.sleep(1000); // so produce will be called first.
		synchronized(this) {
			System.out.println("in consume 1");
			notify(); // sends a signal to threads which are in WAITING state for the monitor lock of the this object!
			System.out.println("But following  lins are also executed. Waiting for 5 seconds.");
			Thread.sleep(5000);
			// Other WAITING threads will not start working immediately. This synchronized block will finish first.
		}

	}	
	
}
