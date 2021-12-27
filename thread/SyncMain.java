package thread;

class Bank {	//동기화(synchronization)를 공부하기 위한 클래스.
	private int money = 10000;	//Pong과 PongWife는 두 클래스 모두 이 변수를 참조하는 메서드를 사용한다.
	public static int king = 100;
	
	public void saveMoney(int save) {
		int m = this.getMoney();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMoney( m + save);
	}
	
	public void minusMoney(int minus){
		
		int m = this.getMoney();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setMoney( m - minus);
	}

	
	private void setMoney(int m) {
		money = m;
	}
	public int getMoney() {
		return money;
	}
	
	public void cheat(String s) {
		if(s == "show me the money") {
			money *= 2;
		}
	}
}

class Pong extends Thread {
	public void run() {	
		synchronized (SyncMain.myBank) {	//Pong클래스에서 스레드(Thread)를 실행한다. 해당 스레드는 전역변수인 myBank 객체를 다른 스레드에서 사용중이지 않을때 동작한다.
			System.out.println("start save");	
			SyncMain.myBank.saveMoney(3000);	//static으로 공유되는 전역변수 myBank의 객체의 saveMoney 메서드를 실행한다.
			System.out.println("saveMoney(3000): " + SyncMain.myBank.getMoney());
		}

	}
}
class PongWife extends Thread {	//Pong클래스와 동일.
	public void run() {
		synchronized (SyncMain.myBank) {
			System.out.println("start minus");
			SyncMain.myBank.minusMoney(1000);
			System.out.println("minuseMoney(1000): " + SyncMain.myBank.getMoney());
		}
	}
}


public class SyncMain {

	public static Bank myBank = new Bank();
	
	public static void main(String[] args) {
		
		Pong k = new Pong();
		PongWife l = new PongWife();
		
		k.start();
		l.start();
		
	}

}
