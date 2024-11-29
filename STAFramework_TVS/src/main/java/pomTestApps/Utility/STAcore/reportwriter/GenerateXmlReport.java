package pomTestApps.Utility.STAcore.reportwriter;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.google.common.io.Resources;

import jxl.write.Label;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class GenerateXmlReport {
	
	String projectPath;
	File[] listOfFolders;
	String[] arrTcDesc;
	String[] arrTcId;
	String[] teststatus;
	String arr_testSolution;
	public static Attr attr;
	public static Element rootElement, testcase;
	
	public GenerateXmlReport(String projectPath,File[] listOfFolders,String[] arrTcId, String[] arrTcDesc, String[] teststatus, String arr_testSolution){
		this.projectPath=projectPath;
		this.listOfFolders=listOfFolders;
		this.arrTcId = arrTcId;
		this.arrTcDesc=arrTcDesc;		
		this.teststatus=teststatus;
		this.arr_testSolution=arr_testSolution;
	}

    void generatexml() throws IOException, RowsExceededException, WriteException {
    	
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("testsuite");
            doc.appendChild(rootElement);
        	
        	Attr attr = doc.createAttribute("xmlns:xsi");
            attr.setValue("http://www.w3.org/2001/XMLSchema-instance");
            rootElement.setAttributeNode(attr);


        	attr = doc.createAttribute("xsi:noNamespaceSchemaLocation");
            attr.setValue("https://maven.apache.org/surefire/maven-surefire-plugin/xsd/surefire-test-report.xsd");
            rootElement.setAttributeNode(attr);

        	attr = doc.createAttribute("name");
            attr.setValue("com.OpeasyTest");
            rootElement.setAttributeNode(attr);

        	attr = doc.createAttribute("time");
            attr.setValue("0.036");
            rootElement.setAttributeNode(attr);

        	attr = doc.createAttribute("tests");
            attr.setValue("5");
            rootElement.setAttributeNode(attr);

        	attr = doc.createAttribute("errors");
            attr.setValue("0");
            rootElement.setAttributeNode(attr);	
        	
        	attr = doc.createAttribute("skipped");
            attr.setValue("0");
            rootElement.setAttributeNode(attr);	
        	
        	attr = doc.createAttribute("failures");
            attr.setValue("1");
            rootElement.setAttributeNode(attr);	
            
            
            
            //Create test case Element
            
//            String name = "StoreBilling_13";            
//            String tcstatus = "PASS";
            
//            getTestcaseElements(doc, testcase, name, tcstatus);
//            rootElement.appendChild(testcase);
//            
//            testcase = doc.createElement("testcase");
//            name = "StoreBilling_12";            
//            tcstatus = "FAIL";
//            
//            getTestcaseElements(doc, testcase, name, tcstatus);
//            
//            rootElement.appendChild(testcase);
            String tcname = "";
            String tcstatus = "";
        	
            for (int i = 0; i < listOfFolders.length; i++) {
    			int j=i+1;
//    			Label label0 = new Label(0, j, String.valueOf(j));			
//    			Label label1tcid= new Label(1, j, arrTcId[i]);
    			tcname = listOfFolders[i].getName();
//    			Label label2 = new Label(3, j, arrTcDesc[i]);
    			tcstatus = teststatus[i];
//    			Label label3 = new Label(4, j, arr_testSolution);
    			
    			
    			testcase = doc.createElement("testcase");
    			getTestcaseElements(doc, testcase, tcname, tcstatus);
    			rootElement.appendChild(testcase);    			

    		}
            
            
        	// shorten way
            // testcase.setAttribute("id", "1");


            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();	
            DOMSource source = new DOMSource(doc);
            
//            String strFWPath = (String) System.getProperty("user.dir");
            
            File strFWPath = new File(Resources.getResource("cucumber\\json").getPath());
            
            StreamResult result = new StreamResult(strFWPath + "SuiteExecutionReport.xml");
        	

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

          } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
          } catch (TransformerException tfe) {
            tfe.printStackTrace();
          }
        
//        try {
//        	
//    		// Generating XML report for the consumption of Qmetry
//        	
//            dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.newDocument();
//            //add elements to Document
//            Element rootElement =
//                doc.createElementNS("https://www.journaldev.com/employee", "testsuite");
//            //append root element to document
//            doc.appendChild(rootElement);
//
//            //append first child element to root element
//            rootElement.appendChild(getTestsuite(doc, "123456", "StoreBilling_1", "PASS"));
//            rootElement.appendChild(getTestsuite(doc, "786587", "StoreBilling_2", "FAIL"));
//
//            //append second child
////            rootElement.appendChild(getTestcases(doc, "2", "Lisa", "35", "Manager", "Female"));
//
//            //for output to file, console
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            
//            //for pretty print
//            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//            DOMSource source = new DOMSource(doc);
//
//            //write to console or file
//            StreamResult console = new StreamResult(System.out);
//            StreamResult file = new StreamResult(new File("C:\\Automation\\WorkspaceNew\\STAFramework_NewUI\\cucumber\\json\\"+"SuiteExecutionReport.xml"));
//
//            //write data
//            transformer.transform(source, console);
//            transformer.transform(source, file);
//            System.out.println("DONE");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    //utility method to create text node
    public static Node getTestcaseElements(Document doc, Element element, String tcname, String tcstatus) {
    	 // testcase elements
        
        // set attribute to testcase element
        attr = doc.createAttribute("name");
        attr.setValue(tcname);
        testcase.setAttributeNode(attr);
    	
    	attr = doc.createAttribute("classname");
        attr.setValue(tcname);
        testcase.setAttributeNode(attr);
    	
    	attr = doc.createAttribute("time");
        attr.setValue("0.007");
        testcase.setAttributeNode(attr);
        
        if (tcstatus.equalsIgnoreCase("PASS"))
        {

        	Element testmethod = doc.createElement("test-method");
//        	testcase.appendChild(testmethod);

        	attr = doc.createAttribute("status");
            attr.setValue("PASS");
            testmethod.setAttributeNode(attr);	
        	
        	attr = doc.createAttribute("name");
            attr.setValue(tcname);    
        	testmethod.setAttributeNode(attr);
        	
        	attr = doc.createAttribute("started-at");
            attr.setValue("2007-05-28T12:14:37Z");    
        	testmethod.setAttributeNode(attr);
        	
        	attr = doc.createAttribute("description");
            attr.setValue("someDescription1");    
        	testmethod.setAttributeNode(attr);
        	
        	attr = doc.createAttribute("finished-at");
            attr.setValue("2007-05-28T12:14:37Z");    
        	testmethod.setAttributeNode(attr);
        	testcase.appendChild(testmethod);
        	
        	
        	Element systemout = doc.createElement("system-out");
        	testcase.appendChild(systemout);
        }
        
        if (tcstatus.equalsIgnoreCase("FAIL")){
        	Element ele = doc.createElement("failure");
        	testcase.appendChild(ele);

        	ele = doc.createElement("system-out");
        	testcase.appendChild(ele);
        	
        	
        	
        }
        return testcase;
    }

}
