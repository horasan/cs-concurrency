package com.horasan.wait_and_notify;

import java.util.ArrayList;
import java.util.List;

public class Processor {
	
	private List<Integer> list = new ArrayList<>();
	private static final int UPPER_LIMIT = 5;
	private static final int LOWER_LIMIT = 0;
	private final Object lock = new Object();
	private int value = 0;
	
	public void producer() throws InterruptedException {
		
		synchronized (lock) {
			while(true) {
				if (list.size() == UPPER_LIMIT) {
					System.out.println("Finished populating list. Waitin for the consumer!");
					lock.wait();
				} 
				else {
					list.add(value);
					System.out.println("Producer added: " + value);
					value = value + 1;
					lock.notify();
				}
				
				Thread.sleep(500);
			}
		}
	}
	
	public void consumer() throws InterruptedException {
		
		synchronized (lock) {
			while(true) {
				if (list.size() == LOWER_LIMIT) {
					System.out.println("Finished removing list. Waitin for the producer!");
					value = 0;
					lock.wait();
				} 
				else {
					System.out.println("Consumer removed: " + list.remove(list.size() - 1));
					lock.notify();
				}
				Thread.sleep(500);
			}
		}
	}
}
