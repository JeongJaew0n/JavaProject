package hi;
//익명 내부 클래스는 인터페이스나 추상클래스를 바로 구현하는데 주로 사용됨 ex)안드로이드 프로그래밍시에 이벤트핸들러(터치와 같은) 구현시에 사용.
// 람다식
class Outer{
	
	Runnable getRunnable(int i) {
		int num = 100;
		
		return new Runnable() {
			
			public void run() {
				//매개변수 i와 인스턴스 변수 num은 모두 final 즉, 상수취급임
				System.out.println("매개변수" + i);
				System.out.println("지역변수" +num);
			}
		};
	}
	
	Runnable runner = new Runnable() {
		
		@Override
		public void run() {
			System.out.println("Runnable 이 구현된 익명 클래스 변수");
			
		}
	};
	
}

public class AnonymousInnerClass {

	public static void main(String[] args) {
		Outer out = new Outer();
		
		Runnable main_run = out.getRunnable(100);
		
		main_run.run();
		out.runner.run();

	}

}
