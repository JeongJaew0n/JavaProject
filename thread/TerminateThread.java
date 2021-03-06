package thread;
//
//This code is for learn the thread.

import java.io.IOException;

public class TerminateThread extends Thread{	// sample thread
	
	private boolean flag = false;		// check the thread is on/off

	
	public TerminateThread(String name) {
		super(name);
	}
	
	public void run() {		
		while(!flag) {			//while thread is alive
			try {
				sleep(100);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(getName() + " end");
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	

	public static void main(String[] args) {
		
		TerminateThread threadA = new TerminateThread("A");
		TerminateThread threadB = new TerminateThread("B");
		TerminateThread threadC = new TerminateThread("C");

		threadA.start();
		threadB.start();
		threadC.start();
		
		int in = 0;
		while(true) {
			try {
				in = System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if( in == 'A') {
				threadA.setFlag(true);
			}else if(in == 'B'){
				threadB.setFlag(true);
			}else if( in == 'C'){
				threadC.setFlag(true);
			}else if( in == 'M') {
				threadA.setFlag(true);
				threadB.setFlag(true);
				threadC.setFlag(true);
				break;
			}else {
				System.out.println("type again");
			}
		}
		
		System.out.println("main end");

	}

}
