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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminToolsPages {
	public WebDriver driver;

	public AdminToolsPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//**************************************Viru Start***************************************
	/**
	 * Page name : OPEASY Provisioning Page
	 * Element 	 : User ID text_box
	 **/

	
	/**
	 * Page name : OPEASY Administrative Tools Page
	 * Element 	 : Licensing Link
	 **/
	@FindBy(xpath=".//*[@id='form1:hyperlinkLicensing']")	
	public static WebElement link_Licensing;
	
	/**
	 * Page name : OPEASY Licensing Page
	 * Element 	 : Licensing Page
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Licensing')]")	
	public static WebElement text_Licensing_ScreenName;
	
	/**
	 * Page name : OPEASY Licensing Page
	 * Element 	 : System Licensing Link
	 **/
	@FindBy(xpath=".//*[@id='form1:hyperlinkSystemLicensing']")	
	public static WebElement link_SystemLicensing;

	/**
	 * Page name : OPEASY Licensing Page
	 * Element 	 : System Licensing Link
	 **/
	@FindBy(id = "form1:hyperlinkDatabaseCleanup")	
	public static WebElement link_DatabaseCleanup;
	
	/**
	 * Page name : OPEASY administrative tools Page
	 * Element 	 : Retrofit Log page
	 **/
	@FindBy(xpath="//label[@id='form1:dropDownLoginLevel_label']")	
	public static WebElement dropdown_Loginlevel;

	/**
	 * Page name : OPEASY Licensing Page
	 * Element 	 : System Licensing Link
	 **/
	@FindBy(id = "form1:hyperlinkDefaultPrivilegeManagement")	
	public static WebElement link_DefaultPrivilegeManagement;
	
	
	/**
	 * Page name : OPEASY System Licensing page Page
	 * Element 	 : System Licensing page
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'System Licensing')]")	
	public static WebElement text_SystemLicensing_ScreenName;
	
	/**
	 * Page name : OPEASY System Licensing Page
	 * Element 	 : Opeasy Licensee Allocation Button
	 **/
	@FindBy(xpath=".//*[@id='form1:buttonLicenseAllocation']")	
	public static WebElement btn_LicenseAllocation;
	
	/**
	 * Page name : OPEASY Licensee Allocation Page
	 * Element 	 : Opeasy Licensee Allocation 
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'OpEasy License Allocation')]")	
	public static WebElement text_LicenseAllocation_screenName;
	
	/**
	 * Page name : OPEASY Licensee Allocation Page
	 * Element 	 : Opeasy OK Button
	 **/
	@FindBy(id = "form1:buttonOK")	
	public static WebElement btn_OK;
	
	/**
	 * Page name : OPEASY Licensing Page
	 * Element 	 : Enterprise Licensing link
	 **/
	@FindBy(xpath=".//*[@id='form1:hyperlinkEnterpriseLicensing']")	
	public static WebElement link_EnterpriseLicensing;
	
	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : Enterprise Licensing link
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Enterprise Licensing')]")	
	public static WebElement text_EnterpriseLicensing_ScreenName;
	

	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : License type
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Enterprise Licensing')]")	
	public static WebElement text_Licensetype_ScreenName;
	
	/**
	 * Page name : OPEASY Administrative Tools Page
	 * Element 	 : Mediapacks link
	 **/
	@FindBy(xpath=".//*[@id='form1:hyperlinkMediaPacks']")	
	public static WebElement link_Mediapacks;
	
	/**
	 * Page name : OPEASY AnalogphonemediaPacks Page
	 * Element 	 : Analog phone Media Packs
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Analog Phone Media Packs')]")	
	public static WebElement text_AnalogphonemediaPack_ScreenName;
	
	/**
	 * Page name : OPEASY AdministrativeTools Page
	 * Element 	 : AdministrativeTools
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Administrative Tools')]")	
	public static WebElement text_AdministrativeTools_ScreenName;
	
	/**
	 * Page name : OPEASY Administrative Tools Page
	 * Element 	 : System Message link
	 **/
	@FindBy(xpath=".//*[@id='form1:hyperlinkSystemMessage']")	
	public static WebElement link_SystemMessage;
	
	/**
	 * Page name : OPEASY System Message Page
	 * Element 	 : System Message
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'System Message')]")	
	public static WebElement text_SystemMessage_ScreenName;
	
	/**
	 * Page name : OPEASY System Message Page
	 * Element 	 : System Message text box
	 **/
	@FindBy(xpath=".//*[@id='form1:textAreaSystemMessage']")	
	public static WebElement text_SystemMessage;
	
	/**
	 * Page name : OPEASY System Message Page
	 * Element 	 : Set Message Button
	 **/
	@FindBy(id="form1:buttonSetMessage")	
	public static WebElement btn_SetMessage;
	
	/**
	 * Page name : OPEASY System Message Page
	 * Element 	 : Refresh Button
	 **/
	@FindBy(id = "form1:buttonRefresh")	
	public static WebElement btn_Refresh;
	
	/**
	 * Page name : OPEASY System Message Page
	 * Element 	 : Message Display at top
	 **/
	@FindBy(xpath=".//*[@id[contains(.,':layoutPanelSystemMessage')]]")	
	public static WebElement text_MessageDisplay;
	
	/**
	 * Page name : OPEASY System Message Page
	 * Element 	 : Clear Message Button
	 **/
	@FindBy(id = "form1:buttonClearMessage")	
	public static WebElement btn_ClearMessage;
	
	/**
	 * Page name : OPEASY administrative tools Page
	 * Element 	 : System settings link
	 **/
	@FindBy(id = "form1:hyperlinkSystemSettings")	
	public static WebElement link_SystemSettings;
	
	/**
	 * Page name : OPEASY System Settings Page
	 * Element 	 : System Settings
	 **/
	@FindBy(xpath=".//*[@id[contains(.,':layoutPanelSystemMessage')]][contains(text(),'Test_Message')]")	
	public static WebElement text_SystemSettings_ScreenName;
	
	/**
	 * Page name : OPEASY System settings Page
	 * Element 	 : Cancel Button
	 **/
	@FindBy(xpath=".//*[@id='form1:buttonCancel']")
	public static WebElement btn_cancel;
	
	
	/**
	 * Page name : OPEASY Administrative Tools Page
	 * Element 	 : Troubleshooting link
	 **/
	@FindBy(xpath=".//*[@id='form1:hyperlinkTroubleshooting']")	
	public static WebElement link_Troubleshooting;
	
	/**
	 * Page name : OPEASY Administrative Tools Page
	 * Element 	 : Troubleshooting link
	 **/
	@FindBy(xpath="//a[contains(text(),'Provisioning')]")	
	public static WebElement link_Provisioning;
	
	/**
	 * Page name : OPEASY Troubleshooting Phones Page
	 * Element 	 : Troubleshooting Phones
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Troubleshooting Phones')]")	
	public static WebElement text_Troubleshooting_screenName;
	

	/**
	 * Page name : OPEASY Administrative Tools Page
	 * Element 	 : Unique ID Management link
	 **/
	@FindBy(id="form1:hyperlinkUniqueIdManagement")	
	public static WebElement link_UniqueIDManagement;
	
	/**
	 * Page name : OPEASY Unique ID Management Page
	 * Element 	 : Unique ID Management 
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Unique ID Management')]")	
	public static WebElement text_UniqueIDManagement_ScreenName;

	/**
	 * Page name : OPEASY Administrative Tools Page
	 * Element 	 : User Authentication Management link
	 **/
	@FindBy(xpath=".//*[@id='form1:hyperlinkUserAuthenticationManagement']")	
	public static WebElement link_UserAuthManagement;
	
	/**
	 * Page name : OPEASY User Authentication Management Page
	 * Element 	 : User Authentication Management
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'User Authentication Management')]")	
	public static WebElement text_UserAuthManagement_ScreenName;
	
	/**
	 * Page name : OPEASY Administrative Tools Page
	 * Element 	 : Default Privilege Management link
	 **/
	@FindBy(xpath=".//*[@id='form1:hyperlinkDefaultPrivilegeManagement']")	
	public static WebElement link_DefaultPrivilege;
	
	/**
	 * Page name : OPEASY Default Privilege Management Page
	 * Element 	 : Default Privilege Management
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Default Privilege Management')]")	
	public static WebElement text_DefaultPrivilege_screenName;
	
	/**
	 * Page name : OPEASY Default Privilege Management Page
	 * Element 	 : Login Level Drop Down
	 **/
	@FindBy(id ="form1:dropDownLoginLevel")	
	public static WebElement dropDown_AdminLoginlevel;
	
	/**
	 * Page name : OPEASY Mainmenu Page
	 * Element 	 : No Element present 
	 **/
	@FindBy(xpath=".//*[@id='form1:gridPanelControls']//tbody//tr[3]//td//div//span[contains(.,'           ')]")	
	public static WebElement text_TableEmpty;
	
	/**
	 * Page name : OPEASY Administrative Tools Page
	 * Element 	 : System Message link
	 **/
	@FindBy(xpath=".//*[@id='form1:hyperlinkSystemMessage']")	
	public static WebElement link_SysMessage;
	
	/**
	 * Page name : OPEASY Administrative Tools Page
	 * Element 	 : Enterprise Settings link
	 **/
	@FindBy(xpath=".//*[@id='form1:hyperlinkEnterpriseSettings']")	
	public static WebElement link_EnterpriseSettings;

	/**
	 * Page name : OPEASY Enterprise Settings Page
	 * Element 	 : Enterprise Settings
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Enterprise Settings')]")	
	public static WebElement text_EnterpriseSettings_ScreenName;
	
	/**
	 * Page name : OPEASY Enterprise Settings Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(xpath=".//*[@id='form1:layoutPanelEnterprise:dropDownEnterprise_list']")	
	public static WebElement dropdown_Enterprise;
	
	/**
	 * Page name : OPEASY Enterprise Settings Page
	 * Element 	 : drop down Template Definition
	 **/
	@FindBy(xpath=".//*[@id='form1:layoutPanelProvisioning:dropDownTemplateKeyDefinitions_list']")	
	public static WebElement dropdown_TemplDef;
	
	/**
	 * Page name : OPEASY Administrative Tools Page
	 * Element 	 : Provisioning link
	 **/
	@FindBy(xpath=".//*[@id='form1:HeaderPane:groupPanel1']//span[contains(.,'Provisioning')]")	
	public static WebElement Label_Provisioning;
	
	/**
	 * Page name : OPEASY Administrative Tools Page
	 * Element 	 : Remedy AIN List link
	 **/
	@FindBy(xpath="//a[contains(.,'Remedy AIN List')]")	
	public static WebElement link_RemedyAIN;
	
	/**
	 * Page name : OPEASY Remedy AIN List Page
	 * Element 	 : Remedy AIN List link
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(.,'Remedy AIN List')]")	
	public static WebElement text_RemedyAIN_ScreenName;
	

//	
//	/**
//	 * Page name : OPEASY Remedy AIN List Page
//	 * Element 	 : AIN value
//	 **/
//	@FindBy(xpath=".//*[@id='form1:gridPanelControls']/tbody/tr[3]/td//tbody//td[1]//span[contains(.,'21000')]")	
//	public static WebElement text_AINvalue;
//	
	/**
	 * Page name : OPEASY Remedy AIN List Page
	 * Element 	 : ADD Button
	 **/
	@FindBy(xpath=".//*[@id='form1:buttonAddAIN']")	
	public static WebElement btn_ADD;
	
	/**
	 * Page name : OPEASY Remedy AIN List Page
	 * Element 	 : text box
	 **/
	//@FindBy(xpath=".//*[@id='form1:gridPanelControls']/tbody//tr[3]//tbody//tr[last()-2]//td[1]//span[2]//input")
	@FindBy(xpath="//*[@id='form1:tableQueryResults:0:textFieldGroupAIN']")
	public static WebElement text_AINValue;
	

	/**
	 * Page name : OPEASY Remedy AIN List Page
	 * Element 	 : text box
	 **/
	@FindBy(xpath="//span[contains(.,'234567')]//parent::td//parent::tr//span[contains(.,'Delete')]//a")	
	public static WebElement Delete_AINValue;
	
	
	/**
	 * Page name : OPEASY Remedy AIN List Page
	 * Element 	 : text box
	 **/
	@FindBy(xpath="//*[@id='form1:tableQueryResults:0:textFieldDescription']")	
	public static WebElement text_Desc;

	/**
	 * Page name : OPEASY Remedy AIN List Page
	 * Element 	 : Apply Button
	 **/
	@FindBy(xpath=".//button[@id[contains(.,':buttonApply')]]")	
	public static WebElement btn_Apply;
	
	/**
	 * Page name : OPEASY Remedy AIN List Page
	 * Element 	 : text box
	 **/
	@FindBy(xpath=".//*[@id='form1:gridPanelControls']/tbody//tr[3]//tbody//tr[4]//td[1]//span[2]//input")
	public static WebElement text_AINValue2;
	
	/**
	 * Page name : OPEASY Remedy AIN List Page
	 * Element 	 : text box
	 **/
	@FindBy(xpath=".//*[@id='form1:gridPanelControls']/tbody//tr[3]//tbody//tr[4]//td[2]//span[2]//input")	
	public static WebElement text_Desc2;
	
	/**
	 * Page name : OPEASY Remedy AIN List Page
	 * Element 	 : Delete Link
	 **/
	@FindBy(xpath="//span[contains(.,'88888')]//parent::td//parent::tr//td[last()]//span//a")	
	public static WebElement link_Delete;
	
	
	/**
	 * Page name : OPEASY Remedy AIN List Page
	 * Element 	 : Delete Link
	 **/
	@FindBy(xpath=".//*[@id='form1:gridPanelControls']/tbody//tr[3]//tbody//tr[last()-2][contains(.,'22222')]//td[last()]//span")	
	public static WebElement link_Delete1;
	
	/**
	 * Page name : OPEASY default Privilege Management Page
	 * Element 	 : Access drop Down
	 **/
	@FindBy(xpath="//span[contains(.,'User and Device Add/Delete')]//parent::td//parent::tr//td[last()]//span//select")	
	public static WebElement text_UserDevice;
	
	/**
	 * Page name : OPEASY Default Privilege Management Page
	 * Element 	 : Saved Message
	 **/
	@FindBy(xpath="//span[contains(.,'Saved')]")	
	public static WebElement text_saved;
	
	/**
	 * Page name : OPEASY Home Page
	 * Element 	 : OpEasy
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'OpEasy')]")	
	public static WebElement text_Opeasy;
	
	/**
	 * Page name : OPEASY Users Page
	 * Element 	 : Drop Down Group
	 **/
	@FindBy(xpath=".//*[@id='form1:dropDownGroup']")	
	public static WebElement text_Group;
	
	/**
	 * Page name : OPEASY Users Page
	 * Element 	 : Drop Down Extension  
	 **/
	
	//@FindBy(xpath="(//span[contains(.,'(All Users)')])[1]")
	@FindBy(id="form1:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:rowGroupSearchCriteria:0:columnFieldName:fieldName_list")	
	public static WebElement dropdown_Extension;
	
	/**
	 * Page name : OPEASY Users Page
	 * Element 	 : Extension text box
	 **/
	@FindBy(id="form1:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:rowGroupSearchCriteria:0:columnFieldValue:fieldValue")	
	public static WebElement text_Extension;
		
	/**
	 * Page name : OPEASY Users Page
	 * Element 	 : Edit Link  
	 **/
	@FindBy(xpath="(//a[contains(text(), 'Edit')])[1]")	
	public static WebElement link_Edit;
	
	/**
	 * Page name : OPEASY Advanced User Modify Page
	 * Element 	 : Advanced User Modify  
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(.,'Advanced: User Modify')]")	
	public static WebElement text_AdvUserModify_ScreenName;
	
	/**
	 * Page name : OPEASY Remedy AIN List Page
	 * Element 	 :Single Page data IMG
	 **/
	@FindBy(xpath="(.//img[@id[contains(.,'_paginateButton_image')]])[1]")	
	public static WebElement btn_singlePage;

	/**
	/**
	 * Page name : OPEASY administrative tools Page
	 * Element 	 : Retrofit Log link
	 **/
	@FindBy(xpath="(//a[contains(text(),'Retrofit Log')])[2]")	
	public static WebElement link_retrofitlog;
	
	/**
	 * Page name : OPEASY administrative tools Page
	 * Element 	 : Retrofit Log page
	 **/
	@FindBy(xpath="(//span[contains(text(),'Retrofit Log')])[1]")	
	public static WebElement text_retrofitLog;
	
	/**
	 * Page name : OPEASY administrative tools Page
	 * Element 	 : Retrofit Log page
	 **/
	@FindBy(xpath="//input[@id='form1:tableDeviceBilling:0:fieldValue']")	
	public static WebElement text_DeviceBillingtype;
	
	//**********************************************Viru End***********************************
}
