package com.horasan.diningphilosophers;

import java.util.Random;

public class Philosopher implements Runnable {
	private int id;
	private volatile boolean stopTrying; // to terminate the thread from outside! volatile.
	private Chopstick leftChopstick;
	private Chopstick rightChopstick;
	private Random randomGenerator;
	private int eatingCounter;

	public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick) {
		this.id = id;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
		this.randomGenerator = new Random(); 
		eatingCounter = 0;
	}

	public void think() throws InterruptedException {
		System.out.println("Philosopher " + id + " is thinking ...");
		Thread.sleep(randomGenerator.nextInt(1000)); // between 0 and 1000 ms.
	} 

	public void eat() throws InterruptedException {
		System.out.println("Philosopher " + id + " is eating ...");
		eatingCounter = eatingCounter + 1;
		Thread.sleep(randomGenerator.nextInt(1000)); // between 0 and 1000 ms.
	}

	public void setStopTrying(boolean stopTrying) {
		this.stopTrying = stopTrying;
	}

	public boolean getStopTrying() {
		return stopTrying;

	}
	
	public int getEatingCounter() {
		return eatingCounter;
	}

	@Override
	public String toString() {
		return "" + id;
	}
	
	@Override
	public void run() {

		try {
			while (!stopTrying) {
				// start with thinking
				think();
				
				if (leftChopstick.pickUp(this, ChopstickState.LEFT)) {
					System.out.println("Philosopher " + this.id + " picked up the LEFT chopstick ...");
					if (leftChopstick.pickUp(this, ChopstickState.LEFT)) {
						System.out.println("Philosopher " + this.id + " picked up the RIGHT chopstick ...");
						eat();
						leftChopstick.putDown(this, ChopstickState.RIGHT);
					}
					
					leftChopstick.putDown(this, ChopstickState.LEFT);
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
