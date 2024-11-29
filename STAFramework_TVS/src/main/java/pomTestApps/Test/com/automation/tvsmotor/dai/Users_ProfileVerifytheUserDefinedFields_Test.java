/**************************************************
#Project Name: MiTEL_CLEARSPAN � Opeasy Automation

#Test case Name: LoginManagement_AdminToolsClearSystemMessage()
#Description:1. This test case verifies Admin tools System Message cleared on Login Management
#Input Parameters: 
#Owner: Virupakshayya Kulkarni
#Author: Hameetha Banu
#Date of creation: 30-Jan-19
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/

package pomTestApps.Test.com.automation.tvsmotor.dai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pomTestApps.STAcore.DAICommon;
import pomTestApps.STAcore.Operations;
import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.AdminToolsPages;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyCommonPageElements;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyHomePage;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.ProvisioningPages;

public class Users_ProfileVerifytheUserDefinedFields_Test extends BaseClass {

	POMSuiteRunner POMSuiteRunner = new POMSuiteRunner();
	Operations oprs = new Operations();

	public static Hashtable<String, String> hashTable = new Hashtable<String, String>();
	public DAICommon clearspanCommon;

	@Test(dataProvider = DP)
	public void AdvProv_11AdvancedProvisioningEdit(String Browser, String clearspanUrl, String opeasyUrl,
			String OpeasyUsername, String OpeasyPassword, String clearspanUserName, String clearspanPassword,
			String strEnterprise, String strGroup, String lastName

	) throws Exception {

		clearspanCommon = new DAICommon(driver, ptr);

		clearspanCommon.navigateOpeasyHomePage();
		clearspanCommon.navigateProvisioningPage();
		clearspanCommon.navigateClearspanHomePage();
		clearspanCommon.navigateAdminToolsPage();

		String strOpeasy_EA_Username = POMSuiteRunner.ConfigStore.get("Opeasy_EA_Username");
		String strOpeasy_EA_Password = POMSuiteRunner.ConfigStore.get("Opeasy_EA_Password");

		String strOpeasy_Username = pomTestApps.STAcore.POMSuiteRunner.ConfigStore.get("Opeasy_SU_Username");
		String strOpeasy_Password = pomTestApps.STAcore.POMSuiteRunner.ConfigStore.get("Opeasy_SU_Password");

		String strTestCaseName = "User Profiles - Verify the user defined fields test case";

		try {
			/*
			 * Login SU and get UDF table Field Name contents Verify
			 * UBillingType drop down values Login EA -> along with steps verify
			 * table content is same. IN EA Verify UBillingType drop down values
			 */

		
			// Step 1. Login to Opeasy as SU
			clearspanCommon.opeasyClearLoginSessions(opeasyUrl, strOpeasy_Username, strOpeasy_Password);

			// Step 2. Click on Admin Tools link
			ptr.click(OpeasyHomePage.link_Admintools, "Click on link : Admin Tools");

			// Step 3. Click System Settings link
			ptr.click(AdminToolsPages.link_SystemSettings, "Click on link : System Settings");

			// Step 4. Verify System Settings page is displayed.
			clearspanCommon.verifyScreenTitleProvPage("System Settings");

			// Step 5. Get User Billing Types from drop down list
			String BillingTypeDropdown = ".//*[@id='form1:layoutUserTypes']//input";
			List<WebElement> listOfInputElements = driver.findElements(By.xpath(BillingTypeDropdown));

			int count = listOfInputElements.size();
			System.out.println("Size" + count);
			List<String> BillingType_src = new ArrayList<String>();

			for (int i = 1; i <= count; i++) {

				String strDynXpath = "(.//*[@id='form1:layoutUserTypes']//input)[" + i
						+ "]";
				WebElement eleUserTypeToGetUserType = driver.findElement(By.xpath(strDynXpath));
				String strUSerTypeName = eleUserTypeToGetUserType.getAttribute("value");
				BillingType_src.add(eleUserTypeToGetUserType.getAttribute("value"));
				int data_size = BillingType_src.size();

				System.out.println("Billing Type values are :   " + strUSerTypeName);

			}

			System.out.println(Arrays.asList(BillingType_src));

			// Step 6. Click on cancel button
			ptr.click(AdminToolsPages.btn_cancel, "Click on Cancel button");
		
			// Step 7. Click on Provisioning link
			ptr.click(AdminToolsPages.link_Provisioning, "Click on Provisioning link");

			// Step 8. Click on User Defined Fields link
			ptr.click(ProvisioningPages.link_UDF, "Click on User Defined Fields link");

			// Step 5. Select Enterprise from Drop down list
			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise, strEnterprise,
					"Selecting an Enterprise : " + strEnterprise);
			
			String UDF_Table= "//*[@id='form1:tableFields_data']";
			driver.findElements(By.xpath(UDF_Table));

			ptr.updateStep("The table with User Defined Fields is displayed as expected", "Pass");

		    // Step 15. Click Cancel Button
			ptr.click(OpeasyCommonPageElements.btn_Cancel, "Click CAncel button");

			ptr.updateStep(strTestCaseName, "Pass");
		    
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
