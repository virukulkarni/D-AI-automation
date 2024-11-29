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

public class PhoneManagementPages {
	public WebDriver driver;

	public PhoneManagementPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//**************************************Viru Start***************************************
	/**
	 * Page name : OPEASY Main menu Page
	 * Element 	 : User ID text_box
	 **/
	
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName']")
	public static WebElement text_Mainmenu_ScreenName;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Device Name drop down list
	 **/
	
	@FindBy(id ="form1:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:rowGroupSearchCriteria:0:columnFieldValue:fieldValue_field")
	public static WebElement text_searchvalue;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Device Name drop down list
	 **/
	
	@FindBy(id ="form1:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:rowGroupSearchCriteria:0:columnFieldCondition:fieldCondition")
	public static WebElement dropdown_searchFilter;
	

	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Device Name drop down list
	 **/
	
	@FindBy(id ="form1:UserSearchFragment:tableSearchCriteria:0:fieldValue")
	public static WebElement text_searchEqualtovalue;
	
	/**
	 * Page name : OPEASY Provisioning Page
	 * Element 	 : Phone Management link
	 **/
	
	@FindBy(id="form1:hyperlinkPhoneManagement")
	public static WebElement link_PhoneManagement;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Search Button
	 **/
	
	@FindBy(xpath=".//input[@id[contains(.,':buttonSearch')]]")
	public static WebElement btn_Search;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Device Name drop down list
	 **/
	
//	@FindBy(xpath =".//select[@id[contains(.,'columnFieldName:fieldName')]]")
	@FindBy(xpath ="//select//option[@value='Device Name']")
	
	//@FindBy(xpath ="form1:UserSearchFragment:tableSearchCriteria:0:fieldName_label")
	public static WebElement dropdown_DeviceName;
	
	/**
	 * Page name : OPEASY Phone Device Add Page
	 * Element 	 : Device Name text box
	 **/
	
	@FindBy(xpath =".//*[@id='form1:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:rowGroupSearchCriteria:0:columnFieldValue:fieldValue_field']")
	public static WebElement text_DeviceNamee;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Search Button
	 **/
	
//	@FindBy(xpath=".//*[@id='form1:tableQueryResults:_table']//tbody//tr[3][contains(.,'9773337236')]")
//	public static WebElement link_Edit;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Search Button
	 **/
	
	@FindBy(xpath=".//*[@id='form1:tableUsers:_table']//tbody//tr[contains(.,'9773337236')]")
	public static WebElement link_EditPhoneDevice;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Search Button
	 **/
	
	@FindBy(xpath="//span[contains(.,'Phone Device Modify')]//span")
	public static WebElement text_PhoneDeviceModify;
	/**
	 * Page name : OPEASY User Modify Page
	 * Element 	 : Delete Button 
	 **/
	
	@FindBy(xpath="//span[contains(.,'Delete')]//input")
	public static WebElement btn_Delete;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Phone Management 
	 **/
	
	@FindBy(xpath="//td//span[contains(.,'Phone Management')]//span")
	public static WebElement text_PhonemanagementName;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Group Device Level
	 **/
	
	@FindBy(xpath="//span[contains(.,'BNGTestAuto_Template')]")
	public static WebElement text_GroupDevice;

//	/**
//	 * Page name : OPEASY Phone Management Page
//	 * Element 	 : Device Level
//	 **/
//	
//	@FindBy(xpath=".//*[@id='form1:tableQueryResults:_table']//tbody//tr[3]//th[3]//table//tbody//tr//td[1]//span//a//span[contains(text(),'Device Level')]")
//	public static WebElement text_DeviceLevel_ScreenName;
	
	/**
	 * Page name : OPEASY Phone Management: Phone Template Page
	 * Element 	 : Phone Management: Phone Template
	 **/
	
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Phone Management: Phone Template')]")
	public static WebElement text_PhoneManagementTemplate_ScreenName;
	

	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Device Levels drop down
	 **/
	
	@FindBy(xpath=".//*[@id='form1:dropDownDeviceLevels_label']")
	public static WebElement dropdown_DeviceLevels;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Enterprise Device 
	 **/
	
	@FindBy(xpath="(.//*[@id='form1:tableQueryResults:_table']//tbody//td[3]//span[contains(text(),'Enterprise')])[1]")
	public static WebElement text_EnterpriseDevice;
	
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : View Button
	 **/
	
	@FindBy(xpath="(.//*[@id='form1:tableQueryResults:_table']//tbody//td[3]//span[contains(text(),'Enterprise')])[1]//parent::span//parent::td//parent::tr//td[12]//span")
	public static WebElement btn_EnterpriseView;
	
	/**
	 * Page name : OPEASY Phone Management: Phone Template Page
	 * Element 	 : Enterprise Template Level
	 **/
	
	@FindBy(xpath=".//*[@id='form1:gridPanelControls']/tbody//tr[3]//td//span[6]//span[contains(.,'Enterprise')]")
	public static WebElement text_Enterprise_ScreenName;

	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Apply Button
	 **/
	
	@FindBy(xpath=".//*[@id='form1:buttonApply']")
	public static WebElement btn_Apply;
	

	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Saved
	 **/
	
	@FindBy(xpath="//span[contains(text(),'Saved')]")
	public static WebElement text_Saved_ScreenName;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : ADD Button
	 **/
	
	@FindBy(xpath=".//*[@id='form1:buttonAdd']")
	public static WebElement btn_ADD;
	
	/**
	 * Page name : OPEASY Phone Device Add Page
	 * Element 	 : Phone Device Add
	 **/
	
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Phone Device Add')]")
	public static WebElement text_PhoneDeviceAdd_ScreenName;
	
	/**
	 * Page name : OPEASY Phone Device Add Page
	 * Element 	 : Device Name text box
	 **/
	
	@FindBy(xpath = "//*[@id='form1:textInputDeviceName']")
	public static WebElement text_DeviceName;
	
	/**
	 * Page name : OPEASY Phone Device Add Page
	 * Element 	 : Device Level Drop Down
	 **/
	
	@FindBy(xpath=".//*[@id='form1:dropDownDeviceLevel']")
	public static WebElement text_DeviceLevel;

	/**
	 * Page name : OPEASY Phone Device Add Page
	 * Element 	 : Device Type Drop down
	 **/
	
	@FindBy(id = "form1:dropDownDeviceType_label")
	public static WebElement dropdown_DeviceType;

	/**
	 * Page name : OPEASY Phone Device Add Page
	 * Element 	 : Template Drop Down
	 **/
	
	@FindBy(id = "form1:dropDownTemplate_label")
	public static WebElement dropdown_Template;
	
	/**
	 * Page name : OPEASY Phone Device Add Page
	 * Element 	 : Manage Users Button
	 **/
	
	@FindBy(id = "form1:buttonManageUsers")
	public static WebElement btn_ManageUsers;
	
	/**
	 * Page name : OPEASY Phone Device Modify: Manage Users Page
	 * Element 	 : Phone Device Modify
	 **/
	
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Phone Device Modify: Manage Users')]")
	public static WebElement text_DeviceModify_ScreenName;
	
	/**
	 * Page name : OPEASY Phone Device Modify: Manage Users Page
	 * Element 	 : Extension search box
	**/
	
	@FindBy(id = ".//*[@id='form1:layoutPanelUserDisplay:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:_table']//tbody//tr//td[1]//span//select")
	public static WebElement text_Extension;

	/**
	 * Page name : OPEASY Phone Device Modify: Manage Users Page
	 * Element 	 : Text Box to enter Extension Number
	 **/

	//@FindBy(xpath="//select[@id='form1:layoutPanelUserDisplay:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:rowGroupSearchCriteria:0:columnFieldName:fieldName']/../../../../td[3]/span/span[1]/span/input")
	@FindBy(xpath=".//*[@id='form1:layoutPanelUserDisplay:layoutPanelUserSearch:UserSearchFragment:tableSearchCriteria:_table']//tbody//tr//td[3]//span//input")
	public static WebElement text_ExtensionNumber;

	/**
	 * Page name : OPEASY Phone Device Modify: Manage Users Page
	 * Element 	 : Endpoint Type
	 **/
	
	@FindBy(id ="form1:dropDownPrimarySCA_label")
	public static WebElement text_EndpointType;
	
	/**
	 * Page name : OPEASY Phone Device Modify: Manage Users Page
	 * Element 	 : Add User Button
	 **/
	
	@FindBy(id = "form1:buttonAddUser")
	public static WebElement btn_AddUser;
	
	/**
	 * Page name : OPEASY Phone Device Add Page
	 * Element 	 : MACAddress text box
	 **/
	
	@FindBy(id = "form1:textInputMacAddress")
	public static WebElement text_MACAddress;
	
	/**
	 * Page name : CLEARSPAN Profiles Page
	 * Element 	 : Group link
	 **/
	
	@FindBy(xpath="html/body/table[2]/tbody/tr[2]/td[4]/table/tbody/tr[4]/td/table/tbody/tr/td[1]/table/tbody/tr[9]/td/a[contains(text(),'Group')]")
	public static WebElement link_Group;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Edit Button
	 **/
	
	@FindBy(xpath="//span[contains(.,'Template_Test')]//span//parent::span//parent::td//parent::tr//td[last()]//span//a")
	public static WebElement btn_Edit;
		
	/**
	 * Page name : OPEASY Phone Device Modify Page
	 * Element 	 : View Template Button
	 **/
	
	@FindBy(xpath=".//*[@id='form1:buttonViewTemplate']")
	public static WebElement btn_ViewTemplate;
	
	/**
	 * Page name : OPEASY Phone Device Edit: Phone Template Page
	 * Element 	 : Template Name
	 **/
	
	@FindBy(xpath="//span[contains(.,'Test_Opeasy')]//span")
	public static WebElement text_template;
	
	/**
	 * Page name : OPEASY Phone Device Modify: Manage Users Page
	 * Element 	 : Add User Button
	 **/
	
	@FindBy(xpath=".//*[@id='form1:layoutPanelUserDisplay:layoutPanelUserSearch:layoutPanelLineSelectSeparator:buttonSearch']")
	public static WebElement btn_SearchforUsers;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Phone Management
	 **/
	
	@FindBy(xpath="//span[contains(.,'Phone Management')]//a")
	public static WebElement text_Phonemanagement;

	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Device Name drop down list
	 **/
	
	@FindBy(xpath="//span[contains(.,'Automation')]")
	public static WebElement text_searchdevice;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Device Name drop down list
	 **/
	
	@FindBy(xpath="//span[contains(.,'Delete')]")
	public static WebElement button_Delete;
	
	/**
	 * Page name : OPEASY Provisioning Page
	 * Element 	 : Phone Management link
	 **/
	//*[@id="form1:tabSetLegacy:progKeyTable:0:progkeyValLabel_label"]
	@FindBy(xpath="//label[@id='form1:UserSearchFragment:tableSearchCriteria:0:fieldName_label']")
	public static WebElement dropdown_DeviceSearch;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Device Name drop down list
	 **/
	
	@FindBy(id="form1:UserSearchFragment:tableSearchCriteria:0:fieldValue")
	public static WebElement text_box;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Device Name drop down list
	 **/
	
	@FindBy(xpath="//span[contains(.,'Delete')]")
	public static WebElement button_Search;
	
	/**
	 * Page name : OPEASY Phone Management Page
	 * Element 	 : Device Name drop down list
	 **/
	
	@FindBy(xpath="//span[contains(.,'Phones')]")
	public static WebElement btn_Phones;
	
	//**********************************************Viru End***********************************
}
