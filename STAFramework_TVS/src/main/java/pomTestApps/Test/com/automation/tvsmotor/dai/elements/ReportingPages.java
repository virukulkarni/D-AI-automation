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

public class ReportingPages {
	public WebDriver driver;

	public ReportingPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//**************************************Viru Start***************************************
	/**
	 * Page name : OPEASY Reporting  Page
	 * Element 	 : Reporting screen name
	 **/
	
	@FindBy(id = "form1:staticTextScreenName")
	public static WebElement text_Reporting_ScreenName;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : link to Inventory Report
	 **/
	
	@FindBy(id = "form1:hyperlinkInventoryReport")
	public static WebElement link_InventoryReporting;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : link to Inventory Report
	 **/
	
	@FindBy(id = "form1:hyperlinkAdministratorReport")
	public static WebElement link_AdministratorReport;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : link to Inventory Report
	 **/
	
	@FindBy(xpath = ".//*[@id='form1:hyperlinkVoiceMailAuditReport']")
	public static WebElement link_VMAuditReport;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : dropDown_GroupList
	 **/
	
	@FindBy( xpath = "(//span[contains(.,'Scheduling')])[3]")
	public static WebElement Scheduling;
	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : dropDown_GroupList
	 **/
	
	@FindBy( xpath = "//a[contains(.,'User Information Report')]")
	public static WebElement link_UserInfoReport;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : link to Inventory Report
	 **/
	
	@FindBy(xpath = ".//*[@id='form1:hyperlinkRegistrationReport']")
	public static WebElement link_RegistrationReport;
	
	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : dropDown_GroupList
	 **/
	
	@FindBy( xpath = "//span[contains(.,'Clearspan License & Optional Services Report')]")
	public static WebElement LicenseReportpage;
	
	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Label Reporting Message
	 **/
	
	@FindBy(xpath = "//span[contains(.,'Scheduling Request: License & Optional Services Report')]")
	public static WebElement schedulingrequest_LicenseOptional;
	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : link to Inventory Report
	 **/
	
	@FindBy(xpath = "//a[contains(.,'Voice Mail Usage Report')]")
	public static WebElement link_VoiceMailUsageReport;	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : link to Inventory Report
	 **/
	
	@FindBy(xpath = "//label[contains(.,'(All Reports)')]")
	public static WebElement link_AllReport;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : link to Inventory Report
	 **/
	
	@FindBy(xpath = "//a[contains(.,'License & Optional Services Report')]")
	public static WebElement link_LicenseOptServiceReporting;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : link to Enterprise Usage Report
	 **/
	
	@FindBy(xpath = "//a[contains(text(),'System User Report')]")
	public static WebElement link_SystemUserReporting;
	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : link to Enterprise Usage Report
	 **/
	
	@FindBy(xpath = "//a[contains(.,'Enterprise Usage Report')]")
	public static WebElement link_EntUsageReporting;
	
		/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : link to Enterprise Usage Report
	 **/
	
	@FindBy(xpath = "//a[contains(text(),'System License Report')]")
	public static WebElement link_SystemLicenseReport;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : ropDown for Enterprise
	 **/
	
	@FindBy( id = "form1:dropDownOCIRFields_list")
	public static WebElement dropdown_OCIRFields;	
	

	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Button Start Report
	 **/
	
	@FindBy(id = "form1:buttonStart")
	public static WebElement btn_StartReport;	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Button Start Report
	 **/
	
	@FindBy(id = "form1:buttonRequestStart")
	public static WebElement btn_ScheduleStartReport;	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Button Schedule Report
	 **/
	
	@FindBy(id = "form1:buttonScheduleReport")
	public static WebElement btn_ScheduleReport;	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Label Reporting Message
	 **/
	
	@FindBy(id = "form1:layoutPanelScreenMessage:staticTextScreenMessage")
	public static WebElement label_RerportingMessage;
	
	/**
	 * Page name : OpEasy Login Management 
	 * Element 	 : Apply button
	 **/
	@FindBy(id = "form1:buttonRefresh")
	public static WebElement btn_Refresh;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Label Status Message
	 **/
	
	@FindBy(id = "form1:staticTextResults") 
	public static WebElement label_ReportStatusMessage;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Label Status Message
	 **/
	
	@FindBy(id = "form1:staticTextStatus")
	public static WebElement label_ScheduleReportStatusMessage;
	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Label Status Message
	 **/
	
	@FindBy(id = "form1:textResultsDetails")
	public static WebElement label_ScheduleReportResultDetails;
	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Label Status Message
	 **/
	
//	@FindBy(id = "form1:textAreaResultsSummary")
	@FindBy(id = "form1:staticTextResults")
	public static WebElement label_ImmediateReportStatusMessage;
	
	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Label Results Message
	 **/
	
	@FindBy(id = "form1:layoutPanelResults:staticTextResults")
	public static WebElement label_ReportResultsMessage;
	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Button 
	 **/				  
	@FindBy(id = "form1:staticTextResults")
	public static WebElement textArea_ReportProgressMessages;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Drop Down Report Schedule
	 **/
	
	@FindBy(id = "form1:dropDownSchedule_label")
	public static WebElement dropDown_ReportSchedule;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Drop Down Report Schedule
	 **/
	
	@FindBy(id = "form1:textFieldScheduleStartTime")
	public static WebElement textbox_ScheduleStartTime;
	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Button Retrieve Report
	 **/
	
	@FindBy( id = "form1:buttonDownloadResults")
	public static WebElement btn_RetreiveReport;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Button Email Report
	 **/
	@FindBy( id = "form1:buttonEmailResults")
	public static WebElement btn_EmailReport;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Button Schedule Refresh button
	 **/
	@FindBy( id = "form1:buttonRefreshStatus")
	public static WebElement btn_ScheduleRefresh;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Textbox Maximum Run count
	 **/
	@FindBy( id = "form1:textFieldMaxRunCount_field")
	public static WebElement text_FieldMaxRunCount;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Button Last Run Results
	 **/
	@FindBy( id = "form1:buttonLastRunResults")
	public static WebElement btn_LastRunResults;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Link Scheduling
	 **/
	@FindBy( id = "form1:hyperlinkScheduling")
	public static WebElement link_Scheduling;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Dropdown Schedule Task List
	 **/
	@FindBy( id = "form1:dropDownScheduledTask_label")
	public static WebElement dropDown_ScheduledTaskList;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : Dropdown Schedule Task List
	 **/
	
	@FindBy( id = "form1:dropDownAdministrator_label")
	public static WebElement dropDown_AdministratorList;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : DropDown for Group
	 **/
	
	@FindBy(id = "form1:cbDepartment_label")
	public static WebElement dropdown_Department;	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : buttonDownloadResults
	 **/
	
	@FindBy( id = "form1:buttonDownloadResults")
	public static WebElement btn_DownloadResults;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : buttonDownloadResults
	 **/
	
	@FindBy( id = "form1:textAreaResultsSummary_field")
	public static WebElement textArea_ResultsSummaryField;
	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : linkSystemXMLReport
	 **/
	
	@FindBy( id = "form1:hyperlinkSystemXMLReport")
	public static WebElement link_SystemXMLReport;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : checkbox_SuccessEmailNotification
	 **/
	
	@FindBy( id = "form1:layoutPanelEmailSuccessNotification:checkboxSuccessEmailNotification_cb")
	public static WebElement checkbox_SuccessEmailNotification;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : checkbox_FailureEmailNotification
	 **/
	
	@FindBy( id = "form1:layoutPanelEmailFailureNotification:checkboxFailureEmailNotification_cb")
	public static WebElement checkbox_FailureEmailNotification;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : checkbox_FTPFile1
	 **/
	
	@FindBy( id = "form1:layoutPanelFile1FTP:checkboxFTPFile1_cb")
	public static WebElement checkbox_FTPFile1;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : btn_File1AddFTPDestination
	 **/
	
	@FindBy( id = "form1:buttonFile1AddFTPDestination")
	public static WebElement btn_File1AddFTPDestination;

	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : txt_FieldUserField
	 **/
	
	@FindBy( id = "form1:textFieldAddress")	
	public static WebElement txt_FieldAddressField;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : txt_FieldUserField
	 **/
	
	@FindBy( id = "form1:textFieldUser")
	public static WebElement txt_FieldUserField;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : txt_FieldPasswordField
	 **/
	
	@FindBy( id = "form1:textFieldPassword")
	public static WebElement txt_FieldPasswordField;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : txt_FieldFileNameField
	 **/
	
	@FindBy( id = "form1:textFieldFileName")
	public static WebElement txt_FieldFileNameField;

	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : btn_TestCionnection
	 **/
	
	@FindBy( id = "form1:buttonTestCionnection")
	public static WebElement btn_TestConnection;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : label_staticTextScreenMessage
	 **/
	
	@FindBy( id = "form1:staticTextScreenMessage")
	public static WebElement label_staticTextScreenMessage;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : txt_SuccessEmailAddress_field
	 **/
	
	@FindBy( id = "form1:layoutPanelEmailSuccessNotification:textFieldSuccessEmailAddress_field")
	public static WebElement txt_SuccessEmailAddress_field;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : txt_FailureEmailAddress_field
	 **/
	
	@FindBy( id = "form1:layoutPanelEmailFailureNotification:textFieldFailureEmailAddress_field")
	public static WebElement txt_FailureEmailAddress_field;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : txt_SchedulingEmailAddress_field
	 **/
	
	@FindBy( id = "form1:textFieldFailureEmailAddress")
	public static WebElement txt_SchedulingEmailAddress;	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : txt_ResultsTime
	 **/
	
	@FindBy( id = "form1:layoutPanelResults:staticTextResultsTime")
	public static WebElement txt_ResultsTime;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : link_CDRQuery
	 **/
	
	@FindBy( xpath = "//a[contains(.,'CDR Query')]")
	public static WebElement link_CDRQuery;	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : link_CDRQuery
	 **/
	
	@FindBy( id = "form1:hyperlinkPhoneAppLogQuery")
	public static WebElement link_PhoneApplLogQuery;	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : link_CDRQuery
	 **/
	
	@FindBy( id = "form1:hyperlinkOCIR")
	public static WebElement link_ProvisioningLogQuery;	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : link_CDRQuery
	 **/
	
	@FindBy( id = "form1:hyperlinkCDR")
	public static WebElement link_CDR;	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : link_CDRQuery
	 **/
	
	@FindBy( id = "form1:hyperlinkCDRManagerConfig")
	public static WebElement link_CDRManagerConfig;	
	
	
	 /**
	  * Page name : OPEASY Reporting Page
	  * Element 	 : link to Provisioning Log
	  **/
		
	@FindBy(xpath = "(//a[contains(.,'Provisioning Log')])[1]")
	public static WebElement link_ProvisioningLog;	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : dropDown_TimeFrameList
	 **/
	
	@FindBy( id = "form1:dropDownTimeFrame_label")
	public static WebElement dropDown_TimeFrameList;	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : checkbox_EmailNotification
	 **/
	
	@FindBy( id = "form1:checkboxEmailNotification")
	public static WebElement checkbox_EmailNotification;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : dropdown_rowGroupSearchCriteria1
	 **/
	
	@FindBy( id = "form1:tableSearchCriteria:rowGroupSearchCriteria:0:columnFieldName:fieldName_list")	
	public static WebElement dropdown_rowGroupSearchCriteria1;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : dropdown_columnFieldComparison1
	 **/
	
	@FindBy( id = "form1:tableSearchCriteria:rowGroupSearchCriteria:0:columnFieldComparison:fieldComparison_list")
	public static WebElement dropdown_columnFieldComparison1;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : txt_FieldValue1
	 **/
	
	@FindBy( id = "form1:tableSearchCriteria:rowGroupSearchCriteria:0:columnFieldValue:fieldValue_field")
	public static WebElement txt_FieldValue1;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : btn_RowAdd1
	 **/
	
	@FindBy( id = "form1:tableSearchCriteria:rowGroupSearchCriteria:0:columnRowAdd:buttonRowAdd")
	public static WebElement btn_RowAdd1;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : dropdown_rowGroupSearchCriteria2
	 **/
	
	@FindBy( id = "form1:tableSearchCriteria:rowGroupSearchCriteria:1:columnFieldName:fieldName_list")
	public static WebElement dropdown_rowGroupSearchCriteria2;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : dropdown_columnFieldComparison2
	 **/
	
	@FindBy( xpath = ".//select[@id[contains(., ':1:columnFieldComparison:fieldComparison_list')]]")
	public static WebElement dropdown_columnFieldComparison2;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : txt_FieldValue2
	 **/
	
	@FindBy( xpath = ".//input[@id[contains(., ':1:columnFieldValue:fieldValue_field')]]")
	public static WebElement txt_FieldValue2;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : btn_StartQuery
	 **/
	
	@FindBy( id = "form1:buttonStart")
	public static WebElement btn_StartQuery;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : btn_DownloadResults
	 **/
	
	@FindBy( id = "form1:buttonDownloadResults")
	public static WebElement btn_DownloadCDRResults;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : dropDown_EnterpriseList
	 **/
	
	@FindBy( id = "form1:layoutPanelControls:dropDownEnterprise_list")
	public static WebElement dropDown_EnterpriseList;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : dropDown_GroupList
	 **/
	
	@FindBy( id = "form1:layoutPanelControls:dropDownGroup_list")
	public static WebElement dropDown_GroupList;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : dropDown_GroupList
	 **/
	
	@FindBy( id = "form1:buttonScheduling")
	public static WebElement button_Scheduling;
		
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : dropDown_GroupList
	 **/
	
	@FindBy( id = "form1:rowGroupSearchCriteria:0:fieldValue")
	public static WebElement txt_SearchValue;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : dropDown_GroupList
	 **/
	
	@FindBy( xpath = "//label[contains(.,'Active / Waiting')]")
	public static WebElement radio_ActiveWaiting;
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : dropDown_GroupList
	 **/
	
	@FindBy( linkText = "Scheduling")
	public static WebElement scheduling;
	
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : dropDown_GroupList
	 **/
	
	@FindBy( xpath = "//span[contains(.,'Customize')]")
	public static WebElement btn_Customize;
			
	
	/**
	 * Page name : OPEASY Reporting Page
	 * Element 	 : dropDown_GroupList
	 **/
	
	@FindBy( id = "form1:buttonScheduleCDRQuery")
	public static WebElement btn_ScheduleCDRReport;
	
	

	
	
	
	
	
	
	
	
	
		
	
	//**********************************************Viru End***********************************
}
