package thread;

//This code is for learn the join method

class PriorityThread extends Thread{
	
	public void run() {
		int sum = 0;
		
		Thread t = Thread.currentThread();		// currentThread
		System.out.println(t + "start");
		
		for(int i=0; i<10000000; i++) {
			sum += i;
		}
		
		System.out.println("number " + t.getPriority()+"Thread end");
	}
}

class allSum extends Thread {	// For sum values
	
	int start;
	int end;
	int total;
	
	allSum(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public void run() {
		for(int i=start; i<=end; i++) {
			total += i;	// sum values start ~end
		}
	}
}

public class ThreadTest {

	public static void main(String[] args) {
		
		allSum test1 = new allSum(1,50);
		allSum test2 = new allSum(51,100);
		
		test1.start();
		test2.start();
		try {
			test1.join();		//if you don't use the join method, the result value of total will be incorrect
			test2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int total = test1.total+test2.total;
		
		System.out.println(total);
	}

}
