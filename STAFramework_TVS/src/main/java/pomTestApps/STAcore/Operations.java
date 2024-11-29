package pomTestApps.STAcore;

import java.io.File;

import pomTestApps.STAcore.POMSuiteRunner;

public class Operations {
	
	private static String OpserverName = "";
	private static String OpUserName = "";
	private static String OpPassWord = "";
	private static String OpHTMLReport = "";
	private static String Opdir = "";
	private static String RPMVersions = "";
	private static String LogProcess = "";
	private static String Known_Hosts="";
	//public static String LogDirectory=pomTestApps.STAcore.POMSuiteRunner.PropertyName+"-Automation-Logs-"+System.currentTimeMillis();

	public static String LogDirectory="MX-ONE"+"-Automation-Logs-"+System.currentTimeMillis();
	
	
	public String getApplicationVersion(String HostIP, String sshUserName, String sshPassword){
		
		Operations.OpserverName = HostIP;
		Operations.OpUserName=sshUserName;
		Operations.OpPassWord=sshPassword;
		Operations.Known_Hosts=System.getProperty("user.dir")+"\\"+pomTestApps.STAcore.POMSuiteRunner.FileName+"\\"+POMSuiteRunner.ConfigStore.get("_Known_hosts");
		
		if(OpserverName.isEmpty() || OpUserName.isEmpty() || OpPassWord.isEmpty()){
			throw new NullPointerException("The Credential should not be blank");
		}
		
		//Command to execute for getting the RPM Versions		
		String rpmlist = "rpm -qa | grep eri";
		File knownHosts = new File(Known_Hosts);
	if((Known_Hosts.isEmpty()) || !(knownHosts.exists())){
		throw new NullPointerException("Known_Hosts file should be present");
	}	
		
		try {
			SSHManager instance = new SSHManager(OpUserName, OpPassWord, OpserverName, Known_Hosts);
		    String errorMessage = instance.connect();
			
			if (errorMessage != null) {
				System.out
						.println("There is an error occured :"
								+ errorMessage);
			}
				
				RPMVersions = instance.sendCommand(rpmlist);							
				System.out.println("The version of RPMs are : \n" +RPMVersions);
				instance.close();

		} catch (Exception ce) {
			System.err
					.println("There is an error encountered during the connection process");
			ce.printStackTrace();
		} 
		return RPMVersions;
		
	}
	
	
	public String LogCollector(String HostIP, String sshUserName, String sshPassword, String TypeOfTest){
		
		Operations.OpserverName = HostIP;
		Operations.OpUserName = sshUserName;
		Operations.OpPassWord = sshPassword;
		Operations.Known_Hosts=System.getProperty("user.dir")+"\\"+pomTestApps.STAcore.POMSuiteRunner.FileName+"\\"+POMSuiteRunner.ConfigStore.get("_Known_hosts");
		
		if(OpserverName.isEmpty() || OpUserName.isEmpty() || OpPassWord.isEmpty()){
			throw new NullPointerException("The Credential should not be blank");
		}
		
		String logDir=LogDirectory;		
		String LogCollector = "tail -f /opt/jboss-4.2.2.GA/server/default/log/server.log >> /local/home/"+pomTestApps.STAcore.POMSuiteRunner.Admin_User+"/"+logDir+"/"+TypeOfTest+".log &";
		String ProcessCommand = "output=`ps aux | grep tail`;set -- $output;pid=$2;echo $2";
		
		
		try {
			SSHManager instance = new SSHManager(OpUserName, OpPassWord, OpserverName, Known_Hosts);
		    String errorMessage = instance.connect();
		    
		    if (errorMessage != null) {
				System.out
						.println("There is an error occured :"
								+ errorMessage);
			}
			
		    instance.sendCommand(LogCollector);
			LogProcess = instance.sendCommand(ProcessCommand);				
			

		} catch (Exception ce) {
			System.err
					.println("Connection is not Established.");
			ce.printStackTrace();
		} 
		return LogProcess;
		
	}
	
	public void ProcessKill(String HostIP, String sshUserName, String sshPassword, String ProcessID){
		
		Operations.OpserverName = HostIP;
		Operations.OpUserName = sshUserName;
		Operations.OpPassWord = sshPassword;
		Operations.Known_Hosts=System.getProperty("user.dir")+"\\"+pomTestApps.STAcore.POMSuiteRunner.FileName+"\\"+POMSuiteRunner.ConfigStore.get("_Known_hosts");
		
		if(OpserverName.isEmpty() || OpUserName.isEmpty() || OpPassWord.isEmpty()){
			throw new NullPointerException("The Credential should not be blank");
		}
		
		System.out.println("Killing the log collection process : "+ProcessID+"\n");
		String ProcessKiller = "kill -9 "+ProcessID;
		
		try {
			SSHManager instance = new SSHManager(OpUserName, OpPassWord, OpserverName, Known_Hosts);
		    String errorMessage = instance.connect();
		    
		    if (errorMessage != null) {
				System.out
						.println("There is an error occured :"
								+ errorMessage);
			}					
				instance.sendCommand(ProcessKiller);
				instance.close();

		} catch (Exception ce) {
			System.err
					.println("Connection is not Established.");
			ce.printStackTrace();
		} 		
		
	}
	
	public void CreateLogDir(String HostIP, String sshUserName, String sshPassword, String LogDirectoryName){
		
		Operations.OpserverName = HostIP;
		Operations.OpUserName = sshUserName;
		Operations.OpPassWord = sshPassword;
		Operations.Known_Hosts=System.getProperty("user.dir")+"\\"+pomTestApps.STAcore.POMSuiteRunner.FileName+"\\"+POMSuiteRunner.ConfigStore.get("_Known_hosts");
		
		if(OpserverName.isEmpty() || OpUserName.isEmpty() || OpPassWord.isEmpty()){
			throw new NullPointerException("The Credential should not be blank");
		}
		
		System.out.println("Creating the Directory : "+LogDirectoryName+"\n");
		String CreateDirectory = "mkdir "+LogDirectoryName;
		
		try {
			SSHManager instance = new SSHManager(OpUserName, OpPassWord, OpserverName, Known_Hosts);
		    String errorMessage = instance.connect();
		    
		    if (errorMessage != null) {
				System.out
						.println("There is an error occured :"
								+ errorMessage);
			}		
							
				instance.sendCommand(CreateDirectory);
				instance.close();
				
		} catch (Exception ce) {
			System.err
					.println("Connection is not Established.");
			ce.printStackTrace();
		} 	
		
	}
	
public void Initiate_EL6_Board(String HostIP, String sshUserName, String sshPassword){
		
	Operations.OpserverName = HostIP;
	Operations.OpUserName = sshUserName;
	Operations.OpPassWord = sshPassword;
	Operations.Known_Hosts=System.getProperty("user.dir")+"\\"+pomTestApps.STAcore.POMSuiteRunner.FileName+"\\"+POMSuiteRunner.ConfigStore.get("_Known_hosts");
		
		if(OpserverName.isEmpty() || OpUserName.isEmpty() || OpPassWord.isEmpty()){
			throw new NullPointerException("The Credential should not be blank");
		}
		
		String CreateEL6Board = "board_config -insert -bpos 1A-0-10 -boardid 118 -numind 16";
		
		try {
			SSHManager instance = new SSHManager(OpUserName, OpPassWord, OpserverName, Known_Hosts);
		    String errorMessage = instance.connect();
		    
		    if (errorMessage != null) {
				System.out
						.println("There is an error occured :"
								+ errorMessage);
			}		
							
				instance.sendCommand(CreateEL6Board);
				instance.close();
				System.out
						.println("The Board with position 1A-0-10 is Created on"
								+ OpserverName);
						
		} catch (Exception ce) {
			System.err
					.println("Connection is not Established.");
			ce.printStackTrace();
		} 		
	}

public void Initiate_Prereq_MicollabAM(int RouteNum, String _AM_IP_Address, int mwi_Number, int MailBoxMinLength, int MailBoxMaxLength, String TrunkIndex, String HostIP, String sshUserName, String sshPassword){
	
	Operations.OpserverName = HostIP;
	Operations.OpUserName = sshUserName;
	Operations.OpPassWord = sshPassword;
	Operations.Known_Hosts=System.getProperty("user.dir")+"\\"+pomTestApps.STAcore.POMSuiteRunner.FileName+"\\"+POMSuiteRunner.ConfigStore.get("_Known_hosts");
	//String CreateEL6Board = "board_config -insert -bpos 1A-0-10 -boardid 118 -numind 16";	

	if(OpserverName.isEmpty() || OpUserName.isEmpty() || OpPassWord.isEmpty()){
		throw new NullPointerException("The Credential should not be blank");
	}
		String CreateEL6Board = "board_config -insert -bpos 1A-0-10 -boardid 118 -numind 16";
		String ED = "mdsh -c number_initiate -number "+mwi_Number+" -numbertype ED;";
		String NumInitiate = "mdsh -c number_data_initiate -externalnumber "+mwi_Number+" -minlength "+MailBoxMinLength+" -maxlength "+MailBoxMaxLength+"\";\"";
		String ROCAI = "mdsh -c ROCAI:ROU="+RouteNum+",SEL=7110000000000010,SIG=0111110000A0,TRAF=03151515,TRM=4,SERV=3110000001,BCAP=000100"+"\";\"";
		String SIPUri = "\'\"sip:?@"+_AM_IP_Address+";tgrp=MiCAM";
		String sip_route = "mdsh -c -f sip_route -set -route "+RouteNum+" -profile MiCollabAM_TCP -uristring0 "+SIPUri+";tgrp=MiCAM\"' -accept REMOTE_IP -match "+_AM_IP_Address+" -mwinumber "+mwi_Number+"\";\"";
		String RODAI = "mdsh -c RODAI:ROU="+RouteNum+",TYPE=TL66,VARC=00000000,VARI=00000000,VARO=00000000"+"\";\"";
		String ROEQI = "mdsh -c ROEQI:ROU="+RouteNum+",TRU=\""+TrunkIndex+";\"";
		String RODDI = "mdsh -c RODDI:ROU="+RouteNum+",DEST="+mwi_Number+",ADC=0005000000000250000001010000,SRT=1"+"\";\"";
	
	try {
		SSHManager instance = new SSHManager(OpUserName, OpPassWord, OpserverName, Known_Hosts);
	    String errorMessage = instance.connect();
	    
	    if (errorMessage != null) {
			System.out
					.println("There is an error occured :"
							+ errorMessage);
		}		
						
			//instance.sendCommand(CreateEL6Board);
	    
	    	System.out.println("External Destination Creation is : " + instance.sendCommand(ED));
	    	System.out.println("Initiating Number Series : "+instance.sendCommand(NumInitiate));
	    	System.out.println("Initiating Route : " + instance.sendCommand(ROCAI));
	    	System.out.println("Making the route as SIP Route " + instance.sendCommand(sip_route));
	    	System.out.println("Initiating Destination : " + instance.sendCommand(RODAI));
	    	System.out.println("Assigning the Equipment to the Route : " + instance.sendCommand(ROEQI));
	    	System.out.println("Assigning the Route to the External Destination : " + instance.sendCommand(RODDI));
			instance.close();
			System.out
					.println("The Board with position 1A-0-10 is Created on"
							+ OpserverName);
					
	} catch (Exception ce) {
		System.err
				.println("Connection is not Established.");
		ce.printStackTrace();
	}
	}

public void Initiate_KL1_Board(String HostIP, String sshUserName, String sshPassword){
	
	Operations.OpserverName = HostIP;
	Operations.OpUserName = sshUserName;
	Operations.OpPassWord = sshPassword;
	Operations.Known_Hosts=System.getProperty("user.dir")+"\\"+pomTestApps.STAcore.POMSuiteRunner.FileName+"\\"+POMSuiteRunner.ConfigStore.get("_Known_hosts");
	
	String CreateEL6Board = "board_config -insert -bpos 1A-0-20 -boardid 117 -numind 16";
	
	if(OpserverName.isEmpty() || OpUserName.isEmpty() || OpPassWord.isEmpty()){
		throw new NullPointerException("The Credential should not be blank");
	}
	
	try {
		SSHManager instance = new SSHManager(OpUserName, OpPassWord, OpserverName, Known_Hosts);
	    String errorMessage = instance.connect();
	    
	    if (errorMessage != null) {
			System.out
					.println("There is an error occured :"
							+ errorMessage);
		}		
						
			instance.sendCommand(CreateEL6Board);
			instance.close();
			System.out
					.println("The Board with position 1A-0-20 is Created on"
							+ OpserverName);

	} catch (Exception ce) {
		System.err
				.println("Connection is not Established.");
		ce.printStackTrace();
	} 	
}




}
