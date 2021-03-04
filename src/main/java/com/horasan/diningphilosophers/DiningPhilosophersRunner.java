package com.horasan.diningphilosophers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiningPhilosophersRunner {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService es = null;
		Philosopher[] philosophers = null;
		Chopstick[] chopsticks = null;
		
		try {
			philosophers = new Philosopher[SystemConstants.NUMBER_OF_PHILOSOPHERS];
			chopsticks = new Chopstick[SystemConstants.NUMBER_OF_CHOPSTICKS];
			es = Executors.newFixedThreadPool(SystemConstants.NUMBER_OF_PHILOSOPHERS);
			
			for(int i = 0; i <SystemConstants.NUMBER_OF_CHOPSTICKS; i++) {
				chopsticks[i] = new Chopstick(i);
			}
			
			for(int i = 0; i <SystemConstants.NUMBER_OF_PHILOSOPHERS; i++) {
				philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i+1)%SystemConstants.NUMBER_OF_CHOPSTICKS]);
			}
			
			for(int i = 0; i <SystemConstants.NUMBER_OF_PHILOSOPHERS; i++) {
				es.execute(philosophers[i]);
			}
			
			Thread.sleep(SystemConstants.RUNNING_TIME);
			
			for(int i = 0; i <SystemConstants.NUMBER_OF_PHILOSOPHERS; i++) {
				philosophers[i].setStopTrying(true); // stop all threads.
			}
			
		}
		finally {
			es.shutdown(); // stop all the threads.
			
			if (!es.isTerminated()) {
				Thread.sleep(2000); // wait a bit for them to shutdown.
			}
			
			for(int i = 0; i <SystemConstants.NUMBER_OF_PHILOSOPHERS; i++) {
				System.out.println("Philosophers " + i  + " eats " + philosophers[i].getEatingCounter() + " times ...");
			}
			
		}

	}

}
