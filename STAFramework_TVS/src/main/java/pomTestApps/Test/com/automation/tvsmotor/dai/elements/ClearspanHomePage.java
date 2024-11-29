package pomTestApps.Test.com.automation.tvsmotor.dai.elements;
/**************************************************
#Project Name: MiTEL_CLEARSPAN - Selenium Framework
#Function Name: HomePage()
#Description:1. Initialization of Driver for the page object HomePage
			 2. All the Xpath for all the web Elements of home page are placed 
#Input Parameters:
#Owner: Virupakshayya Kulkarni
#Author: Virupakshayya Kulkarni
#Date of creation: 23-Jan-18
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**************************************************
#Project Name: MiTEL_CLEARSPAN - Selenium Framework
#Function Name: HomePage()
#Description:1. Initialization of Driver for the page object HomePage
			 2. All the Xpath for all the web Elements of home page are placed 
#Input Parameters:
#Owner: Virupakshayya Kulkarni
#Author: Virupakshayya Kulkarni
#Date of creation: 23-Jan-18
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClearspanHomePage {
	public WebDriver driver;

	public ClearspanHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//**************************************Viru Start***************************************
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : User ID text_box
	 **/
	@FindBy(name="EnteredUserID" )
	public WebElement tbx_UserName;

	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Password_text_box
	 **/
	@FindBy(name = "Password")
	public WebElement tbx_Password;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Password_text_box
	 **/
	@FindBy(xpath = "//a[contains(text(),'Anywhere')]")
	public static WebElement link_BroadworksAnywhere;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Password_text_box
	 **/
	@FindBy(xpath = "//td[contains(text(),'Anywhere')]")
	public static WebElement text_BroadworksAnywhere;
	
	/**
	 * Page name : Clearspan Group Page Element : BNG_1 link
	 **/
	@FindBy(xpath = "(//input[@value='OK'])[1]")
	public static WebElement btn_OK1;
	
	
	/**
	 * Page name : Clearspan Anywhere Page Element : ADD Button
	 **/
	@FindBy(xpath = "(.//input[@value='Add'])[1]")
	public static WebElement link_ADD1;
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Password_text_box
	 **/
	@FindBy(xpath = "html/body/table[2]/tbody/tr[2]/td[4]/form/table/tbody/tr[9]/td/table[4]/tbody/tr/td[3]/a[1]")
	public static WebElement link_Next1;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Prompt for passcode check box
	 **/
	@FindBy(xpath = "//td[contains(text(),'Profile')]")
	public static WebElement text_Profile;
	
	/**
	 * Page name : Clearspan Group Page Element : BNG_1 link
	 **/
	@FindBy(xpath = "//a[contains(.,'BNG_4')]")
	public static WebElement link_BNG_4;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Password_text_box
	 **/
	@FindBy(xpath = "//a[contains(text(),'Schedules')]")
	public static WebElement link_Schedules;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Password_text_box
	 **/
	@FindBy(xpath = "//td[contains(text(),'Schedules')]")
	public static WebElement text_Schedules;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Password_text_box
	 **/
	@FindBy(xpath = "//input[@name='scheduleName']")
	public static WebElement type_Schedule;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Prompt for passcode check box
	 **/
	@FindBy(xpath = "//input[@name='promptForPasscode']")
	public static WebElement uncheck_checkbox;
	
	/**
	 * Page name : Clearspan Home Page Element : India link
	 **/
	@FindBy(xpath = "//a[contains(.,'India')]")
	public static WebElement link_India;
	
	/**
	 * Page name : Clearspan Group Page Element : BNG_1 link
	 **/
	@FindBy(xpath = "//a[contains(.,'BNG_1')]")
	public static WebElement link_BNG_1;
	
	/**
	 * Page name : Clearspan Users Page Element : next link
	 **/
	@FindBy(xpath = "//a[contains(.,'clearspan1')]")
	public static WebElement link_Edit;
	/**
	 * Page name : Clearspan Profile Page Element : Profile link
	 **/
	@FindBy(xpath = "html/body/table[2]/tbody/tr[2]/td[4]/table/tbody/tr[4]/td/table/tbody/tr/td[1]/table//a[contains(.,'Profile')]")
	public static WebElement link_Profile;
	/**
	 * Page name : Clearspan Profile Page Element : Profile link
	 **/
	@FindBy(xpath = "html/body/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td[1]//a[contains(.,'BNG_1')]")
	public static WebElement link_GroupPath;
	/**
	 * Page name : Clearspan Home Page
	 *  Element : Identity/Device Profiles link
	 **/
	@FindBy(xpath = "//a[contains(.,'Identity/Device Profiles')]")
	public static WebElement link_IdentityProfile;	
	
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Login href link
	 **/
	@FindBy(linkText = "Login")
	public WebElement link_Login;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Logout href link
	 **/
	@FindBy(linkText = "[Logout]")
	public WebElement link_Logout;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Users Link
	 **/
	@FindBy(xpath = "//a[contains(text(),'Groups')]")
	public static WebElement link_Groups;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Users Link
	 **/
	@FindBy(className = "logouttext")
	public static WebElement label_logoutText;
	
	/**
	 * Page name : Clearspan Home Page
	 * Element 	 : Groups link
	 **/
	@FindBy(xpath = "//a[contains(text(),'Users')]")
	public static WebElement link_Users;
	
	/**
	 * Page name : Clearspan Home Page
	 * Element 	 : Drop down Extension
	 **/
	@FindBy(xpath = ".//*[@id='findKey0']")
	public static WebElement dropdown_Extension;
	
	/**
	 * Page name : Clearspan Home Page
	 * Element 	 : Text box
	 **/
	@FindBy(id = "findValue0")
	public static WebElement text_Extension;
	
	/**
	 * Page name : Clearspan Home Page
	 * Element 	 : Search Button
	 **/
	@FindBy(id = "search0")
	public static WebElement btn_Search;
	
	/**
	 * Page name : Clearspan Home Page
	 * Element 	 : text User ID
	 **/
	@FindBy(xpath = ".//*[@id='mainForm']/table/tbody/tr[9]/td//table[2]//tbody//tr[1]//td[2]//a[contains(.,'User ID')]")
	public static WebElement text_User;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Enterprise Link
	 **/
	@FindBy(linkText = "Enterprises")
	public static WebElement enterprise_Link;
	
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Find Key
	 **/
	@FindBy(id = "findKey0")
	public static WebElement dropdown_Findkey;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Find Options
	 **/
	@FindBy(id = "findOp0")
	public static WebElement dropdown_FindOption;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Finding Text
	 **/
	@FindBy(xpath = "//input[@name='findValue0']")
	public static WebElement finding_Text;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Search Button
	 **/
	@FindBy(id = "search0")
	public static WebElement search_Button;
	
//	/**
//	 * Page name : ClearSpan Home Page
//	 * Element 	 : Search LastName
//	 **/
//	@FindBy(xpath = "//a[contains(text(),'Last Name')]")
//	public static WebElement lastname_Display;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Groups Link
	 **/
	@FindBy(linkText = "Groups")
	public static WebElement group_Link;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Enterprise ScreenName
	 **/
	@FindBy(xpath = "//td[text()='Enterprises']")
	public static WebElement enterprise_Screen;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Groups ScreenName
	 **/
	@FindBy(xpath = "//td[text()='Groups']")
	public static WebElement group_Screen;
	
	/**deviceProfiles_Link
	 * Page name : ClearSpan Home Page
	 * Element 	 : Resources Link
	 **/
	@FindBy(linkText = "Resources")
	public static WebElement resources_Link;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Device Profiles Link
	 **/
	@FindBy(linkText = "Identity/Device Profiles")
	public static WebElement deviceProfiles_Link;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Device Profile ScreenName
	 **/
	@FindBy(xpath = "//td[text()='Identity/Device Profiles']")
	public static WebElement deviceProfiles_Screen;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : services Link
	 **/
	@FindBy(linkText = "Services")
	public static WebElement services_Link;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Auto Attendant Link
	 **/
	@FindBy(linkText = "Auto Attendant")
	public static WebElement autoAttendant_Link;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Hunt Group Link
	 **/
	@FindBy(linkText = "Hunt Group")
	public static WebElement huntGroup_Link;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Flexible Seating Host Link
	 **/
	@FindBy(linkText = "Flexible Seating Host")
	public static WebElement flexibleSeatingHost_Link;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Auto Attendant Screen
	 **/
	@FindBy(xpath = "//td[text()='Auto Attendant']")
	public static WebElement autoAttendant_Screen;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Auto Attendant Screen
	 **/
	@FindBy(xpath = "//td[text()='Hunt Group']")
	public static WebElement huntGroup_Screen;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Auto Attendant Screen
	 **/
	@FindBy(xpath = "//td[text()='Flexible Seating Host']")
	public static WebElement flexibleSeatingHost_Screen;
	
	/**
	 * Page name : ClearSpan Home Page
	 * Element 	 : Auto Attendant Screen
	 **/
	@FindBy(linkText = "Call Pickup")
	public static WebElement link_CallPickup;

	/**
	 * Page name : ClearSpan Home Page Element : login with your existing userid
	 * and password link
	 * 
	 **/

	@FindBy(xpath = "html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td[1]")
	public static WebElement link_userid;

	/**
	 * Page name : ClearSpan Home Page Element : Search LastName
	 **/
	@FindBy(xpath = ".//*[@id='mainForm']/table/tbody/tr[9]/td/table[2]/tbody/tr[1]/td[4]/a")
	public static WebElement lastname_Screen;

	/**
	 * Page name : ClearSpan Home Page Element : Users Screen
	 **/
	@FindBy(xpath = "//td[text()='Users']")
	public static WebElement Users_Screen;

	/**
	 * Page name : Clearspan Home Page Element : enterprise link
	 **/
	@FindBy(xpath = "html/body/table[2]/tbody/tr[2]/td[4]/table/tbody/tr[4]/td/table/tbody/tr/td[1]/table/tbody/tr[6]/td/a")
	public static WebElement link_Enterprise;

	/**
	 * Page name : ClearSpan Home Page Element : enterprise Screen
	 **/
	@FindBy(xpath = ".//*[@id='mainForm']/table/tbody/tr[2]/td")
	public static WebElement enterprises_Screen;

	/**
	 * Page name : Clearspan Home Page Element : next link
	 **/
	@FindBy(xpath = ".//*[@id='mainForm']/table/tbody/tr[9]/td/table[4]/tbody/tr/td[3]/a[1]")
	public static WebElement link_Next;

	/**
	 * Page name : Clearspan Home Page Element : Groups link
	 **/
	@FindBy(xpath = ".//*[@id='Row12Col1']")
	public static WebElement link_Systemvalidation;

	/**
	 * Page name : ClearSpan Home Page Element : profile Screen
	 **/
	@FindBy(xpath = "html/body/table[2]/tbody/tr[2]/td[4]/table/tbody/tr[2]/td")
	public static WebElement profile_Screen;

	/**
	 * Page name : Clearspan Home Page Element : Profile link
	 **/
	@FindBy(xpath = " html/body/table[2]/tbody/tr[2]/td[4]/table/tbody/tr[4]/td/table/tbody/tr/td[1]/table/tbody/tr[6]/td")
	public static WebElement link_User;

	/**
	 * Page name : ClearSpan Home Page Element : User Screen
	 **/
	@FindBy(xpath = ".//*[@id='mainForm']/table/tbody/tr[2]/td")
	public static WebElement user_Screen;

	/**
	 * Page name : Clearspan Home Page Element : Group link
	 **/
	@FindBy(xpath = "html/body/table[2]/tbody/tr[2]/td[4]/table/tbody/tr[4]/td/table/tbody/tr/td[1]/table/tbody/tr[3]/td/a")
	public static WebElement link_Group;

	/**
	 * Page name : Clearspan Home Page Element : Search button
	 **/
	@FindBy(xpath = "td05")
	public static WebElement btn_SearchProfile;

	/**
	 * Page name : Clearspan Home Page Element : Directaccess link
	 **/
	@FindBy(xpath = ".//*[@id='Row1Col0']")
	public static WebElement link_Directaccess;

	/**
	 * Page name : Clearspan Home Page Element : Resources link
	 **/
	@FindBy(xpath = "html/body/table[2]/tbody/tr[2]/td[1]/form/b/table/tbody/tr[3]/td/a")
	public static WebElement link_Resources;

	/**
	 * Page name : ClearSpan Home Page Element : User Screen
	 **/
	@FindBy(xpath = "html/body/table[2]/tbody/tr[2]/td[4]/table/tbody/tr[2]/td")
	public static WebElement resources_Screen;

	/**
	 * Page name : Clearspan Home Page Element : Identity/Device Profiles link
	 **/
	@FindBy(xpath = "html/body/table[2]/tbody/tr[2]/td[4]/table/tbody/tr[4]/td/table/tbody/tr/td[1]/table/tbody/tr[12]/td/a")
	public static WebElement link_IdentitydeviceProfiles;

	/**
	 * Page name : ClearSpan Home Page Element :Identity/Device Profiles Screen
	 **/
	@FindBy(xpath = ".//*[@id='mainForm']/table/tbody/tr[2]/td")
	public static WebElement IdentityDeviceProfiles_Screen;

	/**
	 * Page name : Clearspan Home Page Element : Link Identity/Device Profile
	 * Name
	 **/
	@FindBy(id = "Row8Col0")
	public static WebElement Link_IdentityDeviceProfileName;

	/**
	 * Page name : ClearSpan Home Page Element :Identity/DeviceProfile Modify
	 **/
	@FindBy(xpath = ".//*[@id='mainForm']/table/tbody/tr[2]/td")
	public static WebElement identitydeviceProfiles_Screen;

	/**
	 * Page name : ClearSpan Home Page Element :Identity/Device Profiles Screen
	 **/
	@FindBy(xpath = ".//*[@id='mainForm']/table/tbody/tr[9]/td/table[3]/tbody/tr/td[2]/table/tbody/tr[12]/td[2]/input")
	public static WebElement PhysicalLocation_Screen;

	/**
	 * Page name : ClearSpan Home Page Element :Identity/Device Profiles Screen
	 **/
	@FindBy(linkText = "Assign Services")
	public static WebElement link_AssignServices;

	/**
	 * Page name : ClearSpan Home Page Element :Identity/Device Profiles Screen
	 **/
	@FindBy(id = "subscribedList")
	public static WebElement list_UserServices;

	/**
	 * Page name : ClearSpan Users Page 
	 * Element : Edit a user
	 **/
	@FindBy(xpath = "//a[contains(text(),'Edit')]")
	public static WebElement btn_edit;	
	
	/**
	 * Page name : ClearSpan Profile Page 
	 * Element : Announcement Repository link
	 **/
	@FindBy(xpath = "//a[contains(text(),'Announcement Repository')]")
	public static WebElement link_announcementRepository;	
	
	/**
	 * Page name : ClearSpan Announcement Repository Page 
	 * Element : Announcement text box
	 **/
	@FindBy(id = "findValue0")
	public static WebElement text_announceName;	
	
	/**
	 * Page name : ClearSpan User Profile Page 
	 * Element : Incoming calls link
	 **/
	@FindBy(xpath = "//a[contains(text(),'Incoming Calls')]")
	public static WebElement link_IncomingCalls;
	
	/**
	 * Page name : ClearSpan Incoming calls Page 
	 * Element   : Call Forwarding Always - On
	 **/
	@FindBy(xpath = "//a[contains(text(),'Call Forwarding Always - On')]")
	public static WebElement link_callforwardAlwaysOn;	
	
	/**
	 * Page name : ClearSpan Incoming calls Page 
	 * Element   : Call Forwarding Always - 
	 **/
	@FindBy(xpath = "//a[contains(text(),'Call Forwarding Always - ')]")
	public static WebElement link_callforwardAlwaysOff;	
	
	/**
	 * Page name : ClearSpan Call Forwarding Always Page 
	 * Element   : Phone number text box
	 **/
	@FindBy(xpath = ".//input[@value='6083337491']")
	public static WebElement text_Phonenumber;	
	
	/**
	 * Page name : Clearspan Users Page Element : Edit user link
	 **/
	@FindBy(xpath = "//a[contains(text(),'6083337490')]")
	public static WebElement link_EditUser;
	
	/**
	 * Page name : Clearspan Users Page Element : Edit user link
	 **/
	@FindBy(xpath = "//a[contains(text(),'BNG_4')]")
	public static WebElement link_EditGroup;
	
	/**
	 * Page name : Clearspan Services Page Element : Clearspan Anywhere link
	 **/
	@FindBy(xpath = "//a[contains(text(),'Clearspan Anywhere')]")
	public static WebElement link_ClearspanAnywhere;
	
	/**
	 * Page name : Clearspan Anywhere Page Element : ADD Button
	 **/
	@FindBy(xpath = ".//input[@value='Add']")
	public static WebElement link_ADD;
	
	/**
	 * Page name : Clearspan Anywhere Page Element : text box
	 **/
	@FindBy(xpath = "//input[@name='userId']")
	public static WebElement text_csID;
	
	/**
	 * Page name : Clearspan Anywhere Page Element : text box
	 **/
	@FindBy(xpath = ".//input[@name='unicodeLastName']")
	public static WebElement text_name;
	
	/**
	 * Page name : Clearspan Anywhere Page Element : Last Name text box
	 **/
	@FindBy(xpath = "//input[@name='clidLastName']")
	public static WebElement text_Lastname;
	
	/**
	 * Page name : Clearspan Anywhere Page Element : First Name text box
	 **/
	@FindBy(xpath = "//input[@name='clidFirstName']")
	public static WebElement ClearspanFirstName;
	
	/**
	 * Page name : Clearspan Anywhere Page Element : Phone Number text box
	 **/
	@FindBy(xpath = "//input[@name='clidPhone']")
	public static WebElement text_phoneNumber;
	
	/**
	 * Page name : Clearspan Anywhere Page Element : Phone Number text box
	 **/
	@FindBy(xpath = "//input[@name='ok']")
	public static WebElement btn_OK;
	
	/**
	 * Page name : Clearspan Anywhere Page Element : Phone Number text box
	 **/
	@FindBy(xpath = "//a[contains(text(),'AutoName')]")
	public static WebElement text_verifyportal;
	
	
	/**
	 * Page name : Clearspan Anywhere Page Element : Phone Number text box
	 **/
	@FindBy(xpath = "//a[contains(text(),'Addresses')]")
	public static WebElement link_addresses;
	
	/**
	 * Page name : Clearspan Anywhere Page Element : Profile link
	 **/
	@FindBy(xpath = "//a[contains(text(),'Profile')]")
	public static WebElement link_profile;
	
	/**
	 * Page name : Clearspan Anywhere Page Element : Profile link
	 **/
	@FindBy(xpath = "(//a[contains(text(),'Profile')])[2]")
	public static WebElement link_profileprofile;
	
	/**
	 * Page name : Clearspan Anywhere Page Element : Profile link
	 **/
	@FindBy(xpath = "//input[@value='Delete']")
	public static WebElement link_Delete;
	
	/**
	 * Page name : Clearspan Anywhere Page Element : Phone Number text box
	 **/
	@FindBy(id = "phoneNumber")
	public static WebElement dropdown_phonenumber;
	
	/**
	 * Page name : Clearspan Anywhere Page Element : Apply Button
	 **/
	@FindBy(xpath = "//input[@value='Apply']")
	public static WebElement btn_Apply;
	
	/**
	 * Page name : Clearspan Anywhere Page Element : Ok Button
	 **/
	@FindBy(xpath = "//input[@value='OK']")
	public static WebElement btn_Ok;
	
	/**
	 * Page name : Clearspan Anywhere Page Element : Ok Button
	 **/
	@FindBy(name = "name")
	public static WebElement name;
	
	/**
	 * Page name : Clearspan Anywhere Page Element : Ok Button
	 **/
	@FindBy(xpath = "//a[contains(.,'Files')]")
	public static WebElement tab_Files;
	
	// **********************************************Ashis
	// End***********************************
}

