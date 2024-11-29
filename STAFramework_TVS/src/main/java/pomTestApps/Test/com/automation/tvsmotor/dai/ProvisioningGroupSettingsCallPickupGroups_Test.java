package pomTestApps.Test.com.automation.tvsmotor.dai;
/**************************************************
#Project Name: MiTEL_CLEARSPAN � Opeasy Automation

#Test case Name: ProvisioningGroupSettingsCallPickupGroups_Test()
#Description:1. This test case is To creating Call Pick up group
#Input Parameters: 
#Owner: Virupakshayya Kulkarni
#Author: Payal Gouda
#Date of creation: 21-Mar-18
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pomTestApps.STAcore.DAICommon;
import pomTestApps.STAcore.Operations;
import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.ClearspanHomePage;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyCommonPageElements;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyHomePage;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.ProvisioningPages;

public class ProvisioningGroupSettingsCallPickupGroups_Test extends BaseClass {

	POMSuiteRunner POMSuiteRunner = new POMSuiteRunner();
	Operations oprs = new Operations();

	public static Hashtable<String, String> hashTable = new Hashtable<String, String>();
	public DAICommon clearspanCommon;

	@Test(dataProvider = DP)
	public void GroupSettingsCallPickupGroups(String Browser, String clearspanUrl, String opeasyUrl,
			String OpeasyUsername, String OpeasyPassword, String clearspanUserName, String clearspanPassword,
			
			String strEnterprise, String strGroup, String callPickupGroupName, String findKey1, String findOption1,
			String findKey2, String findOption2, String queryType, String queryComparison, String queryValue,
			String strAvlableUser

	) throws Exception {

		clearspanCommon = new DAICommon(driver, ptr);

		clearspanCommon.navigateOpeasyHomePage();
		clearspanCommon.navigateProvisioningPage();
		clearspanCommon.navigateClearspanHomePage();

		String strOpeasy_SR_Username = pomTestApps.STAcore.POMSuiteRunner.ConfigStore.get("Opeasy_SR_Username");
		String strOpeasy_SR_Password = pomTestApps.STAcore.POMSuiteRunner.ConfigStore.get("Opeasy_SR_Password");

		String strTestCaseName = "Group Settings - Call Pickup Groups";

		try {

			// Step 1. Login to OpEasy as a Solution Reseller
			clearspanCommon.loginToOpeasy(opeasyUrl, strOpeasy_SR_Username, strOpeasy_SR_Password);

			// Step 2. Validate OpEasy HomePage displayed.
			//ptr.isElementPresent(OpeasyHomePage.text_Opeasy_screenName, "Validating:Opeasy home page Displayed");

			// Step 3. go to Call Pickup Group in OpEasy
			goToCallPickupGroupInOpeasy(callPickupGroupName, strEnterprise, strGroup);

			// Step 4. Search For Call Pick Up Group
			try {
				driver.findElement(By.xpath("//span[text()='" + callPickupGroupName + "']")).isDisplayed();
				System.out.println("callPickupGroupName : " + callPickupGroupName);
				ptr.updateStep("Call PickUp Group already exists, deleting.", "Pass");
				
				String xpath = "//*[@id='form1:tableCallPickupGroups_data']//tr//span[contains(text(), '" + callPickupGroupName + "')]//..//..//a[text()='Edit']";
				driver.findElement(By.xpath(xpath)).click();
				ptr.click(OpeasyCommonPageElements.btn_Delete, "Delete");
				ptr.alertAccept();
				
			} catch (Exception exec) {
				exec.printStackTrace();
				ptr.updateStep("Call PickUp Group is Not Present Create Call PickUp Group", "Pass");
			}

			// Step 5. Validate Add Call Pickup Screen is displayed.
			ptr.isElementPresent(ProvisioningPages.screen_CallPickup_Group,
					"Validating: Add Call Pickup Group page is Displayed");

			// Step 6. Click On Add Button.
			ptr.click(OpeasyCommonPageElements.btn_Add, "Clicking on link:  Add Call PickUp Group");

			// Step 7. Give Call Pick Up Group Name
			ptr.type(ProvisioningPages.input_CallPickupGroup_Name, callPickupGroupName,
					"Give Call Pickup Group Name : " + callPickupGroupName);
			ptr.wait(2000);
			
			driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
			ptr.wait(2000);

			// Step 8. Click On OK Button.
		//	ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking OK");

			// Step 9. Adding user to Call Pickup Group
			String xpath = "//*[@id='form1:tableCallPickupGroups_data']//tr//span[contains(text(), '" + callPickupGroupName + "')]//..//..//a[text()='Edit']";
			driver.findElement(By.xpath(xpath)).click();
		
			ptr.click(OpeasyCommonPageElements.btn_Search, "Click button Search");
			ptr.wait(5000);
			
			Select oSel = new Select(driver.findElement(By.id("form1:listboxAvailableUsers")));
			if(oSel.isMultiple()){			
				oSel.selectByIndex(0);
				ptr.wait(3000);
				xpath = "//*[@id='form1:buttonUserAdd']/span";
				driver.findElement(By.xpath(xpath)).click();
				ptr.click(OpeasyCommonPageElements.btn_Apply, "Clicking Apply");
				
			}
			
			// Step 10. Remove user From Call Pickup Group
			oSel = new Select(driver.findElement(By.id("form1:listboxAssignedUsers")));
			if(oSel.isMultiple()){			
				oSel.selectByIndex(0);
				ptr.wait(3000);
				xpath = "//*[@id='form1:buttonUserRemove']/span";
				driver.findElement(By.xpath(xpath)).click();
				ptr.click(OpeasyCommonPageElements.btn_Apply, "Clicking Apply");
			}
			
			// Step 8. Click On OK Button.
			ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking OK");

			// Step 11. Logout From Opeasy.
			clearspanCommon.logoutOpeasy();

			// Step 12. Go to Clearspan and Check for Call Pickup Group.
			goToCallPickupGroupInClearspan(clearspanUrl, clearspanUserName, clearspanPassword, strEnterprise, strGroup,
					findKey1, findOption1, findKey2, findOption2);

			try {
				driver.findElement(By.linkText("" + callPickupGroupName + "")).isDisplayed();
				ptr.updateStep("Call PickUp Group is Present in clearspan", "Pass");
			} catch (Exception exec) {
				exec.printStackTrace();
				ptr.updateStep("Call PickUp Group is Not Present in clearspan", "Fail");
			}

			// Step 13. Logout from Clearspan
			clearspanCommon.logoutClearspan();

			// Step 1. Login to OpEasy as a Solution Reseller
			clearspanCommon.loginToOpeasy(opeasyUrl, strOpeasy_SR_Username, strOpeasy_SR_Password);
			
			goToCallPickupGroupInOpeasy(callPickupGroupName, strEnterprise, strGroup);

			// Step 4. Search For Call Pick Up Group
			try {
				driver.findElement(By.xpath("//span[text()='" + callPickupGroupName + "']")).isDisplayed();
				System.out.println("callPickupGroupName : " + callPickupGroupName);
				ptr.updateStep("Call PickUp Group already exists, deleting.", "Pass");
				
				String xpath1 = "//*[@id='form1:tableCallPickupGroups_data']//tr//span[contains(text(), '" + callPickupGroupName + "')]//..//..//a[text()='Edit']";
				driver.findElement(By.xpath(xpath1)).click();
				ptr.click(OpeasyCommonPageElements.btn_Delete, "Delete");
				ptr.alertAccept();
				
			} catch (Exception exec) {
				exec.printStackTrace();
				ptr.updateStep("Call PickUp Group is Not Present Create Call PickUp Group", "Pass");
			}

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
	 * Adding Going to Call Pickup Group In Clearspan
	 * 
	 */

	public void goToCallPickupGroupInClearspan(String clearspanUrl, String clearspanUserName, String clearspanPassword,
			String strEnterprise, String strGroup, String findKey1, String findOption1, String findKey2,
			String findOption2) throws IOException, InterruptedException {

		// Step 1. Login to ClearSpan
		clearspanCommon.loginToClearspan(clearspanUrl, clearspanUserName, clearspanPassword);

		// Step 2. click on Enterprise link
		ptr.click(ClearspanHomePage.enterprise_Link, "Clicking on link: Enterprise");

		// Step 3. Validating Enterprise Screen
		ptr.isElementPresent(ClearspanHomePage.enterprise_Screen, "Validating:Enterprise screen Displayed");

		// Step 4. Select Find Key
		ptr.selectDropdownByValue(ClearspanHomePage.dropdown_Findkey, findKey1, "Selecting the Key : " + findKey1, true);

		// Step 6. Select Find Option
		ptr.type(ClearspanHomePage.finding_Text, strEnterprise,
				"Give text to search For Enterprise : " + strEnterprise);

		// Step 7. click on Search Button
		ptr.click(ClearspanHomePage.search_Button, "Clicking on Button: Search");

		// Step 8. click on Enterprise
		driver.findElement(By.xpath("//a[contains(.,'" +strEnterprise + "')]")).click();
		ptr.wait(2000);

		// Step 9. Wait for element to be present
		ptr.waitForElementPresent(ClearspanHomePage.group_Link, 10);

		// Step 10. click on Group link
		ptr.click(ClearspanHomePage.group_Link, "Clicking on link: Group");

		// Step 11. Validating Group Screen
		ptr.isElementPresent(ClearspanHomePage.group_Screen, "Validating:Group screen Displayed");

		// Step 12. Select Find Key
		ptr.selectDropdownByValue(ClearspanHomePage.dropdown_Findkey, findKey2, "Selecting the Key : " + findKey2, true);

		// Step 14. Select Find Option
		ptr.type(ClearspanHomePage.finding_Text, strGroup, "Give text to search : " + strGroup);

		// Step 15. click on Search Button
		ptr.click(ClearspanHomePage.search_Button, "Clicking on Button: Search");

		// Step 16. click on Group
		driver.findElement(By.linkText("" + strGroup + "")).click();

		// Step 17. click on Services Link
		ptr.click(ClearspanHomePage.services_Link, "Clicking on Link: Services");

		// Step 18. click on Services Link
		ptr.click(ClearspanHomePage.link_CallPickup, "Clicking on Link: Call Pickup");

	}



	public void goToCallPickupGroupInOpeasy(String callPickupGroupName, String strEnterprise, String strGroup

	) throws IOException, InterruptedException {

		// Step 1. click on Provisioning from Main menu.
		ptr.click(OpeasyHomePage.link_Provisioning, "Clicking on link: Provisioning");

		// Step 2. Validate Provisioning link displayed.
		clearspanCommon.verifyScreenTitleProvPage("Provisioning");
	
		// Step 3. Click on Group Setting link from provisioning.
		ptr.click(ProvisioningPages.groupSetting_Link, "Clicking on link: Group Setting");

		// Step 4. Validate Group Setting Screen is displayed.
		clearspanCommon.verifyScreenTitleProvPage("Group Settings");
		
		// Step 5. Click On Call Pickup group.
		ptr.click(ProvisioningPages.link_CallPickup_Group, "Clicking on link: Call Pickup Group");

		// Step 6. Validate Call Pickup group Screen is displayed.
		clearspanCommon.verifyScreenTitleProvPage("Call Pickup Groups");
	
		// Step 7. Select Enterprise.
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
				"Selecting an Enterprise : " + strEnterprise);

		// Step 8. Validate Call Pickup group Screen is displayed.
		//ptr.isElementPresent(ProvisioningPages.screen_CallPickup_Group,"Validating: Authorization Codes page is Displayed");

		// Step 9. Select Group.
		ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group, strGroup, "Selecting Group : " + strGroup);
	}

}
