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

public class VirtualUsersPages {
	public WebDriver driver;

	public VirtualUsersPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Group Paging elements begin here
	 */
	
	/**
	 * Page name : OPEASY Provisioning Page
	 **/
	@FindBy(id = "form1:textInputGroupTargetCapacity")
	public static WebElement text_InputGroupTargetCapacity;
	
	/**
	 * Page name : OPEASY Provisioning Page
	 **/
	@FindBy(xpath = "//button[contains(., 'Targets')]")
	public static WebElement tab_Targets;	
	
	/**
	 * Page name : OPEASY Provisioning Page
	 **/
	@FindBy(id = "form1:textFieldName")
	public static WebElement textFieldName;	
	
	/**
	 * Page name : OPEASY Provisioning Page
	 **/
	@FindBy(id = "form1:textFieldGroupPagingIdGroupPagingName")
	public static WebElement text_FieldGroupPagingIdGroupPagingName;	
	
	/**
	 * Page name : OPEASY Provisioning Page
	 **/
	@FindBy(id = "form1:textFieldCLIDLastName")
	public static WebElement text_FieldCLIDLastName;
	
	/**
	 * Page name : OPEASY Provisioning Page
	 **/
	@FindBy(id = "form1:textFieldCLIDFirstName")
	public static WebElement text_FieldCLIDFirstName;
	
	/**
	 * Page name : OPEASY Provisioning Page
	 **/
	@FindBy(id = "form1:textFieldCLIDPhoneNumber")
	public static WebElement text_FieldCLIDPhoneNumber;
	
	/**
	 * Page name : OPEASY Provisioning Page
	 **/
	@FindBy(id = "form1:textFieldExtension")
	public static WebElement text_FieldExtension;

	/**
	 * Page name : OPEASY Provisioning Page
	 **/
	@FindBy(id = "form1:buttonUserAddAll")
	public static WebElement button_UserAddAll;

	/**
	 * Page name : OPEASY Provisioning Page
	 **/
	@FindBy(id = "form1:textFieldAlias1UserName")
	public static WebElement text_FieldAlias1UserName;

	/**
	 * Page name : OPEASY Provisioning Page
	 **/
	@FindBy(id = "form1:buttonUserRemoveAll")
	public static WebElement button_UserRemoveAll;

	
	
	
	/*
	 * Group Paging elements end here 
	 */
}
