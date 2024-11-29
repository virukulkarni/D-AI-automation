package pomTestApps.Utility.STAcore.io;
/**************************************************
#Project Name: MiTEL_MXONE - Selenium Framework


#Function Name: readProperties()
#Description:1. This function reads the property File containing the static data.
#Input Parameters:File Path,Test Class Name
#Owner: Ashis Kumar Pradhan
#Author: Ashis Kumar Pradhan
#Date of creation: 03-July-16
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/
import java.io.FileOutputStream;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.google.common.io.Resources;

import pomTestApps.Utility.STAcore.reportwriter.*;

public class ReadProperties {
	String strFilename;
	String strreportPath;
	String strsuiteName;
	String strscreenShotOnFail;

	int intimplicitWaitTime;
	String strsrcFolder;
	private int intpageLoadTimeOut;
	String baseUrl;
	String userName;
	String password;
	String envdetails;
	String solution;
	String urlType;

	public ReadProperties(String strFilename) throws IOException {
		this.strFilename = strFilename;
		readPropFile();
	}

	private void readPropFile() throws IOException {
		Properties prop = new Properties();
		FileReader file = new FileReader(Resources.getResource("AUTOMATION.properties").getPath());
//		FileReader file = new FileReader(strFilename + ".properties");
		prop.load(file);
		strreportPath = prop.getProperty("reportPath");		
		strsuiteName = prop.getProperty("suiteName");
		strscreenShotOnFail = prop.getProperty("screenShotOnFail");
		intimplicitWaitTime = Integer.parseInt(prop.getProperty("waitTime"));
		strsrcFolder = prop.getProperty("srcFolder");
		intpageLoadTimeOut = Integer.parseInt(prop
				.getProperty("pageLoadTimeOut"));
		baseUrl = prop.getProperty("baseUrl");
		userName = prop.getProperty("userName");
		password = prop.getProperty("password");
		urlType = prop.getProperty("urlType");
		if(prop.getProperty("environment")==null){	
			System.out.println("The value is null for environment");
			prop.put("environment", "");
			FileOutputStream fileOut = new FileOutputStream(strFilename + ".properties");
			prop.store(fileOut, "");
			fileOut.close();
		}
		else{
			System.out.println("No value for environment Present");
			envdetails=prop.getProperty("environment");
			GeneratePDFReport.arr_testEnvironment=envdetails;
			System.out.println("environment Name is    "+envdetails);
		}
		if(prop.getProperty("solution")==null){	
			System.out.println("The value is null for Solution");
			prop.put("solution", "");
			FileOutputStream fileOut = new FileOutputStream(strFilename + ".properties");
			prop.store(fileOut, "");
			fileOut.close();
		}
		else{
			System.out.println("No value for Solution Present");
			solution=prop.getProperty("solution");
			GeneratePDFReport.arr_testSolution=solution;
			System.out.println("Solution Name is    "+envdetails);
		}
		
	}

	public int getimplicitWait() {
		return intimplicitWaitTime;
	}
		
	public int getpageLoadTimeOut() {
		return intpageLoadTimeOut;
	}

	public String getreportPath() {
		return strreportPath;
	}

	public String getsuiteName() {
		return strsuiteName;
	}

	public String getscreenShotcriteria() {
		return strscreenShotOnFail;
	}

	public String getsrcFolder() {
		return strsrcFolder;
	}

	public String getbaseurl() {
		return baseUrl;
	}

	public String getuserName() {
		return userName;
	}

	public String getpassword() {
		return password;
	}
	
	public String getUrlType(){
		return urlType;
	}
	
}
