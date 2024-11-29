/**************************************************
#Project Name: MiTEL_CLEARSPAN � Opeasy Automation

#Test case Name: System Admin -Enterprise Settings - Basic Provisioning - Add User and Device from GUI()
#Description:1.  This test case verifies Basic Provisioning - Add User and Device from GUI
#Input Parameters: 
#Owner: Virupakshayya Kulkarni
#Author: Sakti Prasad pattnaik
#Date of creation: 28-Feb-18
#Name of person modifying: (Tester Name): Hameetha Banu
#Date of modification: 
‘**************************************************/

package pomTestApps.Test.com.automation.tvsmotor.dai;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pomTestApps.STAcore.DAICommon;
import pomTestApps.STAcore.Operations;
import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyCommonPageElements;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyHomePage;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.PhoneManagementPages;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.ProvisioningPages;

public class Users_PhoneDevice_Add_Test extends BaseClass {
	POMSuiteRunner POMSuiteRunner = new POMSuiteRunner();
	Operations oprs = new Operations();

	public static Hashtable<String, String> hashTable = new Hashtable<String, String>();
	public DAICommon clearspanCommon;

	@Test(dataProvider = DP)
	public void BasicProvisioningAddUserandDevicefromGUI(

			String Browser, String clearspanUrl, String opeasyUrl, String OpeasyUsername, String OpeasyPassword,
			String clearspanUserName, String clearspanPassword, String strEnterprise, String strGroup,
			String strDeviceSearch, String strUserName, String strdeviceName, String strDeviceType, String strTemplate,
			String strMACAddress

	) throws Exception {

		clearspanCommon = new DAICommon(driver, ptr);

		clearspanCommon.navigateOpeasyHomePage();
		clearspanCommon.navigateProvisioningPage();
		clearspanCommon.navigateClearspanHomePage();
		clearspanCommon.navigatePhoneManagementPage();

		String strTestCaseName = "Users Phone Device add test case";

		try {

			// Step 1. Login to OpEasy as Super User
			clearspanCommon.opeasyClearLoginSessions(opeasyUrl, OpeasyUsername, OpeasyPassword);

			// Step 2. Select the Provisioning from main menu
			ptr.click(OpeasyHomePage.link_HeaderProvisioning, "Clicking on link Provisioning");

			// Step 3. Provisioning page is displayed
			clearspanCommon.verifyScreenTitleProvPage("Provisioning");

			// Step 4. Click on link User
			ptr.click(ProvisioningPages.Users_Link, "Clicking on link: Users");

			// Step 5. Select Enterprise from drop down
			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Selecting an Enterprise : " + strEnterprise);
			ptr.wait(4000);

			// Step 6. Select Group from drop down
			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group, strGroup,
					"Selecting the Group : " + strGroup);
			ptr.wait(4000);

			// Step 7. select search criteria from drop down
			ptr.selectDropdownByValue(PhoneManagementPages.dropdown_DeviceSearch, strDeviceSearch,
					"Selecting Device Search from drop down: " + strDeviceSearch);
			ptr.wait(4000);
			// Step 8. Enter Last name of the User
			ptr.type(PhoneManagementPages.text_box, strUserName, "Enter Device Name : " + strUserName);

			// Step 19. Click Search button
			driver.findElement(By.xpath("(//span[contains(.,'Search')])[2]")).click();
			
			//ptr.click(OpeasyCommonPageElements.btn_Search, "Clicking on Search button");

			// Step 20. cLick on User to edit
			ptr.click(PhoneManagementPages.text_searchdevice, "Clicking on btn OK");

			// step 21. Verify Advanced User Modify page is displayed.
			clearspanCommon.verifyScreenTitleProvPage("Advanced: User Modify");
			
			// Step 22. Click on Phones tab
			ptr.click(PhoneManagementPages.btn_Phones, "Clicking on Phonoes Tab");

			try {
				driver.findElement(By.xpath("(//span[contains(.,'TestAuto')])[2]")).click();
				ptr.wait(4000);

				// Step 28. Click on Delete button
				ptr.click(OpeasyCommonPageElements.btn_Delete, "Clicking on Delete Button");

				// Step 29. Accept alert
				ptr.alertAccept();
				ptr.wait(4000);
			} catch (Exception exec) {
				ptr.updateStep("Device is not present. Add Device ", "Pass");

			}
			// Step 23. Click Add Primary Phone button
			ptr.click(ProvisioningPages.add_Primary_Phone, "Clicking on Add Primary Phones Tab");

			// Step 24. Enter Device Name
			ptr.type(ProvisioningPages.device_Name, strdeviceName, "Enter Device Name : " + strdeviceName);

			// Step 25. Select Device Type from drop down
			ptr.selectDropdownByValue(ProvisioningPages.device_Type, strDeviceType,
					"Selecting the Group : " + strDeviceType);

			// Step 26. Select Template from Drop down
			ptr.selectDropdownByValue(ProvisioningPages.template, strTemplate,
					"Selecting the template : " + strTemplate);

			// Step 24. Enter MAC address
			ptr.type(ProvisioningPages.text_MACaddress, strMACAddress, "Enter Device Name : " + strMACAddress);
			
			//Enter Line/ Port
			
			ptr.type(ProvisioningPages.text_LineID, "7053334022.primary", "Enter Device Name : 7053334022.primary");
			

			// Step 23. Click on btn OK
			ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on btn OK");

			// Step 24. Click on btn OK
			ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on btn OK");
			ptr.wait(4000);

		//	ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on btn OK");
			
			// Setup part :
			// Step 25. Edit User
			WebElement user = driver.findElement(By.xpath("(//span[contains(.,'Automation')])[1]"));
			ptr.click(user, "Clicking on User button");
			ptr.wait(4000);

			// Step 26. Click on Phones tab
			ptr.click(PhoneManagementPages.btn_Phones, "Clicking on Phones Tab");

			// Step 30. Click on btn OK
			ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on btn OK");

			ptr.updateStep(strTestCaseName, "Pass");

		} catch (Exception exec) {
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