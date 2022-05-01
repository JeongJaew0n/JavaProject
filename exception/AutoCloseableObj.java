package exception;
//
/*
 * try-with-resources 란?
 * try문 안에 선언된 파일 I/O와 핸들러 관련 객체들은 close를 해주어야 한다.
 * try-catch-finally를 통해 finally 구문에서 close를 해주면 오류가 나더라도 정상적으로 close가 되지만,
 * 프로그래머가 직접 하다보면 실수가 날 수도 있고 유지보수하기 어려워 진다.
 * 따라서 try문 안에 선언된 객체는 try문의 종료와 함께 자동으로 끝나는 것이 try-with-resources다.
 * 
 * AutoCloseable을 구현한 
 */

public class AutoCloseableObj implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("close.....");
	}
	
}
