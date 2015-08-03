package exercise2;

public class Producer extends Thread {
	private int n;
  	private DataStore ds;
  	
  	public Producer (int noofnum, DataStore buffer) {
  		n = noofnum;
  		ds = buffer;
    }
    
    public void run() {
    	for (int i = 0; i < n; i++) {
    		try {
    			Thread.sleep( (int) Math.random() * 100); // sleep for a randomly chosen time
    		} catch (InterruptedException e) {return;}
    		
    	    try {
    	    	int val = (int)(Math.random() * (100 - i)); // generate random number between 0 and 100
    	    	ds.put(val); 
    	    	System.out.println("Producer: put..." + val);
    	    } catch (InterruptedException e) {return;}
    		
    	}
    }

}
