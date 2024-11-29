package pomTestApps.Test.com.automation.tvsmotor.dai.elements;
/**************************************************
#Project Name: MiTEL_CLEARSPAN - Selenium Framework
#Function Name: ProvisioningPages()
#Description:1. Provisioning of Users and devices
			 2. All the Xpath for all the web Elements of these pages are placed 
#Input Parameters:
#Owner: Virupakshayya V Kulkarni
#Author: Virupakshayya V Kulkarni
#Date of creation: 16-Oct-2017
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginManagementPages {
	public WebDriver driver;

	public LoginManagementPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	//**************************************Viru Start***************************************
	/**
	 * Page name : OPEASY Login Management Page
	 * Element 	 : Login Management screen name
	 **/

	@FindBy(xpath=".//*[@id='form1:staticTextScreenName']")
	public static WebElement text_LoginManagement_ScreenName;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Login Level
	 **/
	@FindBy(id = "form1:calendarAccountExpiryStartDate_input")	            
	public static WebElement From_date;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Login Level
	 **/
	@FindBy(id = "form1:calendarAccountExpiryEndDate_input")	            
	public static WebElement To_date;
	
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Page Title
	 **/
	@FindBy(xpath="//*[@id='form1:staticTextScreenName']")
	public static WebElement text_Administrator_Add_ScreenName;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : User Name
	 **/
	@FindBy(id="form1:textFieldLoginName")	
	public static WebElement text_UserName;

	/**
	 * Page name : OpEasy Administrator Add Element : User Name
	 **/
	@FindBy(id = "form1:tableSearchCriteria:0:dropDownQueryType_label")
	public static WebElement dropdown_adminSearch;

	/**
	 * Page name : OpEasy Administrator Add Element : User Name
	 **/
	@FindBy(id = "form1:tableSearchCriteria:0:textFieldQueryValue")
	public static WebElement text_Admin;

	/**
	 * Page name : OpEasy Administrator Add Element : Password
	 **/
	@FindBy(id="form1:textFieldPassword")
	public static WebElement text_Password;
	
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Password
	 **/
	@FindBy(id="form1:textFieldConfirmPassword")
	public static WebElement text_ConfirmPassword;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Password
	 **/
	@FindBy(id ="form1:textFieldEmailAddress")
	public static WebElement text_EmailAddress;
	
	
	
	
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Administrator Name
	 **/
	@FindBy(id="form1:textFieldAdminName")
	public static WebElement text_AdminName;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Login Level
	 **/
	
	//@FindBy(id = "form1:dropDownLoginLevel_input")
	@FindBy(id = "form1:dropDownLoginLevel_label")	            
	public static WebElement list_LoginLevel;
	
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Login Level
	 **/
	
	//@FindBy(id = "form1:dropDownLoginLevel_input")
	@FindBy(xpath = "//*[@id[contains(., '24:dropDownAccess_label')]]")	            
	public static WebElement Import_privilegeAccess;
	

	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : OK button
	 **/
	@FindBy(id="form1:tableOpEasyUsers:_tableActionsTop:_paginateButton:_paginateButton_image")
	public static WebElement btn_ShowDataInSinglePage;

	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Customize Privileges
	 **/
	@FindBy(xpath = "//*[@id='form1:buttonCustomize']/span")
	public static WebElement btn_CustomizePrivilege;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Customize Privileges
	 **/
	@FindBy(xpath = "//*[@id='form1:buttonResetToDefault']/span")
	public static WebElement btn_ResetToDefault;
		
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Drop Down Select 
	 **/
	@FindBy(xpath="//tr//span[contains(., 'Advanced Provisioning')]//parent::*//following-sibling::td[1]//select")
	public static WebElement select_AdvProv;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : OK button
	 **/
	@FindBy(id="form1:buttonOK")
	public static WebElement btn_Priv_OK;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Page title : OpEasy Administrator Modify
	 **/
	@FindBy(xpath = "//span[contains(.,'OpEasy Administrator Modify')]")
	public static WebElement text_Administrator_Modify_ScreenName;

	// span[contains(.,'Automation')]//parent::td//parent::tr//span[contains(.,'Delete')]//a

	/**
	 * Page name : OpEasy Administrator Add Element : Page title : OpEasy
	 * Administrator Modify
	 **/
	@FindBy(xpath = "//span[contains(.,'Voice VPN')]//parent::td//parent::tr//td[2]//div[2]//select//option")
	public static WebElement Voicevpn_NoAccess;

	/**
	 * Page name : OpEasy Administrator Add Element : Page title : OpEasy
	 * Administrator Modify
	 **/
	@FindBy(id = "form1:buttonDelete")
	public static WebElement screen_AdminModify;

	/**
	 * Page name : OpEasy Administrator Add Element : Page title : OpEasy
	 * Administrator Modify
	 **/
	@FindBy(id="form1:buttonDelete")
	public static WebElement btn_Delete_User;
	

	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Select list box 
	 **/
	@FindBy(id = "form1:selectAllCheckBox")
	public static WebElement chk_Select_All;
	
	/**
	 * Page name : OpEasy Administrator Modify
	 * Element 	 : groupDeptListBox 
	 **/
	@FindBy(id = "form1:layoutPanelListBox:groupDeptListBox_list")
	public static WebElement listBox_groupDept;	
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Button Login Rules 
	 **/
	@FindBy(id="form1:buttonLoginRules")
	public static WebElement btn_Login_Rules;

	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Button Login Rules 
	 **/
	@FindBy(id="form1:dropDownPasswordDuration_label")
	public static WebElement dropDown_PasswordDuration_label;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Button Login Rules 
	 **/
	@FindBy(id="form1:dropDownMinimumPasswordDuration_label")
	public static WebElement dropDown_MinimumPasswordDuration_label;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Screen name of Login rules Modify 
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(), 'Login Rules Modify')]")
	public static WebElement text_Login_Rules_Modify_ScreenName;	
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Radio Button for Login Rules
	 **/
	@FindBy(id="form1:layoutPanelTopControls:radioButtonLoginRules:radioButtonLoginRules_1:radioButtonLoginRules_1_label_valueContainer")
	public static WebElement radiobutton_LoginRules;	
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Button Login Rules 
	 **/
	@FindBy(id="form1:staticTextLoginRulesHeader")
	public static WebElement text_Login_Rules_Header;	
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : List box enterprise 
	 **/
	@FindBy(id="form1:layoutPanelListBox:groupDeptListBox")
	public static WebElement list_box_Enterprises;	
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Button Login Rules 
	 **/
	@FindBy(id="form1:buttonLoginRules")
	public static WebElement btn_LoginRules;	

	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Radio Button Login Rules 
	 **/
	@FindBy(id="form1:layoutPanelEnterpriseRulesHeader:radioButtonEnterpriseLoginRules:radioButtonEnterpriseLoginRules_1_rb")
	public static WebElement radiobtn_EntLoginRules;

	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Checkbox  AllowAdminLoginName
	 **/
	@FindBy(id = "form1:checkboxAllowAdminLoginName_input")
	public static WebElement checkbox_AllowAdminLoginName;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Checkbox  AllowAdminLoginName
	 **/
	@FindBy(id="form1:checkbox2FactorAuth")
	public static WebElement checkbox_2FactorAuth;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : list dropDownMaxLoginAttempts
	 **/
	@FindBy(id = "form1:dropDownMaxLoginAttempts_label")
	public static WebElement list_dropDownMaxLoginAttempts;	
	
	/**
	 * Page name : OpEasy Login Management 
	 * Element 	 : Apply button
	 **/
	@FindBy(id = "form1:layoutPanelScreenSavedMessage")
	public static WebElement txt_screeSavedMessage;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : list dropDownMaxLoginAttempts
	 **/
	@FindBy(xpath = ".//*[@id='form1:errorMessages'][contains(., \"Password cannot contain the Login Name\")][contains(., \"regardless of character case.\")]")
	public static WebElement txt_ErrorMessage;	

	/**
	 * Page name : OpEasy Page 
	 * Element 	 : link Change Password
	 **/
	@FindBy(id = "form1:HeaderPane:changePasswordHyperlink")
	public static WebElement link_ChangePassword;	
	
	/**
	 * Page name : OpEasy Page 
	 * Element 	 : Page header 
	 **/
	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement text_ScreenArea;
	
	
	/**
	 * Page name : OpEasy Page 
	 * Element 	 : text box old password
	 **/
	@FindBy(id = "form1:oldPasswordText")
	public static WebElement tbx_OldPassword;	

	/**
	 * Page name : OpEasy Page 
	 * Element 	 : text box NewPassword
	 **/
	@FindBy(id = "form1:newPasswordText")
	public static WebElement tbx_NewPassword;	

	/**
	 * Page name : OpEasy Page 
	 * Element 	 : text box ConfirmNewPassword
	 **/
	@FindBy(id = "form1:confirmPasswordText")
	public static WebElement tbx_ConfirmNewPassword;	

	/**
	 * Page name : OpEasy Page 
	 * Element 	 : label ErrorMessage
	 **/
	@FindBy(xpath = "(.//*[@id='form1:errorMessages']//span)[last()]")
	public static WebElement label_ErrorMessage;	
	
	/**
	 * Page name : OpEasy Login Management Page
	 * Element 	 : label ErrorMessage
	 **/
	@FindBy(id = "form1:tableSearchCriteria:0:dropDownQueryType_label")				  
	public static WebElement dropDown_SelectSearchCriteria1;	
	
	/**
	 * Page name : OpEasy Login Management Page
	 * Element 	 : label ErrorMessage
	 **/
	@FindBy(id = "form1:tableSearchCriteria:rowGroupSearchCriteria:0:columnRowAdd:buttonRowAdd")
	public static WebElement btn_SearchRowAdd;		
	
	/**
	 * Page name : OpEasy Login Management Page
	 * Element 	 : label ErrorMessage
	 **/
	@FindBy(id = "form1:tableSearchCriteria:rowGroupSearchCriteria:1:columnQueryType:dropDownQueryType")
	public static WebElement dropDown_SelectSearchCriteria2;
	
	/**
	 * Page name : OpEasy Login Management Page
	 * Element 	 : label ErrorMessage
	 **/
	@FindBy(xpath = ".//select[@id[contains(., ':dropDownQueryComparison')]]")
	public static WebElement dropDown_SelectSearchFilter2;
	
	/**
	 * Page name : OpEasy Login Management Page
	 * Element 	 : label ErrorMessage
	 **/
	@FindBy(xpath = ".//input[@id[contains(., ':textFieldQueryValue_field')]]")
	public static WebElement txt_SearchValue2;
	
	/**
	 * Page name : OpEasy Login Management Page
	 * Element 	 : label ErrorMessage
	 **/
	@FindBy(xpath = ".//input[@id[contains(., '1:columnQueryValue:textFieldQueryValue_field')]]")
	public static WebElement txt_SearchValueSecondRow;
	
	/**
	 * Page name : OpEasy Login Management Page
	 * Element 	 : label ErrorMessage
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':buttonLogoutUnlock')]]")
	public static WebElement btn_LogoutUnlock;

	/**
	 * Page name : OpEasy Login Management Page
	 * Element 	 : DropDown UnlockOpEasyAccountAfter
	 **/
	@FindBy(id = "form1:dropDownAdminAccountLockedDuration_label")
	public static WebElement dropDown_UnlockOpEasyAccountAfter;
	
	/**
	 * Page name : OpEasy Login Management Page
	 * Element 	 : Button button_ResetLoginRules
	 **/
	@FindBy(id = "form1:buttonReset")
	public static WebElement button_ResetLoginRules;
	
	/**
	 * Page name : OpEasy Login Management Page
	 * Element 	 : Button button_ResetLoginRules
	 **/
	@FindBy(id = "form1:dropDownNumberPreviousPasswordsChecked")
	public static WebElement dropDown_NumberPreviousPasswordsChecked;
	
	/**
	 * Page name : OpEasy Login Management Page
	 * Element 	 : Button button_ResetLoginRules
	 **/
	@FindBy(id = "form1:checkboxAllowPreviousPassword")
	public static WebElement checkbox_AllowPreviousPassword;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Password
	 **/
	@FindBy(xpath ="//*[@id='form1:oldPasswordText']")
	public static WebElement text_oldPasswordStaticText;	

	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Password
	 **/
	@FindBy(xpath ="//*[@id='form1:newPasswordText']")
	public static WebElement text_newPasswordText;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Password
	 **/
	@FindBy(xpath ="//*[@id='form1:confirmPasswordText']")
	public static WebElement text_confirmPasswordText;

	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Password
	 **/
	@FindBy(id = "form1:dropDownEnterprise_label")
	public static WebElement dropDownEnterprise_label;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : Password
	 **/
	@FindBy(id = "form1:dropDownNumberPreviousPasswordsChecked_label")
	public static WebElement dropDownNumberPreviousPasswordsChecked_label;

	
	//**********************************************Viru End***********************************
}
