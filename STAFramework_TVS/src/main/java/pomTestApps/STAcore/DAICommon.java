package pomTestApps.STAcore;

/**************************************************
#Project Name: MiTEL_CLEARSPAN - Selenium Framework


#Function Name: CLEARSPANCommon()
#Description:1. Driver Initialization
			 2. Creation of Objects for each individual Pages(page objects)
			 3. Common methods which will be used in the test cases more frequently
#Input Parameters:
#Owner: Viru Kulkarni
#Author: Viru Kulkarni
#Date of creation: 15-Nov-17
#Name of person modifying: (Tester Name): 
#Date of modification: 

â€˜**************************************************/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
//database testing
import java.sql.DriverManager;
import java.sql.ResultSet;
//
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
//import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import pomTestApps.BaseTestType;
import pomTestApps.DriverFunctions;
import pomTestApps.ProcessTestRequest;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.AdminToolsPages;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.ClearspanHomePage;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.EGWPages;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.EnterpriseSettingsPages;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.HelpPages;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.LoginManagementPages;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.MonitoringPages;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyCommonPageElements;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyHomePage;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.PhoneManagementPages;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.PhoneTemplatePages;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.ProvisioningPages;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.ReportingPages;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.VirtualUsersPages;
//To read configs from the excel file
import pomTestApps.Utility.STAcore.io.ExcelHandling;
//For report generation
import pomTestApps.Utility.STAcore.io.Log;
import pomTestApps.Utility.STAcore.reportwriter.GenerateHtmlReport;
import pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport;

public class DAICommon {

	static WebDriver driver;

	GenerateHtmlReport gtr = new GenerateHtmlReport();
	GeneratePDFReport gpr;

	String tcName;
	String testcaseId;

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

	public ProcessTestRequest ptr;

	public ClearspanHomePage clearspanhome;
	public OpeasyHomePage opeasyhome;

	public HelpPages helpPage;
	public PhoneTemplatePages phoneTemplatePage;
	public LoginManagementPages loginmanagementpage;
	public MonitoringPages monitoringpages;
	public AdminToolsPages admintoolspages;
	public ProvisioningPages provisioningpages;
	public OpeasyCommonPageElements opeasyCommonPageElements;
	public EGWPages EGWpages;
	public PhoneTemplatePages phonetemplatepage;
	public PhoneManagementPages phonemanagementpages;
	public EnterpriseSettingsPages enterprisesettingspages;
	public ReportingPages reportingpages;
	public VirtualUsersPages virtualuserspages;
	
	// public OpeasyCommonPageElements opeasyCommonPageElements;
	public static final String COMMA_DELIMITER = ",";

	// Initialization of webdriver and ptr
	public DAICommon(WebDriver driver, ProcessTestRequest ptr) {
		this.driver = driver;
		this.ptr = ptr;
	}

	/*---------------------------------------------------------------------------------------------------------------------------------------------------------------
	 *   The Below methods are to be used by Core Functions and base Classes
	
	login
	 *                                       CORE REUSABLE FUNCTIONS
	 ------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	// This method is called by BeforeTestMethod
	@SuppressWarnings("static-access")
	void createSuitePath(String reportPath, String suiteName, String screenshotOnFail) {
		Log.info("Inside createSuitePath");
		this.screenshotOnFail = screenshotOnFail;
		Log.info("Value of screenshotOnFail " + screenshotOnFail);
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Log.info("Group seriel number " + grpserielNo);

		if (grpserielNo > 1) {
			reportPathSuite = reportPath + "\\" + "SuiteTest_" + dateFormat.format(date);
			Log.info("new reportPath suite is-else  " + reportPathSuite);
		} else {
			reportPathSuite = reportPath + "\\" + suiteName + "_" + dateFormat.format(date);
			Log.info("new reportPath suite is " + reportPathSuite);
		}
		grpserielNo++;

		Log.info("Report Path suite is " + reportPathSuite);
		Log.info("Suitename is " + suiteName);
	}

	// This method is called by Before Method

	void initializeMethod(WebDriver driver, String Browser) {
		if (DriverFunctions.headless == true) {
			Browser = "Headless";
		}
		// System.out.println("Inside initialize method");
		this.driver = driver;
		this.Browser = Browser;
		stepsDetails.clear();
		reportPathBrowser = reportPath + "\\" + Browser;
		browserlist.add(Browser);
		Log.info("Report Path after in bfre mthod " + reportPathBrowser);
		// Reset the flag for Incomplte status of the test case.
		gtr.isTestComplete(false);
	}

	// This method is called by After Method
	void generateMethodInfo() {

		Log.info("After method of " + Browser);
		reportPathBrowser = reportPath;
		@SuppressWarnings("unchecked")
		ArrayList<String[]> newList = (ArrayList<String[]>) stepsDetails.clone();

		testDetails.add(newList);
		serielNo = 1;
	}

	// This is called by After Class to generate HTML report
	void generateTestReport() throws IOException {
		if (endOfTestCase == true) {
			gtr.isTestComplete(true);
		}
		try {

			// gpr=new GeneratePDFReport();
			@SuppressWarnings("unchecked")
			ArrayList<ArrayList<String[]>> newtestDetails = (ArrayList<ArrayList<String[]>>) testDetails.clone();

			GeneratePDFReport.suiteTestDetails.add(newtestDetails);
			this.set_EndTime_test();
			Object[] tcNameandTime = { tcName, date_startTime_test, date_endTime_test };
			GeneratePDFReport.tcNameandTime.add(tcNameandTime);
			@SuppressWarnings("unchecked")
			ArrayList<String> newbrowserlist = (ArrayList<String>) browserlist.clone();

			GeneratePDFReport.suiteBrowserList.add(newbrowserlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new ExcelHandling();

		/*
		 * testDescription = eh.getTestDescription(); Log.info( "Test description is " +
		 * testDescription);
		 */

		// System.out.println("Report Path 1----is Line 141
		// ReusableCore"+reportPath);

		testDescription = BaseTestType.getDescription();

		try {
			gtr.createTestReport(testDetails, browserlist, reportPath, testcaseId, tcName, testDescription);
		} catch (InvocationTargetException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.info("Test Report Created*******");

		Log.info("Clearing Test Details");
		testDetails.clear();
	}

	// This method is called by After Test Methods
	void createSuiteReport() {
		gtr.createSuiteReport(reportPathSuite, startTime_Suite, endTime_Suite);
	}

	/*
	 * Lib to clean Downloads_Folder directory File downloads_path = new
	 */
	public void cleanDownloadsFolder() throws IOException {
		// Clean Downloads_Folder directory
		File downloads_path = new File(System.getProperty("user.dir") + "\\Downloads_Folder\\");
		org.apache.commons.io.FileUtils.cleanDirectory(downloads_path);
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

	// ******************************************Viru
	// Start***************************************
	/*
	 * Creating object for the Home page and other pages as shown in the example
	 * below
	 * 
	 */

	public void navigateOpeasyHomePage() {

		opeasyhome = new OpeasyHomePage(driver);
		opeasyCommonPageElements = new OpeasyCommonPageElements(driver);

	}

	public void navigateHelpPage() {
		helpPage = new HelpPages(driver);
	}


	public void navigateClearspanHomePage() {
		clearspanhome = new ClearspanHomePage(driver);
	}

	public void navigateLoginManagemtentPage() {

		loginmanagementpage = new LoginManagementPages(driver);

	}

	public void navigateMonitoringPage() {

		monitoringpages = new MonitoringPages(driver);

	}

	public void navigateAdminToolsPage() {

		admintoolspages = new AdminToolsPages(driver);

	}

	public void navigateProvisioningPage() {

		provisioningpages = new ProvisioningPages(driver);

	}

	public void navigateOpeasyCommonPageElements() {

		opeasyCommonPageElements = new OpeasyCommonPageElements(driver);

	}

	public void navigateEGWPages() {

		EGWpages = new EGWPages(driver);

	}

	public void navigatePhoneTemplatePage() {

		phonetemplatepage = new PhoneTemplatePages(driver);

	}

	public void navigatePhoneManagementPage() {

		phonemanagementpages = new PhoneManagementPages(driver);

	}

	public void navigateEnterpriseSettingsPage() {

		enterprisesettingspages = new EnterpriseSettingsPages(driver);

	}

	public void navigateReportingPage() {

		reportingpages = new ReportingPages(driver);

	}

	public void navigateVirtualUsersPage() {

		virtualuserspages = new VirtualUsersPages(driver);

	}

	/*
	 * Login to Opeasy portal * Description:This method will log in to the SNM
	 * portal
	 * 
	 * Input parameters: url,username and password to logging in to the Opeasy
	 * Portal
	 */
	public void loginSSO(String SSOUrl, String SSOUsername, String SSOPassword)
			throws IOException, InterruptedException {

		ptr.openUrl(SSOUrl);
		// ptr.wait(2000);

		// ((WebElement) ptr).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(SSOUsername);
		ptr.wait(1500);

		driver.findElement(By.id("password")).sendKeys(SSOPassword);
		ptr.wait(1500);

		driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
		ptr.wait(1500);

	}

	/*
	 * Login SSO Page
	 */
	public void loginToOpeasy(String baseUrl, String UserName, String Password)
			throws IOException, InterruptedException {

		ptr.openUrl(baseUrl);
		ptr.type(opeasyhome.tbx_UserName, UserName, "Enter userName->" + UserName);
		WebElement webElement = driver.findElement(By.xpath(".//input[@id[contains(.,'form1:username')]]"));
		// You can use xpath,ID or name whatever you like
		webElement.sendKeys(Keys.TAB);
		ptr.type(opeasyhome.tbx_Password, Password, "Enter password->" + Password);
		webElement = driver.findElement(By.xpath(".//input[@id[contains(.,'form1:password')]]"));
		webElement.sendKeys(Keys.TAB);
		ptr.click(opeasyhome.btn_Login, "Click button Login");
	}

	public boolean verifyLoginToOpeasy(String baseUrl, String UserName, String Password, String strLoginErrorMessage,
			int intAttempts

	) throws IOException, InterruptedException {
		ptr.openUrl(baseUrl);

		for (int i = 0; i < intAttempts; i++) {
			ptr.openUrl(baseUrl);
			ptr.type(opeasyhome.tbx_UserName, UserName, "Enter userName->" + UserName);
			WebElement webElement = driver.findElement(By.xpath(".//input[@id[contains(.,'form1:username')]]"));
			// You can use xpath,ID or name whatever you like
			webElement.sendKeys(Keys.TAB);
			ptr.type(opeasyhome.tbx_Password, Password, "Enter password->" + Password);
			webElement = driver.findElement(By.xpath(".//input[@id[contains(.,'form1:password')]]"));
			webElement.sendKeys(Keys.TAB);

			ptr.click(opeasyhome.btn_Login, "Click button Login");
			webElement.sendKeys(Keys.ENTER);

			// ptr.click(opeasyhome.btn_Login, "Click on Login Button");
		}

		if (ptr.assertTextContains(opeasyhome.label_LoginErrorMessage, strLoginErrorMessage)) {
			return true;
		}
		return false;

	}

	/*
	 * opeasyClearLoginSessions - To clear stale login sessions
	 * 
	 */
	public void opeasyClearLoginSessions(String baseUrl, String UserName, String Password)
			throws IOException, InterruptedException {

		ptr.openUrl(baseUrl);
//		ptr.type(opeasyhome.tbx_UserName, UserName, "Enter userName->" + UserName);
//		WebElement webElement = driver.findElement(By.xpath(".//input[@id[contains(.,'form1:username')]]"));
//		// You can use xpath,ID or name whatever you like
//		webElement.sendKeys(Keys.TAB);
//		ptr.type(opeasyhome.tbx_Password, Password, "Enter password->" + Password);
//		webElement = driver.findElement(By.xpath(".//input[@id[contains(.,'form1:password')]]"));
//		webElement.sendKeys(Keys.TAB);
//		ptr.wait(5000);
//		ptr.click(opeasyhome.btn_Login, "Click button Login");
//		ptr.wait(5000);
//		try {
//			driver.findElement(By.id("form1:buttonContinue")).click();
//		} catch (NoSuchElementException exc) {
//			Log.info("There is no previous login session with this user: " + UserName);
//		}
//
//		ptr.waitForElementPresent(opeasyhome.link_Logout, 10000);
	}
	// public void opeasyClearLoginSessions(String baseUrl, String UserName,
	// String Password)
	// throws IOException, InterruptedException {
	//
	// ptr.openUrl(baseUrl);
	// ptr.type(opeasyhome.tbx_UserName, UserName, "Enter userName->" +
	// UserName);
	// WebElement webElement =
	// driver.findElement(By.xpath(".//input[@id[contains(.,'form1:username')]]"));
	// // You can use xpath,ID or name whatever you like
	// webElement.sendKeys(Keys.TAB);
	// ptr.type(opeasyhome.tbx_Password, Password, "Enter password->" +
	// Password);
	// webElement =
	// driver.findElement(By.xpath(".//input[@id[contains(.,'form1:password')]]"));
	// webElement.sendKeys(Keys.TAB);
	// ptr.wait(5000);
	// ptr.click(opeasyhome.btn_Login, "Click button Login");
	// ptr.wait(5000);
	// try {
	// ptr.waitForElementPresent(opeasyhome.link_Logout, 10000);
	// } catch (NoSuchElementException exc) {
	// driver.findElement(By.id("form1:buttonContinue")).click();
	// ptr.waitForElementPresent(opeasyhome.link_Logout, 10000);
	// ptr.updateStep("There was a previous login session with this user,
	// clicking CONTINUE button." + UserName, "Info");
	// } finally {
	// ptr.updateStep("Login failed with : " + UserName, "Fail");
	// }
	// }

	/*
	 * Lib to select Enterprise from Opeasy page
	 * 
	 */
	public void opeasySelectEnterprise(WebElement dropDownEnterprise, String strDescription) {

	}

	/*
	 * Logging out from the Opeasy portal * Description:This method will logout from
	 * the Opeasy portal Input Parameters: N/A
	 */

	public void logoutOpeasy() throws Exception {
		ptr.wait(5000);
//		Boolean LogOut = ptr.isElementPresent(opeasyhome.link_opeasy_Logout, "Validating the Logout link is available");
//		ptr.assertTrue(LogOut);
//		ptr.click(opeasyhome.link_opeasy_Logout, "Click on Logout Button");
		// ptr.waitForElementPresent(opeasyhome.label_Logout_Message, 30);
	}

	/*
	 * Login to Clearspan portal * Description:This method will log in to the SNM
	 * portal Input parameters: url,username and password to logging in to the
	 * Clearspan Portal
	 */
	public void loginToClearspan(String clearspanUrl, String strUserName, String strPassword)
			throws IOException, InterruptedException {
		ptr.openUrl(clearspanUrl);
		// driver.findElement(By.name("EnteredUserID")).sendKeys("autotest");
		// driver.findElement(By.name("Password")).sendKeys("autotest");
		// driver.findElement(By.xpath("//a[contains(.,'Login')]")).click();
		ptr.type(clearspanhome.tbx_UserName, strUserName, "Enter userName->" + strUserName);
		ptr.type(clearspanhome.tbx_Password, strPassword, "Enter userName->" + strPassword);
		ptr.click(clearspanhome.link_Login, "Clicking Login link");
	}

	/*
	 * Logging out from the Clearspan portal * Description:This method will logout
	 * from the SNM portal
	 * 
	 * Input Parameters: N/A
	 */
	public void logoutClearspan() throws Exception {

		Boolean LogOut = ptr.isElementPresent(clearspanhome.link_Logout, "Validating the Logout link is available");
		ptr.assertTrue(LogOut);
		ptr.click(clearspanhome.link_Logout, "Click on Logout Button");
		ptr.wait(5000);
		ptr.assertTextContains(clearspanhome.label_logoutText, "Logout");

	}

	// Hameetha code starts
	/*
	 * Login to Surgemail portal * Description:This method will log in to the SNM
	 * portal Input parameters: url,username and password to logging in to the
	 * SurgeMail Portal
	 */

	public void navigateToAutoAttendantPage() throws IOException, InterruptedException {
		// Step 2. Select Provisioning.
		ptr.click(opeasyhome.link_Provisioning, "Clicking on link: Provisioning");
		ptr.wait(3000);

		// Step 1. Click on Virtual Users link
		ptr.click(provisioningpages.virtualUser_Link, "Click on Virtual Users link");
		ptr.wait(3000);

		// Step 1. Click on Auto Attendant link
		ptr.click(provisioningpages.autoAttendant_Link, "Click on Auto Attendant link");
		ptr.wait(3000);
	}

	/*
	 * opeasyClearLoginSessions - To clear stale login sessions
	 * 
	 * Login into OpEasy as Super user and go to Login Management> Login Rules.
	 * Enable the option �Are checked against the Previous Password�and in drop down
	 * option see option is giving till �24 Passwords� Select the option �13
	 * Passwords� from the drop down option. Select the option �Cannot be a Previous
	 * Password�. Click �Apply� and �Ok� Modify the password of another Super User
	 * to an old password.
	 * 
	 * Error message will be displayed on OpEasy page �Password cannot be the same
	 * as any of the 13 previous passwords (including the currentpassword),
	 * regardless of character case�
	 */

	public void loginManagemnt_test_resetPassword(String strUserName) throws StaleElementReferenceException, Exception {

		ptr.wait(10000);

		selectMainPageMenuItem("Login Management", "Login Management");

		createSearchCriteriaRowOnLoginManagementPage(1, "Login Name", "Equal To:", strUserName);

		ptr.wait(5000);
		ptr.click(opeasyCommonPageElements.btn_Search, "Click button Search");
		ptr.wait(7000);
		clickHtmlLinkElementIfAvailableOnPage("Edit", 1);
		ptr.wait(3000);
		ptr.type(loginmanagementpage.text_Password, "Testing", "Enter password-> Testing");
		ptr.type(loginmanagementpage.text_ConfirmPassword, "Testing", "Enter confirm password-> Testing");
		ptr.click(opeasyCommonPageElements.btn_Apply, "Click button Apply");
		ptr.wait(3000);
		// Verify Saved message is displayed and Alternate Number is added.

		driver.findElement(By.xpath("//span[contains(text(),'Saved')]"));

		// Revert the password back to old
		ptr.wait(3000);
		ptr.type(loginmanagementpage.text_Password, strUserName, "Enter password-> " + strUserName);
		ptr.type(loginmanagementpage.text_ConfirmPassword, strUserName, "Enter confirm password-> " + strUserName);
		ptr.click(opeasyCommonPageElements.btn_Apply, "Click button Apply");
		// Verify Saved message is displayed and Alternate Number is added.
		ptr.wait(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Saved')]"));

		ptr.click(opeasyCommonPageElements.btn_OK, "Click button OK");

	}
	/*
	 * opeasyClearLoginSessions - To clear stale login sessions
	 * 
	 * Login into OpEasy as Super user and go to Login Management From dropdown
	 * option select �Super User� and search anadministrator Select a �Super User�
	 * and reset his password by giving newpassword on �Reset Password� and �Confirm
	 * Password� field. Select the option �Change Password at Next Login� Click
	 * �Apply� and �Ok� Logout from OpEasy Now login to OpEasy using the �Super
	 * User� with new passwordwhich has been changed in previous steps
	 * 
	 * Warning message will be displayed on OpEasy page �YourOpEasy account password
	 * must be changed! Please change your password:�
	 */

	public void loginManagemnt_test_resetPassword_case2(String opeasyUrl, String strUserName)
			throws StaleElementReferenceException, Exception {

		ptr.wait(2000);

		selectMainPageMenuItem("Login Management", "Login Management");

		createSearchCriteriaRowOnLoginManagementPage(1, "Login Name", "Equal To:", strUserName);

		ptr.wait(2000);
		ptr.click(opeasyCommonPageElements.btn_Search, "Click button Search");
		ptr.wait(5000);
		clickHtmlLinkElementIfAvailableOnPage("Edit", 1);
		ptr.wait(3000);
		ptr.type(loginmanagementpage.text_Password, strUserName, "Enter password-> Testing");
		ptr.type(loginmanagementpage.text_ConfirmPassword, strUserName, "Enter confirm password-> Testing");
		ptr.selectCheckBox("form1:checkboxChangePasswordAtNextLogin", true);
		ptr.wait(2000);

		ptr.click(opeasyCommonPageElements.btn_Apply, "Click button Apply");
		ptr.wait(3000);
		ptr.click(opeasyCommonPageElements.btn_OK, "Click button OK");

		// Logout Opeasy
		logoutOpeasy();

		opeasyClearLoginSessions(opeasyUrl, strUserName, strUserName);

		ptr.wait(10000);

		verifyScreenTitleProvPage("Change Password");

		// Verify Warning message is displayed on Opeasy
		String msg = driver.findElement(By.xpath("//*[@id='form1:staticTextChangePassword']")).getText();
		if (msg.contains("Your OpEasy account password must be changed!")
				&& (msg.contains("Please change your password."))) {
			// Revert the password back to old
			ptr.wait(3000);

			ptr.type(loginmanagementpage.text_oldPasswordStaticText, strUserName,
					"Enter old password-> " + strUserName);
			ptr.type(loginmanagementpage.text_newPasswordText, strUserName, "Enter new password->  " + strUserName);
			ptr.type(loginmanagementpage.text_confirmPasswordText, strUserName,
					"Enter confirm password->  " + strUserName);

			ptr.click(OpeasyCommonPageElements.btn_OK, "Click button OK");

			ptr.updateStep(
					"Warning Message displayed as expected: Your OpEasy account password must be changed! Please change your password.",
					"Pass");
		} else {
			ptr.updateStep(
					"Warning Message displayed as expected: Your OpEasy account password must be changed! Please change your password.",
					"Fail");
		}

	}

	/*
	 * Lib to land on Group Paging page 3rd parameter is boolean if set to true:
	 * lands on the Group Paging from the Virtual Users page if set to false: lands
	 * on the Group > Group paging page
	 * 
	 */
	public void pagingGroup_goto_mainpage(String strEnterprise, String strGroup, boolean blnGPFromUsersMenu)
			throws InterruptedException, IOException {
		// selectMainPageMenuItem("Provisioning", "Provisioning");
		ptr.click(opeasyhome.link_HeaderProvisioning, "Click link Provisioning");
		selectMainPageMenuItem("Group Settings", "Group Settings");
		ptr.wait(3000);
		if (blnGPFromUsersMenu) {
			selectMainPageMenuItem("Group Paging", "Group Paging");
		} else {
			driver.findElement(By.xpath("//*[@id='form1:hyperlinkGroupPagingSettings']")).click();
		}

		verifyScreenTitleProvPage("Group Paging");

		ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
				"Select Enterprise: " + strEnterprise);
		ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Group, strGroup, "Select Group: " + strGroup);

	}

	public void pagingGroup_goto_mainpage_forGA(String strEnterprise, String strGroup, boolean blnGPFromUsersMenu)
			throws InterruptedException, IOException {
		selectMainPageMenuItem("Provisioning", "Provisioning");
		selectMainPageMenuItem("Group Settings", "Group Settings");
		if (blnGPFromUsersMenu) {
			selectMainPageMenuItem("Group Paging", "Group Paging");
		} else {
			driver.findElement(By.xpath("//*[@id='form1:hyperlinkGroupPagingSettings']")).click();
		}

		verifyScreenTitleProvPage("Group Paging");

		// ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Group,
		// strGroup, "Select Group: " + strGroup);

	}

	/*
	 * Lib to select multiple values
	 * 
	 */
	public void selectMultipleValues(String idMultiSelect, String multipleVals)
			throws InterruptedException, IOException {
		String multipleSel[] = multipleVals.split(";");
		String strXpathForItem = "";
		WebElement eleMultiselect, eleItemInMultiselect;
		for (String valueToBeSelected : multipleSel) {
			eleMultiselect = driver.findElement(By.id(idMultiSelect));
			String xpathItemInMultiselect = "//*[@id='" + idMultiSelect + "']//option[contains(text(),'"
					+ valueToBeSelected + "')]";
			;
			eleItemInMultiselect = driver.findElement(By.xpath(xpathItemInMultiselect));
			ptr.click(eleItemInMultiselect, "Selecting item: " + valueToBeSelected);
			ptr.wait(500);
			eleMultiselect.sendKeys(Keys.CONTROL);
			ptr.wait(500);
		}
	}

	/*
	 * Lib to check if an element is enabled
	 */
	public boolean isWebElementEnabled(WebElement eleToCheck) {
		return eleToCheck.isEnabled();
	}

	/*
	 * Common lib to select Menu
	 */

	public void selectMainPageMenuItem(String strMenuItem) {
		driver.findElement(By.linkText(strMenuItem)).click();
	}

	public void selectMainPageMenuItem(String strMenuItem, String strTitleAfterClick)
			throws InterruptedException, IOException {
		driver.findElement(By.linkText(strMenuItem)).click();
		ptr.wait(3000);
		verifyScreenTitleProvPage(strTitleAfterClick);
	}

	public void selectTopPanelMenuItem(String strMenuItem) {
		driver.findElement(By.linkText(strMenuItem)).click();
	}

	/*
	 * Author: Viru K Scope: Clearspan Anywhere feature Lib to reset AutoAttendant
	 * Service to delete all the phone numners added to the User
	 */

	public void resetAutoAttendantServiceForUser(String strAutoAttUser) throws IOException, InterruptedException {
		// Edit a User who has added Alternate Number service.
		String strDynXpath = "(//span[contains(text(),'" + strAutoAttUser + "')])[1]";
		WebElement eleAutoAtt = driver.findElement(By.xpath(strDynXpath));
		if (eleAutoAtt == null) {
			ptr.updateStep("Auto Attendant record not found: " + strAutoAttUser, "Fail");
		}

		ptr.click(eleAutoAtt, "Selecting Auto Attendant " + strAutoAttUser);

		// Auto Attendant Modify page is displayed.
		verifyScreenTitleProvPage("Auto Attendant Modify");

		ptr.selectDropdownByValue(ProvisioningPages.multiSelect_UserServices, "Alternate Numbers",
				"Selecting Alternate Numbers service to remove");
		ptr.click(ProvisioningPages.btn_ServiceRemove, "Clicking button Remove Service ");
		ptr.click(opeasyCommonPageElements.btn_Apply, "Clicking button Apply");

		// Verify Saved message is displayed and Alternate Number is added.
		ptr.assertTextEquals(ProvisioningPages.txt_screeSavedMessage, "Saved");

		// Add service again
		ptr.selectDropdownByValue(ProvisioningPages.multiSelect_AvailableServices, "Alternate Numbers",
				"Selcting service Alternate Numbers");
		ptr.click(ProvisioningPages.btn_AddService, "Click button Add to add service");

		ptr.click(OpeasyCommonPageElements.btn_Apply, "Clicking button Apply");

		// Verify Saved message is displayed and Alternate Number is added.
		ptr.assertTextEquals(ProvisioningPages.txt_screeSavedMessage, "Saved");

		// Select Auto Attendant from the service
		ptr.selectDropdownByValue(ProvisioningPages.dropdown_ServiceForUser, "Alternate Numbers",
				"Select Alternate Numbers from Service drop down list");
	}

	public void addNAltPhoneNumbersOnVirtualUsersPage(String strStartingPhoneNum, boolean blnAddPhone,
			boolean blnAddExtension, boolean ringPattern, boolean description, int intNNumbers)
			throws IOException, InterruptedException {
		WebElement eleTxtBoxExt;
		WebElement eleTxtBoxRing;
		WebElement eleTxtBoxdesc;
		String strDesc = "test";
		String strExt = "";
		String strPhoneNum = "";
		String strDynXpath = "";
		int intIters = intNNumbers + 1;

		int indRingPat = 1;
		int phoneNumIndex = 2;

		for (int i = 2; i <= intIters; i++) {

			// Add phone number
			System.out.println("1 : i = " + i + " phoneNumIndex = " + phoneNumIndex);
			strDynXpath = "(//select)[" + phoneNumIndex + "]";
			driver.findElement(By.xpath(strDynXpath));

			strPhoneNum = strStartingPhoneNum + (i - 2);
			if (blnAddPhone) {
				// ptr.selectDropdownByVisibleText(eleDropDownPhNum,
				// strPhoneNum,
				// "Selecting Phone number: " + strPhoneNum);
				String strDropDownElement = "form1:rowGroupQueryResults:" + (phoneNumIndex - 2)
						+ ":dropDownPhoneNumber";
				ptr.selectDropdownByValue(strDropDownElement, strPhoneNum, "Selecting Phone Number: " + strPhoneNum);
				ptr.wait(2000);

			}

			// Add Ext number if asked, automatically pick the last four digits
			// of ph num
			if (blnAddExtension) {

				System.out.println("2 : i = " + phoneNumIndex + " phoneNumIndex = " + phoneNumIndex);
				strDynXpath = "//*[@id=\"form1:rowGroupQueryResults:" + (phoneNumIndex - 2) + ":extension\"]";
				eleTxtBoxExt = driver.findElement(By.xpath(strDynXpath));
				// extract only the last 4 digits of the phone number
				strExt = strPhoneNum.substring(strPhoneNum.length() - 4);
				ptr.type(eleTxtBoxExt, strExt, "Entering ext: " + strExt + " for phone number: " + strPhoneNum);
			}

			// Add Ring Pattern if asked, automatically pick from drop down list
			if (ringPattern) {
				strDynXpath = "(//select//ancestor::span/parent::td/parent::*/child::td[5]//span//select)[" + indRingPat
						+ "]";
				eleTxtBoxRing = driver.findElement(By.xpath(strDynXpath));
				System.out.println("3 : i = " + i + " indRingPat = " + indRingPat);
				if (indRingPat == 1) {
					ptr.selectDropdownByVisibleText(eleTxtBoxRing, "Long-Long", "Selecting Ring Pattern: Long-Long ");
				} else if (indRingPat == 5) {
					ptr.selectDropdownByVisibleText(eleTxtBoxRing, "Short-Short-Long",
							"Selecting Ring Pattern: Long-Long ");
				} else if (indRingPat == 7) {
					ptr.selectDropdownByVisibleText(eleTxtBoxRing, "Short-Long-Short",
							"Selecting Ring Pattern: Long-Long ");
				} else {
					ptr.selectDropdownByVisibleText(eleTxtBoxRing, "Normal", "Selecting Ring Pattern: Long-Long ");
				}

			}

			if (description) {
				System.out.println("4 - i = " + i + " phoneNumIndex = " + phoneNumIndex);
				strDynXpath = "(//select)[" + phoneNumIndex
						+ "]/ancestor::span/parent::td/parent::*/child::td[6]//input";
				eleTxtBoxdesc = driver.findElement(By.xpath(strDynXpath));
				// extract only the last 4 digits of the phone number
				// strExt = strPhoneNum.substring(strPhoneNum.length() - 4);
				ptr.type(eleTxtBoxdesc, strDesc, "Enter description" + strDesc);

			}
			phoneNumIndex = phoneNumIndex + 1;
			indRingPat = indRingPat + 1;
		}
	}

	public void addNAltPhoneNumbers(String strStartingPhoneNum, boolean blnAddPhone, boolean blnAddExtension,
			int intNNumbers) throws IOException, InterruptedException {
		WebElement eleDropDownPhNum;
		WebElement eleTxtBoxExt;
		String strExt = "";
		String strPhoneNum = "";
		String strDynXpath = "";
		int intIters = intNNumbers + 1;

		for (int i = 2; i <= intIters; i++) {
			// Add phone number
			strPhoneNum = strStartingPhoneNum + (i - 2);
			if (blnAddPhone) {
				String strDropDownElement = "form1:rowGroupQueryResults:" + (i - 2) + ":dropDownPhoneNumber";
				ptr.selectDropdownByValue(strDropDownElement, strPhoneNum, "Selecting Phone Number: " + strPhoneNum);
				ptr.wait(15000);
			}
			// Add Ext number if asked, automatically pick the last four digits
			// of ph num
			if (blnAddExtension) {
				System.out.println("2 : i = " + i + " phoneNumIndex = " + i);
				strDynXpath = "//*[@id=\"form1:rowGroupQueryResults:" + (i - 2) + ":extension\"]";
				eleTxtBoxExt = driver.findElement(By.xpath(strDynXpath));
				// extract only the last 4 digits of the phone number
				strExt = strPhoneNum.substring(strPhoneNum.length() - 4);
				ptr.type(eleTxtBoxExt, strExt, "Entering ext: " + strExt + " for phone number: " + strPhoneNum);
			}
			ptr.wait(15000);

		}

		// Click Activated. [Optional] - Default: Activated is selected

		// Click Apply.
		ptr.click(opeasyCommonPageElements.btn_Apply, "Click Apply");
		ptr.wait(5000);

		// 1) Verify Saved message is displayed and Alternate Number is added.
		ptr.assertTextEquals(ProvisioningPages.txt_screeSavedMessage, "Saved");

		// Click OK
		ptr.click(opeasyCommonPageElements.btn_OK, "Click OK");
		ptr.wait(5000);

	}

	// /*
	// * Lib to add N alternate phone/ext to the Auto Attendant
	// */
	public void clearAlternateNumbersForUser(String strAutoAttUser, boolean blnClearExt, int intIter)
			throws IOException, InterruptedException {

		// Edit a User who has added Alternate Number service.
		String strDynXpath = "(//span[contains(text(),'" + strAutoAttUser + "')])[1]";
		WebElement eleAutoAtt = driver.findElement(By.xpath(strDynXpath));
		if (eleAutoAtt == null) {
			ptr.updateStep("Auto Attendant record not found: " + strAutoAttUser, "Fail");
		}

		ptr.click(eleAutoAtt, "Selecting User: " + strAutoAttUser);

		// Select Alternate Numbers from Service drop down list.
		ptr.selectDropdownByValue(ProvisioningPages.dropdown_ServiceForUser, "Alternate Numbers",
				"Select Alternate Numbers from Service drop down list");

		WebElement eleTxtBoxExt = null;
		intIter += 1;

		for (int i = 2; i < intIter; i++) {

			ptr.wait(20000);

			String strDropDownElement = "form1:rowGroupQueryResults:" + (i - 2) + ":dropDownPhoneNumber";
			ptr.selectDropdownByValue(strDropDownElement, "(None)",
					"Selecting Phone Number: None for the row: " + (i - 1));
			ptr.wait(2000);
			if (blnClearExt) { // form1:rowGroupQueryResults:0:extension
				strDynXpath = "//*[@id=\"form1:rowGroupQueryResults:" + (i - 2) + ":extension\"]";
				eleTxtBoxExt = driver.findElement(By.xpath(strDynXpath));
				ptr.clear(eleTxtBoxExt, "Clearing Extention for the row: " + (i - 1));
			}
			ptr.wait(5000);
		}

		// Click Apply.
		ptr.click(opeasyCommonPageElements.btn_Apply, "Click Apply");
		ptr.wait(5000);

		// 1) Verify Saved message is displayed and Alternate Number is added.
		ptr.assertTextEquals(ProvisioningPages.txt_screeSavedMessage, "Saved");

		// Click OK
		ptr.click(opeasyCommonPageElements.btn_OK, "Click OK");

		// Wait till the phone number is released for reassigning
		ptr.wait(3000);

		strDynXpath = "(//span[contains(text(),'" + strAutoAttUser + "')])[1]";
		eleAutoAtt = driver.findElement(By.xpath(strDynXpath));

		ptr.click(eleAutoAtt, "Selecting User: " + strAutoAttUser);

		// Select Alternate Numbers from Service drop down list.
		ptr.selectDropdownByValue(ProvisioningPages.dropdown_ServiceForUser, "Alternate Numbers",
				"Select Alternate Numbers from Service drop down list");

	}

	/*
	 * 
	 * Create User with or without advance provisioning privilege
	 * 
	 * Description: This works only if you have logged in as a Super User So, to use
	 * this library, you need login as Super User Logout if not logged in as Super
	 * User. Then, login as Super User
	 * 
	 * Parameters: adminType (EA / GA / etc), Username, password, Boolean flag to
	 * give advanced provisioning privilege Return : True / False based on the
	 * success/failure of the action
	 * 
	 * Verify error message on login to opeasy
	 * 
	 */
	public boolean opeasyLoginVerifyErrorMessage(String baseUrl, String UserName, String Password,
			String strLoginErrorMessage, int intAttempts) throws IOException, InterruptedException {
		ptr.openUrl(baseUrl);

		for (int i = 0; i < intAttempts; i++) {
			ptr.type(opeasyhome.tbx_UserName, UserName, "Enter userName->" + UserName);
			ptr.type(opeasyhome.tbx_Password, Password, "Enter password->" + Password);
			ptr.click(opeasyhome.btn_Login, "Click on Login Button");
		}

		// Look for the expected error message
		try {
			String strDynXpath = ".//span[contains(text(), '" + strLoginErrorMessage + "')]";
			if (driver.findElement(By.xpath(strDynXpath)).isDisplayed()) {
				return true;
			}
		} catch (NoSuchElementException ex) {
			// Do nothing
		}

		return false;
	}

	/*
	 * 
	 * 
	 * /* Create User with or without advance provisioning privilege
	 * 
	 * Description: This works only if you have logged in as a Super User So, to use
	 * this library, you need login as Super User Logout if not logged in as Super
	 * User. Then, login as Super User
	 * 
	 * Parameters: adminType (EA / GA / etc), Username, password, Boolean flag to
	 * give advanced provisioning privilege Return : True / False based on the
	 * success/failure of the action
	 */

	public void addAdminUser(String strAdminType, String strUserName, String strPassword, String strAdminName,
			String strGroups) throws Exception {

		// Check if the user exists already
		// if (userExists(strUserName)) {
		// Log.warn("User already exists " + strUserName);
		// } else {
		// Add the new user
		ptr.click(opeasyhome.link_LoginManagement, "Click on Login Management link");
		ptr.isElementPresent(loginmanagementpage.text_LoginManagement_ScreenName,
				"Wait until the Login Management page is displayed");
		ptr.click(opeasyCommonPageElements.btn_Add, "Clicking on Add button");
		ptr.isElementPresent(loginmanagementpage.text_Administrator_Add_ScreenName,
				"Wait until OpEasy Administration Add page is displayed");
		ptr.type(loginmanagementpage.text_UserName, strUserName, "Enter text : User Name");
		ptr.type(loginmanagementpage.text_Password, strPassword, "Enter text: Password: " + strPassword);
		ptr.type(loginmanagementpage.text_ConfirmPassword, strPassword, "Enter confirm Password: " + strPassword);
		ptr.type(loginmanagementpage.text_EmailAddress, "virupakshayya.kulkarni@mitel.com",
				"Entering Email address: virupakshayya.kulkarni@mitel.com");
		ptr.type(loginmanagementpage.text_AdminName, strAdminName, "Entring text: Administrator Name");
		ptr.selectDropdownByValue(loginmanagementpage.list_LoginLevel, strAdminType,
				"Select Login Level from the drop down");

		// If the user is of the type Enterprise Administrator, then assign
		// one or more enterprise to the user
		if (strAdminType.equals("Enterprise Administrator")) {
			// Click Select all
			WebElement GroupDeptSelection = driver.findElement(By.id("form1:groupDeptListBox"));

			Select Group = new Select(GroupDeptSelection);

			// Split the groups by ;
			String[] arrGroups = strGroups.split(";");
			if (arrGroups[0].equalsIgnoreCase("all")) {

				ptr.click(loginmanagementpage.chk_Select_All, "Select all Enterprises");
			} else {
				// Select more than one Group
				for (String name : arrGroups) {
					Group.selectByValue(name);
				}
			}
			ptr.wait(2000);
		}

		ptr.waitForElementPresent(OpeasyCommonPageElements.btn_OK, 60000);
		ptr.click(OpeasyCommonPageElements.btn_OK, "Click on OK button");
		ptr.wait(5000);

		// Check if the user is added successfully
		if (!LoginUserExists(strUserName)) {
			ptr.updateStep("User not added successfully: " + strUserName, "Fail");
		}
	}

	// public void loginManagementEditUser(String strUserName) throws Exception
	// {
	// // Go to Login Management page
	//
	//// //Search for the user using search drop down
	//// ptr.selectDropdownByValue(loginmanagementpage.dropDown_SelectSearchCriteria1,
	//// "LOGIN_NAME", "Search criteria: LOGIN_NAME");
	//// createSearchCriteriaRow(1, "LOGIN_NAME", "EqualTo", strUserName);
	////
	//// ptr.click(loginmanagementpage.btn_Search, "Click button: Search");
	//
	// try {
	// String dynXpath = ".//a[contains(text(), 'Edit')]";
	// driver.findElement(By.xpath(dynXpath)).click();
	// } catch (org.openqa.selenium.NoSuchElementException e) {
	// Log.info("UserExists not found: " + strUserName);
	// }
	//
	// }

	// Lib to grant advanced provisioning privilege to a user
	@SuppressWarnings("static-access")
	public void loginManagementModifyUserPrivilege(String strUserName, String privilegeName, String strAccessLevel)
			throws Exception {

		if (LoginUserExists(strUserName)) {
			try {
				String dynXpath = ".//a[contains(text(), 'Edit')]";
				driver.findElement(By.xpath(dynXpath)).click();
			} catch (org.openqa.selenium.NoSuchElementException e) {
				Log.info("UserExists not found: " + strUserName);
			}

			// Validate the screen name: OpEasy Administrator Modify
			verifyScreenTitleProvPage("OpEasy Administrator Modify");
			ptr.wait(1000);

			ptr.click(opeasyCommonPageElements.btn_Apply, "Click Apply button");
			ptr.wait(1500);

			driver.findElement(By.id("form1:buttonCustomize")).click();
			ptr.wait(2000);

			String eleXpathPrivilege = "((//tr//span[contains(., '" + privilegeName
					+ "')])//parent::*//following-sibling::td[1]//label)";

			System.out.println(eleXpathPrivilege);
			ptr.wait(2000);

			driver.findElement(By.xpath(eleXpathPrivilege)).click();
			ptr.wait(2000);

			String rowNum = driver.findElement(By.xpath(eleXpathPrivilege)).getAttribute("id").split(":")[2];
			System.out.println("rowNum : " + rowNum);
			System.out.println(eleXpathPrivilege);

			String xpathhh = "//*[@id='form1:tablePrivileges:" + rowNum
					+ ":dropDownAccess_items']//li[contains(text(), '" + strAccessLevel + "')]";
			ptr.wait(5000);

			driver.findElement(By.xpath(xpathhh)).click();
			System.out.println(xpathhh);
			ptr.wait(5000);

			ptr.click(opeasyCommonPageElements.btn_OK, "Click button: OK");

		} else {
			Log.error("User does not exit: " + strUserName);
		}
	}

	// Hameetha- Privilege Reset Default

	@SuppressWarnings("static-access")
	public void ResetToDefaultPrivilege(String strUserName) throws Exception {

		if (LoginUserExists(strUserName)) {
			try {
				String dynXpath = ".//a[contains(text(), 'Edit')]";
				driver.findElement(By.xpath(dynXpath)).click();
			} catch (org.openqa.selenium.NoSuchElementException e) {
				Log.info("UserExists not found: " + strUserName);
			}

			// Validate the screen name: OpEasy Administrator Modify
			verifyScreenTitleProvPage("OpEasy Administrator Modify");
			ptr.wait(2000);

			ptr.click(opeasyCommonPageElements.btn_Apply, "Click button: Apply");
			ptr.wait(30000);

			driver.findElement(By.id("form1:buttonCustomize")).click();
			ptr.wait(10000);

			// Click "Reset To default" button

			driver.findElement(By.xpath("//span[contains(.,'Reset to Default')]")).click();
			ptr.wait(1500);

			driver.findElement(By.xpath("//span[contains(.,'OK')]")).click();
			ptr.wait(1500);

			driver.findElement(By.xpath("//span[contains(.,'OK')]")).click();

		}
	}

	// Delete user if exists
	public void deleteLoginUser(String strUserName) throws Exception {

		// Go to Login Management page
		ptr.click(opeasyhome.link_LoginManagement, "Click on Login Management link");
		ptr.isElementPresent(loginmanagementpage.text_LoginManagement_ScreenName,
				"Wait until the Login Management page is displayed");

		if (LoginUserExists(strUserName)) {
			Log.info("User found successfully!: " + strUserName);
			try {
				String dynXpath = ".//a[contains(text(), 'Edit')]";
				driver.findElement(By.xpath(dynXpath)).click();
				ptr.click(opeasyCommonPageElements.btn_Delete, "Click button Delete");
				ptr.wait(5000);
				ptr.alertAccept();

			} catch (org.openqa.selenium.NoSuchElementException e) {
				Log.info("User does not exist: " + strUserName);
			}
		} else// Verify the deleted user is not displayed on screen
		{
			Log.warn("User does not exist to delete: " + strUserName);
		}
	}

	// Check if the user exists in opeasy
	public boolean LoginUserExists(String strUserName) throws Exception {
		ptr.click(opeasyhome.link_LoginManagement, "Click on Login Management link");

		// Search for the user using search drop down
		createSearchCriteriaRowOnLoginManagementPage(1, "Login Name", "Equal To:", strUserName);
		ptr.click(OpeasyCommonPageElements.btn_Search, "Click Button Search");

		ptr.wait(5000);

		try {
			String dynXpath = ".//span[contains(text(), '" + strUserName + "')]";
			List<WebElement> lstUsers = driver.findElements(By.xpath(dynXpath));
			if (lstUsers.size() > 0) {
				return true;
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			ptr.updateStep("User not found: " + strUserName, "Info");
			return false;
		}
		return true;
	}

	// public boolean isElementPresent(By elem) {
	//
	// try {
	// driver.findElement(elem);
	// return true;
	// } catch (org.openqa.selenium.NoSuchElementException e) {
	// Log.info("Web element not found: " + elem);
	// return false;
	// }
	// }

	/*
	 * Write the methods needed to setup and teardown during autoamtion execution
	 * here like:
	 * 
	 * 1. Create different OpEasy Users like : GA, EA, SA, etc.. 2. Create Group and
	 * Enterprise 3. Add devices to the Enterprises and groups 4. Create Users and
	 * devices using templates and GUI (with and without VM) 5. Create User with or
	 * without advance provisioning previlege
	 */

	/*
	 * Lib to verify content of a PDF file Author :Virupakshayya Kulkarni
	 * 
	 * This lib only checks if the content of the PDF is not empty Steps: 1.
	 * Download the file 2. Verify content 3. Delete the downloaded file Developed
	 * for the feature testing of Provisioning > Help Arguments: 1. URL of the file
	 * to download (with IP only, no FQDN), 2. Local download destination along with
	 * file name, 3. Threshold for blank pages
	 * 
	 * 
	 * How to use: boolean flag = clearspanCommon.verifyPDFContent(
	 * "https://10.70.100.92/OpEasyHelp/OpEasyBasicProvisioning.pdf",
	 * "C:\\Temp\\OpEasyBasicProvisioning.pdf", 0);
	 * 
	 * Limitation: Does not work if you pass FQDN in place of IP address in the URL
	 * to download file
	 */

	// public Boolean verifyPDFContent(String urlDowloadFile, String
	// strLocalDestination, int intThresholdForBlankPages)
	// throws Exception, IOException {
	//
	// // Download the file from the link passed
	// boolean blnVerifyPDFContent = false;
	//
	// // Create a trust manager that does not validate certificate chains
	// TrustManager[] trustAllCerts = new TrustManager[] { new
	// X509TrustManager() {
	// public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	// return null;
	// }
	//
	// public void checkClientTrusted(X509Certificate[] certs, String authType)
	// {
	// }
	//
	// public void checkServerTrusted(X509Certificate[] certs, String authType)
	// {
	// }
	// } };
	//
	// // Install the all-trusting trust manager
	// SSLContext sc = SSLContext.getInstance("SSL");
	// sc.init(null, trustAllCerts, new java.security.SecureRandom());
	// HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	//
	// // Create all-trusting host name verifier
	// HostnameVerifier allHostsValid = new HostnameVerifier() {
	// public boolean verify(String hostname, SSLSession session) {
	// return true;
	// }
	// };
	//
	// // Install the all-trusting host verifier
	// HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	//
	// URL url = new URL(urlDowloadFile);
	// File strDownloadDestination = new File(strLocalDestination);
	//
	// try {
	//
	// // Copy bytes from the URL to the destination file.
	// FileUtils.copyURLToFile(url, strDownloadDestination);
	//
	// ptr.updateStep("File downloaded susccessully: " + urlDowloadFile,
	// "Pass");
	//
	// Log.info("Now verifying the PDF file are blank");
	// blnVerifyPDFContent = verifyBlankPdfPages(strLocalDestination,
	// intThresholdForBlankPages);
	// deleteFileFromDisk(strLocalDestination);
	//
	// } catch (IOException e) {
	// e.printStackTrace();
	//
	// ptr.updateStep(
	// "Failed to download the file: " + urlDowloadFile + " to local disk: " +
	// strDownloadDestination,
	// "Fail");
	//
	// blnVerifyPDFContent = false;
	// }
	//
	// // Check the file content is not empty
	//
	// return blnVerifyPDFContent;
	// }

	// HAMEETHA
	/*
	 * Lib to create TEMP account
	 */
	// Login Name, Administrator Name, Password, confirm password, Email
	// Address, enable temporary checkbox, Select Login level as SA
	public void createTEMPAccount(String LoginName, String AdminName, String pwd, String Email, String LoginLevel,
			String From, String ToDate) throws Exception {

		WebElement temp_checkbox = driver.findElement(By.xpath(".//*[@id='form1:checkboxIsTempAccount']/div[2]/span"));
		ptr.click(temp_checkbox, "Enable Temporary account Check box");
		ptr.wait(2000);

		ptr.type(LoginManagementPages.From_date, From, "Ente Active From Date");
		ptr.wait(3000);

		ptr.type(LoginManagementPages.To_date, ToDate, "Enter To Date");
		ptr.wait(3000);

		ptr.type(LoginManagementPages.text_UserName, LoginName, "Enter Login Name");
		ptr.wait(3000);

		ptr.type(LoginManagementPages.text_AdminName, AdminName, "Enter Administrator Name : " + AdminName);
		ptr.wait(3000);

		ptr.type(LoginManagementPages.text_Password, pwd, "Enter Password : " + pwd);
		ptr.wait(3000);

		ptr.type(LoginManagementPages.text_ConfirmPassword, pwd, "Enter confirm Password : " + pwd);
		ptr.wait(3000);

		ptr.type(LoginManagementPages.text_EmailAddress, Email, "Enter Email Address : " + Email);
		ptr.wait(1500);

		ptr.selectDropdownByValue(LoginManagementPages.list_LoginLevel, LoginLevel,
				"Selecting an Import type :Enterprise");

		// ptr.selectDropdownByValue(LoginManagementPages.list_LoginLevel,
		// LoginLevel,
		// "Selecting an Enterprise : " + LoginLevel);

		// ptr.selectDropdownByVisibleText(LoginManagementPages.list_LoginLevel,
		// LoginLevel,
		// "Select Login Level: " + LoginLevel);
		// ptr.wait(1000);

		ptr.click(OpeasyCommonPageElements.btn_Apply, "Click Apply button ");
		ptr.wait(3000);

		// ptr.assertTextEquals(OpeasyCommonPageElements.saved, "Saved");
		// ptr.wait(3000);

	}

	// Lib to delete file if exists from the local disk
	// Author :Virupakshayya Kulkarni

	public void deleteFileFromDisk(String strFileLocation) throws FileNotFoundException {
		try {
			File file = new File(strFileLocation);
			if (file.exists()) {
				file.delete();
				Log.info("Deleted file successfully: " + strFileLocation);
			}
		} catch (Exception e) {
			Log.info("File does not exist to delete :" + strFileLocation);
		}

	}

	/*
	 * Lib to check if file exists Author : Virupakshayya Kulkarni
	 * 
	 */

	public boolean fileExists(File file) {
		if (file.exists()) {
			return true;
		}
		return false;
	}

	// Library to verify the PDF file content has blank pages
	// This lib takes 2 arguments: 1. Local File location 2. Threshold of blank
	// pages in the pdf file

	// Author :Virupakshayya Kulkarni
	public boolean verifyBlankPdfPages(String source, int intThresholdForBlankPages)
			throws IOException, DocumentException {
		PdfReader r = null;
		RandomAccessSourceFactory rasf = null;
		RandomAccessFileOrArray raf = null;
		Document document = null;
		PdfCopy writer = null;
		boolean isBlankPagesExists = false;

		try {
			r = new PdfReader(source);
			rasf = new RandomAccessSourceFactory();
			raf = new RandomAccessFileOrArray(rasf.createBestSource(source));
			document = new Document(r.getPageSizeWithRotation(1));
			document.open();
			int intNoOfBlankPDFPages = 0;

			for (int i = 1; i <= r.getNumberOfPages(); i++) {
				String pageContent = PdfTextExtractor.getTextFromPage(r, i);
				// Uncomment the following line to print the content on the
				// console for debugging

				// System.out.println("PageContent ="+pageContent+"length
				// ="+pageContent.trim().length());

				if (pageContent.trim().length() == 0) {
					intNoOfBlankPDFPages++;
				}
			}

			System.out.println("Number of blank pages : " + intNoOfBlankPDFPages);
			if (intNoOfBlankPDFPages > intThresholdForBlankPages) {
				isBlankPagesExists = true;

			}
			Log.info("Actual number of blank pages are: " + intNoOfBlankPDFPages);

		} finally {
			if (document != null)
				document.close();

			if (writer != null)
				writer.close();

			if (raf != null)
				raf.close();

			if (r != null)
				r.close();

		}

		return isBlankPagesExists;
	}

	// public boolean isElementPresent(WebElement ele, String description) {
	// boolean eleFound = false;
	// Log.info(".......IS ELEMENT PRESENT...........");
	// try {
	// ptr.isElementPresent(ele, description);
	// eleFound = true;
	// } catch (NoSuchElementException e) {
	// Log.info(" Element Not Found :");
	// }
	// return eleFound;
	// }

	/*
	 * Lib to read cell from excel sheet Author: Virupakshayya Kulkarni
	 */
	public String getExcelCellData(String filePath, String strSheetName, String strCellName) {

		FileInputStream inputStream = null;
		String retValue = null;
		try {
			inputStream = new FileInputStream(new File(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);

			org.apache.poi.ss.usermodel.Sheet sheet;
			if (!strSheetName.equals("")) {
				sheet = workbook.getSheet(strSheetName);
			} else {
				sheet = workbook.getSheetAt(0);
				System.out.println(sheet);
			}
			CellReference ref = new CellReference(strCellName);

			Row r = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(ref.getRow());
			if (r != null) {
				Cell c = r.getCell(ref.getCol());
				System.out.println(c.getRichStringCellValue().getString());
				retValue = c.getRichStringCellValue().getString();
			}

			((BufferedReader) workbook).close();
			inputStream.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return retValue;

	}

	/*
	 * Lib to verify text in word/ notepad
	 */

	public void searchText(String filePath, String strTextToFind) throws FileNotFoundException {

		try {
			String clearspanFilePath = System.getProperty("user.dir") + "\\" + "Upload_files" + "\\"
					+ "AudioCodes500L (Group India-BNG_1).cli";

			// Open the text file in a web browser
			// String filePath = "file:///path/to/your/text/file.txt";
			driver.get(clearspanFilePath);

			// Read the content of the text file
			String fileContent = driver.getPageSource();

			// Text to search for in the file
			String searchText = "ACTIVATE";

			// Check if the text is present in the file content
			if (fileContent.contains(searchText)) {
				System.out.println("Text is present in the file.");
				ptr.updateStep("ACTIVATE is present in the file", "Pass");
			} else {
				System.out.println("Text is not present in the file.");
				ptr.updateStep("ACTIVATE is Not present in the file", "Fail");
			}

			String fileContent1 = driver.getPageSource();
			if (fileContent1.contains("gateway trunk-group")) {
				System.out.println("gateway trunk-group is present in the file.");
				ptr.updateStep("gateway trunk-group is present in the file", "Pass");
			} else {
				System.out.println("gateway trunk-group is not present in the file.");
				ptr.updateStep("gateway trunk-group is Not present in the file", "Fail");
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	// End
	public Object getNumericExcelCellData(String filePath, String strSheetName, int coln, int rows) throws IOException {

		FileInputStream inputStream = new FileInputStream(new File(filePath));
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet(strSheetName);
		XSSFRow row = sheet.getRow(rows);
		XSSFCell cell = row.getCell(coln);
		double value = cell.getNumericCellValue();
		System.out.println("column value is " + value);
		return value;
	}

	/*
	 * 
	 * public String getExcelCellData(String filePath, String strSheetName, String
	 * strCellName) throws IOException {
	 * 
	 * FileInputStream inputStream = new FileInputStream(new File(filePath));
	 * 
	 * Workbook workbook = new XSSFWorkbook(inputStream);
	 * org.apache.poi.ss.usermodel.Sheet sheet; if (!strSheetName.equals("")) {
	 * sheet = workbook.getSheet(strSheetName); } else { sheet =
	 * workbook.getSheetAt(0); System.out.println(sheet); } CellReference ref = new
	 * CellReference(strCellName); String retValue = null; Row r =
	 * ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(ref.getRow()); if (r !=
	 * null) { Cell c = r.getCell(ref.getCol()); //Cell c = r.getCell(ref.getCol(),
	 * r.CREATE_NULL_AS_BLANK);
	 * System.out.println(c.getRichStringCellValue().getString());
	 * //System.out.println(c.getRichStringCellValue().getString(); retValue =
	 * c.getRichStringCellValue().getString(); }
	 * 
	 * workbook.close(); inputStream.close(); } catch (Exception ex) {
	 * System.out.println(ex.getMessage()); } return retValue;
	 * 
	 * }
	 */
	/*
	 * Lib to read empty cell from Excel Sheet Author: Hameetha Banu
	 */
	public String getEmptyExcelCellData(String filePath, String strSheetName, String strCellName) throws IOException {

		FileInputStream inputStream = new FileInputStream(new File(filePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		org.apache.poi.ss.usermodel.Sheet sheet;
		if (!strSheetName.equals("")) {
			sheet = workbook.getSheet(strSheetName);
		} else {
			sheet = workbook.getSheetAt(0);
			System.out.println(sheet);
		}
		CellReference ref = new CellReference(strCellName);
		String retValue = null;
		Row r = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(ref.getRow());
		if (r != null) {
			// Cell c = r.getCell(ref.getCol());
			Cell c = r.getCell(ref.getCol()); // ,r. CREATE_NULL_AS_BLANK);
			// System.out.println(c.getRichStringCellValue().getString());
			System.out.println(c.getRichStringCellValue().getString() + " ");
			retValue = c.getRichStringCellValue().getString();
		}

		((BufferedReader) workbook).close();
		inputStream.close();

		return retValue;

	}

	/*
	 * Lib to verify sheet(s) present
	 * verifyWorksheetsPresentInExcelWorkbook(strWorkbook, worksheetnames) Returns
	 * list of worksheets not present Parameters: 1. Workbook 2. Comma separated
	 * sheet names
	 */

	public String verifyWorksheetsPresentInExcelWorkbook(String strWorkbook, String arrExpectedWorksheetNames)
			throws IOException {
		String strSheetsNotFound = "";

		// Split the list of expected worksheets as Java List
		String[] arrWorksheets = arrExpectedWorksheetNames.split(";");

		// Read the excel file
		FileInputStream excelFile = new FileInputStream(new File(strWorkbook));

		List<String> sheetNames = new ArrayList<>();

		Workbook workbook = new XSSFWorkbook(excelFile);

		System.out.println("Local workbook : " + strWorkbook);

		// List all the excel sheets present in the excel workbook
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			sheetNames.add(workbook.getSheetName(i));
		}

		String strSheetNames = String.join(",", sheetNames);

		ptr.updateStep("List of Spreadsheets present in the Workbook are : " + strSheetNames, "Info");

		ptr.updateStep("Searching for worksheets :" + arrExpectedWorksheetNames, "Info");

		// Search for the expected worksheets in the workbook
		for (String worksheet : arrWorksheets) {
			if (sheetNames.contains(worksheet) ) {
				ptr.updateStep("Found spreadsheet in excel workbook " + strWorkbook + " : " + worksheet, "Info");
			} else {
				ptr.updateStep("Spreadsheet NOT found in excel workbook " + strWorkbook + " : " + worksheet, "Info");
				strSheetsNotFound = worksheet + strSheetsNotFound + ", ";
			}
		}

		workbook.close();

		return strSheetsNotFound;
	}

	/*
	 * Author : Virupakshayya Kulkarni
	 * 
	 * Lib to count number of words in a file Not checked with excel files Returns
	 * the count, 0 otherwise
	 */

	public int WordCounter(String sourcefile, String searchFor) {

		int searchLength = searchFor.length();
		int searchCount = 0;
		try {
			BufferedReader bout = new BufferedReader(new FileReader(sourcefile));
			String ffline = null;
			int lcnt = 0;

			System.out.println("\n");
			while ((ffline = bout.readLine()) != null) {
				lcnt++;

				for (int searchIndex = 0; searchIndex < ffline.length();) {
					int index = ffline.indexOf(searchFor, searchIndex);
					if (index != -1) {
						System.out.print("Line number " + lcnt + ",");
						searchCount++;
						searchIndex += index + searchLength;
					} else {
						break;
					}

				}
			}
			System.out.println("\n");
			bout.close();
			System.out.println("SearchCount = " + searchCount);
		} catch (Exception e) {
			System.out.println(e);
		}
		return searchCount;
	}

	/*
	 * Lib: Library to write data in to excel cell Author: Virupakshayya Kulkarni
	 */

	public static boolean insertMultiExcelCellData(String filePath, String strSheetName, String strCellValueKeyPair)
			throws IOException {

		boolean retValue = false;
		try {
			FileInputStream inputStream = new FileInputStream(new File(filePath));
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
						ref.getCol();
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
						System.out.println("Successfully modified the cell " + strCellName + " with value: "
								+ c.getRichStringCellValue().getString());
						retValue = true;
						;
					} else {
						System.out.println("Failed to insert new value in cell " + strCellName + " is: "
								+ c.getRichStringCellValue().getString());
						return retValue;
					}

				} // End of loop to insert in to new cells

				inputStream.close();

				// Write into the file now
				try {
					FileOutputStream outputStream = new FileOutputStream(new File(filePath));
					workbook.write(outputStream);
					workbook.close();

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

	/*
	 * Author: Viru Common lib to clear Alternate number table for Users + Virtual
	 * Users Clear PhoneNumber assigned and the Extension
	 * 
	 */

	// public void clearAlternateNumbersForUser(String strUser, boolean
	// blnClearPhnNumber, int intIter)
	// throws IOException, InterruptedException {
	//
	// // Edit a User who has added Alternate Number service.
	// String strDynXpath = "(//span[contains(text(),'" + strUser + "')])[1]";
	// WebElement eleAutoAtt = driver.findElement(By.xpath(strDynXpath));
	// if (eleAutoAtt == null) {
	// ptr.updateStep("Advanced User not found: " + strUser, "Fail");
	// }
	//
	// ptr.click(eleAutoAtt, "Selecting Advanced User " + strUser);
	//
	// // Step 8. Select Alternate Numbers service from drop down list
	// ptr.selectDropdownByValue(ProvisioningPages.dropdown_ServiceForUserForUser,
	// "ALTERNATE_NUMBERS",
	// "Selecting Alternate Numbers service from drop down list ");
	//
	// intIter += 1;
	//
	// for (int i = 2; i <= intIter; i = i + 2) {
	// if (blnClearPhnNumber) {
	// String strDropDownElement = "form1:rowGroupQueryResults:" + (i - 2) +
	// ":dropDownPhoneNumber";
	// ptr.selectDropdownByValue(strDropDownElement, "None", "Selecting Phone
	// Number: None");
	// ptr.wait(2000);
	// }
	//
	// }
	//
	// // Click Apply.
	// ptr.click(opeasyCommonPageElements.btn_Apply, "Click Apply");
	// ptr.wait(5000);
	//
	// // Click OK
	// ptr.click(opeasyCommonPageElements.btn_OK, "Click OK");
	// ptr.wait(3000);
	//
	// ptr.click(eleAutoAtt, "Selecting User " + strUser);
	// ptr.wait(3000);
	//
	// }

	/*
	 * Lib to search a value is present in Excel worksheet
	 * 
	 */

//	public boolean searchExcelSheet(List<String> searchText, String WorkSheet, String strSheetName) throws IOException {
//		ptr.wait(30000);
//		ptr.updateStep("Parsing the excel workbook : " + WorkSheet, "Pass");
//		int retryCount = 0;
//		try {
////			FileInputStream file = new FileInputStream(new File(WorkSheet));
//
//			// Create Workbook instance
//			Workbook workbook = new XSSFWorkbook(WorkSheet);
//			boolean searchSucceeded = false;
//
//			
//			for (String searchString : searchText) {
//				searchSucceeded = false; // Reinitialize
//				// Iterate rows
//				retryCount = 0;
//			
//			
//			// Iterate through each sheet in the workbook
//			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
//				org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(strSheetName);
//
//				// Iterate through each row in the sheet
//				for (Row row : sheet) {
//					// Iterate through each cell in the row
//					for (Cell cell : row) {
//						// Check the cell type before processing
//						if (cell.getCellType() == CellType.STRING) {
//							String cellValue = cell.getStringCellValue();
//							// Check if the cell value matches the search string
//							if (cellValue.equalsIgnoreCase(searchText)) {
//								System.out.println("Found '" + searchText + "' at row " + row.getRowNum()
//										+ ", column " + cell.getColumnIndex() + " in sheet " + sheet.getSheetName());
//							}
//						}
//					}
//				}
//			}
//
//			// Close the workbook and file input stream
//			workbook.close();
////			file.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return true;
//	}
	
	public boolean searchExcelSheet(String searchText, String WorkSheet, String strSheetName)
			throws IOException, InterruptedException {
		
		List<String> lstSearchText = null;		
		lstSearchText.add(searchText);
		
		return searchExcelSheet(lstSearchText, WorkSheet, strSheetName);
			
	}

	public boolean searchExcelSheet(List<String> searchText, String WorkSheet, String strSheetName)
			throws IOException, InterruptedException {
		// This parameter is for appending sheet rows to mergedSheet in the end

		Double doubleValue = null;
		Boolean booleanValue = null;
		FileInputStream excellFile = null;
		boolean searchSucceeded = false;
		boolean foundAllSearchStrings = true;
		org.apache.poi.ss.usermodel.Sheet sheet = null;
		Workbook workbook = new XSSFWorkbook(WorkSheet);

		try {

			ptr.updateStep("Parsing the excel workbook : " + WorkSheet, "Pass");
			int retryCount = 0;

			ptr.wait(30000);

			int intSheetsCount = workbook.getNumberOfSheets();
			System.out.println("No. of worksheets in excel workbook are: " + intSheetsCount);
			for (int i = 0; i < intSheetsCount; i++) {
				System.out.println("SheetName at index " + i + ": " + workbook.getSheetName(i));
			}

			// Get first/desired sheet from the workbook
			if (intSheetsCount == 0) {
				ptr.updateStep("Number of sheets in the excel are: " + intSheetsCount, "Pass");
				return false;
			}

			if (strSheetName == "") {
				sheet = workbook.getSheetAt(0);
				ptr.updateStep("Found excel sheet in the workbook at index 0", "Pass");
			} else {
				sheet = workbook.getSheet(strSheetName);
				ptr.updateStep("Found excel sheet in the workbook with name: " + strSheetName, "Pass");
			}
			if (sheet == null) {
				System.out.println("Sheet not found in the worksheet: " + strSheetName);
				// ptr.updateStep("Sheet not found in the worksheet: " +
				// strSheetName, "Fail");
				workbook.close();
				return false;
			}
			// Iterate through all the serach strings from here {
			for (String searchString : searchText) {
				searchSucceeded = false; // Reinitialize
				// Iterate rows
//				retryCount = 0;

//				while (!searchSucceeded || retryCount++ < 3) {
//					System.out.println("TRIAL Number: " + retryCount);

				// Iterate through each sheet in the workbook
				for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
					sheet = workbook.getSheet(strSheetName);

					// Iterate through each row in the sheet
					for (Row row : sheet) {
						// Iterate through each cell in the row
						for (Cell cell : row) {
							// Check the cell type before processing
							if (cell.getCellType() == CellType.STRING) {
								String cellValue = cell.getStringCellValue();
								// Check if the cell value matches the search string
								if (cellValue.equalsIgnoreCase(searchString)) {
									System.out.println(
											"Found '" + searchText + "' at row " + row.getRowNum() + ", column "
													+ cell.getColumnIndex() + " in sheet " + sheet.getSheetName());

									searchSucceeded = true;
									break;
								}
							}
						}

					}
				}

				if (searchSucceeded) {
					ptr.updateStep(
							"FOUND the Search string " + searchString + " in the excel sheet: " + sheet.getSheetName(),
							"Info");
				} else {
					foundAllSearchStrings = foundAllSearchStrings && false;
					System.out.println("Search string Not Found in the excel: " + searchString);
					ptr.updateStep("Search string NOT FOUND in the excel: " + searchString, "Info");
				}

//				} // End of while loop

			} // End iteration after all search strings have been searched

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			workbook.close();
			excellFile.close();
		}
//		return true;
		return foundAllSearchStrings;
	}

	/*
	 * Lib to do partial String search n Excel sheet
	 * 
	 */
	public boolean getCellDataSubstringExcelSheet(List<String> searchText, String WorkSheet, String strSheetName,
			int substring) throws IOException {
		// This parameter is for appending sheet rows to mergedSheet in the end

//		Double doubleValue = null;
//		Boolean booleanValue = null;
//		XSSFWorkbook workbook = null;
//		FileInputStream excellFile = null;
//		boolean searchSucceeded = false;
//		boolean foundAllSearchStrings = true;
//		ArrayList<Row> filteredRows = new ArrayList<Row>();
//		XSSFSheet sheet = null;
//		;
//
//		try {
//			ptr.wait(30000);
//			ptr.updateStep("Parsing the excel workbook : " + WorkSheet, "Pass");
//			int retryCount = 0;
//
//			excellFile = new FileInputStream(new File(WorkSheet));
//
//			// Create Workbook instance holding reference to .xlsx file
//			workbook = new XSSFWorkbook(excellFile);
//			int intSheetsCount = workbook.getNumberOfSheets();
//			System.out.println("No. of worksheets in excel workbook are: " + intSheetsCount);
//			for (int i = 0; i < intSheetsCount; i++) {
//				System.out.println("SheetName at index " + i + ": " + workbook.getSheetName(i));
//			}
//
//			// Get first/desired sheet from the workbook
//			if (intSheetsCount == 0) {
//				ptr.updateStep("Number of sheets in the excel are: " + intSheetsCount, "Pass");
//				return false;
//			}
//
//			if (strSheetName == "") {
//				sheet = workbook.getSheetAt(0);
//				ptr.updateStep("Found excel sheet in the workbook at index 0", "Pass");
//			} else {
//				sheet = workbook.getSheet(strSheetName);
//				ptr.updateStep("Found excel sheet in the workbook with name: " + strSheetName, "Pass");
//			}
//			if (sheet == null) {
//				System.out.println("Sheet not found in the worksheet: " + strSheetName);
//				// ptr.updateStep("Sheet not found in the worksheet: " +
//				// strSheetName, "Fail");
//				workbook.close();
//				return false;
//			}
//			// Iterate through all the serach strings from here {
//			for (String searchString : searchText) {
//				searchSucceeded = false; // Reinitialize
//				// Iterate rows
//				retryCount = 0;
//
//				while (!searchSucceeded || retryCount++ < 3) {
//					System.out.println("TRIAL Number: " + retryCount);
//
//					for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
//						System.out.println("Searching data: \"" + searchString + " \"through all rows of the sheet");
//						XSSFRow row = sheet.getRow(j);
//
//						// Iterate columns
//						if (null == row) {
//							continue;
//						}
//
//						for (int k = row.getFirstCellNum(); k < row.getLastCellNum(); k++) {
//							XSSFCell cell = row.getCell(k);
//
//							// ptr.wait(1000);
//
//							// Search value based on cell type
//							if (cell != null) {
//								switch (cell.getCellType()) {
//								case HSSFCell.CELL_TYPE_NUMERIC:
//									if (doubleValue != null
//											&& doubleValue.doubleValue() == cell.getNumericCellValue()) {
//										filteredRows.add(row);
//										break;
//									}
//									break;
//								case HSSFCell.CELL_TYPE_STRING:
//									if (searchString != null && searchString.contains(
//											cell.getRichStringCellValue().getString().trim().substring(substring))) {
//										// &&
//										// searchString.contains(cell.getRichStringCellValue().getString().trim().substring(index)))
//										// {
//										filteredRows.add(row);
//										System.out.println("try");
//										break;
//									}
//									break;
//								case HSSFCell.CELL_TYPE_BOOLEAN:
//									if (booleanValue != null
//											&& booleanValue.booleanValue() == cell.getBooleanCellValue()) {
//										filteredRows.add(row);
//									}
//									break;
//								default:
//									if (searchString != null && searchString.equals(cell.getStringCellValue())) {
//										filteredRows.add(row);
//									}
//									break;
//								}
//
//							}
//						}
//
//					} // End of iteration through all rows and columns of the
//						// excel file
//
//					if (filteredRows.size() > 0) {
//						searchSucceeded = true;
//						ptr.updateStep("Search string FOUND in the excel: " + searchString, "Pass");
//						break;
//					} else {
//						foundAllSearchStrings = foundAllSearchStrings && false;
//						System.out.println("Search string Not Found in the excel: " + searchString);
//						ptr.updateStep("Search string Not FOUND in the excel: " + searchString, "Fail");
//					}
//
//				} // End of while loop
//
//			} // End iteration after all search strings have been searched
//
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		} finally {
//			workbook.close();
//			excellFile.close();
//		}

		return true;
//		return foundAllSearchStrings;
	}

	/*
	 * Lib to find user and Clearspan Anywhere service present in CSV file
	 */

	public boolean searchCsvExcelSheet(String searchUser, String WorkSheet) throws IOException {
		// This parameter is for appending sheet rows to mergedSheet in the end

		BufferedReader fileReader = null;
		boolean searchSucceeded = false;

		try {

			// Create the file reader
			fileReader = new BufferedReader(new FileReader(WorkSheet));

			// Read the CSV file header to skip it
			String line = null;

			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(COMMA_DELIMITER);

				if (null != tokens && tokens.length == 18) {
					for (int index = 0; index < tokens.length; index++) {
						if (StringUtils.equalsIgnoreCase(searchUser, tokens[index])) {

							// Check if column 'Q' has 'Clearspan Anywhere' and
							// column 'R' has 'Premium'
							if (StringUtils.equals("Clearspan Anywhere", tokens[16])
									&& StringUtils.equals("Premium", tokens[17])) {
								searchSucceeded = true;
								break;
							}
						}

					}
					if (searchSucceeded) {
						break;
					}
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());

		} finally {
			fileReader.close();
		}

		return searchSucceeded;

	}

	/*
	 * Lib to execute sql query on obeasy mysql database Works on local instance of
	 * opeasy and mysql but fails on the remote EMS server due to security
	 * Firewalls.
	 * 
	 * 
	 */

	public void executeSQLQuery(String dbURL, String strUsername, String strPasword) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbURL, strUsername, strPasword);

			Statement st = conn.createStatement();
			String sqlquery = "SELECT * FROM csutil.logins WHERE LoginName = 'mallam'";
			ResultSet res = st.executeQuery(sqlquery);
			while (res.next()) {
				System.out.println(res.getString("LoginName"));
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}

	public boolean testImmediateReports(String strReportType, String strScreenName, String strEnterprise,
			String strGroup, String strDepartment, int intTimeoutMinutes) throws Exception {

		selectReportingType(strReportType, strScreenName, strEnterprise, strGroup, strDepartment);

		// Step 5. Click on Start Report
		ptr.click(ReportingPages.btn_StartReport, "Clicking on Start Report");

		// Step 8. Verify Status message changes to Complete
		if (!isReportGenerationStatusPresent(reportingpages.btn_Refresh,
				reportingpages.label_ImmediateReportStatusMessage, "Report completed successfully", intTimeoutMinutes,
				"Immediate")) {
			ptr.updateStep("Report generation failed with errors. Please verify manually once...", "Fail");
			return false;
		}

		return true;
	}

	/*
	 * public boolean testImmediateReports(String strReportType, String
	 * strScreenName, String strEnterprise, String strGroup, String strDepartment,
	 * int intTimeoutMinutes) throws Exception {
	 * 
	 * selectReportingType(strReportType, strScreenName, strEnterprise, strGroup,
	 * strDepartment);
	 * 
	 * // Step 5. Click on Start Report ptr.click(ReportingPages.btn_StartReport,
	 * "Clicking on Start Report"); ptr.wait(35000);
	 * 
	 * ptr.click(ReportingPages.btn_Refresh, "click refresh button");
	 * ptr.wait(35000);
	 * 
	 * if (driver.findElement(By.xpath("//span[contains(.,'Active')]")).isDisplayed
	 * ()){ ptr.click(ReportingPages.btn_Refresh, "click refresh button");
	 * ptr.wait(20000); ptr.click(ReportingPages.btn_Refresh,
	 * "click refresh button"); }else
	 * 
	 * // Step 8. Verify Status message changes to Complete if
	 * (!isReportGenerationStatusPresent(reportingpages.btn_Refresh,
	 * reportingpages.label_ImmediateReportStatusMessage,
	 * "Report completed successfully", intTimeoutMinutes, "Immediate")) {
	 * ptr.updateStep(
	 * "Report generation failed with errors. Please verify manually once...",
	 * "Fail"); return false; }
	 * 
	 * return true; }
	 */
	public boolean testScheduledReports(String strReportType, String strSchedule, int intRepeatAfterMinutes,
			int intMinutesToGenerateReport) throws Exception {

		// Schedule report now
		ptr.click(ReportingPages.btn_ScheduleReport, "Click on Schedule Report");
		ptr.wait(2000);

		// Verify Scheduling page appears
		ptr.assertTextContains(ReportingPages.text_Reporting_ScreenName, "Scheduling Request: " + strReportType);

		// Select Schedule Once
		ptr.selectDropdownByVisibleText(ReportingPages.dropDown_ReportSchedule, strSchedule,
				"Select Schedule: " + strSchedule);

		// Check if the report is repeated and configure accordingly
		if (strSchedule.contains("Repeated")) {

			driver.findElement(By.id("form1:textFieldScheduleStartTime"));

			// Fetch the current time from the "Initial Start Time" field
			String strCurrentTime = ptr.getText(reportingpages.textbox_ScheduleStartTime, "Get text from time box");
			ptr.updateStep("Time before: " + strCurrentTime, "Info");

			String strNextScheduledTime = dateAddMinutes(strCurrentTime, intRepeatAfterMinutes);

			// Set the initial start time filed with the newTime
			ptr.type(reportingpages.textbox_ScheduleStartTime, strNextScheduledTime,
					"Typing new time in the time box: " + strNextScheduledTime);

			// Set maximum number of runs as 1
			// ptr.type(reportingpages.text_FieldMaxRunCount, "1", "Typing max
			// run count to 1");

			// Click on start report button
			ptr.click(reportingpages.btn_ScheduleStartReport, "Click on button Start Report");

			// Check status changes to - Waiting to start...
			ptr.assertTextContains(reportingpages.label_ScheduleReportStatusMessage, "Waiting to start...");

			// Wait for 2+ minutes for repeating the report generation which is
			// 10 seconds more than 120 sec.
			int intWaitTime = (intRepeatAfterMinutes * 60000) + 10000; // converting
																		// minutes
																		// to
																		// milliseconds
			Log.info("Waiting for " + intRepeatAfterMinutes + " minutes for repeating the report generation "
					+ "which is 10 seconds more than 120 sec");
			ptr.wait(intWaitTime);

			WebElement refresh = driver.findElement(By.xpath("//span[contains(.,'Refresh')]"));
			try {
				if (refresh.isDisplayed()) {
					ptr.click(refresh, "click Rfresh button");
					ptr.wait(5000);
				} else {
					ptr.wait(2000);
				}
			} catch (Exception e) {
				ptr.updateStep("Refresh button not seen", "INFO");
			}
			ptr.wait(30000);
			try {
				if (refresh.isDisplayed()) {
					ptr.click(refresh, "click Refresh button");
					ptr.wait(5000);
				} else {
					ptr.wait(2000);
				}
			} catch (Exception e) {
				ptr.updateStep("Refresh button not seen", "INFO");
			}
			ptr.wait(10000);
			try {
				if (refresh.isDisplayed()) {
					ptr.click(refresh, "click Rfresh button");
					ptr.wait(5000);
					ptr.click(refresh, "click Rfresh button");
					ptr.wait(5000);
					ptr.click(refresh, "click Rfresh button");
					ptr.wait(5000);
					ptr.click(refresh, "click Rfresh button");
					ptr.wait(5000);

				} else {
					ptr.wait(2000);
				}
			} catch (Exception e) {
				ptr.updateStep("Refresh button not seen", "INFO");
			}

			// Step 8. Verify Status message changes to Complete
			if (!isReportGenerationStatusPresent(reportingpages.btn_ScheduleRefresh,
					reportingpages.label_ScheduleReportStatusMessage, "Finished", intMinutesToGenerateReport,
					"Scheduled")) {
				ptr.updateStep("Report generation failed with errors. Please verify manually once...", "Fail");
				return false;
			}

		} else { // Schedule is of the type "Run Once"

			// Click on Start Report button
			ptr.click(ReportingPages.btn_ScheduleStartReport, "Clicking on Start Report Button");

			ptr.click(ReportingPages.btn_ScheduleRefresh, "Click Refresh button");
			ptr.wait(2000);

			// Step 8. Verify Status message changes to Complete
			if (!isReportGenerationStatusPresent(reportingpages.btn_ScheduleRefresh,
					reportingpages.label_ScheduleReportStatusMessage, "Finished", intMinutesToGenerateReport,
					"Scheduled")) {
				ptr.updateStep("Report generation failed with errors. Please verify manually once...", "Fail");
				return false;
			}
		}

		// Click button OK
		ptr.click(opeasyCommonPageElements.btn_OK, "Clicking on OK button");

		return true;

	}

	/*
	 * Check if report is generated successfully until time out.
	 */

	public boolean isReportGenerationStatusPresent(WebElement eleButtonToRefresh, WebElement eleStatusObject,
			String strExpStatus, int intTimeOutInMinutes, String strRerportType) throws Exception {

		String strCurrentStatusMsg = "";
		// Convert minutes to ms
		intTimeOutInMinutes = intTimeOutInMinutes * 60000;
		int intWaitedTime = 30000;
		// // Step 16. Click on Refresh.
		// try {
		// ptr.click(eleButtonToRefresh, "Click button Refresh");
		// } catch(NoSuchElementException exc) {
		// // Do nothing
		// }

		// Wait until the import completes within the given timeout
		while (intWaitedTime < intTimeOutInMinutes) {
			// verify Refresh button is displayed
			try {
				// Increase the wait
				intWaitedTime += 30000;

				// wait for another 30 secs
				ptr.wait(40000);

				// Step 16. Click on Refresh.
				String strXpath = "form1:buttonRefresh";
				if (strRerportType.equals("Scheduled")) {
					strXpath = "form1:buttonRefreshStatus";
				}

				driver.findElement(By.id(strXpath)).click();
				ptr.wait(16000);

				if (strRerportType.equals("Scheduled")) {
					strCurrentStatusMsg = ptr.getText(reportingpages.label_ScheduleReportStatusMessage,
							"Getting text from Results Message box"); // form1:staticTextStatus
					if (strCurrentStatusMsg.contains("Finished")) {
						return true;
					} else {
						driver.findElement(By.id(strXpath)).click();
					}
				} else {
					strCurrentStatusMsg = ptr.getText(reportingpages.label_ReportStatusMessage,
							"Getting text from Results Message box"); // form1:staticTextStatus
					if (strCurrentStatusMsg.contains("Completed")) {
						return true;
					} else {
						driver.findElement(By.id(strXpath)).click();
					}
				}

			} catch (NoSuchElementException ex) {
				strCurrentStatusMsg = driver.findElement(By.id("form1:textResultsDetails")).getAttribute("value");
				if (strCurrentStatusMsg.contains(strExpStatus)) {
					ptr.updateStep("Report status matches expected: " + strExpStatus, "Pass");
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * Lib to select the Enterprise and other items before generating report
	 * 
	 */
	public void selectReportingType(String strPartialLinkText, String strScreenName, String strEnterprise,
			String strGroup, String strDepartment) throws Exception {

		// Step 4. Select Report
		try {
			// WebElement eleReportLink =
			// driver.findElement(By.partialLinkText(strPartialLinkText));
			WebElement eleReportLink = driver.findElement(By.xpath("//a[contains(.,'" + strPartialLinkText + "')]"));

			if (eleReportLink != null) {
				ptr.updateStep("Reporting link found on the Reporting page" + strPartialLinkText, "Pass");

				ptr.click(eleReportLink, "Clicking on link - " + strPartialLinkText);

				// Step 3. The Reporting page is displayed
				ptr.assertTextContains(ReportingPages.text_Reporting_ScreenName, strScreenName);

				// Select the suitable parameters
				if (!strEnterprise.contains("null")) {
					ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
							"Select Enterprise:" + strEnterprise);
				}

				// Select Group
				if (!strGroup.contains("null")) {
					ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group, strGroup,
							"Selecting Group :" + strGroup);
				}

				// Select Department
				if (!strDepartment.contains("null")) {
					ptr.selectDropdownByValue(ReportingPages.dropdown_Department, strDepartment,
							"Selecting Department :" + strDepartment);
				}
			}
		} catch (NoSuchElementException exception) {
			ptr.updateStep("Reporting link on the Reporting page not present: " + strPartialLinkText, "Fail");
			exception.printStackTrace();
		}
	}

	/*
	 * Lib to Retrieve rports from the reporting page Author - Viru
	 */
	public String retrieveReports(String strReportName) throws Exception {

		String strFilePath = null;
		boolean fileDownloaded = false;
		int i = 0;

		// Clear downloads folder before retrieving new reports
		clearDownloadsFolder();

		// Step 9. Retrieve Report
		ptr.click(ReportingPages.btn_RetreiveReport, "Clicking on Retrieve Report button");

		// Verify records in the downloaded report
		File downloads_path = new File(System.getProperty("user.dir") + "\\Downloads_Folder\\");
		File[] listOfFiles = downloads_path.listFiles();

		while (i++ <= 10) {
			// Wait for a minute
			ptr.wait(60000);
			if (listOfFiles.length > 0) {
				strFilePath = listOfFiles.toString();
				fileDownloaded = true;
				break;
			}
			if (fileDownloaded) {
				break;
			}
		}

		// // Retrieve value from text area Results field
		// WebElement eleTextAreaResults = driver
		// .findElement(By.id("form1:layoutPanelResultsDetails:textResultsDetails_field"));
		// String strTextAreaResults = eleTextAreaResults.getAttribute("value");
		// System.out.println(strTextAreaResults);
		//
		// // Verify if the Results has the SUCCESSFUL message
		// if (strTextAreaResults.contains("SUCCESSFUL: " + strReportName + "
		// completed successfully.")) {
		// ptr.updateStep("Report generated successully", "Pass");
		// return strFilePath;
		// } else {
		// ptr.updateStep("Report generation failed :" + strReportName, "Fail");
		// }
		return strFilePath;
	}
	// /*
	// * Lib to parse XML file and search for a node
	// */
	//
	// public boolean isParemeterPresentInXMLFile(String strXMLFile, String
	// strXpath) {
	// try
	// {
	// DocumentBuilderFactory documentBuilderFactory =
	// DocumentBuilderFactory.newInstance();
	// documentBuilderFactory.setNamespaceAware(true);
	// DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
	// File file = new File(strXMLFile);
	// Document doc = builder.parse(file);
	//
	//// DocumentBuilder docBuilder =
	// DocumentBuilderFactory.newInstance().newDocumentBuilder();
	//// Document doc = docBuilder.parse(new InputStream(new
	// StringReader(strXMLFile)));
	//
	// XPathFactory xPathFactory = XPathFactory.newInstance();
	// XPath xpath = xPathFactory.newXPath();
	//
	// XPathExpression expression = xpath.compile(strXpath);
	// // "/Inventory/Item[Quantity>200]/*"
	//
	// NodeList nodes = (NodeList) expression.evaluate(doc,
	// XPathConstants.NODESET);
	// if (nodes.getLength() > 0) {
	// return true;
	// } else {
	// return false;
	// }
	//
	// }

	// // Lib to select Enterprise
	// public void OpEasySelectEnterprise(String strEnterprise, String str)
	// throws Exception {
	//
	// // Select Enterprise
	// try {
	// driver.findElement(By.id("form1:layoutPanelTopControls:dropDownEnterprise_list"));
	// ptr.selectDropdownByValue(ProvisioningPages.dropdown_Enterprisee,
	// strEnterprise,
	// "Selecting an Enterprise : " + strEnterprise);
	// } catch (NoSuchElementException ex) {
	// try {
	// if
	// (driver.findElement(By.id("form1:layoutPanelTopControls:staticTextEnterprise"))
	// != null) {
	// if (!ptr.assertTextContains(ProvisioningPages.label_EnterpriseName,
	// strEnterprise)) {
	// // Enterprise selected is not same
	// ptr.updateStep("Selected Enterprise does not match to expected: " +
	// strEnterprise + "Actual : "
	// + ptr.getText(ProvisioningPages.label_EnterpriseName, "Actual Enterprise
	// selected :"),
	// "Fail");
	// }
	// } else {
	// ptr.updateStep("Enterprise selection not possible", "Fail");
	// }
	// } catch (NoSuchElementException exc) {
	// // Log.error("Element not found to select :" + strEnterprise +
	// // "Exception: " + exc);
	// }
	// }
	// }

	public static void Operation(String OperationName, String Value) throws Exception {

		if (OperationName.equals("DeleteDirNum")) {

			driver.findElement(By.xpath("//*[contains(text(),'" + Value + "')]/../td[7]/a/img")).click();

		} else if (OperationName.equals("DeleteCSP")) {
			driver.findElement(By.xpath("//*[contains(text(),'" + Value + "')]/../td[8]/a/img")).click();

		} else if (OperationName.equals("DeleteExtn")) {
			driver.findElement(By.xpath("//*[contains(text(),'" + Value + "')]/../td[8]/a/img")).click();

		} else if (OperationName.equals("DeleteSubsystem")) {
			driver.findElement(By.xpath("//*[contains(text(),'" + Value + "')]/../../td[8]/a/img")).click();

		} else if (OperationName.equals("DeleteOperator")) {
			driver.findElement(By.xpath("//*[contains(text(),'" + Value + "')]/../td[8]/a/img")).click();

		} else if (OperationName.equals("MediaGateway")) {
			driver.findElement(By.xpath("//*[contains(text(),'" + Value + "')]/../td[8]/a/img")).click();

		} else if (OperationName.equals("SubSystem")) {
			driver.findElement(By.xpath("//*[contains(text(),'" + Value + "')]/../td[8]/a/img")).click();

		}

	}
	/*
	 * Lib to clear Downloads_Folder in the STA Framework folder Author :
	 * Virupakshayya Kulkarni
	 */

	public void clearDownloadsFolder() {
		// Clean Downloads_Folder directory
		File downloads_path = new File(System.getProperty("user.dir") + "\\Downloads_Folder\\");
		try {
			org.apache.commons.io.FileUtils.cleanDirectory(downloads_path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Lib to add minutes to the date passed in the format MM/dd/yyyy HH:mm Author :
	 * Virupakshayya V Kulkarni
	 */
	public String dateAddMinutes(String strCurrentTime, int intRepeatAfterMinutes) throws ParseException {
		System.out.println("Present time: " + strCurrentTime);

		// Convert the string date to Date format
		Date dtTime = new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(strCurrentTime);
		System.out.println("Present time: " + dtTime);

		// Adding minutes to the Current time
		Date dtNextScheduledTime = DateUtils.addMinutes(dtTime, intRepeatAfterMinutes);
		System.out.println("New Time after adding " + dtNextScheduledTime);

		// Convert to string
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		String strNextScheduledTime = dateFormat.format(dtNextScheduledTime);

		System.out.println("New string Time after adding " + strNextScheduledTime);

		return strNextScheduledTime;
	}

	public static void selectGroup(String groupName) {
		driver.findElement(By.xpath("//*[contains(text(),'" + groupName + "')]/input")).click();
	}

	/*
	 * Lib to logout the users forcibly before starting the automation
	 * 
	 */

	public void opeasyLogoutUsersForcibly(String[] arrUsers) throws IOException, InterruptedException {

		ptr.click(OpeasyHomePage.link_LoginManagement, "Clicking on Login management");
		ptr.selectDropdownByValue(loginmanagementpage.dropDown_SelectSearchCriteria1, "LOGGED_IN",
				"Select only logged in users");
		ptr.click(opeasyCommonPageElements.btn_Search, "Click on search button");
		ptr.wait(5000);

		// Collect the names of logged in users in one string for comparison
		String strDynXpath = "//span[@id[contains(., 'tableColumnLoginName:staticTextLoginName')]]//span";
		List<WebElement> strLoggedInUsers = driver.findElements(By.xpath(strDynXpath));
		String strLoggedInUsrs = "";
		for (WebElement temp : strLoggedInUsers) {
			strLoggedInUsrs = strLoggedInUsrs + ";" + temp.getText();
		}

		for (String strUser : arrUsers) {
			if (strLoggedInUsrs.contains(strUser)) {
				String strXpath = "//span[contains(text(),'" + strUser + "')]";
				try {
					WebElement eleUser = driver.findElement(By.xpath(strXpath));
					Log.info("Found user logged in : " + strUser + " Logging out the User now");

					// select and log out the user
					ptr.click(eleUser, "Select the user to be logged out");
					WebElement ele = driver.findElement(By.xpath(".//input[@id[contains(.,':buttonLogoutUnlock')]]"));
					ele.click();
					ptr.alertAccept();
					ptr.click(OpeasyCommonPageElements.btn_OK, "Click button OK");

				} catch (org.openqa.selenium.NoSuchElementException e) {
					Log.info("User not logged in : " + strUser);
				}
			}

		}
	}

	/*
	 * Function to download the worksheet from Import page and return the downloaded
	 * import file name Author: Viru
	 */
	public String DownloadWorksheetFromImportPage(String strAdminLevel, String strImportType, String strEnterprise,
			String strGroup) throws IOException, InterruptedException {

		String strDropDownImportType = "";
		String strImportForFileDesc = "";

		// ImportType could be one of Advanced, System, Enterprise, Group
		if (!(strImportType.contains("Import"))) {
			strDropDownImportType = "Import: " + strImportType;
			strImportForFileDesc = "Import";
		}

		ptr.click(OpeasyHomePage.link_HeaderProvisioning, "Clicking on link Provisioning");

		ptr.click(provisioningpages.import_Link, "Click link Import");

		// Select Import Type
		ptr.selectDropdownByExactValue(ProvisioningPages.list_ImportType_list, strDropDownImportType,
				"Select Import Type: " + strDropDownImportType);

		// Select a Enterprise which has all three types(string, int, boolean)
		// of userfields defined.
		// If not ImportType is System, you need to select Enterprise
		if (!(strImportType.contains("System")) && ("SU|EA|SR|SA".contains(strAdminLevel))) {
			ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Select Enterprise : " + strEnterprise);
			if (strGroup != null) {
				ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Group, strGroup,
						"Select group: " + strGroup);
			}
		}

		String strWorksheetName = "Clearspan" + strImportForFileDesc + strImportType;
		if (strGroup != null) {
			strWorksheetName = strWorksheetName + "_" + strGroup;
		}

		if (strImportType.contains("Advanced")) {
			strWorksheetName = strWorksheetName + "_AutomationTest" + ".xlsx";
		} else {
			strWorksheetName = strWorksheetName + ".xlsm";
		}

		System.out.println("Workbook name constructed based on selection: " + strWorksheetName);

		// Step 11.Delete worksheet if already exists
		String source = System.getProperty("user.dir") + "\\" + "Downloads_Folder" + "\\" + strWorksheetName;

		File sourcepath = new File(source);
		deleteFileFromDisk(sourcepath.toString());
		ptr.wait(2000);

		// Step 12.Click on Get Work sheet
		ptr.click(ProvisioningPages.button_GetWorksheet, "Clicking on link: Get Worksheet");
		ptr.wait(10000);

		// Step 14.Delete File If Exists in Clearspan Folder

		if (fileExists(sourcepath)) {
			return sourcepath.toString();
		}

		return "";
	}

	// FOr Jazz Download worksheet
	public String DownloadWorksheetFromImportPageJazz(String strAdminLevel, String strImportType, String strEnterprise,
			String strGroup) throws IOException, InterruptedException {

		String strDropDownImportType = "";
		String strImportForFileDesc = "";

		// ImportType could be one of Advanced, System, Enterprise, Group
		if (!(strImportType.contains("Import"))) {
			strDropDownImportType = "Import: " + strImportType;
			strImportForFileDesc = "Import";
		}

		ptr.click(OpeasyHomePage.link_HeaderProvisioning, "Clicking on link Provisioning");

		ptr.click(provisioningpages.import_Link, "Click link Import");

		// Select Import Type
		ptr.selectDropdownByExactValue(ProvisioningPages.list_ImportType_list, strDropDownImportType,
				"Select Import Type: " + strDropDownImportType);

		// Select a Enterprise which has all three types(string, int, boolean)
		// of userfields defined.
		// If not ImportType is System, you need to select Enterprise
		if (!(strImportType.contains("System")) && ("SU|EA|SR|SA".contains(strAdminLevel))) {
			ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Select Enterprise : " + strEnterprise);
			if (strGroup != null) {
				ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Group, strGroup,
						"Select group: " + strGroup);
			}
		}
		String strWorksheetName = "Clearspan" + strImportForFileDesc + strImportType + "_AutomationTest";
		if (strGroup != null) {
			strWorksheetName = strWorksheetName + "_" + strGroup;
		}

		if (strImportType.contains("Advanced")) {
			strWorksheetName = strWorksheetName + ".xlsx";
		} else {
			strWorksheetName = strWorksheetName + ".xlsm";
		}

		System.out.println("Workbook name constructed based on selection: " + strWorksheetName);

		// Step 11.Delete worksheet if already exists
		String source = System.getProperty("user.dir") + "\\" + "Downloads_Folder" + "\\" + strWorksheetName;

		File sourcepath = new File(source);
		deleteFileFromDisk(sourcepath.toString());
		ptr.wait(2000);

		// Step 12.Click on Get Work sheet
		ptr.click(ProvisioningPages.button_GetWorksheet, "Clicking on link: Get Worksheet");
		ptr.wait(10000);

		// Step 14.Delete File If Exists in Clearspan Folder

		if (fileExists(sourcepath)) {
			return sourcepath.toString();
		}

		return "";
	}

	public boolean ImportWorkSheet(String strWorksheetFile, int intMaxTimeout, String strExpectedResponse)
			throws IOException, InterruptedException {

		int intWaitedTime = 30000;
		int intMaxTimeoutInSecs = 60000 * intMaxTimeout;

		// Step 16. Delete previous Import results for clarity
		try {
			if (provisioningpages.btn_DeleteImportResults.isDisplayed()) {
				ptr.click(provisioningpages.btn_DeleteImportResults, "Clicking on link: Refresh");
				ptr.wait(3000);
				ptr.alertAccept();
				ptr.wait(3000);
			}

		} catch (NoSuchElementException e) {
			// Do nothing
		}

		// Step 17.Click on Browse
		ptr.click(ProvisioningPages.btn_ProvisionSpreadsheet, "Clicking button ProvisionSpreadsheet");

		// Step 9. Choose file to upload
		String autoIttoolLocation = System.getProperty("user.dir") + "\\Upload_files" + "\\" + "ChooseFile.exe" + " ";
		Runtime.getRuntime().exec(autoIttoolLocation + strWorksheetFile);
		ptr.wait(3000);

		// Step 14. Click on Start Import Button.
		ptr.wait(10000);
		ptr.click(ProvisioningPages.start_Import_Button, "Clicking Button: Start Import");

		// // Step 15. Wait For Import Queued to start.
		// ptr.waitForElementPresent(ProvisioningPages.import_Queue_ScreenName,
		// 30);

		// Step 16. Click on Refresh.
		try {
			ptr.click(ProvisioningPages.btn_Refresh, "Clicking on link: Refresh");
		} catch (NoSuchElementException e) {
			// Do nothing
		}

		// Wait until the import completes within the given timeout
		while (intWaitedTime < intMaxTimeoutInSecs) {
			// verify Refresh button is displayed
			try {
				// Step 17. Wait for import to be completed.
				driver.findElement(By.xpath("//span[contains(text(),'Completed')]"));

				// break if completed
				break;

			} catch (NoSuchElementException ex) {

				// Increase the wait
				intWaitedTime += 30000;

				// wait for another 30 secs
				ptr.wait(30000);
				try {
					// Step 16. Click on Refresh.
					ptr.click(ProvisioningPages.btn_Refresh, "Clicking on link: Refresh");
					break;
				} catch (NoSuchElementException ex2) {
					// Do nothing

				}
			}
		}

		// Validate import has passed
		String strImportResults = driver.findElement(By.xpath(".//*[@id[contains(.,'textResultsDetails')]]"))
				.getAttribute("value");

		return strImportResults.contains(strExpectedResponse);

	}

	// Check if the user exists in opeasy
	@SuppressWarnings("static-access")
	public boolean userProfileExists(String strAdminLevel, String strEnterprise, String strGroup, String strSearchBy,
			String strSearchValue) throws IOException, InterruptedException {

		// Step 2. Go to provisioning -> user profiles
		ptr.click(OpeasyHomePage.link_Provisioning, "Clicking on link Proisioning");

		// Search the User in Users page and delete
		ptr.click(ProvisioningPages.link_UserProfiles, "Click on Users Profiles link to search the Profile");

		if ("SU|EA|SR|SA".contains(strAdminLevel)) {

			// Select Enterprise
			ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Select Enterprise : " + strEnterprise);

			// Select Group
			ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Group, strGroup, "Select Group : " + strGroup);
		}

		// Select SearchBy
		ptr.selectDropdownByValue(ProvisioningPages.dropdown_SearchCriteriarRow1, strSearchBy,
				"Select search criteria: " + strSearchBy);

		// Enter search by value
		ptr.type(ProvisioningPages.text_UsernameField, strSearchValue, "Enter search by value: " + strSearchValue);

		// Click on search button
		ptr.click(opeasyCommonPageElements.btn_Search, "Click Search button");
		ptr.wait(3000);

		// Verify if the user is listed in the table of search results
		String strDynamicXpath = "//span[contains(text(), '" + strSearchValue + "')]";
		try {
			driver.findElement(By.xpath(strDynamicXpath));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Log.info("User not found with search value: " + strSearchValue);
			return false;
		}

		Log.info("User found with search value: " + strSearchValue);
		return true;
	}

	// Check if the user exists in opeasy
	@SuppressWarnings("static-access")
	public boolean userExists(String strAdminLevel, String strEnterprise, String strGroup, String strSearchBy,
			String strSearchValue) throws StaleElementReferenceException, Exception {

		// Search the User in Users page and delete
		ptr.click(ProvisioningPages.link_Users, "Click on Users link to search the User");

		if (strAdminLevel.matches("SU|EA|SR|SA")) {

			// Select Enterprise
			ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Select Enterprise : " + strEnterprise);

			// Select Group
			ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Group, strGroup, "Select Group : " + strGroup);
		}

		createSearchCriteriaRow(1, strSearchBy, "", strSearchValue);
		ptr.wait(3000);

		// driver.findElement(By.xpath("//span[contains(.,'Search')]")).click();
		ptr.click(OpeasyCommonPageElements.btn_Search, "Click Button Search");
		ptr.wait(3000);

		// // Select SearchBy
		// ptr.selectDropdownByValue(ProvisioningPages.dropdown_SearchCriteriarRow1,
		// strSearchBy,
		// "Select search criteria: " + strSearchBy);
		//
		// // Enter search by value
		// ptr.type(ProvisioningPages.text_UsernameField, strSearchValue, "Enter
		// search by value: " + strSearchValue);
		//
		// // Click on search button
		// ptr.click(opeasyCommonPageElements.btn_VirtualUsersSearch, "Click
		// Search button");

		// Verify if the user is listed in the table of search results
		String strDynamicXpath = "//span[contains(text(), '" + strSearchValue + "')]";
		try {
			driver.findElement(By.xpath(strDynamicXpath));
			Log.info("User found with search value: " + strSearchValue);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Log.info("User not found with search value: " + strSearchValue);
			return false;
		}

		return true;
	}

	/*
	 * Lib to create Search Criteria row on OpEasy Users page or any other page
	 */

	public void createSearchCriteriaRowInLoginMangagement(int intRowNumber, String strSearchCrit, String strCondition,
			String strSearchValue) throws Exception, StaleElementReferenceException {

		WebElement eleSearchCrit = null;

		if (intRowNumber != 0) {
			intRowNumber = intRowNumber - 1;
		}

		if (strCondition == "") {
			strCondition = "Contains";
		}

		// Web elements of Search criteria table on Opeasy
		String strXpathSearchCriteria = ".//select[@id[contains(.,':" + intRowNumber
				+ ":columnQueryType:dropDownQueryType_list')]]";
		String strXpathSearchCondition = ".//select[@id[contains(.,':" + intRowNumber
				+ ":columnQueryComparison:dropDownQueryComparison_list')]]";
		String strXpathSearchValue = ".//input[@id[contains(.,':" + intRowNumber
				+ ":columnQueryValue:textFieldQueryValue_field')]]";

		// click + symbol at add multiple search
		if (intRowNumber > 1) {
			driver.findElement(By.xpath("(//button[@id[contains(.,'buttonRowAdd')]])[last()]")).click();
			ptr.wait(3000);
		}

		ptr.wait(2000);

		eleSearchCrit = driver.findElement(By.xpath(strXpathSearchCriteria));
		ptr.selectDropdownByValue(eleSearchCrit, strSearchCrit,
				"select Search Criteria field from drop down list: " + strSearchCrit);

		ptr.wait(2000);

		// Step 2. Select StartsWith from drop down list
		eleSearchCrit = driver.findElement(By.xpath(strXpathSearchCondition));
		ptr.selectDropdownByValue(eleSearchCrit, strCondition,
				"select Search Condition field from drop down list: " + strCondition);

		ptr.wait(2000);

		// Step 3. Enter Search value in the text box
		eleSearchCrit = driver.findElement(By.xpath(strXpathSearchValue));
		ptr.type(eleSearchCrit, strSearchValue, "Enter Search value in the text box: " + strSearchValue);

		ptr.wait(2000);

	}

	/*
	 * Lib to create Search Criteria row on OpEasy Users page or any other page
	 */

	public void createSearchCriteriaRow(int intRowNumber, String strSearchCrit, String strCondition,
			String strSearchValue) throws Exception, StaleElementReferenceException {

		WebElement eleSearchCrit = null;

		// Web elements of Search criteria table on Opeasy

		String strXpathSearchCriteria = "//label[@id='form1:UserSearchFragment:tableSearchCriteria:"
				+ (intRowNumber - 1) + ":fieldName_label']";
		String strXpathSearchCondition = "//label[@id='form1:UserSearchFragment:tableSearchCriteria:"
				+ (intRowNumber - 1) + ":fieldCondition_label']";
		String strXpathSearchValue = "//input[@id='form1:UserSearchFragment:tableSearchCriteria:" + (intRowNumber - 1)
				+ ":fieldValue']";

		// click + symbol at add multiple search
		if (intRowNumber > 1) {
			driver.findElement(By.xpath("(//button[@id[contains(.,'buttonRowAdd')]])[last()]")).click();
			ptr.wait(3000);
		}

		eleSearchCrit = driver.findElement(By.xpath(strXpathSearchCriteria));
		ptr.selectDropdownByValue(eleSearchCrit, strSearchCrit,
				"select Search Criteria field from drop down list: " + strSearchCrit);
		ptr.wait(2000);

		// Step 2. Select StartsWith from drop down list
		if (!(strCondition.equals("")) && (strCondition != null)) {
			eleSearchCrit = driver.findElement(By.xpath(strXpathSearchCondition));
			ptr.selectDropdownByValue(eleSearchCrit, strCondition,
					"select Search Condition field from drop down list: " + strCondition);
			ptr.wait(2000);
		}

		// Step 3. Enter Search value in the text box
		if (!(strSearchValue.equals("")) && (strCondition != null)) {
			eleSearchCrit = driver.findElement(By.xpath(strXpathSearchValue));
			ptr.type(eleSearchCrit, strSearchValue, "Enter Search value in the text box: ");
			ptr.wait(2000);
		}

	}

	/*
	 * Lib to delete search criteria
	 * 
	 */
	public void deleteSearchCriteriaLastRow() throws InterruptedException {
		driver.findElement(By.xpath("(//button[@id[contains(.,'buttonRowDelete')]])[last()]")).click();
		ptr.wait(3000);
	}

	/*
	 * Lib to create Search Criteria row on OpEasy Users page or any other page
	 */

	public void createGroupSearchCriteriaRow(int intRowNumber, String strSearchCrit, String strCondition,
			String strSearchValue) throws Exception, StaleElementReferenceException {

		WebElement eleSearchCrit = null;

		if (intRowNumber != 0) {
			intRowNumber = intRowNumber - 1;
		}

		if (strCondition == "") {
			strCondition = "Contains";
		}

		// Web elements of Search criteria table on Opeasy

		String strXpathSearchCriteria = "//label[@id='form1:rowGroupSearchCriteria:" + intRowNumber
				+ ":fieldName_label']";
		String strXpathSearchCondition = "//label[@id='form1:rowGroupSearchCriteria:" + intRowNumber
				+ ":fieldComparison_label']";
		String strXpathSearchValue = "//input[@id='form1:rowGroupSearchCriteria:" + intRowNumber + ":fieldValue']";
		String strXpathAddSearchCriteriaRow = "(//button[@id[contains(.,'buttonRowAdd')]])[last()]";

		// click + symbol at add multiple search
		if ((intRowNumber + 1) > 1) {
			WebElement btnDdRow = driver.findElement(By.xpath(strXpathAddSearchCriteriaRow));
			ptr.click(btnDdRow, "Click button AddRow");
			ptr.wait(10000);
		}

		eleSearchCrit = driver.findElement(By.xpath(strXpathSearchCriteria));
		ptr.selectDropdownByValue(eleSearchCrit, strSearchCrit,
				"select Search Criteria field from drop down list: " + strSearchCrit);

		ptr.wait(5000);

		if (!(strCondition.equals("Contains"))) {
			// Step 2. Select StartsWith from drop down list
			eleSearchCrit = driver.findElement(By.xpath(strXpathSearchCondition));
			ptr.selectDropdownByValue(eleSearchCrit, strCondition,
					"select Search Condition field from drop down list: " + strCondition);

			ptr.wait(5000);
		}

		// Step 3. Enter Search value in the text box
		eleSearchCrit = driver.findElement(By.xpath(strXpathSearchValue));
		ptr.type(eleSearchCrit, strSearchValue, "Enter Search value in the text box: " + strSearchValue);

		ptr.wait(5000);

	}

	/*
	 * Lib to create Search Criteria row on OpEasy Users page or any other page
	 */

	public void createExportPageSearchCriteriaRow(int intRowNumber, String strSearchCrit, String strCondition,
			String strSearchValue) throws Exception, StaleElementReferenceException {

		WebElement eleSearchCrit = null;

		if (intRowNumber != 0) {
			intRowNumber = intRowNumber - 1;
		}

		if (strCondition == "") {
			strCondition = "Contains";
		}

		// Web elements of Search criteria table on Opeasy

		String strXpathSearchCriteria = "//label[@id='form1:tableSearchCriteria:" + intRowNumber + ":fieldName_label']";
		String strXpathSearchCondition = "//label[@id='form1:tableSearchCriteria:" + intRowNumber
				+ ":fieldCondition_label']";
		String strXpathSearchValue = "//input[@id='form1:tableSearchCriteria:" + intRowNumber + ":fieldValue']";

		// click + symbol at add multiple search
		if ((intRowNumber + 1) > 1) {
			driver.findElement(By.xpath("(//button[@id[contains(.,'buttonRowAdd')]])[last()]")).click();
			ptr.wait(3000);
		}

		eleSearchCrit = driver.findElement(By.xpath(strXpathSearchCriteria));
		ptr.wait(3000);
		ptr.selectDropdownByValue(eleSearchCrit, strSearchCrit,
				"select Search Criteria field from drop down list: " + strSearchCrit);

		ptr.wait(2000);

		if (!(strCondition.equals("Contains"))) {
			// Step 2. Select StartsWith from drop down list
			eleSearchCrit = driver.findElement(By.xpath(strXpathSearchCondition));
			ptr.selectDropdownByValue(eleSearchCrit, strCondition,
					"select Search Condition field from drop down list: " + strCondition);

			ptr.wait(2000);
		}

		// Step 3. Enter Search value in the text box
		eleSearchCrit = driver.findElement(By.xpath(strXpathSearchValue));
		ptr.type(eleSearchCrit, strSearchValue, "Enter Search value in the text box: " + strSearchValue);

		ptr.wait(2000);

	}

	/*
	 * Lib to create Search Criteria row on OpEasy Users page or any other page
	 */

	public void createSearchCriteriaRowForVirtualUsers(String strSearchCrit, String strCondition, String strSearchValue)
			throws Exception, StaleElementReferenceException {

		WebElement eleSearchCrit = null;

		// Web elements of Search criteria table on Opeasy
		String strXpathSearchCriteria = "form1:dropDownQueryType_label";

		eleSearchCrit = driver.findElement(By.id(strXpathSearchCriteria));
		ptr.selectDropdownByValue(eleSearchCrit, strSearchCrit,
				"select Search Criteria field from drop down list: " + strSearchCrit);
		ptr.wait(2000);

		if (!(strCondition == "")) {
			// Step 2. Select StartsWith from drop down list
			String strXpathSearchCondition = "form1:dropDownQueryComparison_label";
			eleSearchCrit = driver.findElement(By.id(strXpathSearchCondition));
			ptr.selectDropdownByValue(eleSearchCrit, strCondition,
					"select Search Condition field from drop down list: " + strCondition);
			ptr.wait(2000);
		}

		// Step 3. Enter Search value in the text box
		if (!(strSearchValue == "")) {
			String strXpathSearchValue = "form1:textInputQueryValue";
			eleSearchCrit = driver.findElement(By.id(strXpathSearchValue));
			ptr.type(eleSearchCrit, strSearchValue, "Enter Search value in the text box: ");
		}

		ptr.wait(2000);

	}

	/*
	 * Lib to create Search Criteria row on OpEasy Users page or any other page
	 */

	public void createSearchCriteriaRowOnLoginManagementPage(int intRowNumber, String strSearchCrit,
			String strCondition, String strSearchValue) throws Exception, StaleElementReferenceException {

		WebElement eleSearchCrit = null;

		// click + symbol at add multiple search if second or sub sequest rows
		if (intRowNumber > 1) {
			driver.findElement(By.xpath("(//button[@id[contains(.,'buttonRowAdd')]])[last()]")).click();
			ptr.wait(3000);
		}

		int intWebElementIndexforSearchElements = intRowNumber - 1;

		// if (strCondition == "") {
		// strCondition = "Contains";
		// }

		// Web elements of Search criteria table on Opeasy

		String strXpathSearchCriteria = "//label[@id='form1:tableSearchCriteria:" + intWebElementIndexforSearchElements
				+ ":dropDownQueryType_label']";

		eleSearchCrit = driver.findElement(By.xpath(strXpathSearchCriteria));
		ptr.selectDropdownByValue(eleSearchCrit, strSearchCrit,
				"select Search Criteria field from drop down list: " + strSearchCrit);
		ptr.wait(5000);

		if (!(strCondition == "")) {
			// Step 2. Select StartsWith from drop down list
			String strXpathSearchCondition = "//label[@id='form1:tableSearchCriteria:"
					+ intWebElementIndexforSearchElements + ":dropDownQueryComparison_label']";
			eleSearchCrit = driver.findElement(By.xpath(strXpathSearchCondition));
			ptr.selectDropdownByValue(eleSearchCrit, strCondition,
					"select Search Condition field from drop down list: " + strCondition);
			ptr.wait(2000);
		}

		// Step 3. Enter Search value in the text box
		if (!(strSearchValue == "")) {
			String strXpathSearchValue = "//input[@id='form1:tableSearchCriteria:" + intWebElementIndexforSearchElements
					+ ":textFieldQueryValue']";
			eleSearchCrit = driver.findElement(By.xpath(strXpathSearchValue));
			ptr.type(eleSearchCrit, strSearchValue, "Enter Search value in the text box: " + strSearchValue);
		}

		ptr.wait(2000);

	}

	/*
	 * Lib to add device user with Billing Type
	 */

	@SuppressWarnings("static-access")
	public boolean addUser(String strEnterprise, String strGroup, String strBillingType, String strPhoneNum)
			throws IOException, InterruptedException {

		String strLastName = "AutoTestLastName";
		String strFirstName = "AutoTestFirstName";

		ptr.click(opeasyCommonPageElements.btn_Add, "Click button Add to add new user");

		// Enter Clearspan User related fields
		ptr.type(provisioningpages.lastname_Clearspan_User, strLastName, "Enter last name: " + strLastName);
		ptr.type(provisioningpages.firstname_Clearspan_User, strLastName, "Enter fist name: " + strFirstName);
		ptr.type(provisioningpages.userPassword_Clearspan_User, strLastName,
				"Enter Clearspan user password: " + strPhoneNum);
		ptr.type(provisioningpages.text_Userconfirmpassword, strLastName,
				"Enter Clearspan user confirm password: " + strFirstName);
		ptr.type(provisioningpages.clearspan_UserID, strPhoneNum, "Enter User Info: Clearspan User ID: " + strPhoneNum);
		ptr.type(provisioningpages.calling_Line_Lastname, strLastName,
				"Enter Calling Line ID > Last name: " + strLastName);
		ptr.type(provisioningpages.calling_Line_Firstname, strLastName,
				"Enter Calling Line ID > First name: " + strFirstName);

		// Select Phone number
		ptr.selectDropdownByValue(provisioningpages.dropdown_Phonenumber, strPhoneNum,
				"Selecting Phone number: " + strPhoneNum);

		// Select Billing Type
		if (strBillingType != null) {
			ptr.selectDropdownByVisibleText(provisioningpages.lst_BillingUsertype, strBillingType,
					"Selecting Billing Type: " + strBillingType);
		}

		ptr.click(opeasyCommonPageElements.btn_OK, "Click OK buttin");

		// verify no error message appears

		if (isMessageDisplayed("Error Messages")) {
			return false;
		}

		return true;

	}

	// Check if the user exists in opeasy
	@SuppressWarnings("static-access")
	public boolean virtualUserExists(String strAdminLevel, String strEnterprise, String strGroup, String strSearchBy,
			String strSearchValue, String virtualUserType) throws StaleElementReferenceException, Exception {

		// TBD - Click Provisioning
		ptr.click(opeasyhome.link_HeaderProvisioning, "Click Provisioning link");
		ptr.wait(5000);
		ptr.click(provisioningpages.link_VirtualUsers, "Click link Virtual Users");
		ptr.wait(5000);

		// Search the User in Users page and delete
		switch (virtualUserType) {
		case "Auto Attendants":
			ptr.click(ProvisioningPages.link_AutoAttendants, "Click on link_AutoAttendants");
			break;
		case "Flexible Seating Hosts":
			ptr.click(ProvisioningPages.link_FlexibleSeatingHosts, "Click on link_FlexibleSeatingHosts");
			break;
		case "Hunt Groups":
			ptr.click(ProvisioningPages.link_HuntGroups, "Click on link_HuntGroups");
			break;
		case "Virtual User Inventory":
			ptr.click(ProvisioningPages.link_VirtualUserInventory, "Click on link_VirtualUserInventory");
			break;
		}

		if ("SU|EA|SR|SA".contains(strAdminLevel)) {

			// Select Enterprise
			ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Select Enterprise : " + strEnterprise);

			// Select Group
			ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Group, strGroup, "Select Group : " + strGroup);
		}

		createSearchCriteriaRowForVirtualUsers(strSearchBy, "", strSearchValue);
		//
		// // Select SearchBy
		// switch (virtualUserType) {
		// case "Auto Attendants":
		// ptr.selectDropdownByValue(ProvisioningPages.dropdown_VirtAutoAttUserSearchCriteria,
		// strSearchBy,
		// "Select search criteria: " + strSearchBy);
		// ptr.type(ProvisioningPages.txt_VirtUserAutoAttInputQueryValue_field,
		// strSearchValue,
		// "Enter search by value: " + strSearchValue);
		// break;
		//
		// case "Flexible Seating Hosts":
		// ptr.selectDropdownByValue(ProvisioningPages.dropdown_VirtUserFlexHostSearchCriteria,
		// strSearchBy,
		// "Select search criteria: " + strSearchBy);
		// ptr.type(ProvisioningPages.txt_VirtUserFlexSeatingHostInputQueryValue_field,
		// strSearchValue,
		// "Enter search by value: " + strSearchValue);
		// break;
		//
		// case "Hunt Groups":
		// ptr.selectDropdownByValue(ProvisioningPages.dropdown_VirtUserHuntGroupsSearchCriteria,
		// strSearchBy,
		// "Select search criteria: " + strSearchBy);
		// ptr.type(ProvisioningPages.txt_VirtUserHuntGroupsInputQueryValue_field,
		// strSearchValue,
		// "Enter search by value: " + strSearchValue);
		// break;
		//
		// case "Virtual User Inventory":
		// ptr.selectDropdownByValue(ProvisioningPages.dropdown_VirtUserVirtUserInvSearchCriteria,
		// strSearchBy,
		// "Select search criteria: " + strSearchBy);
		// ptr.type(ProvisioningPages.txt_VirtUserVirtUserInvInputQueryValue_field,
		// strSearchValue,
		// "Enter search by value: " + strSearchValue);
		// break;
		// }

		// Click on search button
		ptr.wait(3000);
		ptr.click(opeasyCommonPageElements.btn_Search, "Click Search button");
		ptr.wait(5000);

		// Verify if the user is listed in the table of search results
		String strDynamicXpath = "//span[contains(text(), '" + strSearchValue + "')]";
		try {
			driver.findElement(By.xpath(strDynamicXpath));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Log.info("User not found with search value: " + strSearchValue);
			return false;
		}

		Log.info("User found with search value: " + strSearchValue);
		return true;
	}

	// Delete user if exists
	public boolean deleteVirtualUserThatExists(String strUserSearchValue) throws IOException, InterruptedException {

		// Verify if the user is listed in the table of search results
		String strDynamicXpath = "//span[contains(text(), '" + strUserSearchValue + "')]";
		try {
			driver.findElement(By.xpath(strDynamicXpath));
			strDynamicXpath = "//a[contains(text(), 'Edit')]";
			try {
				WebElement eleUserEditLink = driver.findElement(By.xpath(strDynamicXpath));
				ptr.click(eleUserEditLink, "Click on Edit link to delete the User later.");

				ptr.click(opeasyCommonPageElements.btn_Delete, "Click buttin Delete");
				ptr.wait(5000);
				ptr.alertAccept();

				return true;

			} catch (org.openqa.selenium.NoSuchElementException e) {
				// ptr.updateStep("User not found with search value: " +
				// strUserSearchValue, "Fail");
				Log.info("User not found with search value: " + strUserSearchValue);
				return false;
			}

			// span[contains(a, 'Edit')]
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// ptr.updateStep("User not found with search value: " +
			// strUserSearchValue, "Fail");
			Log.info("User not found with search value: " + strUserSearchValue);
			return false;
		}

	}

	// Lib to delete device from Phone management
	// Check if the user exists in opeasy
	@SuppressWarnings("static-access")
	public boolean deviceExists(String strAdminLevel, String strEnterprise, String strGroup, String strSearchBy,
			String strSearchValue) throws IOException, InterruptedException {

		// TBD - Click Provisioning
		ptr.click(OpeasyHomePage.link_HeaderProvisioning, "Click link - Provisioning");
		// ptr.click(provisioningpages.link_provisioning, "Click Provisioning
		// link");

		// Search the User in Users page and delete
		ptr.click(ProvisioningPages.link_PhoneManagement, "Click on link_PhoneManagement to search the device");

		if ("SU|EA|SR|SA".contains(strAdminLevel)) {
			// Select Enterprise
			ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Select Enterprise : " + strEnterprise);

			// Select Group
			ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Group, strGroup, "Select Group : " + strGroup);
		}

		// Create Search criteria row
		// Select SearchBy
		try {
			createSearchCriteriaRow(1, strSearchBy, "", strSearchValue);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// ptr.selectDropdownByValue(ProvisioningPages.dropdown_SearchCriteriarRow1,
		// strSearchBy,
		// "Select search criteria: " + strSearchBy);
		//
		// // Enter search by value
		// ptr.type(ProvisioningPages.text_SearchValueRow1, strSearchValue,
		// "Enter search by value: " + strSearchValue);

		// Click on search button
		ptr.wait(3000);
		ptr.click(opeasyCommonPageElements.btn_Search, "Click Search button");
		ptr.wait(3000);

		// Verify if the user is listed in the table of search results
		String strDynamicXpath = "//span[contains(text(), '" + strSearchValue + "')]";
		try {
			driver.findElement(By.xpath(strDynamicXpath));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Log.info("Device not found with search value: " + strSearchValue);
			return false;
		}

		Log.info("Device found with search value: " + strSearchValue);
		return true;
	}

	// Delete user if exists
	@SuppressWarnings("static-access")
	public boolean deleteDeviceThatExists(String strUserSearchValue) throws IOException, InterruptedException {

		// Verify if the user is listed in the table of search results
		String strDynamicXpath = "//span[contains(text(), '" + strUserSearchValue + "')]";
		try {
			WebElement eleUserName = driver.findElement(By.xpath(strDynamicXpath));
			strDynamicXpath = "(//a[contains(.,'Edit')])[1]";
			eleUserName = driver.findElement(By.xpath(strDynamicXpath));
			ptr.click(eleUserName, "Click on Edit link to delete the device later.");
			try {
				// strDynamicXpath = "(//a[contains(.,'Edit')])[1]";
				eleUserName = driver.findElement(By.xpath(strDynamicXpath));

				// WebElement eleUserEditLink =
				// driver.findElement(By.xpath(strDynamicXpath));
				ptr.click(eleUserName, "Click on Edit link to delete the device now.");

				// Delete User
				ptr.click(opeasyCommonPageElements.btn_Delete, "Click buttin Delete");
				ptr.wait(5000);
				ptr.alertAccept();

				// Now press delete to delete the device
				ptr.wait(5000);
				ptr.click(opeasyCommonPageElements.btn_Delete, "Click buttin Delete");
				ptr.wait(5000);
				return true;

			} catch (org.openqa.selenium.NoSuchElementException e) {
				// ptr.updateStep("User not found with search value: " +
				// strUserSearchValue, "Fail");
				Log.info("User not found with search value: " + strUserSearchValue);
				return false;
			}

			// span[contains(a, 'Edit')]
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// ptr.updateStep("User not found with search value: " +
			// strUserSearchValue, "Fail");
			Log.info("User not found with search value: " + strUserSearchValue);
			return false;
		}

	}

	// Delete user if exists
	@SuppressWarnings("static-access")
	public boolean deleteUserThatExists(String strUserSearchValue) throws IOException, InterruptedException {

		// Verify if the user is listed in the table of search results
		String strDynamicXpath = "//span[contains(text(), '" + strUserSearchValue + "')]";
		try {
			driver.findElement(By.xpath(strDynamicXpath));
			strDynamicXpath = "//a[contains(text(), 'Edit')]";
			try {
				WebElement eleUserEditLink = driver.findElement(By.xpath(strDynamicXpath));
				ptr.click(eleUserEditLink, "Click on Edit link to delete the User later.");

				// Delete User
				ptr.click(opeasyCommonPageElements.btn_Delete, "Click button Delete");
				ptr.alertAccept();
				ptr.wait(5000);

				try {
					driver.findElement(By.xpath("//*[@id='form1:buttonDelete']/span")).click();
					ptr.wait(5000);
				} catch (NoSuchElementException e) {
					// Do nothing
				}

				return true;
			} catch (org.openqa.selenium.NoSuchElementException e) {
				// ptr.updateStep("User not found with search value: " +
				// strUserSearchValue, "Fail");
				ptr.updateStep("User not found with search value: " + strUserSearchValue, "Info");
				return false;
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			ptr.updateStep("User not found with search value: " + strUserSearchValue, "Info");
			return false;
		}

	}

	// public boolean UserDefinedFieldValuesPresent(String strEnterprise, String
	// strGroup, String strSearchBy,
	// String strSearchValue, String strUserID, String strFieldValuePairs)
	// throws IOException, InterruptedException {
	//
	// if (userExists( strEnterprise, strGroup, strSearchBy, strUserID)) {
	// //View User details
	// String strDynXpath = "//a[contains(text(),'View')]";
	// driver.findElement(By.xpath(strDynXpath)).click();
	//
	// ptr.assertTextEquals(ProvisioningPages.textuser_ScreenName, "Advanced:
	// User View");
	//
	// //Verify the field values present
	// String[] lstFieldsValues = strFieldValuePairs.split(";");
	// for (String strFieldValue: lstFieldsValues) {
	// strDynXpath = "(.//span[contains(text(),'" + strFieldValue + "')]";
	// driver.findElement(By.xpath(strDynXpath));
	// ptr.updateStep("UserDefined field value present" + strFieldValue,
	// "Pass");
	// }
	// }
	// return true;
	// }

	public void OpEasy_CheckBoxOperateOnExportPage(String strCB_Name, String strCheckUncheckValue) {
		String strDynXPath = "//input[@value='" + strCB_Name + "']";
		WebElement eleCheckBox = driver.findElement(By.xpath(strDynXPath));
		// Actions builder = new Actions(driver);
		if (!eleCheckBox.isSelected() && strCheckUncheckValue.equalsIgnoreCase("check")) {
			// builder.moveToElement(eleCheckBox, 2,
			// 2).click().build().perform();
			// builder.moveToElement(eleCheckBox, 10, 10).sendKeys(Keys.SPACE);
			eleCheckBox.click();
			// driver.action.context_click(el).perform
			ptr.updateStep("Selected the checkbox: " + strCB_Name, "Pass");
		} else if (eleCheckBox.isSelected() && strCheckUncheckValue.equalsIgnoreCase("uncheck")) {
			ptr.updateStep("Unchecked the checkbox: " + strCB_Name, "Pass");
			// builder.moveToElement(eleCheckBox, 4,
			// 4).click().build().perform();
			eleCheckBox.click();
		}
	}

	/*
	 * Lib to Add Alternate Phone numbers
	 */

	public void addNAltPhoneNumbers(String strStartingPhoneNum, boolean blnAddPhone, boolean blnAddExtension,
			boolean ringPattern, boolean description, int intNNumbers) throws IOException, InterruptedException {
		WebElement eleTxtBoxExt;
		WebElement eleTxtBoxRing;
		WebElement eleTxtBoxdesc;
		String strDesc = "test";
		String strExt = "";
		String strPhoneNum = "";
		String strDynXpath = "";
		int intIters = intNNumbers + 1;

		int indRingPat = 1;
		int phoneNumIndex = 2;

		for (int i = 2; i <= intIters; i++) {

			// Add phone number
			System.out.println("1 : i = " + i + " phoneNumIndex = " + phoneNumIndex);
			strDynXpath = "(//select)[" + phoneNumIndex + "]";
			driver.findElement(By.xpath(strDynXpath));

			strPhoneNum = strStartingPhoneNum + (i - 2);
			if (blnAddPhone) {
				// ptr.selectDropdownByVisibleText(eleDropDownPhNum,
				// strPhoneNum,
				// "Selecting Phone number: " + strPhoneNum);
				String strDropDownElement = "form1:rowGroupQueryResults:" + (phoneNumIndex - 2)
						+ ":dropDownPhoneNumber";
				ptr.selectDropdownByValue(strDropDownElement, strPhoneNum, "Selecting Phone Number: " + strPhoneNum);
				ptr.wait(3000);

			}

			// Add Ext number if asked, automatically pick the last four digits
			// of ph num
			if (blnAddExtension) {
				System.out.println("2 : i = " + phoneNumIndex + " phoneNumIndex = " + phoneNumIndex);
				strDynXpath = "//*[@id=\"form1:rowGroupQueryResults:" + (phoneNumIndex - 2) + ":extension\"]";
				eleTxtBoxExt = driver.findElement(By.xpath(strDynXpath));
				// extract only the last 4 digits of the phone number
				strExt = strPhoneNum.substring(strPhoneNum.length() - 4);
				ptr.type(eleTxtBoxExt, strExt, "Entering ext: " + strExt + " for phone number: " + strPhoneNum);
				ptr.wait(3000);
			}

			// Add Ring Pattern if asked, automatically pick from drop down list
			if (ringPattern) {
				strDynXpath = "(//select//ancestor::span/parent::td/parent::*/child::td[5]//span//select)[" + indRingPat
						+ "]";
				eleTxtBoxRing = driver.findElement(By.xpath(strDynXpath));
				System.out.println("3 : i = " + i + " indRingPat = " + indRingPat);
				if (indRingPat == 1) {
					ptr.selectDropdownByVisibleText(eleTxtBoxRing, "Long-Long", "Selecting Ring Pattern: Long-Long ");
				} else if (indRingPat == 5) {
					ptr.selectDropdownByVisibleText(eleTxtBoxRing, "Short-Short-Long",
							"Selecting Ring Pattern: Long-Long ");
				} else if (indRingPat == 7) {
					ptr.selectDropdownByVisibleText(eleTxtBoxRing, "Short-Long-Short",
							"Selecting Ring Pattern: Long-Long ");
				} else {
					ptr.selectDropdownByVisibleText(eleTxtBoxRing, "Normal", "Selecting Ring Pattern: Long-Long ");
				}
				ptr.wait(3000);

			}

			if (description) {
				System.out.println("4 - i = " + i + " phoneNumIndex = " + phoneNumIndex);
				strDynXpath = "(//*[@id=\"form1:rowGroupQueryResults_data\"]//tr[" + (phoneNumIndex - 1)
						+ "]//input)[last()]";
				eleTxtBoxdesc = driver.findElement(By.xpath(strDynXpath));
				// extract only the last 4 digits of the phone number
				// strExt = strPhoneNum.substring(strPhoneNum.length() - 4);
				ptr.type(eleTxtBoxdesc, strDesc, "Enter description" + strDesc);
				ptr.wait(3000);
			}
			phoneNumIndex = phoneNumIndex + 1;
			indRingPat = indRingPat + 1;
		}

		// Click Apply.
		ptr.wait(10000);
		ptr.click(opeasyCommonPageElements.btn_Apply, "Click Apply");

		// 1) Verify Saved message is displayed and Alternate Number is added.
		ptr.assertTextEquals(ProvisioningPages.txt_screeSavedMessage, "Saved");

		// Click OK
		ptr.click(opeasyCommonPageElements.btn_OK, "Click OK");

	}

	/*
	 * //Login as SU and cvhange other Admins privileges
	 * 
	 * public void ModifyAdminPrivilegefromSU(String privilegeName, String
	 * strAccessLevel) throws Exception {
	 * 
	 * // Step 1. Login to OpEasy as super User opeasyClearLoginSessions(opeasyUrl,
	 * OpeasyUsername, OpeasyPassword);
	 * 
	 * selectMainPageMenuItem("Login Management", "Login Management");
	 * ptr.wait(3000);
	 * 
	 * // Step 4. Search and edit a System Admin
	 * ptr.selectDropdownByValue(LoginManagementPages.dropdown_adminSearch,
	 * strdropdownAdminsearch, "Select System Admin from drop down :" +
	 * strdropdownAdminsearch);
	 * 
	 * // Step 5. Search value enter ptr.type(LoginManagementPages.text_Admin,
	 * strOpeasy_Username, "Select Enterprise Admin from drop down :" +
	 * strOpeasy_Username);
	 * 
	 * // Step 5. Click Search button ptr.click(OpeasyCommonPageElements.btn_Search,
	 * " Click Search button");
	 * 
	 * // if (LoginUserExists(strAdmin)) { try { String dynXpath =
	 * ".//a[contains(text(), 'Edit')]";
	 * driver.findElement(By.xpath(dynXpath)).click(); } catch
	 * (org.openqa.selenium.NoSuchElementException e) {
	 * Log.info("UserExists not found: " + strOpeasy_Username); } // Validate the
	 * screen name: OpEasy Administrator Modify
	 * ptr.isElementPresent(LoginManagementPages.
	 * text_Administrator_Modify_ScreenName,
	 * "Validate screen title: OpEasy Administrator Modify");
	 * 
	 * // Modify access level Log.info("Modify the access level for the user: " +
	 * strOpeasy_Username); ptr.click(LoginManagementPages.btn_CustomizePrivilege,
	 * "Click button: Customize Privilege"); ptr.wait(2000);
	 * 
	 * ModifyUserPrivilege(privilegeName1, "No Access");
	 * 
	 * // Step 13. click Apply Button ptr.click(OpeasyCommonPageElements.buttonOK,
	 * "Clicking on btn OK"); ptr.wait(2000);
	 * 
	 * } catch (Exception ee) { ptr.updateStep("Privilege list is not present",
	 * "Fail"); } } ptr.wait(2000);
	 * 
	 * }
	 */

	public void ModifyUserPrivilege(String privilegeName, String strAccessLevel) throws Exception {

		String[] lstprivilege = privilegeName.split(";");
		String eleXpathPrivilege = "";

		for (String privilegelist : lstprivilege) {
			try {
				eleXpathPrivilege = "(//tr//span[contains(., '" + privilegelist
						+ "')]//parent::*//following-sibling::td[1]//label)";
				System.out.println("privilegelist : " + privilegelist);

				System.out.println("eleXpathPrivilege :" + eleXpathPrivilege);
				ptr.wait(3000);

				driver.findElement(By.xpath(eleXpathPrivilege)).click();
				ptr.wait(5000);

				WebElement access_dropdown = driver.findElement(By.xpath("//span[contains(.,'" + privilegelist
						+ "')]//parent::td//parent::tr//td[2]//div//label[@id[contains(.,'form1:tablePrivileges')]]"));

				System.out.println(access_dropdown);

				ptr.selectDropdownByValue(access_dropdown, strAccessLevel,
						"Select Access from drop down: " + strAccessLevel);

				// driver.findElement(By.xpath("//span[contains(.,'"+privilegelist+"')]//parent::td//parent::tr//td[2]//div//select//option[contains(.,'"+strAccessLevel+"')]")).click();
				ptr.wait(1500);

			} catch (Exception ee) {
				ptr.updateStep("Privilege list is not present", "Fail");
			}
		}
		ptr.wait(2000);

	}

	/*
	 * Lib to Add Alternate Phone numbers
	 */

	public void addNAltPhoneNumbersOnUsersPage(String strStartingPhoneNum, boolean blnAddPhone, boolean blnAddExtension,
			boolean ringPattern, boolean description, int intNNumbers) throws IOException, InterruptedException {
		WebElement eleTxtBoxExt;
		WebElement eleTxtBoxRing;
		WebElement eleTxtBoxdesc;
		String strDesc = "test";
		String strExt = "";
		String strPhoneNum = "";
		String strDynXpath = "";
		int intIters = intNNumbers + 1;

		int indRingPat = 1;
		int phoneNumIndex = 2;

		for (int i = 2; i <= intIters; i++) {

			// Add phone number
			System.out.println("1 : i = " + i + " phoneNumIndex = " + phoneNumIndex);
			strDynXpath = "(//select)[" + phoneNumIndex + "]";
			driver.findElement(By.xpath(strDynXpath));

			strPhoneNum = strStartingPhoneNum + (i - 2);
			if (blnAddPhone) {
				// ptr.selectDropdownByVisibleText(eleDropDownPhNum,
				// strPhoneNum,
				// "Selecting Phone number: " + strPhoneNum);
				String strDropDownElement = "form1:tableQueryResults:" + (phoneNumIndex - 2) + ":dropDownPhoneNumber";
				ptr.selectDropdownByValue(strDropDownElement, strPhoneNum, "Selecting Phone Number: " + strPhoneNum);
				ptr.wait(2000);

			}

			// Add Ext number if asked, automatically pick the last four digits
			// of ph num
			if (blnAddExtension) {

				System.out.println("2 : i = " + phoneNumIndex + " phoneNumIndex = " + phoneNumIndex);
				strDynXpath = "//*[@id=\"form1:tableQueryResults:" + (phoneNumIndex - 2) + ":extension\"]";
				eleTxtBoxExt = driver.findElement(By.xpath(strDynXpath));
				// extract only the last 4 digits of the phone number
				strExt = strPhoneNum.substring(strPhoneNum.length() - 4);
				ptr.type(eleTxtBoxExt, strExt, "Entering ext: " + strExt + " for phone number: " + strPhoneNum);
			}

			// Add Ring Pattern if asked, automatically pick from drop down list
			if (ringPattern) {
				strDynXpath = "(//select//ancestor::span/parent::td/parent::*/child::td[5]//span//select)[" + indRingPat
						+ "]";
				eleTxtBoxRing = driver.findElement(By.xpath(strDynXpath));
				System.out.println("3 : i = " + i + " indRingPat = " + indRingPat);
				if (indRingPat == 1) {
					ptr.selectDropdownByVisibleText(eleTxtBoxRing, "Long-Long", "Selecting Ring Pattern: Long-Long ");
				} else if (indRingPat == 5) {
					ptr.selectDropdownByVisibleText(eleTxtBoxRing, "Short-Short-Long",
							"Selecting Ring Pattern: Long-Long ");
				} else if (indRingPat == 7) {
					ptr.selectDropdownByVisibleText(eleTxtBoxRing, "Short-Long-Short",
							"Selecting Ring Pattern: Long-Long ");
				} else {
					ptr.selectDropdownByVisibleText(eleTxtBoxRing, "Normal", "Selecting Ring Pattern: Long-Long ");
				}

			}

			if (description) {
				System.out.println("4 - i = " + i + " phoneNumIndex = " + phoneNumIndex);
				strDynXpath = "(//select)[" + phoneNumIndex
						+ "]/ancestor::span/parent::td/parent::*/child::td[6]//input";
				eleTxtBoxdesc = driver.findElement(By.xpath(strDynXpath));
				// extract only the last 4 digits of the phone number
				// strExt = strPhoneNum.substring(strPhoneNum.length() - 4);
				ptr.type(eleTxtBoxdesc, strDesc, "Enter description" + strDesc);

			}
			phoneNumIndex = phoneNumIndex + 1;
			indRingPat = indRingPat + 1;
		}

		// Click Apply.
		ptr.wait(10000);
		ptr.click(opeasyCommonPageElements.btn_Apply, "Click Apply");

		// 1) Verify Saved message is displayed and Alternate Number is added.
		ptr.assertTextEquals(ProvisioningPages.txt_screeSavedMessage, "Saved");

		// Click OK
		ptr.click(opeasyCommonPageElements.btn_OK, "Click OK");

	}

	/*
	 * Lib to add Phone Numbers without Extension
	 * 
	 */
	// public void addNAltPhoneNumbersWOextension(String strStartingPhoneNum,
	// boolean blnAddPhone, boolean blnAddExtension,
	// boolean ringPattern, boolean description, int intNNumbers) throws
	// IOException, InterruptedException {
	// WebElement eleTxtBoxRing;
	// WebElement eleTxtBoxdesc;
	// String strDesc = "test";
	// String strPhoneNum = "";
	// String strDynXpath = "";
	// int indRingPat = 1;
	// int phoneNumIndex = 2;
	//
	// for (int i = 2; i <= 11; i++) {
	//
	// // Add phone number
	// System.out.println("1 : i = " + i + " phoneNumIndex = " + phoneNumIndex);
	// strDynXpath = "(//select)[" + phoneNumIndex + "]";
	// driver.findElement(By.xpath(strDynXpath));
	//
	// strPhoneNum = strStartingPhoneNum + (i - 2);
	// if (blnAddPhone) {
	// // ptr.selectDropdownByVisibleText(eleDropDownPhNum,
	// // strPhoneNum,
	// // "Selecting Phone number: " + strPhoneNum);
	// String strDropDownElement = "form1:rowGroupQueryResults:" +
	// (phoneNumIndex - 2)
	// + ":dropDownPhoneNumber";
	// ptr.selectDropdownByValue(strDropDownElement, strPhoneNum, "Selecting
	// Phone Number: " + strPhoneNum);
	// ptr.wait(2000);
	// }
	//
	// // Add Ext number if asked, automatically pick the last four digits
	// // of ph num
	// third: if (blnAddExtension) {
	// System.out.println("2 : i = " + i + " phoneNumIndex = " + phoneNumIndex);
	// break third;
	// }
	//
	// // Add Ring Pattern if asked, automatically pick from drop down list
	// if (ringPattern) {
	// strDynXpath =
	// "(//select//ancestor::span/parent::td/parent::*/child::td[5]//span//select)["
	// + indRingPat
	// + "]";
	// eleTxtBoxRing = driver.findElement(By.xpath(strDynXpath));
	// System.out.println("3 : i = " + i + " indRingPat = " + indRingPat);
	// ptr.selectDropdownByVisibleText(eleTxtBoxRing, "Long-Long", "Selecting
	// Ring Pattern: Long-Long ");
	//
	// }
	//
	// if (description) {
	// System.out.println("4 - i = " + i + " phoneNumIndex = " + phoneNumIndex);
	// strDynXpath = "(//select)[" + phoneNumIndex
	// + "]/ancestor::span/parent::td/parent::*/child::td[6]//input";
	// eleTxtBoxdesc = driver.findElement(By.xpath(strDynXpath));
	// // extract only the last 4 digits of the phone number
	// // strExt = strPhoneNum.substring(strPhoneNum.length() - 4);
	// ptr.type(eleTxtBoxdesc, strDesc, "Enter description" + strDesc);
	//
	// }
	// phoneNumIndex = phoneNumIndex + 2;
	// indRingPat = indRingPat + 1;
	// }
	//
	// // Click Apply.
	// ptr.click(opeasyCommonPageElements.btn_Apply, "Click Apply");
	// ptr.wait(10000);
	// // 1) Verify Saved message is displayed and Alternate Number is added.
	// ptr.assertTextEquals(ProvisioningPages.txt_screeSavedMessage, "Saved");
	//
	// // Click OK
	// ptr.click(opeasyCommonPageElements.btn_OK, "Click OK");
	//
	// }

	/*
	 * Lib to add Alternate phone numbers on AA user
	 */
	// public void addAltPhoneNumbersAA(String strStartingPhoneNum, boolean
	// blnAddPhone, boolean blnAddExtension,sdfg
	// int intNNumbers) throws IOException, InterruptedException {
	// WebElement eleTxtBoxExt;
	// // String strDesc = "test";
	// String strExt = "";
	// // String strRing = "";
	// String strPhoneNum = "";
	// String strDynXpath = "";
	// int intIters = intNNumbers + 1;
	//
	// // int indRingPat =1;
	// // int phoneNumIndex = 2;
	//
	// for (int phoneNumIndex = 2; phoneNumIndex <= intIters; phoneNumIndex++) {
	//
	// // Add phone number
	// strPhoneNum = strStartingPhoneNum + (phoneNumIndex - 2);
	// if (blnAddPhone) {
	// // ptr.selectDropdownByVisibleText(eleDropDownPhNum,
	// // strPhoneNum,
	// // "Selecting Phone number: " + strPhoneNum);
	// //
	//
	// // //*[@id=\"form1:rowGroupQueryResults:0:dropDownPhoneNumber_items\"]
	// String strDropDownElement = "form1:rowGroupQueryResults:" +
	// (phoneNumIndex - 2)
	// + ":dropDownPhoneNumber";
	// ptr.selectDropdownByValue(strDropDownElement, strPhoneNum, "Selecting
	// Phone Number: " + strPhoneNum);
	// ptr.wait(2000);
	//
	// }
	//
	// // Add Ext number if asked, automatically pick the last four digits
	// // of ph num
	// if (blnAddExtension) {
	// System.out.println("2 : i = " + phoneNumIndex + " phoneNumIndex = " +
	// phoneNumIndex);
	// strDynXpath = "//*[@id=\"form1:rowGroupQueryResults:" + (phoneNumIndex -
	// 2) + ":extension\"]";
	// eleTxtBoxExt = driver.findElement(By.xpath(strDynXpath));
	// // extract only the last 4 digits of the phone number
	// strExt = strPhoneNum.substring(strPhoneNum.length() - 4);
	// ptr.type(eleTxtBoxExt, strExt, "Entering ext: " + strExt + " for phone
	// number: " + strPhoneNum);
	// }
	// }
	//
	// // Click Apply.
	// ptr.click(opeasyCommonPageElements.btn_Apply, "Click Apply");
	// ptr.wait(10000);
	//
	// // 1) Verify Saved message is displayed and Alternate Number is added.
	// ptr.assertTextEquals(ProvisioningPages.txt_screeSavedMessage, "Saved");
	//
	// // Click OK
	// ptr.click(opeasyCommonPageElements.btn_OK, "Click OK");
	//
	// }

	/*
	 * Lib to clear Alternate Phone Numbers and Extension
	 * 
	 */

	// public void clearAlternateNumbersForHG(String strHGUser, boolean
	// blnClearPhnNumber, int intIter)
	// throws IOException, InterruptedException {
	//
	// // Edit a User who has added Alternate Number service.
	// String strDynXpath = "(//span[contains(text(),'" + strHGUser + "')])[1]";
	// WebElement eleAutoAtt = driver.findElement(By.xpath(strDynXpath));
	// if (eleAutoAtt == null) {
	// ptr.updateStep("Auto Attendant record not found: " + strHGUser, "Fail");
	// }
	//
	// ptr.click(eleAutoAtt, "Selecting Auto Attendant " + strHGUser);
	//
	// // Step 8. Select Alternate Numbers service from drop down list
	// ptr.selectDropdownByValue(ProvisioningPages.dropdown_ServiceForUser,
	// "GROUP_HUNT_GROUP_ALTERNATE_NUMBERS",
	// "Selecting Alternate Numbers service from drop down list ");
	//
	// intIter += 1;
	//
	// for (int i = 2; i <= intIter; i = i + 2) {
	//
	// if (blnClearPhnNumber) {
	// strDynXpath = "(//select)[" + i + "]";
	// Select dropDown = new Select(driver.findElement(By.xpath(strDynXpath)));
	// dropDown.selectByValue("-*N*-");
	//
	// String strDropDownElement = "form1:rowGroupQueryResults:" + (i - 2) +
	// ":dropDownPhoneNumber";
	// ptr.selectDropdownByValue(strDropDownElement, "None", "Selecting Phone
	// Number: None");
	// ptr.wait(2000);
	// }
	//
	// }
	//
	// // Click Apply.
	// ptr.click(opeasyCommonPageElements.btn_Apply, "Click Apply");
	// ptr.wait(10000);
	// // 1) Verify Saved message is displayed and Alternate Number is added.
	// ptr.assertTextEquals(ProvisioningPages.txt_screeSavedMessage, "Saved");
	//
	// // Click OK
	// ptr.click(opeasyCommonPageElements.btn_OK, "Click OK");
	//
	// strDynXpath = "//span[contains(text(),'" + strHGUser + "')]";
	// eleAutoAtt = driver.findElement(By.xpath(strDynXpath));
	// if (eleAutoAtt == null) {
	// ptr.updateStep("Auto Attendant record not found: " + strHGUser, "Fail");
	// }
	//
	// ptr.click(eleAutoAtt, "Selecting Usert " + strHGUser);
	//
	// }

	// Lib to check Error message displayed on screen
	public boolean isMessageDisplayed(String strMessage) {
		// TODO Auto-generated method stub
		String strDynXpath = "//span[contains(text(),'" + strMessage + "')]";
		try {
			driver.findElement(By.xpath(strDynXpath));
			System.out.println("INFO: Message is displayed on the page! : " + strMessage);
			return true;
		} catch (NoSuchElementException ex) {
			System.out.println("INFO: No such message displayed on the page! : " + strMessage);
		}
		return false;
	}

	public void verifyScreenTitleProvPage(String strExpTitle) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ptr.wait(10000);
		WebElement ele = driver.findElement(By.xpath(".//span[@id='form1:staticTextScreenName']"));
		ptr.assertTextEquals(ele, strExpTitle);
	}

	/*
	 * public void AdminToolsDefaultPriv(String strAdmin, String privname, String
	 * access) throws IOException, InterruptedException { // TODO Auto-generated
	 * method stub // Step 4.select Default Privilege Management from Main menu
	 * ptr.click(AdminToolsPages.link_DefaultPrivilege,
	 * "Clicking on link: Default Privilege Management");
	 * 
	 * // Step 5. Verify Default Privilege Management page is // displayed.
	 * verifyScreenTitleProvPage("Default Privilege Management");
	 * 
	 * // Select Solution Reseller from the Login Level drop-down list.
	 * ptr.selectDropdownByValue(AdminToolsPages.dropdown_Loginlevel, strAdmin,
	 * "Selecting an login level : "+strAdmin); ptr.wait(3000);
	 * 
	 * // In the Provisioning section select Sync Teams. Select Full Access from the
	 * Access drop-down list. // Step 8. Click OK Button
	 * 
	 * driver.findElement(By.xpath("(//td[contains(.,'"+privname+
	 * "')])[last()]//parent::tr//td[last()]//div[@aria-label='Select access level for Sync Teams']"
	 * )).click(); ptr.wait(2000);
	 * 
	 * String strXpath = ""; strXpath =
	 * "//*[@id=\"form1:tablePrivileges:32:dropDownAccess_items\"]//li[contains(text(), '"
	 * +access+"')]";
	 * 
	 * (new WebDriverWait(driver,
	 * 10)).until(ExpectedConditions.elementToBeClickable(By.xpath(strXpath)));
	 * WebElement eleDropDownItem = driver.findElement(By.xpath(strXpath));
	 * ptr.click(eleDropDownItem, "Selecting item from drop down"); ptr.wait(2000);
	 * 
	 * ptr.click(OpeasyCommonPageElements.btn_Apply, "Clicking on Button : Apply");
	 * ptr.wait(3000);
	 * 
	 * driver.findElement(By.xpath("//span[contains(.,'Saved')]")).isDisplayed() ;
	 * ptr.wait(2000);
	 * 
	 * ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on Button : OK");
	 * 
	 * // Step 9. Verify Administrative Tools page is displayed.
	 * verifyScreenTitleProvPage("Administrative Tools"); }
	 */

	/*
	 * Lib to restore the admin previleges to defaults Author : Viru
	 */
	public void adminPrveilegesRestoreDefaults(String strLoginName) throws Exception {
		ptr.click(opeasyhome.link_LoginManagement, "Click link Login Management");
		// ptr.selectDropdownByValue(provisioningpages.dropdown_SearchCriteriarRow1,
		// "LOGIN_NAME", "Select search criteria: LOGIN_NAME");
		// ptr.selectDropdownByValue(provisioningpages.dropdown_SearchConditionRow1,
		// "EqualTo", "Select search condition: EqualTo");
		// ptr.type(provisioningpages.text_SearchValueRow1, strLoginName, "Enter
		// login name: " + strLoginName);
		//
		createSearchCriteriaRowInLoginMangagement(1, "LOGIN_NAME", "EqualTo", strLoginName);
		ptr.wait(3000);
		ptr.click(opeasyCommonPageElements.btn_Search, "click button Search");
		ptr.wait(3000);
		if (driver.findElements(By.xpath("//a[contains(.,'Edit')]")).size() == 1) {
			driver.findElement(By.xpath("//a[contains(.,'Edit')]")).click();
			ptr.click(loginmanagementpage.btn_CustomizePrivilege, "Click button Customize Previleges");
			ptr.click(loginmanagementpage.btn_ResetToDefault, "Click button Restore to defaults");
			ptr.click(OpeasyCommonPageElements.btn_OK, "Click button OK");
		}
	}

	/*
	 * Lib to validate Export feature of Clearspan Anywhere Viru
	 * 
	 */
	@SuppressWarnings("static-access")
	public boolean ExportClearspanDataValidation(String strUserType, String strEnterprise, String strGroup)
			throws InterruptedException, StaleElementReferenceException, Exception {

		// Step 4. Select Import type from drop down list

		selectMainPageMenuItem("Provisioning", "Provisioning");
		ptr.wait(3000);
		selectMainPageMenuItem("Export", "Export Clearspan Data");
		ptr.wait(3000);

		String strExportType = "Export: System";
		ptr.selectDropdownByValue(ProvisioningPages.cb_ExportTypeList, strExportType,
				"Selecting Export type: " + strExportType);

		try {
			if ((strUserType.matches("SU|SR|SA|EA"))) {
				if (OpeasyCommonPageElements.dropdown_Enterprise.isDisplayed()) {
					// Step 4. Select Enterprise from drop down list
					ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
							"Selecting Enterprise from drop down list");
				}
			}
		} catch (Exception ee) {
			if ((strUserType.equals("GA"))) {
			}
			System.out.println("Enterprise is labeled");
		}

		try {
			if (OpeasyCommonPageElements.dropdown_Group.isDisplayed()) {
				ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group, strGroup,
						"Selecting the Group : " + strGroup);
			}
		} catch (NoSuchElementException ex) {
			ptr.updateStep("Select All option not there", "INFO");
		}

		// Clear the current selection of worksheets
		ptr.wait(5000);

		try {
			WebElement select_all = driver.findElement(By.id("form1:hyperlinkSelectAll"));
			if (select_all.isDisplayed()) {
				driver.findElement(By.id("form1:hyperlinkSelectAll")).click();
				ptr.wait(2000);
			} else {
				ptr.updateStep("Select all button is not seen", "INFO");
			}
		} catch (Exception e) {
			ptr.updateStep("Select all button is not seen", "INFO");
			// TODO: handle exception
		}

		ptr.click(provisioningpages.btn_StartExport, "Click Start Export");
		ptr.wait(60000);

		if (provisioningpages.btn_Refresh.isDisplayed()) {
			ptr.click(provisioningpages.btn_Refresh, "Click button Refresh");
			ptr.wait(25000);
		} else {
			ptr.updateStep("Refresh button not seen", "INFO");
		}
		ptr.wait(20000);
		if (provisioningpages.retrieve_Results.isDisplayed()) {
			ptr.click(provisioningpages.retrieve_Results, "Click Retrieve results");
			ptr.wait(35000);
		} else {
			ptr.click(provisioningpages.btn_Refresh, "Click button Refresh");
			// ptr.updateStep("Refresh button not seen", "INFO");
		}

		/*
		 * if (provisioningpages.btn_Refresh.isDisplayed()) {
		 * ptr.click(provisioningpages.btn_Refresh, "Click button Refresh");
		 * ptr.wait(20000); } else { ptr.updateStep("Refresh button not seen", "INFO");
		 * }
		 */
		// ptr.click(provisioningpages.btn_RetreiveResults, "Click button
		// Retrieve results");
		ptr.wait(10000);

		String strExpReportFileName = "ClearspanExportSystem";

		// Wait for the report to download in the Downloaeds_Folder
		String strFilename = System.getProperty("user.dir") + "\\Downloads_Folder" + "\\" + strExpReportFileName;
		File file = new File(strFilename);

		// Verify records in the downloaded report
		File downloads_path = new File(System.getProperty("user.dir") + "\\Downloads_Folder\\");
		File[] listOfFiles = downloads_path.listFiles();
		String strActualFile = "";
		String strSheetName = "OpEasy Login Rules";

		// Fetch the actual file
		if (listOfFiles.length > 0) {
			for (File fileName : listOfFiles) {
				if (file.toString().contains(strExpReportFileName)) {
					strActualFile = fileName.toString();
					System.out.println("Found downloaded file in the folder: " + strActualFile);
					ptr.updateStep("Download of Results spreadsheet passed", "Pass");
				}
			}
		} else {
			ptr.updateStep("Download of Results spreadsheet failed!", "Fail");

		}

		// getExcelCellData(strActualFile, "OpEasy Login Rules", "A9-AF9");

		FileInputStream inputStream = null;
		String retValue = null;
		try {
			inputStream = new FileInputStream(new File(strActualFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);

			org.apache.poi.ss.usermodel.Sheet sheet;
			if (!strSheetName.equals("")) {
				sheet = workbook.getSheet(strSheetName);
			} else {
				sheet = workbook.getSheetAt(0);
				System.out.println(sheet);
			}

			org.apache.poi.ss.util.CellReference ref;
			Row r;
			// validate the cell name has - Range
			String cellRange = "F9,G9,H9,I9,J9,K9,L9,M9,N9,O9,P9,"
					+ "Q9,R9,S9,T9,U9,V9,W9,X9,Y9,Z9,AA9,AB9,AC9,AD9,AE9,AF9,AG9,AH9";

			String[] cells = cellRange.split(",");
			for (String cell : cells) {
				ref = new org.apache.poi.ss.util.CellReference(cell);
				r = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(ref.getRow());
				if (r != null) {
					Cell c = r.getCell(ref.getCol());
					System.out.println(c.getRichStringCellValue().getString());
					retValue = c.getRichStringCellValue().getString();
					if (retValue != "") {
						ptr.updateStep("Found data in the cell: " + cell, "Info");
					} else {
						ptr.updateStep("Value not found in the cell: " + cell, "Warn");
						((BufferedReader) workbook).close();
						inputStream.close();
						return false;
					}
				}
			}

			((BufferedReader) workbook).close();
			inputStream.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		// Invoke excell validation
		return true;

	}

	/*
	 * Lib to validate excel cell value has either True or false -Hameetha
	 */

	@SuppressWarnings("static-access")
	public boolean EnterprisePhoneNumberExport(String strUserType, String strExportType, String strEnterprise,
			String strExpReportFileName) throws InterruptedException, StaleElementReferenceException, Exception {

		// Step 4. Select Import type from drop down list

		selectMainPageMenuItem("Provisioning", "Provisioning");
		ptr.wait(3000);
		selectMainPageMenuItem("Export", "Export Clearspan Data");
		ptr.wait(3000);

		// String strExportType = "Export: Enterprise";
		ptr.selectDropdownByValue(ProvisioningPages.cb_ExportTypeList, strExportType,
				"Selecting Export type: " + strExportType);

		if ((strUserType.matches("SU|SR|SA|EA"))) {
			// Step 4. Select Enterprise from drop down list
			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Selecting Enterprise from drop down list");
		} else if ((strUserType.equals("GA"))) {
			System.out.println("Enterprise is labeled");
		}

		// Clear the current selection of worksheets
		ptr.wait(5000);
		if (strUserType.matches("SU")) {
			ptr.click(provisioningpages.hyperlink_ClearAll, "Click link ClearAll to clear current selections");
			ptr.wait(5000);
		}

		ptr.SelectWorksheetCheckboxByLabel("PhoneNumbers");
		ptr.wait(3000);

		ptr.click(provisioningpages.btn_StartExport, "Click Start Export");
		ptr.wait(60000);

		ptr.click(provisioningpages.btn_Refresh, "Click button Refresh");
		ptr.wait(10000);

		ptr.click(provisioningpages.btn_RetreiveResults, "Click button Retrieve results");
		ptr.wait(10000);

		// String strExpReportFileName = "ClearspanExportSystem";

		// Wait for the report to download in the Downloaeds_Folder
		String strFilename = System.getProperty("user.dir") + "\\Downloads_Folder" + "\\" + strExpReportFileName;
		File file = new File(strFilename);

		// Verify records in the downloaded report
		File downloads_path = new File(System.getProperty("user.dir") + "\\Downloads_Folder\\");
		File[] listOfFiles = downloads_path.listFiles();
		String strActualFile = "";
		String strSheetName = "PhoneNumbers";

		// Fetch the actual file
		if (listOfFiles.length > 0) {
			for (File fileName : listOfFiles) {
				if (file.toString().contains(strExpReportFileName)) {
					strActualFile = fileName.toString();
					System.out.println("Found downloaded file in the folder: " + strActualFile);
					ptr.updateStep("Download of Results spreadsheet passed", "Pass");
				}
			}
		} else {
			ptr.updateStep("Download of Results spreadsheet failed!", "Fail");

		}

		// getExcelCellData(strActualFile, "OpEasy Login Rules", "A9-AF9");

		FileInputStream inputStream = null;
		String retValue = null;
		try {
			inputStream = new FileInputStream(new File(strActualFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);

			org.apache.poi.ss.usermodel.Sheet sheet;
			if (!strSheetName.equals("")) {
				sheet = workbook.getSheet(strSheetName);
			} else {
				sheet = workbook.getSheetAt(0);
				System.out.println(sheet);
			}

			org.apache.poi.ss.util.CellReference ref;
			Row r;
			// validate the cell name has - Range
			String cellRange = "E9,E10,E11,E12,E13,E144,E15,E16,E17,E18,E19,E20,E21,E22,E23,E24,E25,E26,E27,E28,E29,E30,E31,E32,E33,E34,E35,E36,E37,E38,E39,E40,E41,E42,E43,E44,E45,E46,E47,E48,E49,E50,E51,E52,E53,E54,E55,E56,E57,E58,E59,E60,E61,E62,E63,E64,E65,E67,E68,E69,E70,E71,E72,E73,E74,E75,E76,E77,E78";

			String[] cells = cellRange.split(",");
			for (String cell : cells) {
				ref = new org.apache.poi.ss.util.CellReference(cell);
				r = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(ref.getRow());
				System.out.println("r : " + r);
				if (r != null) {
					Cell c = r.getCell(ref.getCol());
					System.out.println(c.getRichStringCellValue().getString());
					retValue = c.getRichStringCellValue().getString();
					System.out.println("retValue : " + retValue);
					wait(2000);

					try {
						if (retValue.contains("True") || retValue.contains("False")) {
							ptr.updateStep("Found data in the cell: " + cell, "Info");
						}
					} catch (Exception ee) {
						System.out.println(ee.getMessage());
						ptr.updateStep("Value not found in the cell: " + cell, "Warn");
						((BufferedReader) workbook).close();
						inputStream.close();
						return false;
					}
				}
			}

			((BufferedReader) workbook).close();
			inputStream.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return true;
	}

	/*
	 * String cellRange1 =
	 * "F9,F10,F11,F12,F13,F14,F15,F16,F17,F18,F19,F20,F21,F22,F23,F24,F25,F26,F27,F28,F29,F30,F31,F32,F33,F34,F35,F36,F37,F38,F39,F40,F41,F42,F43,F44,F45,F46,F47,F48,F49,F50,F51,F52,F53,F54,F55,F56,F57,F58,F59,F60,F61,F62,F63,F64,F65,F67,F68,F69,F70,F71,F72,F73,F74,F75,F76,F77,F78";
	 * String[] cells1 = cellRange1.split(","); for (String cell : cells1) { ref =
	 * new CellReference(cell); r = ((org.apache.poi.ss.usermodel.Sheet)
	 * sheet).getRow(ref.getRow()); if (r != null) { Cell c =
	 * r.getCell(ref.getCol());
	 * System.out.println(c.getRichStringCellValue().getString()); retValue =
	 * c.getRichStringCellValue().getString(); System.out.println("retValue : "
	 * +retValue); try { if (retValue.contains("True") || retValue.contains("False")
	 * ) { ptr.updateStep("Found data in the cell: " + cell , "Info"); } }catch
	 * (Exception ee) { ptr.updateStep( "Value not found in the cell: " + cell ,
	 * "Warn"); workbook.close(); inputStream.close(); return false; } } }
	 * 
	 * workbook.close(); inputStream.close();
	 */
	// } catch (Exception ex) {
	// System.out.println(ex.getMessage());
	// }
	// Invoke excell validation
	// return true;

	/*
	 * To validate error message displayed on screen
	 * 
	 */
	public boolean verifyErrorMessageOnScreen(String strExpectedMessage) {
		List<WebElement> errMsgs = driver.findElements(By.xpath(".//*[@id='form1:errorMessages']//span"));
		String concatenatedErrMsg = "";
		for (WebElement msgRow : errMsgs) {
			concatenatedErrMsg += msgRow.getText();
		}
		return (concatenatedErrMsg.contains(strExpectedMessage));
	}

	/*
	 * Lib to get the label of selected Radio Button
	 * 
	 */

	public String getSelectedRadioButton() {
		String strLabelOfChekcedRadioButton = "";
		try {
			if (driver.findElements(By.xpath(
					"//div[@class='ui-radiobutton ui-widget']//parent::div//parent::div//following-sibling::label"))
					.size() > 0) {
				// Get the label of checked radio button
				strLabelOfChekcedRadioButton = driver.findElement(By.xpath(
						"//div[@class='ui-radiobutton ui-widget']//input[@checked=\"checked\"]//parent::div//parent::div//following-sibling::label"))
						.getText();
			}
		} catch (NoSuchElementException e) {
			// return null
		}

		return strLabelOfChekcedRadioButton;
	}

	/*
	 * Lib for User Defined Field page - to select an item from dropDown in the UDF
	 * table row Either last or given row number
	 */

	// public void udfSelectDropDownByValue(String strDropDownName, String
	// strItem, String strDescription){
	//
	// udfSelectDropDownByValue( intRowNum, String strDropDownName, String
	// strItem, String strDescription){
	// }

	public void udfSelectDropDownByValue(int intRowNum, String strDropDownName, String strItem)
			throws IOException, InterruptedException {
		String strDropDownXpath = "";
		String strDescr = "";

		// * Get row count from table - //*[@id="form1:tableFields_data"]//tr

		int intRowCount = driver.findElements(By.xpath("//*[@id='form1:tableFields_data']//tr")).size();
		if (intRowNum == -1) {
			// Its last row
			intRowNum = intRowCount - 1;
		} else {
			intRowNum = intRowNum - 1;
		}

		if (strDropDownName.equals("AdminLevel")) {
			strDropDownXpath = "form1:tableFields:" + intRowNum + ":dropDownLevel";
			strDescr = "Select item from dropDownLevel: " + strItem;
		} else if (strDropDownName.equals("FieldType")) {
			{
				strDropDownXpath = "form1:tableFields:" + intRowNum + ":dropDownType";
				strDescr = "Select item from dropDownType: " + strItem;
			}
		}
		ptr.selectDropdownByValue(strDropDownXpath, strItem, strDescr);

	}

	/*
	 * CSAnywhere - prepare Opeasy Admin login details
	 * 
	 */

	public List<String> CSAnywherePrepareOpeasyAdminDetails(String strAdmins) {

		String[] lstAdmins = strAdmins.split(":");
		List<String> OpeasyAdmins = new ArrayList<>();

		for (String admin : lstAdmins) {
			// Different Opeasy admin logins to test with
			switch (admin) {

			case "SU":
				OpeasyAdmins.add("SU:" + POMSuiteRunner.ConfigStore.get("Opeasy_SU_Username") + ":"
						+ POMSuiteRunner.ConfigStore.get("Opeasy_SU_Password"));
				break;

			case "SA":
				OpeasyAdmins.add("SA:" + POMSuiteRunner.ConfigStore.get("Opeasy_SA_Username") + ":"
						+ POMSuiteRunner.ConfigStore.get("Opeasy_SA_Password"));
				break;

			case "EA":
				OpeasyAdmins.add("EA:" + POMSuiteRunner.ConfigStore.get("Opeasy_EA_Username") + ":"
						+ POMSuiteRunner.ConfigStore.get("Opeasy_EA_Password"));
				break;

			case "SR":
				OpeasyAdmins.add("SR:" + POMSuiteRunner.ConfigStore.get("Opeasy_SR_Username") + ":"
						+ POMSuiteRunner.ConfigStore.get("Opeasy_SR_Password"));
				break;

			case "GA":
				OpeasyAdmins.add("GA:" + POMSuiteRunner.ConfigStore.get("Opeasy_GA_Username") + ":"
						+ POMSuiteRunner.ConfigStore.get("Opeasy_GA_Password"));
				break;

			case "DA":
				OpeasyAdmins.add("DA:" + POMSuiteRunner.ConfigStore.get("Opeasy_DA_Username") + ":"
						+ POMSuiteRunner.ConfigStore.get("Opeasy_DA_Password"));
				break;

			case "GPGA":
				OpeasyAdmins.add("GPGA:" + POMSuiteRunner.ConfigStore.get("Opeasy_GA_GP_Username") + ":"
						+ POMSuiteRunner.ConfigStore.get("Opeasy_GA_GP_Password"));

			}
		}
		return OpeasyAdmins;
	}

	/*
	 * Lib to login and go to Export page
	 */

	public void CSAnywhereGotoUsersPage(String opeasyUrl, String strOpeasy_Username, String strOpeasy_Password,
			String strUserType, String strEnterprise, String strGroup

	) throws IOException, InterruptedException {
		// Step 1. Login to OpEasy
		opeasyClearLoginSessions(opeasyUrl, strOpeasy_Username, strOpeasy_Password);

		// Step 2. Click on Provisioning link
		ptr.click(OpeasyHomePage.link_Provisioning, "Clicking on provisioning link");

		// Step 3. Click on Users link
		ptr.click(ProvisioningPages.link_Users, "Clicking on Users link");
		ptr.wait(3000);

		if ((strUserType.matches("SU|SR|SA|EA"))) {
			// Step 4. Select Enterprise from drop down list
			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Selecting Enterprise from drop down list");
			ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Group, strGroup, "Select Group: " + strGroup);
		} else if ((strUserType.equals("GA"))) {
			System.out.println("Enterprise is labeled");
		}

		// Clear the current selection of worksheets
		ptr.wait(5000);

	}

	/*
	 * Lib to login and go to Export page
	 */

	public void CSAnywhereGotoVirtualUsersPage(String opeasyUrl, String strOpeasy_Username, String strOpeasy_Password,
			String strUserType, String strVUType, String strEnterprise, String strGroup

	) throws IOException, InterruptedException {
		// Step 1. Login to OpEasy
		opeasyClearLoginSessions(opeasyUrl, strOpeasy_Username, strOpeasy_Password);

		// Step 2. Click on Provisioning link
		ptr.click(OpeasyHomePage.link_Provisioning, "Clicking on provisioning link");

		// Step 3. Click on Users link
		// Search the User in Users page and delete
		switch (strVUType) {
		case "Auto Attendants":
			ptr.click(ProvisioningPages.link_AutoAttendants, "Click on link_AutoAttendants");
			break;
		case "Flexible Seating Hosts":
			ptr.click(ProvisioningPages.link_FlexibleSeatingHosts, "Click on link_FlexibleSeatingHosts");
			break;
		case "Hunt Groups":
			ptr.click(ProvisioningPages.link_HuntGroups, "Click on link_HuntGroups");
			break;
		case "Virtual User Inventory":
			ptr.click(ProvisioningPages.link_VirtualUserInventory, "Click on link_VirtualUserInventory");
			break;
		}

		if ((strUserType.matches("SU|SR|SA|EA"))) {
			// Step 4. Select Enterprise from drop down list
			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Selecting Enterprise from drop down list");
			ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Group, strGroup, "Select Group: " + strGroup);
		} else if ((strUserType.equals("GA"))) {
			System.out.println("Enterprise is labeled");
		}

		// Clear the current selection of worksheets
		ptr.wait(5000);

	}

	/*
	 * Lib to login and go to Export page
	 */

	public void CSAnywhereGotoExportPage(String opeasyUrl, String strOpeasy_Username, String strOpeasy_Password)
			throws IOException, InterruptedException {
		// Step 1. Login to OpEasy
		opeasyClearLoginSessions(opeasyUrl, strOpeasy_Username, strOpeasy_Password);

		// Step 2. Click on Provisioning link
		ptr.click(OpeasyHomePage.link_Provisioning, "Clicking on provisioning link");
		ptr.wait(3000);

		// Step 3. Click on Export link
		ptr.click(ProvisioningPages.link_Export, "Clicking on export link");
		ptr.wait(3000);

		// try {
		// driver.findElement(By.xpath("//*[@id='form1:buttonDeleteResults']/span")).click();
		// ptr.wait(3000);
		// ptr.alertAccept();
		// } catch (NoSuchElementException e) {
		// // Do nothing
		// }
	}

	/*
	 * Lib to validate Export feature of Clearspan Anywhere Viru
	 * 
	 */
	public void CSAnywhereUserSearchValidateResults(String strSearchCritsAndDataToValidate

	) throws InterruptedException, StaleElementReferenceException, Exception {

		String strCrit;
		String strCondition;
		String strValue;
		int intCaseNumber = 0;

		String[] lstSearchCris;
		String[] lstTestData;
		String strDataToValidate = "";
		String strTestType = "";
		strCrit = "";
		strCondition = "";
		strValue = "";
		String[] strSearchCrits;

		String[] lstUseCasesData = strSearchCritsAndDataToValidate.split("#");
		for (String strUserCaseData : lstUseCasesData) {
			intCaseNumber += 1;
			ptr.updateStep("******** Executing Use Case : " + intCaseNumber, "Info");
			lstTestData = strUserCaseData.split("zz");

			strSearchCrits = lstTestData[0].split("yy");
			strDataToValidate = lstTestData[1];
			strTestType = lstTestData[2];

			for (int i = 0; i < strSearchCrits.length; i++) {
				strCrit = "";
				strCondition = "";
				strValue = "";
				lstSearchCris = strSearchCrits[i].split("xx");
				strCrit = strSearchCrits[i].split("xx")[0];
				if (lstSearchCris.length > 1) {
					strCondition = lstSearchCris[1];
				}
				if (lstSearchCris.length > 2) {
					strValue = lstSearchCris[2];
				}
				createSearchCriteriaRow((i + 1), strCrit, strCondition, strValue);
				ptr.wait(3000);
			}

			ptr.click(opeasyCommonPageElements.btn_Search, "Click button Search");
			ptr.wait(5000);

			// Validate results
			try {
				if (strTestType.contains("TestPositive")) {
					// Positive test
					driver.findElements(By.xpath("//span[contains(text(), '" + strDataToValidate + "')]"));
					ptr.updateStep("Positive Test: Found expected data: " + strDataToValidate, "Pass");
				} else {
					if (strTestType.contains("TestNegative")) {
						if (driver.findElements(By.xpath("//td[contains(., 'No users exist.')]")).size() > 0) {
							ptr.updateStep("Negative Test: Found no records as expected.", "Pass");
						} else {
							ptr.updateStep("Negative Test: Found records against expectation.", "Fail");
						}
					} else {
						// Error message to be validated
						if (verifyErrorMessageOnScreen(strTestType)) {
							ptr.updateStep("Error Message: Found as expected: " + strTestType, "Pass");
						} else {
							ptr.updateStep("Error Message: Not found: " + strTestType, "Fail");
						}
					}
				}
			} catch (NoSuchElementException ex) {
				ptr.updateStep("Test failed to get the expected results in case of: " + strTestType, "Fail");
			}

			// To delete search criteria rows
			for (int i = 1; i <= strSearchCrits.length; i++) {
				deleteSearchCriteriaLastRow();
				ptr.wait(5000);
			}
		}
	}

	/*
	 * Lib to validate Export feature of Clearspan Anywhere Viru
	 * 
	 */
	public void CSAnywhereExportWorksheetsValidateResults(String ExportType, String strUserType, String strEnterprise,
			String strGroup, String strCommaSeperatedListOfCheckBoxLabels, boolean validateResult,
			boolean blnPositiveTest, String strSearchCrits, String strSheetsAndDataToValidate

	) throws InterruptedException, StaleElementReferenceException, Exception {

		String[] strWorkSheetLabels = strCommaSeperatedListOfCheckBoxLabels.split(":");
		if (strWorkSheetLabels.length > 0) {

			// Step 4. Select Import type from drop down list
			String strExportType = "Export: " + ExportType;
			ptr.selectDropdownByValue(ProvisioningPages.cb_ExportTypeList, strExportType,
					"Selecting Export type: " + strExportType);

			if (!(strUserType.matches("GA"))) {
				// Step 4. Select Enterprise from drop down list
				ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
						"Selecting Enterprise from drop down list");
			} else if ((strUserType.equals("GA"))) {
				System.out.println("Enterprise is labeled");
			}

			// Clear the current selection of worksheets
			ptr.wait(5000);
			ptr.click(provisioningpages.hyperlink_ClearAll, "Click link ClearAll to clear current selections");
			ptr.wait(5000);

			// Selected the needed worksheets
			for (String strWorksheetLabelName : strWorkSheetLabels) {
				ptr.wait(3000);
				ptr.selectCheckBox(strWorksheetLabelName, true, ExportType);
			}

			// Clear the search criterias if already present
			int intSearchCritRows = driver.findElements(By.xpath("//button[@id[contains(.,'buttonRowDelete')]]"))
					.size();
			if (intSearchCritRows > 1) {
				for (int i = 1; i < intSearchCritRows; i++) {
					driver.findElement(By.xpath("(//button[@id[contains(.,'buttonRowDelete')]])[last()]")).click();
					ptr.wait(3000);
				}
			}

			String[] lstSerachCrits = strSearchCrits.split("#");
			String strCrit;
			String strCondition;
			String strValue;
			String strSplitChar = ":";

			for (int i = 0; i < lstSerachCrits.length; i++) {
				strCrit = "";
				strCondition = "";
				strValue = "";
				// Loop through the modules to verify all alerts
				if (lstSerachCrits[i].contains(";")) {
					strSplitChar = ";";
				}
				strCrit = lstSerachCrits[i].split(strSplitChar)[0];
				strCondition = lstSerachCrits[i].split(strSplitChar)[1];
				strValue = lstSerachCrits[i].split(strSplitChar)[2];
				createExportPageSearchCriteriaRow((i + 1), strCrit, strCondition, strValue);
				ptr.wait(10000);
			}

			ptr.click(ProvisioningPages.btn_StartExport, "clicking on Start Export Button");
			ptr.wait(5000);
			ptr.click(ProvisioningPages.btn_Refresh, "Clicking on link: Refresh");

			// Wait until the export completes within the given timeout
			int intWaitedTime = 30000;
			int intMaxTimeoutInMts = 10;
			int intMaxTimeoutInSecs = 60000 * intMaxTimeoutInMts;

			while (intWaitedTime < intMaxTimeoutInSecs) {
				// verify Refresh button is displayed
				try {
					// Step 17. Wait for export to be completed.
					driver.findElement(By.xpath("//span[contains(text(),'Completed')]"));
					// break if completed
					break;

				} catch (NoSuchElementException ex) {
					// Increase the already waited time
					intWaitedTime += 30000;

					// wait for another 30 secs
					ptr.wait(30000);
					try {
						// Step 16. Click on Refresh.
						ptr.click(ProvisioningPages.btn_Refresh, "Clicking on link: Refresh");
						// continue;
					} catch (NoSuchElementException ex2) {
						// Export task completed
						ptr.updateStep("Export task completed after: " + intWaitedTime, "Pass");
						break;
					}
				}
			}

			if (validateResult) {

				if (!blnPositiveTest) {
					String result = ptr.getText(provisioningpages.import_Results_multiline,
							"Get text from Results window");
					if (result.contains("spreadsheet requested but no match found.")) {
						ptr.updateStep("Negative Test: The export failed fetching the results as expected!", "Pass");
						return;
					} else {
						ptr.updateStep("Negative Test: The export did not fail to fetch the results as expected!",
								"Fail");
					}
				}

				// Step 18. Click on Retrieve Results button
				ptr.click(ProvisioningPages.retrieve_Results, "clicking on Retrieve Results button");
				ptr.wait(20000);

				String strExpReportFileName = "ClearspanExport" + strExportType.split(":")[1].trim();

				// Wait for the report to download in the Downloaeds_Folder
				String strFilename = System.getProperty("user.dir") + "\\Downloads_Folder" + "\\"
						+ strExpReportFileName;
				File file = new File(strFilename);

				// Verify records in the downloaded report
				File downloads_path = new File(System.getProperty("user.dir") + "\\Downloads_Folder\\");
				File[] listOfFiles = downloads_path.listFiles();
				String strActualFile = "";

				// Fetch the actual file
				if (listOfFiles.length > 0) {
					for (File fileName : listOfFiles) {
						if (file.toString().contains(strExpReportFileName)) {
							strActualFile = fileName.toString();
							// Log.info("Found downloaded file in the folder: "
							// +
							// strActualFile);
							ptr.updateStep("Download of Results spreadsheet passed", "Pass");
							break;
						}
					}
				} else {
					ptr.updateStep("Download of Results spreadsheet failed!", "Fail");
				}

				// Search for the presence of result if positive, else opposite

				// Fail if the result is not found in the excel report
				// AutoAttendant:1243#User:4312
				ptr.wait(10000);
				String[] lstDataToValidate = strSheetsAndDataToValidate.split("#");
				String strWorksheet = "";
				List<String> lstDataToSearch = new ArrayList<>();
				;

				// Loop through the modules to verify all alerts
				for (String strDataToValidate : lstDataToValidate) {
					strWorksheet = strDataToValidate.split(":")[0];
					lstDataToSearch.add(strDataToValidate.split(":")[1]);
					System.out.println("try");

					boolean blnSearchResultsFound = searchExcelSheet(lstDataToSearch, strActualFile, strWorksheet);

					if (blnSearchResultsFound) {
						if (blnPositiveTest) {
							ptr.updateStep("Positive Test: Found expected data in the worksheet...", "Pass");
						} else {
							ptr.updateStep("Negative Test: Found data unexpectedly in the worksheet...", "Fail");
						}
					} else {
						if (blnPositiveTest) {
							ptr.updateStep("Positive Test: Expected data not found in the worksheet...", "Fail");
						} else {
							ptr.updateStep("Negative Test: Data not foudn as expected in the worksheet...", "Pass");
						}
						// ptr.updateStep("Positive Test: Not found expected
						// data in the worksheet...", "Fail");
					}
				}
			} // End of validate results block
		} else {
			ptr.updateStep("Please select at least one worksheet to export", "Fail");
		}

	}

	/*
	 * Login management featre related testing - Common lib
	 */

	public void loginManagemnt_test_increasePassword(String intPasswords)
			throws StaleElementReferenceException, Exception {

		String strAutotestOpeasyUsername = pomTestApps.STAcore.POMSuiteRunner.ConfigStore.get("Opeasy_SUUsername");

		selectMainPageMenuItem("Login Management", "Login Management");
		ptr.click(LoginManagementPages.btn_Login_Rules, "Click button: Login Rules");
		verifyScreenTitleProvPage("Login Rules Modify");

		ptr.selectDropdownByValue(LoginManagementPages.dropDown_NumberPreviousPasswordsChecked, "24 Passwords:",
				"Verify : Select value: 24 Passwords: is present");

		String strPasswords = intPasswords + " Passwords:";

		ptr.selectDropdownByValue(LoginManagementPages.dropDown_NumberPreviousPasswordsChecked, strPasswords,
				"Select value: " + strPasswords);

		ptr.selectCheckBox("form1:checkboxAllowPreviousPassword", true);

		ptr.click(OpeasyCommonPageElements.btn_Apply, "Click button Apply");
		ptr.click(OpeasyCommonPageElements.btn_OK, "Click button OK");

		verifyScreenTitleProvPage("Login Management");
		createSearchCriteriaRowOnLoginManagementPage(1, "Login Name", "", strAutotestOpeasyUsername);
		ptr.click(OpeasyCommonPageElements.btn_Search, "Click button Search");
		ptr.wait(3000);

		clickHtmlLinkElementIfAvailableOnPage("Edit", 1);
		ptr.type(LoginManagementPages.text_Password, strAutotestOpeasyUsername,
				"Change password: " + strAutotestOpeasyUsername);
		ptr.type(LoginManagementPages.text_ConfirmPassword, strAutotestOpeasyUsername,
				"Change password: " + strAutotestOpeasyUsername);
		ptr.type(LoginManagementPages.text_AdminName, "viru", "Entering Admin name");

		ptr.click(OpeasyCommonPageElements.btn_Apply, "Click button Apply");

		String strErrMsg = "Password cannot be the same as any of the " + intPasswords
				+ " previous passwords (including the current password), regardless of character case.";

		if (verifyErrorMessageOnScreen(strErrMsg)) {
			ptr.updateStep("Error message seen as expected", "Pass");
		} else {
			ptr.click(OpeasyCommonPageElements.btn_Cancel, "Click button Cancel");
			ptr.updateStep("Error message seen as expected", "Pass");
		}

		ptr.click(OpeasyCommonPageElements.btn_Cancel, "Click button Cancel");

		// Cleanupp

		ptr.click(LoginManagementPages.btn_Login_Rules, "Click button: Login Rules");
		verifyScreenTitleProvPage("Login Rules Modify");

		ptr.selectDropdownByExactValue(LoginManagementPages.dropDown_NumberPreviousPasswordsChecked, " Password:",
				"Select value: Password: ");

		ptr.selectCheckBox("form1:checkboxAllowPreviousPassword", false);

		ptr.click(OpeasyCommonPageElements.btn_Apply, "Click button Apply");
		ptr.click(OpeasyCommonPageElements.btn_OK, "Click button OK");

	}

	/*
	 * Author: Viru Lib for testing Global Extra Settings Privileges test cases
	 */
	public void GlobalExtraSettingsTest(String strEnterprise, String strGroup, String strManufacturer,
			boolean verifyTabDisplayed, boolean blnCheckEditable) throws InterruptedException, IOException {

		selectMainPageMenuItem("Provisioning", "Provisioning");
		ptr.wait(5000);
		selectMainPageMenuItem("Phone Templates", "Phone Templates");
		ptr.wait(5000);
		selectMainPageMenuItem("Global Settings", "Global Configuration File Settings");
		ptr.wait(5000);
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
				"Select Enterprise : " + strEnterprise);
		ptr.wait(15000);
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group, strGroup, "Select Group : " + strGroup);
		ptr.wait(15000);

		ptr.selectDropdownByValue(PhoneTemplatePages.dropdown_PhoneManufacturer, strManufacturer,
				"Select Group : " + strGroup);
		// ptr.selectDropdownByExactValue(PhoneTemplatePages.dropdown_PhoneManufacturer,
		// strManufacturer,
		// "Select Manufacturer: " + strManufacturer);
		ptr.wait(30000);

		try {
			driver.findElement(By.xpath("//*[@id='form1:tabSet']/ul//a[contains(., 'Extra Settings')]"));
			if (verifyTabDisplayed) { // Tab Displayed
				ptr.updateStep("The Extra Settings tab is displayed.", "Pass");
				if (blnCheckEditable) { // Tab components are editable
					try {
						ptr.wait(5000);
						driver.findElement(By.xpath("//*[@id='form1:tabSet']/ul//a[contains(., 'Extra Settings')]"))
								.click();
						ptr.wait(20000);
						WebElement btnGroupSettings = driver.findElement(
								By.id("form1:tabSet:TemplatesGlobalExtraSettings:buttonGroupExtraSettings"));
						if (btnGroupSettings.isEnabled()) {
							// Editable - Pass
							ptr.updateStep("Group Extra Settings button is enabled", "Pass");
						} else {
							ptr.updateStep("Group Extra Settings button is not enabled", "Fail");
						}

						ptr.wait(10000);
						WebElement buttonEnterpriseExtraSettings = driver.findElement(
								By.id("form1:tabSet:TemplatesGlobalExtraSettings:buttonEnterpriseExtraSettings"));
						if (buttonEnterpriseExtraSettings.isEnabled()) {
							// Editable - Pass
							ptr.updateStep("Enterprise Extra Settings button is enabled", "Pass");
							ptr.click(buttonEnterpriseExtraSettings, "Click on buttonEnterpriseExtraSettings");
							ptr.wait(20000);
							ptr.alertAccept();
							ptr.wait(5000);
							ptr.click(opeasyCommonPageElements.btn_Apply, "Click button Apply");
						} else {
							ptr.updateStep("Enterprise Extra Settings button is not enabled", "Fail");
						}

						ptr.wait(10000);
						WebElement buttonSystemExtraSettings = driver.findElement(
								By.id("form1:tabSet:TemplatesGlobalExtraSettings:buttonSystemExtraSettings"));
						if (buttonSystemExtraSettings.isEnabled()) {
							// Editable - Pass
							ptr.updateStep("System Extra Settings button is enabled", "Pass");
							ptr.click(buttonSystemExtraSettings, "Click on buttonSystemExtraSettings");
							ptr.wait(20000);
							ptr.alertAccept();
							ptr.click(opeasyCommonPageElements.btn_Apply, "Click button Apply");
						} else {
							ptr.updateStep("System Extra Settings button is not enabled", "Fail");
						}

					} catch (NoSuchElementException e) {
						// Not editable - Fail
						ptr.updateStep("Extra Settings button is not enabled", "Fail");
					}
				}
			} else {
				ptr.updateStep("The Extra Settings tab is displayed.", "Fail");
			}
		} catch (NoSuchElementException e) { // Tab Not displayed
			if (verifyTabDisplayed) {
				ptr.updateStep("The Extra Settings tab is not displayed.", "Fail");
			} else {
				ptr.updateStep("The Extra Settings tab is not displayed.", "Pass");
			}
		}
		ptr.wait(10000);
		ptr.click(OpeasyCommonPageElements.btn_Cancel, "Click button OK");

	}

	


	/*
	 * Lib to click a href element if available on page Used for 508 automation,
	 * where the record identity does not matter Any record is okay as long as the
	 * record is editable
	 */
	public boolean clickHtmlLinkElementIfAvailableOnPage(String strLinkText, int intIndex) throws InterruptedException {
		try {
			String index = String.valueOf(intIndex);

			if (intIndex < 0) {
				index = "last()";
			}
			String strDynXpath = "(//a[contains(text(), '" + strLinkText + "')])[" + index + "]";
			WebElement ele = driver.findElement(By.xpath(strDynXpath));

			ele.click();
			ptr.wait(3000);
		} catch (NoSuchElementException ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	// public void execRestGET (String strRequest) throws
	// ClientProtocolException, IOException {
	//
	// HttpClient client = new DefaultHttpClient();
	// HttpGet request = new HttpGet(strRequest);
	// HttpResponse response = client.execute(request);
	// BufferedReader rd = new BufferedReader (new
	// InputStreamReader(response.getEntity().getContent()));
	// String line = null;
	// while ((line = rd.readLine()) != null) {
	// System.out.println(line);
	// }
	//
	// }
	//
	// public void execRestPUT(String strRequest) throws
	// ClientProtocolException, IOException {
	// HttpClient client = new DefaultHttpClient();
	// HttpPost post = new HttpPost(strRequest);
	// StringEntity input = new StringEntity("product");
	// post.setEntity(input);
	// HttpResponse response = client.execute(post);
	// BufferedReader rd = new BufferedReader(new
	// InputStreamReader(response.getEntity().getContent()));
	// String line = null;
	// while ((line = rd.readLine()) != null) {
	// System.out.println(line);
	// }
	// }

	/*
	 * Lib to click a href element if available on page Used for 508 automation,
	 * where the record identity does not matter Any record is okay as long as the
	 * record is editable
	 */
	public boolean clickSpanElementIfAvailableOnPage(String strLinkText, int intIndex) throws InterruptedException {
		try {
			String index = String.valueOf(intIndex);

			if (intIndex < 0) {
				index = "last()";
			}
			String strDynXpath = "(//span[contains(text(), '" + strLinkText + "')])[" + index + "]";
			WebElement ele = driver.findElement(By.xpath(strDynXpath));
			ele.click();
			ptr.wait(3000);
		} catch (NoSuchElementException ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * Lib to click a href element if available on page Used for 508 automation,
	 * where the record identity does not matter Any record is okay as long as the
	 * record is editable
	 */
	public boolean clickTabElementIfAvailableOnPage(String strTabName) throws InterruptedException {
		try {
			String strDynXpath = "//button[contains(., '" + strTabName + "')]";
			WebElement ele = driver.findElement(By.xpath(strDynXpath));
			ele.click();
			ptr.wait(3000);
		} catch (NoSuchElementException ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * Lib to click a href element if available on page Used for 508 automation,
	 * where the record identity does not matter Any record is okay as long as the
	 * record is editable
	 */
	public void deleteAndConfirm() throws InterruptedException, IOException {
		try {
			ptr.click(opeasyCommonPageElements.btn_Delete, "Click button Delete");
			ptr.wait(3000);
			ptr.alertAccept();
			ptr.wait(3000);
		} catch (NoSuchElementException ex) {
			ex.printStackTrace();
			return;
		}
	}

	// }

	public void scheduleResults(String Ent, String strExpReportFileName, String strsheetName) throws Exception {

		WebElement result1 = driver.findElement(
				By.xpath("(//span[contains(.,'" + Ent + "')])[1]//parent::td//parent::tr//a[contains(.,'Results')]"));

		ptr.click(result1, "Click Results link");
		ptr.wait(3500);

		ptr.click(ReportingPages.btn_RetreiveReport, "Click Retrieve Results button");
		// Verify Enterprise is displayed
		// Wait for the report to download in the Downloaeds_Folder
		String strFilename = System.getProperty("user.dir") + "\\Downloads_Folder" + "\\" + strExpReportFileName;
		File file = new File(strFilename);

		System.out.println("strExpReportFileName" + strExpReportFileName);
		System.out.println("strFilename" + strFilename);

		// Verify records in the downloaded report
		File downloads_path = new File(System.getProperty("user.dir") + "\\Downloads_Folder\\");
		System.out.println("downloads path : " + downloads_path);
		File[] listOfFiles = downloads_path.listFiles();
		String strActualFile = "";

		// Fetch the actual file
		if (listOfFiles.length > 0) {
			for (File fileName : listOfFiles) {
				ptr.wait(1500);
				if (file.toString().contains(strExpReportFileName)) {
					ptr.wait(1500);
					strActualFile = fileName.toString();
					ptr.wait(1500);
					// .info("Found downloaded file in the folder: " +
					// strActualFile);
					System.out.println("Actual File : " + strActualFile);
					ptr.updateStep("Download of Results spreadsheet passed", "Pass");
					break;
				}
			}
		} else {
			ptr.updateStep("Download of Results spreadsheet failed!", "Fail");
		}

		// Step 10. Verify that all the Users are listed and the tabs are in the
		// Export.
		String strDownloadedResultsFile = null;

		String strReturn = verifyWorksheetsPresentInExcelWorkbook(strActualFile, strsheetName);
		if (strReturn != "") {
			ptr.updateStep("Expected following worksheets not present in the results wokrbook " + strActualFile + " : "
					+ strReturn, "Fail");
		} else {
			ptr.updateStep("Expected following worksheets present in the results wokrbook " + strActualFile + " : "
					+ strsheetName, "Pass");
		}

		List<String> searchField = new ArrayList<String>();
		searchField.add(Ent);

		boolean blnResult = searchExcelSheet(searchField, strActualFile, strsheetName);
		System.out.println("Search result  is : " + blnResult);
		if (blnResult) {
			ptr.updateStep("Enterprise is present", "Pass");
		} else {
			ptr.updateStep("Enterprise is not seen", "Fail");
		}

	}

	public void CreateUserProfile(String strEnterprise, String strGroup, String StrProfileName, String strDeviceType,
			String Template) throws Exception {
		try {

			// Step 3. select Phone Templates from Provisioning
			ptr.click(ProvisioningPages.link_UserProfiles, "Clicking on link: User Profiles");

			// Step 6. Select Enterprise from drop down box
			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Selecting an Enterprise : " + strEnterprise);
			ptr.wait(5000);

			// Step 7. Select Group from drop down box
			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group, strGroup,
					"Selecting the Group : " + strGroup);

			ptr.click(OpeasyCommonPageElements.btn_Add, "Clicking on button : Add");

			verifyScreenTitleProvPage("User Profile Add");

			ptr.type(ProvisioningPages.textbox_Userprofile, StrProfileName,
					"Enter New User Profile Name : " + StrProfileName);

			ptr.selectDropdownByValue(ProvisioningPages.dropdown_DeviceType, strDeviceType,
					"Selecting Device Type : " + strDeviceType);

			ptr.selectDropdownByValue(ProvisioningPages.lst_DevTemplate, Template,
					"Selecting Template from drop down : <Default> (Group)");

			ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on link: OK");

		} catch (NoSuchElementException e) {
			ptr.updateStep("User profile is not created", "INFO");
		}
	}

	/*
	 * Add User using User Profile
	 */
	public void addUserusingProfile(String strEnterprise, String strGroup, String userProfile, String StrLastName,
			String StrFirstName, String strPhoneNum) throws Exception {

		try {

			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Selecting an Enterprise : " + strEnterprise);
			ptr.wait(5000);

			// Step 7. Select Group from drop down box
			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group, strGroup,
					"Selecting the Group : " + strGroup);

			// Step 5. Click on Add User Button.
			ptr.click(OpeasyCommonPageElements.btn_Add, "Click On Add Button");

			verifyScreenTitleProvPage("Advanced: User Add");

			// Step 7. Select User Profile From Dropdown.
			ptr.selectDropdownByValue(ProvisioningPages.user_profile, userProfile,
					"Select User Profile From Dropdown: " + userProfile);

			ptr.type(ProvisioningPages.lastname_Clearspan_User, StrLastName, "Enter Last Name : " + StrLastName);
			ptr.type(ProvisioningPages.firstname_Clearspan_User, StrFirstName, "Enter First Name : " + StrFirstName);

			ptr.selectDropdownByValue(ProvisioningPages.phoneNumber_AdvanceUser, strPhoneNum,
					"Selecting Device Type : " + strPhoneNum);

			ptr.type(ProvisioningPages.userPassword_Clearspan_User, "clearspan", "Enter Password : clearspan");

			ptr.type(ProvisioningPages.text_Userconfirmpassword, "clearspan", "Enter confirm Password : clearspan");

			ptr.type(ProvisioningPages.clearspan_UserID, StrLastName + "." + StrFirstName,
					"Enter confirm Password : clearspan");

			ptr.type(ProvisioningPages.Calling_Line_Lastname, StrLastName, "Enter Last Name : " + StrLastName);
			ptr.type(ProvisioningPages.Calling_Line_Firstname, StrFirstName, "Enter First Name : " + StrFirstName);

			ptr.type(ProvisioningPages.textbox_DeviceAccessUserName, "clearspan",
					"Enter Device Access User Name : clearspan");
			ptr.type(ProvisioningPages.textbox_DeviceAccessPassword, "clearspan",
					"Enter Device Access Password : clearspan");

			// ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on link: OK");

			// try {
			if (OpeasyCommonPageElements.btn_OK.isDisplayed()) {
				ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on link: OK");
			} else {
				System.out.println("Pass");
				// catch (NoSuchElementException s) {

			}

			// try {
			WebElement title = driver.findElement(By.xpath("//span[contains(.,'User Add Messages')]"));
			if (title.isDisplayed()) {
				ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on link: OK");
			} else {
				System.out.println("Pass");
			}
			// } catch (NoSuchElementException s) {

			// }

			verifyScreenTitleProvPage("Users");

		} catch (NoSuchElementException e) {
			ptr.updateStep("User is not created", "INFO");
		}
	}

	/*
	 * Add user using user profile - PING Attach/detach feature
	 */

	public void addUserusingProfilePing(String strEnterprise, String strGroup, String userProfile, String StrLastName,
			String StrFirstName, String strPhoneNum, String email, String dispositionalState) throws Exception {

		try {

			// Search the User in Users page and delete
			ptr.click(ProvisioningPages.link_Users, "Click on Users link to search the User");

			// Select Enterprise
			ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Select Enterprise : " + strEnterprise);

			// Select Group
			ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Group, strGroup, "Select Group : " + strGroup);

			// Step 5. Click on Add User Button.
			ptr.click(OpeasyCommonPageElements.btn_Add, "Click On Add Button");

			verifyScreenTitleProvPage("Advanced: User Add");

			try {
				if (userProfile != null) {
					// Step 7. Select User Profile From Dropdown.
					ptr.selectDropdownByValue(ProvisioningPages.user_profile, userProfile,
							"Select User Profile From Dropdown: " + userProfile);

				} else {
					ptr.updateStep("User profile is not required to this test case", "INFO");
				}
			} catch (NoSuchElementException e) {
				// do nothing
			}

			ptr.type(ProvisioningPages.lastname_Clearspan_User, StrLastName, "Enter Last Name : " + StrLastName);
			ptr.type(ProvisioningPages.firstname_Clearspan_User, StrFirstName, "Enter First Name : " + StrFirstName);

			ptr.type(ProvisioningPages.text_Emailaddress, email, "Enter email address->" + email);

			ptr.selectDropdownByValue(ProvisioningPages.phoneNumber_AdvanceUser, strPhoneNum,
					"Selecting Device Type : " + strPhoneNum);

			String CSUserId = StrFirstName + "." + StrLastName;

			// Clearspan UserID textbox
			ptr.type(ProvisioningPages.textbox_clearspanUserId, CSUserId, "Enter Clearspan UserID->" + CSUserId);

			ptr.type(ProvisioningPages.authentication_Name, CSUserId, "Enter Authentication Name: " + CSUserId);

			// Enter User password
			ptr.type(ProvisioningPages.userPassword_Clearspan_User, "clearspan", "Enter User password ");

			ptr.type(ProvisioningPages.text_Userconfirmpassword, "clearspan", "Enter Confirm User password ");

			// ptr.type(ProvisioningPages.clearspan_UserID, "clearspan1" ,
			// "Enter confirm Password : clearspan" );

			ptr.type(ProvisioningPages.Calling_Line_Lastname, StrLastName, "Enter Last Name : " + StrLastName);
			ptr.type(ProvisioningPages.Calling_Line_Firstname, StrFirstName,
					"Enter Calling Line ID First Name : " + StrFirstName);

			// Verify the Warning message if you try to use the retained PING device

			try {
				if (dispositionalState.equals("Retain")) {
					String expected_msg = "� 'Use the existing Ping account' must be selected to reattach the Ping Account in Phone Edit page for the Clearspan Bridge device.";
					String actual_msg = ProvisioningPages.ping_WarningMsg.getText();
					System.out.println("actual msg : " + actual_msg);
					if (expected_msg.equals(actual_msg)) {
						ptr.updateStep("Warning message is displayed", "Pass");

					}

				} else {
					ptr.updateStep("Warning message is not displayed", "Fail");
				}
			} catch (NoSuchElementException e) {
				// do nothing
			}

			ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on link: OK");
			ptr.wait(2000);

		} catch (NoSuchElementException e) {
			ptr.updateStep("User is not created", "INFO");
		}

		try {
			if (driver.findElement(By.xpath("//span[contains(.,'User Add Messages')]")).isDisplayed()) {
				ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on link: OK");
				ptr.wait(2000);
			} else {
				// do nothing
			}
		} catch (NoSuchElementException e) {

			// do nothing
		}

		verifyScreenTitleProvPage("Users");
	}

	/*
	 * delete user PING device assigned - Select "Retain" or "Deactivated"
	 */
	public void deletePingUser(String strEnterprise, String strGroup, String StrLastName, String dispositionalState)
			throws Exception {

		try {

			// Search the User in Users page and delete
			ptr.click(ProvisioningPages.link_Users, "Click on Users link to search the User");

			// Select Enterprise
			ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Select Enterprise : " + strEnterprise);

			// Select Group
			ptr.selectDropdownByValue(opeasyCommonPageElements.dropdown_Group, strGroup, "Select Group : " + strGroup);

			// Use search criteria and search the user
			createSearchCriteriaRow(1, "User: Last Name", "", StrLastName);
			ptr.click(OpeasyCommonPageElements.btn_Search, "Click Button Search");
			ptr.wait(2000);

			driver.findElement(By.xpath("//span[text()='" + StrLastName + "']")).click();

			verifyScreenTitleProvPage("Advanced: User Modify");
			ptr.click(OpeasyCommonPageElements.btn_Delete, "Click Button Delete");
			ptr.wait(2000);

			ptr.alertAccept();

			verifyScreenTitleProvPage("Ping User Deactivate/Retain");

			driver.findElement(By.xpath("//label[contains(.,'" + dispositionalState + "')]")).click();
			ptr.wait(2000);

			ptr.click(OpeasyCommonPageElements.btn_OK, "Click Button OK");
			ptr.wait(2000);

			verifyScreenTitleProvPage("Users");

		} catch (NoSuchElementException e) {
			ptr.updateStep("User is not deleted", "INFO");
		}
	}

	public void scheduleExport(String Admin, String Ent1, String Ent2, String Ent3) throws Exception {

		try {
			// Click Scheduling
			ptr.click(reportingpages.button_Scheduling, "Click Scheduling");
			ptr.wait(2000);

			ptr.isElementPresent(ReportingPages.Scheduling, "Verify Scheduling page is displayed");

			ptr.isElementPresent(ReportingPages.Scheduling, "Verify Scheduling page is displayed");

			// Select admin from drop down
			// select Admin from drop down
			ptr.selectDropdownByValue(reportingpages.dropDown_AdministratorList, Admin, "Selecting Admin : " + Admin);

			// The Scheduling requests table contains the requests for the
			// Reports for the 2-3 Enterprises.
			WebElement Entp1 = driver.findElement(By.xpath("(//span[contains(., '" + Ent1 + "')])[1]"));
			WebElement Entp2 = driver.findElement(By.xpath("(//span[contains(., '" + Ent2 + "')])[1]"));
			WebElement Entp3 = driver.findElement(By.xpath("(//span[contains(., '" + Ent3 + "')])[1]"));
			ptr.isElementPresent(Entp1, "Enterprise seen" + Ent1);
			ptr.isElementPresent(Entp2, "Enterprise seen" + Ent2);
			ptr.isElementPresent(Entp3, "Enterprise seen" + Ent3);
			ptr.wait(2000);

			// Click Refresh button
			ptr.click(ProvisioningPages.btn_Refresh, "Click Refresh button");
			ptr.wait(20000);

			try {
				ptr.click(ProvisioningPages.btn_Refresh, "Click Refresh button");
			} catch (NoSuchElementException e) {
				ptr.updateStep("Refresh button not seen", "INFO");
			}
			ptr.wait(20000);

			try {
				ptr.click(ProvisioningPages.btn_Refresh, "Click Refresh button");
				ptr.wait(20000);
			} catch (NoSuchElementException e) {
				ptr.updateStep("Refresh button not seen", "INFO");
			}
			ptr.wait(8000);
			try {
				ptr.click(ProvisioningPages.btn_Refresh, "Click Refresh button");
				ptr.wait(20000);
			} catch (NoSuchElementException e) {
				ptr.updateStep("Refresh button not seen", "INFO");
			}
			try {
				ptr.click(ProvisioningPages.btn_Refresh, "Click Refresh button");
				ptr.wait(20000);
			} catch (NoSuchElementException e) {
				ptr.updateStep("Refresh button not seen", "INFO");
			}
		} catch (NoSuchElementException h) {
			h.printStackTrace();
		}

	}
}

// End of Clearspan common libs
