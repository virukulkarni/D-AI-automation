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

public class PhoneTemplatePages {
	public WebDriver driver;

	public PhoneTemplatePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// **************************************Viru
	// Start***************************************
	/**
	 * Page name : OPEASY Main menu Page Element : User ID text_box
	 **/

	@FindBy(xpath = ".//*[@id='form1:staticTextScreenName']")
	public static WebElement text_Mainmenu_ScreenName;

	/**
	 * Page name : OPEASY Provisioning Page Element : Provisioning link
	 **/

	@FindBy(xpath = ".//*[@id='form1:LeftPane:navigationTree:app10:app10_link']")
	// @FindBy(xpath=".//*[@id='form1:staticTextScreenName']")
	public static WebElement text_Provisioning;

	/**
	 * Page name : OPEASY Provisioning Page Element : Phone Templates link
	 **/

	@FindBy(id = "form1:hyperlinkTemplates")
	public static WebElement link_Templates;
	
	/**
	 * Page name : OPEASY Provisioning Page Element : Phone Templates link
	 **/

	@FindBy(xpath = "//button[@aria-label='Edit Prog Keys']//span")
	public static WebElement tab_ProgKeys;
	
	/**
	 * Page name : OPEASY Provisioning Page Element : Key Definitions link
	 **/

	@FindBy(xpath = "//a[contains(text(),'Key Definitions')]")
	public static WebElement link_KeyDefinitions;
	
	/**
	 * Page name : OPEASY Provisioning Page Element : Key Definitions page
	 **/

	@FindBy(xpath = "//span[contains(text(),'Key Definitions')]")
	public static WebElement text_KeyDefinitions;
	
	/**
	 * Page name : OPEASY Global Configuration File settings Page Element : Extra settings Tab
	 **/

	@FindBy(xpath = ".//a[contains(text(),'Extra Settings')]")
	public static WebElement text_ExtSettings;
	
	/**
	 * Page name : OPEASY Global Configuration File settings Page Element : Extra settings Tab
	 **/

	@FindBy(xpath = ".//a[contains(text(),'General Settings')]")
	public static WebElement text_GeneralSettings;
	
	/**
	 * Page name : OPEASY Global Configuration File settings Page Element : Extra settings Tab
	 **/
	
	@FindBy(xpath = ".//a[contains(text(),'System Config File Extension')]")
	public static WebElement text_SysConfigExtSettings;
	
	/**
	 * Page name : OPEASY Global Configuration File settings Page Element : Dial Plan Tab
	 **/

	@FindBy(xpath = ".//a[contains(text(),'Dial Plan')]")
	public static WebElement text_DialPlan;

	/**
	 * Page name : OPEASY Global Configuration File settings Page Element : Dial Plan Tab
	 **/

	@FindBy(xpath = ".//a[contains(text(),'Custom Rings')]")
	public static WebElement text_CustomRings;
	
	
	/**
	 * Page name : OPEASY Phone Templates Page Element : Definitions link
	 **/

	@FindBy(id = "form1:hyperlinkDefinitions")
	public static WebElement link_Definitions;

	/**
	 * Page name : OPEASY Template Definitions Page Element : Template
	 * Definitions
	 **/

	@FindBy(xpath = ".//a[@id[contains(.,'hyperlinkDefinitions')]]")
	public static WebElement text_TemplateDefinitions_ScreenName;


	/**
	 * Page name : OPEASY Template Definitions Page Element : Device Type
	 * dropdown
	 **/

	/**
	 * Page name : OPEASY Template Definitions Page Element : Template
	 * Definitions
	 **/

	/**
	 * Page name : OPEASY Template Definitions Page Element : Template
	 **/

	@FindBy(xpath = ".//*[@id='TemplateDefinition:templateTable:_table']//tbody//tr[3]//parent::td//parent::tr//td[last()]//span")
	public static WebElement text_dropdown;

	/**
	 * Page name : OPEASY Template Definitions Page Element : Delete Dropdown
	 **/

	@FindBy(xpath = ".//*[@id='TemplateDefinition:templateTable:_table']//tbody//tr[3]//parent::td//parent::tr//td[last()]//select")
	public static WebElement dropdown_Delete;

	/**
	 * Page name : OPEASY Template Definitions Page Element : Delete Dropdown
	 **/

	@FindBy(xpath = ".//*[@id='TemplateDefinition:templateTable:_table']//tbody//tr[3]//td[1]//span[2]//span[contains(text(),'--(Delete Pending')]")
	public static WebElement text_DeletePending_screenName;

	/**
	 * Page name : OPEASY Template Delete Page Element : Template Delete
	 **/

	@FindBy(xpath = ".//*[@id='form1:staticTextScreenName'][contains(text(),'Template Delete')]")
	public static WebElement text_TemplateDelete_ScreenName;

	/**
	 * Page name : OPEASY Template Modify Page Element : Template Modify
	 **/
	@FindBy(xpath = ".//*[@id='form1:staticTextScreenName'][contains(text(),'Template Modify')]")
	public static WebElement text_TemplateModify_ScreenName;

	/**
	 * Page name : OPEASY Template Definitions Page Element : Delete Failed
	 **/

	@FindBy(xpath = ".//*[@id='TemplateDefinition:templateTable:_table']//tbody//tr[3]//td[1]//span[2]//span[contains(text(),'--(Delete Failed')]")
	public static WebElement text_Deletefailed_screenName;

	/**
	 * Page name : OPEASY Template Definitions Page Element : Global settings
	 * link
	 **/
	@FindBy(id = "form1:hyperlinkGlobalSettings")
	public static WebElement link_GlobalSettings;

	/**
	 * Page name : OPEASY Global Configuration File Settings Page Element :
	 * Global Configuration File Settings
	 **/

	@FindBy(xpath = ".//*[@id='form1:staticTextScreenName'][contains(text(),'Global Configuration File Settings')]")
	public static WebElement text_Configfile_screenName;

	/**
	 * Page name : OPEASY Global Configuration File Settings Page Element :
	 * PhoneManufacturer dropdown
	 **/

	@FindBy(id = "form1:dropDownPhoneManufacturer_label")	
	public static WebElement dropdown_PhoneManufacturer;

	/**
	 * Page name : OPEASY Global Configuration File Settings Page Element :
	 * General settings link
	 **/

	@FindBy(xpath = "//*[@id='form1:tabSet']/ul/li[contains(., 'General Settings')]/a")
	public static WebElement tab_GeneralSettings;

	/**
	 * Page name : OPEASY Template Modify Page Page Element :
	 * General Tab
	 **/

	@FindBy(xpath = "//div[contains(text(),'General Settings')]")
	public static WebElement text_Generaltab;
	/**
	 * Page name : OPEASY Global Configuration File Settings Page Element :
	 * Group settings button
	 **/

	@FindBy(xpath = "//button[@aria-label='Edit Group Settings']//span")
	public static WebElement btn_GroupSettings;



	/**
	 * Page name : OPEASY Phone Templates Page Element : Phone Templates
	 **/

	@FindBy(xpath = ".//*[@id='form1:staticTextScreenName'][contains(text(),'Phone Templates')]")
	public static WebElement text_PhoneTemplates_ScreenName;

	/**
	 * Page name : OPEASY Global Configuration File Settings Page Element :
	 * Extra settings button
	 **/

	@FindBy(xpath = "//*[@id='form1:tabSet']/ul/li[contains(., 'Extra Settings')]/a")
	public static WebElement tab_ExtraSettings;

	/**
	 * Page name : OPEASY Template Definitions Page Element : Edit drop Down
	 **/

	@FindBy(xpath = ".//*[@id='TemplateDefinition:templateTable:_table']//tbody//tr[3]//td[4]//span[contains(.,'Edit')]")
	public static WebElement dropdown_Edit;

	/**
	 * Page name : OPEASY Main menu Page Element : Main Menu Link
	 **/

	@FindBy(xpath = ".//*[@id='TemplateDefinition:HeaderPane:groupPanel1:hyperlinkMainMenu']")
	public static WebElement link_Mainmenu;

	/**
	 * Page name : OPEASY Phone Template Page Element : Phone Template Screen
	 **/

	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement template_ScreenName;

	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType list
	 **/

	@FindBy(id = "form1:dropDownPhoneDeviceType_label")
	public static WebElement list_DeviceType;

	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/
	@FindBy(id = "form1:hyperlinkEntDeviceTypeTags")
	public static WebElement link_DeviceTypetags;
	
	

	/**
	 * Page name : OPEASY Phone Template Page Element : Enterprises DeviceType
	 * tags Screen
	 **/

	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement devicetypetags_ScreenName;

	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags Screen
	 **/

	@FindBy(id = "form1:layoutPanelDeviceType")
	public static WebElement devicetype_ScreenName;

	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/

	@FindBy(id = "form1:hyperlinkServicePacks")
	public static WebElement link_ServicePack;

	/**
	 * Page name : OPEASY Phone Template Page Element : Service packs Screen
	 **/

	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement serviepack_ScreenName;

	/**
	 * Page name : OPEASY Phone Template Page Element : Service packs & Group
	 * Screen
	 **/

	@FindBy(id = "form1:tableQueryResults:_titleBar")
	public static WebElement serviepackgroup_ScreenName;

	/**
	 * Page name : OPEASY Phone Template Page Element : SDMI Proxy
	 **/

	@FindBy(linkText = "SMDI Proxy")
	public static WebElement link_Sdmiproxy;

	/**
	 * Page name : OPEASY Phone Template Page Element : SDMI Proxy Screen name
	 **/

	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement sdmiproxy_ScreenName;

	/**
	 * Page name : OPEASY Phone Template Page Element : Solution Reseller
	 * Defined Fields
	 **/

	@FindBy(id = "form1:hyperlinkEnterpriseSolutionResellerDefinedFields")
	public static WebElement link_SRdefinedfield;

	/**
	 * Page name : OPEASY Phone Template Page Element : Enterprise setting
	 * Screen name
	 **/

	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement enterprisesetting_ScreenName;

	/**
	 * Page name : OPEASY Phone Template Page Element : Solution Reseller
	 * Defined Fields
	 **/

	@FindBy(id = "form1:hyperlinkEnterpriseSystemDefinedFields")
	public static WebElement link_SYSdefinedfield;

	/**
	 * Page name : OPEASY Phone Template Page Element : Enterprise Department
	 * Add Screen name
	 **/

	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement departmentadd_Screenname;

	/**
	 * Page name : OPEASY Phone Template Page Element : Enterprise System
	 * Defined field Screen name
	 **/
	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement sysdefinedfield_Screenname;

	/**
	 * Page name : OPEASY Template Definitions Page Element : 
	 * Device Type* dropdown
	 **/
	@FindBy(xpath = ".//select[@id[contains(.,'dropDownPhoneDeviceType')]]")
//	@FindBy(xpath = ".//*[@id='TemplateDefinition:layoutPanelControls:dropDownPhoneDeviceType']")
	public static WebElement dropdown_Phonedevicetype;

	/**
	 * Page name : OPEASY Template Definitions Page Element : Template
	 * Definitions
	 **/
	@FindBy(id = "TemplateDefinition:staticTextScreenName")
	public static WebElement text_EnterpriseSettingsScreenName;
	
	/**
	 * Page name : OPEASY Global Configuration File Settings Page Element :
	 * 
	 **/	
	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement label_Configfile_screenName;

	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:layoutPanelTopControls:staticTextEnterprise")
	public static WebElement label_EnterpriseName;	

	/**
	 * Page name : OpEasy Phone Template Definition Modify Page Element : Template Users tab
	 **/
	@FindBy(xpath = "//a[contains(.,'Template Users')]")
	public static WebElement tab_templateUsers;	

	/**
	 * Page name : OpEasy Phone Template Definition Modify Page Element : Template Users tab
	 **/
	//@FindBy(xpath = "//span[@class='ui-button-text ui-c'][contains(.,'Search')]")
	@FindBy(id = "form1:tabSetLegacy:buttonSearch")
	public static WebElement btn_Search;	
	
	/**
	 * Page name : OpEasy Phone Template Definition Modify Page Element : Template Users tab
	 **/
	//@FindBy(xpath = "(//a[contains(@tabindex,'-1')])[4]")
	@FindBy(xpath = "//a[contains(.,'Hard Keys')]")
	public static WebElement tab_Hardkeys;	

	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(id = "form1:dropDownKeyDefinitions_label")	
	public static WebElement dropdown_TemplateKeys;
	
	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(xpath = "//a[contains(.,'Prog Keys')]")	
	public static WebElement btn_ProgKeys;
	
	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(xpath = "//span[contains(.,'Apply')]")
	public static WebElement button_Apply;
	
	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(xpath = "//a[contains(.,'Features')]")	
	public static WebElement tab_Features;
	

	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(xpath = "//label[@class='ui-outputlabel ui-widget _Opeasy_FieldLabelLeft'][contains(.,'Enterprise Directory')]")
	
	public static WebElement  type_Enterprise;
	
	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(id = "form1:tabSetLegacy:staticTextEnablePolycomEnterpriseDirectory")
	public static WebElement  Checkbox_Enterprise;
	
	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(xpath = "//*[@id='form1:tabSetLegacy:checkboxEnableEnterpriseDirectory']/div[2]/span")
	//*[@id="form1:tabSetLegacy:checkboxEnableEnterpriseDirectory"]/div[2]/span
	public static WebElement  Checkbox_Ent;

	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(id = "form1:tabSetLegacy:staticTextEnablePolycomGroupDirectory")
	public static WebElement  type_Group;

	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(id = "form1:tabSetLegacy:staticTextEnablePolycomPersonalDirectory")
	public static WebElement  type_Personal;


	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(id = "form1:tabSetLegacy:staticTextEnableEnterpriseDirectory")
	public static WebElement  Directory_Enterprise;
	
	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(id = "form1:tabSetLegacy:staticTextEnableGroupDirectory")
	public static WebElement  Directory_Group;
	
	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(id = "form1:tabSetLegacy:staticTextEnablePersonalDirectory")
	public static WebElement  Directory_Personal;
	
	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(xpath = "(//span[contains(@class,'ui-chkbox-icon ui-icon ui-icon-blank ui-c')])[5]")
	public static WebElement  type_checkbox;
	
	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(xpath = "//span[@class='_Opeasy_ScreenName'][contains(.,'Template Modify: Rebuild Configuration Files')]")
	public static WebElement  screenname;
	
	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(xpath = "//span[@class='ui-button-text ui-c'][contains(.,'Save and Rebuild')]")
	public static WebElement  btn_SaveandRebuild;

	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(xpath = "//span[@class='ui-button-text ui-c'][contains(.,'Cancel')]")
	public static WebElement  btn_cancel;
	
	/**
	 * Page name : OPEASY Template Definitions Page Element : Device Type
	 * dropdown
	 **/
	@FindBy(id = "form1:dropDownPhoneDeviceType_label")
	public static WebElement dropdown_Devicetype;
	
	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/
	@FindBy(id = "form1:dropDownNewTemplateLevel_label")
	public static WebElement dropdown_NewTemplateLevel;
		
	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/
	@FindBy(xpath = "//input[@id='form1:newTemplate']")
	public static WebElement textbox_TemplateName;
	
	
	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/
	@FindBy(xpath = "//span[contains(.,'Add Template')]")
	public static WebElement btn_AddTemplate;
	
	
	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/
	@FindBy(xpath = "//label[@id='form1:tabSetMain:TemplatesDefinitionsEditPolyEdgeBGeneralSettingsTab:dropDownEMSAddressName_label']")
	public static WebElement dropdown_URISoftkey;
	
	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/
	@FindBy(xpath = "//a[contains(.,'Left Line Key Functions')]")
	public static WebElement btn_LeftLineKey;
	
	
	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/
	@FindBy(xpath = "//a[contains(.,'Lines')]")
	public static WebElement link_Lines;
	
	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/
	@FindBy(xpath = "//a[contains(.,'Paging Group')]")
	public static WebElement link_PagingGroup;
	
	
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
	 * Page name : OPEASY Template Add 
	 * Element 	 : DropDown for Group
	 **/
	
	@FindBy(xpath = "//*[@id[contains(., '1:dropDownTELProfile_label')]]")
	public static WebElement dropdown_telProfile_port2;	
	
	/**
	 * Page name : OPEASY Template Add 
	 * Element 	 : DropDown for Group
	 **/
	
	@FindBy(xpath = "//*[@id[contains(., '2:dropDownTELProfile_label')]]")
	public static WebElement dropdown_telProfile_port3;	
	
	/**
	 * Page name : OPEASY Template Add 
	 * Element 	 : DropDown for Group
	 **/
	
	@FindBy(xpath = "//*[@id[contains(., '3:dropDownTELProfile_label')]]")
	public static WebElement dropdown_telProfile_port4;	
	
	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/
	@FindBy(xpath = "//label[@id='form1:tabSetMain:TemplatesDefinitionsEditPolyEdgeBLinesTab:lineTablePolycomD230:0:dropDownLineUser_label']")
	public static WebElement dropdown_LinePosition;
	
	

	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/
	@FindBy(xpath = "//input[@id='form1:tabSetMain:TemplatesDefinitionsEditPolyEdgeBPagingGroupTab:pagingGroupTable:0:textFieldMulticastAddress']")
	public static WebElement textbox_PagingGroup;
	
	/*
	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/
	@FindBy(xpath = "//a[contains(.,'Right Line Key Functions')]")
	public static WebElement link_RightKeyFunctiontab;
	
	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/
	@FindBy(xpath = "//label[@id='form1:tabSetMain:TemplatesDefinitionsEditCiscoGeneralTab:dropDownEMSAddressName_label']")
	public static WebElement dropdown_GeneralTabURI;
	
	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/
	@FindBy(xpath = "//label[@id='form1:tabSetMain:TemplatesDefinitionsEditCiscoLinesTab:lineTableCisco:0:dropDownLineUserCisco_label']")
	public static WebElement dropdown_LinePosition1;
	
	
	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/
	@FindBy(xpath = "//a[contains(.,'Programmable Keys')]")
	public static WebElement tab_ProgrammableKeys;
	
	
	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/
	@FindBy(xpath = "//label[@id='form1:tabSetMain:TemplatesDefinitionsEditCiscoProgrammableKeysTab:keyTable:0:dropDownProgrammableKeyLabel_label']")
	public static WebElement dropdown_programmableKey1;
	
	
	/**
	 * Page name : OPEASY Phone Template Page Element : DeviceType tags
	 **/
	@FindBy(xpath = "//label[contains(.,'Clearspan Directory')]")
	public static WebElement checkbox_CSDirectory;
	
}
