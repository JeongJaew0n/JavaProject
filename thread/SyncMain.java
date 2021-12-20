package thread;

class Bank {
	private int money = 10000;
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
		synchronized (SyncMain.myBank) {
			System.out.println("start save");
			SyncMain.myBank.saveMoney(3000);
			System.out.println("saveMoney(3000): " + SyncMain.myBank.getMoney());
		}

	}
}
class PongWife extends Thread {
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
