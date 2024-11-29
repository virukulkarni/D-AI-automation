package pomTestApps.Test.com.automation.tvsmotor.dai;

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
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.ProvisioningPages;

public class ProvisioningDeletePhoneManagement_Test extends BaseClass {
	
	POMSuiteRunner POMSuiteRunner = new POMSuiteRunner();
	Operations oprs = new Operations();

	public static Hashtable<String, String> hashTable = new Hashtable<String, String>();
	public DAICommon clearspanCommon;
	public ProvisioningPages provisioningpages;
	
	@Test(dataProvider = DP)
	public void DeletePhoneManagement(
			String Browser,
			String clearspanUrl,
			String opeasyUrl,
			String OpeasyUsername,
			String OpeasyPassword,
			String clearspanUserName,
			String clearspanPassword,
			String strEnterprise,
			String strGroup,
			String deviceName,
			String deviceLevel,
			String deviceType,
			String template,
			String phoneLocation,
			String findKey,
			String findOption,
			String findText
			
			
			) throws Exception {

		clearspanCommon = new DAICommon(driver, ptr);

		clearspanCommon.navigateOpeasyHomePage();
		clearspanCommon.navigateProvisioningPage();
		clearspanCommon.navigateClearspanHomePage();
		
		String strOpeasy_SA_Username = POMSuiteRunner.ConfigStore.get("Opeasy_SA_Username");
		String strOpeasy_SA_Password = POMSuiteRunner.ConfigStore.get("Opeasy_SA_Password");
		
		String strTestCaseName = "Delete Phone Management test case";

		try {
			// Step 1. Login to OpEasy as a System Admin without Advanced Provisioning Privilege
		    clearspanCommon.loginToOpeasy(opeasyUrl, strOpeasy_SA_Username, strOpeasy_SA_Password);
		    
			if (clearspanCommon.deviceExists("SU", strEnterprise, strGroup, "Device Name", deviceName)) {
				String strDynamicXpath = "//a[contains(.,'Edit')]";
				WebElement eleUserName = driver.findElement(By.xpath(strDynamicXpath));
				
				ptr.click(eleUserName, "Click on Edit link to delete the device later.");
				ptr.assertTextEquals(ProvisioningPages.textuser_ScreenName, "Phone Device Modify");
				
				// Delete User
				ptr.click(OpeasyCommonPageElements.btn_Delete, "Click button Delete");
				ptr.wait(3000);
				ptr.alertAccept();
				ptr.wait(3000);
				
//				ptr.click(provisioningpages.btn_OK, "CLick button OK");
				
			}
			
			// Step 10. Click On Add Button.
			ptr.click(OpeasyCommonPageElements.btn_Add, "Clicking on link: Add Button"); 
			
			// Step 11. Validate Phone Device Add Screen is displayed.
			ptr.isElementPresent(ProvisioningPages.phoneDeviceAdd_ScreenName, "Validating:Announcement Repository page is Displayed");
			
			// Step 12. Give Device Name For Create Phone Management.
			ptr.type(ProvisioningPages.device_Name, deviceName , "Selecting Device Name : " + deviceName );
									
			// Step 13. Select Device Level.
			ptr.selectDropdownByValue(ProvisioningPages.device_Level, deviceLevel , "Selecting Device Level : " + deviceLevel );
						
			// Step 14. Select Device Type.
			ptr.selectDropdownByVisibleText(ProvisioningPages.device_Type, deviceType , "Selecting device Type : " + deviceType );
			
			// Step 15. Validate Template Button Is Enabled.
			if (ProvisioningPages.template.isEnabled()) {
				ptr.updateStep("Choose Template is Enabled", "Pass");
			} else {
				ptr.updateStep("Choose Template is not Enabled", "Fail");
			}
			
			// Step 16. Select Template For Phone Management.
			ptr.selectDropdownByValue(ProvisioningPages.template, template , "Selecting Template : " + template );
			
			//Step 17. Validate View Template Button Is Enabled
			if (ProvisioningPages.view_Template.isEnabled())
			{ptr.updateStep("Choose view Template is Enabled","Pass");}
			else
			{ptr.updateStep("Choose view Template is not Enabled","Fail");}
			
			// Step 18. Give Phone location For Create Phone Template.
			ptr.type(ProvisioningPages.phone_Location, phoneLocation , "Give Phone Location : " + phoneLocation );
			
	    	// Step 19. Click on OK Button.
	    	ptr.click(OpeasyCommonPageElements.btn_OK, "Clicking OK Button");
	    	
			if (clearspanCommon.deviceExists("SU", strEnterprise, strGroup, "Device Name", deviceName)) {
				ptr.updateStep("Phone device added successfully: " + deviceName, "Pass");
			} else {
				ptr.updateStep("Phone device NOT added successfully: " + deviceName, "Fail");
			}
//			
//	    	//Step 22. LogOut From OpeEasy.
//			clearspanCommon.logoutOpeasy();
//	    	
//	    	//Step 23.  Validating in ClearSpan for Phone Management Existence.
//			ValidatingPhoneInClearspan(clearspanUrl,clearspanUserName,clearspanPassword,strEnterprise,strGroup,deviceName,findKey,findOption,
//					findText); 
//				
//			// Step 24. Find Phone Management In List
//				try{
//					driver.findElement(By.xpath("//a[@class='listSortHeader']/../../../tr/td/a[text()='"+deviceName+"']")).isDisplayed();
//					}
//				catch (Exception exec){
//					exec.getStackTrace();
//					ptr.updateStep("Phone Management is not present in clearspan","Fail");
//					}
//	    	
//			//Step 25. Logout From ClearSpan
//			clearspanCommon.logoutClearspan();
//			
//	    	// STEPS FOR DELETING PHONE MANAGEMENT
//			
//			// Step 26. Login to OpEasy as a System Admin without Advanced Provisioning Privilege
//		    clearspanCommon.loginToOpeasy(opeasyUrl, strOpeasy_SA_Username, strOpeasy_SA_Password);
//			
//			// Step 27. Validate OpEasy HomePage displayed.
//			ptr.isElementPresent(OpeasyHomePage.text_Opeasy_screenName, "Validating:Opeasy home page Displayed");
//
//			// Step 28. click on Provisioning from Main menu.
//			ptr.click(OpeasyHomePage.link_Provisioning, "Clicking on link: Provisioning");
//			
//			// Step 29. Validate Provisioning Screen displayed.
//			ptr.isElementPresent(OpeasyHomePage.Provisioning_Screen, "Validating:Provisioning page Displayed");
//	    	
//	    	// Step 30. Click on Phone Management link from provisioning.
//	    	ptr.click(ProvisioningPages.phoneManagement_Link, "Clicking on link: Phone Management");
//	    				
//	    	// Step 31. Validate Phone Management Screen is displayed.
//	    	ptr.isElementPresent(ProvisioningPages.phoneManagement_ScreenName, "Validating: Phone Management page is Displayed");
//	    				
//	    	// Step 32. Select Enterprise.
//	    	ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Enterprise,strEnterprise, "Selecting an Enterprise : " + strEnterprise );
//	    				
//	    	// Step 33. Validate Phone Management Screen is displayed.
//	    	ptr.isElementPresent(ProvisioningPages.phoneManagement_ScreenName, "Validating: Phone Management page is Displayed");
//	    				
//	    	//Step 34. Select Group from Drop down box.
//	    	ptr.selectDropdownByValue(OpeasyCommonPageElements.dropdown_Group, strGroup , "Selecting the Group : " +strGroup);
//	    	
//	    	//Step 35. Select Device Level from Drop down box.
//	    	ptr.selectDropdownByValue(ProvisioningPages.device_Levels, deviceLevel , "Selecting the device Level : " +deviceLevel);
//
//	    	clearspanCommon.createSearchCriteriaRow(1, "Device Name", "", deviceName);
//	    	ptr.click(OpeasyCommonPageElements.btn_VirtualUsersSearch, "Click Button Search");
//	    	
//	    	// Step 38. Click on Edit Button for Corresponding Device.
//	    	driver.findElement(By.xpath("(//*[@id=\"form1:tableQueryResults\"]//span[contains(text(), '" + deviceName + "')])[1]")).click();
	    	driver.findElement(By.xpath("//span[text()='"+deviceName+"']")).click();
	    	
	    	ptr.updateStep("Clicked the Phone to be Delete ", "Pass");
	    	
	    	// Step 39. Click on Delete Button.
	    	ptr.wait(3000);
	    	ptr.click(OpeasyCommonPageElements.btn_Delete, "Click button Delete");
	    	ptr.wait(3000);
	    	ptr.alertAccept();
	    	ptr.wait(3000);
//	    	//Step 40. Confirmation For Deleting Announcement.
//
//		    if( ptr.isAlertPresent()) {    	  
//	    		ptr.updateStep("Alert popup is present ", "Pass");
//	    		ptr.alertAccept();
//	    	} else{
//	    		ptr.updateStep("Alert popup is present ", "Fail");	
//	    	}
//		    
		    //Click Apply button
		    ptr.click(OpeasyCommonPageElements.btn_Apply, "Clicking on apply button");
	    	
//	    	//Step 42. LogOut From OpeEasy.
//			clearspanCommon.logoutOpeasy();
//	    	
//	    	//Step 43.  Validating in ClearSpan for Phone Management Existence.
//			ValidatingPhoneInClearspan(clearspanUrl,clearspanUserName,clearspanPassword,strEnterprise,strGroup,deviceName,findKey,findOption,
//					findText); 
//				
//			// Step 44. Find Phone Management In List
//				try{
//					driver.findElement(By.xpath("//a[@class='listSortHeader']/../../../tr/td/a[text()='"+deviceName+"']")).isDisplayed();
//					ptr.updateStep("Phone Management is not Deleted From clearspan","Fail");
//					}
//				catch (Exception exec){
//					exec.getStackTrace();
//					ptr.updateStep("Phone Management is Deleted From clearspan","Pass");
//					}
//	
//			//Step 45. Logout From ClearSpan
//			clearspanCommon.logoutClearspan();
//			
//			// Step 46. Login to OpEasy as a System Admin 
//		    clearspanCommon.loginToOpeasy(opeasyUrl, strOpeasy_SA_Username, strOpeasy_SA_Password);
		    
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

	/*
	 * Adding validating For Phone Management In ClearSpan
	 * 
	 */
	 
	public void ValidatingPhoneInClearspan(
		    String clearspanUrl,
			String clearspanUserName,
			String clearspanPassword,
			String strEnterprise,
			String strGroup,
			String deviceName,
			String findKey,
			String findOption,
			String findText) throws IOException, InterruptedException {
		
		

		// Step 1. Login to ClearSpan 
	    clearspanCommon.loginToClearspan(clearspanUrl, clearspanUserName, clearspanPassword);
	    
	    // Step 2. click on Enterprise link
	    ptr.click(ClearspanHomePage.enterprise_Link, "Clicking on link: Enterprise");
	    
	    // Step 3. Validating Enterprise Screen
	    ptr.isElementPresent(ClearspanHomePage.enterprise_Screen, "Validating:Enterprise screen Displayed");

	    // Step 4. Select Find Key
	    ptr.selectDropdownByValue(ClearspanHomePage.dropdown_Findkey, "Name" , "Selecting the Key : Name", true);
	    
	   // Step 5. Select Find Option
	    ptr.selectDropdownByValue(ClearspanHomePage.dropdown_FindOption, findOption , "Selecting the Option : " +findOption, true);
	    
	   // Step 6. Select Find Option
	    ptr.type(ClearspanHomePage.finding_Text, findText , "Give text to search : " +findText);

		// Step 7. click on Search Button
	    ptr.click(ClearspanHomePage.search_Button, "Clicking on Button: Search");
	    
	    // Step 8. Validating Enterprise Presence in ClearSpan
	    driver.findElement(By.xpath("//a[contains(text(), 'Mitel India Lab')]")).click();
	    
	    ptr.updateStep("Click On The Enterprise","Pass");
	    
	    // Step 10. Click on Group Link
	    ptr.click(ClearspanHomePage.group_Link, "Click on Link: Group");
	    
	    // Step 11. Validating Group Screen
	    ptr.isElementPresent(ClearspanHomePage.group_Screen, "Validating:Group screen Displayed");
	    
	    // Step 12. click on Search Button
	    ptr.click(ClearspanHomePage.search_Button, "Clicking on Button: Search");
	    
	    // Step 10. Validating Group Presence in ClearSpan
	    driver.findElement(By.xpath("//a[contains(text(), 'Mitel India Lab')]")).click();
	    
	    // Step 11. Click on Group Name
//	    driver.findElement(By.xpath("//a[contains(text(), '" +  + "')]")).click();
	    
	    ptr.updateStep("Click On The Group","Pass");
	    
	    // Step 12. click on Resource Link
	    ptr.click(ClearspanHomePage.resources_Link, "Clicking on Link: Resources");
	    
	    // Step 13. click on Resource Link
	    ptr.click(ClearspanHomePage.deviceProfiles_Link, "Clicking on Link: Resources");
	    
	    // Step 14. Validating Group Screen
	    ptr.isElementPresent(ClearspanHomePage.deviceProfiles_Screen, "Validating:Device Profile Displayed");
	    
	    // Step 15. click on Search Button
	    ptr.click(ClearspanHomePage.search_Button, "Clicking on Button: Search");
	}
	}

