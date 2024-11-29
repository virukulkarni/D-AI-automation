package pomTestApps.Utility.STAcore.io;
/**************************************************
#Project Name: Mitel - Selenium Framework


#Function Name: logger()
#Author: Ashis Kumar Pradhan
#Description: This function reads the excelsheet containing test data related to test case.
#Date of creation: 01-July-16
#Input Parameters:File Path,Test Class Name
#Owner: Ashis Kumar Pradhan
#Author: Ashis Kumar Pradhan
#Date of creation: 03-July-16
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/
import org.apache.log4j.Logger;
	
public class Log {

	private static Logger logger = Logger.getLogger(Log.class
			.getCanonicalName());

	public static <T> T info(T message) {
		logger.info(message);
		return message;
	}

	public static void warn(String message) {
		logger.warn(message);
	}

	public static void error(String message) {
		logger.error(message);
	}

	public static void fatal(String message) {
		logger.fatal(message);
	}

	public static void debug(String message) {
		logger.debug(message);
	}

	public static void trace(String message) {
		logger.trace(message);
	}

}
