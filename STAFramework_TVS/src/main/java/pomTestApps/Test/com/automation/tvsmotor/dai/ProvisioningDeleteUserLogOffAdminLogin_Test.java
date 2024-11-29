/**************************************************
#Project Name: MiTEL_CLEARSPAN � Opeasy Automation

#Test case Name: LoginManagement_PhoneTemplatesDisplayTemplate_Test()
#Description:1. This test case is combination of verifing 'Display Template', 'Edit Template', 'Delete Template', 'Select Template in se' testcases on Login Management
#Input Parameters: 
#Owner: Virupakshayya Kulkarni
#Author: Payal Gouda
#Date of creation: 12-Feb-18
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/

package pomTestApps.Test.com.automation.tvsmotor.dai;

import java.util.Hashtable;

import org.testng.annotations.Test;

import pomTestApps.STAcore.DAICommon;
import pomTestApps.STAcore.Operations;
import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyHomePage;

public class ProvisioningDeleteUserLogOffAdminLogin_Test extends BaseClass {
	
	POMSuiteRunner POMSuiteRunner = new POMSuiteRunner();
	Operations oprs = new Operations();

	public static Hashtable<String, String> hashTable = new Hashtable<String, String>();
	public DAICommon clearspanCommon;
	
	@Test(dataProvider = DP)
	public void DeleteUserUsingGUI(
			String Browser,
			String clearspanUrl,
			String opeasyUrl,
			String OpeasyUsername,
			String OpeasyPassword,
			String clearspanUserName,
			String clearspanPassword
			
			) throws Exception {

		clearspanCommon = new DAICommon(driver, ptr);

		clearspanCommon.navigateOpeasyHomePage();
		
		String strOpeasy_WO_SA_Username = POMSuiteRunner.ConfigStore.get("Opeasy_WO_SA_Username");
		String strOpeasy_WO_SA_Password = POMSuiteRunner.ConfigStore.get("Opeasy_WO_SA_Password");
		String strOpeasy_SA_Username = POMSuiteRunner.ConfigStore.get("Opeasy_SA_Username");
		String strOpeasy_SA_Password = POMSuiteRunner.ConfigStore.get("Opeasy_SA_Password");
		
		String strTestCaseName = "Delete User/Devices - Log off an Admin Login a SA";

		try {
			// Step 1. Login to OpEasy as a System Admin without Advanced Provisioning Privilege
		    clearspanCommon.opeasyClearLoginSessions(opeasyUrl, strOpeasy_WO_SA_Username, strOpeasy_WO_SA_Password);
			
			// Step 2. Validate OpEasy HomePage displayed.
			ptr.isElementPresent(OpeasyHomePage.text_Opeasy_screenName, "Validating:Opeasy home page Displayed");

			// Logging out from OpEasy as a system Admin
			clearspanCommon.logoutOpeasy();
			
			// Step 3. Login to OpEasy as a System Admin.
		    clearspanCommon.opeasyClearLoginSessions(opeasyUrl, strOpeasy_SA_Username, strOpeasy_SA_Password);
			
		    // Step 2. Validate OpEasy HomePage displayed.
		 	ptr.isElementPresent(OpeasyHomePage.text_Opeasy_screenName, "Validating:Opeasy home page Displayed");

			
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



