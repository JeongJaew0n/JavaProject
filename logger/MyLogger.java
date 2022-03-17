package logger;
//
//너무 적은 로그(정확하게 시스템 파악 어려움)도, 너무 많은 로그(오버헤드, 너무 많은 file I/O)도 안좋음.
//로거 -> 핸들러 -> 레코드

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
	Logger logger = Logger.getLogger("mylogger");	//mylogger는 식별자. 매번 같은 객체를 반환함. 일종의 싱글톤 패턴
	private static MyLogger instance = new MyLogger();	//싱글톤 패턴
	
	public static final String errorLog = "log.txt";
	public static final String warningLog = "warning.txt";
	public static final String fineLog = "fine.txt";
	
	private FileHandler logFile = null;
	private FileHandler warningFile = null;
	private FileHandler fineFile = null;
	
	private MyLogger() {
		try {
			logFile = new FileHandler(errorLog,true);	//true는 append(추가)해서 작성.
			warningFile = new FileHandler(warningLog,true);	
			fineFile = new FileHandler(fineLog,false);		//핸들러를 통해 파일 입출력.
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		logFile.setFormatter(new SimpleFormatter());
		warningFile.setFormatter(new SimpleFormatter());
		fineFile.setFormatter(new SimpleFormatter());
		
		logger.setLevel(Level.ALL);	//모든 레벨(severe~finest)을 다 찍는다.
		
		warningFile.setLevel(Level.WARNING);	//직접 설정하지 않으면 기본logger를 따라감.
		fineFile.setLevel(Level.FINE);			//설정해주면 해당 레벨 이상만 찍음.
		
		logger.addHandler(logFile);
		logger.addHandler(warningFile);
		logger.addHandler(fineFile);
	}
	
	public static MyLogger getLogger() {
		return instance;
	}
	
	public void log(String msg) {
		
		logger.finest(msg);
		logger.finer(msg);
		logger.fine(msg);
		logger.config(msg);
		logger.info(msg);
		logger.warning(msg);
		logger.severe(msg);
		
	}
	
	public void fine(String msg) {
		logger.fine(msg);
	}
	
	public void warning(String msg) {
		logger.warning(msg);
	}
}


