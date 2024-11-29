/**************************************************
#Project Name: MiTEL_CLEARSPAN � Opeasy Automation

#Test case Name: LoginManagement_PhoneTemplatesDisplayTemplate_Test()
#Description:1. This test case is combination of verifing 'Display Template', 'Edit Template', 'Delete Template', 'Select Template in se' testcases on Login Management
#Input Parameters: 
#Owner: Virupakshayya Kulkarni
#Author: Payal Gouda
#Date of creation: 20-Jan-18
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/

package pomTestApps.Test.com.automation.tvsmotor.dai;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pomTestApps.STAcore.DAICommon;
import pomTestApps.STAcore.Operations;
import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.ClearspanHomePage;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyCommonPageElements;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyHomePage;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.ProvisioningPages;

public class ProvisioningDeleteBasicUserUsingGUI_Test extends BaseClass {

	POMSuiteRunner POMSuiteRunner = new POMSuiteRunner();
	Operations oprs = new Operations();

	public static Hashtable<String, String> hashTable = new Hashtable<String, String>();
	public DAICommon clearspanCommon;
	public ProvisioningPages provisioningpages;

	@Test(dataProvider = DP)
	public void DeleteUserUsingGUI(String Browser, String clearspanUrl, String opeasyUrl, String OpeasyUsername,
			String OpeasyPassword, String clearspanUserName, String clearspanPassword, String strEnterprise,
			String strGroup, String userProfile, String lastName, String firstName, String phoneNum,
			String userPassword, String findKey, String findOpt, String searchCriteria, String searchFragment

	) throws Exception {

		clearspanCommon = new DAICommon(driver, ptr);

		clearspanCommon.navigateOpeasyHomePage();
		clearspanCommon.navigateProvisioningPage();
		clearspanCommon.navigateClearspanHomePage();

		String strOpeasy_WO_SA_Username = POMSuiteRunner.ConfigStore.get("Opeasy_WO_SA_Username");
		String strOpeasy_WO_SA_Password = POMSuiteRunner.ConfigStore.get("Opeasy_WO_SA_Password");

		String strTestCaseName = "Delete User/Devices - Delete Basic Users from GUI";

		try {

//			// SETUP
//			// Delete User if already present
			clearspanCommon.opeasyClearLoginSessions(opeasyUrl, strOpeasy_WO_SA_Username, strOpeasy_WO_SA_Password);
			
//			if (clearspanCommon.deviceExists("SU", strEnterprise, strGroup, "User: Phone Number", phoneNum)) {
//				clearspanCommon.deleteDeviceThatExists(phoneNum);
//			}

			ptr.click(OpeasyHomePage.link_HeaderProvisioning, "Click link - Provisioning");
			ptr.wait(3000);
			
			//Delete User if already present
			if (clearspanCommon.userExists("SA", strEnterprise, strGroup, "User: Phone Number (Primary)", phoneNum)) {
				clearspanCommon.deleteUserThatExists(phoneNum);
			}
			
			// Steps To Create Basic User
			// Step 5. Click on Add User Button.
			ptr.click(OpeasyCommonPageElements.btn_Add, "Click On Add Button");

			// Step 6. Validate User Add is Displayed .
			ptr.isElementPresent(ProvisioningPages.basic_User_ScreenName, "Validating: Basic User Add Page Displayed");

			// Step 7. Select User Profile From Dropdown.
			ptr.selectDropdownByValue(ProvisioningPages.user_profile, userProfile,
					"Select User Profile From Dropdown: " + userProfile);

			// Step 8. Validate View Template is Enable .
			driver.findElement(By.id("form1:buttonViewTemplate")).isEnabled();

			// Step 9. Input LastName.
			ptr.type(ProvisioningPages.lastname_Clearspan_User, lastName, "Enter lastName->" + lastName);

			// Step 10. Input FirstName.
			ptr.type(ProvisioningPages.firstname_Clearspan_User, firstName, "Enter firstName->" + firstName);

			// Step 11. Select PhoneNumber.
			ptr.selectDropdownByValue(ProvisioningPages.phoneNumber_BasicUser, phoneNum,
					"Selecting the PhoneNumber : " + phoneNum);

			// Step 13. Input UserPassword.
			ptr.type(ProvisioningPages.userPassword_Clearspan_User, userPassword,
					"Enter UserPassword->" + userPassword);
			
			ptr.type(ProvisioningPages.text_UserconfirmpasswordBasicProv, userPassword,
					"Enter UserPassword->" + userPassword);
			
//			// Select No Voice Mail
////			ptr.selectDropdownByIndex(provisioningpages.dropDownVoiceMail_list, 0, "Selecting No Voice Mail");	
//			ptr.selectCheckBox("form1:checkboxUseOrgID", true);
//			ptr.wait(5000);
//			ptr.type(provisioningpages.txt_UserID, "1243", "Enter User ID");
			

			// Step 14. Click on OK Button To Create User.
			ptr.click(OpeasyCommonPageElements.btn_OK, "Click on Ok Button To Create User");
			
			if(clearspanCommon.userExists("SA", strEnterprise, strGroup, "User: Phone Number (Primary)", phoneNum)) {
				ptr.updateStep("USer created successfully: " + phoneNum, "Pass");
			} else {
				ptr.updateStep("User creation failed: " + phoneNum, "Fail");
			}

//			// Step 18. LogOut From OpEasy.
			clearspanCommon.logoutOpeasy();
//
//			// Validating User Present in ClearSpan After create in OpEasy
//
//			// Step 19. Validating in clearspan for user Existence.
//			goToUserSettingPageInClearspan(clearspanUrl, clearspanUserName, clearspanPassword, findKey, findOpt,
//					phoneNum);
//
//			// Step 20. Find User In List
//
//			// Step 8. Validating LastName displayed
//			String strDynXpath = ".//a[contains(., '" + lastName + "')]";
//			try{
//				driver.findElement(By.xpath(strDynXpath)).isDisplayed();
//				ptr.updateStep("User is listed in Clearspan successfully: " + lastName, "Pass");
//			} catch (NoSuchElementException ex) {
//				ptr.updateStep("User is not listed in Clearspan : " + lastName, "Fail");
//			}
//			
//			// Step 21. Logout From ClearSpan
//			clearspanCommon.logoutClearspan();
//
//			// Step 1.Go To Users Page In OpEasy
//			// Step 1. Login to OpEasy as a System Admin without Advanced
//			// Provisioning Privilege
			clearspanCommon.loginToOpeasy(opeasyUrl, strOpeasy_WO_SA_Username, strOpeasy_WO_SA_Password);

			ptr.click(OpeasyHomePage.link_HeaderProvisioning, "Click link Provisioning");
			
			// SEARCH AND DELETE THE USER CREATED IN OPEASY -GUI
			if (clearspanCommon.userExists("SA", strEnterprise, strGroup, "User ID / Alternate User ID", phoneNum)) {
				clearspanCommon.deleteUserThatExists(phoneNum);
			}
			
//			clearspanCommon.logoutOpeasy();
//
//			// Validating User Present in ClearSpan After create in OpEasy
//			goToUserSettingPageInClearspan(clearspanUrl, clearspanUserName, clearspanPassword, findKey, findOpt,
//					lastName);
//
//			// Step 31. Find User In List
//			try{
//				driver.findElement(By.xpath(strDynXpath)).isDisplayed();
//				ptr.updateStep("User is not deleted from Clearspan successfully: " + lastName, "Fail");
//			} catch (NoSuchElementException ex) {
//				ptr.updateStep("User is deleted from Clearspan successfully: " + lastName, "Pass");
//			}
//
//			// Step 32. Logout From ClearSpan
//			clearspanCommon.logoutClearspan();
//
//			// Step 33.Login to OpEasy
//			clearspanCommon.loginToOpeasy(opeasyUrl, strOpeasy_WO_SA_Username, strOpeasy_WO_SA_Password);
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
	 * Adding validating For User Existence In ClearSpan
	 * 
	 */
	public void goToUserSettingPageInClearspan(String clearspanUrl, String clearspanUserName, String clearspanPassword,
			String findKey, String findOpt, String lastName) throws IOException, InterruptedException {

		// Step 1. Login to ClearSpan
		clearspanCommon.loginToClearspan(clearspanUrl, clearspanUserName, clearspanPassword);

		// Step 2. click on Users link
		ptr.click(ClearspanHomePage.link_Users, "Clicking on link: Users");

		// Step 6. Type finding Text for user
		ptr.type(ClearspanHomePage.finding_Text, lastName, "Enter Last Name : " + lastName);

		// Step 7. Click on Search Button
		ptr.click(ClearspanHomePage.search_Button, "Click on Search Button");

	}

	// Delete the user.
	public void deleteuserInOpeasy(String Browser, String opeasyUrl, String OpeasyUsername, String OpeasyPassword,
			String lastName, String phoneNum) throws IOException, InterruptedException {

		// Step 10. Click On Edit.
		driver.findElement(By.xpath("//span[text()='" + lastName + "']")).click();

		try {
			// Step 11. Click on Delete Button To Delete User.
			ptr.click(ProvisioningPages.delete_Button, "Click on Delete Button To Delete User");

			// Step 12. Confirmation For Deleting User.
			ptr.alertAccept();

			// Step 24. Logout from OpEasy.
			clearspanCommon.logoutOpeasy();

			// Step 14. Login to Opeasy as super user
			clearspanCommon.loginToOpeasy(opeasyUrl, OpeasyUsername, OpeasyPassword);

			// Step 15. Select the Provisioning from main menu
			ptr.click(clearspanCommon.opeasyhome.link_Provisioning, "Clicking on link: Provisioning");

			// Step 16. Click on Phone Management link from provisioning.
			ptr.click(ProvisioningPages.phoneManagement_Link, "Clicking on link: Phone Management");

			// Step 17. Select Device name from drop down list
			ptr.selectDropdownByValue(ProvisioningPages.dropdown_SearchCriteriarRow1, "Device Name",
					"Select value from drop down list : Device Name");

			// Step 18. Select search criteria
			ptr.selectDropdownByValue(ProvisioningPages.dropdown_SearchConditionRow1, "Contains",
					"Select value from drop down list : Contains");

			// Step 19. Enter Phone number to search
			ptr.type(ProvisioningPages.text_SearchValueRow1, phoneNum, "Enter phone number to search : Phonenumber ");

			// Step 20. Select search button
			ptr.click(ProvisioningPages.btn_Search, "Enter search button");

			// Step 21. Click on edit link
			ptr.click(ProvisioningPages.Edit_link, "Click on link : Edit");

			ptr.click(OpeasyCommonPageElements.btn_Delete, "Click button Delete");
			ptr.alertAccept();
			
			// step 24. click on Apply button
			ptr.click(OpeasyCommonPageElements.btn_Apply, "Click on button : Apply");
		} catch (Exception exec1) {
			exec1.getStackTrace();
			ptr.updateStep("Not able to delete users ", "Fail");

		}
	}
}
