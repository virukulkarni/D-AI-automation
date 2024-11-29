package datatable;

public class OriaGlobalVariables implements CommonInterface {

	//* This acts as structure for all the information required for test bed under execution  */
		public class GlobalVariablesTestBed implements CommonInterface {
			public String TestNodeName;
			public String FQDN;
			public String NetworkElementName;
			public String LocalName;
			public String BuildVersion;
			public String IPAddress;
			public String Username;
			public String Password;
			public String EsmIPAddress;
			public String EsmUserName;
			public String EsmPassword;
			public String ConsumerID;
			public String SharedSecret;
			public String FinalTokenID;
			public String FinalSecret;
		}
	
	public class GlobalVariablesMBGRestApi implements CommonInterface {
		public String RestApiObjectName;
		public String RestApiIPAddress;
		public String RestApiUsername;
		public String RestApiPassword;
		public String RestApiConsumerID;
		public String RestApiSharedSecret;
		public String RestApiFinalTokenID;
		public String RestApiFinalSecret;
		
	}

	public class GlobalVariablesGeneral implements CommonInterface {
		public String GeneralObjName;
		public String GeneralSPPortalURL;
		public String GeneralCustomerPortalURL;
		public String GeneralResellerPortalURL;
		public String GeneralSPUsername;
		public String GeneralSPPassword;
		public String GeneralApplicationName;
		public String GeneralApplicationVersion;
		public String GeneralOutlookURL;
		public String GeneralOutlookUserName;
		public String GeneralOutlookPassword;
		public String GeneralEndUserPortalURL;
		public String GeneralORIAServerUsername;
		public String GeneralORIAServerPassword;
		public String GeneralMiVBUserName;
		public String GeneralMiVBPassword;

	}

	public class GlobalVariablesFeatureProfile implements CommonInterface {
		public String FPObjectName;
		public String FPName;
		public String FPDescription;
		public int FPCosDay;
		public int FPCosNight1;
		public int FPCosNight2;
	}

	public class GlobalVariablesDialingPrivilege implements CommonInterface {
		public String DPObjectName;
		public String DPName;
		public String DPDescription;
		public int DPCosDay;
		public int DPCosNight1;
		public int DPCosNight2;
	}

	public class GlobalVariablesKeyTemplate implements CommonInterface {
		public String KTObjectName;
		public String KTName;
		public String KTDescription;
		public String featureDropdown;
		public String label1Name;
	}

	public class GlobalVariablesMASRestApi implements CommonInterface {
		public String RestApiObjectName;
		public String RestApiIPAddress;
		public String RestApiUsername;
		public String RestApiPassword;
	}

	public class GlobalVariablesAdminBundles implements CommonInterface {
		public String AdminBundleObjectName;
		public String AdminBundleName;
		public int AdminBundleProductCode;
		public String AdminBundleDescription;
		public String CreateUsersCHKStatus;
		public String ModifyUsersCHKStatus;
		public String DeleteUsersCHKStatus;
		public String CreateCallGroupsCHKStatus;
		public String ModifyCallGroupsCHKStatus;
		public String DeleteCallGroupsCHKStatus;
		public String CreateHotDeskPhonesCHKStatus;
		public String ModifyHotDeskPhonesCHKStatus;
		public String DeleteHotDeskPhonesCHKStatus;
		public String CreateKeyTemplatesCHKStatus;
		public String ModifyKeyTemplatesCHKStatus;
		public String DeleteKeyTemplatesCHKStatus;
		public String CreateCompanySpeedDialCHKStatus;
		public String ModifyCompanySpeedDialCHKStatus;
		public String DeleteCompanySpeedDialCHKStatus;
		
		//Used  only in Oria6.1 and later
		public String CreateACDGroups;
		public String ModifyACDGroups;
		public String DeleteACDGroups;
		public String CreateAdvancedACDGroups;
		public String CreateACDPaths;
		public String ModifyACDPaths;
		public String DeleteACDPaths;
		public String CreateAdvancedACDPaths;
		public String CreateACDMOH;
		public String ModifyACDMOH;
		public String DeleteACDMOH;
		public String CreateRADProgramming;
		public String ModifyRADProgramming;
		public String DeleteRADProgramming;
		//
		
		public String CreateACDCHKStatus;
		public String ModifyACDCHKStatus;
		public String DeleteACDCHKStatus;
		public String CreateCallReroutingDestinationsCHKStatus;
		public String ModifyCallReroutingDestinationsCHKStatus;
		public String DeleteCallReroutingDestinationsCHKStatus;
		public String CreateAutoAttendantCHKStatus;
		public String ModifyAutoAttendantCHKStatus;
		public String DeleteAutoAttendantCHKStatus;
		public String UsersCHKStatus;
		public String CallGroupsCHKStatus;
		public String HotDeskPhonesCHKStatus;
		public String KeyTemplatesCHKStatus;
		public String CompanySpeedDialCHKStatus;
		public String ACDCHKStatus;
		public String CallReroutingDestinationsCHKStatus;
		public String AutoAttendantCHKStatus;
		public String ModifyAdvancedSettingsCHKStatus;
		public String ModifyMusicOnHoldCHKStatus;
		public String PXSyncCHKStatus;
		public String EmailCapabilitiesCHKStatus;
		public String CallFlowsCHKStatus;
		public String GeneralMailboxCHKStatus;
	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesUserBundles implements CommonInterface {
		public String UserBundleObjectName;
		public String UserBundleBundleType;
		public String UserBundleBundleName;
		public int UserBundleBundleProductCode;
		public String UserBundleBundleDescription;
		public String UserBundleSelectaservicetype;
		public String UserBundleSelectalicensetype;
		public String UserBundleVoicemail;
		public String UserBundleStandardUnifiedMessaging;
		public String UserBundleAdvancedUnifiedMessaging;
		public String UserBundleVoicemailToEmail;
		public String UserBundleAWVConferencing;
		public String UserBundleMiCollabClientService;
		public String UserBundleLyncPlugin;
		public String UserBundleUseWifi;
		public String UserBundleEnableSecureTransport;
		public String UserBundleCompression;
		public String UserBundlePrimePhoneType;
		public String UserBundlePrimeFeatureProfile;
		public String UserBundleSecondPhoneType;
		public String UserBundleSecondFeatureProfile;
		public String UserBundleThirdPhoneType;
		public String UserBundleThirdFeatureProfile;
		public String UserBundleBundleDevices;
		public String UserBundlePrimePhoneTypeStatus;
		public String UserBundlePrimeFeatureProfileStatus;
		public String UserBundleSecondPhoneTypeStatus;
		public String UserBundleSecondFeatureProfileStatus;
		public String UserBundleThirdPhoneTypeStatus;
		public String UserBundleThirdFeatureProfileStatus;
		public String UserBundleFourthPhoneType;
		public String UserBundleFourthPhoneTypeStatus;
		public String UserBundleFourthFeatureProfileStatus;
		public String UserBundleFourthFeatureProfile;
		public String UserBundleBundleDevicesStatus;
		public String UserBundleAttendantExtension;
		public String UserBundleFeatureCOS;
		public String UserBundleLimitsCOS;
		public String UserBundleMessageWaiting1;
		public String UserBundleMessageWaiting2;

	}

	public class GlobalVariablesPlatform implements CommonInterface {
		public String PlatformObjectName;
		public String PlatformName;
		public String PlatformType;
		public String PlatformHostName;
		public String PlatformMiXMLUsername;
		public String PlatformMiXMLPassword;
		public String PlatformPublicFacingFQDN_IPAddress;
		public String PlatformMSLUsername;
		public String PlatformMSLPassword;
		public String PlatformMMGHostName;
		public String PlatformUseEmbeddedMiVoiceBorderGateway;
		public String EmbeddedMBGPublicFacingFQDN_IPAddress;
		public String PlatformDescription;
		public String PlatformDemoMode;
		public String PlatformStatusmessage;

	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesPlatformSite implements CommonInterface {
		public String PlatformSiteObjectName;
		public String PlatformSiteSiteName;
		public String PlatformSitePrimaryMiVoiceBusiness;
		public String PlatformSiteResilientMiVoiceBusiness;
		public String PlatformSiteMinetDeviceMBG;
		public String PlatformSiteInstallerPassword;
		public String PlatformSiteSIPDeviceMBG;
		public String PlatformSiteUCClientDeviceMBG;
		public int PlatformSiteCESIDNumber;
		public int PlatformSiteCPNNumber;
		public String PlatformSiteCPNNumberStatus;
		public String PlatformSiteCESIDNumberStatus;
		public String PlatformSiteAddMinetMBGInstallerPassword;
		public String PlatformSiteNetworkZone;

	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesPlatformDIDs implements CommonInterface {
		public String PlatformDIDsObjectName;
		public int PlatformDIDsStartRange;
		public int PlatformDIDsEndRange;
		public String PlatformDIDsMBGCluster;
		public String PlatformSIPTrunk;
		public String PlatformSite;

	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesPlatformMiVoiceBusiness implements CommonInterface {
		public String PlatformMiVoiceBusinessObjectName;
		public String PlatformMiVoiceBusinessName;
		public String PlatformMiVoiceBusinessHostName;
		public String PlatformMiVoiceBusinessMiXMLUsername;
		public String PlatformMiVoiceBusinessMiXMLPassword;

	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesPlatformMiCollabClientTenant implements CommonInterface {
		public String PlatformMiCollabClientTenantObjectName;
		public String PlatformMiCollabClientTenantTenantId;
		public String PlatformMiCollabClientTenantHostName;
		public String PlatformMiCollabClientTenantPublicFacingFQDN_IPAddress;
		public String PlatformMiCollabClientTenantMSLUsername;
		public String PlatformMiCollabClientTenantMSLPassword;
		public String PlatformMiCollabClientTenantAdministratorEmail;
		public int PlatformMiCollabClientTenantDialingPrefix;
		public String PlatformMiCollabClientTenantStatusmessage;

	}

	public class GlobalVariablesPlatformSettings implements CommonInterface {
		public String PlatformSettingsObjectName;
		public String PlatformSettingsVoicemailHuntGroupPilotNumber;
		public String PlatformSettingsLowerSpeedDialNumberRange;
		public String PlatformSettingsUpperSpeedDialNumberRange;
	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesMiVoiceBusiness implements CommonInterface {
		public String MiVoiceBusinessObjectName;
		public String MiVoiceBusinessHostAddress;
		public String MiVoiceBusinessUsername;
		public String MiVoiceBusinessPassword;
		public String MiVoiceBusinessNetworkElementIP;
		public String MiVoiceBusinessNewNetworkElementName;

	}

	public class GlobalVariablesMiVoiceBorderGateway implements CommonInterface {
		public String MBGObjectName;
		public String MBGName;
		public String MBGHostName;
		public String MBGPublicFacingFQDN_IPAddress;
		public String MBGMSLUsername;
		public String MBGMSLPassword;
		public String MBGDescription;
		public String MBGDemoMode;
		public String MBGStatusmessage;
		public int MBGPlatformGroupColumnValue;
		public String MBGVerifyColumnValue;
		public String MBGDemoModeStatus;
	}

	public class GlobalVariablesBulkImport implements CommonInterface {
		public String BulkObjectName;
		public String BulkCustomerName;
		public String BulkImportFile;
	}

	public class GlobalVariablesCustomer implements CommonInterface {
		public String CustomerObjectName;
		public String CustomerName;
		public int CustomerAccountNumber;
		public String CustomerMainOfficeAddress;
		public int CustomerPrimaryPhoneNumber;
		public String CustomerDescription;
		public String CustomerPortalBranding;
		public String CustomerWebID;
		public String CustomerPlatform;
		public int CustomerExtensionLength;
		public String CustomerDialingPrivilegeAssignment;
		public int CustomerNoOfKeyTemplate;
		public String CustomerKeyTemplate1;
		public String CustomerKeyTemplate2;
		public String CustomerKeyTemplate3;
		public String CustomerKeyTemplate4;
		public String CustomerKeyTemplate5;
		public String CustomerWelcomeEmailTemplate;
		public String CustomerAutomaticallySendEmailonUserCreation;
		public String CustomerTimeZone;
		public String CustomerAdditionalCPNsInfoName;
		public int CustomerAdditionalCPNsInfoNumber;
		public int CustomerAdditionalEmergencyInfoSize;
		public String CustomerAdditionalEmergencyInfoLocation1;
		public int CustomerAdditionalEmergencyInfoNumber1;
		public String CustomerAdditionalEmergencyInfoLocation2;
		public int CustomerAdditionalEmergencyInfoNumber2;
		public String CustomerAdditionalEmergencyInfoLocation3;
		public int CustomerAdditionalEmergencyInfoNumber3;
		public String CustomerAdditionalEmergencyInfoLocation4;
		public int CustomerAdditionalEmergencyInfoNumber4;
		public String CustomerAdditionalEmergencyInfoLocation5;
		public int CustomerAdditionalEmergencyInfoNumber5;
		public int TotalNumberofBundleSize;
		public String CustomerBundleName1;
		public int CustomerBundleValue1;
		public String CustomerBundleName2;
		public int CustomerBundleValue2;
		public String CustomerBundleName3;
		public int CustomerBundleValue3;
		public String CustomerBundleName4;
		public int CustomerBundleValue4;
		public String CustomerBundleName5;
		public int CustomerBundleValue5;
		public String CustomerBundleName6;
		public int CustomerBundleValue6;
		public String CustomerBundleName7;
		public int CustomerBundleValue7;
		public String CustomerBundleName8;
		public int CustomerBundleValue8;
		public String CustomerBundleName9;
		public int CustomerBundleValue9;
		public String CustomerBundleName10;
		public int CustomerBundleValue10;
		public String CustomerHotdeskdevice;
		public String CustomerLanguage;
		public String CustomerFirstName;
		public String CustomerLastName;
		public String CustomerEmailAddress;
		public String CustomerUsername;
		public String CustomerPassword;
		public String CustomerConfirmPassword;
		public String CustomerAdminBundle;
		public String CustomerAdditionalCPNStatus;
	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesUser implements CommonInterface {
		public String UserObjectName;
		public String UserLanguage;
		public String UserFirstName;
		public String UserLastName;
		public String UserEmailAddress;
		public String UserUsername;
		public String UserPassword;
		public String UserConfirmPassword;
		public String UserBundleAssignment;
		public String UserSiteAssignment;
		public String UserEmergencyResponseLocation;
		public int UserDirectNumber;
		public String UserCallerIDNumber;
		public String UserEnablePrivacy;
		public int UserExtension;
		public String UserPhoneModel;
		public String UserPhoneMACAddress;
		public int UserPhonePIN;
		public String UserAssignDialingPrivilege;
		public String UserAssignKeyTemplate;
		public String UserPrimePhoneSIPUserName;
		public String UserPrimePhoneSIPPassword;
		public String UserPrimePhoneConfirmSIPPassword;
		public String UserVoicemailPasscode;
		public String UserConfirmPasscode;
		public int UserExternalPhonePrefix;
		public int UserExternalPhoneNumber;
		public String UserActivateSimultaneousRinging;
		public String UserThirdPhoneSIPUserName;
		public String UserThirdPhoneSIPPassword;
		public String UserThirdPhoneConfirmSIPPassword;
		public String CallHandlingRulesUserBusy;
		public String CallHandlingRulesAtDay;
		public String CallHandlingRulesAtNight;
		public String CallHandlingRulesAtAltNight;

	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesHotDeskPhone implements CommonInterface {
		public String HDPhoneObjectName;
		public String HDPhoneSiteAssignment;
		public String HDPhoneName;
		public int HDPhoneExtension;
		public String HDPhonePhoneType;
		public String HDPhonePhoneMACAddress;
		public String HDPhoneEmergencyResponseLocation;
	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesGroup implements CommonInterface {
		public String GroupObjectName;
		public String GroupType;
		public String GroupSiteAssignment;
		public String GroupGroupName;
		public String GroupGroupDescription;
		public String GroupGroupProgramming;
		public int GroupGroupExtension;
		public String GroupOverflowPoint;
		public String GroupEnableGroupVoicemail;
		public int GroupRingingTimer;
		public int GroupCascadeTimer;
		public int GroupQueuedTimer;
		public String GroupDirectNumber;
		public int GroupVoicemailPasscode;
		public int GroupConfirmPasscode;
		public String GroupVoicemailtoEmailAddress;
		public String GroupEnableForwardingtoEmail;
		public String GroupDial_0;
		public int GroupDialExtentionNumber;
		public String GroupSelectUser;
		public String GroupEnterDial_0_Ext;
		public String GroupUser;

	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesResellers implements CommonInterface {
		public String ResellerObjectName;
		public String ResellerResellersName;
		public int ResellerAccountNumber;
		public String ResellerMainOfficeAddress;
		public int ResellerPrimaryPhoneNumber;
		public String ResellerDescription;
		public String ResellerPortalBranding;
		public String ResellerWebID;
		public String ResellerResellersType;
		public String ResellerLanguage;
		public String ResellerFirstName;
		public String ResellerLastName;
		public String ResellerEmailAddress;
		public String ResellerUsername;
		public String ResellerPassword;
		public String ResellerConfirmPassword;
	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesAdministrator implements CommonInterface {
		public String AdministratorObjectName;
		public String AdministratorLanguage;
		public String AdministratorFirstName;
		public String AdministratorLastName;
		public String AdministratorEmailAddress;
		public String AdministratorUsername;
		public String AdministratorPassword;
		public String AdministratorConfirmPassword;
		public String AdministratorOperationsProfile;
	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesOperationsProfile implements CommonInterface {
		public String OperatioProfileObjectName;
		public String OperatioProfileOperationsProfileName;
		public String OperatioProfileOperationsProfileDescription;
		public String OperatioProfileCreateBundles;
		public String OperatioProfileModifyBundles;
		public String OperatioProfileDeleteBundles;
		public String OperatioProfileCreateCustomers;
		public String OperatioProfileModifyCustomers;
		public String OperatioProfileDeleteCustomers;
		public String OperatioProfileLoginAsCustomers;
		public String OperatioProfileCreateResellers;
		public String OperatioProfileModifyResellers;
		public String OperatioProfileDeleteResellers;
		public String OperatioProfileLoginAsResellers;
		public String OperatioProfileCreatePlatformGroups;
		public String OperatioProfileModifyPlatformGroups;
		public String OperatioProfileDeletePlatformGroups;
		public String OperatioProfileCreateBrands;
		public String OperatioProfileModifyBrands;
		public String OperatioProfileDeleteBrands;
		public String OperatioProfileModifyAdvanced;
		public String OperatioProfileModifyBackgroundTaskResults;
		public String OperatioProfileCreatePhoneCapabilities;
		public String OperatioProfileModifyPhoneCapabilities;
		public String OperatioProfileAllBilling;
		public String OperatioProfileDeletePhoneCapabilities;
		public String OperatioProfileModifyDefault;
		public String OperatioProfileCreateMiVoiceBorderGateways;
		public String OperatioProfileModifyMiVoiceBorderGateways;
		public String OperatioProfileDeleteMiVoiceBorderGateways;
		public String OperatioProfileCreateEmailTemplate;
		public String OperatioProfileModifyEmailTemplate;
		public String OperatioProfileDeleteEmailTemplate;
		public String OperatioProfileCreateKeyTemplates;
		public String OperatioProfileModifyKeyTemplates;
		public String OperatioProfileDeleteKeyTemplates;
		public String OperatioProfileCreateAdministrators;
		public String OperatioProfileModifyAdministrators;
		public String OperatioProfileDeleteAdministrators;

	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesBrand implements CommonInterface {
		public String BrandObjectName;
		public String BrandBrandLabel;
		public String BrandBrandDescription;
		public String BrandHomeLink;
		public String BrandTermsofUseLink;
		public String BrandPrivacyPolicyLink;
		public String BrandFavicon;
		public String BrandCompanyLogo;
		public String BrandBannerAdvertisement;
		public String BrandLoginImage;
	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesEmailTemplate implements CommonInterface {
		public String EmailTemplateObjectName;
		public String EmailTemplateEmailTemplateName;
		public String EmailTemplateEmailTemplateDescription;
		public String EmailTemplateSenderEmailAddress;
		public String EmailTemplateSubject;
		public String EmailTemplateGreetingText;
		public String EmailTemplateFooterText;
		public String EmailTemplateEmailOriaPortalDetails;
		public String EmailTemplateEmailOriaUsernameandURL;
		public String EmailTemplateEmailOriaPassword;
		public String EmailTemplateEmailPhoneDetails_AllPhones;
		public String EmailTemplatePortalPhoneDetails_AllPhones;
		public String EmailTemplateEmailDeskphone;
		public String EmailTemplatePortalDeskphone;
		public String EmailTemplateEmailHotDesk;
		public String EmailTemplatePortalHotDesk;
		public String EmailTemplateEmailGenericSIPPhone;
		public String EmailTemplatePortalGenericSIPPhone;
		public String EmailTemplateEmailMiVoiceConferencePhone;
		public String EmailTemplatePortalMiVoiceConferencePhone;
		public String EmailTemplateMailPCMinetsoftphone;
		public String EmailTemplatePortalPCMinetsoftphone;
		public String EmailTemplateEmailPCSIPsoftphone;
		public String EmailTemplatePortalPCSIPsoftphone;
		public String EmailTemplateEmailMobileSIPsoftphone;
		public String EmailTemplatePortalMobileSIPsoftphone;
		public String EmailTemplateEmailACD;
		public String EmailTemplatePortalACD;
		public String EmailTemplateEmailDualModeMobile;
		public String EmailTemplatePortalDualModeMobile;
		public String EmailTemplateEmailExternalPhoneDetail;
		public String EmailTemplatePortalExternalPhoneDetail;
		public String EmailTemplateEmailCallerPartyNumberInformation;
		public String EmailTemplatePortalCallerPartyNumberInformation;
		public String EmailTemplateEmailEmergencyInformation;
		public String EmailTemplatePortalEmergencyInformation;
		public String EmailTemplateEmailDID;
		public String EmailTemplatePortalDID;
		public String EmailTemplateEmailVoicemailDetails;
		public String EmailTemplatePortalVoicemailDetails;
		public String EmailTemplateEmailMiCollabWebClient;
		public String EmailTemplatePortalMiCollabWebClient;
		public String EmailTemplateEmailMiCollabClientDetails;
		public String EmailTemplatePortalMiCollabClientDetails;
		public String EmailTemplateEmailLyncPluginURL;
		public String EmailTemplatePortalLyncPluginURL;
		public String EmailTemplateEmailAWVConferencingDetails;
		public String EmailTemplatePortalAWVConferencingDetails;
		public String EmailTemplateEmailSetupInstructions;
		public String EmailTemplatePortalSetupInstructions;
	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesACDGroups implements CommonInterface {
		public String ACDGroupObjectName;
		public String ACDGroupSiteAssignment;
		public String ACDGroupName;
		public String ACDGroupGroupDescription;
		public int ACDGroupExtension;
		public int ACDGroupReportingNumber;
		public String ACDGroupUser;
	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesACDPaths implements CommonInterface {
		public String ACDPathsObjectName;
		public String ACDPathsSiteAssignment;
		public String ACDPathsName;
		public String ACDPathsDescription;
		public int ACDPathsDirectNumber;
		public int ACDPathsExtension;
		public int ACDPathsReportingNumber;
		public String ACDPathsEnableVoicemailforthisPath;
		public String ACDPathsPrimarySkillGroup;
		public String ACDPathsOverflowGroup;
	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesAutoAttendant implements CommonInterface {
		public String AutoAttendantObjectName;
		public String AutoAttendantName;
		public String AutoAttendantDescription;
		public String AutoAttendantDIDs; //numbers people can call to reach this auto attendant.
        public String AutoAttendantCallerPessKey; //When the caller presses 1, what should happen?
        public String AutoAttendantPickUpUser; //To which User do you want to transfer?
		public String AutoAttendantGreetingFile;
		public String AutoAttendantDial_0_User;
		public String AutoAttendantSelectUser;
		public String AutoAttendantDial_0_Ext;
		public String AutoAttendantEnterDial_0_Ext;
	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesCallReroutingDestination implements CommonInterface {
		public String CallReroutingDestinationStatusName;
		public String CallReroutingDestinationName;
		public String CallReroutingDestinationNumber;
	}

	//Create the Structure for visible columns in excel sheet
	public class GlobalVariablesCompanySpeedDial implements CommonInterface {
		public String CompanySpeedDialObjectName;
		public String CompanySpeedDialName;
		public int CompanySpeedDialNumbertoDial;
		public String CompanySpeedDialNumbertoCall;
	}

	public class GlobalVariablesPlatformSIPBillingNumber implements CommonInterface {
		public String PlatformSIPBillingObjectName;
		public String PlatformSIPBillingName;
		public int PlatformSIPBillingNumber;

	}

	public class GlobalVariablesCallFlow implements CommonInterface {
		public String CallFlowObjectName;
		public String CallFlowName;
		public String CallFlowDiscription;
		
	}
}
