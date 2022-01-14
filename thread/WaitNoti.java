package thread;

This code is for learn the Wait and Notify in thread

import java.util.ArrayList;
import java.util.Scanner;

class LibrarySystem {	// singleton.Main system of Library. In here, It will be created static object
	public ArrayList<String> books = new ArrayList<String>();	
	
	public void addBook(String book_name) {	// Add a book name to book array list 
		books.add(book_name);
	}
	
	public void rmBook(String book_name) {	// Remove a book name from book array list
		boolean no_search = true;
		if(books.size() > 0) {		
			for(int i=0; i<books.size(); i++) {		
				if(books.get(i).equals(book_name)) {
					books.remove(i);
					no_search = false;
					break;
				}
			}
			if(no_search)	System.out.println("찾는 결과가 없습니다.");
		}
		else {
			System.out.println("책이 없습니다!");
		}
	}
	
	public synchronized String lendBook() throws InterruptedException {	// Lend a book. This can have race condition.
		
		Thread t = Thread.currentThread();
		
		while(books.size()==0) {		//if you use notify(), you can use if.
			System.out.println(t.getName() + " wating start");
			wait();							//if dont's use wait, infinite roop. why?
										//메서드 진입시에 가지고 있던 값이 갱신이 안됨.
			System.out.println(t.getName() + " wating end");
		}
		
		String lendBook = books.remove(0);
		
		System.out.println(t.getName() + "이가" + lendBook + " 빌렸습니다.");
		
		return lendBook;
	}
	
	public synchronized void returnBook(String book_name) {
		Thread t = Thread.currentThread();
		
		books.add(book_name);
		notifyAll();		//notifyAll is more fair than notify
		System.out.println(t.getName() + "이가" + book_name + " 반납했습니다.");
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
			System.out.println("Library시스템에 온걸 환영합니다.\n1.책 추가 2.책 삭제 3.스레드초기화 4.종료 5.책목록");
			System.out.println("6.학생추가 7.학생행동");
			int sel = sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1:
				System.out.println("추가할 책 제목을 입력해주세요.");
				String book_name = sc.nextLine();
				if(book_name.equals("t")) {
					ChangLibrary.lib_sys.addBook("태백산맥1");
					ChangLibrary.lib_sys.addBook("태백산맥2");
					ChangLibrary.lib_sys.addBook("태백산맥3");
					ChangLibrary.lib_sys.addBook("태백산맥4");
				}
				else ChangLibrary.lib_sys.addBook(book_name);
				break;
			case 2:
				System.out.println("삭제할 책 제목을 입력해주세요.");
				ChangLibrary.lib_sys.rmBook(sc.nextLine());
				break;
			case 3:
				for(Student ss: students) {
					System.out.println(ss.getName()+" 종료됩니다.");
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
				System.out.println("학생이 1명 추가되었습니다. 현재학생: "+ students.size() + "명");
				break;
			case 7:
				if(students.size() == 0) {
					System.out.println("학생이 없습니다.");
					break;
				}
				if(ChangLibrary.lib_sys.books.size() == 0) {
					System.out.println("책이 없습니다.");
					break;
				}
				for(Student ss: students) {
					if(ss.getState() == Thread.State.NEW) ss.start();
					else System.out.println("쓰레드는 run 된 다음 종료 후 다시 실행될 수 없습니다!!! 새로운 스레드를 생성하고 run해주세요!!!!!");
				}
				break;
			}
		}
	}

}
