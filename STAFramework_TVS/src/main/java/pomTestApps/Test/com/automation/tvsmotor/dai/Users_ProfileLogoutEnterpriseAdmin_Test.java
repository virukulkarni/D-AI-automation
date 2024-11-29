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

import java.util.Hashtable;

import org.testng.annotations.Test;

import pomTestApps.STAcore.DAICommon;
import pomTestApps.STAcore.Operations;
import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyHomePage;

public class Users_ProfileLogoutEnterpriseAdmin_Test extends BaseClass {

	POMSuiteRunner POMSuiteRunner = new POMSuiteRunner();
	Operations oprs = new Operations();

	public static Hashtable<String, String> hashTable = new Hashtable<String, String>();
	public DAICommon clearspanCommon;

	@Test(dataProvider = DP)
	public void Users_ProfileLogoutEnterpriseAdmin(String Browser, String clearspanUrl, String opeasyUrl,
			String OpeasyUsername, String OpeasyPassword, String clearspanUserName, String clearspanPassword
			
	) throws Exception {

		clearspanCommon = new DAICommon(driver, ptr);

		clearspanCommon.navigateOpeasyHomePage();
		clearspanCommon.navigateProvisioningPage();
		clearspanCommon.navigateClearspanHomePage();

		String strOpeasy_EA_Username = POMSuiteRunner.ConfigStore.get("Opeasy_EA_Username");
		String strOpeasy_EA_Password = POMSuiteRunner.ConfigStore.get("Opeasy_EA_Password");

		String strTestCaseName = "User Profiles - Logout Enterprise Admin test case";

		try {
			
			// Step 1. Login to OpEasy as an Enterprise Admin
			clearspanCommon.opeasyClearLoginSessions(opeasyUrl, strOpeasy_EA_Username, strOpeasy_EA_Password);
		
			// Step 2. Verify Opeasy Main page is displayed
			ptr.assertTextContains(OpeasyHomePage.text_Opeasy_screenName, "OpEasy");

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
