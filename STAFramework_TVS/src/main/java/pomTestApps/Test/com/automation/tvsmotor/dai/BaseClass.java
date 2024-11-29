package pomTestApps.Test.com.automation.tvsmotor.dai;
/**************************************************
#Project Name: MiTEL_CLEARSPAN - Selenium Framework



#class Name: BaseClass()
#Description:1. This will redirect to property file
#Input Parameters:File Path,Test Class Name
#Owner: Virupakshayya Kulkarni
#Author: Virupakshayya Kulkarni
#Date of creation: 12-Oct-2017
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/
import java.io.IOException;

import org.testng.annotations.BeforeMethod;

import pomTestApps.BaseTestType;




public class BaseClass extends BaseTestType {

	

	@BeforeMethod()
	public void beforemethod() throws IOException {
		super.beforeMethod();

	}



	@Override
	public void setPropertyFileName() {
		super.setPropertyFileName(pomTestApps.STAcore.POMSuiteRunner.PropertyName);
	
		
	}

}
