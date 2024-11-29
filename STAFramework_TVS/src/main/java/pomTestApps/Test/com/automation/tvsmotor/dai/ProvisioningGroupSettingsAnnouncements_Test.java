package pomTestApps.Test.com.automation.tvsmotor.dai;
/**************************************************
#Project Name: MiTEL_CLEARSPAN � Opeasy Automation

#Test case Name: ProvisioningGroupSettingsAnnouncements_Test()
#Description:1. This test case is To Count Announcement For the Group
#Input Parameters: 
#Owner: Virupakshayya Kulkarni
#Author: Payal Gouda
#Date of creation: 22-Mar-18
#Name of person modifying: (Tester Name): Hameetha Banu
#Date of modification: 07.05.2018
‘**************************************************/

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pomTestApps.STAcore.DAICommon;
import pomTestApps.STAcore.Operations;
import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyCommonPageElements;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyHomePage;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.ProvisioningPages;

public class ProvisioningGroupSettingsAnnouncements_Test extends BaseClass {

	POMSuiteRunner POMSuiteRunner = new POMSuiteRunner();
	Operations oprs = new Operations();

	public static Hashtable<String, String> hashTable = new Hashtable<String, String>();
	public DAICommon clearspanCommon;

	@Test(dataProvider = DP)
	public void GroupSettingsAnnouncements(String Browser, String clearspanUrl, String opeasyUrl, String OpeasyUsername,
			String OpeasyPassword, String clearspanUserName, String clearspanPassword, String strEnterprise,
			String strGroup, String announcementType, String queryType, String queryComparison, String announcementName,
			String fileName) throws Exception {

		clearspanCommon = new DAICommon(driver, ptr);

		clearspanCommon.navigateOpeasyHomePage();
		clearspanCommon.navigateProvisioningPage();

		String strOpeasy_SR_Username = pomTestApps.STAcore.POMSuiteRunner.ConfigStore.get("Opeasy_SR_Username");
		String strOpeasy_SR_Password = pomTestApps.STAcore.POMSuiteRunner.ConfigStore.get("Opeasy_SR_Password");

		String strTestCaseName = "Group Settings - Announcements";

		try {
			/*
			 * Setup Part
			 */
			String strOpeasy_Username_EA;
			String strOpeasy_Username_SA;
			String strOpeasy_Username_SR;
			String strOpeasy_Username_GA;
			String strOpeasy_Username_DA;

			String strOpeasy_Password;
			String strUserType = "";

			strOpeasy_Username_EA = POMSuiteRunner.ConfigStore.get("Opeasy_EA_Username");
			strOpeasy_Password = POMSuiteRunner.ConfigStore.get("Opeasy_EA_Password");
			strUserType = "EA";

			/*
			 * Set "Account ID" Privilege as "No Access" for EA
			 */

			// Step 1. Login to OpEasy as super User

			clearspanCommon.opeasyClearLoginSessions(opeasyUrl, OpeasyUsername, OpeasyPassword);

			clearspanCommon.ResetToDefaultPrivilege(strOpeasy_Username_EA);

			strOpeasy_Username_SA = POMSuiteRunner.ConfigStore.get("Opeasy_SA_Username");
			strOpeasy_Password = POMSuiteRunner.ConfigStore.get("Opeasy_SA_Password");
			strUserType = "SA";

			clearspanCommon.ResetToDefaultPrivilege(strOpeasy_Username_SA);

			strOpeasy_Username_SR = POMSuiteRunner.ConfigStore.get("Opeasy_SR_Username");
			strOpeasy_Password = POMSuiteRunner.ConfigStore.get("Opeasy_SR_Password");
			strUserType = "SR";

			clearspanCommon.ResetToDefaultPrivilege(strOpeasy_Username_SR);
			
			strOpeasy_Username_DA = POMSuiteRunner.ConfigStore.get("Opeasy_DA_Username");
			strOpeasy_Password = POMSuiteRunner.ConfigStore.get("Opeasy_DA_Password");
			strUserType = "DA";

			clearspanCommon.ResetToDefaultPrivilege(strOpeasy_Username_DA);

			// Logging out from OpEasy as a system Admin
			 clearspanCommon.logoutOpeasy();
			 
			// Step 1. session as a Solution Reseller
			clearspanCommon.opeasyClearLoginSessions(opeasyUrl, strOpeasy_SR_Username, strOpeasy_SR_Password);

			// Step 2. Validate OpEasy HomePage displayed.
			ptr.isElementPresent(OpeasyHomePage.text_Opeasy_screenName, "Validating:Opeasy home page Displayed");

			// Step 3. click on Provisioning from Main menu.
			ptr.click(OpeasyHomePage.link_Provisioning, "Clicking on link: Provisioning");

			// Step 4. Validate Provisioning link displayed.
			ptr.isElementPresent(OpeasyHomePage.Provisioning_Screen, "Validating:Provisioning page Displayed");

			// Step 5. Click on Group Setting link from provisioning.
			ptr.click(ProvisioningPages.groupSetting_Link, "Clicking on link: Group Setting");

			// Step 6. Validate Group Setting Screen is displayed.
			ptr.isElementPresent(ProvisioningPages.groupSetting_Screen, "Validating:Group Setting page is Displayed");

			// Step 7. Click on Announcement Repository.
			ptr.click(ProvisioningPages.announcementRepository_Link, "Clicking on link: Announcement Repository");

			// Step 8. Validate Announcement Repository Screen is displayed.
			ptr.isElementPresent(ProvisioningPages.announcementRepository_Screen,
					"Validating:Announcement Repository page is Displayed");

			// Step 9. Select Enterprise.
			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Selecting an Enterprise : " + strEnterprise);

			// Step 10. Validate Announcement Repository Screen is displayed.
			ptr.isElementPresent(ProvisioningPages.announcementRepository_Screen,
					"Validating:Announcement Repository page is Displayed");

			// Step 11. Select Group.
			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group, strGroup,
					"Selecting a Group : " + strGroup);

			// Step 23. Select Announcement Query Type from Drop down box
			ptr.selectDropdownByValue(ProvisioningPages.announcement_Type, announcementType,
					"Selecting from drop down : Starts with " + announcementType);

			// Step 27. Click On Search.
			ptr.click(OpeasyCommonPageElements.btn_Search, "Clicking on link: search Announcement");

			int announcementListCount = driver.findElements(By.xpath("//a[contains(text(), 'Edit')]")).size();
			System.out.println("Number of Announcement Elements:  " + announcementListCount);

			ptr.updateStep("Announcements are displayed", "Pass");
			
			try {
				driver.findElement(By.xpath("//span[contains(text(),'" + announcementName + "')]")).click();
				ptr.wait(10000);
				// Step 29. Click On Delete Announcement.
				ptr.click(OpeasyCommonPageElements.btn_Delete, "Clicking on link: Delete Announcement");
				ptr.wait(3000);
				ptr.alertAccept();
				ptr.wait(3000);
			} catch (Exception exec) {
				exec.printStackTrace();
				ptr.updateStep("Auto Attendant is Not Present Create Auto Attendant User", "Pass");
			}
			ptr.wait(3000);

			// Step 12.Click on Add Button
			ptr.click(OpeasyCommonPageElements.btn_Add, "Clicking on link: add");

			// Step 13. Validate Group Announcement Add Screen is displayed.
			ptr.isElementPresent(ProvisioningPages.announcementAdd_Screen,
					"Validating:Group Announcement Add page is Displayed");

			// Step 14. Type Announcement Name.
			ptr.type(ProvisioningPages.announcement_Name, announcementName, "Type Announcement Name");
			ptr.wait(3000);

			// Step 15. Click on Browse for Announcement
			ptr.click(ProvisioningPages.btn_ProvisionSpreadsheet, "Clicking on link: Browse");
			ptr.wait(3000);
			// Step 9. Choose file to upload using AutoIt

			System.out.println(System.getProperty("user.dir"));
			String addAnnouncement = System.getProperty("user.dir") + "\\Upload_files" + "\\" + "meeting_greeting.wav";
			String autoIttoolLocation = System.getProperty("user.dir") + "\\Upload_files" + "\\"
					+ "ChooseFile.exe" + " ";

			Runtime.getRuntime().exec(autoIttoolLocation + addAnnouncement);

			// Step 17. Click on OK Button.
			ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking OK Button");

			// Step 18. Validating Announcement File is Displayed in List.
			ptr.isElementPresent(ProvisioningPages.announcement_List,
					"Validating:Announcement File is display In List");

			// Step 19. Click on OK Button.
			ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking OK Button");

			// Step 20. Validate Group Setting Screen is displayed.
			ptr.isElementPresent(ProvisioningPages.groupSetting_Screen, "Validating:Group Setting page is Displayed");

		}

		catch (Exception exec) {
			exec.getStackTrace();
			ptr.updateStep(strTestCaseName, "Fail");
		}

		finally {

			// Logging out from the application
			clearspanCommon.logoutOpeasy();

			// Generating report for the test case
			ptr.endReport();
		}
	}

}
