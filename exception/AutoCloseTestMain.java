package exception;

public class AutoCloseTestMain {

	public static void main(String[] args) {
		
//		try(AutoCloseableObj obj = new AutoCloseableObj();) {
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		AutoCloseableObj obj = new AutoCloseableObj();
		try(obj) {
			throw new Exception();
		} catch(Exception e) {
			System.out.println("ERROR!");
		}
		
	}

}
