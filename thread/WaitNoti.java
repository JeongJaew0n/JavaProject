package thread;

import java.util.ArrayList;
import java.util.Scanner;

class LibrarySystem {
	public ArrayList<String> books = new ArrayList<String>();
	
	public void addBook(String book_name) {
		books.add(book_name);
	}
	
	public void rmBook(String book_name) {
		boolean no_search = true;
		if(books.size() > 0) {
			for(int i=0; i<books.size(); i++) {
				if(books.get(i).equals(book_name)) {
					books.remove(i);
					no_search = false;
					break;
				}
			}
			if(no_search)	System.out.println("ã�� ����� �����ϴ�.");
		}
		else {
			System.out.println("å�� �����ϴ�!");
		}
	}
	
	public synchronized String lendBook() throws InterruptedException {
		
		Thread t = Thread.currentThread();
		
		while(books.size()==0) {
			System.out.println(t.getName() + " wating start");
			wait();
			System.out.println(t.getName() + " wating end");
		}
		
		String lendBook = books.remove(0);
		
		System.out.println(t.getName() + "�̰�" + lendBook + " ���Ƚ��ϴ�.");
		
		return lendBook;
	}
	
	public synchronized void returnBook(String book_name) {
		Thread t = Thread.currentThread();
		
		books.add(book_name);
		notifyAll();
		System.out.println(t.getName() + "�̰�" + book_name + " �ݳ��߽��ϴ�.");
	}
}

class Student extends Thread{
	public void run() {
		try {
			String lend_book = ChangLibrary.lib_sys.lendBook();
			if(lend_book == null) return;
			sleep(3000);
			ChangLibrary.lib_sys.returnBook(lend_book);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ChangLibrary{
	public static LibrarySystem lib_sys = new LibrarySystem();
}



public class WaitNoti {

	public static void main(String[] args) {
		
		int ex = 0;
		ArrayList<Student> students = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		while(ex == 0) { 
			System.out.println("Library�ý��ۿ� �°� ȯ���մϴ�.\n1.å �߰� 2.å ���� 3.�������ʱ�ȭ 4.���� 5.å���");
			System.out.println("6.�л��߰� 7.�л��ൿ");
			int sel = sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1:
				System.out.println("�߰��� å ������ �Է����ּ���.");
				String book_name = sc.nextLine();
				if(book_name.equals("t")) {
					ChangLibrary.lib_sys.addBook("�¹���1");
					ChangLibrary.lib_sys.addBook("�¹���2");
					ChangLibrary.lib_sys.addBook("�¹���3");
					ChangLibrary.lib_sys.addBook("�¹���4");
				}
				else ChangLibrary.lib_sys.addBook(book_name);
				break;
			case 2:
				System.out.println("������ å ������ �Է����ּ���.");
				ChangLibrary.lib_sys.rmBook(sc.nextLine());
				break;
			case 3:
				for(Student ss: students) {
					System.out.println(ss.getName()+" ����˴ϴ�.");
					ss.interrupt();
				}
				break;
			case 4:
				ex = 1;
				break;
			case 5:
				for(int i=0; i<ChangLibrary.lib_sys.books.size(); i++) {
					System.out.println(ChangLibrary.lib_sys.books.get(i));
				}
				break;
			case 6:
				students.add(new Student());
				System.out.println("�л��� 1�� �߰��Ǿ����ϴ�. �����л�: "+ students.size() + "��");
				break;
			case 7:
				if(students.size() == 0) {
					System.out.println("�л��� �����ϴ�.");
					break;
				}
				if(ChangLibrary.lib_sys.books.size() == 0) {
					System.out.println("å�� �����ϴ�.");
					break;
				}
				for(Student ss: students) {
					if(ss.getState() == Thread.State.NEW) ss.start();
					else System.out.println("������� run �� ���� ���� �� �ٽ� ����� �� �����ϴ�!!! ���ο� �����带 �����ϰ� run���ּ���!!!!!");
				}
				break;
			}
		}
	}

}
