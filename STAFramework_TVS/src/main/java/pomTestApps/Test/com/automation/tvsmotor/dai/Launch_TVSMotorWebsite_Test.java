package pomTestApps.Test.com.automation.tvsmotor.dai;

/**************************************************
#Project Name: MiTEL_CLEARSPAN � Opeasy Automation
#Test case Name: LoginManagement_EnterpriseLoginRules_Test()
#Description:1. This test case verifies Login Rules on Login Management page
#Input Parameters: EnterpriseName
#Owner: Virupakshayya Kulkarni
#Author: Hameetha Banu K
#Date of creation: 02-Jun-21
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pomTestApps.STAcore.DAICommon;
import pomTestApps.STAcore.Operations;
import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyCommonPageElements;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.ReportingPages;

public class Launch_TVSMotorWebsite_Test extends BaseClass {

	public static Hashtable<String, String> hashTable = new Hashtable<String, String>();
	POMSuiteRunner POMSuiteRunner = new POMSuiteRunner();

	Operations oprs = new Operations();
	public DAICommon clearspanCommon;

	@Test(dataProvider = DP)
	public void Reporting_OpeningTheReportingMenu(

			String Browser, String clearspanUrl, String opeasyUrl, String OpeasyUsername, 
			String OpeasyPassword, String ClearspanUserName, String ClearspanPassword
					

	) throws Exception {

		clearspanCommon = new DAICommon(driver, ptr);
		
		String strTestcaseName = "Launch_TVSMotorWebsite_Test";

		
		/*
		 *Login a Solution Reseller.
The Solution Reseller's Main menu is displayed.

Select Reporting.
The Reporting menu is displayed.

Select the Inventory Report.
The Clearspan Inventory Report page is displayed.

Click the Enterprise drop-down list.

Multiple Enterprises option is displayed.
		 * 
		 */

//		clearspanCommon.navigateOpeasyHomePage();
//		clearspanCommon.navigateReportingPage();

//		String strOpeasy_SR_Username = POMSuiteRunner.ConfigStore.get("Opeasy_SR_Username");
//		String strOpeasy_SR_Password = POMSuiteRunner.ConfigStore.get("Opeasy_SR_Password");

		try {
			
			// Step 1. Login to OpEasy as a Super User
						clearspanCommon.opeasyClearLoginSessions(opeasyUrl, OpeasyUsername, OpeasyPassword);
//						
//						// Step 2. Click on Reporting link.
//						ptr.click(clearspanCommon.opeasyhome.link_Reporting, "Clicking on link: Reporting");
//
//						// Step 3. The Reporting page is displayed
//						ptr.isElementPresent(ReportingPages.text_Reporting_ScreenName, "Verify if Reporting page is displayed");	
//						
//						//Adding Cleanup part.  CLick Scheduling button
//						ptr.click(ReportingPages.scheduling, "Click Scheduling button ");
//						
//						ptr.selectDropdownByValue(ReportingPages.dropDown_ScheduledTaskList, "(All Scheduled Tasks)",
//								"Selecting task :(All Scheduled Tasks)" );	
//						
//						ptr.selectDropdownByValue(ReportingPages.dropDown_AdministratorList, OpeasyUsername,
//								"Selecting Admin : " +OpeasyUsername );
//						ptr.wait(2000);
//						
//						ptr.click(ReportingPages.radio_ActiveWaiting, "Enable Radio button" );
//						ptr.wait(2000);
//						
//						List<WebElement> table = driver.findElements(By.xpath("//tbody[@id='form1:tableScheduling_data']//tr"));
//					
//						try {
//							int size = table.size();
//							System.out.println("Size : " +size);
//							if (size >0){
//								for (int i =1; i==size; i++){
//									driver.findElement(By.xpath("//span[@class='ui-chkbox-icon ui-icon ui-icon-blank ui-c']")).click();
//									ptr.wait(2000);
//								}
//								System.out.println("Size : " +size);
//							}
//						}catch (Exception f) {
//							ptr.updateStep("Table cleared", "INFO");
//						}
//						
//						//Click apply button
//						ptr.click(OpeasyCommonPageElements.btn_Apply, "Click Apply button");
//						ptr.wait(2000);
//						
//						// Logging out from the application
//						clearspanCommon.logoutOpeasy();
//						
//						
//			// Step 1. Login to OpEasy as a Solution Reseller Admin
//			clearspanCommon.opeasyClearLoginSessions(opeasyUrl, strOpeasy_SR_Username, strOpeasy_SR_Password);
//
//			// Step 2. Click on Reporting link.
//			ptr.click(clearspanCommon.opeasyhome.link_Reporting, "Clicking on link: Reporting");
//
//			// Step 3. The Reporting page is displayed
//			ptr.isElementPresent(ReportingPages.text_Reporting_ScreenName, "Verify if Reporting page is displayed");	
//					
//			//Step 4. Click Inventory Report Link
//			ptr.click(ReportingPages.link_InventoryReporting, "Click Inventory Report Link" );
//			
//			//Click the Enterprise drop-down list.
//			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, "(Multiple Enterprises)",
//					"Selecting enterprise : (Multiple Enterprises) " );				
						
			ptr.updateStep(strTestcaseName, "Pass");
		}

		catch (Exception exec) {
			exec.getStackTrace();
			ptr.updateStep(strTestcaseName, "Fail");
		}

		finally {

			// Logging out from the application
//			clearspanCommon.logoutOpeasy();

			// Generating report for the test case
			ptr.endReport();

		}
	}

}
