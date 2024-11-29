/*----------------------------------------------------------------------------------------------------------------------
	            This Class handles all requests from Base Class and Test Class                                                    |
----------------------------------------------------------------------------------------------------------------------*/
package pomTestApps;
/**************************************************
#Project Name: MiTEL_MXONE - Selenium Framework

#Class Name: ReusableUiCoreKeywords()
#Description:This Class handles all requests from Base Class and Test Class
#Input Parameters:
#Owner: Ashis Kumar Pradhan
#Author: Ashis Kumar Pradhan
#Date of creation: 03-July-16
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.Utility.STAcore.io.Log;
import pomTestApps.Utility.STAcore.reportwriter.GenerateHtmlReport;
import pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport;

public class ReusableUiCoreKeywords {
	WebDriver driver;
//	FirefoxDriver driver;
	GenerateHtmlReport gtr = new GenerateHtmlReport();
	GeneratePDFReport gpr;

	String tcId;
	String tcName;
	String reportPath;
	String reportPathBrowser;
	public static String reportPathSuite;
	String testExecutionStatus = "Pass";
	static String screenshotOnFail;
	ArrayList<String[]> stepsDetails = new ArrayList<String[]>();
	static ArrayList<ArrayList<String[]>> testDetails = new ArrayList<ArrayList<String[]>>();

	String Browser;
	ArrayList<String> browserlist = new ArrayList<String>();
	static int serielNo = 1;
	static int int_runCount = 1;
	static int grpserielNo = 1;
	String status = null;
	String testDescription;
	static Date startTime_Suite;
	Date endTime_Suite;
	Date date_startTime_test;
	Date date_endTime_test;
	boolean endOfTestCase = false;
	

	/*---------------------------------------------------------------------------------------------------------------------------------------------------------------
	 *   The Below methods are to be used by Core Functions and base Classes
	 
	 *                                       CORE REUSABLE FUNCTIONS
	 ------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	// This method is called by BeforeTestMethod
	@SuppressWarnings("static-access")
	void createSuitePath(String reportPath, String suiteName,
			String screenshotOnFail) {
		Log.info("Inside createSuitePath");
		this.screenshotOnFail = screenshotOnFail;
		Log.info("Value of screenshotOnFail " + screenshotOnFail);
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Log.info("Group seriel number " + grpserielNo);

		if (grpserielNo > 1) {
			reportPathSuite = reportPath + "\\" + "SuiteTest_"
					+ dateFormat.format(date);
			Log.info("new reportPath suite is-else  " + reportPathSuite);
		} else {
			reportPathSuite = reportPath + "\\" + suiteName + "_"
				+ dateFormat.format(date) + "_TVS_DAI_"
						+ POMSuiteRunner.strDAIAppName + "_"
						+ POMSuiteRunner.strTestplanName + "_On_"
						+ POMSuiteRunner.strBrowser;				
			Log.info("new reportPath suite is " + reportPathSuite);
		}
		grpserielNo++;

		Log.info("Report Path suite is " + reportPathSuite);
		Log.info("Suitename is " + suiteName);
	}

	// This method is called by Before Method

	void initializeMethod(WebDriver driver2, String Browser) {
		if (DriverFunctions.headless == true) {
			Browser = "Headless";
		}
		System.out.println("Inside initialize method");
		this.driver = driver2;
		this.Browser = Browser;
		stepsDetails.clear();
		reportPathBrowser = reportPath + "\\" + Browser;
		
		browserlist.add(Browser);
		Log.info("Report Path after in bfre mthod " + reportPathBrowser);
		// Reset the flag for Incomplte status of the test case.
		gtr.isTestComplete(false);
	}

	// This method is called by After Method
	@SuppressWarnings("unchecked")
	void generateMethodInfo() {

		Log.info("After method of " + Browser);
		reportPathBrowser = reportPath;
		@SuppressWarnings("unchecked")
		ArrayList<String[]> newList = (ArrayList<String[]>) stepsDetails
				.clone();
		testDetails.add(newList);
		testDescription = BaseTestType.getDescription();
		tcId = BaseTestType.getTestcaseId();
		
		Log.info("Test description is " + testDescription);
		System.out.println("Test Description is ..."+testDescription);
		
		
		for(int newListCount=0; newListCount<stepsDetails.size();newListCount++){
			
			//String[] stockArr = new String[stepsDetails.size()];
			String[] stockArr = stepsDetails.get(newListCount).clone();

			
		System.out.println("Test Details ...."+stockArr[0]+stockArr[1]+stockArr[2]);
		}
		serielNo = 1;
	}

	// This is called by After Class to generate HTML report
	void generateTestReport() throws IOException, InvocationTargetException {
		if (endOfTestCase == true) {
			gtr.isTestComplete(true);
		}
		try {

			// gpr=new GeneratePDFReport();
			@SuppressWarnings("unchecked")
			ArrayList<ArrayList<String[]>> newtestDetails = (ArrayList<ArrayList<String[]>>) testDetails
					.clone();

			GeneratePDFReport.suiteTestDetails.add(newtestDetails);
			this.set_EndTime_test();
			Object[] tcNameandTime = { tcName, date_startTime_test,
					date_endTime_test };
			GeneratePDFReport.tcNameandTime.add(tcNameandTime);
			@SuppressWarnings("unchecked")
			ArrayList<String> newbrowserlist = (ArrayList<String>) browserlist
					.clone();
			GeneratePDFReport.suiteBrowserList.add(newbrowserlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*ExcelHandling eh = new ExcelHandling();
		testDescription = eh.getTestDescription();*/
		System.out.println("Report Path 1----is Line 141 ReusableCore"+reportPath);
		gtr.createTestReport(testDetails, browserlist, reportPath, tcId, tcName, testDescription);

		Log.info("Test Report Created*******");
//
		Log.info("Clearing Test Details");
		testDetails.clear();
	}

	// This method is called by After Test Methods
	void createSuiteReport() {
		gtr.createSuiteReport(reportPathSuite, startTime_Suite, endTime_Suite);
	}

	// THIS METHOD IS CALLED IN BEFORE TEST METHOD TO SET THE START TIME OF THE
	// EXECUTION
	void set_StartTime_suite() {
		Date date = new Date();
		startTime_Suite = date;
		Log.info("Start time is " + startTime_Suite);
	}

	// THIS METHOD IS CALLED IN AFTER TEST TO SET THE END TIME OF THE EXECUTION
	void set_EndTime_suite() {
		Date date = new Date();
		endTime_Suite = date;
	}

	@SuppressWarnings("deprecation")
	void set_StartTime_test() {
		Date date = new Date();
		date_startTime_test = date;
		// date_startTime_test =
		// date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
		Log.info("Start time is " + startTime_Suite);
	}

	// THIS METHOD IS CALLED IN AFTER TEST TO SET THE END TIME OF THE EXECUTION
	@SuppressWarnings("deprecation")
	void set_EndTime_test() {
		Date date = new Date();
		date_endTime_test = date;
		// date_endTime_test =
		// date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	}



	/*----------------------------------------------------------------------------------------------------------------------
	 *              CORE RESUABLE METHODS ENDS HERE                                                                        |
	 ----------------------------------------------------------------------------------------------------------------------*/

}
