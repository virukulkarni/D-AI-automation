package datatable;

public class NextGenGlobalVariables implements CommonInterface {

	public class GlobalVariablesGeneral implements CommonInterface {
		public String GeneralObjName;
		public String ApplicationVersion;
		public String ServerVersion;
		public String ServerIPAddress;
		public String ServerMiVBIPAddress;
		public String RemoteServerUsername;
		public String RemoteServerPassword;
		public String RemoteSTALocation;
		public String MainServerUsername;
		public String MainServerPassword;
		public String WebClientUrl;
		public int vmPrefix;
		public String Gmailusername;
		public String GmailPassword;
		public String MCDUsername;
		public String MCDPassword;
		
	}

	public class GlobalVariablesPlatform implements CommonInterface {
		public String GeneralObjName;
		public String PlatformID;
		public String PlatformName;
		public int PlatformVersion;
		public int PlatformDensity;
		public String AppPath;
		public String AppPackage;
		public String AppActivity;
		public String ServerURL;
		public int ServerPortNumber;
		public int WebkitPortNumber;
		public int WDAPortNumber;
	}
	
	public class GlobalVariablesCommonDevices implements CommonInterface {
		public String GeneralObjName;
		public String PlatformName;
	}
	public class GlobalVariablesCommonUsers implements CommonInterface {
		public String GeneralObjName;
		public String UserObjName;
	}
	public class GlobalVariablesUser implements CommonInterface {
		public String GeneralObjName;
		public String UserFirstName;
		public String UserLastName;
		public int UserPRGNumber;
		public int UserSoftphoneNumber;
		public String UserDeskphoneType;
		public int UserDeskphoneNumber;
		public String UserDeskphoneTypeSecond;
		public int UserDeskphoneNumberSecond;
		public int UserVoicemailPIN;
		public String UserEHDU;
		public String UserExternalExtension;
		public String prefixExternalExtension;
		public int UserMinetExtension;
		public String UserMinetSoftphoneType;
		public String UserAuthenticationCode;
		public String UserwebClientLoginId;
		public String UserwebClientLoginPass;
		public int deskphoneAutoAnsKey;
		public int deskphoneCallForwardKey;
		public int userCallForwardNumber;
		public int userAWVHuntgroupNo;
		public int userAWVHuntgroupMembers;
		public String UserSetSidePwd;
		public String Email;
	}
}
