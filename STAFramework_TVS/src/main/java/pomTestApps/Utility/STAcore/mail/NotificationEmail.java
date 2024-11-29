package pomTestApps.Utility.STAcore.mail;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
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

import pomTestApps.*;
import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport;

public class NotificationEmail {

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
	         new jakarta.mail.Authenticator() {
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

	         // Title ex: OpEasy Automation � Sanity Started on Tb20 for Version: 20.1 195
	         String strTitle = "OpEasy Automation � " + POMSuiteRunner.suitename 
	        		+ " test started on "
	         		+ pomTestApps.Utility.STAcore.reportwriter.GeneratePDFReport.strAUTBuildInfo;
	         
        	 System.out.println("Title: " + strTitle);
	         
	         // Set Subject: header field
	         message.setSubject(strTitle);        		 
	         
	         // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();

		     	// Now set the actual message
				String header = "Hi All,\n\nThis is an auto generated e-mail from TVS MOTOR D&AI Automation Team, please do not reply."
						+ "\n Please wait for the completion of Automation run. "
					//	+ "\n Automation run progress could be monitored from Jenkins server: " 
						// + prop.getProperty("jenkinsServerUrl") 
					//	+ "\n\t Login credentials: "+ prop.getProperty("jenkinsLoginCredentials")  + ""
						+ "\n------------------------------------------------------------------------------------------------------------------------------------"
					//	+ "\nThe test report would be sent as email attachment after the run is completed."
						+ "\nWe request you to kindly avoid the following activities and avoid interruptions during the run: "
						+ "\n\t - OpEasy build upgrade activities, unless critical,"
						+ "\n\t - Loggin to OpEAsy with Automation user credentials"
						+ "\n------------------------------------------------------------------------------------------------------------------------------------";
			

			String footer = "\n\n\nThank you,\n" + pomTestApps.STAcore.POMSuiteRunner.PropertyName
					+ " Automation Team :";

			//System.out.println(line);
	         messageBodyPart.setText(header+footer);
	                 
	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);

	         // Send message
	         Transport.send(message);

	         System.out.println("Notification Email sent successfully....");
	  
	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
	   }
	}