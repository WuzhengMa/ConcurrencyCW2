import display.*;

public class Controller{

    public static int Max = 9;
    protected NumberCanvas passengers;
    public static int num_pas = 0;

    public Controller(NumberCanvas nc) {
	passengers = nc;
    }

    public synchronized void newPassenger() throws InterruptedException {
	// complete implementation                                    
        while (num_pas >= Max) wait();

        num_pas ++;
        passengers.setValue(num_pas);
        notifyAll();
    }

    public synchronized int getPassengers(int mcar) throws InterruptedException {
	// complete implementation for part I                                    
        while(num_pas <  mcar) wait();

        num_pas -= mcar;
        passengers.setValue(num_pas);
        notifyAll();
        return mcar;
    }

    public synchronized void goNow() {
	// complete implementation for part II                                       
    }

}
