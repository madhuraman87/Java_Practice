package exercise2;

public class DataStore {
	
	private int contents;
	private int limit = 0;

	public synchronized void put(int i) throws InterruptedException {
		while (limit > 10) { // wait till the buffer becomes empty
			try {
				wait();
			} catch (InterruptedException e) {
				throw e;
			}
		}
		contents = i;
		limit++;		
		notify();
	}

	public synchronized int get() throws InterruptedException {
		while (limit == 0) { // wait till something is put in the buffer
			try {
				wait();
			} catch (InterruptedException e) {
				throw e;
			}
		}
		limit--;
		notify();
		int val = contents;
		
		return val;
	}

}
