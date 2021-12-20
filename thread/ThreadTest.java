package thread;

class PriorityThread extends Thread{
	
	public void run() {
		int sum = 0;
		
		Thread t = Thread.currentThread();
		System.out.println(t + "start");
		
		for(int i=0; i<10000000; i++) {
			sum += i;
		}
		
		System.out.println(t.getPriority()+"¹øÂ° Thread end");
	}
}

class allSum extends Thread {
	
	int start;
	int end;
	int total;
	
	allSum(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public void run() {
		for(int i=start; i<=end; i++) {
			total += i;
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
			test1.join();
			test2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int total = test1.total+test2.total;
		
		System.out.println(total);
	}

}
