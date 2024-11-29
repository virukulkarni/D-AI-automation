package pomTestApps;
/**************************************************
#Project Name: MiTEL_MXONE - Selenium Framework


#Class Name: SuiteRunner()
#Description:This Class responsible for running the test cases in a suite
#Input Parameters:
#Owner: Ashis Kumar Pradhan
#Author: Ashis Kumar Pradhan
#Date of creation: 03-July-16
#Name of person modifying: (Tester Name): Naveen Kumar Punnana
#Date of modification: Changed the core implementation of Test Suite with respect to hashmap implementation.
‘**************************************************/
import java.io.File;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.Utility.STAcore.io.Log;
import pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport;


public class SuiteRunner {
	public static List<XmlClass> myClasses = new ArrayList<XmlClass> ();
	POMSuiteRunner SRunner = new POMSuiteRunner();
	static Boolean suiteRun=false;
	static int testCount=0;
	XmlSuite mySuite = new XmlSuite();
	List<XmlTest> myTestsjp = new ArrayList<XmlTest>();
	XmlTest myTest;
	
	private static ArrayList<String> groups = new ArrayList<String>();
    public String testPlanName;
	public void run() throws Exception  {
		suiteRun=true;
		try {
				TestNG myTestNG = new TestNG();
				
				XmlSuite mySuite = new XmlSuite();
				mySuite.setName(pomTestApps.STAcore.POMSuiteRunner.Sname);
				XmlTest myTest = new XmlTest(mySuite);
				myTest.setName(pomTestApps.STAcore.POMSuiteRunner.Sname);
			
			    int tcscount = SRunner.TestSuite.size();
			    while(testCount<tcscount)			    	
			    {
			    	String tc = String.valueOf(testCount);
			    	myClasses.add(new XmlClass(SRunner.packageName+"."+SRunner.TestSuite.get(tc)));
			    	System.out.println(SRunner.TestSuite.get(tc));
			    	testCount++;
			    }
		
			//Assign that to the XmlTest Object created earlier.
			    myTest.setXmlClasses(myClasses);
			
			//Add the suite to the list of suites.
			    List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
			    mySuites.add(mySuite);
			    
			//Set the list of Suites to the testNG object you created earlier.
			    myTestNG.setXmlSuites(mySuites);
			    
			//invoke run() - this will run your class.
			    myTestNG.run();    
 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public void addtest(XmlSuite Suite, List<XmlTest> myTests){
		
		String testName="testName"+testCount;
		XmlTest myTest = new XmlTest(Suite);
		int tcscount1 = SRunner.TestSuite.size();
		int tcCount=0;
	    while(tcCount<tcscount1)			    	
	    {
	    	String tc = String.valueOf(tcCount);
	    	myTest.setName(SRunner.TestSuite.get(tc));
	    	myTests.add(myTest);
	    	System.out.println("Test Case Name Is: "+SRunner.TestSuite.get(tc));
	    	tcCount++;
	    }
		
		myClasses.removeAll(myClasses);
		
	}
}
