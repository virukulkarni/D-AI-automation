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

public class EGWPages {
	public WebDriver driver;

	public EGWPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:hyperlinkConfigure")
	public static WebElement link_Configure;
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:hyperlinkAssignment")
	public static WebElement link_Assignment;
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:egwAssociationTable:_tableActionsTop:_paginateButton:_paginateButton_image")
	public static WebElement btn_SinglePageView;
	
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = "//*[@id='form1:addButton']/span")
	public static WebElement btn_AddEGW;
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = ".//input[@id[contains(., ':cancelButton')]]")
	public static WebElement btn_Cancel;
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = "//input[@id='form1:gatewayName']")
	public static WebElement txt_gatewayName_field;
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = "//input[@id='form1:pbxName']")
	public static WebElement txt_pbxName_field;
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = "//input[@id='form1:ipAddress']")
	public static WebElement txt_ipAddress_field;
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = "//input[@id='form1:soapUsername']")
	public static WebElement txt_soapUsername_field;
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = "//input[@id='form1:soapPassword']")
	public static WebElement txt_soapPassword_field;
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = "//input[@id='form1:confirmSoapPassword']")
	public static WebElement txt_confirmSoapPassword_field;
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(xpath = "//button[@id='form1:save']/span")
	public static WebElement btn_OK;
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:LeftPane:navigationTree:summary:summary_link")
	public static WebElement link_Summary;
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:layoutPanelControlsSynchronize:hyperlinkSynchronize")
	public static WebElement link_Synchronize;
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:egwAssociationTable:0:egwDropDownList_label")
	public static WebElement dropdown_assignEGW;
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:gatewayDropDown_label")
	public static WebElement dropdown_GatewayForSync;
	
	/**
	 * Page name : OpEasy Provisioning Page Element
	 **/
	@FindBy(id = "form1:buttonResynchronize")
	public static WebElement btn_Resynchronize;
	
		
	
}

