package com.horasan.diningphilosophers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

	private int id;
	private Lock lock; // concurrency, avoid deadlock!
	
	
	public Chopstick(int id) {
		this.id = id;
		lock = new ReentrantLock();
		
	}
	
	public boolean pickUp(Philosopher phi, ChopstickState state) throws InterruptedException {
		
		if(lock.tryLock(10, TimeUnit.MILLISECONDS)) {
			System.out.println(phi.toString() + " picked up the " + state.toString() +" chopstick with id:" + this.id);
			return true;
		}
		
		return false;
	}
	
	public void putDown(Philosopher phi, ChopstickState state) {
		lock.unlock(); // other Philosopher can now pickUp this.
		System.out.println(phi.toString() + " put down the " + state.toString() +" chopstick with id:" + this.id);
	}
	
}
