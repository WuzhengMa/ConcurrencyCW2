

/**
 * Complete the implementation of this class in line with the FSP model
 */

import display.*;

public class Controller {
    
    public static int Max = 9;
    protected NumberCanvas passengers;

  // declarations
    public static int num_pas = 0;
    boolean go_flag = false;

    public Controller(NumberCanvas nc) {
      passengers = nc;
    }

    public synchronized void newPassenger() throws InterruptedException {

	while (num_pas >= Max) wait();	//wait if there is more people than Max
	
	num_pas ++;
	passengers.setValue(num_pas);
	notifyAll();
    }

    public synchronized int getPassengers(int mcar) throws InterruptedException {
	
	while(num_pas < mcar && !go_flag) wait();	
       
	if(go_flag){
	    go_flag = false;
	    mcar = num_pas;	//update the number of passengers on car on the screen
	    num_pas = 0;
	    passengers.setValue(num_pas);
	    notifyAll();
	}else{
	    num_pas -= mcar;
	    passengers.setValue(num_pas);
	    notifyAll();
	}
	return mcar; 
    }

    public synchronized void goNow(){
	// complete implementation for part II
	if(num_pas > 0){
	    go_flag = true;
	}
	notifyAll();
    }

}
