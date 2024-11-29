package pomTestApps.Test.com.automation.tvsmotor.dai;
/**************************************************
#Project Name: MiTEL_CLEARSPAN � Opeasy Automation

#Test case Name: ProvisioningGroupSettingsAuthorizationCodes_Test()
#Description:1. This test case is To Test Authorization Codes in Group setting
#Input Parameters: 
#Owner: Virupakshayya Kulkarni
#Author: Payal Gouda
#Date of creation: 21-Mar-18
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pomTestApps.STAcore.DAICommon;
import pomTestApps.STAcore.Operations;
import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyCommonPageElements;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyHomePage;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.ProvisioningPages;

public class ProvisioningGroupSettingsAuthorizationCodes_Test extends BaseClass {

	POMSuiteRunner POMSuiteRunner = new POMSuiteRunner();
	Operations oprs = new Operations();

	public static Hashtable<String, String> hashTable = new Hashtable<String, String>();
	public DAICommon clearspanCommon;

	@Test(dataProvider = DP)
	public void GroupSettingsAuthorizationCodes(String Browser, String clearspanUrl, String opeasyUrl,
			String OpeasyUsername, String OpeasyPassword, String clearspanUserName, String clearspanPassword,
			String strEnterprise, String strGroup, String authorizationCode, String description) throws Exception {

		clearspanCommon = new DAICommon(driver, ptr);

		clearspanCommon.navigateOpeasyHomePage();
		clearspanCommon.navigateProvisioningPage();

		String strOpeasy_SR_Username = pomTestApps.STAcore.POMSuiteRunner.ConfigStore.get("Opeasy_SR_Username");
		String strOpeasy_SR_Password = pomTestApps.STAcore.POMSuiteRunner.ConfigStore.get("Opeasy_SR_Password");

		String strTestCaseName = "ProvisioningGroupSettingsAuthorizationCodes_Test";

		try {

			// Step 1. Login to OpEasy as a Solution Reseller
			clearspanCommon.opeasyClearLoginSessions(opeasyUrl, strOpeasy_SR_Username, strOpeasy_SR_Password);

			// Step 2. Validate OpEasy HomePage displayed.
			ptr.isElementPresent(OpeasyHomePage.text_Opeasy_screenName, "Validating:Opeasy home page Displayed");

			// Step 3. click on Provisioning from Main menu.
			ptr.click(OpeasyHomePage.link_HeaderProvisioning, "Clicking on link Provisioning");

			// Step 4. Validate Provisioning link displayed.
		//	ptr.isElementPresent(OpeasyHomePage.Provisioning_Screen, "Validating:Provisioning page Displayed");

			// Step 5. Click on Group Setting link from provisioning.
			ptr.click(ProvisioningPages.groupSetting_Link, "Clicking on link: Group Setting");

			// Step 6. Validate Group Setting Screen is displayed.
		//	ptr.isElementPresent(ProvisioningPages.groupSetting_Screen, "Validating:Group Setting page is Displayed");

			// Step 7. Click On Authorization Codes.
			ptr.click(ProvisioningPages.link_AuthorizationCodes, "Clicking on link: Authorization Codes");

			// Step 8. Validate Authorization Codes Screen is displayed.
			ptr.isElementPresent(ProvisioningPages.screen_AuthorizationCodes,
					"Validating: Authorization Codes page is Displayed");

			// Step 9. Select Enterprise.
			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Selecting an Enterprise : " + strEnterprise);

			// Step 10. Validate Announcement Repository Screen is displayed.
			ptr.isElementPresent(ProvisioningPages.screen_AuthorizationCodes,
					"Validating: Authorization Codes page is Displayed");

			// Step 11. Select Enterprise.
			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group, strGroup,
					"Selecting an Enterprise : " + strGroup);

			// Deleet the existing Auth code if already exists
			try {
				String xpath = "//input[@value='0987654']//parent::td//parent::tr//a[contains(.,'Delete')]";
				driver.findElement(By.xpath(xpath)).click();
				ptr.alertAccept();
			} catch (NoSuchElementException e) {
				// Do nothing
			}

			// Step 12. Click On Add Button.
			ptr.click(ProvisioningPages.button_Add_AuthorizationCodes, "Clicking on link:  Add Authorization Codes");

			ptr.wait(5000);

			WebElement ele = driver.findElement(By.xpath("//*[@id='form1:tableAuthCodes:0:textFieldAuthCode']"));
			ptr.type(ele, "0987654", "Enter Auth code");

			ele = driver.findElement(By.xpath("//*[@id='form1:tableAuthCodes:0:textFieldDescription']"));
			ptr.type(ele, "Description", "Enter Description");

			ptr.click(OpeasyCommonPageElements.btn_Apply, "Click button OK");
			ptr.wait(3000);

			ele = driver.findElement(By.xpath("//*[@id='form1:staticTextScreenSavedMessage']"));
			ptr.waitForElementPresent(ele, 10);

			clearspanCommon.clickHtmlLinkElementIfAvailableOnPage("Delete", -1);
			ptr.wait(3000);
			ptr.alertAccept();

			ptr.click(OpeasyCommonPageElements.btn_OK, "Click button OK");

			// Step 17. Validate Group Setting Screen is displayed.
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
