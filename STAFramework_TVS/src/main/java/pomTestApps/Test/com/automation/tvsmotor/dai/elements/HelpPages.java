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

public class HelpPages {
	public WebDriver driver;

	public HelpPages(WebDriver driver) {
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
	 * Page name : OPEASY Provisioning Page
	 * Element 	 : Provisioning link
	 **/

	@FindBy(xpath=".//*[@id='form1:LeftPane:navigationTree:app10:app10_link']")
	//@FindBy(xpath=".//*[@id='form1:staticTextScreenName']")
	public static WebElement text_Provisioning;
	
	/**
	 * Page name : OPEASY Provisioning Page
	 * Element 	 : Help link
	 **/

	@FindBy(id="form1:HeaderPane:groupPanel1:hyperlinkHelp")
	public static WebElement link_Help;
	
	/**
	 * Page name : OPEASY Help Menu Box
	 * Element 	 : Basic Provisioning link
	 **/

	//@FindBy(xpath="//a[contains(text(),'Basic Provisioning User Guide')]")
	@FindBy(xpath="//a[contains(.,'Basic Provisioning User Guide')]")
	public static WebElement link_Basic;
	
	/**
	 * Page name : OPEASY Help Menu Box
	 * Element 	 : Advanced Provisioning link
	 **/

	@FindBy(xpath="//a[contains(.,'Advanced Provisioning User Guide')]")
	public static WebElement link_Advanced;
	
	/**
	 * Page name : OPEASY Help Menu Box
	 * Element 	 : Import Worksheet Definitions link
	 **/

	@FindBy(xpath="//a[contains(.,'Import Worksheet Definitions')]")
	public static WebElement link_Import;
	
	/**
	 * Page name : OPEASY Help Menu Box
	 * Element 	 : Advanced Administrator Guide link
	 **/

	@FindBy(xpath="//a[contains(.,'Advanced Administrator Guide')]")
	public static WebElement link_Advancedadmin;
	
	/**
	 * Page name : OPEASY Help Menu Box
	 * Element 	 : Device Management Configuration Guide link
	 **/

	@FindBy(xpath="//a[contains(.,'Device Management Configuration Guide')]")
	public static WebElement link_DeviceManagement;
	
	/**
	 * Page name : OPEASY Help Menu Box
	 * Element 	 : Reporting Guide link
	 **/

	@FindBy(xpath="//a[contains(.,'Reporting Guide')]")
	public static WebElement link_ReportingGuide;
	
	//**********************************************Viru End***********************************
}
