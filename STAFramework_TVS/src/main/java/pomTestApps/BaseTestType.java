package pomTestApps;

/**************************************************
#Project Name: MiTEL_MXONE - Selenium Framework


#Function Name: 
#Description:1.  This is responsible for reading the parameters from the ecel data sheet using data provider annotation
#Input Parameters:
#Owner: Ashis Kumar Pradhan
#Author: Ashis Kumar Pradhan
#Date of creation: 03-July-16
#Name of person modifying: (Tester Name): Naveen Kumar Punnana
#Date of modification: 1. Changed the implementation of fetching url information.
   					   2. Modified the implementatino of Test Suite constructor.
�**************************************************/
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.google.common.io.Resources;
import com.itextpdf.text.DocumentException;

import jxl.read.biff.BiffException;
import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.STAcore.XL_Reader;
import pomTestApps.Utility.STAcore.io.ExcelHandling;
import pomTestApps.Utility.STAcore.io.Log;
import pomTestApps.Utility.STAcore.io.ReadProperties;

public abstract class BaseTestType {

	public final static String DP = "parameters";

	public static XL_Reader xlsreader = new XL_Reader(Resources.getResource("config/TVSMOTOR/AUTOMATION_Config.xls").getPath());

	// Mandatory Variable Declarations.
	public WebDriver driver;
	static String strBrowser;
	public static Object[][] browser;
	public static String className;
	public static String testDescription;
	public static String testcaseId;
	int browserCount = 0;
	static String dataFilePath;
	static String propFilePath;
	private static int ii = 0;

	// Core Classes
	DriverFunctions df;
	public static ProcessTestRequest ptr;
	public static ReadProperties rp;
	public static ExcelHandling EH;
	public static String suiteName;
	static int rowNum;

	@BeforeSuite
	public void beforeTest() {
		setPropertyFileName();

		try {
			System.out.println("***************************************");
			System.out.println("-------------- EXECUTION STARTS HERE----------------------");
			System.out.println("-------------- BEFORE TEST   ----------------------");
			rp = new ReadProperties(propFilePath);
//			rp = new ReadProperties(Resources.getResource("AUTOMATION").getFile());
			ptr = new ProcessTestRequest();
			ptr.createSuitePath(rp.getreportPath(), rp.getsuiteName(), rp.getscreenShotcriteria());
			ptr.set_StartTime_suite();
			EH = new ExcelHandling();
			//killExecutables("chromedriver.exe");
			System.out.println("-------------- BEFORE TEST ENDS  ----------------------");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The below sections handles parameterization. Its mandatory to create a
	 * .xls file against each test case. The file name should be equal to the
	 * test class name. *
	 */

	@DataProvider(name = DP)
	public static Object[][] credentials() throws BiffException, IOException {
		browser = null;
		System.out.println("The number of test cases in the suite are : " + SuiteRunner.myClasses.size());
		String ClassName = getClass(ii);

		System.out.println("Test Case Running is : " + ClassName);
		suiteName = POMSuiteRunner.TestCaseIndex.get(ClassName);
		System.out.println("Suite Name is .." + suiteName);
		System.out.println("Class name in the DP..." + ClassName);
		rowNum = xlsreader.getCellRowNum(suiteName, "Testcase", ClassName);
		System.out.println("Suite name Row number .." + rowNum);

		int configRowNum = xlsreader.getCellRowNum("TestPlan", "SuiteName", suiteName);
		String configValue = xlsreader.getCellData("TestPlan", "Configuration", configRowNum);
		System.out.println("Config Values .." + configValue);
		int configRowNumber = xlsreader.getCellRowNum("Configs", "ConfigurationName", configValue);
		System.out.println("Config Row number..." + configRowNumber);
		System.out.println("Row number is :" + rowNum);
		ArrayList<Object> dataList = new ArrayList<>();
		dataList.add(
				xlsreader.getCellData(suiteName, "Browser", xlsreader.getCellRowNum(suiteName, "Testcase", ClassName)));

		for (int rowNumb = 2; rowNumb <= xlsreader.getRowCount("Configs"); rowNumb++) {
			if (configValue == xlsreader.getCellData("Configs", "ConfigurationName", rowNumb)) {
				for (int colNumb = 1; colNumb < xlsreader.getColumnCount("Configs"); colNumb++) {
					dataList.add(POMSuiteRunner.CredentialConfigStore
							.get(configValue + "." + xlsreader.getCellData("Configs", colNumb, 1)));
					System.out.println("The Credential Information for the Suite " + suiteName + " is :"
							+ POMSuiteRunner.CredentialConfigStore
									.get(configValue + "." + xlsreader.getCellData("Configs", colNumb, 1)));
					System.out.println(
							"The Key is : " + configValue + "." + xlsreader.getCellData("Configs", colNumb, 1));

				}
			}
		}

		String data = POMSuiteRunner.TestCaseData.get(ClassName);

		if ((data != null && data.indexOf(",") > 0) || data.indexOf(",") < 0) {

			StringTokenizer sTokenizer = new StringTokenizer(data, ",");
			while (sTokenizer.hasMoreElements()) {
				dataList.add(sTokenizer.nextElement());

			}
		} else {

			dataList.add(data);
		}

		Object[] list = dataList.toArray();
		dataList.clear();

		browser = new Object[1][list.length];
		for (int i = 0; i < 1; i++) {
			for (int k = 0; k < list.length; k++)
				if (list != null) {
					browser[i][k] = list[k];
					System.out.println("inside for loop " + list[k]);
					System.out.println(browser[i][k]);
				}
		}
		ii++;
		return browser;

	}

	public static String getDescription() {
		testDescription = xlsreader.getCellData(suiteName, "Description", rowNum);
		System.out.println("Test Case Description " + testDescription);
		return testDescription;
	}

	public static String getTestcaseId() {
		testcaseId = xlsreader.getCellData(suiteName, "TC ID", rowNum);
		System.out.println("Test Case ID " + testcaseId);
		return testcaseId;
	}

	public static String getClass(int ii) {

		String ClassName1 = SuiteRunner.myClasses.get(ii).toString();
		int lastIndex = ClassName1.lastIndexOf(".") + 1;
		int ClassLength = ClassName1.length() - 1;
		String ClassName = ClassName1.substring(lastIndex, ClassLength);

		return ClassName;
	}

	/**
	 * Method for before Class
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings(value = { "all" })
	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws IOException {
		Log.info("********************************************");
		Log.info("--------------In before Class****************");
		System.out.println("******Before Class***********");
		rp = new ReadProperties(propFilePath);
		Log.info("Source Folder is " + rp.getsrcFolder());

		String internalPath = this.getClass().getName().replace(".", File.separator);
		String externalPath = System.getProperty("user.dir") + "\\src" + File.separator + internalPath;

		this.dataFilePath = externalPath.substring(0, externalPath.lastIndexOf(File.separator));

		Log.info("----------------datafile name----------------" + dataFilePath);
		this.className = this.getClass().getSimpleName().trim();
		ptr = new ProcessTestRequest(this.getClass().getSimpleName().trim(), rp.getsuiteName());
		Log.info("Class Name is : " + className);
		System.out.println("Class name is ...." + className);
		ptr.set_StartTime_test();
		System.out.println("*********--------------Before Class ENDS--------****************");
	}

	/**
	 * Method for AfterMethod
	 */

	@AfterMethod
	public void afterMethod() {
		System.out.println("*********--------------After method starts--------****************");
		Log.info("------        After Method Executed---------");
		System.out.println("After Method......");
		ptr.generateMethodInfo();
		if (suiteName != "TestSetup")
			try {
				df.closebrowser();
				System.out.println("*********--------------Afret method ENDS--------****************");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

	/**
	 * Method for AfterClass
	 */
	@AfterClass
	public void afterClass() throws IOException {
		System.out.println("-----------------------After class starts here-------------------");
		Log.info("------        After Class Starts---------");
		System.out.println("....After class .......");
		try {
			ptr.generateTestReport();
		} catch (InvocationTargetException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.driver.quit();
		Log.info("------        After Class Executed---------");
		System.out.println("-----------------------After class ends here-------------------");
	}

	/**
	 * Method for BeforeMethod
	 */
	public void beforeMethod() {
		Log.info("------        Before Method Starts---------");
		System.out.println(".....Before Method ...");
		strBrowser = (String) browser[browserCount][0];

		System.out.println("------        Before Method Starts---------");
		df = new DriverFunctions(driver, strBrowser, rp.getimplicitWait(), rp.getpageLoadTimeOut());
		
		// Rread browser from the Jenkins parameter
		strBrowser = POMSuiteRunner.strBrowser;
		df = new DriverFunctions(driver, strBrowser, rp.getimplicitWait(), rp.getpageLoadTimeOut());
		
		try {
			this.driver = df.openBrowser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ptr.initializeMethod(this.driver, strBrowser);
		browserCount++;

		Log.info("------Before Method Ends---------");
		System.out.println("------Before Method Ends---------");
	}

	/**
	 * Method for AfterTest
	 * @throws InterruptedException 
	 */

	@AfterSuite
	public void afterTest() throws IOException, DocumentException, InterruptedException {
		Log.info("------        After Test Starts---------");
		System.out.println("......After Suite ........");
		ptr.set_EndTime_suite();
		ptr.createSuiteReport();
		this.driver.quit();
		//killExecutables("phantomjs.exe");
		Log.info("------Killing all instances of chrome---------");
		//killExecutables("chromedriver.exe");
		//killExecutables("IEDriverServer.exe");
		Log.info("------       EXECUTION COMPLETED..---------");
	}

	/**
	 * Reads the Property File Name and processes it.
	 */
	public abstract void setPropertyFileName();

	public void setPropertyFileName(String propFilePath) {
		this.propFilePath = propFilePath;

	}

	/**
	 * This method will explicitly kill Phantom.exe processes. *
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	private void killExecutables(String browserDriver) throws IOException, InterruptedException {
		String pidInfo;
		Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

		String line;
		while ((line = input.readLine()) != null) {
			pidInfo = line;
			// System.out.println(pidInfo);
			if (pidInfo.contains("phantomjs.exe")) {
				Runtime.getRuntime().exec("taskkill /F /IM " + browserDriver);
				ptr.wait(5000);
			}

		}

	}

}
