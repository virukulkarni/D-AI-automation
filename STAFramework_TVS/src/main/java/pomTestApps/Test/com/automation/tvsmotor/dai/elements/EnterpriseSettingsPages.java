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

public class EnterpriseSettingsPages {
	public WebDriver driver;

	public EnterpriseSettingsPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//**************************************Viru Start***************************************
	/**
	 * Page name : OPEASY Provisioning Page
	 * Element 	 : Enterprise Settings Link
	 **/
	
	@FindBy(xpath=".//*[@id='form1EnterpriseSettings:hyperlinkGroupSettings']")
	public static WebElement link_Enterprisesettings;
	
	/**
	 * Page name : OPEASY Enterprise Settings Page
	 * Element 	 : Departments link
	 **/
	
	@FindBy(xpath=".//*[@id='form1:layoutPanelEnterpriseDepartments:hyperlinkEnterpriseDepartments']")
	public static WebElement link_Departments;
	
	/**
	 * Page name : OPEASY Enterprise Settings Page
	 * Element 	 : Departments link
	 **/
	
	@FindBy(xpath="(//a[contains(.,'Voice VPN')])[2]")
	public static WebElement link_VoiceVPN;
	
	//form1:hyperlinkEnterpriseVoiceVPNSettings
	/**
	 * Page name : OPEASY Enterprise Settings Page
	 * Element 	 : Departments link
	 **/
	
	@FindBy(id="form1:hyperlinkEnterpriseVoiceVPNSettings")
	public static WebElement linkVoiceVPN;
	
	/**
	 * Page name : OPEASY Enterprise Settings Page
	 * Element 	 : Departments link
	 **/
	
	@FindBy(xpath="(//a[contains(.,'Voice VPN')])")
	public static WebElement naviatelink_VoiceVPN;
	
	/**
	 * Page name : OPEASY Enterprise Settings Page
	 * Element 	 : Departments link
	 **/
	
	@FindBy(xpath="//span[contains(.,'Enterprise Voice VPN Modify')]")
	public static WebElement text_VoiceVPNModify;
	
	/**
	 * Page name : OPEASY Enterprise Departments Page
	 * Element 	 : Enterprise Departments 
	 **/
	
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Enterprise Departments')]")
	public static WebElement text_EntDepartments_ScreenName;
	
	/**
	 * Page name : OPEASY Enterprise Departments Add Page
	 * Element 	 : Enterprise Departments Add
	 **/
	
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Enterprise Department Add')]")
	public static WebElement text_EntDepartAdd_ScreenName;
	
	/**
	 * Page name : OPEASY Enterprise Department AddPage
	 * Element 	 : Department Name text box link
	 **/
	
	@FindBy(xpath=".//*[@id='form1:layoutPanelTopControls:textFieldDepartmentName_field']")
	public static WebElement text_DeptName;
	
	/**
	 * Page name : OPEASY Enterprise Settings Page
	 * Element 	 : Device Types link
	 **/
	
	@FindBy(xpath=".//*[@id='form1:layoutPanelEntDeviceTypes:hyperlinkEntDeviceTypes']")
	public static WebElement link_DeviceTypes;
	
	/**
	 * Page name : OPEASY Enterprise Device Types Page
	 * Element 	 : Enterprise Device Types 
	 **/
	
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Enterprise Device Types')]")
	public static WebElement text_DeviceTypes_ScreenName;
	
	/**
	 * Page name : OPEASY Enterprise Device Types Page
	 * Element 	 : Enterprise Drop Down
	 **/
	
	@FindBy(xpath=".//*[@id='form1:dropDownEnterprise_list']")
	public static WebElement dropdown_Ent;
	
	/**
	 * Page name : OPEASY Enterprise Device Types Page
	 * Element 	 : Available Device Types 
	 **/
	
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Enterprise Device Types')]")
	public static WebElement text_AvlDeviceTypes_Box;
	
	/**
	 * Page name : OPEASY Enterprise Device Types Page
	 * Element 	 : ADD Button
	 **/
	
	@FindBy(xpath=".//*[@id='form1:layoutPanelEnterpriseDeviceTypes:buttonAdd']")
	public static WebElement btn_ADD;

	/**
	 * Page name : OPEASY Enterprise Device Types Page
	 * Element 	 : Device Types
	 **/
	
	@FindBy(xpath=".//*[@id='form1:layoutPanelEnterpriseDeviceTypes:listboxAvailableDeviceTypes']/option[1]")
	public static WebElement text_AvlDevicetype;
	

	/**
	 * Page name : OPEASY Enterprise Device Types Page
	 * Element 	 : Enterprise Device Types Box
	 **/
	
	@FindBy(xpath=".//*[@id='form1:layoutPanelEnterpriseDeviceTypes:staticTextEnterpriseDeviceTypesHeader']")
	public static WebElement text_EntDeviceTypes_Box;
	
	

	/**
	 * Page name : OPEASY Enterprise Device Types Page
	 * Element 	 : Enterprise Device Types 
	 **/
	
	@FindBy(xpath=".//*[@id='form1:layoutPanelEnterpriseDeviceTypes:staticTextEnterpriseDeviceTypesHeader']")
	public static WebElement text_EntDeviceTypes;
	
	

	/**
	 * Page name : OPEASY Enterprise Settings Page
	 * Element 	 : Enterprise Settings
	 **/
	
	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Enterprise Settings')]")
	public static WebElement text_EntSettings;
	//**********************************************Viru End***********************************
}
