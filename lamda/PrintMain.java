package lamda;
//
public class PrintMain {

	public static void main(String[] args) {
		Hello hel = new Hello();	//전통적인 방식.
		hel.showString("Hi");//
		
		PrintString pt = new PrintString() {	//익명 함수를 사용하여 인터페이스를 바로 구현.
			
			public void showString(String s) {
				System.out.println(s);
			}
		};
		
		pt.showString("WOW");
			
		
		PrintString lamda_pt = s->System.out.println(s);	//람다식을 이용해 구현해야 할 메서드가 하나 뿐일때 이런식으로 구현 가능. 매개변수 -> 함수내용
		
		lamda_pt.showString("This is Good lamda!");
	}
}

class Hello implements PrintString {	//원래 방식 implements선언하고 해당 메서드를 구현한다.

	@Override
	public void showString(String s) {
		System.out.println(s);
	}
}
