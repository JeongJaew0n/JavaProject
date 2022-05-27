package logger;
//
public class LoggerTest {

	public static void main(String[] args) {
			MyLogger myLogger = MyLogger.getLogger();
			
//			myLogger.log("test");
			myLogger.fine("what!");
	}

}
