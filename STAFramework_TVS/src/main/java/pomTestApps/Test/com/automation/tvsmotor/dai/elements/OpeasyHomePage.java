package pomTestApps.Test.com.automation.tvsmotor.dai.elements;
/**************************************************
#Project Name: MiTEL_MXONE - Selenium Framework
#Function Name: HomePage()
#Description:1. Initialization of Driver for the page object HomePage
			 2. All the Xpath for all the web Elements of home page are placed 
#Input Parameters:
#Owner: Ashis Kumar Pradhan
#Author: Ashis Kumar Pradhan
#Date of creation: 03-July-16
#Name of person modifying: (Tester Name): 
#Date of modification: 
â€˜**************************************************/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpeasyHomePage {
	public WebDriver driver;

	public OpeasyHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//**************************************Viru Start***************************************
	/**
	 * Page name : OPEASY Home Page
	 * Element 	 : User ID text_box
	 **/
	@FindBy(id = "txtEmailID" )
	public WebElement tbx_UserName;
	
	/**
	 * Page name : OPEASY Home Page
	 * Element 	 : Password_text_box
	 **/
	@FindBy(id = "form1:password" )
	public WebElement tbx_Password;
	
	/**
	 * Page name : OPEASY Provisioning Page
	 * Element 	 : Change password link
	 **/
	
	@FindBy(id = "form1:HeaderPane:groupPanel1:changePasswordHyperlink")				  
	public WebElement link_ChangePassword;
	
	/**
	 * Page name : OPEASY Provisioning Page
	 * Element 	 : btn_Cancel
	 **/
	
	@FindBy(id = "form1:buttonCancel")				  
	public WebElement btn_Cancel;
	

	/**
	 * Page name : OPEASY Provisioning Page
	 * Element 	 : Provisioning link
	 **/

	@FindBy(id = "form1:hyperlinkProvisioning")
	public static WebElement link_Provisioning;
	
	/**
	 * Page name : OPEASY Provisioning Page
	 * Element 	 : Provisioning link
	 **/

	@FindBy(id = "form1:HeaderPane:hyperlinkProvisioning")
	public static WebElement link_HeaderProvisioning;
	/**
	 * Page name : OPEASY Provisioning Page
	 * Element 	 : EnterpriseSettings link
	 **/
	@FindBy(id = "form1:hyperlinkEnterpriseSettings_action")
	public static WebElement link_EnterpriseSettings;
		
	/**
	 * Page name : OPEASY Home Page
	 * Element 	 : Login button
	 **/
	@FindBy(id = "form1:buttonLogin")	
	public WebElement btn_Login;

	/**
	 * Page name : OPEASY Home Page
	 * Element 	 : Error Message Box on home page
	 **/

	@FindBy(xpath = ".//*[@id='form1:layoutPanelLogin:loginMessage']")
	public static WebElement label_LoginErrorMessage;	
	
	/**
	 * Page name : OpEasy Home Page
	 * Element 	 : Logout message
	 **/
	
	@FindBy(xpath = "//*[contains(text(),'Logged Out')]")
	public WebElement label_Logout_Message;
	
	/**
	 * Page name : OPEASY Home Page
	 * Element 	 : Continue button after login
	 **/
	@FindBy(id="form1:buttonContinue")	
	public WebElement btn_Login_Continue;	
	
	/**
	 * Page name : OPEASY Home Page
	 * Element 	 : Login Management link
	 **/
	@FindBy(xpath="(//a[contains(text(),'Login Management')])[1]")
	public static WebElement link_LoginManagement;

	/**
	 * Page name : SNM Home Page
	 * Element 	 : text Site
	 **/
	@FindBy(xpath="//*[contains(text(),'Site')]")
	public WebElement text_Site;
	
	/**
	 * Page name : SNM Home Page
	 * Element 	 : text Logged in as 
	 **/
	@FindBy(xpath="//*[contains(text(),'Logged in as:')]")
	public WebElement text_LoggedInAs;

	/**
	 * Page name : SNM Home Page
	 * Element 	 : User Guide link
	 **/
	@FindBy(xpath="//a[contains(text(),'User Guide')]")
	public WebElement link_UserGuide;
	
	/**
	 * Page name : SNM Home Page
	 * Element 	 : Site Map link
	 **/
	@FindBy(xpath="//a[contains(text(),'Site Map')]")
	public WebElement link_SiteMap;
	
	/**
	 * Page name : SNM Home Page
	 * Element 	 : Logout link
	 **/
	@FindBy(xpath="//*[contains(text(),'Logout')]")
	public WebElement link_Logout;
	
	/**
	 * Page name : Main menu Page
	 * Element 	 : Logout link
	 **/
	@FindBy(xpath="//a[contains(text(), 'Logout')]")
	public WebElement link_opeasy_Logout;

	/**
	 * Page name : OPEASY Home Page
	 * Element 	 : Admin Tools Link
	 **/
	@FindBy(id = "form1:hyperlinkSystemAdministration")	
	public static WebElement link_Admintools;
	
	/**
	 * Page name : Main menu Page
	 * Element 	 : Configure EGW link
	 **/
	@FindBy(id="form1:hyperlinkEGWManager")
	public static WebElement link_EGWManager;
	
	/**
	 * Page name : OPEASY Home Page
	 * Element 	 : OpEasy 
	 **/
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'OpEasy')]")		
	public static WebElement text_Opeasy_screenName;
	
	/**
	 * Page name : OPEASY Home Page
	 * Element 	 : Homepage screen name 
	 **/
	@FindBy(id="form1:staticTextScreenName")		
	public static WebElement text_screenName;
	
	/**
	 * Page name : OPEASY Home Page
	 * Element 	 : OpEasy About 
	 **/
	@FindBy(xpath = ".//a[contains(., 'About')]")		
	public static WebElement link_About;
	
	/**
	 * Page name : OPEASY Home Page
	 * Element 	 : Provisioning Screen 
	 **/
	@FindBy(xpath = "//span[.,'Provisioning']")		
	public static WebElement Provisioning_Screen;
		
	/**
	 * Page name : OPEASY Home Page
	 * Element 	 : Login Management link
	 **/
	@FindBy(xpath="(//a[contains(text(),'Reporting')])[1]")
	public WebElement link_Reporting;

	/**
	 * Page name : OPEASY Home Page
	 * Element 	 : Super User main menu page
	 **/
	@FindBy(id="form1:HeaderPane:usertext")
	public static WebElement Screen_superuser;
	
	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:layoutPanelTopControls:staticTextEnterprise")
	public static WebElement label_EnterpriseName;	
	
	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(xpath = "//span[text()='Enterprise:']/../../span[2]/span/select")
	public static WebElement dropdown_EnterpriseName;
	
	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:hyperlinkMonitoring")
	public static WebElement link_Monitoring;
	
	/**
	 * Page name : OpEasy User Settings Page Element : Enterprise dropdown
	 **/
	@FindBy(id = "form1:hyperlinkSNMPManager")
	public static WebElement link_SNMPManager;

	
	
	
	
	
	//**********************************************Ashis End***********************************
}
