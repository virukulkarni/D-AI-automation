package pomTestApps.Test.com.automation.tvsmotor.dai;
/**************************************************
#Project Name: MiTEL_CLEARSPAN � Opeasy Automation

#Test case Name: LoginManagement_PhoneTemplatesDisplayTemplate_Test()
#Description:1. This test case is combination of verifing 'Display Template', 'Edit Template', 'Delete Template', 'Select Template in se' testcases on Login Management
#Input Parameters: 
#Owner: Virupakshayya Kulkarni
#Author: Payal Gouda
#Date of creation: 20-Feb-18
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pomTestApps.STAcore.DAICommon;
import pomTestApps.STAcore.Operations;
import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.ClearspanHomePage;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyCommonPageElements;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyHomePage;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.ProvisioningPages;

public class ProvisioningDeleteVirtualUsers_Test extends BaseClass {

	POMSuiteRunner POMSuiteRunner = new POMSuiteRunner();
	Operations oprs = new Operations();

	public static Hashtable<String, String> hashTable = new Hashtable<String, String>();
	public DAICommon clearspanCommon;

	@Test(dataProvider = DP)
	public void DeleteVirtualUsers(String Browser, String clearspanUrl, String opeasyUrl, String OpeasyUsername,
			String OpeasyPassword, String clearspanUserName, String clearspanPassword, String strEnterprise,
			String strGroup, String autoAttName, String autoAttID, String autoAttType, String autoAtt_Department,
			String autoAtt_PhoneNumber, String extension, String autoAtt_NetworkServerSite, String callingLineLastname,
			String callingLineFirstname, String searchQuery, String searchComparison, String huntsearchQuery,
			String huntsearchOption, String flexHostsearchQuery, String flexHostsearchOption, String findKey1,
			String findOption1, String findKey2, String findOption2, String strEnt

	) throws Exception {

		clearspanCommon = new DAICommon(driver, ptr);

		clearspanCommon.navigateOpeasyHomePage();
		clearspanCommon.navigateProvisioningPage();
		clearspanCommon.navigateClearspanHomePage();

		String strOpeasy_SA_Username = POMSuiteRunner.ConfigStore.get("Opeasy_SA_Username");
		String strOpeasy_SA_Password = POMSuiteRunner.ConfigStore.get("Opeasy_SA_Password");

		String strTestCaseName = "	Delete User/Devices - Delete Virtual Users";

		try {
			// Step 1. Login to OpEasy as a System Admin without Advanced
			// Provisioning Privilege
			clearspanCommon.opeasyClearLoginSessions(opeasyUrl, OpeasyUsername, OpeasyPassword);
			
			// Step 3. click on Provisioning from Main menu.
			ptr.click(OpeasyHomePage.link_Provisioning, "Clicking on link: Provisioning");
			ptr.wait(3000);			
			
			//Delete User if already present
			if (clearspanCommon.userExists("SA", strEnterprise, strGroup, "User ID / Alternate User ID", autoAttID)) {
				clearspanCommon.deleteUserThatExists(autoAttID);
			}
			
			if (clearspanCommon.virtualUserExists("SU", strEnterprise, strGroup, 
					"Phone Number (Primary)", autoAttID, "Auto Attendants")) {
				clearspanCommon.deleteVirtualUserThatExists(autoAttID);
			}

			// Step 3. Step To Go To Provisioning page
			ptr.click(OpeasyCommonPageElements.btn_OK, "Click button OK");
			ptr.click(OpeasyCommonPageElements.btn_OK, "Click button OK");

			clearspanCommon.logoutOpeasy();
			
			clearspanCommon.opeasyClearLoginSessions(opeasyUrl, strOpeasy_SA_Username, strOpeasy_SA_Password);
			
			// Step 4. Step To Go To Auto Attendant page
//			goToProvisioningPage();
			goToAutoAttendantUserPage();

			// Step 5. Step To Create Auto Attendant 
			if (CreateAutoAttendantUser(strEnterprise, strGroup, autoAttName, autoAttID, autoAttType,
					autoAtt_Department, autoAtt_PhoneNumber, extension, autoAtt_NetworkServerSite, callingLineLastname,
					callingLineFirstname)) {
					ptr.updateStep("Auto Attendant User is Created", "Pass");
			}else {
				ptr.updateStep("Auto Attendant User is Not Created", "Fail");
			}

			if( clearspanCommon.virtualUserExists("SA", strEnterprise, strGroup, searchQuery, autoAttName, "Auto Attendants")) {
				clearspanCommon.deleteVirtualUserThatExists(autoAttName);
			}
		
			clearspanCommon.logoutOpeasy();

			// Step 10. Go to ServiceTab In Clearspan
			goToServicesTabInClearspan(clearspanUrl, clearspanUserName, clearspanPassword, strEnt, strGroup,
					findKey1, findOption1, findKey2, findOption2);

			// Step 11. Go to Auto Attendant in Clearspan
			goToAutoAttendantInClearspan();

			// Step 12. Validate Virtual User In clearspan
			try {
				driver.findElement(By.linkText("" + autoAttName + ""));
				ptr.updateStep("Virtual User is present in clearspan", "fail");
			} catch (Exception exec) {
				ptr.updateStep("Virtual User is not present in clearspan", "pass");
			}
			
			clearspanCommon.opeasyClearLoginSessions(opeasyUrl, strOpeasy_SA_Username, strOpeasy_SA_Password);
//
//			// logout clearspan
//			clearspanCommon.logoutClearspan();
//
//			/*
//			 * Steps For Hunt Group
//			 */
//
//			// Step 1. Login to OpEasy as a System Admin
//			clearspanCommon.loginToOpeasy(opeasyUrl, strOpeasy_SA_Username, strOpeasy_SA_Password);
//
//			// Step 2. Validate OpEasy HomePage displayed.
//			// ptr.isElementPresent(OpeasyHomePage.text_Opeasy_screenName,
//			// "Validating:Opeasy home page Displayed");
//
//			// Step 3. Step To Go To Provisioning page
//			goToProvisioningPage();
//
//			// Step 13. Step To Go To Hunt Group page
//			goToHuntGroupUserPage();
//
//			// Step 14. Step To Go To Auto Attendant page
//			if (CreateHuntGroupUser(strEnterprise, strGroup, autoAttName, autoAttID, autoAttType, autoAtt_Department,
//					autoAtt_PhoneNumber, extension, autoAtt_NetworkServerSite, callingLineLastname,
//					callingLineFirstname)) {
//
//				// Step 15. Find User In List
//				try {
//					ptr.updateStep("Hunt Group User is Created", "Pass");
//				} catch (NoSuchElementException exec) {
//					ptr.updateStep("Hunt Group User is Not Created", "Fail");
//				}
//			}
//
//			// Step 16. Step To Go To Hunt Group page
//			goToHuntGroupUserPage();
//
//			// Step 17. Step To Go To Hunt Group page
//			if (DeleteHuntGroupUser(strEnterprise, strGroup, autoAttName, huntsearchQuery, huntsearchOption)) {
//
//				// Step 18. Find User In List
//				try {
//					ptr.updateStep("Hunt Group is Deleted", "Pass");
//				} catch (Exception exec) {
//					ptr.updateStep("Hunt Group is Not Deleted", "Fail");
//				}
//			}
//
//			// logout opeasy
//			clearspanCommon.logoutOpeasy();
//
//			// Step 19. Go to ServiceTab In Clearspan
//			goToServicesTabInClearspan(clearspanUrl, clearspanUserName, clearspanPassword, strEnterprise, strGroup,
//					findKey1, findOption1, findKey2, findOption2);
//
//			// Step 20. Go to Hunt Group in Clearspan
//			goToHuntGroupInClearspan();
//
//			// Step 21. Validate Virtual User In clearspan
//
//			try {
//				driver.findElement(By.xpath("" + autoAttName + "")).isDisplayed();
//				ptr.updateStep("Virtual User is present in clearspan", "fail");
//			} catch (Exception exec) {
//				ptr.updateStep("Virtual User is not present in clearspan", "pass");
//			}
//
//			// logout clearspan
//			clearspanCommon.logoutClearspan();
//
//			/*
//			 * Steps For Flexible Seating user
//			 */
//			// Step 1. Login to OpEasy as a System Admin without Advanced
//			// Provisioning Privilege
//			clearspanCommon.loginToOpeasy(opeasyUrl, strOpeasy_SA_Username, strOpeasy_SA_Password);
//
//			// Step 2. Validate OpEasy HomePage displayed.
//			ptr.isElementPresent(OpeasyHomePage.text_Opeasy_screenName, "Validating:Opeasy home page Displayed");
//
//			// Step 3. Step To Go To Provisioning page
//			goToProvisioningPage();
//
//			// Step 4. Step To Go To Flexible Seating Host page
//			goToFlexibleSeatingHostsPage();
//
//			// Step 5. Step To Create Auto AttendantFlexible Seating Host User
//			if (CreateFlexSeatingHostUser(strEnterprise, strGroup, autoAttName, autoAttID, autoAttType,
//					autoAtt_Department, autoAtt_PhoneNumber, extension, autoAtt_NetworkServerSite, callingLineLastname,
//					callingLineFirstname)) {
//
//				// Step 6. Find User In List
//				try {
//					ptr.updateStep("Flexible Seating Host User is Created", "Pass");
////					ptr.click(OpeasyCommonPageElements.btn_OK, "Click button OK");
//				} catch (NoSuchElementException exec) {
//					ptr.updateStep("Flexible Seating Host User is Not Created", "Fail");
//				}
//			}
//			
//			// Step 4. Step To Go To Flexible Seating Host page
//			goToProvisioningPage();
//
//			// Step 7. Step To Go To Flexible Seating Host page
//			goToFlexibleSeatingHostsPage();
//
//			// Step 8. Step To Delete Flexible Seating Host User
//			if (DeleteFlexSeatingHostUser(strEnterprise, strGroup, autoAttName, flexHostsearchQuery,
//					flexHostsearchOption)) {
//
//				// Step 9. Find User In List
//				try {
//					ptr.updateStep("Flexible Seating Host User is Deleted", "Pass");
//				} catch (NoSuchElementException exec) {
//					ptr.updateStep("Flexible Seating Host User is Not Deleted", "Fail");
//				}
//
//			}
//
//			// logout opeasy
//			clearspanCommon.logoutOpeasy();
//
//			// Step 19. Go to ServiceTab In Clearspan
//			goToServicesTabInClearspan(clearspanUrl, clearspanUserName, clearspanPassword, strEnterprise, strGroup,
//					findKey1, findOption1, findKey2, findOption2);
//
//			// Step 20. Go to Flexible Seating Host in Clearspan
//			goToFlexibleSeatingHostInClearspan();
//
//			// Step 23 .Click on Search button
//			ptr.click(ClearspanHomePage.search_Button, "Click On Search");
//
//			// Step 21. Validate Virtual User In clearspan
//
//			try {
//				driver.findElement(By.xpath("" + autoAttName + "")).isDisplayed();
//				ptr.updateStep("Virtual User is present in clearspan", "fail");
//			} catch (Exception exec) {
//				ptr.updateStep("Virtual User is not present in clearspan", "pass");
//			}
//			// logout clearspan
//			clearspanCommon.logoutClearspan();
//
//			// Step 1. Login to OpEasy as a System Admin without Advanced
//			// Provisioning Privilege
//			clearspanCommon.loginToOpeasy(opeasyUrl, strOpeasy_SA_Username, strOpeasy_SA_Password);
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

	/*
	 * Adding Steps To Going Auto Attendant User page
	 * 
	 */

	public void goToProvisioningPage() throws IOException, InterruptedException {

		// Step 1. click on Provisioning from Main menu.
		ptr.click(OpeasyHomePage.link_HeaderProvisioning, "Clicking on link: Provisioning");

		// Step 2. Validate Provisioning link displayed.
		clearspanCommon.verifyScreenTitleProvPage("Provisioning");
		
	}

	/*
	 * Adding Steps To Going Auto Attendant User page
	 * 
	 */

	public void goToAutoAttendantUserPage() throws IOException, InterruptedException {
		
		// Step 1. click on Provisioning from Main menu.
		ptr.click(OpeasyHomePage.link_HeaderProvisioning, "Clicking on link: Provisioning");

		// Step 2. Validate Provisioning link displayed.
		clearspanCommon.verifyScreenTitleProvPage("Provisioning");
	
		// Step 1. click on Virtual Users link
		ptr.click(ProvisioningPages.virtualUser_Link, "Clicking on link: Virtual Users");

		// Step 2. Validating Virtual Users Screen Displayed
		clearspanCommon.verifyScreenTitleProvPage("Virtual Users");

		// Step 3. click on Auto Attendant link
		ptr.click(ProvisioningPages.autoAttendant_Link, "Clicking on link: Auto Attendant");

		// Step 4. Validating Auto Attendant Screen Displayed
		ptr.isElementPresent(ProvisioningPages.autoAttendant_Screen, "Validating: Auto Attendant page Displayed");

	}

	/*
	 * Adding Steps To Going Hunt Group User page
	 * 
	 */

	public void goToHuntGroupUserPage() throws IOException, InterruptedException {

		// Step 1. click on Virtual Users link
		ptr.click(ProvisioningPages.virtualUser_Link, "Clicking on link: Virtual Users");

		// Step 2. Validating Virtual Users Screen Displayed
		clearspanCommon.verifyScreenTitleProvPage("Virtual Users");

		// Step 3. click on Hunt Group link
		ptr.click(ProvisioningPages.huntGroup_Link, "Clicking on link: Hunt Group ");

		// Step 4. Validating Hunt Group Screen Displayed
		ptr.isElementPresent(ProvisioningPages.huntGroup_Screen, "Validating: Hunt Group page Displayed");

	}

	/*
	 * Adding Steps To Going Flexible Seating Hosts User page
	 * 
	 */

	public void goToFlexibleSeatingHostsPage() throws IOException, InterruptedException {

		// Step 1. click on Virtual Users link
		ptr.click(ProvisioningPages.virtualUser_Link, "Clicking on link: Virtual Users");

		// Step 2. Validating Virtual Users Screen Displayed
		clearspanCommon.verifyScreenTitleProvPage("Virtual Users");

		// Step 3. click on Flexible Seating Hosts link
		ptr.click(ProvisioningPages.flexibleSeatingHost_Link, "Clicking on link: Flexible Seating Hosts");

		// Step 4. Validating Flexible Seating Hosts Screen Displayed
		ptr.isElementPresent(ProvisioningPages.flexibleSeatingHost_Screen,
				"Validating: Flexible Seating Hosts page Displayed");
	}

	/*
	 * Adding Steps For Add Auto Attendant User
	 * 
	 */

	public boolean CreateAutoAttendantUser(String strEnterprise, String strGroup, String autoAttName, String autoAttID,
			String autoAttType, String autoAtt_Department, String autoAtt_PhoneNumber, String extension,
			String autoAtt_NetworkServerSite, String callingLineLastname, String callingLineFirstname)
			throws IOException, InterruptedException {

		// STEPS FOR ADDING AUTO ATTENDANT USER

		// Step 1. Select Enterprise
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
				"Selecting an Enterprise : " + strEnterprise);

		// Step 2. Validating Auto Attendant Screen Displayed
		ptr.isElementPresent(ProvisioningPages.autoAttendant_Screen, "Validating: Auto Attendant page Displayed");

		// Step 3. Select Group
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group, strGroup, "Selecting the Group : " + strGroup);

		// Step 4. Validating Auto Attendant Screen Displayed
//		ptr.isElementPresent(ProvisioningPages.autoAttendant_Screen, "Validating: Auto Attendant page Displayed");

		// Step 5. Click on Add Button
		ptr.click(OpeasyCommonPageElements.btn_Add, "Click On Add User Button");

		// Step 6. Validating Auto Attendant Add Screen
		ptr.isElementPresent(ProvisioningPages.autoAttendantAdd_Screen,
				"Validating:Auto Attendant screen Is Displayed");

		// Step 7. Give Name For Auto Attendant User
		ptr.type(ProvisioningPages.autoAttName_Field, autoAttName, "Give the Auto Attendant User Name: " + autoAttName);

		// Step 8. Give Auto Attendant ID For Auto Attendant User
		ptr.type(ProvisioningPages.autoAttID_Field, autoAttID, "Give the Auto Attendant User ID: " + autoAttID);

		// Step 9. Select Auto Attendant Type
		ptr.selectDropdownByValue(ProvisioningPages.autoAtt_Type, autoAttType,
				"Selecting the Auto Attendant Type : " + autoAttType);


		// Step 11. Select Department
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Department, autoAtt_Department,
				"Selecting the Auto Attendant Department : " + autoAtt_Department);

		// Step 12. Select Phone Number
		ptr.selectDropdownByValue(ProvisioningPages.dropdown_Phonenumber, autoAtt_PhoneNumber,
				"Selecting the Auto Attendant PhoneNumber : " + autoAtt_PhoneNumber);

		// Step 13. Validate For Activated is Enabled
		ptr.selectRadioButton("Activated");

		// Step 14. Give Extension
		ptr.type(ProvisioningPages.extension_Number, extension, "Give the Auto Attendant User ID: " + extension);

		// Step 15. Validate For Activated is Enabled
//		ptr.selectDropdownByValue(ProvisioningPages.autoAtt_NetworkServerSite, autoAtt_NetworkServerSite,
//				"Selecting the Auto Attendant Department : " + autoAtt_NetworkServerSite);

		// Step 16. Give LastName For Auto Attendant Calling Line ID
		ptr.type(ProvisioningPages.autoAtt_LastName, callingLineLastname,
				"Give the Auto Attendant User ID: " + callingLineLastname);

		// Step 17. Give FirstName For Auto Attendant Calling Line ID
		ptr.type(ProvisioningPages.autoAtt_FirstName, callingLineFirstname,
				"Give the Auto Attendant User ID: " + callingLineFirstname);

		// Step 18. click on OK Button
		ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on link: OK");

		// Step 24. Validate For Virtual User Presence
		// WebElement AutoAttNameLink =
		// driver.findElement(By.xpath("//span[text()='"+autoAttName+"']"));
		// AutoAttNameLink.isDisplayed();

		// Step 19. click on OK Button
		ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on link: OK");

		ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on link: OK");

		return true;

	}
	/*
	 * Adding Steps For Delete Auto Attendant User
	 * 
	 */

	public boolean DeleteAutoAttendantUser(String strEnterprise, String strGroup, String autoAttName,
			String searchQuery, String searchComparison) throws IOException, InterruptedException {

		// STEPS FOR DELETING AUTOATTENDANT USER

		// Step 1. Select Enterprise
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
				"Selecting an Enterprise : " + strEnterprise);

		// Step 2. Validating Auto Attendant Screen Displayed
		ptr.isElementPresent(ProvisioningPages.autoAttendant_Screen, "Validating: Auto Attendant page Displayed");

		// Step 3. Select Group
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group, strGroup, "Selecting the Group : " + strGroup);

		// Step 4. Validating Auto Attendant Screen Displayed
		ptr.isElementPresent(ProvisioningPages.autoAttendant_Screen, "Validating: Auto Attendant page Displayed");

		// Step 5. Select SearchQuery
		ptr.selectDropdownByValue(ProvisioningPages.autoAtt_SearchQuery, searchQuery,
				"Selecting the Group : " + searchQuery);

		// Step 6. Select searchComparison
		ptr.selectDropdownByValue(ProvisioningPages.autoAtt_SearchComparison, searchComparison,
				"Selecting the Group : " + searchComparison);

		// Step 7.Give Search Value
		ptr.type(ProvisioningPages.autoAtt_SearchValue, autoAttName, "Give Search Value : " + autoAttName);

		// Step 8. Click On Search Button
		ptr.click(OpeasyCommonPageElements.btn_VirtualUsersSearch, "Clicking on link: Search");

		// Step 9. Validating Attendant Number Presence
		WebElement AutoAttNameLink = driver.findElement(By.xpath("//span[text()='" + autoAttName + "']"));
		AutoAttNameLink.isDisplayed();

		// Step 10. Click On Edit to Corresponding User
		driver.findElement(By.xpath("//span[text()='" + autoAttName + "']/../../../td[9]/span/a")).click();

		// Step 11. Wait For Modify Page
		ptr.waitForElementPresent(ProvisioningPages.autoAtt_ModifyScreens, 20);

		// Step 12. click on Delete link
		ptr.click(OpeasyCommonPageElements.btn_Delete, "Click button Delete");
		ptr.alertAccept();
		return true;

	}

	/*
	 * Adding Steps For Add Hunt Group User
	 * 
	 */

	public boolean CreateHuntGroupUser(String strEnterprise, String strGroup, String autoAttName, String autoAttID,
			String autoAttType, String autoAtt_Department, String autoAtt_PhoneNumber, String extension,
			String autoAtt_NetworkServerSite, String callingLineLastname, String callingLineFirstname)
			throws IOException, InterruptedException {

		// STEPS FOR ADDING HUNT GROUP USER

		// Step 1. Select Enterprise
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
				"Selecting an Enterprise : " + strEnterprise);

		// Step 2. Validating Hunt Group Screen Displayed
		ptr.isElementPresent(ProvisioningPages.huntGroup_Screen, "Validating: Hunt Group page Displayed");

		// Step 3. Select Group
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group, strGroup, "Selecting the Group : " + strGroup);

		// Step 4. Validating Hunt Group Screen Displayed
		ptr.isElementPresent(ProvisioningPages.huntGroup_Screen, "Validating: Hunt Group page Displayed");

		ptr.click(OpeasyCommonPageElements.btn_VirtualUsersSearch, "Click on button Search");

		// Search if user is already added
		try {
			// Step 9. Validating HuntGroup
			WebElement eleAutoAttNameLink = driver.findElement(By.xpath("//span[text()='" + autoAttName + "']"));
			if (eleAutoAttNameLink != null) {
				ptr.updateStep("HuntGroup user is already added: " + autoAttName, "Pass");
			}

			ptr.click(OpeasyCommonPageElements.btn_OK, "Press OK button");

			return true;

		} catch (org.openqa.selenium.NoSuchElementException e) {
			ptr.updateStep("FlexiHost user is nod present, adding : " + autoAttName, "Pass");
		}

		// Step 5. Click on Add Button
		ptr.click(OpeasyCommonPageElements.btn_Add, "Click On Add User Button");

		// Step 6. Validating Hunt Group Add Screen
		ptr.isElementPresent(ProvisioningPages.huntGrpAdd_Screen, "Validating: Hunt Group screen Is Displayed");

		// Step 7. Give Name For Hunt Group User
		ptr.type(ProvisioningPages.huntGrpName_Field, autoAttName, "Give the Hunt Group User Name: " + autoAttName);

		// Step 8. Give Hunt Group ID For Hunt Group User
		ptr.type(ProvisioningPages.huntGrpID_Field, autoAttID, "Give the Hunt Group User ID: " + autoAttID);

		// Step 9. Select Hunt Group Type
		// ptr.selectDropdownByValue(ProvisioningPages.autoAtt_Type,
		// autoAttType, "Selecting the Hunt Group Type : " +autoAttType);

		// Step 10. Wait for Hunt Group Add element
		ptr.waitForElementPresent(ProvisioningPages.huntGrpAdd_Screen, 20);

		// Step 11. Select Department For Hunt Group
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Department, autoAtt_Department,
				"Selecting the Hunt Group Department : " + autoAtt_Department);
		
		//Select AttendantType as Basic
//		ptr.selectDropdownByValue(ProvisioningPages.dropdown_AttendantType, "Basic", "Selecting AttendantType as Basic");

		// Step 12. Select Phone Number For Hunt Group
		ptr.selectDropdownByValue(ProvisioningPages.dropdown_Phonenumber, autoAtt_PhoneNumber,
				"Selecting the Hunt Group PhoneNumber : " + autoAtt_PhoneNumber);

		// Step 13. Validate For Activated is Enabled
		ptr.isElementPresent(ProvisioningPages.activated_Button, "Validating: Activated is Present ");

		// Step 14. Give Extension
		ptr.type(ProvisioningPages.extension_Number, extension, "Give the Auto Attendant User ID: " + extension);

		// Step 15. Validate For Activated is Enabled
		ptr.selectDropdownByValue(ProvisioningPages.autoAtt_NetworkServerSite, autoAtt_NetworkServerSite,
				"Selecting the Hunt Group Department : " + autoAtt_NetworkServerSite);

		// Step 16. Give LastName For Hunt Group Calling Line ID
		ptr.type(ProvisioningPages.huntGrp_LastName, callingLineLastname,
				"Give the Hunt Group User ID: " + callingLineLastname);

		// Step 17. Give FirstName For Hunt Group Calling Line ID
		ptr.type(ProvisioningPages.huntGrp_FirstName, callingLineFirstname,
				"Give the Hunt Group User ID: " + callingLineFirstname);

		// Step 18. click on OK Button
		ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on link: OK");

		// Step 19. click on OK Button
		ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on link: OK");

		// Step 19. click on OK Button
		ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on link: OK");

		return true;

	}
	/*
	 * Adding Steps For Delete Hunt Group User
	 * 
	 */

	public boolean DeleteHuntGroupUser(String strEnterprise, String strGroup, String autoAttName,
			String huntsearchQuery, String huntsearchOption) throws IOException, InterruptedException {

		// STEPS FOR DELETING AUTOATTENDANT USER

		// Step 1. Select Enterprise
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
				"Selecting an Enterprise : " + strEnterprise);

		// Step 2. Validating Hunt Group Screen Displayed
		ptr.isElementPresent(ProvisioningPages.huntGroup_Screen, "Validating: Hunt Group page Displayed");

		// Step 3. Select Group
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group, strGroup, "Selecting the Group : " + strGroup);

		// Step 4. Validating Hunt Group Screen Displayed
		ptr.isElementPresent(ProvisioningPages.huntGroup_Screen, "Validating: Hunt Group page Displayed");

		// Step 5. Select SearchQuery
		ptr.selectDropdownByValue(ProvisioningPages.huntGrp_SearchQuery, huntsearchQuery,
				"Selecting the Group : " + huntsearchQuery);

		// Step 6. Select searchComparison
		ptr.selectDropdownByValue(ProvisioningPages.huntGrp_SearchOption, huntsearchOption,
				"Selecting the Group : " + huntsearchOption);

		// Step 7.Give Search Value
		ptr.type(ProvisioningPages.huntGrp_SearchValue, autoAttName, "Give Search Value : " + autoAttName);

		// Step 11. Wait For Modify Page
		ptr.waitForElementPresent(ProvisioningPages.huntGroup_Screen, 20);

		// Step 8. Click On Search Button
		ptr.click(OpeasyCommonPageElements.btn_VirtualUsersSearch, "Clicking on link: Search");

		// Step 9. Validating Hunt Group Number Presence
		WebElement AutoAttNameLink = driver.findElement(By.xpath("//span[text()='" + autoAttName + "']"));
		AutoAttNameLink.isDisplayed();

		// Step 10. Click On Edit to Corresponding User
		driver.findElement(By.xpath("//span[text()='" + autoAttName + "']/../../../td[8]/span/a")).click();

		// Step 11. Wait For Modify Page
		ptr.waitForElementPresent(ProvisioningPages.huntGrp_ModifyScreen, 20);

		// Step 12. click on Delete link
		ptr.click(OpeasyCommonPageElements.btn_Delete, "Click button Delete");
		ptr.alertAccept();

		return true;

	}

	/*
	 * Adding Steps For Add Flex Seating Host User
	 * 
	 */

	public boolean CreateFlexSeatingHostUser(String strEnterprise, String strGroup, String autoAttName,
			String autoAttID, String autoAttType, String autoAtt_Department, String autoAtt_PhoneNumber,
			String extension, String autoAtt_NetworkServerSite, String callingLineLastname, String callingLineFirstname)
			throws IOException, InterruptedException {

		// STEPS FOR ADDING Flexible Seating Host USER

		// Step 1. Select Enterprise
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
				"Selecting an Enterprise : " + strEnterprise);

		// Step 2. Validating Flexible Seating Host Screen Displayed
		ptr.isElementPresent(ProvisioningPages.flexibleSeatingHost_Screen,
				"Validating: Flexible Seating Host page Displayed");

		// Step 3. Select Group
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group, strGroup, "Selecting the Group : " + strGroup);

		// Step 4. Validating Flexible Seating Host Screen Displayed
		ptr.isElementPresent(ProvisioningPages.flexibleSeatingHost_Screen,
				"Validating: Flexible Seating Host page Displayed");

		// Click Search button
		ptr.click(ProvisioningPages.flexibleHost_Search, "Click button Search");

		// Search if user is already added
		try {
			// Step 9. Validating Flexible Seating Host Number Presence
			WebElement eleAutoAttNameLink = driver.findElement(By.xpath("//span[text()='" + autoAttName + "']"));
			if (eleAutoAttNameLink != null) {
				ptr.updateStep("FlexiHost user is already added: " + autoAttName, "Pass");
			}

			ptr.click(OpeasyCommonPageElements.btn_OK, "Press OK button");

			return true;

			// Step 10. Click On Edit to Corresponding User
			// driver.findElement(By.xpath("//span[text()='" + autoAttName +
			// "']/../../../td[8]/span/a")).click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			ptr.updateStep("FlexiHost user is nod present, adding : " + autoAttName, "Pass");
		}

		// Step 5. Click on Add Button
		ptr.click(OpeasyCommonPageElements.btn_Add, "Click On Add User Button");

		// Step 6. Validating Flexible Seating Host Add Screen
		ptr.isElementPresent(ProvisioningPages.flexSeatingHostAdd_Screen,
				"Validating: Flexible Seating Host screen Is Displayed");

		// Step 7. Give Name For Flexible Seating Host User
		ptr.type(ProvisioningPages.flexSeatingHost_Name, autoAttName, "Give the Hunt Group User Name: " + autoAttName);

		// Step 8. Give Hunt Group ID For Flexible Seating Host User
		ptr.type(ProvisioningPages.flexSeatingHost_ID, autoAttID,
				"Give the Flexible Seating Host User ID: " + autoAttID);

		// Step 9. Select Hunt Group Type
		// ptr.selectDropdownByValue(ProvisioningPages.autoAtt_Type,
		// autoAttType, "Selecting the Flexible Seating HostType : "
		// +autoAttType);

		// Step 10. Wait for Hunt Group Add element
		ptr.waitForElementPresent(ProvisioningPages.flexSeatingHostAdd_Screen, 20);

		// Step 11. Select Department For Flexible Seating Host
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Department, autoAtt_Department,
				"Selecting the Flexible Seating Host Department : " + autoAtt_Department);

		// Step 12. Select Phone Number For Flexible Seating Host
		ptr.selectDropdownByValue(ProvisioningPages.dropdown_Phonenumber, autoAtt_PhoneNumber,
				"Selecting the Flexible Seating Host PhoneNumber : " + autoAtt_PhoneNumber);

		// Step 13. Validate For Activated is Enabled
		ptr.isElementPresent(ProvisioningPages.activated_Button, "Validating: Activated is Present ");

		// Step 14. Give Extension
		ptr.type(ProvisioningPages.extension_Number, extension, "Give the Auto Attendant User ID: " + extension);

		// Step 15. Validate For Activated is Enabled
		ptr.selectDropdownByValue(ProvisioningPages.autoAtt_NetworkServerSite, autoAtt_NetworkServerSite,
				"Selecting the Flexible Seating Host Department : " + autoAtt_NetworkServerSite);

		// Step 16. Give LastName For Hunt Group Calling Line ID
		ptr.type(ProvisioningPages.calling_Line_Lastname, callingLineLastname,
				"Give the Hunt Group User ID: " + callingLineLastname);

		// Step 17. Give FirstName For Flexible Seating Host Calling Line ID
		ptr.type(ProvisioningPages.calling_Line_Firstname, callingLineFirstname,
				"Give the Flexible Seating Host User ID: " + callingLineFirstname);

		// Step 18. click on OK Button
		ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on link: OK");

		// Step 19. click on OK Button
		ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on link: OK");

		// Step 19. click on OK Button
		ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on link: OK");

		return true;

	}
	/*
	 * Adding Steps For Delete Flex Seating Host User
	 * 
	 */

	public boolean DeleteFlexSeatingHostUser(String strEnterprise, String strGroup, String autoAttName,
			String flexHostsearchQuery, String flexHostsearchOption) throws IOException, InterruptedException {

		// STEPS FOR DELETING AUTOATTENDANT USER

		// Step 1. Select Enterprise
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
				"Selecting an Enterprise : " + strEnterprise);

		// Step 2. Validating Flexible Seating Host Screen Displayed
		ptr.isElementPresent(ProvisioningPages.flexibleSeatingHost_Screen,
				"Validating: Flexible Seating Host page Displayed");

		// Step 3. Select Group
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group, strGroup, "Selecting the Group : " + strGroup);

		// Step 4. Validating Flexible Seating Host Screen Displayed
		ptr.isElementPresent(ProvisioningPages.flexibleSeatingHost_Screen,
				"Validating: Flexible Seating Host page Displayed");

		// Step 5. Select SearchQuery
		ptr.selectDropdownByValue(ProvisioningPages.flexSeatingHost_SearchQuery, flexHostsearchQuery,
				"Selecting the Query : " + flexHostsearchQuery);

		// Step 6. Select searchComparison
		ptr.selectDropdownByVisibleText(ProvisioningPages.flexSeatingHost_SearchOption, flexHostsearchOption,
				"Selecting the Option : " + flexHostsearchOption);

		// Step 7.Give Search Value
		ptr.type(ProvisioningPages.flexSeatingHost_SearchValue, autoAttName, "Give Search Value : " + autoAttName);

		// Step 8. Click On Search Button
		ptr.click(OpeasyCommonPageElements.btn_VirtualUsersSearch, "Clicking on link: Search");

		// Step 9. Validating Flexible Seating Host Number Presence
		WebElement AutoAttNameLink = driver.findElement(By.xpath("//span[text()='" + autoAttName + "']"));
		AutoAttNameLink.isDisplayed();

		// Step 10. Click On Edit to Corresponding User
		driver.findElement(By.xpath("//span[text()='" + autoAttName + "']/../../../td[8]/span/a")).click();

		// Step 11. Wait For Modify Page
		ptr.waitForElementPresent(ProvisioningPages.flexHost_ModifyScreen, 20);

		// Step 12. click on Delete link
		ptr.click(OpeasyCommonPageElements.btn_Delete, "Click button Delete");
		ptr.alertAccept();

		return true;

	}

	/*
	 * Adding Going to Services Tab In Clearspan
	 * 
	 */

	public void goToServicesTabInClearspan(String clearspanUrl, String clearspanUserName, String clearspanPassword,
			String strEnt, String strGroup, String findKey1, String findOption1, String findKey2,
			String findOption2) throws IOException, InterruptedException {

		// Step 1. Login to ClearSpan
		clearspanCommon.loginToClearspan(clearspanUrl, clearspanUserName, clearspanPassword);

		// Step 2. click on Enterprise link
		ptr.click(ClearspanHomePage.enterprise_Link, "Clicking on link: Enterprise");

		// Step 3. Validating Enterprise Screen
		ptr.isElementPresent(ClearspanHomePage.enterprise_Screen, "Validating:Enterprise screen Displayed");

		// Step 4. Select Find Key
	//	ptr.selectDropdownByValue(ClearspanHomePage.dropdown_Findkey, findKey1, "Selecting the Key : " + findKey1, true);

		// Step 6. Select Find Option
		ptr.type(ClearspanHomePage.finding_Text, strEnt,
				"Give text to search For Enterprise : " + strEnt);

		// Step 7. click on Search Button
		ptr.click(ClearspanHomePage.search_Button, "Clicking on Button: Search");

		// Step 7. click on Enterprise
		driver.findElement(By.xpath("//a[contains(.,'"+strEnt+"')]")).click();
	//	driver.findElement(By.linkText("Mitel India Lab")).click();

		// Step 8. Wait for element to be present
		ptr.waitForElementPresent(ClearspanHomePage.group_Link, 10);

		// Step 2. click on Group link
		ptr.click(ClearspanHomePage.group_Link, "Clicking on link: Group");

		// Step 3. Validating Group Screen
		ptr.isElementPresent(ClearspanHomePage.group_Screen, "Validating:Group screen Displayed");

		// Step 4. Select Find Key
		ptr.selectDropdownByValue(ClearspanHomePage.dropdown_Findkey, findKey2, "Selecting the Key : " + findKey2, true);

//		// Step 5. Select Find Option
//		ptr.selectDropdownByValue(ClearspanHomePage.dropdown_FindOption, findOption2,
//				"Selecting the Option : " + findOption2, true);

		// Step 6. Select Find Option
		ptr.type(ClearspanHomePage.finding_Text, strGroup, "Give text to search : " + strGroup);

		// Step 7. click on Search Button
		ptr.click(ClearspanHomePage.search_Button, "Clicking on Button: Search");

		// Step 7. click on Group
		driver.findElement(By.linkText("" + strGroup + "")).click();

		// Step 12. click on Services Link
		ptr.click(ClearspanHomePage.services_Link, "Clicking on Link: Services");

	}

	/*
	 * Going To Auto Attendant In Clearspan
	 * 
	 */

	public void goToAutoAttendantInClearspan() throws IOException, InterruptedException {

		// Step 13. click on Auto Attendant Link
		ptr.click(ClearspanHomePage.autoAttendant_Link, "Clicking on Link: Auto Attendant");

	}

	/*
	 * Going To Hunt Group In Clearspan
	 * 
	 */

	public void goToHuntGroupInClearspan() throws IOException, InterruptedException {

		/// Step 13. click on Hunt Group Link
		ptr.click(ClearspanHomePage.huntGroup_Link, "Clicking on Link: Hunt Group");
	}

	/*
	 * Going To Flexible Seating Host In Clearspan
	 * 
	 */

	public void goToFlexibleSeatingHostInClearspan() throws IOException, InterruptedException {

		// Step 13. click on Flexible Seating Host Link
		ptr.click(ClearspanHomePage.flexibleSeatingHost_Link, "Clicking on Link: Hunt Group");

	}

}
