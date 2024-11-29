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
�**************************************************/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProvisioningPages {
	public WebDriver driver;

	public ProvisioningPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// **************************************Viru
	// Start***************************************
	/**
	 * Page name : OPEASY Provisioning Page Element : User ID text_box
	 **/

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(id = "form1:hyperlinkUsers")
	public static WebElement Users_Link;

	/**
	 * Page name : OPEASY Provisioning Page Element : Refresh Import
	 **/
	@FindBy(id = "form1:dropDownSchedule_label")
	public static WebElement ScheduleDropdown;

	/**
	 * Page name : OPEASY Provisioning Page Element : Refresh Import
	 **/
	@FindBy(id = "form1:buttonScheduleExport")
	public static WebElement ScheduleExport;

	/**
	 * Page name : OPEASY Provisioning Page Element : Refresh Import
	 **/
	@FindBy(id = "form1:buttonRequestStart")
	public static WebElement StartExport;

	/**
	 * Page name : OPEASY Provisioning Page Element : Refresh Import
	 **/
	@FindBy(xpath = ".//*[@id='form1:checkboxMonday1']/div[2]/span")
	public static WebElement CheckboxMonday;

	/**
	 * Page name : OPEASY Provisioning Page Element : Refresh Import
	 **/
	@FindBy(id = "form1:buttonEmailResults")
	public static WebElement Email_Results;

	/**
	 * Page name : OPEASY Provisioning Page * Element : View Template Button
	 **/
	@FindBy(id = "form1:tablePhoneDevices:0:buttonTemplateView")
	public static WebElement Device_viewTemplate;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(id = "form1:textInputForwardToNumber")
	public static WebElement fwd_textbox;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(linkText = "Night Forwarding")
	public static WebElement NightForwarding;

	/**
	 * Page name : OpEasy Enterprise User defined Fields Page Element : Delete
	 * link
	 **/
	@FindBy(xpath = "//input[@value='56123']//parent::td//parent::tr//a[contains(.,'Delete')]")
	public static WebElement delete_authcode;

	/**
	 * Page name : OPEASY Provisioning Page Element : View Template Button
	 **/
	@FindBy(id = "form1:tableAuthCodes:0:textFieldAuthCode")
	public static WebElement type_authcode;

	/**
	 * Page name : OPEASY Provisioning Page Element : View Template Button
	 **/
	@FindBy(id = "form1:tableAuthCodes:0:textFieldDescription")
	public static WebElement type_authdes;

	/**
	 * Page name : OPEASY Provisioning Page Element : View Template Button
	 **/
	@FindBy(id = "form1:hyperlinkAuthCodes")
	public static WebElement auth_codes;
	/**
	 * Page name : OpEasy User Settings Page Element : Button for Initialize
	 * User Speed Dial 100 Settings
	 **/
	@FindBy(xpath = ".//*[@id='form1:errorMessages']/div/ul/li/span")
	public static WebElement SD8_User_Errormessage;

	/**
	 * Page name : OPEASY Provisioning Page Element : View Template Button
	 **/
	@FindBy(id = "form1:dropDownAccountIDEnt_label")
	public static WebElement dropdownEnt_AccountID;

	/**
	 * Page name : OpEasy export Page Element : Users checkbox
	 **/
	@FindBy(xpath = "//span[contains(.,'Users')]")
	public static WebElement checkbox_Users;

	/**
	 * Page name : OPEASY Provisioning Page Element : View Template Button
	 **/
	@FindBy(id = "form1:dropDownAccountIDGrp_label")
	public static WebElement dropdownGrp_AccountID;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(id = "form1:textFieldAccountID")
	public static WebElement txt_UserID;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "//span[contains(.,'Account ID')]")
	public static WebElement txt_AccountID;

	/**
	 * Page name : OPEASY Export Page Element : worksheet AccountID
	 **/

	@FindBy(xpath = "//label[contains(.,'AccountIDs')]")
	public static WebElement worksheet_AccountID;

	/**
	 * Page name : OpEasy User Settings Page Element : Advanced User Add
	 **/
	@FindBy(xpath = "//div[@id='form1:checkboxUseOrgID']//span")
	public static WebElement OrganizationID_checkbox;

	/**
	 * Page name : OpEasy User Settings Page Element : Advanced User Add
	 **/
	@FindBy(id = "form1:textFieldAccountID")
	public static WebElement AcccountID_textbox;

	/**
	 * Page name : OpEasy User Settings Page Element : Advanced User Add
	 **/
	@FindBy(xpath = ".//*[@id='form1:chkSystemExportTabs']/tbody/tr/td[1]//div[2]")
	public static WebElement AcccountID_checkbox;
	/**
	 * Page name : OPEASY Provisioning Page Element : View Template Button
	 **/
	@FindBy(id = "form1:dropDownAccountIDSys_label")
	public static WebElement dropdown_AccountID;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "//span[contains(.,'Optional')]")
	public static WebElement Optional;
	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(id = "form1:hyperlinkVirtualUsers")
	public static WebElement link_VirtualUsers;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(id = "form1:dropDownVoiceMail_label")
	public static WebElement dropDownVoiceMail_list;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "(//a[contains(text(),'User Profiles')])[2]")
	public static WebElement User_Profiles;

	/**
	 * Page name : OPEASY Provisioning Page Element : txt_PhoneNumber
	 **/

	@FindBy(id = "form1:textPhoneNumber1")
	public static WebElement txt_CallsfromPhoneNumber;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "//*[@id='form1:buttonCallCenterAdd']/span")
	public static WebElement Add;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(id = "form1:dropDownDepartment_label")
	public static WebElement dropdown_Department;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "//span[contains(text(),'User: Clearspan Anywhere Phone Number Modify')]")
	public static WebElement text_CSPhonoeNumberModify;

	/**
	 * Page name : OPEASY Provisioning Page Element : Provisioning link
	 **/

	@FindBy(xpath = "(//a[contains(text(),'Provisioning')])[1]")
	public static WebElement link_HeaderProvisioning;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Auto Attendant
	 * Link
	 **/
	@FindBy(xpath = "//a[@id='form1:LeftPane:navigationTree:VirtualUsers:AutoAttendants:AutoAttendants_link']")
	public static WebElement link_AA;

	/**
	 * Page name : OpEasy User Settings Page Element : VoicePortalPassword
	 * Clearspan user
	 **/
	@FindBy(id = "form1:textFieldVoicePortalPassword2")
	public static WebElement voicePortalConfirmPassword;

	/**
	 * Page name : OpEasy User Settings Page Element : UserPassword Clearspan
	 * user
	 **/
	@FindBy(id = "form1:textFieldPassword2")
	public static WebElement ConfirmuserPassword_Clearspan_User;

	/**
	 * Page name : OpEasy Provisioning Page Element : Hunt Groups link
	 **/
	@FindBy(xpath = "//a[contains(text(),'Hunt Groups')]")
	public static WebElement Link_HG;

	/**
	 * Page name : OpEasy export clearspan data Page Element : Hunt Groups link
	 **/
	@FindBy(xpath = "//span[contains(text(),'Hunt Groups ')]")
	public static WebElement checkbox_HG;

	/**
	 * Page name : OpEasy export clearspan data Page Element : Hunt Groups link
	 **/
	@FindBy(xpath = "//span[contains(text(),'Export Clearspan Data')]")
	public static WebElement screen_ExportPage;

	/**
	 * Page name : OpEasy export clearspan data Page Element : Hunt Groups
	 * Alternate Numbers checkbox
	 **/
	@FindBy(xpath = "//span[contains(text(),'HG AlternateNumbers ')]")
	public static WebElement checkbox_HGAlt;

	/**
	 * Page name : OpEasy Users Page Element : Users link
	 **/
	@FindBy(id = "form1:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:rowGroupSearchCriteria:2:columnFieldName:fieldName_list")
	public static WebElement dropdown_UserSearchField3;

	/**
	 * Page name : OpEasy Users Page Element : Users link
	 **/
	@FindBy(id = "form1:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:rowGroupSearchCriteria:3:columnFieldName:fieldName_list")
	public static WebElement dropdown_UserSearchField4;

	/**
	 * Page name : OpEasy Users Page Element : Users link
	 **/
	@FindBy(id = "form1:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:rowGroupSearchCriteria:4:columnFieldName:fieldName_list")
	public static WebElement dropdown_UserSearchField5;

	/**
	 * Page name : OpEasy Export Clearspan Data Page Element : Users link
	 **/
	@FindBy(id = "form1:tableSearchCriteria:rowGroupSearchCriteria:1:columnFieldCondition:fieldCondition_list")
	public static WebElement dropdown_searchOpt2;

	/**
	 * Page name : OpEasy Export Clearspan Data Page Element : Users link
	 **/
	@FindBy(id = "form1:tableSearchCriteria:rowGroupSearchCriteria:0:columnFieldValue:fieldValue_field")
	public static WebElement type_AltPhoneNumber;

	/**
	 * Page name : OpEasy Export Clearspan Data Page Element : Users link
	 **/
	@FindBy(id = "form1:tableSearchCriteria:rowGroupSearchCriteria:1:columnFieldValue:fieldValue_field")
	public static WebElement type_AltExt;

	// Beginning of search related elements

	/**
	 * Page name : OPEASY Provisioning Page Element : User Search Criteria
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':1:columnFieldName:fieldName_list')]]")
	public static WebElement dropdown_UserSearchField2;

	/**
	 * Page name : OPEASY Provisioning Page Element : User Search Criteria
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':0:columnFieldValue:fieldValue_field')]]")
	public static WebElement type_SearchText1;

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':0:columnFieldCondition:fieldCondition_list')]]")
	public static WebElement dropdown_SearchConditionRow1;

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':0:columnFieldCondition:fieldCondition_list')]]")
	public static WebElement type_SearchFilter1;

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(id = "form1:dropDownQueryType_label")
	public static WebElement dropdown_SearchQueryType;

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':0:columnFieldCondition:fieldCondition_list')]]")
	public static WebElement dropdown_searchOpt;

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':1:columnFieldCondition:fieldCondition_list')]]")
	public static WebElement type_SearchFilter2;

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':2:columnFieldCondition:fieldCondition_list')]]")
	public static WebElement type_SearchFilter3;

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':3:columnFieldCondition:fieldCondition_list')]]")
	public static WebElement type_SearchFilter4;

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':4:columnFieldCondition:fieldCondition_list')]]")
	public static WebElement type_SearchFilter5;

	/**
	 * Page name : OPEASY Phone management Page Element : text box
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':0:columnFieldValue:fieldValue_field')]]")
	// form1:UserSearchFragment:tableSearchCriteria:0:fieldName_label
	public static WebElement text_SearchValueRow1;

	/**
	 * Page name : OpEasy Users Page Element : Search text box
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':0:columnRowAdd:buttonRowAdd')]]")
	public static WebElement btn_SearchAddRow1;

	/**
	 * Page name : OpEasy Users Page Element : Search text box
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':0:columnRowAdd:buttonRowAdd')]]")
	public static WebElement btn_rowAdd;

	/**
	 * Page name : OpEasy Users Page Element : Search text box
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':1:columnRowAdd:buttonRowAdd')]]")
	public static WebElement btn_rowAdd1;

	/**
	 * Page name : OpEasy Users Page Element : Search text box
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':2:columnRowAdd:buttonRowAdd')]]")
	public static WebElement btn_rowAdd2;

	/**
	 * Page name : OpEasy Users Page Element : Search text box
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':3:columnRowAdd:buttonRowAdd')]]")
	public static WebElement btn_rowAdd3;

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(xpath = "//a[contains(text(),'User Defined Fields')]")
	public static WebElement link_UDF;

	// /**
	// * Page name : OpEasy Provisioning Page Element : User defined Fields link
	// **/
	// @FindBy(id = "form1:buttonAdd")
	// public static WebElement btn_Add;

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(xpath = ".//*[@id[contains(.,'columnFieldName:fieldName_label')]]")
	public static WebElement findOpt1;

	/**
	 * Page name : OpEasy Users Page Element : User Search text box
	 **/
	@FindBy(id = "form1:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:rowGroupSearchCriteria:0:columnFieldValue:fieldValue_field")
	public static WebElement text_search1;

	/**
	 * Page name : OpEasy Users Page Element : Start Export Button
	 **/
	@FindBy(xpath = "//*[@id='form1:buttonStart']/span")
	public static WebElement btn_StartExport;

	/**
	 * Page name : OpEasy Users Page Element : User Search text box
	 **/
	@FindBy(id = "form1:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:rowGroupSearchCriteria:1:columnFieldValue:fieldValue_field")
	public static WebElement text_search2;

	/**
	 * Page name : OpEasy Export Clearspan Data Page Element : + symbol
	 **/
	@FindBy(id = "form1:tableSearchCriteria:rowGroupSearchCriteria:0:columnRowAdd:buttonRowAdd")
	public static WebElement btn_ExportPlus;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "//*[@id=\"form1:tab1\"]/*[contains(text(),'Optional')]")
	public static WebElement tab_Optional;

	// Beginning of search related elements

	/**
	 * Page name : OPEASY Provisioning Page Element : User Search Criteria
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':0:columnFieldName:fieldName_list')]]")
	public static WebElement dropdown_SearchCriteriarRow1;

	/**
	 * Page name : OPEASY Provisioning Page Element : User Search Criteria
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':0:columnFieldName:fieldName_list')]]")
	public static WebElement dropdown_SearchCriteria;

	/**
	 * Page name : OPEASY Provisioning Page Element : User Search Criteria
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':0:columnFieldName:fieldName_list')]]")
	public static WebElement dropdown_selectField;

	// /**
	// * Page name : OpEasy Provisioning Page Element : User defined Fields link
	// **/
	// @FindBy(xpath =
	// ".//select[@id[contains(.,':0:columnFieldCondition:fieldCondition_list')]]")
	// public static WebElement dropdown_SearchConditionRow1;
	//
	// /**
	// * Page name : OpEasy Provisioning Page Element : User defined Fields link
	// **/
	// @FindBy(xpath =
	// ".//select[@id[contains(.,':0:columnFieldCondition:fieldCondition_list')]]")
	// public static WebElement type_SearchFilter1;
	//
	// /**
	// * Page name : OpEasy Provisioning Page Element : User defined Fields link
	// **/
	// @FindBy(xpath =
	// ".//select[@id[contains(.,':0:columnFieldCondition:fieldCondition_list')]]")
	// public static WebElement dropdown_searchOpt;
	//
	// /**
	// * Page name : OpEasy Provisioning Page Element : User defined Fields link
	// **/
	// @FindBy(xpath =
	// ".//select[@id[contains(.,':1:columnFieldCondition:fieldCondition_list')]]")
	// public static WebElement type_SearchFilter2;
	//
	// /**
	// * Page name : OpEasy Provisioning Page Element : User defined Fields link
	// **/
	// @FindBy(xpath =
	// ".//select[@id[contains(.,':2:columnFieldCondition:fieldCondition_list')]]")
	// public static WebElement type_SearchFilter3;
	//
	// /**
	// * Page name : OpEasy Provisioning Page Element : User defined Fields link
	// **/
	// @FindBy(xpath =
	// ".//select[@id[contains(.,':3:columnFieldCondition:fieldCondition_list')]]")
	// public static WebElement type_SearchFilter4;
	//
	// /**
	// * Page name : OpEasy Provisioning Page Element : User defined Fields link
	// **/
	// @FindBy(xpath =
	// ".//select[@id[contains(.,':4:columnFieldCondition:fieldCondition_list')]]")
	// public static WebElement type_SearchFilter5;

	//
	// /**
	// * Page name : OpEasy Users Page Element : Search text box
	// **/
	// @FindBy(xpath =
	// ".//input[@id[contains(.,':1:columnRowAdd:buttonRowAdd')]]")
	// public static WebElement btn_rowAdd1;
	//
	// /**
	// * Page name : OpEasy Users Page Element : Search text box
	// **/
	// @FindBy(xpath =
	// ".//input[@id[contains(.,':2:columnRowAdd:buttonRowAdd')]]")
	// public static WebElement btn_rowAdd2;
	//
	// /**
	// * Page name : OpEasy Users Page Element : Search text box
	// **/
	// @FindBy(xpath =
	// ".//input[@id[contains(.,':3:columnRowAdd:buttonRowAdd')]]")
	// public static WebElement btn_rowAdd3;
	//

	/**
	 * Page name : OPEASY Provisioning Page Element : User Search Criteria
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':1:columnFieldName:fieldName_list')]]")
	public static WebElement dropdown_SearchCriteriarRow2;

	/**
	 * Page name : OPEASY Provisioning Page Element : User Search Criteria
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':1:columnFieldName:fieldName_list')]]")
	public static WebElement dropdown_selectField2;

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':1:columnFieldCondition:fieldCondition_list')]]")
	public static WebElement dropdown_SearchConditionRow2;

	/**
	 * Page name : OPEASY Phone management Page Element : text box
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':1:columnFieldValue:fieldValue_field')]]")
	public static WebElement text_SearchValueRow2;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':1:columnRowDelete:buttonRowDelete')]]")
	public static WebElement btn_SearchDeleteRow2;

	/**
	 * Page name : OPEASY Provisioning Page Element : User Search Criteria
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':2:columnFieldName:fieldName_list')]]")
	public static WebElement dropdown_SearchCriteriarRow3;

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':2:columnFieldCondition:fieldCondition_list')]]")
	public static WebElement dropdown_SearchConditionRow3;

	/**
	 * Page name : OPEASY Phone management Page Element : text box
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':2:columnFieldValue:fieldValue_field')]]")
	public static WebElement text_SearchValueRow3;

	/**
	 * Page name : OPEASY Phone management Page Element : text box
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':1:columnFieldValue:fieldValue_field')]]")
	public static WebElement type_SearchText2;

	/**
	 * Page name : OPEASY Phone management Page Element : text box
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':2:columnFieldValue:fieldValue_field')]]")
	public static WebElement type_SearchText3;

	/**
	 * Page name : OPEASY Phone management Page Element : text box
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':3:columnFieldValue:fieldValue_field')]]")
	public static WebElement type_SearchText4;

	/**
	 * Page name : OPEASY Phone management Page Element : text box
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':4:columnFieldValue:fieldValue_field')]]")
	public static WebElement type_SearchText5;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':2:columnRowDelete:buttonRowDelete')]]")
	public static WebElement btn_SearchDeleteRow3;

	/**
	 * Page name : OPEASY Provisioning Page Element : User Search Criteria
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':3:columnFieldName:fieldName_list')]]")
	public static WebElement dropdown_SearchCriteriarRow4;

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':3:columnFieldCondition:fieldCondition_list')]]")
	public static WebElement dropdown_SearchConditionRow4;

	/**
	 * Page name : OPEASY Phone management Page Element : text box
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':3:columnFieldValue:fieldValue_field')]]")
	public static WebElement text_SearchValueRow4;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':3:columnRowDelete:buttonRowDelete')]]")
	public static WebElement btn_SearchDeleteRow4;

	/**
	 * Page name : OPEASY Provisioning Page Element : User Search Criteria
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':4:columnFieldName:fieldName_list')]]")
	public static WebElement dropdown_SearchCriteriarRow5;

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':4:columnFieldCondition:fieldCondition_list')]]")
	public static WebElement dropdown_SearchConditionRow5;

	/**
	 * Page name : OPEASY Phone management Page Element : text box
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':4:columnFieldValue:fieldValue_field')]]")
	public static WebElement text_SearchValueRow5;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = ".//input[@id[contains(.,':4:columnRowDelete:buttonRowDelete')]]")
	public static WebElement btn_SearchDeleteRow5;

	// Good ones end here

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(id = "form1:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:rowGroupSearchCriteria:1:columnFieldName:fieldName_list")
	public static WebElement findOpt2;

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,':0:columnFieldCondition:fieldCondition_list')]]")
	public static WebElement findFilter1;

	/**
	 * Page name : OpEasy Provisioning Page Element : User defined Fields link
	 **/
	@FindBy(id = "form1:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:rowGroupSearchCriteria:1:columnFieldCondition:fieldCondition_list")
	public static WebElement findFilter2;

	// End of search related elements

	/**
	 * Page name : OpEasy Advanced User Modify Page Element : Alternate User Id1
	 * text box
	 **/
	@FindBy(id = "form1:textFieldAlternateId1UserID")
	public static WebElement text_altUserId1;

	/**
	 * Page name : OpEasy Advanced User Modify Page Element : Alternate User Id1
	 * text box
	 **/
	@FindBy(id = "form1:textFieldAlternateId2User")
	public static WebElement text_altUserId2;
	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "//a[contains(text(),'New User E-mail Notification')]")
	public static WebElement link_UserEmailNotification;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "//span[contains(text(),'New User E-mail Message')]")
	public static WebElement text_EmailMessage;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "//span[contains(text(),'From')]")
	public static WebElement text_From;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "//span[contains(text(),'User General Settings: New User E-mail Notification')]")
	public static WebElement text_UserSettingsEmailNotif_ScreenName;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "((.//*[@id='form1:tableFields_data']//tr[last()-1]//span)//select)[1]")
	public static WebElement type_strAdmin;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "((.//*[@id='form1:tableFields_data']//tr[last()-1]//span)//select)[2]")
	public static WebElement type_strvalue;
	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "//span[contains(text(),'Enterprise Phone Numbers')]")
	public static WebElement text_EntPhoneNumbers;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "(.//*[@id='form1:tableFields_data']//tr[1]//input)[1]")
	public static WebElement type_name;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "//a[contains(text(),'User Defined Fields')]")
	public static WebElement Link_userdefinedfields;

	/**
	 * Page name : OpEasy Hunt group Modify Page Element : User Defined Fields
	 **/
	@FindBy(xpath = "//span[contains(text(),'User Defined Fields')]")
	public static WebElement text_userdefinedfields;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "//span[contains(text(),'Enterprise User Defined Fields')]")
	public static WebElement text_EntUserdEfinedFields;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(id = "form1:layoutPanelTable:tableFields:_table")
	public static WebElement table_EntUserFields;

	/**
	 * Page name : Enterprise phone Numbers Page Element : Users link
	 **/
	@FindBy(id = "form1:checkboxIncludeEnterprisePhoneNumbersInLists_cb")
	public static WebElement text_checkboxphonenumberlist;

	/**
	 * Page name : Enterprise Settings Page Element : Users link
	 **/
	@FindBy(id = "form1:hyperlinkEnterprisePhoneNumbers")
	public static WebElement link_phonenumbers;

	/**
	 * Page name : OpEasy User Profiles modify Page Element : User Profiles
	 * modify
	 **/
	@FindBy(xpath = "//span[contains(text(),'User Profile Modify')]")
	public static WebElement text_UserProfileModify;

	/**
	 * Page name : OpEasy User Profiles modify Page Element : User Profiles
	 * modify
	 **/
	@FindBy(xpath = "//legend[contains(text(),'User Defined Fields')]")
	public static WebElement text_userdefinedfield;

	/**
	 * Page name : OpEasy User Profiles modify Page Element : User Profiles
	 * modify
	 **/
	@FindBy(id = "form1:tableFields:_table]")
	public static WebElement text_userdefinedtable;

	/**
	 * Page name : OpEasy User Profiles Page Element : User Profiles Page
	 **/
	@FindBy(id = "form1:layoutPanelUserBillingType:dropDownBillingUsertype")
	public static WebElement text_UserBillingTypeDropdown;

	/**
	 * Page name : OpEasy User Profiles Page Element : User Profiles Page
	 **/
	@FindBy(xpath = "(//span[contains(text(),'User Profiles')])")
	public static WebElement text_Userprofiles;

	/**
	 * Page name : OPEASY Import Page Element : Department Link
	 **/
	@FindBy(xpath = "//span[contains(text(), 'Automation_Modify')]")
	public static WebElement Ent_Department_Link;

	/**
	 * Page name : OPEASY Enterprise departments Page Element : Import Link
	 **/
	@FindBy(xpath = "(//a[contains(.,'Import')])[1]")
	public static WebElement Link_Import;

	/**
	 * Page name : OPEASY Enterprise departments Page Element : Import Link
	 **/
	@FindBy(id = "//*[@id='form1:LeftPane:navigationTree:2']/span/span[3]/a")
	public static WebElement importNavigate_Link;

	/**
	 * Page name : OPEASY Phone management Page Element : Device name drop down
	 * list
	 **/
	@FindBy(id = "form1:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:rowGroupSearchCriteria:0:columnFieldCondition:fieldCondition_list")
	public static WebElement searchopt_dropdown;

	/**
	 * Page name : OPEASY Phone management Page Element : text box
	 **/
	@FindBy(xpath = "//input[@value='Search']")
	public static WebElement btn_Search;

	/**
	 * Page name : OPEASY Phone management Page Element : text box
	 **/
	@FindBy(xpath = "//a[contains(.,'Edit')]")
	public static WebElement Edit_link;

	/**
	 * Page name : OPEASY Import Page Element : Phone Management Link
	 **/

	@FindBy(id = "form1:LeftPane:navigationTree:PhoneManagement:PhoneManagement_link")
	public static WebElement PhoneManagementNavigate_Link;

	// /**
	// * Page name : OPEASY Advanced User Modify Page
	// * Element : User Billing Type drop down
	// **/
	// @FindBy(xpath =
	// "html/body/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td/div/span[2]/span/select")
	// public static WebElement dropdown_BillingType;
	//
	/**
	 * Page name : OPEASY Enterprise Departments Page Element : Department
	 **/

	@FindBy(xpath = "//span[contains(.,'Automation_Modify')]//span")
	public static WebElement text_ModifyDept;

	/**
	 * Page name : OPEASY Component Status Page Element : Component Status
	 **/

	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement text_Provisioning_ScreenName;

	/**
	 * Page name : OPEASY Enterprise Departments Page Element : Department
	 **/

	@FindBy(xpath = "//span[contains(.,'Automation')]//span")
	public static WebElement text_Dept;

	/**
	 * Page name : OPEASY Users Page Element : Users
	 **/

	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement text_Users_ScreenName;

	/**
	 * Page name : OPEASY Users Page Element : GeneralSettings Button
	 **/

	@FindBy(xpath = "//*[@id='form1:buttonGeneralSettings']/span")
	public static WebElement btn_GeneralSettings;

	/**
	 * Page name : OPEASY General Settings Page Element : User Settings link
	 **/

	@FindBy(id = "form1:hyperlinkUserSettings")
	public static WebElement link_UserSettings;

	/**
	 * Page name : OPEASY General Settings Page Element : User Settings link
	 **/

	@FindBy(xpath = "//span[contains(text(),'General Settings')]")
	public static WebElement text_GeneralSettings;

	/**
	 * Page name : OPEASY Users Page Element : Users
	 **/

	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement text_UserSettings_ScreenName;

	/**
	 * Page name : OPEASY User settings Page Element : Enterprise drop down
	 **/

	@FindBy(id = "form1:dropDownPhoneManufacturer_label")
	public static WebElement dropdown_manufacturer;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:staticTextEnterprise")
	public static WebElement label_EnterpriseName;

	/**
	 * Page name : OpEasy User Settings Page Element : Used user count
	 **/
	@FindBy(xpath = "//span[text()='Used:']")

	public static WebElement used_user_Count;

	/**
	 * Page name : OpEasy User Settings Page Element : System Settings Label
	 **/
	@FindBy(xpath = "//*[text()='System Settings']")
	public static WebElement text_SystemSettings_ScreenName;

	/**
	 * Page name : OpEasy User Settings Page Element : EnterpriseSettings Label
	 **/
	@FindBy(xpath = "//*[text()='Enterprise Settings']")
	public static WebElement text_EnterpriseSettings_ScreenName;

	/**
	 * Page name : OpEasy User Settings Page Element : Group Settings Label
	 **/
	@FindBy(xpath = "//*[text()='Group Settings']")
	public static WebElement text_GroupSettings_ScreenName;

	/**
	 * Page name : OpEasy User Settings Page Element : Advanced User Add
	 **/
	@FindBy(xpath = "//span[text()='Advanced: User Add']")
	public static WebElement advanced_User_Display;

	/**
	 * Page name : OpEasy User Settings Page Element : Lastname Clearspan user
	 **/
	@FindBy(id = "form1:textFieldLastName")
	public static WebElement lastname_Clearspan_User;

	/**
	 * Page name : OpEasy User Settings Page Element : Firstname Clearspan user
	 **/
	@FindBy(id = "form1:textFieldFirstName")
	public static WebElement firstname_Clearspan_User;

	/**
	 * Page name : OpEasy User Settings Page Element : PhoneNumber Clearspan
	 * user
	 **/
	@FindBy(id = "form1:dropDownPhoneNumber_label")
	public static WebElement phoneNumber_AdvanceUser;

	/**
	 * Page name : OpEasy User Settings Page Element : PhoneNumber Basic user
	 **/
	@FindBy(id = "form1:dropDownPhoneNumber_label")
	public static WebElement phoneNumber_BasicUser;

	/**
	 * Page name : OpEasy User Settings Page Element : Activated Display
	 * Clearspan user
	 **/
	@FindBy(xpath = "(//span[contains(text(),'Activated')])[1]")
	public static WebElement activated_Button;

	/**
	 * Page name : OpEasy User Settings Page Element : Extension Clearspan user
	 **/
	@FindBy(id = "form1:textFieldExtension")
	public static WebElement extension_Number;

	/**
	 * Page name : OpEasy User Settings Page Element : VoicePortalPassword
	 * Clearspan user
	 **/
	@FindBy(id = "form1:textFieldVoicePortalPassword")
	public static WebElement voicePortalPassword_Clearspan_User;

	/**
	 * Page name : OpEasy User Settings Page Element : UserPassword Clearspan
	 * user
	 **/
	@FindBy(id = "form1:textFieldPassword")
	public static WebElement userPassword_Clearspan_User;

	/**
	 * Page name : OpEasy User Settings Page Element : Email User Notification
	 **/
	@FindBy(id = "form1:textFieldNewUserProcurementEmailAddress")
	public static WebElement email_User_Notification;

	/**
	 * Page name : OpEasy User Settings Page Element : Email Clearspan user
	 **/

	@FindBy(id = "form1:textFieldPassword")
	public static WebElement Email_Clearspan_User;

	/**
	 * Page name : OpEasy User Settings Page Element : Clearspan user Id
	 **/
	@FindBy(id = "form1:textFieldUserIdUserName")
	public static WebElement clearspan_UserID;

	/**
	 * Page name : OpEasy User Settings Page Element : Calling Line Lastname
	 **/
	@FindBy(id = "form1:textFieldCLIDLastName")
	public static WebElement calling_Line_Lastname;

	/**
	 * Page name : OpEasy User Settings Page Element : Calling Line Firstname
	 **/
	@FindBy(id = "form1:textFieldCLIDFirstName")
	public static WebElement calling_Line_Firstname;

	/**
	 * Page name : OpEasy User Settings Page Element : Sorting Icon
	 **/
	@FindBy(id = "form1:tableQueryResults:_tableActionsTop:_sortPanelToggleButton:_sortPanelToggleButton_image")
	public static WebElement sorting_Icon;

	/**
	 * Page name : OpEasy User Settings Page Element : Modify Clearspan User
	 * Display
	 **/
	@FindBy(xpath = "//span[text()='Modify an existing Clearspan user.']")
	public static WebElement modify_ClearspanUser_Display;

	/**
	 * Page name : OpEasy User Settings Page Element : Delete Button
	 **/
	@FindBy(xpath = "//input[@id[contains(., ':buttonDelete')]]")
	public static WebElement delete_Button;

	/**
	 * Page name : OpEasy User Settings Page Element : Clearspan user Id
	 **/
	@FindBy(id = "form1:textFieldUserIdUserName")
	public static WebElement Clearspan_UserID;

	/**
	 * Page name : OpEasy User Settings Page Element : Calling Line Lastname
	 **/
	@FindBy(id = "form1:textFieldCLIDLastName")
	public static WebElement Calling_Line_Lastname;

	/**
	 * Page name : OpEasy User Settings Page Element : Calling Line Firstname
	 **/
	@FindBy(id = "form1:textFieldCLIDFirstName")
	public static WebElement Calling_Line_Firstname;
	
	/**
	 * Page name : OpEasy User Settings Page Element : Calling Line Lastname
	 **/
	@FindBy(xpath = "//input[@id[contains(., 'CLIDLastName')]]")
	public static WebElement Calling_LineID_Lastname;
	
	/**
	 * Page name : OpEasy User Settings Page Element : Calling Line Lastname
	 **/
	@FindBy(xpath = "//input[@id[contains(., 'CLIDFirstName')]]")
	public static WebElement Calling_LineID_Firstname;

	/**
	 * Page name : OpEasy User Settings Page Element : Ok Button For Create User
	 **/
	@FindBy(id = "form1:buttonOK")
	public static WebElement Ok_Button;

	/**
	 * Page name : OpEasy User Settings Page Element : Search For Announcement
	 * page
	 **/
	@FindBy(id = "form1:LeftPane:navigationTree:GroupSettings:GroupAnnouncements:GroupAnnouncements_link")
	public static WebElement Announcements_Button1;

	/**
	 * Page name : OpEasy User Settings Page Element : Search For Announcement
	 * page
	 **/
	@FindBy(id = "form1:tableAnnouncements:rowGroupAnnouncements:4:tableColumnSelected")
	public static WebElement WarChant_Row;

	/**
	 * Page name : OpEasy User Settings Page Element : Sorting Icon
	 **/
	@FindBy(id = "form1:tableQueryResults:_tableActionsTop:_sortPanelToggleButton:_sortPanelToggleButton_image")
	public static WebElement Sorting_Icon;

	/**
	 * Page name : OpEasy User Settings Page Element : Modify Clearspan User
	 * Display
	 **/
	@FindBy(xpath = "//span[text()='Modify an existing Clearspan user.']")
	public static WebElement Modify_ClearspanUser_Display;

	/**
	 * Page name : OpEasy User Settings Page Element : Virtual User Link
	 **/
	@FindBy(id = "form1:hyperlinkVirtualUsers")
	public static WebElement virtualUser_Link;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Virtual User
	 * ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Virtual User Inventory']")
	public static WebElement virtualUser_Screen;

	/**
	 * Page name : OpEasy Hunt Group Modify Page Element : Virtual User
	 * ScreenName
	 **/
	@FindBy(xpath = "//span[contains(text(),'Hunt Group Modify')]")
	public static WebElement text_HGModify;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Auto Attendant
	 * Link
	 **/
	@FindBy(id = "form1:hyperlinkAutoAttendants")
	public static WebElement autoAttendant_Link;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Auto Attendant
	 * ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Auto Attendants']")
	public static WebElement autoAttendant_Screen;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Auto Attendant
	 * Add ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Auto Attendant Add']")
	public static WebElement autoAttendantAdd_Screen;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Auto Attendant
	 * Name Field
	 **/
	@FindBy(id = "form1:textFieldName")
	public static WebElement autoAttName_Field;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Auto Attendant ID
	 **/
	@FindBy(id = "form1:textFieldAutoAttendantIdAutoAttendantName")
	public static WebElement autoAttID_Field;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Auto Attendant
	 * Type
	 **/
	@FindBy(id = "form1:dropDownAutoAttendantType_label")
	public static WebElement autoAtt_Type;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Auto Attendant
	 * NetworkServerSite
	 **/
	// @FindBy(id =
	// "form1:layoutPanelNetworkServerSite:dropDownNetworkServerSite_list")
	@FindBy(xpath = "form1:dropDownNetworkServerSite_label")
	public static WebElement autoAtt_NetworkServerSite;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Auto Attendant
	 * Last Name
	 **/
	@FindBy(id = "form1:textFieldCLIDLastName")
	public static WebElement autoAtt_LastName;

	/**
	 * Page name : OpEasy User Settings Page Element : Button
	 **/
	@FindBy(id = "form1:textFieldName")
	public static WebElement txt_VUAA_Name;

	/**
	 * Page name : OpEasy User Settings Page Element : OK Button
	 **/
	@FindBy(id = "form1:textFieldAutoAttendantIdAutoAttendantName")
	public static WebElement txt_AA_ID;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Auto Attendant
	 * First Name
	 **/
	@FindBy(id = "form1:textFieldCLIDFirstName")
	public static WebElement autoAtt_FirstName;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Auto Attendant
	 * SearchQuery
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,'dropDownQueryType_label")
	public static WebElement autoAtt_SearchQuery;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Auto Attendant
	 * SearchComparison
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,'dropDownQueryComparison_list')]]")
	public static WebElement autoAtt_SearchComparison;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Auto Attendant
	 * SearchValue
	 **/
	@FindBy(id = "form1:layoutPanelAutoAttendantSearch:layoutPanelAutoAttendantSearchOptions:textInputQueryValue_field")
	public static WebElement autoAtt_SearchValue;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Auto Attendant
	 * Modify Screen
	 **/
	@FindBy(xpath = "//span[text()='Auto Attendant Modify']")
	public static WebElement autoAtt_ModifyScreens;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Hunt Group Link
	 **/
	@FindBy(id = "form1:hyperlinkGroupHuntGroups")
	public static WebElement huntGroup_Link;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Hunt Group
	 * ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Hunt Groups']")
	public static WebElement huntGroup_Screen;

	/**
	 * Page name : OpEasy Hunt Group Add page ScreenName
	 **/
	@FindBy(xpath = "//span[contains(.,'Hunt Group Add')][1]//span")
	public static WebElement huntGroupAdd_Screen;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Flexible Seating
	 * Hosts Link
	 **/
	@FindBy(id = "form1:hyperlinkFlexSeatingHosts")
	public static WebElement flexibleSeatingHost_Link;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Flexible Seating
	 * Hosts ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Flexible Seating Hosts']")
	public static WebElement flexibleSeatingHost_Screen;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Hunt Group Add
	 * ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Flexible Seating Host Add']")
	public static WebElement flexSeatingHostAdd_Screen;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Hunt Group Search
	 * Button
	 **/
	@FindBy(xpath = "//input[@value='Search']")
	public static WebElement flexibleHost_Search;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Authentication
	 * Name
	 **/
	@FindBy(id = "form1:textFieldAuthenticationName")
	public static WebElement authentication_Name;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(xpath = "//option[@value='Alternate Numbers']")
	public static WebElement dropdown_altNumUserService;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:extension")
	public static WebElement type_extension;

	/**
	 * Page name : OPEASY Provisioning Page Element : btn_ServiceRemove
	 **/

	@FindBy(xpath = "//span[contains(text(),'Failure provisioning Alternate Numbers: OCI Error: [Error 4202] Extension is already assigned to another user:')]")
	public static WebElement error_sameExt;

	/**
	 * Page name : OPEASY Provisioning Page Element : btn_ServiceRemove
	 **/

	@FindBy(xpath = "//span[contains(text(),'Failure provisioning Alternate Numbers: OCI Error: [Error 4909] Invalid extension.  The extension length for this group India:BNG_4 is 4 to 4 digits long.')]")
	public static WebElement error_invalidExt;

	/**
	 * Page name : OPEASY Provisioning Page Element : btn_ServiceRemove
	 **/

	@FindBy(xpath = "//span[contains(text(),'Failure provisioning Alternate Numbers: OCI Error: [Error 4910] Invalid extension.  The extension can only contain characters 0-9.')]")
	public static WebElement error_invalidExtension;

	/**
	 * Page name : OPEASY Provisioning Page Element : btn_ServiceRemove
	 **/

	@FindBy(xpath = "(//select)[4]")
	public static WebElement dropdown_SameAltNumber;

	/**
	 * Page name : OPEASY Provisioning Page Element : btn_ServiceRemove
	 **/

	@FindBy(xpath = "//span[contains(text(),'Failure provisioning Alternate Numbers: OCI Error: [Error 4201] Phone number is not available for assignment:')]")
	public static WebElement error_PhNumberNA;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Authentication
	 * Name
	 **/
	@FindBy(id = "form1:textFieldAuthenticationPassword")
	public static WebElement authentication_Password;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Authentication
	 * Name
	 **/
	@FindBy(id = "form1:textFieldAuthenticationPassword2")
	public static WebElement authentication_ConfirmPassword;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Virtual User
	 * Inventory Link
	 **/
	@FindBy(linkText = "Virtual User Inventory")
	public static WebElement virtual_User_Inventory_Link;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Virtual User
	 * Inventory ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Virtual User Inventory']")
	public static WebElement virtual_User_Inventory_Screen;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Flex Seating Host
	 * Name
	 **/
	@FindBy(id = "form1:textFieldName")
	public static WebElement flexSeatingHost_Name;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Flex Seating Host
	 * ID
	 **/
	@FindBy(xpath = "//input[@id='form1:textFieldFlexibleSeatingHostIdFlexibleSeatingHostName']")
	public static WebElement flexSeatingHost_ID;

	/**
	 * Page name : OpEasy User Settings Page Element : Phone Tab In Flexible
	 * Host
	 **/
	@FindBy(xpath = "//*[@id='form1:tab2']/span")
	public static WebElement phoneTab_FlexibleHost;

	/**
	 * Page name : OpEasy User Settings Page Element : Phone Devices ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Phone Devices']")
	public static WebElement phoneDevices_Screen;

	/**
	 * Page name : OpEasy User Settings Page Element : Add Primary Phone
	 **/
	@FindBy(id = "form1:buttonAddPrimaryPhone")
	public static WebElement add_Primary_Phone;

	/**
	 * Page name : OpEasy User Settings Page Element : Phone Devices ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Flexible Seating Host: Primary Phone Device Add']")
	public static WebElement add_Primary_Phone_Display;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Flexible Seating
	 * Host Modify screen
	 **/
	@FindBy(xpath = "//span[text()='Flexible Seating Host Modify']")
	public static WebElement flexHost_ModifyScreen;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : flex Seating Host
	 * SearchQuery
	 **/

	@FindBy(xpath = ".//select[@id[contains(.,'dropDownQueryType_list')]]")
	public static WebElement flexSeatingHost_SearchQuery;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : flex Seating Host
	 * SearchOption
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,'dropDownQueryComparison_list')]]")
	public static WebElement flexSeatingHost_SearchOption;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : flex Seating Host
	 * SearchValue
	 **/
	@FindBy(id = "form1:textInputQueryValue")
	public static WebElement flexSeatingHost_SearchValue;

	/**
	 * Page name : OPEASY Provisioning Page Element : Import Link
	 **/
	@FindBy(id = "form1:hyperlinkImport")
	public static WebElement import_Link;

	/**
	 * Page name : OPEASY Provisioning Page Element : Provisioning link
	 **/

	@FindBy(id = "form1:HeaderPane:hyperlinkProvisioning")
	public static WebElement HeaderProvisioning;

	/**
	 * Page name : OPEASY Provisioning Page Element : Import Screen
	 **/

	@FindBy(xpath = "//span[text()='Import']")
	public static WebElement import_ScreenName;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Get Worksheet
	 * Button
	 **/
	@FindBy(id = "form1:buttonGetWorksheet")
	public static WebElement button_GetWorksheet;

	/**
	 * Page name : OPEASY Provisioning Page Element : Start Import Button
	 **/

	@FindBy(xpath = "//*[@id='form1:buttonStart']/span")
	public static WebElement start_Import_Button;

	/**
	 * Page name : OPEASY Provisioning Page Element : Import Type
	 **/

	@FindBy(id = "form1:cbImportType_label")
	public static WebElement dropdown_ImportType;

	/**
	 * Page name : OPEASY Provisioning Page Element : ChooseFile Button
	 **/

	@FindBy(id = "form1:fileUploadSpreadsheet")
	public static WebElement chooseFile_Button;
	
	/**
	 * Page name : OPEASY Provisioning Page Element : ChooseFile Button
	 **/

	@FindBy(xpath = "//span[@id[contains(., 'UploadSpreadsheet')]]")
	public static WebElement ChooseFile_Button;

	/**
	 * Page name : OPEASY Provisioning Page Element : ChooseFile Button
	 **/

	@FindBy(id = "form1:fileUploadSpreadsheet")
	public static WebElement btn_ProvisionSpreadsheet;

	/**
	 * Page name : OPEASY Provisioning Page Element : Import Queue ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Export queued to start']")
	public static WebElement Export_Queue_ScreenName;

	/**
	 * Page name : OPEASY Provisioning Page Element : Import Queue ScreenName
	 **/
	@FindBy(id = "form1:hyperlinkPhoneManagement")
	public static WebElement link_PhoneManagement;
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management 
	 **/
	@FindBy(xpath = "//a[contains( .,'Phone Management')]")
	public static WebElement btn_PhoneManagement;

	/**
	 * Page name : OPEASY Provisioning Page Element : Refresh Import
	 **/
	@FindBy(xpath = "//*[@id='form1:buttonRefresh']/span")
	public static WebElement btn_Refresh;

	/**
	 * Page name : OPEASY Provisioning Page Element : Refresh Import
	 **/
	@FindBy(xpath = "//*[@id='form1:buttonDeleteResults']/span")
	public static WebElement btn_DeleteImportResults;

	/**
	 * Page name : OPEASY Provisioning Page Element : Result Completed
	 **/
	@FindBy(xpath = "//span[contains(text(),'Completed')]")
	public static WebElement import_Results;

	/**
	 * Page name : OPEASY Provisioning Page Element : Result Completed
	 **/
	@FindBy(xpath = "//span[@id='form1:staticTextResults']")
	public static WebElement text_importResults;

	/**
	 * Page name : OPEASY Provisioning Page Element : Result Completed
	 **/
	@FindBy(id = "form1:HeaderPane:hyperlinkProvisioning")
	public static WebElement link_provisioning;

	/**
	 * Page name : OPEASY Provisioning Page Element : Result Completed
	 **/
	@FindBy(id = "form1:HeaderPane:groupPanel1:hyperlinkProvisioning")
	public static WebElement link_provisioning_top;

	/**
	 * Page name : OPEASY Provisioning Page Element : Result Completed
	 **/
	@FindBy(id = "form1:textResultsDetails")
	public static WebElement import_Results_multiline;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Select User Profile
	 **/
	@FindBy(id = "form1:dropDownUserProfile_label")
	public static WebElement user_profile;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Group Setting Link
	 **/
	@FindBy(xpath = "//span[text()='Group Settings']")
	public static WebElement groupSetting_Screen;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Query Comparison Search
	 **/
	@FindBy(id = "form1:dropDownQueryComparison_label")
	public static WebElement queryComparison_Search;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(linkText = "Phone Management")
	public static WebElement phoneManagement_Link;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "(//a[contains(.,'Phone Management')])[1]")
	public static WebElement link_phoneManagement;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management
	 * ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Phone Management']")
	public static WebElement phoneManagement_ScreenName;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Device Add
	 * ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Phone Device Add']")
	public static WebElement phoneDeviceAdd_ScreenName;

	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceName For Phone
	 * Management
	 **/

	@FindBy(id = "form1:textInputDeviceName")
	public static WebElement device_Name;
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceName For Phone
	 * Management
	 **/

	@FindBy(xpath = "(//input[@id[contains(., 'DeviceName')]])[2]")
	public static WebElement device_FieldName;

	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/

	@FindBy(id = "form1:dropDownDeviceLevel_label")
	public static WebElement device_Level;

	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceType For Phone
	 * Management
	 **/

	@FindBy(id = "form1:dropDownDeviceType_label")
	public static WebElement device_Type;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Template For Phone
	 * Management
	 **/

	@FindBy(id = "form1:dropDownTemplate_label")
	public static WebElement template;

	/**
	 * Page name : OPEASY Provisioning Page * Element : View Template Button
	 **/
	@FindBy(id = "form1:buttonViewTemplate")
	public static WebElement view_Template;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Location
	 **/

	@FindBy(id = "form1:textInputPhysicalLocation")
	public static WebElement phone_Location;

	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/

	@FindBy(id = "form1:dropDownDeviceLevels")
	public static WebElement device_Levels;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Hunt Group Name
	 * Field
	 **/
	@FindBy(id = "form1:textFieldName")
	public static WebElement huntGrpName_Field;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Hunt Group ID
	 **/
	@FindBy(id = "form1:textFieldHuntGroupIdHuntGroupName")
	public static WebElement huntGrpID_Field;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Hunt Group
	 * LastName
	 **/
	@FindBy(id = "form1:textFieldCLIDLastName")
	public static WebElement huntGrp_LastName;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Hunt Group
	 * FirstName
	 **/
	@FindBy(id = "form1:textFieldCLIDFirstName")
	public static WebElement huntGrp_FirstName;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Hunt Group
	 * SearchQuery
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,'dropDownQueryType_list')]]")
	public static WebElement huntGrp_SearchQuery;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Hunt Group
	 * SearchOption
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,'dropDownQueryComparison_list')]]")
	public static WebElement huntGrp_SearchOption;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Hunt Group
	 * SearchValue
	 **/
	@FindBy(id = "form1:layoutPanelHuntGroupSearch:layoutPanelHuntGroupSearchOptions:textInputQueryValue_field")
	public static WebElement huntGrp_SearchValue;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Hunt Group Modify
	 * screen
	 **/
	@FindBy(xpath = "//span[text()='Hunt Group Modify']")
	public static WebElement huntGrp_ModifyScreen;

	/**
	 * Page name : OpEasy Virtual User Settings Page Element : Hunt Group Add
	 * ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Hunt Group Add']")
	public static WebElement huntGrpAdd_Screen;

	// /**
	// * Page name : OPEASY Provisioning Page Element : ChooseFile Button
	// **/
	// @FindBy(xpath = ".//*[@id[contains(.,
	// ':fileUploadSpreadsheet_com.sun.webui.jsf.upload')]]")
	// public static WebElement ChooseFile_Button;

	/**
	 * Page name : OPEASY Provisioning Page Element : txt_ChoosenFile
	 **/
	@FindBy(id = "form1:layoutPanelSpreadsheet:fileUploadSpreadsheet_com.sun.webui.jsf.upload")
	public static WebElement txt_ChoosenFile;

	/**
	 * Page name : OPEASY Provisioning Page Element : Result Completed
	 **/
	@FindBy(id = "form1:buttonDownloadResults")
	public static WebElement retrieve_Results;

	/**
	 * Page name : OpEasy User Settings Page Element : Search For Announcement
	 * page
	 **/
	@FindBy(xpath = "//input[@value='Phones']")
	public static WebElement btn_Phones;

	/**
	 * Page name : OpEasy User Settings Page Element : Search For Announcement
	 * page
	 **/
	@FindBy(xpath = "//input[@value='Add Primary Phone']")
	public static WebElement btn_addprimaryphone;

	/**
	 * Page name : OpEasy User Settings Page Element : Search For Announcement
	 * page
	 **/
	@FindBy(id = "form1:textInputDeviceName")
	public static WebElement text_deviceName;

	/**
	 * Page name :Group Announcement Repository Page Element :
	 * GroupAnnouncementRepository Page
	 **/
	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement text_static_ScreenName;
	/**
	 * Page name :User Primary Phone Device Add Element : Line/port text box
	 **/
	@FindBy(id = "form1:textFieldLinePortUserName")
	public static WebElement text_LineID;

	/**
	 * Page name :User Primary Phone Device Add Element : Line/port text box
	 **/
	@FindBy(id = "form1:textInputMacAddress")
	public static WebElement text_MACaddress;

	/**
	 * Page name : OPEASY Provisioning Page Element : Get Worksheet Button
	 **/

	@FindBy(id = "form1:buttonGetWorksheet")
	public static WebElement get_worksheet_Button;

	/**
	 * Page name : OPEASY Provisioning Page Element : Add Basic User ScreenName
	 **/

	@FindBy(xpath = "//span[text()='User Add']")

	public static WebElement basic_User_ScreenName;

	/**
	 * Page name : OPEASY Login page Element : Login
	 **/

	@FindBy(xpath = "html/body/form/span[4]/span")
	public static WebElement Login_page;

	/**
	 * Page name : OPEASY Provisioning Page Element : Group Setting Link
	 **/

	@FindBy(id = "form1:hyperlinkGroupSettings")
	public static WebElement groupSetting_Link;

	/**
	 * Page name : OPEASY Provisioning Page Element : Announcement Repository
	 * Link
	 **/

	@FindBy(id = "form1:hyperlinkAnnouncements")
	public static WebElement announcementRepository_Link;

	/**
	 * Page name : OPEASY Provisioning Page Element : Announcement Repository
	 * ScreenName
	 **/

	@FindBy(xpath = "//span[text()='Group Announcement Repository']")
	public static WebElement announcementRepository_Screen;

	/**
	 * Page name : OPEASY Provisioning Page Element : Group Announcement Add
	 * ScreenName
	 **/

	@FindBy(xpath = "//span[text()='Group Announcement Add']")
	public static WebElement announcementAdd_Screen;

	/**
	 * Page name : OPEASY Provisioning Page Element : Announcement Name
	 **/

	@FindBy(id = "form1:textInputAnnouncementFileName")
	public static WebElement announcement_Name;

	/**
	 * Page name : OPEASY Provisioning Page Element : Announcement List
	 **/
	@FindBy(id = "form1:dropDownGroup_label")
	public static WebElement announcement_List;

	/**
	 * Page name : OPEASY Provisioning Page Element : Announcement Type
	 **/
	@FindBy(id = "form1:dropDownAnnouncementType_label")
	public static WebElement announcement_Type;

	/**
	 * Page name : OPEASY Provisioning Page Element : Announcement Value
	 **/

	@FindBy(id = "form1:textInputQueryValue")
	public static WebElement announcement_Value;

	/**
	 * Page name : OPEASY Provisioning Page Element : Authorization Codes Link
	 **/

	@FindBy(xpath = "//a[contains(.,'Authorization Codes')]")
	public static WebElement link_AuthorizationCodes;

	/**
	 * Page name : OPEASY Provisioning Page Element : Authorization Codes
	 * ScreenName
	 **/

	@FindBy(xpath = "//span[contains(text(),'Barring Authorization Codes')]")
	public static WebElement screen_AuthorizationCodes;

	/**
	 * Page name : OPEASY Provisioning Page Element : Add Button for Auth Codes
	 **/

	@FindBy(id = "form1:buttonAddAuthCode")
	public static WebElement button_Add_AuthorizationCodes;

	/**
	 * Page name : OPEASY Provisioning Page Element : Delete Link
	 **/

	@FindBy(linkText = "Delete")
	public static WebElement link_DeleteAuthCodes;

	/**
	 * Page name : OPEASY Provisioning Page Element : Authorization Code Input
	 **/

	@FindBy(id = "form1:tableColumnAuthCode:textFieldAuthCode")
	public static WebElement input_AuthorizationCode;

	/**
	 * Page name : OPEASY Provisioning Page Element : Authorization Code Input
	 **/

	@FindBy(id = "form1:tableColumnDescription:textFieldDescription")
	public static WebElement input_Description;

	/**
	 * Page name : OPEASY Provisioning Page Element : Cancel Link
	 **/

	@FindBy(id = "form1:buttonCancel")
	public static WebElement link_CancelAuthCodes;

	/**
	 * Page name : OPEASY Provisioning Page Element : Call pickUp Group link
	 **/

	@FindBy(xpath = "//a[contains(.,'Call Pickup Groups')]")
	public static WebElement link_CallPickup_Group;

	/**
	 * Page name : OPEASY Provisioning Page Element : Call pickUp Group
	 * ScreenName
	 **/

	@FindBy(xpath = "//span[text()='Call Pickup Groups']")
	public static WebElement screen_CallPickup_Group;

	/**
	 * Page name : OPEASY Provisioning Page Element : Add Call pickUp Group
	 * ScreenName
	 **/

	@FindBy(xpath = "//span[text()='Call Pickup Group Add']")
	public static WebElement screen_AddCallPickup_Group;

	/**
	 * Page name : OPEASY Provisioning Page Element : Call pickUp Group Name
	 **/

	@FindBy(id = "form1:textFieldCallPickupName")
	public static WebElement input_CallPickupGroup_Name;

	/**
	 * Page name : OPEASY Provisioning Page Element : Modify Call pickUp Group
	 * ScreenName
	 **/

	@FindBy(xpath = "//span[text()='Call Pickup Group Modify']")
	public static WebElement screen_ModifyCallPickup_Group;

	/**
	 * Page name : OPEASY Provisioning Page Element : Call pickUp Group Search
	 * Query Type
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,'dropDownQueryType_list')]]")
	public static WebElement dropdown_PickupQueryType;

	/**
	 * Page name : OPEASY Provisioning Page Element : Call pickUp Group Search
	 * Comparison
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,'dropDownQueryComparison_list')]]")
	public static WebElement dropdown_PickupQueryComparison;

	/**
	 * Page name : OPEASY Provisioning Page Element : Available Users Select box
	 * *
	 **/
	@FindBy(id = "form1listboxAvailableUsers_label")
	public static WebElement select_AvailableUsers;

	/**
	 * Page name : OPEASY Provisioning Page Element : Add user Button
	 **/

	@FindBy(id = "form1:buttonUserAdd")
	public static WebElement button_AddUserTo_CallPickupGroup;

	/**
	 * Page name : OPEASY Provisioning Page Element : Add user Button
	 **/

	@FindBy(xpath = ".//button[@value='Remove <']")
	public static WebElement button_RemoveUserFromCallPickupGroup;

	/**
	 * Page name : OPEASY Provisioning Page Element : Query Value TextField
	 **/

	@FindBy(id = "form1:textInputQueryValue")
	public static WebElement text_PickupQueryValue;

	/**
	 * Page name : OPEASY Provisioning Page Element : Departments Link
	 **/
	@FindBy(id = "form1:hyperlinkGroupDepartment")
	public static WebElement link_Departments;

	/**
	 * Page name : OPEASY Provisioning Page Element : Department ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Group Departments']")
	public static WebElement screen_Departments;

	/**
	 * Page name : OPEASY Provisioning Page Element : Add Department ScreenName
	 **/

	@FindBy(xpath = "//span[text()='Group Department Add']")
	public static WebElement screen_AddDepartments;

	/**
	 * Page name : OPEASY Provisioning Page Element : Add Department ScreenName
	 **/

	@FindBy(id = "form1:textFieldDepartmentName")
	public static WebElement text_DepartmentName;

	/**
	 * Page name : OPEASY Reporting Page Element : DropDown for Group
	 **/

	@FindBy(id = "form1:dropDownParentDepartment_label")
	public static WebElement dropdown_ParentDepartment;

	/**
	 * Page name : OPEASY Provisioning Page Element : Add Department ScreenName
	 **/

	@FindBy(xpath = "//span[contains(text(),'Department name already exists')]")
	public static WebElement errormsg_DepartmentAlreadyExist;

	/**
	 * Page name : OPEASY Provisioning Page Element : Device Type Tags Link
	 **/
	@FindBy(id = "form1:hyperlinkGroupDeviceTypeTags")
	public static WebElement link_DeviceTypeTags;

	/**
	 * Page name : OPEASY Provisioning Page Element : Device Type Tags
	 * ScreenName
	 **/

	@FindBy(xpath = "//span[text()='Group Device Type Tags']")
	public static WebElement screen_DeviceTypeTags;

	/**
	 * Page name : OPEASY Provisioning Page Element : Device Type dropdown
	 **/

	@FindBy(id = "form1:dropDownPhoneDeviceType_label")
	public static WebElement dropdown_DeviceType;
	
	/**
	 * Page name : OPEASY Provisioning Page Element : Device Type drop Down
	 **/

	@FindBy(xpath = "//label[@id[contains(., 'Name_label')]]")
	public static WebElement dropdown_Devicetype;

	/**
	 * Page name : OPEASY Provisioning Page Element : Caption Device Type
	 * Selected for Tags
	 **/

	@FindBy(xpath = "//caption[contains(text(),'Custom Tags for Devices of Device Type')]")
	public static WebElement caption_AfterDeviceTypeSelect;

	/**
	 * Page name : OPEASY Provisioning Page Element : Night Forwarding Link
	 **/

	@FindBy(linkText = "Night Forwarding")
	public static WebElement link_NightForwarding;

	/**
	 * Page name : OPEASY Provisioning Page Element : Night Forwarding
	 * ScreenName
	 **/

	@FindBy(xpath = "//span[text()='Group Night Forwarding']")
	public static WebElement screen_NightForwarding;

	/**
	 * Page name : OPEASY Provisioning Page Element : Phone Directory Management
	 * Link
	 **/

	@FindBy(xpath = "//a[contains(.,'Phone Directory Management')]")
	public static WebElement link_PhoneDirManagement;

	/**
	 * Page name : OPEASY Provisioning Page Element : Phone Directory Management
	 * ScreenName
	 **/

	@FindBy(xpath = "//span[text()='Phone Directory Management']")
	public static WebElement screen_PhoneDirManagement;

	/**
	 * Page name : OPEASY Provisioning Page Element : Phone Directory Management
	 * Scope Radio Button
	 **/

	@FindBy(xpath = ".//*[@id[contains(., ':radioButtonScope_0_rb')]]")
	public static WebElement radioButton_EnterpriseDirScope;

	/**
	 * Page name : OPEASY Provisioning Page Element : Phone Number Link
	 **/

	@FindBy(id = "form1:hyperlinkGroupPhoneNumbers")
	public static WebElement link_PhoneNumber;

	/**
	 * Page name : OPEASY Provisioning Page Element : Phone Number ScreenName
	 **/

	@FindBy(xpath = "//span[text()='Group Phone Numbers']")
	public static WebElement screen_PhoneNumber;

	/**
	 * Page name : OPEASY Provisioning Page Element : CheckBox assigned to user
	 **/

	@FindBy(xpath = "fprm1:checkboxShowAssigned_cb')]]")
	public static WebElement checkbox_NumRangeAssignedToUser;

	/**
	 * Page name : OPEASY Provisioning Page Element : CheckBox Activated
	 **/

	@FindBy(xpath = "//input[@id[contains(., ':checkboxShowActivated_cb')]]")
	public static WebElement checkbox_NumRangeActivated;

	/**
	 * Page name : OPEASY Provisioning Page Element : Edit Button
	 **/

	@FindBy(xpath = "(//a[text()='Edit'])[1]")
	public static WebElement button_Edit;

	// /**
	// * Page name : OPEASY Provisioning Page Element : User Search Criteria
	// **/
	// @FindBy(xpath = ".//select[@id[contains(.,'dropDownQueryType_list')]]")
	// public static WebElement dropdown_VirtAutoAttUserSearchCriteria;
	//
	// /**
	// * Page name : OPEASY Provisioning Page Element : User Search Criteria
	// **/
	// @FindBy(id =
	// "form1:layoutPanelFlexibleSeatingHostsearch:layoutPanelFlexibleSeatingHostsearchOptions:dropDownQueryType_list")
	// public static WebElement dropdown_VirtUserFlexHostSearchCriteria;
	//
	// /**
	// * Page name : OPEASY Provisioning Page Element : User Search Criteria
	// **/
	// // @FindBy(id =
	// //
	// "form1:layoutPanelHuntGroupSearch:layoutPanelHuntGroupSearchOptions:dropDownQueryType_list")
	// @FindBy(xpath = ".//select[@id[contains(.,'dropDownQueryType_list')]]")
	// public static WebElement dropdown_VirtUserHuntGroupsSearchCriteria;
	//
	// /**
	// * Page name : OPEASY Provisioning Page Element : User Search Criteria
	// **/
	// @FindBy(xpath = ".//select[@id[contains(.,'dropDownQueryType_list')]]")
	// public static WebElement dropdown_VirtUserVirtUserInvSearchCriteria;

	/**
	 * Page name : OPEASY Provisioning Page Element : User Search Criteria
	 **/
	@FindBy(id = "form1:textInputQueryValue")
	public static WebElement txt_VirtUserAutoAttInputQueryValue_field;
	/**
	 * Page name : OPEASY Provisioning Page Element : User Search Criteria
	 **/
	@FindBy(id = "form1:textInputQueryValue")
	public static WebElement txt_VirtUserFlexSeatingHostInputQueryValue_field;

	/**
	 * Page name : OPEASY Provisioning Page Element : User Search Criteria
	 **/
	@FindBy(id = "form1:textInputQueryValue")
	public static WebElement txt_VirtUserHuntGroupsInputQueryValue_field;

	/**
	 * Page name : OPEASY Provisioning Page Element : User Search Criteria
	 **/
	@FindBy(id = "form1:textInputQueryValue")
	public static WebElement txt_VirtUserVirtUserInvInputQueryValue_field;

	/**
	 * Page name : OPEASY Provisioning Page Element : User Search Value
	 **/

	@FindBy(id = "form1:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:rowGroupSearchCriteria:0:columnFieldValue:fieldValue_field")
	public static WebElement dropdown_UserSearchValue;

	/**
	 * Page name : OpEasy User Settings Page Element : Search For User
	 **/
	@FindBy(id = "form1:layoutPanelSearch:buttonSearch")
	public static WebElement search_UserProfiles;

	/**
	 * Page name : OpEasy User Settings Page Element : Link Speed Dial 8 Lists
	 **/
	@FindBy(linkText = "Speed Dial 8 Lists")
	public static WebElement link_SpeedDial8Lists;

	/**
	 * Page name : OpEasy User Settings Page Element : Speed Dial 8 Lists
	 * ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Group Speed Dial 8 Lists']")
	public static WebElement screen_SpeedDial8Lists;

	/**
	 * Page name : OpEasy User Settings Page Element : Link Speed Dial 100 Lists
	 **/
	@FindBy(xpath = "//a[contains(.,'Speed Dial 100 Lists')]")
	public static WebElement link_SpeedDial100Lists;

	/**
	 * Page name : OpEasy User Settings Page Element : Speed Dial 100 Lists
	 * ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Group Speed Dial 100 Lists']")
	public static WebElement screen_SpeedDial100Lists;

	/**
	 * Page name : OpEasy User Settings Page Element : Add Speed Dial 100 Lists
	 **/
	@FindBy(id = "form1:buttonAddSpeedDialList")
	public static WebElement button_AddSpeedDial100;

	/**
	 * Page name : OpEasy User Settings Page Element : Speed Dial 100 List add
	 * ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Group Speed Dial 100 List Add']")
	public static WebElement screen_AddSpeedDial100;

	/**
	 * Page name : OpEasy User Settings Page Element : Speed Dial 100 NameField
	 **/
	@FindBy(id = "form1:textInputListName")
	public static WebElement text_NameSpeedDial100;

	/**
	 * Page name : OpEasy User Settings Page Element : Speed Dial 100
	 * DescriptionField
	 **/
	@FindBy(id = "form1:textInputListDescription")
	public static WebElement text_DescriptionSpeedDial100;

	/**
	 * Page name : OpEasy User Settings Page Element : Speed Dial 100 Add Button
	 **/
	@FindBy(id = "form1:layoutPanelSpeedDial100AddButton:buttonAddSpeedDial100")
	public static WebElement button_AddSpeedDial100Internal;

	/**
	 * Page name : OpEasy User Settings Page Element : Speed Dial 100 Dropdown
	 **/
	@FindBy(id = "form1:layoutPanelSpeedDial100:dropDownSpeedCode100_list")
	public static WebElement dropdown_SpeedDial100;

	/**
	 * Page name : OpEasy User Settings Page Element : Speed Dial 100 Entry Add
	 * ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Group Speed Dial 100 Entry Add']")
	public static WebElement screen_SpeedDial100EntryAdd;

	/**
	 * Page name : OpEasy User Settings Page Element : Speed Dial 100
	 * DescriptionField
	 **/
	@FindBy(id = "form1:textInputDescription")
	public static WebElement text_DescriptionSpeedDial;

	/**
	 * Page name : OpEasy User Settings Page Element : Speed Dial 100 Phone
	 * Number
	 **/
	@FindBy(id = "form1:textInputPhoneNumber")
	public static WebElement text_InputPhoneNumber;

	/**
	 * Page name : OpEasy User Settings Page Element : Speed Dial 100 Entry
	 * ScreenName
	 **/
	@FindBy(xpath = "//*[text()='Group Speed Dial 100 List Modify']")
	public static WebElement screen_SpeedDial100EntryModify;

	/**
	 * Page name : OpEasy User Settings Page Element : Select Service For User
	 **/
	@FindBy(id = "form1:dropDownServiceSelect_label")
	public static WebElement dropdown_ServiceForUser;

	/**
	 * Page name : OpEasy User Settings Page Element : User Left Link
	 **/
	@FindBy(xpath = "//*[@id='form1:LeftPane:navigationTree:0']/span/span[3]/a")
	public static WebElement link_LeftUser;

	/**
	 * Page name : OpEasy User Settings Page Element : User Left Link
	 **/
	@FindBy(id = "form1:fieldsetAlternateNumber")
	public static WebElement dropdown_altTable;

	/**
	 * Page name : OpEasy User Settings Page Element : Select Initialize List
	 * Using
	 **/
	@FindBy(id = "form1:layoutPanelInitializeList:layoutPanelInitializeListInput:dropDownGroupSpeedDialListSelect_list")
	public static WebElement dropdown_InitializeList;

	/**
	 * Page name : OpEasy User Settings Page Element : Add Button In User Page
	 **/
	@FindBy(id = "form1:layoutPanelSpeedDial100:buttonAddSpeedDial100")
	public static WebElement button_AddSpeedDialInUserPage;

	/**
	 * Page name : OpEasy User Settings Page Element : User: Speed Dial 100 Add
	 * ScreenName
	 **/
	@FindBy(xpath = "//*[text()='User: Speed Dial 100 Add']")
	public static WebElement Screen_UserSpeedDialAdd;

	/**
	 * Page name : OpEasy User Settings Page Element : Solution Reseller Defined
	 * Fields Link
	 **/
	@FindBy(xpath = "//a[contains(.,'Solution Reseller Defined Fields')]")
	public static WebElement link_SolutionResellerDefinedFields;

	/**
	 * Page name : OpEasy User Settings Page Element : Solution Reseller Defined
	 * Fields ScreenName
	 **/
	@FindBy(xpath = "//*[text()='Group Solution Reseller Defined Fields']")
	public static WebElement Screen_SolutionResellerDefinedFields;

	/**
	 * Page name : OpEasy User Settings Page Element : System Defined Fields
	 * Link
	 **/
	@FindBy(id = "form1:hyperlinkGroupSystemDefinedFields")
	public static WebElement link_SystemDefinedFields;

	/**
	 * Page name : OpEasy User Settings Page Element : System Defined Fields
	 * ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Group System Defined Fields']")
	public static WebElement Screen_SystemDefinedFields;

	/**
	 * Page name : OpEasy User Settings Page Element : Virtual On-Net Enterprise
	 * Extensions Link
	 **/
	@FindBy(xpath = "//a[contains(.,'Virtual On-Net Enterprise Extensions')]")
	public static WebElement link_VirtualOnNetEnterpriseExt;

	/**
	 * Page name : OpEasy User Settings Page Element : Virtual On-Net Enterprise
	 * Extensions ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Virtual On-Net Enterprise Extensions']")
	public static WebElement Screen_VirtualOnNetEnterpriseExt;

	/**
	 * Page name : OpEasy User Settings Page Element : Search Button for Virtual
	 * On-Net Enterprise Extensions
	 **/
	@FindBy(xpath = "//input[@value='Search']")
	public static WebElement button_SearchVirtualOnNetEnterpriseExt;

	/**
	 * Page name : OpEasy User Settings Page Element : Search Button for Virtual
	 * On-Net Enterprise Extensions
	 **/
	@FindBy(id = "form1:buttonInitializeList")
	public static WebElement button_InitializeList;

	/**
	 * Page name : OpEasy User Settings Page Element : Button for Initialize
	 * User Speed Dial 100 Settings
	 **/
	@FindBy(xpath = "//*[@id='form1:buttonInitializeUser']/span")
	public static WebElement button_InitializeUser;

	/**
	 * Page name : OpEasy User Settings Page Element : Speed Dial 100 Entry
	 * Modify InitializeUser setting ScreenName
	 **/
	@FindBy(xpath = "//span[text()='Group Speed Dial 100 List: Initialize User Settings']")
	public static WebElement screen_SpeedDial100EntryModifyInitializeUser;

	/**
	 * Page name : OpEasy User Settings Page Element : Button for Initialize
	 * Selected User Speed Dial 100 Settings
	 **/
	@FindBy(xpath = "//*[@id='form1:buttonInitializeSelectedUsers']/span")
	public static WebElement button_InitializeSelectedUser;

	/**
	 * Page name : OpEasy User Settings Page Element : Button for Initialize
	 * Selected User Speed Dial 100 Settings
	 **/
	@FindBy(xpath = "//span[contains(text(),'Initialization of Speed Dial 100')]")
	public static WebElement button_InitializationSpeedDialMsg;

	/**
	 * Page name : OPEASY Provisioning Page Element : Active Result
	 **/

	@FindBy(xpath = "//span[text()='Active']")
	public static WebElement active_Result;

	/**
	 * Page name : OPEASY Provisioning Page Element : link User
	 **/

	@FindBy(linkText = "Users")
	public static WebElement link_Users;

	/**
	 * Page name : OPEASY Provisioning Page Element : ChooseFile Button
	 **/

	@FindBy(id = "form1:LeftPane:navigationTree:GroupSettings:GroupAnnouncements:GroupAnnouncements_link")
	public static WebElement Announcements_link;

	/**
	 * Page name : OPEASY Provisioning Page Element :
	 * btn_DeleteSelectedAnnouncements
	 **/

	@FindBy(id = "form1:layoutPanelAnnouncementDelete:buttonDeleteSelectedAnnouncements")
	public static WebElement btn_DeleteSelectedAnnouncements;

	/**
	 * Page name : OPEASY Home Page Element : systemadmin_screenname
	 **/

	@FindBy(id = "form1:HeaderPane:usertext")
	public static WebElement systemadmin_screenname;

	/**
	 * Page name : OPEASY Home Page Element : systemadmin_screenname
	 **/

	@FindBy(id = "form1:hyperlinkExport")
	public static WebElement link_Export;

	/**
	 * Page name : OPEASY Home Page Element : checkbox_ExportTypeList
	 **/

	@FindBy(id = "form1:cbExportType_label")
	public static WebElement cb_ExportTypeList;

	/**
	 * Page name : OPEASY Home Page Element : link_SelectAll
	 **/

	@FindBy(id = "form1:hyperlinkSelectAll")
	public static WebElement link_SelectAll;

	/**
	 * Page name : OPEASY Home Page Element : checkbox_ExportTypeList
	 **/

	// @FindBy(id = "form1:layoutPanelExportButtons:buttonStart")
	@FindBy(xpath = "//*[@id='form1:buttonStart']/span")
	public static WebElement btn_StartReport;

	/**
	 * Page name : OPEASY Home Page Element : checkbox_ExportTypeList
	 **/

	@FindBy(id = "form1:buttonDownloadResults")

	public static WebElement btn_RetreiveResults;

	/**
	 * Page name : OPEASY Reporting Page Element :
	 * dropdown_columnFieldComparison1
	 **/

	@FindBy(id = "form1:tableSearchCriteria:rowGroupSearchCriteria:0:columnFieldCondition:fieldCondition_list")
	public static WebElement dropdown_columnFieldComparison1;

	/**
	 * Page name : OPEASY Reporting Page Element :
	 * dropdown_columnFieldComparison2
	 **/

	@FindBy(id = "form1:tableSearchCriteria:rowGroupSearchCriteria:1:columnFieldCondition:fieldCondition_list")
	public static WebElement dropdown_columnFieldComparison2;

	/**
	 * Page name : OPEASY Provisioning Page Element : Enterprise Link
	 **/

	@FindBy(id = "form1:hyperlinkEnterpriseSettings_action")
	public static WebElement Enterprise_Link;

	/**
	 * Page name : OPEASY Provisioning Page Element : Enterprise setting Screen
	 **/

	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement Enterprisesetting_ScreenName;

	/**
	 * Page name : OPEASY Provisioning Page Element : Department Link
	 **/

	@FindBy(id = "form1:hyperlinkEnterpriseDepartments")
	public static WebElement Department_Link;

	/**
	 * Page name : OPEASY Provisioning Page Element : Enterprise Departments
	 * Screen
	 **/

	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement Enterprisedepartments_ScreenName;

	/**
	 * Page name : OpEasy User Settings Page Element : Button
	 **/
	@FindBy(xpath = "//input[@value='Add']")
	public static WebElement btn_ADD_VU;

	/**
	 * Page name : OPEASY Provisioning Page Element : Select SystemValidation
	 * Enterprise drop down
	 **/
	@FindBy(id = "form1:layoutPanelTopControls:dropDownParentDepartment_list")
	public static WebElement dropdown_parentDepartment;

	/**
	 * Page name : OPEASY Provisioning Page Element : Error massage page is
	 * displayed
	 **/
	@FindBy(id = "form1:errorMessages']/table/tbody/tr[1]/th")
	public static WebElement Errormsg_displayed;

	/**
	 * Page name : OpEasy Enterprise User defined Fields Page Element : Delete
	 * link
	 **/
	@FindBy(xpath = "//span[contains(.,'Automation')]//parent::td//parent::tr//span[contains(.,'Delete')]//a")
	public static WebElement link_delete;
	//
	// /**
	// * Page name : OpEasy Enterprise User defined Fields Page Element : Delete
	// * link
	// **/
	// @FindBy(xpath = "((//span[contains(.,'System Admin Number
	// Field1')]//parent::td//parent::tr//span[contains(.,'Number')]//parent::td//parent::tr//span//span)[7])//input[@type='checkbox']")
	// public static WebElement text_checkbox;

	// /**
	// * Page name : OpEasy Enterprise User defined Fields Page Element : Delete
	// * link
	// **/
	// @FindBy(xpath = "//span[contains(.,'System Admin Number
	// Field1')]//parent::td//parent::tr//span[contains(.,'Number')]//parent::td//parent::tr//span//parent::td//parent::tr//span//span//span//input[@type='text']")
	// public static WebElement text_entervalue;

	/**
	 * Page name : OPEASY Provisioning Page Element : Device Type Link
	 **/

	@FindBy(id = "form1:hyperlinkEntDeviceTypes")
	public static WebElement Devicetype_Link;

	/**
	 * Page name : OPEASY Provisioning Page Element : Enterprise Devicetypes
	 * Screen
	 **/

	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement Devicetpes_ScreenName;

	/**
	 * Page name : OPEASY Provisioning Page Element : Aastra 53i Link
	 **/

	@FindBy(xpath = "(.//*[@id='form1:layoutPanelEnterpriseDeviceTypes:listboxAvailableDeviceTypes_list'])//option[2]")
	public static WebElement link_Aastra;

	/**
	 * Page name : OPEASY Provisioning Page Element : Enterprise Devicetypes
	 * Screen
	 **/
	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement Enterprisetesting_ScreenName;

	/**
	 * Page name : OpEasy User Settings Page Element : Button
	 **/
	@FindBy(id = "form1:buttonRemove")
	public static WebElement button_REMOVE;

	/**
	 * Page name : OPEASY Provisioning Page Element : User Screen
	 **/
	@FindBy(id = "form1:staticTextScreenName'][contains(.,'Users')]")
	// @FindBy(xpath = "//span[contains(text(),'User Add')]")
	public static WebElement user_ScreenName;

	/**
	 * Page name : OPEASY Users Page Element : User Screen
	 **/
	@FindBy(xpath = "//span[contains(text(),'User Add')]")
	public static WebElement user_Add_Screenname;

	/**
	 * Page name : OPEASY Provisioning Page Element : Select All Enterprise drop
	 * down
	 * 
	 **/
	@FindBy(id = "form1:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:rowGroupSearchCriteria:0:columnFieldCondition:fieldCondition_list")
	public static WebElement dropdown_Contain;

	/**
	 * Page name : OPEASY Provisioning Page Element : Select SystemValidation
	 * Enterprise drop down
	 **/
	@FindBy(id = "form1:fieldValue")
	public static WebElement text_UsernameField;

	/**
	 * Page name : OpEasy User Settings Page Element : Last Name
	 **/
	@FindBy(id = "form1:textFieldLastName")
	public static WebElement text_LastName;

	/**
	 * Page name : OpEasy User Settings Page Element : First Name
	 **/
	@FindBy(id = "form1:textFieldFirstName")
	public static WebElement text_FirstName;
	
	/**
	 * Page name : OpEasy User Settings Page Element : First Name
	 **/
	@FindBy(id = "form1:textFieldFirstName")
	public static WebElement text_Firstme;

	/**
	 * Page name : OpEasy User Settings Page Element : Email Address
	 **/
	@FindBy(id = "form1:textFieldEmail")
	public static WebElement text_Emailaddress;

	/**
	 * Page name : OPEASY Provisioning Page Element :Phone Number
	 **/
	@FindBy(id = "form1:dropDownPhoneNumber_label")
	public static WebElement dropdown_Phonenumber;

	/**
	 * Page name : OpEasy User Settings Page Element :Extension Number
	 **/
	@FindBy(id = "form1:textFieldExtension")
	public static WebElement text_Extension;
	
	
	/**
	 * Page name : OpEasy User Settings Page Element :Extension Number
	 **/
	@FindBy(xpath = "//input[@id='form1:textFieldPhoneNumberExtension']")
	public static WebElement textbox_Ext;

	/**
	 * Page name : OpEasy User Settings Page Element : Voice Portal Passcode
	 **/
	@FindBy(id = "form1:textFieldVoicePortalPassword")
	public static WebElement text_Passcode;

	/**
	 * Page name : OpEasy User Settings Page Element : User Password
	 **/
	@FindBy(id = "form1:textFieldPassword")
	public static WebElement text_Password;

	/**
	 * Page name : OPEASY Provisioning Page Element : Edit Link
	 **/

	@FindBy(id = "form1:tableQueryResults:rowGroupQueryResults:0:columnHyperlinkEdit")
	public static WebElement link_Edit;

	/**
	 * Page name : OpEasy User Settings Page Element :Extension Number
	 **/
	@FindBy(id = "form1:textFieldPhysicalLocation")
	public static WebElement text_PhoneLocation;

	/**
	 * Page name : OPEASY Provisioning Page Element : Error massage page is
	 * displayed
	 **/
	@FindBy(id = "form1:errorMessages']/table/tbody/tr[2]/td/div/ul/li/span")
	public static WebElement Errormsg_ScreenName;

	/**
	 * Page name : OPEASY Component Status Page Element : Component Status
	 **/

	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement textuser_ScreenName;

	/**
	 * Page name : OpEasy User Settings Page Element : Clearspan userid
	 **/
	@FindBy(id = "form1:textFieldUserIdUserName")
	public static WebElement text_Userid;

	/**
	 * Page name : OpEasy User Settings Page Element : Clearspan userid
	 **/
	@FindBy(id = "form1:textFieldCLIDLastName")
	public static WebElement text_Lastname;

	/**
	 * Page name : OpEasy User Settings Page Element : Clearspan userid
	 **/
	@FindBy(id = "form1:textFieldLastName")
	public static WebElement text_Lastname_UserModifyPage;

	/**
	 * Page name : OpEasy User Settings Page Element : Clearspan userid
	 **/
	@FindBy(id = "form1:textFieldFirstName")
	public static WebElement text_Firstname_UserModifyPage;

	/**
	 * Page name : OpEasy User Settings Page Element : Clearspan userid
	 **/
	@FindBy(id = "form1:textFieldCLIDFirstName")
	public static WebElement text_Firststname;

	/**
	 * Page name : OPEASY Provisioning Page Element : Select User profile drop
	 * down
	 **/
	@FindBy(id = "form1:dropDownUserProfile_label")
	public static WebElement dropdown_Userprofile;

	/**
	 * Page name : OPEASY Hunt Groups Add Page Element : Hunt Group User Name
	 **/
	@FindBy(id = "form1:textFieldName")
	public static WebElement huntgroupuser;

	/**
	 * Page name : OPEASY Hunt Groups Add Page Element : Hunt Group ID
	 **/
	@FindBy(id = "form1:textFieldHuntGroupIdHuntGroupName")
	public static WebElement huntgroupID;

	/**
	 * Page name : OPEASY Hunt Groups Add Page Element : Hunt Group Extension
	 **/
	@FindBy(id = "form1:textFieldExtension")
	public static WebElement huntgroupExtension;

	/**
	 * Page name : OPEASY Hunt Groups Add Page Element : Hunt Group Last Name
	 **/
	@FindBy(id = "form1:textFieldCLIDLastName")
	public static WebElement huntgroupLastName;

	/**
	 * Page name : OPEASY Hunt Groups Add Page Element : Hunt Group First Name
	 **/
	@FindBy(id = "form1:textFieldCLIDFirstName")
	public static WebElement huntgroupFirstName;

	/**
	 * Page name : OPEASY Flexible seating Host Add Page Element : Flexible
	 * seating Host Add
	 **/

	@FindBy(xpath = "//span[contains(.,'Flexible Seating Host Add')]//span")
	public static WebElement FlexseatAdd_Screen;

	/**
	 * Page name : OPEASY Flexible seating Host Add Page
	 * 
	 * Element : Flexible seating Host Add
	 **/

	@FindBy(id = "form1:textFieldName")
	public static WebElement FlexSeatHostName;

	/**
	 * Page name : OPEASY Flexible seating Host Add Page
	 * 
	 * Element : Flexible seating Host Add
	 **/

	@FindBy(id = "form1:textFieldFlexibleSeatingHostIdFlexibleSeatingHostName")
	public static WebElement FlexSeatHostID;

	/**
	 * Page name : OPEASY Flexible seating Host Add Page Element : Flexible
	 * Seating Host Add
	 **/
	@FindBy(id = "form1:textFieldExtension")
	public static WebElement FlexSeatExtension;

	/**
	 * Page name : OPEASY Flexible seating Host Add Page Element : Flexible
	 * Seating Host Last Name
	 **/
	@FindBy(id = "form1:textFieldCLIDLastName")
	public static WebElement FlexSeatLastName;

	/**
	 * Page name : OPEASY Flexible seating Host Add Page Element : Flexible
	 * Seating Host First Name
	 **/
	@FindBy(id = "form1:textFieldCLIDFirstName")
	public static WebElement FlexSeatFirstName;

	/**
	 * Page name : OPEASY Provisioning Page Element : Provisioning screen Name
	 **/

	@FindBy(id = "form1:staticTextScreenName'][contains(.,'Provisioning')]")
	public static WebElement text_Provisioning;

	/**
	 * Page name : OPEASY Provisioning Page Element : User ID text_box
	 **/

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = ".//*[@id='form1:errorMessages']/table/tbody/tr[2]/td/div/ul/li/span")
	public static WebElement Error_Message;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = "//span[contains(text(),'Search comparison value is a required field')]")
	public static WebElement HGError_Message;

	/**
	 * Page name : OpEasy Provisioning Page Element : Error MEssages text
	 **/
	@FindBy(xpath = "//*[@id='form1:errorMessages']//span)")
	public static WebElement lbl_ErrorMessages;

	/**
	 * Page name : OPEASY Provisioning Page Element : tableTitleAltNumbers
	 **/

	@FindBy(xpath = ".//span[contains(text(), 'Alternate Numbers allows up to ten additional phone numbers')]")
	public static WebElement label_TableTitleAltNumbers;

	/**
	 * Page name : OPEASY Provisioning Page Element : tableTitleAltNumbers
	 **/

	@FindBy(id = "form1:checkboxEnableFaxMessaging_cb")
	public static WebElement checkbox;

	/**
	 * Page name : OPEASY Provisioning Page Element : tableTitleAltNumbers
	 **/

	@FindBy(id = "form1:dropDownUserProfile_label")
	public static WebElement dropdown_userprofile;

	/**
	 * Page name : OPEASY Provisioning Page Element : multiSelect_UserServices
	 **/

	@FindBy(id = "form1:listboxUserServices_list")
	public static WebElement multiSelect_UserServices;

	/**
	 * Page name : OPEASY Provisioning Page Element : multiSelect_UserServices
	 **/

	@FindBy(xpath = "//*[@id='form1:ListSelector:buttonAdd']/span")
	public static WebElement btn_AddMultipleEnterprises;

	/**
	 * Page name : OPEASY Provisioning Page Element : multiSelect_UserServices
	 **/
	@FindBy(id = "form1:ListSelector:listboxMultipleAvailableSelections")
	public static WebElement listbox_MultipleAvailableSelections;

	/**
	 * Page name : OPEASY Provisioning Page Element : multiSelect_UserServices
	 **/
	@FindBy(id = "form1:ListSelector:listboxMultipleSelectedSelections")
	public static WebElement listbox_MultipleSelectedSelections;

	/**
	 * Page name : OPEASY Provisioning Page Element : multiSelect_UserServices
	 **/

	@FindBy(xpath = "//*[@id='form1:ListSelector:buttonAddAll']/span")
	public static WebElement btn_AddAllEnterprises;

	@FindBy(xpath = "//*[@id='form1:ListSelector:buttonRemove']/span")
	public static WebElement btn_RemoveEnterprises;

	/**
	 * Page name : OPEASY Provisioning Page Element : multiSelect_UserServices
	 **/

	@FindBy(xpath = "//*[@id='form1:ListSelector:buttonRemoveAll']/span")
	public static WebElement btn_RemoveAllEnterprises;

	/**
	 * Page name : OPEASY Provisioning Page Element :
	 * multiSelect_AvailableServices
	 **/

	@FindBy(id = "form1:listboxAvailableServices_label")
	public static WebElement multiSelect_AvailableServices;

	/**
	 * Page name : OPEASY Provisioning Page Element : btn_AddService
	 **/
	@FindBy(id = "form1:buttonAddService")
	public static WebElement btn_AddService;

	/**
	 * Page name : OPEASY Provisioning Page Element : btn_ServiceRemove
	 **/
	@FindBy(id = "form1:buttonServiceRemove")
	public static WebElement btn_ServiceRemove;

	/**
	 * Page name : OPEASY Provisioning Page Element : btn_AddPhoneNumber
	 **/

	@FindBy(xpath = "//*[@id='form1:buttonAddPhoneNumber']/span")
	public static WebElement btn_AddPhoneNumber;

	/**
	 * Page name : OPEASY Provisioning Page Element : txt_PhoneNumber
	 **/

	@FindBy(id = "form1:textInputPhoneNumber")
	public static WebElement txt_PhoneNumber;

	/**
	 * Page name : OPEASY Provisioning Page Element : txt_Description
	 **/

	@FindBy(id = "form1:textInputDescription")
	public static WebElement txt_Description;

	/**
	 * Page name : OPEASY Provisioning Page Element : txt_outboundAltNum
	 **/

	@FindBy(id = "form1:textInputOutboundAlternateNumber")
	public static WebElement txt_outboundAltNum;

	/**
	 * Page name : OPEASY Provisioning Page Element :
	 * cb_EnableDiversionInhibitor
	 **/

	@FindBy(id = "form1:checkboxEnableDiversionInhibitor_cb")
	public static WebElement cb_EnableDiversionInhibitor;

	/**
	 * Page name : OPEASY Provisioning Page Element :
	 * cb_RequreAnswerConfirmation
	 **/

	@FindBy(id = "form1:checkboxRequreAnswerConfirmation_cb")
	public static WebElement cb_RequreAnswerConfirmation;

	/**
	 * Page name : OPEASY Provisioning Page Element : btn_AddSelectiveCriteria
	 **/

	@FindBy(id = "form1:buttonAddSelectiveCriteria")
	public static WebElement btn_AddSelectiveCriteria;

	/**
	 * Page name : OPEASY Provisioning Page Element : txt_SelCritDescription
	 **/

	@FindBy(id = "form1:textInputName")
	public static WebElement txt_SelCritDescription;

	/**
	 * Page name : OPEASY Provisioning Page Element : rb_UseClearspanAnywhere
	 **/

	@FindBy(id = "form1:radioButtonUseClearspanAnywhere:0")
	public static WebElement rb_UseClearspanAnywhere;

	/**
	 * Page name : OPEASY Provisioning Page Element : dropDown_TimeSchedule_list
	 **/

	@FindBy(id = "form1:dropDownTimeSchedule_label")
	public static WebElement dropDown_TimeSchedule_list;

	/**
	 * Page name : OPEASY Provisioning Page Element :
	 * dropDown_HolidaySchedule_list
	 **/

	@FindBy(id = "form1:dropDownHolidaySchedule_label")
	public static WebElement dropDown_HolidaySchedule_list;

	/**
	 * Page name : OPEASY Provisioning Page Element :
	 * chkbox_AdvancedExportTabs_12_cb
	 **/

	@FindBy(id = "form1:layoutPanelAdvancedExportTabs:chkAdvancedExportTabs:chkAdvancedExportTabs_12_cb")
	public static WebElement chkbox_AdvancedExportTabs_12_cb;

	/**
	 * Page name : OPEASY Provisioning Page Element : hyperlinkClearAll
	 **/

	@FindBy(id = "form1:hyperlinkClearAll")
	public static WebElement hyperlink_ClearAll;

	/**
	 * Page name : OPEASY Provisioning Page Element : list_ImportType_list
	 **/

	@FindBy(id = "form1:cbImportType_label")
	public static WebElement list_ImportType_list;

	/**
	 * Page name : OPEASY Provisioning Page Element :
	 * radioButton_CallSource_1_rb
	 **/

	@FindBy(id = "form1:layoutPanelCallSource:radioButtonCallSource:radioButtonCallSource_1_rb")
	public static WebElement radioButton_CallSource_1_rb;

	/**
	 * Page name : OPEASY Provisioning Page Element :
	 * checkboxUnavailableNumbers_cb
	 **/

	@FindBy(id = "form1:layoutPanelCallSource:checkboxUnavailableNumbers_cb")
	public static WebElement checkboxUnavailableNumbers_cb;

	/**
	 * Page name : OPEASY Provisioning Page Element :
	 * listbox_AvailableCallToNumbers_list
	 **/

	@FindBy(id = "form1:listboxAvailableCallToNumbers_label")
	public static WebElement listbox_AvailableCallToNumbers_list;

	/**
	 * Page name : OPEASY Provisioning Page Element : buttonCallCenterAdd
	 **/

	@FindBy(id = "form1:layoutPanelCallsTo:buttonCallCenterAdd")
	public static WebElement buttonCallCenterAdd;

	/**
	 * Page name : OPEASY Provisioning Page Element :
	 * listboxSelectedCallToNumbers_list
	 **/

	@FindBy(id = "form1:listboxSelectedCallToNumbers_label")
	public static WebElement listboxSelectedCallToNumbers_list;

	/**
	 * Page name : OPEASY Provisioning Page Element : link_UserProfiles
	 **/

	@FindBy(id = "form1:hyperlinkUserProfiles")
	public static WebElement link_UserProfiles;

	/**
	 * Page name : OPEASY Provisioning Page Element : link_UserProfiles
	 **/

	@FindBy(id = "form1:textFieldUserProfileName")
	public static WebElement txt_UserProfileName;
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 * Element 	 : User Profile Name
	 **/
	@FindBy(xpath = "//input[@id[contains(., 'UserProfileName')]]")	
	public static WebElement text_UserProfileName;

	/**
	 * Page name : OPEASY Provisioning Page Element : link_UserProfiles
	 **/

	@FindBy(id = "form1:dropDownUserType_label")
	public static WebElement lst_UserType;
	
	/**
	 * Page name : OPEASY Provisioning Page Element : link_UserProfiles
	 **/

	@FindBy(xpath = "//*[@id[contains(., 'Type_label')]]")
	public static WebElement label_DeviceType;

	/**
	 * Page name : OPEASY Provisioning Page Element : link_UserProfiles
	 **/

	@FindBy(id = "form1:dropDownPhoneDeviceType_label")
	public static WebElement lst_DeviceType;

	/**
	 * Page name : OPEASY Provisioning Page Element : link_UserProfiles
	 **/

	@FindBy(id = "form1:dropDownPhoneDeviceTemplate_label")
	public static WebElement lst_DevTemplate;

	/**
	 * Page name : OPEASY Provisioning Page Element : link_UserProfiles
	 **/

	@FindBy(id = "form1:dropDownBillingUsertype_label")
	public static WebElement lst_BillingUsertype;

	/**
	 * Page name : OPEASY Provisioning Page
	 **/

	@FindBy(id = "form1:staticTextScreenSavedMessage")
	public static WebElement txt_screeSavedMessage;

	/**
	 * Page name : OPEASY Provisioning Page
	 **/

	@FindBy(id = "form1:hyperlinkSystemSettings")
	public static WebElement link_SystemSettings;

	/**
	 * Page name : OPEASY Provisioning Page
	 **/

	@FindBy(id = "form1:hyperlinkEnterpriseEnterpriseUserDefinedFields")
	public static WebElement link_UserDefinedFields;
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = "(//a[contains(.,'Definitions')])[1]")
	public static WebElement link_Definitions;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(xpath = "//a[contains(text(),'Enterprise Settings')]")
	public static WebElement link_EnterpriseSettings;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown Page
	 * name : OpEasy User Page Element : User password text box
	 **/
	@FindBy(id = "form1:textFieldPassword")
	public static WebElement text_Userpassword;

	/**
	 * Page name : OpEasy User Page Element : User confirm password text box
	 **/
	@FindBy(id = "form1:textFieldPassword2")
	public static WebElement text_Userconfirmpassword;

	/**
	 * Page name : OpEasy User Page Element : Clearspan User ID text box
	 **/
	@FindBy(id = "form1:textFieldUserIdUserName")
	public static WebElement text_csuserID;

	/**
	 * Page name : OpEasy User Page Element : CAlling ID Last Name
	 **/
	@FindBy(id = "form1:textFieldCLIDLastName")
	public static WebElement text_callingLastName;

	/**
	 * Page name : OpEasy User Page Element : CAlling ID First Name
	 **/
	@FindBy(id = "form1:textFieldCLIDFirstName")
	public static WebElement text_callingFirstname;

	/**
	 * Page name : OpEasy User Page Element : Phone Number text box
	 **/
	@FindBy(id = "form1:textFieldCLIDPhoneNumber")
	public static WebElement text_phoneNumber;

	/**
	 * Page name : OpEasy User Page Element : Phone Number text box
	 **/
	@FindBy(xpath = "//*[@id='form1:buttonServicePackAdd']/span")
	public static WebElement button_ServicePackAdd;

	/**
	 * Page name : OpEasy User Page Element : VoicePortalPassword Clearspan user
	 **/
	@FindBy(id = "form1:textFieldVoicePortalPassword")
	public static WebElement voicePortalPassword;

	/**
	 * Page name : OpEasy User Page Element : Confirm VoicePortalPassword
	 * Clearspan user
	 **/
	@FindBy(id = "form1:textFieldVoicePortalPassword2")
	public static WebElement confirmvoicePortalPassword;

	/**
	 * Page name : OpEasy User Page Element : Confirm VoicePortalPassword
	 * Clearspan user
	 **/
	@FindBy(id = "form1:textFieldVoicePortalPassword2")
	public static WebElement text_confirmvoicePortalPasswordBasicProv;

	/**
	 * Page name : OpEasy User Page Element : Confirm VoicePortalPassword
	 * Clearspan user
	 **/
	@FindBy(id = "form1:textFieldPassword2")
	public static WebElement text_UserconfirmpasswordBasicProv;

	/**
	 * Page name : OpEasy User Page Element : Announcement Button page
	 **/
	@FindBy(xpath = "//*[@id=\"form1:layoutPanelTabs\"]//button[contains(., 'Announcements')]")
	public static WebElement btn_announcement;

	/**
	 * Page name : OpEasy Advanced User Page Element : Add Announcement Button
	 * page
	 **/
	@FindBy(id = "form1:buttonAddAnnouncement")
	public static WebElement add_announcement;

	/**
	 * Page name : OpEasy Advanced User Announcement Add Page Element : User
	 * Announcement Add page
	 **/
	@FindBy(xpath = "//span[contains(text(),'User: Announcement Add')]")
	public static WebElement text_UserannouncementAdd;

	/**
	 * Page name : OpEasy Advanced User Announcement Add Page Element :
	 * Announcement Name text box page
	 **/
	@FindBy(id = "form1:textInputAnnouncementFileName")
	public static WebElement text_announcementName;

	/**
	 * Page name : OpEasy Advanced User Announcement Add Page Element :
	 * Announcement browse button page
	 **/
	// @FindBy(xpath =
	// "//*[@id=\"form1:fileUploadAnnouncementFile\"]/div[1]/span")
	// @FindBy(xpath = "//input[@id='form1:fileUploadAnnouncementFile_input']")
	@FindBy(xpath = "(//span[contains(.,'* Load Announcement File')])[1]")

	public static WebElement btn_Browse;

	/**
	 * Page name : OpEasy Advanced User Announcement Add Page Element :
	 * Announcement browse Announcement file
	 **/
	@FindBy(xpath = "//*[@id=\"form1:fileUploadAnnouncementFile_label\"]")
	public static WebElement btn_ChooseAnnouncementFile;

	/**
	 * Page name : OpEasy Advanced User Modify Page Element : Advanced User
	 * Modify page
	 **/
	@FindBy(xpath = "//span[contains(text(),'Advanced: User Modify')]")
	public static WebElement text_advancedUserModify;

	/**
	 * Page name : OpEasy Advanced User Modify Page Element : Always text
	 * message page
	 **/
	@FindBy(id = "form1:labelCFAActive")
	public static WebElement text_always;

	/**
	 * Page name : OpEasy Advanced User Modify Page Element : On Radio button
	 * page
	 **/
	@FindBy(xpath = ".//*[@id[contains(.,'radioButtonCFAActive_0_rb')]]")
	public static WebElement radio_On;

	/**
	 * Page name : OpEasy Advanced User Modify Page Element : Off Radio button
	 * page
	 **/
	@FindBy(xpath = ".//*[@id[contains(.,'radioButtonCFAActive_1_rb')]]")
	public static WebElement radio_Off;

	/**
	 * Page name : OpEasy Advanced User Modify Page Element : On Radio button
	 * page
	 **/
	@FindBy(id = "form1:textInputCFAForwardToNumber")
	public static WebElement type_Phonenumber;
	
	 /**
	  * Page name : Provisioning Add Template Page Element : On Radio button
	  * page
	  **/
	@FindBy(xpath = "//label[@id[contains(., 'staticText8')]]")
	public static WebElement btn_RestartPhones;
	
	
	/**
	 * Page name : Provisioning Add Template Page Element : 
	 * page
	 **/
	@FindBy(xpath = "//a[contains(.,'Ports')]")
	public static WebElement tab_ports;
	

	/**
	 * Page name : Provisioning Add Template Page Element : 
	 * page
	 **/
	@FindBy(xpath = "//input[@id[contains(., 'Description')]]")
	public static WebElement text_description;
	
	/**
	 * Page name : OpEasy Advanced User Modify Page Element : Available portal
	 * list link page
	 **/
	@FindBy(id = "form1:hyperlinkAvailablePortalList")
	public static WebElement link_portal;

	/**
	 * Page name : OpEasy Advanced User Modify Page Element : Available portal
	 * page page
	 **/
	@FindBy(xpath = "//span[contains(text(),'Available Clearspan Anywhere Portals')]")
	public static WebElement text_anywhereportalpage;

	/**
	 * Page name : OpEasy Advanced User Modify Page Element : Available portal
	 * page page
	 **/
	@FindBy(xpath = "//span[contains(text(),'User: Clearspan Anywhere Phone Number Add')]")
	public static WebElement text_anywherephonenumberadd;

	/**
	 * Page name : available clearspan Anywhere Portals Page Element : Phone
	 * Number text box
	 **/
	@FindBy(xpath = "//span[contains(text(),'AutomationPortalName')]")
	public static WebElement text_verifyportal;

	/**
	 * Page name : OClearspan Anywhere phone number add Page Element : text box
	 * page
	 **/
	@FindBy(id = "form1:textInputPhoneNumber")
	public static WebElement type_anywherePhonenumber;

	/**
	 * Page name : OPEASY Provisioning Page Element : Error massage page is
	 * displayed
	 **/
	@FindBy(xpath = "html/body/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/div/table/tbody")
	public static WebElement verify_phonenumber;

	/**
	 * Page name : OPEASY Enterprise settings Page Element : Enterprise settings
	 **/

	@FindBy(xpath = "//span[contains(text(),'Enterprise Settings')]")
	public static WebElement text_EnterpriseSettings;

	/**
	 * Page name : OpEasy Users Page Element : Device Level drop down list
	 **/
	@FindBy(id = "form1:dropDownSpecial")
	public static WebElement dropdown_deviceLevel;

	/**
	 * Page name : OPEASY Provisioning Page Element : HG link
	 **/
	@FindBy(xpath = "//a[contains(text(),'Hunt Groups')]")
	public static WebElement link_HG;

	/**
	 * Page name : OpEasy Provisioning Page Element : HG Nane
	 **/
	@FindBy(id = "form1:textFieldName")
	public static WebElement type_HGName;

	/**
	 * Page name : OpEasy Provisioning Page Element : HG Nane
	 **/
	@FindBy(id = "form1:textFieldHuntGroupIdHuntGroupName")
	public static WebElement type_HGid;

	/**
	 * Page name : OpEasy Hunt group Add Page Element : HG Last Name
	 **/
	@FindBy(id = "form1:textFieldCLIDLastName")
	public static WebElement type_HGLname;

	/**
	 * Page name : OpEasy Hunt group Add Page Element : HG Last Name
	 **/
	@FindBy(id = "form1:textFieldCLIDFirstName")
	public static WebElement type_HGFname;

	/**
	 * Page name : OpEasy HG Modify Page Element : Users link
	 **/
	@FindBy(id = "form1:buttonServiceAdd")
	public static WebElement btn_serviceAdd;

	/**
	 * Page name : OpEasy Users Page Element : Users link
	 **/
	@FindBy(id = "form1:layoutPanelHuntGroupSearch:layoutPanelHuntGroupSearchOptions:dropDownQueryType_list")
	public static WebElement dropdown_HGSearchField1;

	/**
	 * Page name : OpEasy Users Page Element : Users link
	 **/
	@FindBy(id = "form1:layoutPanelHuntGroupSearch:layoutPanelHuntGroupSearchOptions:dropDownQueryComparison_list")
	public static WebElement dropdown_HGSearchFilter1;

	/**
	 * Page name : OpEasy Users Page Element : Search text box
	 **/
	@FindBy(id = "form1:textInputQueryValue")
	public static WebElement type_HGSearchText1;

	/**
	 * 
	 **/
	@FindBy(id = "form1:layoutPanelAdvancedExportTabs:chkAdvancedExportTabs:chkAdvancedExportTabs_1_cb")
	public static WebElement chkbox_AutoAttendants;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:layoutPanelAdvancedExportTabs:chkAdvancedExportTabs:chkAdvancedExportTabs_26_cb")
	public static WebElement chkbox_UserDefinedFields;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:layoutPanelGroupExportTabs:chkGroupExportTabs:chkGroupExportTabs_32_cb")
	public static WebElement chkbox_UserDefinedFields_ExportGroupPage;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:layoutPanelAdvancedExportTabs:chkAdvancedExportTabs:chkAdvancedExportTabs_25_cb")
	public static WebElement chkbox_UserDefinedFields_SR_Page;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:layoutPanelAdvancedExportTabs:chkAdvancedExportTabs:chkAdvancedExportTabs_15_cb")
	public static WebElement chkbox_;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:hyperlinkEnterpriseEnterpriseUserDefinedFields")
	public static WebElement link_UserDefinedFields_SideLink;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:hyperlinkAutoAttendants")
	public static WebElement link_AutoAttendants;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:LeftPane:navigationTree:VirtualUsers:GroupGroupPaging:GroupGroupPaging_link")
	public static WebElement link_GroupPaging;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:hyperlinkFlexSeatingHosts")
	public static WebElement link_FlexibleSeatingHosts;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:hyperlinkGroupHuntGroups")
	public static WebElement link_HuntGroups;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:hyperlinkVirtualUserInventory")
	public static WebElement link_VirtualUserInventory;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:layoutPanelFlexibleSeatingHostsearch:buttonSearch")
	public static WebElement btn_FlexibleSeatingHost;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:layoutPanelGroupExportTabs:chkGroupExportTabs:chkGroupExportTabs_4_cb")
	public static WebElement chkbox_FlexibleSeatingHost;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:tableSearchCriteria:rowGroupSearchCriteria:0:columnFieldValue:fieldValue")
	public static WebElement textbox_SearchCriteria_ExportPage;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(xpath = "*//input[@value='Delete']")
	public static WebElement btn_DeleteOnExportPage;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = ".//*[@id[contains(.,':listboxMultipleAvailableSelections_list')]]")
	public static WebElement multiSelect_AvailableEnterprises;

	/**
	 * Page name : OpEasy Provisioning Page Element : Users link
	 **/
	@FindBy(xpath = ".//*[@id[contains(.,':listboxMultipleSelectedSelections_list')]]")
	public static WebElement multiSelect_SelectedEnterprises;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:layoutPanelControls:checkboxSelectAll_cb")
	public static WebElement chkbox_SelectAllEnterpriseUserFields;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:checkboxSelectDefined_cb")
	public static WebElement chkbox_SelectDefinedEnterpriseUserFields;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:layoutPanelServicePacks:listboxAvailableServicePacks_list")
	public static WebElement multiselect_AvailableServicePacks;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:listboxUserServicePacks_label")
	public static WebElement multiselect_UserServicePacks;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = "//button[@value='Add >']")
	public static WebElement btn_AddServicePack;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:dropDownAutoAttendantType_label")
	public static WebElement dropdown_AttendantType;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:dropDownProfileType_label")
	public static WebElement dropDown_ProfileType;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:dropDownKeyDefinitions_label")
	public static WebElement dropDown_KeyDefinitions;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:dropDownPhoneManufacturer_label")
	public static WebElement dropDown_PhoneManufacturer;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = "(//*[@id='form1:tableFields_data']//td[count(//table//th[text()='Field Name']/preceding-sibling::*) +1])[1]//input")
	public static WebElement txtUDFNewFieldName;

	/**
	 * Page name : OPEASY Provisioning Page * Element : View Template Button
	 **/
	@FindBy(xpath = "//span[contains(.,'User: Phone Template')]")
	public static WebElement text_PhoneTemplate;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = "(//*[@id='form1:tableFields_data']//td[count(//table//th[text()='Field Name']/preceding-sibling::*) +4])[1]//input")
	public static WebElement txtUDFNewDefaultValue;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:dropDownVoiceMailPasswordEnt_label")
	public static WebElement dropDownVoiceMailPasswordEnt_label;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:dropDownVoiceMailPasswordGrp_label")
	public static WebElement dropDownVoiceMailPasswordGrp_label;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:dropDownServiceSelect_label")
	public static WebElement dropDownServiceSelect_label;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:deleteVoiceMailButton")
	public static WebElement btn_deleteVoiceMailButton;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:staticTextScreenMessage")
	public static WebElement staticTextScreenMessage;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:textInputCSVMGroupEmailAddress")
	public static WebElement text_InputCSVMGroupEmailAddress;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:textInputCSVMGroupPassword")
	public static WebElement text_InputCSVMGroupPassword;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:textInputCSVMGroupPassword2")
	public static WebElement text_InputCSVMGroupPassword2;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:dropDownServiceSelect_label")
	public static WebElement dropdown_service;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:dropDownOCIRFields_label")
	public static WebElement dropDown_OCIRFields;

	//
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = "//input[@value='Departments']//parent::div//parent::div//div[2]")
	public static WebElement department_worksheet;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = "//input[@value='EnterpriseVoiceVPNPolicy']//parent::div//parent::div//div[2]")
	public static WebElement Voicevpn_worksheet;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = "//input[@value='ActiveWaiting']//parent::div//parent::div//div[2]")
	public static WebElement scheduling_activewaiting;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = "(//a[contains(.,'Emergency Call Notification')])[3]")
	public static WebElement link_EmergencyCallNotifi;

	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:textFieldEmailToAddress")
	public static WebElement text_MailId;

	/**
	 * Page name : OPEASY Provisioning Page Element : Enterprise Settings
	 **/

	@FindBy(xpath = ".//*[@id='form1:labelFCCRegulationNote']")
	public static WebElement EmergencycallNote;

	/**
	 * Page name : OPEASY Provisioning Page Element : Enterprise Settings
	 **/

	@FindBy(xpath = "//input[@id='form1:checkboxAllowGroupOverride_input']")
	public static WebElement AllowOverride_checkbox;

	/**
	 * Page name : OPEASY Provisioning Page Element : Refresh Import
	 **/
	@FindBy(id = "form1:dropDownNewTemplateLevel_label")

	public static WebElement templatelevel;
	
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 * Element 	 : drop down Group
	 **/
	@FindBy(id = "form1:dropDownNewTemplateLevel_label")	
	public static WebElement dropdown_NewTemplateLevel;
	
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 * Element 	 : drop down Group
	 **/
	@FindBy(xpath = "//input[@id[contains(., 'newTemplate')]]")	
	public static WebElement text_NewTemplateName;
	

	/**
	 * Page name : OPEASY Provisioning Page Element : Refresh Import
	 **/
	@FindBy(id = "form1:newTemplate")
	public static WebElement templatename;

	/**
	 * Page name : OPEASY Provisioning Page Element : Refresh Import
	 **/
	@FindBy(id = "form1:buttonAddTemplate")
	public static WebElement addbutton;
	
	 /**
	  * Page name : OpEasy Provisioning Page Element
	  * Element 	 : Add Template button
	  **/
	 @FindBy(xpath = "//span[contains(., 'Add Template')]")	
	 public static WebElement btn_AddTemplate;

	/**
	 * Page name : OPEASY Provisioning Page Element : Refresh Import
	 **/
	@FindBy(id = "form1:tabSetLegacy:dropDownEMSAddressName_label")
	public static WebElement URIdropdown;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(linkText = "Lines")
	public static WebElement Lines;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(id = "form1:tabSetLegacy:lineTablePolycom:0:lineUserPolycom_label")
	// form1:tabSetLegacy:lineTablePolycom:0:lineUserPolycom_input
	public static WebElement position;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//input[@id='form1:textFieldUserProfileName']")
	public static WebElement textbox_Userprofile;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//input[@id='form1:textFieldUserProfileName']")
	public static WebElement textbox_DevicePassword;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//input[@id='form1:textInputDevicePassword']")
	public static WebElement textbox_DeviceAccessPassword;
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//input[@id='form1:textInputDevicePassword2']")
	public static WebElement textbox_DeviceAccessConfirmPassword;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//input[@id='form1:textInputDeviceUserName']")
	public static WebElement textbox_DeviceAccessUserName;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "(//span[contains(.,'Edit')])[1]")
	public static WebElement btn_Edit;
	
	/**
	 * Page name : OpEasy User Settings Page Element : Calling Line Lastname
	 **/
	@FindBy(xpath = "//span[@id[contains(., '0:staticTextPhoneNumber')]]")
	public static WebElement text_staticPhone;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//span[contains(.,'Phones')]")
	public static WebElement button_Phones;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//span[contains(.,'Add Shared Call Appearance')]")
	public static WebElement button_AddSCA;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//button[@id='form1:buttonEdit']")
	public static WebElement butn_Edit;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//span[contains(.,' Phone ')]")
	public static WebElement btn_Phone;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//label[@id='form1:dropDownAvailableCallcenters_label']")
	public static WebElement dropdown_callCenter;

	// button[@id='form1:buttonAssignCallCenter']

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//span[contains(.,'Assign Call Center')]")
	public static WebElement button_AssignCallCenter;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "(//button[contains(.,'Search')])//span")
	public static WebElement button_Search;

	//
	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//input[@id='form1:textFieldUserIdUserName']")
	public static WebElement textbox_clearspanUserId;

	//
	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "(//span[contains(.,'Search')])[last()]")
	public static WebElement butn_Search;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//label[@id='form1:dropDownBillingBundle_label']")
	public static WebElement dropdown_UserBillingBundle;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//input[@id='form1:UserSearchFragment:tableSearchCriteria:0:fieldValue']")
	public static WebElement type_searchvalue;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//span[contains(.,'Delete Device*')]")
	public static WebElement btn_DeleteDevice;

	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//span[contains(.,'Send Current Auth Codes')]")
	public static WebElement btn_SendAuthCodeEmail;
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//span[contains(.,'Sync Added/Modified Teams Users')]")
	public static WebElement btn_SyncAddModify;
	
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//span[contains(.,'Sync Deleted Teams Users')]")
	public static WebElement btn_DeletedTeamsUsers;
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "(//label[contains(.,'Desktop')])[1]")
	public static WebElement chkbox_Desktop;
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/ 
	@FindBy(xpath = "//label[contains(.,'ClearspanBridge')]")
	public static WebElement radioButton_ClearspanBridge;
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/
	@FindBy(id = "form1:dropDownDeviceName_label")
	public static WebElement phone_Device;
	
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/
	@FindBy(xpath = "//*[@id[contains(., 'DeviceLevel_label')]]")
	public static WebElement dropdown_DeviceLevel;
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceTemplate For Phone
	 * Management
	 **/
	@FindBy(xpath = "//*[@id[contains(., 'DeviceTemplate_label')]]")
	public static WebElement dropdown_DeviceTemplate;
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : Phone Management Link
	 **/
	@FindBy(xpath = "//input[@id='form1:textInputDevicePassword2']")
	public static WebElement textbox_ConfirmDeviceAccessPassword;
		
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/
	@FindBy(xpath = "//a[contains(.,'Voice VPN')]")
	public static WebElement link_VoiceVPN;
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/
	@FindBy(id = "form1:textFieldCSBridgeUserName")
	public static WebElement pingclientUserName;
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/
	@FindBy(xpath = "//span[@class='ui-messages-warn-summary']")
	public static WebElement ping_WarningMsg;
		
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/
	@FindBy(xpath = "//span[@class='ui-messages-error-summary']")
	public static WebElement ping_ErrorMsg;
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/
	@FindBy(xpath = "//label[contains(.,'Use the existing Ping account')]")
	public static WebElement radiobtn_existingPingacct;
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/
	@FindBy(xpath = "//button[contains(.,'Phones')]")
	public static WebElement tab_Phones;
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/
	@FindBy(xpath = "//label[@id='form1:dropDownDeviceSearchList_label']")
	public static WebElement dropdown_phonedeviceList;

	
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/
	@FindBy(xpath = "//label[contains(.,'Retain')]")
	public static WebElement label_Retain;
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/
	@FindBy(xpath = "(//a[contains(.,'User Profiles')])[1]")
	public static WebElement link_UserProfile;
	
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/
	@FindBy(xpath = "//label[@id='form1:dropDownServiceSelect_label']")
	public static WebElement dropdown_servi;
	
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/
	@FindBy(xpath = "//a[contains(.,'Clear All')]")
	public static WebElement checkbox_clearAll;
	
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/
	@FindBy(xpath = "//label[contains(.,'Users')]")
	public static WebElement chkbox_Users;
	
	/**
	 * Page name : OPEASY Provisioning Page * Element : DeviceLevel For Phone
	 * Management
	 **/
	@FindBy(xpath = "//label[contains(.,'Domains')]")
	public static WebElement worksheet_Domains;
	
	
	// **********************************************Viru
	// End***********************************
}
//