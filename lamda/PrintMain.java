package lamda;

public class PrintMain {

	public static void main(String[] args) {
		Hello hel = new Hello();	//�������� ���.
		hel.showString("Hi");
		
		PrintString pt = new PrintString() {	//�͸� �Լ��� ����Ͽ� �������̽��� �ٷ� ����.
			
			public void showString(String s) {
				System.out.println(s);
			}
		};
		
		pt.showString("WOW");
			
		
		PrintString lamda_pt = s->System.out.println(s);	//���ٽ��� �̿��� �����ؾ� �� �޼��尡 �ϳ� ���϶� �̷������� ���� ����. �Ű����� -> �Լ�����
		
		lamda_pt.showString("This is Good lamda!");
	}
}

class Hello implements PrintString {	//���� ��� implements�����ϰ� �ش� �޼��带 �����Ѵ�.

	@Override
	public void showString(String s) {
		System.out.println(s);
	}
}
