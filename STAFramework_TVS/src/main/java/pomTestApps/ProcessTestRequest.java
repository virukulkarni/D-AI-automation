package pomTestApps;
/**************************************************
#Project Name: MiTEL_MXONE - Selenium Framework


#Class Name: ProcessTestRequest()
#Description:
#Input Parameters:
#Owner: Ashis Kumar Pradhan
#Author: Ashis Kumar Pradhan
#Date of creation: 03-July-16
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/
import java.util.HashMap;
import java.util.Map;

import pomTestApps.Utility.STAcore.io.Log;


public class ProcessTestRequest extends ReusableTestKeywords {
	//public static int testCalltimes;
	public static Map tcInvocation= new HashMap();;
	
	/*----------------------------------------------------------------------------------------------------------------------
	 *                                                    CONSTRUCTORS                                                |
	 ----------------------------------------------------------------------------------------------------------------------*/

	public ProcessTestRequest() {}

	
	public ProcessTestRequest(String tcName, String suiteName) {	
		try{
			int numofOccurance=(int) tcInvocation.get(tcName);
			numofOccurance++;
			tcInvocation.put(tcName, numofOccurance);
		}
		catch(NullPointerException e){
			tcInvocation.put(tcName, 0);
		}
		
		int newNumOfOccurance=(int) tcInvocation.get(tcName);
		if(newNumOfOccurance>0){
			reportPath = reportPathSuite + "\\" + tcName+"_"+newNumOfOccurance;
		}
		else{
		reportPath = reportPathSuite + "\\" + tcName;
		}
		this.tcName = tcName;	
		Log.info("ReportPath from test level " + reportPath);
	}

	
	
}