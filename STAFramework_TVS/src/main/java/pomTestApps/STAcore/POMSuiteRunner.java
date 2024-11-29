package pomTestApps.STAcore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Resources;

import pomTestApps.SuiteRunner;

public class POMSuiteRunner {

	OperationExecutor OpEec = new OperationExecutor();
	// Defining the hashtable dataStore.
	public static Hashtable<String, String> SuiteName = new Hashtable<String, String>();
	public static Hashtable<String, String> RefSuiteName = new Hashtable<String, String>();
	public static Hashtable<String, String> Configuration = new Hashtable<String, String>();
	public static Hashtable<String, String> TestCaseData = new Hashtable<String, String>();
	public static Hashtable<String, String> ConfigStore = new Hashtable<String, String>();
	public static Hashtable<String, String> TestSuite = new Hashtable<String, String>();
	public static Hashtable<String, String> TestSuiteIndex = new Hashtable<String, String>();
	public static Hashtable<String, String> TestCaseIndex = new Hashtable<String, String>();
	public static Hashtable<String, String> CredentialConfigStore = new Hashtable<String, String>();
	public static int _rowCount = 0;
	public static String currentTest;
	public static String currentTestCaseID;
	public static String result;
	public static String suiteName;
	public static String suitename;
	public static String configurationName;
	public static int defRowNum = 2;
	public static String RunAll = "No";
	private static char[] Platform_Ver;
	public static String PVersion;
	public static String packageName;
	public static String Sname;
	public static String ConfName;
	public static String PropertyName;
	public static String FileName;
	public static String Admin_User;
	public static String Downloads_Folder;
	public static String strEmailRecipients;
	public static String strSendEmail;
	public static String strEmailPassword;
	public static String strEmailNReportHeadline;

	//public static String strFrameworkFolder = System.getProperty("user.dir");
	public static String strConfigFile =  Resources.getResource("config/TVSMOTOR/AUTOMATION_Config.xls").getPath();
	public static String strTestParameters = "";
	public static String strTestplanName = "";
	public static String strOpeasyURL = "";
	public static String strBrowser = "";
	public static String strDAIAppName = "";
	// public static XL_Reader xlsreader = new XL_Reader(strConfigFile);
	public static XL_Reader xlsreader;

	// Declaring Xls Reader.
	// public static XL_Reader xlsreader = new


	public static Logger logger = Logger.getLogger("devpinoyLogger");

	@Parameters({ "package-name", "suite-name", "config-name", "property-name", "Files", "Admin_User" })
	@Test
	public void Run(String pkg, String sname, String cname, String pname, String fname, String sshUser)
			throws Exception {
		packageName = pkg;
		Sname = sname;
		ConfName = cname;
		PropertyName = pname;
		FileName = fname;
		Admin_User = sshUser;
		
		String strSuiteToRunFile = Resources.getResource("SuiteToRun.txt").getPath();
		File file = new File(strSuiteToRunFile);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		
		try {
			
			String strTestplanLogistics = "";
			strTestParameters = br.readLine().trim();
			System.out.println("Test parameters received from Jenkins: " +strTestParameters);
			
			String[] strData = strTestParameters.split(" ");
			strTestplanName = strData[0];
			strOpeasyURL = strData[1];
			strBrowser = strData[2];
			strDAIAppName = strData[3];
			strSendEmail = strData[4];
			strEmailRecipients = strData[5].toString().replaceAll(":", ",");			
			
//			strEmailRecipients = strEmailRecipients.
			System.out.println("Email Receipients: " + strEmailRecipients);
	
			switch (strTestplanName) {
			
				case "Sanity_MPCP":
					strTestplanName = "Sanity_MPCP";
					strTestplanLogistics = "A2:Yes;A3:Yes";
					strEmailNReportHeadline = " Sanity_MPCP Test Report ";
					break;
									
			}
			
			try {
				boolean blnStatus = false;
				blnStatus = insertMultiExcelCellData(strConfigFile, "TestPlan", strTestplanLogistics);				
				System.out.println("Update excel TestPlan sheet status: " + blnStatus);
				
				String strCellValue = "C2:" + strOpeasyURL;
				blnStatus = insertMultiExcelCellData(strConfigFile, "Configs", strCellValue);
				System.out.println("Update OpeasyURL to Configs sheet status: " + blnStatus);
				
			}catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		xlsreader = new XL_Reader(strConfigFile);
		System.out.println("........." + xlsreader);
		System.out.println("propertyName " + PropertyName);
		System.out.println("Sname " + Sname);
		
		int Refi = 0;
		for (int tpRowNum = 2; tpRowNum <= xlsreader.getRowCount("TestPlan"); tpRowNum++) {

			String KeyRowCount = String.valueOf(Refi);
//			if (xlsreader.getCellData("TestPlan", "Run", tpRowNum).trim().equalsIgnoreCase("Yes")) {
			if (xlsreader.getCellData("TestPlan", 0, tpRowNum).trim().equalsIgnoreCase("Yes")) {				
				System.out.println("This is Row Number : " + tpRowNum + "\n");
				RefSuiteName.put(KeyRowCount, xlsreader.getCellData("TestPlan", "SuiteName", tpRowNum));
				SuiteName.put(xlsreader.getCellData("TestPlan", "SuiteName", tpRowNum),
						xlsreader.getCellData("TestPlan", "SuiteName", tpRowNum));
				TestSuiteIndex.put(xlsreader.getCellData("TestPlan", "SuiteName", tpRowNum), String.valueOf(Refi));
				Configuration.put(xlsreader.getCellData("TestPlan", "SuiteName", tpRowNum),
						xlsreader.getCellData("TestPlan", "Configuration", tpRowNum));
				Refi++;
			}
		}
		// Initializing Iterator for SuiteName HashTable.
		int refCount = 2;
		Collection HashCollector = SuiteName.values();
		Iterator SuiteNameItr = HashCollector.iterator();
		while (SuiteNameItr.hasNext()) {
			suitename = SuiteNameItr.next().toString();
			// Populating Credentials, and application urls from spread sheet.
			configurationName = Configuration.get(suitename);
			for (int rowNumb = 2; rowNumb <= xlsreader.getRowCount("Configs"); rowNumb++) {
				if (configurationName == xlsreader.getCellData("Configs", "ConfigurationName", rowNumb)) {
					for (int colNumb = 1; colNumb < xlsreader.getColumnCount("Configs"); colNumb++) {
						CredentialConfigStore.put(
								configurationName + "." + xlsreader.getCellData("Configs", colNumb, 1),
								xlsreader.getCellData("Configs", colNumb, rowNumb).toString());
						System.out.println("The Credential Information for the Suite " + suitename + " is :"
								+ CredentialConfigStore.get(xlsreader.getCellData("Configs", colNumb, 1)));
						System.out.println("The Key is : " + configurationName + "."
								+ xlsreader.getCellData("Configs", colNumb, 1));

					}
				}
			}

			// Populating Global Variables and Values into Configuration Data
			// Store.
			String ConfigSuite = Configuration.get(suitename);
			for (int tpRowNum = 2; tpRowNum <= xlsreader.getRowCount(ConfigSuite); tpRowNum++) {

				System.out.println("The Configuration that will be loaded is : " + ConfigSuite + "\n");
				System.out.println("The Parameter that is being loaded is : "
						+ xlsreader.getCellData(ConfigSuite, "GlobalParameterName", tpRowNum) + "\n");
				System.out.println("The Parameter value that is being loaded is : "
						+ xlsreader.getCellData(ConfigSuite, "GlobalParameterName", tpRowNum).toString() + "\n");
				ConfigStore.put(xlsreader.getCellData(ConfigSuite, "GlobalParameterName", tpRowNum),
						xlsreader.getCellData(ConfigSuite, "GlobalParameterValue", tpRowNum));
			}

			// Clean Downloads_Folder directory
//			File downloads_path = new File(System.getProperty("user.dir") + "\\src\\main\resources\\Downloads_Folder\\");
//			org.apache.commons.io.FileUtils.cleanDirectory(downloads_path);

			// Populating TestData into TestCaseData Hash Map
			switch (suitename) {

			case "TestSetup":
			case "HSPTestSetup":
				int suiteRowNum = 2;

				int TotalTestCases = xlsreader.getRowCount(suitename);
				while (suiteRowNum <= TotalTestCases) {
					if ((xlsreader.getCellData(suitename, "Runmode", suiteRowNum).equals("Y")
							&& RunAll.equalsIgnoreCase("No")) || RunAll.equalsIgnoreCase("Yes")) {

						try {

							String TCRowNum = String.valueOf(_rowCount);
							System.out.println("The Count of Test Cases : " + TCRowNum);
							currentTest = xlsreader.getCellData(suitename, "Testcase", suiteRowNum);
							currentTestCaseID = xlsreader.getCellData(suitename, "TC ID", suiteRowNum);
							System.out.println(
									"The Current Test Case is : " + currentTestCaseID + " - " + currentTest + "\n");

							System.out.println("Loading the TestCase " + currentTest + " data into Hashmap.\n");
							TestCaseData.put(xlsreader.getCellData(suitename, "TC ID", suiteRowNum),
									xlsreader.getCellData(suitename, "TC ID", suiteRowNum));

							TestCaseData.put(xlsreader.getCellData(suitename, "Testcase", suiteRowNum),
									xlsreader.getCellData(suitename, "TestData", suiteRowNum));

							TestSuite.put(TCRowNum, xlsreader.getCellData(suitename, "Testcase", suiteRowNum));
							TestCaseIndex.put(xlsreader.getCellData(suitename, "Testcase", suiteRowNum), suitename);
							System.out.println("TestCase data for the Test case " + currentTest
									+ " loaded successfully into Hashmap.\n");
							_rowCount++;

						} catch (Throwable t) {

							System.out.println("Exception caught is : " + t);
						}
					}

					suiteRowNum++;

				}

				;
				break;

			case "Sanity_MPCP":
				int SanitysuiteRowNum = 2;
				int SanityTotalTestCases = xlsreader.getRowCount(suitename);
				while (SanitysuiteRowNum <= SanityTotalTestCases) {
					if ((xlsreader.getCellData(suitename, "Runmode", SanitysuiteRowNum).equals("Y")
							&& RunAll.equalsIgnoreCase("No")) || RunAll.equalsIgnoreCase("Yes")) {

						try {

							String TCRowNum = String.valueOf(_rowCount);
							System.out.println("The Count of Test Cases : " + TCRowNum);
							currentTest = xlsreader.getCellData(suitename, "Testcase", SanitysuiteRowNum);
							System.out.println("The Current Test Case is : " + currentTest + "\n");
							System.out.println("Loading the TestCase " + currentTest + " data into Hashmap.\n");
							TestCaseData.put(xlsreader.getCellData(suitename, "Testcase", SanitysuiteRowNum),
									xlsreader.getCellData(suitename, "TestData", SanitysuiteRowNum));
							TestSuite.put(TCRowNum, xlsreader.getCellData(suitename, "Testcase", SanitysuiteRowNum));
							TestCaseIndex.put(xlsreader.getCellData(suitename, "Testcase", SanitysuiteRowNum),
									"Sanity_MPCP");
							System.out.println("TestCase data for the Test case " + currentTest
									+ " loaded successfully into Hashmap.\n");
							_rowCount++;

						} catch (Throwable t) {

							System.out.println("Exception Caught is : " + t);
						}
					}

					SanitysuiteRowNum++;

				}

			case "JazzSanity":
				int JazzSanitysuiteRowNum = 2;
				int JazzSanityTotalTestCases = xlsreader.getRowCount(suitename);
				while (JazzSanitysuiteRowNum <= JazzSanityTotalTestCases) {
					if ((xlsreader.getCellData(suitename, "Runmode", JazzSanitysuiteRowNum).equals("Y")
							&& RunAll.equalsIgnoreCase("No")) || RunAll.equalsIgnoreCase("Yes")) {

						try {

							String TCRowNum = String.valueOf(_rowCount);
							System.out.println("The Count of Test Cases : " + TCRowNum);
							currentTest = xlsreader.getCellData(suitename, "Testcase", JazzSanitysuiteRowNum);
							System.out.println("The Current Test Case is : " + currentTest + "\n");
							System.out.println("Loading the TestCase " + currentTest + " data into Hashmap.\n");
							TestCaseData.put(xlsreader.getCellData(suitename, "Testcase", JazzSanitysuiteRowNum),
									xlsreader.getCellData(suitename, "TestData", JazzSanitysuiteRowNum));
							TestSuite.put(TCRowNum, xlsreader.getCellData(suitename, "Testcase", JazzSanitysuiteRowNum));
							TestCaseIndex.put(xlsreader.getCellData(suitename, "Testcase", JazzSanitysuiteRowNum),
									"JazzSanity");
							System.out.println("TestCase data for the Test case " + currentTest
									+ " loaded successfully into Hashmap.\n");
							_rowCount++;

						} catch (Throwable t) {

							System.out.println("Exception Caught is : " + t);
						}
					}

					JazzSanitysuiteRowNum++;

				}
			case "HSPSanity":
				int HSPSanitysuiteRowNum = 2;
				int HSPSanityTotalTestCases = xlsreader.getRowCount(suitename);
				while (HSPSanitysuiteRowNum <= HSPSanityTotalTestCases) {
					if ((xlsreader.getCellData(suitename, "Runmode", HSPSanitysuiteRowNum).equals("Y")
							&& RunAll.equalsIgnoreCase("No")) || RunAll.equalsIgnoreCase("Yes")) {

						try {

							String TCRowNum = String.valueOf(_rowCount);
							System.out.println("The Count of Test Cases : " + TCRowNum);
							currentTest = xlsreader.getCellData(suitename, "Testcase", HSPSanitysuiteRowNum);
							System.out.println("The Current Test Case is : " + currentTest + "\n");
							System.out.println("Loading the TestCase " + currentTest + " data into Hashmap.\n");
							TestCaseData.put(xlsreader.getCellData(suitename, "Testcase", HSPSanitysuiteRowNum),
									xlsreader.getCellData(suitename, "TestData", HSPSanitysuiteRowNum));
							TestSuite.put(TCRowNum, xlsreader.getCellData(suitename, "Testcase", HSPSanitysuiteRowNum));
							TestCaseIndex.put(xlsreader.getCellData(suitename, "Testcase", HSPSanitysuiteRowNum),
									suitename);
							System.out.println("TestCase data for the Test case " + currentTest
									+ " loaded successfully into Hashmap.\n");
							_rowCount++;

						} catch (Throwable t) {

							System.out.println("Exception Caught is : " + t);
						}
					}

					HSPSanitysuiteRowNum++;

				}

				break;


			case "508_Compliance":
				int AccessibilityTestRowNum = 2;
				int AccessibilityTestTotalTestCases = xlsreader.getRowCount(suitename);
				while (AccessibilityTestRowNum <= AccessibilityTestTotalTestCases) {
					if ((xlsreader.getCellData(suitename, "Runmode", AccessibilityTestRowNum).equals("Y")
							&& RunAll.equalsIgnoreCase("No")) || RunAll.equalsIgnoreCase("Yes")) {

						try {
							String TCRowNum = String.valueOf(_rowCount);
							System.out.println("The Count of Test Cases : " + TCRowNum);
							currentTest = xlsreader.getCellData(suitename, "Testcase", AccessibilityTestRowNum);
							System.out.println("The Current Test Case is : " + currentTest + "\n");
							System.out.println("Loading the TestCase " + currentTest + " data into Hashmap.\n");
							TestCaseData.put(xlsreader.getCellData(suitename, "Testcase", AccessibilityTestRowNum),
									xlsreader.getCellData(suitename, "TestData", AccessibilityTestRowNum));
							TestSuite.put(TCRowNum,
									xlsreader.getCellData(suitename, "Testcase", AccessibilityTestRowNum));
							TestCaseIndex.put(xlsreader.getCellData(suitename, "Testcase", AccessibilityTestRowNum),
									suitename);
							System.out.println("TestCase data for the Test case " + currentTest
									+ " loaded successfully into Hashmap.\n");

							_rowCount++;
						} catch (Throwable t) {

							System.out.println("Exception Caught is : " + t);
						}
					}
					AccessibilityTestRowNum++;
				}

				break;
				

				
			case "RegressionTB20":
				
				int RegressionsuiteRowNum = 2;
				int RegressionTotalTestCases = xlsreader.getRowCount(suitename);
				while (RegressionsuiteRowNum <= RegressionTotalTestCases) {
					if ((xlsreader.getCellData(suitename, "Runmode", RegressionsuiteRowNum).equals("Y")
							&& RunAll.equalsIgnoreCase("No")) || RunAll.equalsIgnoreCase("Yes")) {

						try {
							String TCRowNum = String.valueOf(_rowCount);
							System.out.println("The Count of Test Cases : " + TCRowNum);
							currentTest = xlsreader.getCellData(suitename, "Testcase", RegressionsuiteRowNum);
							System.out.println("The Current Test Case is : " + currentTest + "\n");
							System.out.println("Loading the TestCase " + currentTest + " data into Hashmap.\n");
							TestCaseData.put(xlsreader.getCellData(suitename, "Testcase", RegressionsuiteRowNum),
									xlsreader.getCellData(suitename, "TestData", RegressionsuiteRowNum));
							TestSuite.put(TCRowNum,
									xlsreader.getCellData(suitename, "Testcase", RegressionsuiteRowNum));
							TestCaseIndex.put(xlsreader.getCellData(suitename, "Testcase", RegressionsuiteRowNum),
									suitename);
							System.out.println("TestCase data for the Test case " + currentTest
									+ " loaded successfully into Hashmap.\n");

							_rowCount++;
						} catch (Throwable t) {

							System.out.println("Exception Caught is : " + t);
						}
					}
					RegressionsuiteRowNum++;
				}

				break;

				
			case "RegressionJazz":
				
				int JazzRegressionsuiteRowNum = 2;
				int JazzRegressionTotalTestCases = xlsreader.getRowCount(suitename);
				while (JazzRegressionsuiteRowNum <= JazzRegressionTotalTestCases) {
					if ((xlsreader.getCellData(suitename, "Runmode", JazzRegressionsuiteRowNum).equals("Y")
							&& RunAll.equalsIgnoreCase("No")) || RunAll.equalsIgnoreCase("Yes")) {

						try {
							String TCRowNum = String.valueOf(_rowCount);
							System.out.println("The Count of Test Cases : " + TCRowNum);
							currentTest = xlsreader.getCellData(suitename, "Testcase", JazzRegressionsuiteRowNum);
							System.out.println("The Current Test Case is : " + currentTest + "\n");
							System.out.println("Loading the TestCase " + currentTest + " data into Hashmap.\n");
							TestCaseData.put(xlsreader.getCellData(suitename, "Testcase", JazzRegressionsuiteRowNum),
									xlsreader.getCellData(suitename, "TestData", JazzRegressionsuiteRowNum));
							TestSuite.put(TCRowNum,
									xlsreader.getCellData(suitename, "Testcase", JazzRegressionsuiteRowNum));
							TestCaseIndex.put(xlsreader.getCellData(suitename, "Testcase", JazzRegressionsuiteRowNum),
									suitename);
							System.out.println("TestCase data for the Test case " + currentTest
									+ " loaded successfully into Hashmap.\n");

							_rowCount++;
						} catch (Throwable t) {

							System.out.println("Exception Caught is : " + t);
						}
					}
					JazzRegressionsuiteRowNum++;
				}

				break;		
					
				
			case "BuildAccTest":
				
				int BuildAccTestsuiteRowNum = 2;
				int BuildAccTestTotalTestCases = xlsreader.getRowCount(suitename);
				while (BuildAccTestsuiteRowNum <= BuildAccTestTotalTestCases) {
					if ((xlsreader.getCellData(suitename, "Runmode", BuildAccTestsuiteRowNum).equals("Y")
							&& RunAll.equalsIgnoreCase("No")) || RunAll.equalsIgnoreCase("Yes")) {

						try {
							String TCRowNum = String.valueOf(_rowCount);
							System.out.println("The Count of Test Cases : " + TCRowNum);
							currentTest = xlsreader.getCellData(suitename, "Testcase", BuildAccTestsuiteRowNum);
							System.out.println("The Current Test Case is : " + currentTest + "\n");
							System.out.println("Loading the TestCase " + currentTest + " data into Hashmap.\n");
							TestCaseData.put(xlsreader.getCellData(suitename, "Testcase", BuildAccTestsuiteRowNum),
									xlsreader.getCellData(suitename, "TestData", BuildAccTestsuiteRowNum));
							TestSuite.put(TCRowNum,
									xlsreader.getCellData(suitename, "Testcase", BuildAccTestsuiteRowNum));
							TestCaseIndex.put(xlsreader.getCellData(suitename, "Testcase", BuildAccTestsuiteRowNum),
									suitename);
							System.out.println("TestCase data for the Test case " + currentTest
									+ " loaded successfully into Hashmap.\n");

							_rowCount++;
						} catch (Throwable t) {

							System.out.println("Exception Caught is : " + t);
						}
					}
					BuildAccTestsuiteRowNum++;
				}

				break;				
				
		case "CSAnywhere":
				
				int CSAnywheresuiteRowNum = 2;
				int CSAnywhereTotalTestCases = xlsreader.getRowCount(suitename);
				while (CSAnywheresuiteRowNum <= CSAnywhereTotalTestCases) {
					if ((xlsreader.getCellData(suitename, "Runmode", CSAnywheresuiteRowNum).equals("Y")
							&& RunAll.equalsIgnoreCase("No")) || RunAll.equalsIgnoreCase("Yes")) {

						try {
							String TCRowNum = String.valueOf(_rowCount);
							System.out.println("The Count of Test Cases : " + TCRowNum);
							currentTest = xlsreader.getCellData(suitename, "Testcase", CSAnywheresuiteRowNum);
							System.out.println("The Current Test Case is : " + currentTest + "\n");
							System.out.println("Loading the TestCase " + currentTest + " data into Hashmap.\n");
							TestCaseData.put(xlsreader.getCellData(suitename, "Testcase", CSAnywheresuiteRowNum),
									xlsreader.getCellData(suitename, "TestData", CSAnywheresuiteRowNum));
							TestSuite.put(TCRowNum,
									xlsreader.getCellData(suitename, "Testcase", CSAnywheresuiteRowNum));
							TestCaseIndex.put(xlsreader.getCellData(suitename, "Testcase", CSAnywheresuiteRowNum),
									suitename);
							System.out.println("TestCase data for the Test case " + currentTest
									+ " loaded successfully into Hashmap.\n");

							_rowCount++;
						} catch (Throwable t) {

							System.out.println("Exception Caught is : " + t);
						}
					}
					CSAnywheresuiteRowNum++;
				}

				break;
				
			case "NewFeatures":
				int NewFeaturessuiteRowNum = 2;
				int NewFeaturesTotalTestCases = xlsreader.getRowCount(suitename);
				while (NewFeaturessuiteRowNum <= NewFeaturesTotalTestCases) {
					if ((xlsreader.getCellData(suitename, "Runmode", NewFeaturessuiteRowNum).equals("Y")
							&& RunAll.equalsIgnoreCase("No")) || RunAll.equalsIgnoreCase("Yes")) {

						try {
							String TCRowNum = String.valueOf(_rowCount);
							System.out.println("The Count of Test Cases : " + TCRowNum);
							currentTest = xlsreader.getCellData(suitename, "Testcase", NewFeaturessuiteRowNum);
							System.out.println("The Current Test Case is : " + currentTest + "\n");
							System.out.println("Loading the TestCase " + currentTest + " data into Hashmap.\n");
							TestCaseData.put(xlsreader.getCellData(suitename, "Testcase", NewFeaturessuiteRowNum),
									xlsreader.getCellData(suitename, "TestData", NewFeaturessuiteRowNum));
							TestSuite.put(TCRowNum,
									xlsreader.getCellData(suitename, "Testcase", NewFeaturessuiteRowNum));
							TestCaseIndex.put(xlsreader.getCellData(suitename, "Testcase", NewFeaturessuiteRowNum),
									suitename);
							System.out.println("TestCase data for the Test case " + currentTest
									+ " loaded successfully into Hashmap.\n");

							_rowCount++;
						} catch (Throwable t) {

							System.out.println("Exception Caught is : " + t);
						}
					}
					NewFeaturessuiteRowNum++;
				}

				break;

			}
			refCount++;
		}
		String Loglevel = POMSuiteRunner.ConfigStore.get("_LogLevel").toString();
		switch (Loglevel) {

		case "DEBUG":
			PropertyConfigurator.configure("Log4j_DEBUG.properties");
			break;
		case "INFO":
			PropertyConfigurator.configure( Resources.getResource("config/TVSMOTOR/AUTOMATION_Config.xls") );// "Log4j_INFO.properties");
			break;
		}

		Collection HashCollector1 = SuiteName.values();
		Iterator SuiteNameItr1 = HashCollector1.iterator();
		while (SuiteNameItr1.hasNext())
			System.out.println("The SuiteName from HashTable is :" + SuiteNameItr1.next() + "\n");

		Collection ConfigCollector = Configuration.values();
		Iterator ConfigurationItr = ConfigCollector.iterator();
		Iterator SuiteNameItr2 = HashCollector1.iterator();
		while (ConfigurationItr.hasNext() && SuiteNameItr2.hasNext())
			System.out.println("The Configuration for " + SuiteNameItr2.next() + " from HashTable is :"
					+ ConfigurationItr.next() + "\n");

		Collection TestDataCollector = TestCaseData.values();
		Iterator TestDataCollectorItr = TestDataCollector.iterator();
		while (TestDataCollectorItr.hasNext())
			System.out.println("The TestCaseData  is : " + TestDataCollectorItr.next().toString() + "\n");

		Collection ConfigStoreCollector = ConfigStore.values();
		Iterator ConfigStoreCollectorItr = ConfigStoreCollector.iterator();
		while (ConfigStoreCollectorItr.hasNext())
			System.out.println("The Configuration Data  is : " + ConfigStoreCollectorItr.next().toString() + "\n");

		Collection CredentialStoreCollector = CredentialConfigStore.values();
		Iterator CredentialStoreCollectorItr = CredentialStoreCollector.iterator();
		while (CredentialStoreCollectorItr.hasNext())
			System.out.println("The Credential Data  is : " + CredentialStoreCollectorItr.next().toString() + "\n");

		for (int i = 0; i < _rowCount; i++) {
			String TCext = String.valueOf(i);
			System.out.println("The Test Cases are : " + TestSuite.get(TCext));

		}

		SuiteRunner suiterunner = new SuiteRunner();
		
		//Run tests
		suiterunner.run();
		// super.run();
	}

	public static void ReadExcel(String filePath) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(filePath));
//			Workbook wb = WorkbookFactory.create(inputStream);
//			FileInputStream inputStream = new FileInputStream(new File(filePath));

			Workbook wb = new XSSFWorkbook(inputStream);

			int numberOfSheet = wb.getNumberOfSheets();

			for (int i = 0; i < numberOfSheet; i++) {
				Sheet sheet = wb.getSheetAt(i);
				// .... Customize your code here
				// To get sheet name, try -> sheet.getSheetName()
			}
		} catch (Exception ec) {

		}
	}

	public static boolean insertMultiExcelCellData(String filePath, String strSheetName, String strCellValueKeyPair)
			throws IOException {

		boolean retValue = false;
		try {
			FileInputStream inputStream = new FileInputStream(new File(filePath));
			@SuppressWarnings("resource")
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Workbook workbook = WorkbookFactory.create(inputStream);
//			FileInputStream inputStream = new FileInputStream(new File(filePath));

			Workbook workbook = new XSSFWorkbook(inputStream);

			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(strSheetName);
			CellReference ref;

			// Reaad the semicolon separated key value pairs of cell and value
			// in an array
			// "A1:10;A2:20;A3:Viru"
			if (strCellValueKeyPair.contains(":")) // Check if there is at least
													// one pair of cell & value
			{
				String strCellName = "";
				String strCellData = "";

				// Split the string on semicolon
				String[] arrCellValuePairs = strCellValueKeyPair.split(";");

				// Loop through the pairs of cell and value to insert
				for (String strPairs : arrCellValuePairs) {
					// Split the strings on : to get the cellname and cell value
					String[] strCellValuPair = strPairs.split(":");

					strCellName = strCellValuPair[0];
					strCellData = strCellValuPair[1];

					ref = new CellReference(strCellName);

					Row r = sheet.getRow(ref.getRow());
					if (r == null) {
						System.out.println("The row does not exist, creating one: " + strCellName);
						int row = ref.getRow();
						sheet.createRow(row);
						r = sheet.getRow(ref.getRow());
					}

					Cell c = r.getCell(ref.getCol());
					if (c == null) {
						System.out.println("The cell does not exist, creating one: " + strCellName);
						c = r.createCell(ref.getCol());
					}

					// Set the new value in the cell
					System.out.println("Set the new value in the cell: " + strCellData);
					c.setCellValue(strCellData);

					// Set the new value in the cell
					c = r.getCell(ref.getCol());
					if (null != c.getRichStringCellValue().getString()) {
						System.out.println("The new value inserted in cell " + strCellName + "is: "
								+ c.getRichStringCellValue().getString());
						retValue = true;
						;
					} else {
						System.out.println("Failed to insert new value in cell " + strCellName + "is: "
								+ c.getRichStringCellValue().getString());
						return retValue;
					}

				} // End of loop to insert in to new cells

				inputStream.close();

				// Write into the file now
				try {
					FileOutputStream outputStream = new FileOutputStream(new File(filePath));
					workbook.write(outputStream);
					((BufferedReader) workbook).close();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			} // End of check for ":"
			else {
				System.out.println(
						"Failed! There is not a single pair of cell and vlaue in the format: \"A1:10;A2:20;A3:Viru\" to insert.");
			}

		} catch (Exception exception) {
			retValue = false;
			System.out.println("Error! The file: " + filePath
					+ " is either not found or being used by another application! please check.");
			exception.printStackTrace();
		}

		return retValue;

	}
}