package problem.solving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ProducerConsumer {
	private static final int NUMBER_OF_PRODUCERS = 5;
	
	private static final int NUMBER_OF_CONSUMERS = 5;
	
	private static final int TASK_REPETATIONS = 5; // change it to 100
	
	public static void main(String[] args){

		final List<List<Integer>> sharedUnSortedList = Collections.synchronizedList(new ArrayList<List<Integer>>());

		final List<List<Integer>> sharedSortedList = Collections.synchronizedList(new ArrayList<List<Integer>>());
		
		Thread consumer = null;
		for(int i=0; i < NUMBER_OF_CONSUMERS; i++){
			consumer = new Thread(new Consumer(sharedSortedList, sharedUnSortedList));
			consumer.start();		
			
		}
		
		Thread producer;
		for(int i=0; i < NUMBER_OF_PRODUCERS; i++){
			producer= new Thread(new Producer(TASK_REPETATIONS,sharedUnSortedList));
			producer.start();			
		}
	}
}

class Producer implements Runnable {
	private final int repeats;

	private final List<List<Integer>> sharedUnSortedList;
	
	public Producer(int repeats, final List<List<Integer>> sharedUnSortedList) {
		this.repeats = repeats;
		this.sharedUnSortedList = sharedUnSortedList;
	}

	@Override
	public void run() {
		for (int i = 0; i < repeats; i++) {
			synchronized (sharedUnSortedList) {
				sharedUnSortedList.add(generateRandomArray(10));
				sharedUnSortedList.notifyAll();
				System.out.println(String.format("%s Producer - Task create for Consumer", Thread.currentThread().getName()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.err.println(e);
				}
			}
		}
	}

	public List<Integer> generateRandomArray(int n) {
		List<Integer> randomNumbers = new ArrayList<>(n);
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			randomNumbers.add(random.nextInt(100));
		}
	return randomNumbers;
	}
}

class Consumer implements Runnable {
	private final List<List<Integer>> sharedSortedList;
	
	private final List<List<Integer>> sharedUnSortedList;	
	
	public Consumer(final List<List<Integer>> sharedSortedList, final List<List<Integer>> sharedUnSortedList){
		this.sharedSortedList = sharedSortedList;
		this.sharedUnSortedList = sharedUnSortedList;
	}
	
	@Override
	public void run() {
		synchronized (sharedUnSortedList) {
			while (sharedUnSortedList.isEmpty()) {
				try {
					System.out.println(String.format("%s -  No Lists to sort! - Waiting for prodcuer.",	Thread.currentThread().getName()));
					sharedUnSortedList.wait();

				} catch (InterruptedException e) {
					System.err.println("Thread Intrrupted - " + e);
				}
			}
			for (Iterator<List<Integer>> iterator = sharedUnSortedList.iterator(); iterator.hasNext();) {
				List<Integer> unsortedList = iterator.next();
				iterator.remove();
				//Collections.sort(unsortedList);
				sharedSortedList.add(bubbleSort(unsortedList));				
				System.out.println(String.format("%s Consumer - List Sorted %s", 	Thread.currentThread().getName(),unsortedList));
			}
		}
	}
	
	public List<Integer> bubbleSort(List<Integer> unsortedList) {
		int temp = 0;
		if (!unsortedList.isEmpty()) {
			int size = unsortedList.size();
			for (int i = 0; i < size-1; i++) {
				for (int j = 0; j < (size -i -1); j++) {
					if (unsortedList.get(j).compareTo(unsortedList.get(j + 1)) > 0) {
						temp = unsortedList.get(j);
						unsortedList.set(j, unsortedList.get(j + 1));
						unsortedList.set(j + 1, temp);
					}
				}
			}
		}
		return unsortedList;
	}
}