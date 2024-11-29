package pomTestApps.Utility.STAcore.mail;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import pomTestApps.STAcore.POMSuiteRunner;

public class MailSender {

		public static String reportPath;
		public static void SendMail(String to) throws IOException, MessagingException {
	      Properties prop = System.getProperties();
	      FileReader file = new FileReader(pomTestApps.STAcore.POMSuiteRunner.PropertyName+".properties");
	      prop.load(file);
	      
	      final String username = prop.getProperty("from.mail.id");				//change accordingly
	      final String password = POMSuiteRunner.strEmailPassword;	;		//change accordingly
		  prop.put("mail.smtp.host",prop.getProperty("mail.smtphost"));
	      prop.put("mail.smtp.port", prop.getProperty("mail.port"));
	      prop.put("mail.smtp.auth", "flase");
	      prop.put("mail.smtp.starttls.enable", "false");
	      prop.put("mail.smtp.requirestarttls.enable", "false");

	      // Get the Session object.
	      Session session = Session.getInstance(prop,
	         new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
	            }
	         });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(prop.getProperty("from.mail.id")));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse(to));
	                                                
	         String strBuildInfo = pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.strAUTBuildInfo;
	         String[] strArrBuildInfo = strBuildInfo .split(" ");
	         String strTitle = "";
	         
	         strTitle = "OpEasy Automation (" + POMSuiteRunner.suitename.toUpperCase() 
     		+ ") completed on "
		         		+ pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.strAUTBuildInfo;
	         
//	         System.out.println(" +++++++++++++" + Arrays.toString(strArrBuildInfo));
//	         if (POMSuiteRunner.strTestplanName.equals("HSPSanity")){
//	        	 strTitle = "OpEasy " + strArrBuildInfo[1] 
//	        		+ " " + strArrBuildInfo[2] 
//	        		+ "(BNo." + strArrBuildInfo[4].split("\\n")[0]  
//	         		+ POMSuiteRunner.strEmailNReportHeadline;
//	         } else {
//	        	 strTitle = "OpEasy " + strArrBuildInfo[1] 
//	 	        		+ "(BNo." + strArrBuildInfo[3].split("\\n")[0]  
//	 	         		+ POMSuiteRunner.strEmailNReportHeadline;
//	 	         	 
//	         }
	        	 System.out.println("Title: " + strTitle);
	         
	         // Set Subject: header field
	         message.setSubject(strTitle);        		 
	         
	         // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();
	         
//	         float dblAutomationAccuracy = 100 
//	        		 - ( pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.getStatusFromArray(pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.arr_teststatus, "Fail") 
//	        		 / pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.arr_teststatus.length )
//	        		 * 100;

	         // Now set the actual message
	         String header = "Hi All,\n\tThis is an auto generated e-mail from TVS MOTOR D&AI Team, please do not reply."
						//+ "\nPlease find attached the test report.\n"
						//+ "The detailed report with screenshots can be accessed from the Automation server. Please contact us.\n"
						//+ "The Jenkins job could be accessed from: " + prop.getProperty("jenkinsServerUrl") 
						//+ "\n\t Login credentials: "+ prop.getProperty("jenkinsLoginCredentials")  + ""

						+ "\n--------------------------------"
						+ "\nSuite Execution Results"
						+ "\n--------------------------------"
						+ "\n\t" + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.strAUTBuildInfo
						+ "\n\n\tTotal tests \t: " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.arr_teststatus.length
						+ "\n\tPassed \t\t: " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.getStatusFromArray(pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.arr_teststatus, "Pass")
						+ "\n\tFailed \t\t: " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.getStatusFromArray(pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.arr_teststatus, "Fail")
						+ "\n\tNotRun \t: " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.getStatusFromArray(pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.arr_teststatus, "NotRun")
//						+ "\nTotal test cases NoRun : " + pomTestApps.Utility.STAcore.repo\\rtwriter.GeneratePDFReport.getStatusFromArray(pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.arr_teststatus, "NoRun");
//						+ "\nExpected test case failures: 05"
//						+ "\nAutomation accuracy excluding expected failures    : " + dblAutomationAccuracy + "%"
//						// + "\nLatest deployment"  //+ pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.strAUTBuildInfo 
						+ "\n\n\tAutomation Client Browser \t: " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.strAUTBrowserInfo.toUpperCase()
						+ "\n\tAutomation Client Operating System \t: " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.strAUTOSInfo.toUpperCase()					
//						+ "\n------------------------------------------------------------"
						+"\n\n\tExecution Result summary is available at: \n\t\tTest Cycle -> Automated Regression -> 2024 -> OpEasy Regression -> <Test cycle name >"
						+ "\n\t\thttps://tvsmotor.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=CC&project.id=10000#!/Manage/TestCycle?folderId=997728"
						+ "\n------------------------------------------------------------";	
	         
	         
	         /*
	         String header = "Hi All,\n\tThis is an auto generated e-mail from Clearspan Automation Team, please do not reply."
						//+ "\nPlease find attached the test report.\n"
						//+ "The detailed report with screenshots can be accessed from the Automation server. Please contact us.\n"
						//+ "The Jenkins job could be accessed from: " + prop.getProperty("jenkinsServerUrl") 
						//+ "\n\t Login credentials: "+ prop.getProperty("jenkinsLoginCredentials")  + ""

						+ "\n--------------------------------"
						+ "\nSuite Execution Results"
						+ "\n--------------------------------"
						+ "\n\t" + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.strAUTBuildInfo
						+ "\n\n\tTotal tests \t: " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.arr_teststatus.length
						+ "\n\tPassed \t\t: " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.getStatusFromArray(pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.arr_teststatus, "Pass")
						+ "\n\tFailed \t\t: " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.getStatusFromArray(pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.arr_teststatus, "Fail")
//						+ "\nTotal test cases NoRun : " + pomTestApps.Utility.STAcore.repo\\rtwriter.GeneratePDFReport.getStatusFromArray(pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.arr_teststatus, "NoRun");
//						+ "\nExpected test case failures: 05"
//						+ "\nAutomation accuracy excluding expected failures    : " + dblAutomationAccuracy + "%"
//						// + "\nLatest deployment"  //+ pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.strAUTBuildInfo 
						+ "\n\n\tAutomation Client Browser \t: " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.strAUTBrowserInfo.toUpperCase()
						+ "\n\tAutomation Client Operating System \t: " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.strAUTOSInfo.toUpperCase()					
//						+ "\n------------------------------------------------------------"
						+"\n\n\tExecution Result summary is available at: \n\t\tTest Cycle -> Automated Regression -> 2023 -> OpEasy Regression -> <Test cycle name >"
						+ "\n\t\thttps://clearspan.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=CC&project.id=10000#!/Manage/TestCycle?folderId=800556"
						+ "\n------------------------------------------------------------";			
	         */
	         
	         /*
				String header = "Hi All,\n\tThis is an auto generated e-mail from Clearspan Automation Team, please do not reply."
						//+ "\nPlease find attached the test report.\n"
						//+ "The detailed report with screenshots can be accessed from the Automation server. Please contact us.\n"
						//+ "The Jenkins job could be accessed from: " + prop.getProperty("jenkinsServerUrl") 
						//+ "\n\t Login credentials: "+ prop.getProperty("jenkinsLoginCredentials")  + ""
						+ "\n------------------------------------------------------------"
						+ "\nPING: Latest deployment"  //+ pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.strAUTBuildInfo 
						+ "\n\nBrowser Used: " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.strAUTBrowserInfo
						+ "\n\nOperating System: " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.strAUTOSInfo					
						+ "\n------------------------------------------------------------"
						+"\n Detailed reports are available at: https://clearspan.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=SV&project.id=10008#!/Manage/TestCycle?projectId=10000";
					//	+ "\n\nTotal Test Cases Executed : " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.arr_teststatus.length
					//	+ "\nTotal test cases Passed : " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.getStatusFromArray(pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.arr_teststatus, "Pass")
					//	+ "\nTotal test cases Failed : " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.getStatusFromArray(pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.arr_teststatus, "Fail")
					//	+ "\nTotal test cases NoRun : " + pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.getStatusFromArray(pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.arr_teststatus, "NoRun")
//						+ "\nExpected test case failures: 05"
//						+ "\nAutomation accuracy excluding expected failures    : " + dblAutomationAccuracy + "%"
					//	+ "\n------------------------------------------------------------";
				
*/
	         
			String footer = "\n\n\nThank you,\n" 
					+ pomTestApps.STAcore.POMSuiteRunner.PropertyName + " AUTOMATION,"
					+ "\n\t viru.kulkarni@tvsmotor.com ";

			//System.out.println(line);
	         messageBodyPart.setText(header+footer);
	                 
	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         /*
	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String pdfPath=ReusableUiCoreKeywords.reportPathSuite;
	         String filename=pdfPath+"/Suite_Execution_Report.pdf";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName("Suite Execution Report.pdf");
	         multipart.addBodyPart(messageBodyPart);
*/
	         
	         // Send the complete message parts
	         message.setContent(multipart);

	         // Send message
	         Transport.send(message);

	         System.out.println("Automation-Report Email sent successfully....");
	  
	      } catch (MessagingException e) {
	    	  e.printStackTrace();
	         throw new RuntimeException(e);
	      }
	   }
	}