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

public class MonitoringPages {
	public WebDriver driver;

	public MonitoringPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//**************************************Viru Start***************************************
	/**
	 * Page name : OPEASY Provisioning Page
	 * Element 	 : User ID text_box
	 **/
	
	@FindBy(xpath="//span[contains(text(),'Monitoring')]")
	public static WebElement text_Monitoring_ScreenName;
	
	/**
	 * Page name : OPEASY Monitoring Page
	 * Element 	 : OpeasyMonitoring link
	 **/

	@FindBy(xpath=".//*[@id='form1:hyperlinkOpEasyStatus']")
	public static WebElement text_OpeasyMonitoring_ScreenName;
	
	/**
	 * Page name : OPEASY Monitoring Page
	 * Element 	 : OpeasyMonitoring
	 **/

	@FindBy(xpath=".//*[@id='form1:staticTextScreenName']")
	public static WebElement text_OpeasyMonitoringp_ScreenName;
	
	/**
	 * Page name : OPEASY Monitoring Page
	 * Element 	 : OpeasyMonitoring
	 **/

	@FindBy(xpath="//span[contains(.,'BNGTestAutoComponent')]//parent::td//parent::tr//td[last()]//a")
	public static WebElement link_Delete;
	
	/**
	 * Page name : OPEASY ClearspanMonitoring Page
	 * Element 	 : Configuration link
	 **/

	@FindBy(id = "form1:LeftPane:groupPanel2:navigationTree:snmpManager:Configure:ConfigureEmail:ConfigureEmail_link")
	public static WebElement link_ConfigureEmail;	
	
	/**
	 * Page name : OPEASY ClearspanMonitoring Page
	 * Element 	 : Configuration link
	 **/

	@FindBy(id = "form1:LeftPane:groupPanel2:navigationTree:snmpManager:Configure:Configure_link")
	public static WebElement link_Configure;	
	
	/**
	 * Page name : OpEasy Monitoring Page
	 * Element 	 : Main menu link
	 **/
	@FindBy(id ="form1:HeaderPane:groupPanel2:groupPanel1:hyperlinkMainMenu")
	public static WebElement link_Mainmenu;
	
	/**
	 * Page name : OPEASY Services Page
	 * Element 	 : OpeasyServices link
	 **/

	@FindBy(id ="form1:hyperlinkServiceStatus")
	public static WebElement link_OpeasyServices;
	
	/**
	 * Page name : OPEASY Services Status Page
	 * Element 	 : OpeasyServicesStatus 
	 **/

	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'OpEasy Service Status')]")
	public static WebElement text_OpeasyServicesStatus_ScreenName;
	
	/**
	 * Page name : OPEASY Database Audit Page
	 * Element 	 : OpeasyDatabaseAudit
	 **/

	@FindBy(xpath=".//*[@id='form1:hyperlinkDbAudit']")
	public static WebElement text_OpeasyDatabaseAudit_ScreenName;
	
	/**
	 * Page name : OPEASY Database Audit Page
	 * Element 	 : DatabaseAuditStatus
	 **/

	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Database Audit Status')]")
	public static WebElement text_DatabaseAuditStatus_ScreenName;
	
	/**
	 * Page name : OPEASY Configuration Page
	 * Element 	 : OpeasyConfiguration
	 **/

	@FindBy(id ="form1:hyperlinkConfigurationInfo")
	public static WebElement link_OpeasyConfiguration;
	
	/**
	 * Page name : OPEASY Configuration Information Page
	 * Element 	 : OpeasyConfigurationInformation
	 **/

	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'OpEasy Configuration Information')]")
	public static WebElement text_OpeasyConfigurationInformation;
	/**
	 * Page name : OPEASY ClearspanMonitoring Page
	 * Element 	 : ClearspanMonitoring link
	 **/

	@FindBy(xpath=".//*[@id='form1:hyperlinkFaultMonitor']")
	public static WebElement text_ClearspanMonitoring;
	
	/**
	 * Page name : OPEASY Database Audit Page
	 * Element 	 : OpeasyDatabaseAudit
	 **/

	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Clearspan Monitoring')]")
	public static WebElement text_clearspanMonitoring_ScreenName;
	
	/**
	 * Page name : OPEASY ClearspanMonitoring Page
	 * Element 	 : Configuration link
	 **/

	@FindBy(id = "form1:hyperlinkConfiguration")
	public static WebElement link_Configuration;
	
	/**
	 * Page name : OPEASY ClearspanMonitoring Page
	 * Element 	 : Configuration link
	 **/

	@FindBy(id="form1:hyperlinkComponents")
	public static WebElement link_Components;
	
	/**
	 * Page name : OPEASY Component Configuration Page
	 * Element 	 : Component Configuration
	 **/

	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Component Configuration')]")
	public static WebElement text_ComponentConfiguration_ScreenName;
	
	/**
	 * Page name : OPEASY Component Configuration Page
	 * Element 	 : Edit Component
	 **/

	@FindBy(xpath=".//*[@id='form1:layoutPanelNewComponent:sectionTitleNewComponent'][contains(text(),'Edit Component')]")
	public static WebElement text_EditComponent;
	
	/**
	 * Page name : OPEASY Component Configuration Page
	 * Element 	 : Edit Component Name
	 **/

	@FindBy(id="form1:newComponentName")
	public static WebElement text_EditComponentName;
	
	/**
	 * Page name : OPEASY Component Configuration Page
	 * Element 	 : AddComponent 
	 **/

	@FindBy(id = "form1:addButton")
	public static WebElement btn_AddComponent;
	
	/**
	 * Page name : OPEASY Add ComponentPage
	 * Element 	 : Add Component
	 **/

	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Add Component')]")
	public static WebElement text_Addcomponent_ScreenName;
	
	/**
	 * Page name : OPEASY Add ComponentPage
	 * Element 	 : Host Name/IP Address 
	 **/

	@FindBy(id = "form1:address")
	public static WebElement text_HostName_IP;
	
	/**
	 * Page name : OPEASY Add ComponentPage
	 * Element 	 :SNMP IP
	 **/

	@FindBy(id = "form1:textFieldIpAddr")
	public static WebElement text_SNMPIP;
	
	/**
	 * Page name : OPEASY Add ComponentPage
	 * Element 	 :SNMP TRAP IP
	 **/

	@FindBy(id = "form1:textFieldIpAddr")
	public static WebElement text_SNMPTRAP_IP;
	
	/**
	 * Page name : OPEASY Add ComponentPage
	 * Element 	 :SNMP TRAP COMM
	 **/

	@FindBy(id="form1:textFieldTrapCommunity")
	public static WebElement text_SNMPTRAP_COMM;
	

	/**
	 * Page name : OPEASY Component Configuration Page
	 * Element 	 : Component Configuration
	 **/

	@FindBy(xpath=".//*[@id='form1:staticTextScreenName']")
	public static WebElement text_Component_config_screenName;
	
	/**
	 * Page name : OPEASY Component Configuration Page
	 * Element 	 : Component list table
	 **/

	@FindBy(xpath=".//*[@id='form1:componentTable:_table']")
	public static WebElement text_Componentlist;
	
	/**
	 * Page name : OPEASY Component Configuration Page
	 * Element 	 : Delete Element
	 **/

	@FindBy(xpath=".//*[@id='form1:componentTable:_table']//tr[contains(., 'AutoComponent')]//td[contains(.,'Delete')]//a")
	public static WebElement text_DeleteElement;
	
	/**
	 * Page name : OPEASY ClearspanMonitoring configuration Page
	 * Element 	 : ClearspanMonitoring configuration
	 **/

	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Clearspan Monitoring Configuration')]")
	public static WebElement text_Clearspan_configMonitor_screenName;
	
	/**
	 * Page name : OPEASY ClearspanMonitoring Page
	 * Element 	 : ClearspanMonitoring Status
	 **/

	@FindBy(id = "form1:hyperlinkStatus")
	public static WebElement link_Status;
	
	/**
	 * Page name : OPEASY Component Status Page
	 * Element 	 : Component Status
	 **/

	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Monitoring Status')]")
	public static WebElement text_ComponentStatus_ScreenName;
	
	/**
	 * Page name : OPEASY Component Status Page
	 * Element 	 : Poll Good
	 **/

	@FindBy(xpath=".//*[@id='form1:table1']//tbody//td[7]")
	public static WebElement text_PollError;
	
	/**
	 * Page name : OPEASY Monitoring Page
	 * Element 	 : SNMP Manager link
	 **/

	@FindBy(id = "form1:hyperlinkSNMPManager")
	public static WebElement link_SNMPManager;
	
	/**
	 * Page name : OPEASY SNMP Manager Page
	 * Element 	 : Traps
	 **/

	@FindBy(xpath=".//*[@id='form1:staticTextTraps']")
	public static WebElement text_Trap_ScreenName;
	
	/**
	 * Page name : OPEASY SNMP Manager Page
	 * Element 	 : Trap Summary link
	 **/

	@FindBy(xpath=".//*[@id='form1:hyperlinkViewSummary']")
	public static WebElement text_TrapSummary;
	
	/**
	 * Page name : OPEASY SNMP Manager Page
	 * Element 	 : View Trap Summary 
	 **/

	@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'View Trap Summary')]")
	public static WebElement text_ViewTrapSummary_ScreenName;
	
	/**
    * Page name : OPEASY View Trap Summary Page
	* Element 	 : Show time
	**/

	@FindBy(xpath=".//*[@id='form1:dropDownStartTime']")
	public static WebElement text_Showtime;
	
	/**
	    * Page name : OPEASY View Trap Summary Page
		* Element 	 : Starting time
		**/

		@FindBy(xpath=".//*[@id='form1:table1:_titleBar']")
		public static WebElement text_startingtime;
		
	/**
	    * Page name : OPEASY View Trap Summary Page
		* Element 	 : Select time
		**/

		@FindBy(xpath="//*[contains(text(),'Last 10 Minutes')]")
		public static WebElement text_Selecttime;
		
		/**
		 * Page name : OPEASY View Trap Summary
		 * Element 	 : SNMP type link
		 **/

		@FindBy(xpath=".//*[@id='form1:table1:_table']//tbody//tr[2]//td[8]//a")
		public static WebElement text_SNMPDisplay;
		
		/**
		 * Page name : OPEASY View Trap Summary
		 * Element 	 : View Trap Log
		 **/

		//@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'View Trap Log')]")
		@FindBy(xpath="//span[contains(text(),'View Trap Log')]")
		public static WebElement text_TrapLog_ScreenName;
		
		/**
		 * Page name : OPEASY SNMP Trap
		 * Element 	 : SNMP Trap Page
		 **/

		@FindBy(xpath=".//*[@id='form1:staticTextScreenName']")
		public static WebElement text_SNMPTrap;
		
		/**
		 * Page name : OPEASY SNMP Manager
		 * Element 	 : all Traps link
		 **/

		@FindBy(id = "form1:hyperlinkAllTraps")
		public static WebElement link_AllTraps;
		
		/**
		 * Page name : OPEASY Display All Traps
		 * Element 	 : Display All Traps
		 **/

		@FindBy(xpath=".//*[@id='form1:staticTextScreenName']")
		public static WebElement text_DisplayAllTraps;
		
		/**
		 * Page name : OPEASY Display All Traps
		 * Element 	 : Traps Dropdown list
		 **/

		@FindBy(id  ="form1:dropDownTraps_label")
		public static WebElement dropDown_Traps;
		
		/**
		 * Page name : OPEASY Display All Traps
		 * Element 	 : SNMP MIB Dropdown list
		 **/

		@FindBy(id = "form1:dropDownMIBName_label")
		public static WebElement dropDown_SNMPMIB;
		
		/**
		 * Page name : OPEASY Display All Traps
		 * Element 	 : SNMP Type No list
		 **/

		@FindBy(xpath="html/body/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td/div/div/table//tbody//td[1]//span//span[contains(.,'(Unknown)')]")
        public static WebElement text_SNMPType_Nolist;

		
		/**
		 * Page name : OPEASY View Trap Summary
		 * Element 	 : Trap Summary Table
		 **/

		//@FindBy(xpath=".//*[@id='form1:table1:_table']")
		@FindBy(xpath="(.//*[@id='form1:table1:_table']//tbody//tr[2])[contains(.,'Display')]")
		public static WebElement text_TrapSummaryTable;
		
		/**
		 * Page name : OPEASY Component Polls Page
		 * Element 	 : Component Polls Page
		 **/

		@FindBy(xpath=".//*[@id='form1:staticTextScreenName']")
		public static WebElement text_ComponentPolls_ScreenName;
		
		/**
		 * Page name : OPEASY Add ComponentPage
		 * Element 	 :SNMP TRAP IP
		 **/

		@FindBy(xpath="(//div[contains(@id, 'form1:table1')]//tbody//td[7]//span[span>0])"
				+ "[1]//parent::td//parent::tr//td[last()]//a")
		public static WebElement btn_View;
		
		/**
		 * Page name :  OPEASY Component Polls Page
		 * Element 	 :  Component Polls Page
		 **/

		@FindBy(xpath=".//*[@id='form1:staticTextScreenName']")
		public static WebElement text_Component_Polls_ScreenName;
		
		/**
		 * Page name : OPEASY Component Polls Page
		 * Element 	 : Poll Status Table
		 **/

		@FindBy(xpath=".//*[@id='form1:table1:_table']")
		public static WebElement text_PollStatus;
		
		/**
		 * Page name : OPEASY Component Polls Page
		 * Element 	 : View samples Link
		 **/

		//@FindBy(xpath="(//div[contains(@id, 'form1:table1')]//tbody//td[6]//span[span>0])[1]//parent::td//parent::tr//td[last()]//a")
		
		//@FindBy(xpath=".//*[@id='form1:table1:tableRowGroup1:1:bewSamplesColumn:viewSamplesButton']")
		@FindBy(xpath="(//span[span>0][span[contains(@id,'tableColumnError')]][span>0])[1]//parent::td//parent::tr//td[last()]")
		public static WebElement text_ViewSamples;
		
		/**
		 * Page name : OPEASY Component Polls Page
		 * Element 	 : View Query Link
		 **/

		@FindBy(xpath="(//div[contains(@id, 'form1:table1')]//tbody//tr//td[6]//span[span>0])[1]//parent::td//parent::tr//td[7]//a")
		public static WebElement text_ViewQuery;
		
		/**
		 * Page name : OPEASY Query Status Page
		 * Element 	 : Query Status
		 **/

		@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'Query Status')]")
		public static WebElement text_QueryStatus_ScreenName;

		/**
		 * Page name : OPEASY  View Samples-From Query page
		 * Element 	 :  View Samples-From Query page
		 **/

		@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'View Samples - From Query')]")
		public static WebElement text_ViewSamples_From_ScreenName;
		
		/**
		 * Page name : OPEASY Query Status Page
		 * Element 	 : Sample Definition Name
		 **/

		@FindBy(xpath=".//*[@id='form1:table1:tableRowGroup1:0:queryNames:staticText1']")
		public static WebElement text_DefinitionName;
		
		/**
		 * Page name : OPEASY  SampleDefinition page
		 * Element 	 :  View SampleDefinition
		 **/

		@FindBy(xpath=".//*[@id='form1:staticTextScreenName'][contains(text(),'View Samples - One Sample Definition')]")
		public static WebElement text_SampleDefinition_ScreenName;
		
		/**
		 * Page name : OPEASY Monitoring Page
		 * Element 	 : Logout link
		 **/
		@FindBy(xpath="//*[@id='form1:HeaderPane:groupPanel1:hyperlinkLogout']")
		public static WebElement link_Logout;
	
		/**
		 * Page name : OPEASY Clearspan Monitoring Configuration Page
		 * Element 	 : OK Button specially named
		 **/

		@FindBy(id ="form1:saveButton")
		public static WebElement btn_SplOK;
		

		/**
		 * Page name : OPEASY Query Status Page
		 * Element 	 : View samples Link
		 **/

		@FindBy(xpath="(//div[contains(@id, 'form1:table1')]//tbody//td[5]//span[span>0])[1]//parent::td//parent::tr//td[last()]//a")
		public static WebElement link_ViewSamples;
	//**********************************************Viru End***********************************
}
