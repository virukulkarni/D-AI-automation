package pomTestApps.STAcore;

/**************************************************
#Project Name: TVS MOTOR - Selenium Framework



#Test case Name: Operations Executor
#Description:1. This Implementation helps in executing Add on features like ssh, ftp, Linux command executions.
#Input Parameters:File Path,Test Class Name
#Owner: Naveen Kumar Punnana
#Author: Naveen Kumar Punnana
#Date of creation: 21-Oct-16
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/

import java.util.Hashtable;
import java.util.StringTokenizer;

import pomTestApps.STAcore.Operations;


public class OperationExecutor extends Operations {
	
	
	public static Hashtable<String,String> AttributeValuelist = new Hashtable<String,String>();
	public static String Attribute="";
	public static String Attributelist="";
	public static String Version="";
	public static String known_hosts=POMSuiteRunner.ConfigStore.get("_Known_hosts");
	
	
	public void getAppVersion(String HostIP, String HostUserName, String HostPassword) {
		// TODO Auto-generated method stub
		
		Operations oprs = new Operations();
		
		 try{
		String Version=oprs.getApplicationVersion(HostIP, HostUserName, HostPassword);
		
		if (Version!=null && Version.endsWith("\n")){			
			Version = Version.trim();
			Version = Version.replace("\n", ",");
			
			System.out.println("The version of RPMs are : \n" +Version);
			
			if((Version.indexOf(",")> 0)||Version.indexOf(",")< 0)
			{
				
			StringTokenizer sTokenizer= new StringTokenizer(Version, ",");
			
			while(sTokenizer.hasMoreElements())
			{
				//dataList.add(sTokenizer.nextElement());
				String tempVariable = sTokenizer.nextElement().toString();
				String Attribute=tempVariable.split("-")[0];
				String AttributeValue=tempVariable.split("-")[1]+"-"+tempVariable.split("-")[2];
				System.out.println("Attributes are : "+Attribute+"\n");
				System.out.println("Values are : "+AttributeValue+"\n");
				AttributeValuelist.put(Attribute, AttributeValue);
			}
			}
			else
			{			
				System.out.println("There is no data.");
			}
		}else{
			System.out.println("There is no data.");
		}
		 }finally{
			 System.out.println("Execution Completed.");
		 }
	}

}

