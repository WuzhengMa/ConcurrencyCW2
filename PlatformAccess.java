

/**
 * Complete the implementation of this class in line with the FSP model
 */

public class PlatformAccess {

  /* declarations required */
    boolean occupied = false;
   
    public synchronized void arrive() throws InterruptedException {
	while(occupied) wait();
	occupied = true;
       
	
    }

    public synchronized void depart() {
	occupied = false;
	notifyAll();
    }

}