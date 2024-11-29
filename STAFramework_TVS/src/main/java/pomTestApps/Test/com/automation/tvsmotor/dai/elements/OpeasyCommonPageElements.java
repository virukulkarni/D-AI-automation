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

public class OpeasyCommonPageElements {
	public WebDriver driver;

	public OpeasyCommonPageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//**************************************Viru Start***************************************
	
	/**
	 * Page name : OPEASY Users Page
	 * Element 	 : Search Button  
	 **/
	@FindBy(xpath = "//button[contains(.,'Search')]")
//	@FindBy(xpath ="//button[@id='form1:buttonSearch']//span")
	public static WebElement btn_Search;
	
	
	/**
	 * Page name : OPEASY Users Page
	 * Element 	 : Search Button  
	 **/
	@FindBy(xpath = "//*[@id=\"form1:buttonSearch\"]/span")	
	public static WebElement btn_VirtualUsersSearch;
	
	
	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(id = "form1:dropDownEnterprise_label")	
	public static WebElement dropdown_Enterprise;
	
	
	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(id = "form1:dropDownNewTemplateEnterprise_label")	
	public static WebElement dropdown_NewEnterprise;

	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(id = "form1:UserSearchFragment:tableSearchCriteria:0:fieldName_label")	
	public static WebElement phone_Management_Search;
	
	
	
	/**
	 * Page name : OPEASY Enterprise Licensing Page
	 * Element 	 : drop down Enterprise
	 **/
	@FindBy(id = "form1:dropDownEnterprise")	
	public static WebElement dropdown_EnterpriseOption;
	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : DropDown for Group
	 **/
	
	@FindBy(id = "form1:dropDownDepartment_label")
	public static WebElement dropdown_Department;	
	
	/**
	 * Page name : OPEASY Remedy AIN List Page
	 * Element 	 : drop down Group
	 **/
	@FindBy(id = "form1:dropDownGroup_label")	
	public static WebElement dropdown_Group;
	
	
	/**
	 * Page name : OPEASY Remedy AIN List Page
	 * Element 	 : drop down Group
	 **/
	@FindBy(id = "form1:dropDownPhoneDeviceType_label")	
	public static WebElement dropdown_DeviceType;
	
	
	/**
	 * Page name : OPEASY Remedy AIN List Page
	 * Element 	 : drop down Group
	 **/
	@FindBy(id = "form1:dropDownNewTemplateGroup_label")	
	public static WebElement dropdown_templateGroup;
	
	/**
	 * Page name : OPEASY Remedy AIN List Page
	 * Element 	 : drop down Template Level
	 **/
	@FindBy(id = "form1:dropDownSearchCriteria_label")
	public static WebElement dropdown_TemplateLevel;
	
	
	/**
	 * Page name : OPEASY Remedy AIN List Page
	 * Element 	 : drop down Group
	 **/
	@FindBy(id = "form1:dropDownNewTemplateLevel_label")	
	public static WebElement dropdown_NewTemplateLevel;
	
	/**
	 * Page name : OPEASY Template Add 
	 * Element 	 : DropDown for Group
	 **/
	
	@FindBy(xpath = "//*[@id[contains(., '0:dropDownTELProfile_label')]]")
	public static WebElement dropdown_telProfile_port;	
	
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
	 * Page name : OPEASY Users Page
	 * Element 	 : Search Button  
	 **/
	@FindBy(xpath = "//*[@id='form1:buttonDelete']/span")	
	public static WebElement btn_Delete;

	/**
	 * Page name : OPEASY Users Page
	 * Element 	 : Search Button  
	 **/
	@FindBy(xpath = "//*[@id='form1:buttonDeleteResults']/span")	
	public static WebElement btn_DeleteResults;
	
	/**
	 * Page name : OPEASY Users Page
	 * Element 	 : Search Button  
	 **/
	@FindBy(xpath = "//a[@id[contains(., '2:hyperlinkDelete')]]")	
	public static WebElement link_Delete2;
	
	
    /**
	 * Page name : OPEASY Users Page
	 * Element 	 : Search Button  
	 **/
	@FindBy(xpath = "//a[@id[contains(., '3:hyperlinkDelete')]]")	
	public static WebElement link_Delete3;
	
	
	/**
	 * Page name : OPEASY Users Page
	 * Element 	 : Search Button  
	 **/
	@FindBy(xpath = "//a[@id[contains(., '4:hyperlinkDelete')]]")	
	public static WebElement link_Delete4;
	
	
	/**
	 * Page name : OPEASY Users Page
	 * Element 	 : Search Button  
	 **/
	@FindBy(xpath = "//a[@id[contains(., '5:hyperlinkDelete')]]")	
	public static WebElement link_Delete5;
	
	/**
	 * Page name : OPEASY Users Page
	 * Element 	 : Search Button  
	 **/
	@FindBy(xpath = "//a[@id[contains(., '1:hyperlinkDelete')]]")	
	public static WebElement link_Delete1;

	
	/**
	 * Page name : OPEASY Login Management Page
	 * Element 	 : Add button
	 **/

	@FindBy(xpath = "//*[@id='form1:buttonAdd']/span")
	public static WebElement btn_Add;
	
	/**
	 * Page name : OPEASY Pages
	 * Element 	 : Add Template button
	 **/

	@FindBy(xpath = "//span[contains(., 'Add Template')]")
	public static WebElement btn_AddTemplate;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : OK button
	 **/
	@FindBy(xpath = "//*[@id='form1:buttonOK']")
	public static WebElement btn_OK;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : OK button
	 **/
	@FindBy(id = "form1:OKButton")
	public static WebElement btn_OKbutton;
	
	/**
	 * Page name : OPEASY Pages
	 **/
	@FindBy(id = "form1:buttonApply")
	public static WebElement btn_Apply;

	/**
	 * Page name : OPEASY Login Management Page
	 * Element 	 : Add button
	 **/

	@FindBy(xpath = "//span[contains(.,'Saved')]")
	public static WebElement saved;
	
	/**
	 * Page name : OpEasy Administrator Add
	 * Element 	 : OK button
	 **/
	@FindBy(xpath = "//*[@id='form1:buttonOK']")
	public static WebElement buttonOK;
	/**
	 * Page name : OPEASY pages
	 **/
	@FindBy(id = "form1:buttonCancel")
	public static WebElement btn_Cancel;

	/**
	 * Page name : OPEASY pages
	 **/
	@FindBy(id = "form1:cancelButton")
	public static WebElement btn_CancelButton;

	/**
	 * Page name : OPEASY Pages
	 **/
	@FindBy(xpath = "(//a[contains(.,'Phone Management')])[2]")
	public static WebElement btn_PhoneManagement;

	/**
	 * Page name : OPEASY Pages
	 **/
	@FindBy(id = "form1:buttonUserAddAll")
	public static WebElement button_UserAddAll;
	
	/**
	 * Page name : OPEASY Pages
	 **/
	@FindBy(id = "form1:dropDownScheduledTask_label")
	public static WebElement dropdown_task;
	
	
	/**
	 * Page name : OPEASY Pages
	 **/
	@FindBy(id = "form1:UserSearchFragment:tableSearchCriteria:0:fieldName_label")
	public static WebElement searchcriteria;
	
	/**
	 * Page name : OPEASY Pages
	 **/
	@FindBy(id = "form1:UserSearchFragment:tableSearchCriteria:0:fieldCondition_label")
	public static WebElement searchCondition;
	
	
	/**
	 * Page name : OPEASY Pages
	 **/
	@FindBy(id = "form1:UserSearchFragment:tableSearchCriteria:0:fieldValue")
	public static WebElement searchValue;
	
	
	/**
	 * Page name : OPEASY Pages
	 **/
	@FindBy(xpath = "//input[@id[contains(., 'fieldValue')]]")
	public static WebElement text_searchValue;
	
	
			/**
			 * Page name : OPEASY Pages
			 **/
			@FindBy(xpath = "(//span[contains(text(),'Delete')])[1]")
			public static WebElement button_Delete;
			
			
			
			/**
			 * Page name : OPEASY Remedy AIN List Page
			 * Element 	 : drop down Search Type
			 **/
			@FindBy(id = "form1:dropDownSearchType_label")	
			public static WebElement dropdown_SearchType;
			

			/**
			 * Page name : OPEASY Remedy AIN List Page
			 * Element 	 : drop down  Field Name Search
			 **/
			@FindBy(id = "form1:rowGroupSearchCriteria:0:fieldNameDD_label")	
			public static WebElement dropdown_SearchQuery;
			
		
			
	
	//**********************************************Viru End***********************************
}
