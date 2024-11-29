package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtil {

	public static  Logger APPLICATION_LOGS=null;
	public static String strDate;
	public static String resultFolderPath=null;
	
	
	public static void initializeLogger(){
		
		APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
		strDate=getCurrentTimeStamp();
		resultFolderPath = setLogConfig();
		provideFolderAccess(resultFolderPath);
		
	}
	

	public static String setLogConfig() {

		String log4jPropertyPath = System.getProperty("user.dir")+"\\src";
		String logFilePath = System.getProperty("user.dir")+"\\Reports\\Html\\"+strDate;
		modifyLog4jProperties(log4jPropertyPath+"\\log4j.properties", logFilePath+ "\\Application.log");

		return logFilePath;
		}

	private static void modifyLog4jProperties(String log4jPropertyPath, String logFilePath){
		Properties props = new Properties();
		try {
		//InputStream configStream = new FileInputStream(Thread.currentThread().getContextClassLoader().getResource(log4jPropertyPath).getPath());
		InputStream configStream = new FileInputStream(log4jPropertyPath);
		props.load(configStream);
		configStream.close();
		} catch (IOException e) {
		
		}
		props.setProperty("log4j.appender.dest1.File", logFilePath);
		LogManager.resetConfiguration();
		PropertyConfigurator.configure(props);
		}
		
	public static String getCurrentTimeStamp()
	{ 
		SimpleDateFormat CurrentDate = new SimpleDateFormat("MM-dd-yyyy"+"_"+"HH-mm-ss");
		Date now = new Date(); 
		String CDate = CurrentDate.format(now); 
		return CDate; 
	}
	
	public static void provideFolderAccess(String resultFolderPath) {
		// TODO Auto-generated method stub
		File file = new File(resultFolderPath);
		
		    if (file.canWrite()) {
	            
	        } else {
	           
	            file.setWritable(true);
	        }
	   
	}
	
}
