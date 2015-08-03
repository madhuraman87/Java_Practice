package exercise2;

public class Consumer extends Thread {
	private int n;
  	private DataStore ds;
  	
  	public Consumer (int noofnum, DataStore buffer) {
  		n = noofnum;
  		ds = buffer;
    }

	public void run() {
		int value = 0;
		for (int i = 0; i < n; i++) {
			try {
				value = ds.get();
				System.out.println("Consumer: got..." + value);
			} catch (InterruptedException e) {
				return;
			}
			try {
				Thread.sleep((int) Math.random() * 100); // sleep for a randomly chosen time
			} catch (InterruptedException e) {
				return;
			}

		}
	}

}
