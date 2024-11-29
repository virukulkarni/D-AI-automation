package pomTestApps.Test.com.automation.tvsmotor.dai;
/**************************************************
#Project Name: MiTEL_CLEARSPAN � Opeasy Automation

#Test case Name: ProvisioningGroupSettingsDepartments_Test()
#Description:1. This test case is To count Department For Particular group
#Input Parameters: 
#Owner: Virupakshayya Kulkarni
#Author: Payal Gouda
#Date of creation: 22-Mar-18
#Name of person modifying: (Tester Name): 
#Date of modification: 
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

public class ProvisioningGroupSettingsDepartments_Test extends BaseClass {
	
	POMSuiteRunner POMSuiteRunner = new POMSuiteRunner();
	Operations oprs = new Operations();

	public static Hashtable<String, String> hashTable = new Hashtable<String, String>();
	public DAICommon clearspanCommon;
	
	@Test(dataProvider = DP)
	public void GroupSettingsDepatments(String Browser,
			String clearspanUrl,
			String opeasyUrl,
			String OpeasyUsername,
			String OpeasyPassword,
			String clearspanUserName,
			String clearspanPassword,
			String strEnterprise,
			String strGroup,
			String departmentName
			) throws Exception {

		clearspanCommon = new DAICommon(driver, ptr);

		clearspanCommon.navigateOpeasyHomePage();
		clearspanCommon.navigateProvisioningPage();
		
		String strOpeasy_SR_Username = pomTestApps.STAcore.POMSuiteRunner.ConfigStore.get("Opeasy_SR_Username");
		String strOpeasy_SR_Password = pomTestApps.STAcore.POMSuiteRunner.ConfigStore.get("Opeasy_SR_Password");
		
		String strTestCaseName = "Group Settings - Departments";

		try {

			// Step 1. Login to OpEasy as a Solution Reseller
		    clearspanCommon.loginToOpeasy(opeasyUrl, strOpeasy_SR_Username, strOpeasy_SR_Password);
			
			// Step 2. Validate OpEasy HomePage displayed.
			ptr.isElementPresent(OpeasyHomePage.text_Opeasy_screenName, "Validating:Opeasy home page Displayed");
			
			// Step 3. click on Provisioning from Main menu.
			ptr.click(OpeasyHomePage.link_Provisioning, "Clicking on link: Provisioning");
									
			// Step 4. Validate Provisioning link displayed.
			clearspanCommon.verifyScreenTitleProvPage("Provisioning");
			
			// Step 5. Click on Group Setting link from provisioning.
			ptr.click(ProvisioningPages.groupSetting_Link, "Clicking on link: Group Setting");
						
			// Step 6. Validate Group Setting Screen is displayed.
			clearspanCommon.verifyScreenTitleProvPage("Group Settings");
						
			// Step 7. Click On Link Department.
			ptr.wait(3000);
			ptr.click(ProvisioningPages.link_Departments, "Clicking on link: Departments"); 
						
			// Step 8. Validate Department Screen is displayed.
			clearspanCommon.verifyScreenTitleProvPage("Group Departments");
			
			// Step 9. Select Enterprise.
			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise,strEnterprise, "Selecting an Enterprise : " + strEnterprise );
												
			// Step 10. Validate Department Screen is displayed.
			ptr.isElementPresent(ProvisioningPages.screen_Departments, "Validating:Departments page is Displayed");
						
			// Step 11. Select Group.
			ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group,strGroup, "Selecting an Enterprise : " + strGroup );
					
			// Step 12. Click On Search.
		    ptr.click(OpeasyCommonPageElements.btn_Search, "Clicking on link: search Department"); 
			
		    // Step 13. Verify The Visibility Of Departments
		    int DepartmentListCount = driver.findElements(By.xpath("//span[text()='Edit']")).size();
			System.out.println("Number of Department Elements:  " + DepartmentListCount);

			if ((DepartmentListCount > 0)) {
				ptr.updateStep("Department are displayed", "Pass");
			}
			else {
				ptr.updateStep("Department are Not displayed", "Fail");
			}
		    
			// Step 14. Click on Add Button
			ptr.click(OpeasyCommonPageElements.btn_Add, "Clicking on link: add"); 
			
			// Step 15. Validate Department Add Screen is displayed.
			ptr.isElementPresent(ProvisioningPages.screen_AddDepartments, "Validating:Department Add page is Displayed");
					
			// Step 14. Type Department Name.
			ptr.type(ProvisioningPages.text_DepartmentName, departmentName, "Type Department Name :" +departmentName);
						
			//Step 15. Click on Ok
			ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking on link: OK");
			
			//Step 16. Validate Error Message
			ptr.isElementPresent(ProvisioningPages.errormsg_DepartmentAlreadyExist, "Validating: Error Message For Department is Already Exist");
						
			// Step 17. Click on Cancel Button.
			ptr.click(OpeasyCommonPageElements.btn_Cancel, "Clicking Cancel Button");
				    	
			// Step 18. Validate Department Screen is displayed.
		    ptr.isElementPresent(ProvisioningPages.screen_Departments, "Validating: Department page is Displayed");
			
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

