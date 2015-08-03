package exercise2;

/**
 * 
Exercise 2 
 
Please write a program that does the following: 
 
1. A Producer class produces a randomly generated number 
2. The Producer class stores this number into a DataStore class, which has a limited 
capacity 
3. A Consumer class consumes a number from the DataStore class and displays it to 
System.out. 
 
The program should run until the Producer produces 100 numbers. The DataStore should have 
a maximum capacity of 10. The Producer and Consumer should be running in parallel, in other 
words, the Consumer should be able to consume numbers before the Producer is done 
producing all 100 numbers. 
 * 
 */

public class ProdConsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataStore buffer = new DataStore();
	    
	    // create new threads
	    Thread producer = new Producer(100, buffer);
	    Thread consumer = new Consumer(100, buffer);
	    
	    // starting threads
	    producer.start();
	    consumer.start();
	    
	    // Wait for the threads to finish
	    try {
	    	producer.join();
	    	consumer.join();
	    } catch (InterruptedException e) {
	    	return;
	    }
	}
}

