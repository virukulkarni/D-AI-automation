package pomTestApps.STAcore;

import org.openqa.selenium.WebElement;

public class CommonUtil {

	public static String getInitialTime(String string) {
		
		return string.substring(39);
	
		
		
	}

	public static boolean findTimeDifference(String initialTime, String endTime) {
		if (initialTime.equalsIgnoreCase(endTime)) {
			return true;
		}
		return false;
	}

	
}
