package hi;
//�͸� ���� Ŭ������ �������̽��� �߻�Ŭ������ �ٷ� �����ϴµ� �ַ� ���� ex)�ȵ���̵� ���α׷��ֽÿ� �̺�Ʈ�ڵ鷯(��ġ�� ����) �����ÿ� ���.
class Outer{
	
	Runnable getRunnable(int i) {
		int num = 100;
		
		return new Runnable() {
			
			public void run() {
				//�Ű����� i�� �ν��Ͻ� ���� num�� ��� final ��, ��������
				System.out.println("�Ű�����" + i);
				System.out.println("��������" +num);
			}
		};
	}
	
	Runnable runner = new Runnable() {
		
		@Override
		public void run() {
			System.out.println("Runnable �� ������ �͸� Ŭ���� ����");
			
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
