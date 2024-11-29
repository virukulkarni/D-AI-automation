package pomTestApps.Utility.STAcore.reportwriter;

/**************************************************
#Project Name: TVS MOTOR - Selenium Framework

#Function Name: GenerateHtmlReport()
#Description:1.  This method is responsible for generating the customized HTMLReport report
#Input Parameters:
#Owner: Viru Kulkarni
#Author: Viru Kulkarni
#Date of creation: 03-July-16
#Name of person modifying: (Tester Name): Virupakshayya Kulkarni
#Date of modification: Modified the report for accomodating CS-One versions from the SUT as a part of demo feedback.
‘**************************************************/
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.common.io.Resources;
import com.itextpdf.text.DocumentException;

import pomTestApps.ProcessTestRequest;
import pomTestApps.BaseTestType.*;
import pomTestApps.STAcore.OperationExecutor;
import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.STAcore.XL_Reader;
import pomTestApps.Utility.STAcore.io.Log;
import pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport;

public class GenerateHtmlReport {

	OperationExecutor OprExec = new OperationExecutor();
	POMSuiteRunner CLEARSPAN = new POMSuiteRunner();

	List<String[]> stepsDetails = new ArrayList<String[]>();
	String[] stepDetails = new String[4];
	List<String> htmlrep = new ArrayList<String>();
	List<String> htmlrepsuite = new ArrayList<String>();
	static String coordinateList;
	static List<String> status = new ArrayList<String>();
	static int count = 1;
	int serielNo;
	boolean flag_Complete = false;

	File[] listOfFolders;
	String[] teststatus;
	String[] arrTcDesc;
	String[] arrTcId;

	static GeneratePDFReport gpr = new GeneratePDFReport();

	public void isTestComplete(Boolean val) {
		flag_Complete = val;
	}

	public void createSuiteReport(String projectPath, Date startTime, Date endTime) {

		if (count > 1) {
			return;
		}
		count++;
		Log.info("************************************************************");
		Log.info("-         Inside Create Suite Report                        -");
		Log.info("          Start time is :                        " + startTime);
		Log.info("          End time is :                          " + endTime);
		String htmlFile = projectPath + "\\report.html";
		Log.info("          File name :                             " + htmlFile);
		long diff = endTime.getTime() - startTime.getTime();
		int diffsec = (int) (diff / (1000));
		int min = diffsec / 60;
		int sec = diffsec % 60;
		Log.info(min + "." + sec);

		Log.info("Differnece is " + diff);
		int j = 0;
		File folder = null ;
		try {

			try {
				folder = new File(projectPath);
			} catch (Exception ex) {
				System.out.println(ex.toString());
			}
			listOfFolders = folder.listFiles();
			String testCases[] = new String[listOfFolders.length];
			teststatus = new String[listOfFolders.length];
			arrTcId = new String[listOfFolders.length];
			arrTcDesc = new String[listOfFolders.length];
			Log.info("NO of folders " + listOfFolders.length);
			for (int i = 0; i < listOfFolders.length; i++) {
				if (listOfFolders[i].isDirectory()) {
					System.out.println(listOfFolders[i].getName());
					testCases[i] = listOfFolders[i].getName();
					File[] listOfFiles = listOfFolders[i].listFiles();
					for (j = 0; j < listOfFiles.length; j++) {
						if (listOfFiles[j].isFile()) {
							if (listOfFiles[j].getName().equalsIgnoreCase("status.txt")) {
								FileInputStream fstream = new FileInputStream(projectPath + "\\"
										+ listOfFolders[i].getName() + "\\" + listOfFiles[j].getName());
								DataInputStream in = new DataInputStream(fstream);
								BufferedReader br = new BufferedReader(new InputStreamReader(in));
								String strLine;

								if ((strLine = br.readLine()) != null) {
									String[] data = strLine.split("###");
									teststatus[i] = data[0];
									arrTcId[i] = data[1];
									arrTcDesc[i] = data[2];
								}
								in.close();
							}
						}

					}
				}
			}
			htmlrepsuite.add("<!DOCTYPE html>");
			htmlrepsuite.add("<html>");
			htmlrepsuite.add("<head>");
			htmlrepsuite.add("<style>");
			htmlrepsuite.add("#header {");
			htmlrepsuite.add("background-color:black;");
			htmlrepsuite.add("color:white;");
			htmlrepsuite.add("text-align:center;");
			htmlrepsuite.add("padding:5px;}");
			htmlrepsuite.add("#article {");
			htmlrepsuite.add("width:350px;");
			htmlrepsuite.add("float:left;");
			htmlrepsuite.add("text-align:center;");
			htmlrepsuite.add("padding:10px;}");
			htmlrepsuite.add("#footer {");
			htmlrepsuite.add(" background-color:black;");
			htmlrepsuite.add("color:white;");
			htmlrepsuite.add("clear:both;");
			htmlrepsuite.add("text-align:center;");
			htmlrepsuite.add("position: relative;");
			htmlrepsuite.add("bottom:0;");
			htmlrepsuite.add("right: 0;");
			htmlrepsuite.add("left: 0;");
			htmlrepsuite.add("height:30px;}");
			htmlrepsuite.add("table, th, td {");
			htmlrepsuite.add("border: 1px solid black;");
			htmlrepsuite.add("border-collapse: collapse;");
			htmlrepsuite.add("text-align:center}");
			htmlrepsuite.add("th, td {padding: 5px;}</style>");
			htmlrepsuite.add("</head>");
			htmlrepsuite.add("<body>");
			htmlrepsuite.add("<div id=\"wrapper\">");

			// Begining of the header.

			htmlrepsuite.add("<div id=\"header\">");
			htmlrepsuite.add(
					"<img src=\".\\img\\TVS_Motor_Company_Logo.png\" alt=\"HTML6 Icon\" style=\"width:130px;height:98px\" align=\"left\">");
			htmlrepsuite.add(
					"<img src=\".\\img\\MXONE.jpg\" alt=\"HTML5 Icon\" style=\"width:130px;height:98px\" align=\"right\">");
			htmlrepsuite
					.add("<h1 align=\"center\"> TVS MOTOR TEST AUTOMATION REPORT <br>Suite - " + POMSuiteRunner.suiteName +"</h1>");
			htmlrepsuite.add("<br></div>");

			// Begining of Time Stamp Section.

			htmlrepsuite.add("<div id=\"Section\">");
			htmlrepsuite.add("<br><br>");
			htmlrepsuite.add("<span align=\"center\"> <b> Execution Start Time: " + startTime + "</b></span>");
			htmlrepsuite.add(
					"<br><span align=\"center\"> <b>Execution Time: " + min + " mins:" + sec + " secs </b></span>");
			htmlrepsuite.add("<br><span align=\"center\"><b> Execution End Time: " + endTime + "</b></span>");
			htmlrepsuite.add("</div>");

		//	String strSUTVersion = POMSuiteRunner.strSUTReleaseName + " "
			//		+ pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.strAUTBuildInfo;
			
			String strSUTVersion = pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.strAUTBuildInfo;

			// Begining of Version.

			htmlrepsuite.add("<div id=\"Version\">");
			htmlrepsuite.add("<br><br>");
			htmlrepsuite.add("<table style=\"width:100%\" align=\"center\">");
			htmlrepsuite.add("<tr>");
			htmlrepsuite.add("<th>Application Tested</th>");
			htmlrepsuite.add("<th>Version</th>");
			htmlrepsuite.add("</tr>");
			htmlrepsuite.add("<tr>");
		//	htmlrepsuite.add("<td>"
		//			+ POMSuiteRunner.strSUTReleaseName
		//			+ "</td>");
			htmlrepsuite.add("<td>" + strSUTVersion + "</td>");
			htmlrepsuite.add("</tr>");

			htmlrepsuite.add("</table>");
			htmlrepsuite.add("</div>");

			htmlrepsuite.add("<div id=\"Section\">");
			htmlrepsuite.add("<br><br>");
			htmlrepsuite.add("<table style=\"width:100%\" align=\"center\">");
			htmlrepsuite.add("<tr>");
			htmlrepsuite.add("<th>Sl.No</th>");
			htmlrepsuite.add("<th>Test Case ID</th>");
			htmlrepsuite.add("<th>Test Case Details</th>");
			htmlrepsuite.add("<th>Test Case Description</th>");
			htmlrepsuite.add("<th>Status</th>");

			htmlrepsuite.add("</tr>");

			for (int i = 0; i < listOfFolders.length; i++) {
				Log.info("Value of I" + i);
				htmlrepsuite.add("<tr>");
				htmlrepsuite.add("<td>" + (i + 1) + "</td>");

				htmlrepsuite.add("<td>");
				htmlrepsuite.add(arrTcId[i]);
				htmlrepsuite.add("</td>");

				htmlrepsuite.add("<td>");
				htmlrepsuite.add("<a href=.\\" + listOfFolders[i].getName() + "\\" + listOfFolders[i].getName()
						+ ".html>" + listOfFolders[i].getName() + "</a>");
				htmlrepsuite.add("</td>");

				htmlrepsuite.add("<td>");
//				htmlrepsuite.add("<a href=.\\" + listOfFolders[i].getName() + "\\" + listOfFolders[i].getName()
//						+ ".html>" + listOfFolders[i].getName() + " - " + arrTcDesc[i] + "</a>");
				htmlrepsuite.add("<a href=.\\" + listOfFolders[i].getName() + "\\" + listOfFolders[i].getName()
						+ ".html>" + arrTcDesc[i] + "</a>");
				htmlrepsuite.add("</td>");

				if (teststatus[i].equalsIgnoreCase("Pass")) {
					htmlrepsuite.add("<td bgcolor=\"green\">" + teststatus[i] + "</td>");
				} else if (teststatus[i].equalsIgnoreCase("Fail")) {
					htmlrepsuite.add("<td bgcolor=\"red\">" + teststatus[i] + "</td>");
				} else if (teststatus[i].equalsIgnoreCase("Incomplete")) {
					htmlrepsuite.add("<td bgcolor=\"darkorange\">" + teststatus[i] + "</td>");
				}
				// else if (teststatus[i].equalsIgnoreCase("Fail")){

				else {
					htmlrepsuite.add("<td bgcolor=\"yellow\">" + teststatus[i] + "</td>");
				}

				//

				htmlrepsuite.add("</tr>");

			}

			htmlrepsuite.add("</table>");
			htmlrepsuite.add("</div>");
			htmlrepsuite.add("<br><br><br><br>");
			htmlrepsuite.add("<div id=\"footer\">");
			htmlrepsuite.add("Copyright @ Mitel.com");
			htmlrepsuite.add("</div>");
			htmlrepsuite.add("</div>");
			htmlrepsuite.add("</body>");
			htmlrepsuite.add("</html>");
			File file = new File(htmlFile);
			if (!file.exists()) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				for (int num_tcs = 0; num_tcs < htmlrepsuite.size(); num_tcs++) {
					bw.write(htmlrepsuite.get(num_tcs));
				}

				bw.close();
			}
			System.out.println("Successfully generated the report.html file in this location  " + projectPath);

			Log.info("-          Create Suite Report    - ENDS                    -");
			Log.info("************************************************************");
			File repfile = new File(projectPath);
			try {
				repfile.mkdirs();
			} catch (Exception ex) {
				System.out.println(ex.toString());
			}
//			File source = new File(".\\img");
			File source = new File(Resources.getResource("img").getPath());
			File dest = new File(repfile + "\\img");
			try {
				FileUtils.copyDirectory(source, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		gpr.setListofFolder(listOfFolders);
		gpr.setarrTcDesc(arrTcDesc);
		gpr.setarrTcId(arrTcId);
		gpr.settestStatus(teststatus);

		try {
			gpr.createPDF(projectPath, startTime, endTime);
		} catch (IOException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Create JSON report 
		/*
		 * 
		 * {
			"name": "name of suite",
			"description": "some description",
			"results": [
				{
					"build": "buildId",
					"timestamp": "timings",
					"total": "number of test cases",
					"passed": "number of test cases passed",
					"failed": "number of test cases failed",
					"percentage": " pass %%",
					"description": "some description",
					"webapp": {
						"version": "app version",
						"url": "application url",
						"name": "name of the app",
						"description": "some description"
					}
				}
				]
			}
		 */

	}

	public void createTestReport(ArrayList<ArrayList<String[]>> testDetails, ArrayList<String> browserlist,
			String reportPath, String tcId, String tcName, String tcDescription) throws IOException, InvocationTargetException {
		System.out.println("Inside create TestReprot********");

		Log.info("************************************************************");
		Log.info("-         Inside Create Test Report                        -");
		Log.info("           Test Case ID :              " + tcId);
		Log.info("           Test Case Name :              " + tcName);
		String testCaseStatus = "Pass";
		Boolean notRun = true;
		// HTML REPORT FOR TEST CASE
		htmlrep.add("<!DOCTYPE html>");
		htmlrep.add("<html>");
		htmlrep.add("<head>");
		htmlrep.add("<style>");
		htmlrep.add("#header {");
		htmlrep.add("background-color:black;");
		htmlrep.add("color:white;");
		htmlrep.add("text-align:center;");
		htmlrep.add("padding:5px;}");
		htmlrep.add("#article {");
		htmlrep.add("width:350px;");
		htmlrep.add("float:left;");
		htmlrep.add("text-align:center;");
		htmlrep.add("padding:10px;}");
		htmlrep.add("#footer {");
		htmlrep.add(" background-color:black;");
		htmlrep.add("color:white;");
		htmlrep.add("clear:both;");
		htmlrep.add("text-align:center;");
		htmlrep.add("position: relative;");
		htmlrep.add("bottom:0;");
		htmlrep.add("right: 0;");
		htmlrep.add("left: 0;");
		htmlrep.add("height:30px;}");
		htmlrep.add("table, th, td {");
		htmlrep.add("border: 1px solid black;");
		htmlrep.add("border-collapse: collapse;");
		htmlrep.add("text-align:center}");
		htmlrep.add("th, td {padding: 5px;}</style>");
		htmlrep.add("</head>");
		htmlrep.add("<body>");
		htmlrep.add("<div id=\"wrapper\">");
		htmlrep.add("<div id=\"header\">");
		htmlrep.add(
				"<img src=\"img\\TVS_Motor_Company_Logo.png\" alt=\"HTML5 Icon\" style=\"width:130px;height:98px\" align=\"left\">");
		htmlrep.add(
				"<img src=\"img\\MXONE.jpg\" alt=\"HTML5 Icon\" style=\"width:130px;height:98px\" align=\"right\">");
		htmlrep.add("<h1 align=\"center\">REGRESSION TEST REPORT</h1>");
		htmlrep.add("<br>");
		htmlrep.add(
				"</div><div id=\"section\">Executed On: <span id=\"date\"></span><script>document.getElementById(\"date\").innerHTML = Date();</script>");
		htmlrep.add(
				"</div><div id=\"Version\">Executed On: <span id=\"date\"></span><script>document.getElementById(\"date\").innerHTML = Date();</script>");

		htmlrep.add("<div id=\"report\" class=\"container\">");
		htmlrep.add("<h2 align=\"center\">TEST CASE ID :" + tcName + "</h2>");
		htmlrep.add("<br>");
		htmlrep.add("<h2 align=\"center\">TEST CASE NAME :" + tcDescription + "</h2>");
		htmlrep.add("</div>");

		for (int numOfTests = 0; numOfTests < testDetails.size(); numOfTests++) {
			stepsDetails = testDetails.get(numOfTests);
			Log.info("No of steps are " + stepsDetails.size());
			htmlrep.add("<div id=\"section\">");
			if (pomTestApps.BaseTestType.suiteName != "TestSetup") {
				htmlrep.add("<h3 align=\"center\">BROWSER : " + browserlist.get(numOfTests).toUpperCase() + "</h3>");
			}
			htmlrep.add("<p>");
			htmlrep.add("<table style=\"width:100%\" align=\"center\">");
			htmlrep.add("<tr>");
			htmlrep.add("<th  bgcolor=\"DarkTurquoise\">Sl.No </th>");
			htmlrep.add("<th  bgcolor=\"DarkTurquoise\">Test Step Desc</th>");
			htmlrep.add("<th  bgcolor=\"DarkTurquoise\">Status</th>");
			htmlrep.add("<th  bgcolor=\"DarkTurquoise\">Screenshot</th>");
			htmlrep.add("</tr>");

			for (int i = 0; i < stepsDetails.size(); i++) {
				serielNo = i + 1;
				htmlrep.add("<tr>");
				htmlrep.add("<td>" + serielNo + "</td>");
				htmlrep.add("<td>" + stepsDetails.get(i)[0] + "</td>");
				if (stepsDetails.get(i)[1].equalsIgnoreCase("Pass")) {
					htmlrep.add("<td bgcolor=\"green\">" + stepsDetails.get(i)[1] + "</td>");
					notRun = false;
				} else if (stepsDetails.get(i)[1].contains("Fail")) {
					htmlrep.add("<td bgcolor=\"red\">" + stepsDetails.get(i)[1] + "</td>");
					testCaseStatus = "Fail";
					notRun = false;
				} else {
					htmlrep.add("<td bgcolor=\"blue\">" + stepsDetails.get(i)[1] + "</td>");
					// testCaseStatus = "Fail";
					notRun = false;
				}
				if (pomTestApps.BaseTestType.suiteName != "TestSetup") {
					htmlrep.add("<td><a href=\"./" + browserlist.get(numOfTests) + "/screenshots/" + serielNo
							+ ".png\">SCREENSHOT</a></td>");
				}
				htmlrep.add("</tr>");

			}
			htmlrep.add(" </table></p></p>");
			htmlrep.add("</div>");
		}
		htmlrep.add("</div>");
		htmlrep.add("<div id=\"footer\">");
		htmlrep.add("Copyright @ www.mitel.com");
		htmlrep.add("</div>");
		htmlrep.add("</body>");
		htmlrep.add("</html>");
		
		File file = new File(reportPath);
		System.out.println("report Path inside create test report " + reportPath);
		file.mkdirs();
		
		File source = new File(Resources.getResource("img").getPath());

		System.out.println("source path ..... report " + source);
		File dest = new File(file + "\\img");
		try {
			FileUtils.copyDirectory(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

//		File file = new File(reportPath);
//		System.out.println("report Path inside create test report " + reportPath);
//		file.mkdirs();
//		File source = new File(Resources.getResource("img").getPath());				
//		System.out.println("source path ..... report " + source);
//		
//		File dest = new File(Resources.getResource("img").getPath());		
//		System.out.println("destination path ..... report " + dest);
//		
//		 try {
//	            FileUtils.copyDirectory(source, dest);
//	            System.out.println("Directory copied successfully.");
////	        } catch (InvocationTargetException e) {
////	            Throwable cause = e.getCause();
////	            System.out.println("Cause: " + cause.getMessage());
////	            cause.printStackTrace();
//	        } catch (Exception e) {
//	            System.out.println("IO Exception occurred: " + e.getMessage());
//	            e.printStackTrace();
//	        }

		int newNumOfOccurance = (int) ProcessTestRequest.tcInvocation.get(tcName);
		if (newNumOfOccurance > 0) {

			tcName = tcName + "_" + newNumOfOccurance;
		}
		FileWriter f1 = new FileWriter(file + "\\" + tcName + ".html");
		FileWriter f2 = new FileWriter(file + "\\status.txt");
		if (notRun == false) {
			if (testCaseStatus.contains("Fail")) {
				f2.write("Fail");
			} else {
				if (flag_Complete == false) {
					f2.write("Incomplete");
				} else {
					f2.write(testCaseStatus);
				}
			}
		}

		else {
			f2.write("NotRun");
		}
		f2.write("###");

		f2.write(tcId);

		f2.write("###");

		f2.write(tcDescription);
		for (int j = 0; j < htmlrep.size(); j++) {
			f1.write(htmlrep.get(j));

		}
		f1.close();
		f2.close();
		Log.info("-          Create Test Report For  " + tcName + "   - ENDS                    -");
		Log.info("*****************************************************************************");

	}
}
