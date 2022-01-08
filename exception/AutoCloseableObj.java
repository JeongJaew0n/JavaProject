package exception;

/*
 * try-with-resources ��?
 * try�� �ȿ� ����� ���� I/O�� �ڵ鷯 ���� ��ü���� close�� ���־�� �Ѵ�.
 * try-catch-finally�� ���� finally �������� close�� ���ָ� ������ ������ ���������� close�� ������,
 * ���α׷��Ӱ� ���� �ϴٺ��� �Ǽ��� �� ���� �ְ� ���������ϱ� ����� ����.
 * ���� try�� �ȿ� ����� ��ü�� try���� ����� �Բ� �ڵ����� ������ ���� try-with-resources��.
 * 
 * AutoCloseable�� ������ 
 */

public class AutoCloseableObj implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("close.....");
	}
	
}
