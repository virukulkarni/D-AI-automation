package GmailAPI;

import java.util.Properties;

import jakarta.mail.BodyPart;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.Session;
import jakarta.mail.Store;

import com.sun.mail.imap.protocol.FLAGS;

import datatable.NextGenGlobalVariables.GlobalVariablesGeneral;
import datatable.NextGenGlobalVariables.GlobalVariablesUser;
import util.LoggerUtil;

public class Gmail {

	public String GmailGetAuthCode(GlobalVariablesGeneral generalObject,GlobalVariablesUser userObject){
		LoggerUtil.APPLICATION_LOGS.debug("Executing GmailGetAuthCode Keyword");
		String Authcode="";	
	
		try{
			Properties props = new Properties();
			props.setProperty("mail.store.protocol", "imaps");
			props.setProperty("Requires SSL", "Yes");
			props.setProperty("Port", "993");

			Session session = Session.getInstance(props, null);

			Store store = session.getStore("imaps");
			store.connect("smtp.gmail.com", generalObject.Gmailusername, generalObject.GmailPassword);

			Folder inbox = store.getFolder("inbox");
			inbox.open(Folder.READ_ONLY);
			int messageCount = inbox.getMessageCount();

			System.out.println("Total Messages:- " + messageCount);

            Message[] messages = inbox.getMessages();
			Multipart mp = null;
			BodyPart bp=null;
			String ss=null;

			for (int i = 0; i < messages.length; i++) {
//				System.out.println("Mail Subject:- " + messages[i].getSubject());
				String s=messages[i].getSubject();
				if(s!=null){
					if(s.contains(Integer.toString(userObject.UserDeskphoneNumber)) || s.contains(Integer.toString(userObject.UserSoftphoneNumber))){
						mp = (Multipart) messages[i].getContent();
						bp = mp.getBodyPart(0);
						ss=bp.getContent().toString();
						String[] arrSplit = ss.split("Please use the following key:");
						String[] arrSplitFinal = arrSplit[1].split("\n");
						System.out.println(arrSplitFinal[1]);
						Authcode=arrSplitFinal[1];
					}
				}
			}
			inbox.close(true);
			store.close();
		}
		catch(Exception e){
			LoggerUtil.APPLICATION_LOGS.debug("Error while Executing GmailGetAuthCode Keyword \n" +e.getMessage());
		}
		return Authcode;
	}
	
	public String GmailDeleteMail(GlobalVariablesGeneral generalObject,GlobalVariablesUser userObject){
		LoggerUtil.APPLICATION_LOGS.debug("Executing GmailDeleteMail Keyword");
		String message="Fail";	

		try{  
			Properties props = new Properties();
			props.setProperty("mail.store.protocol", "imaps");
			props.setProperty("Requires SSL", "Yes");
			props.setProperty("Port", "993");
			Session session = Session.getInstance(props, null);

			Store store = session.getStore("imaps");
			store.connect("smtp.gmail.com", generalObject.Gmailusername, generalObject.GmailPassword); 

			Folder folder = store.getFolder("inbox");  

			if (!folder.exists()) {  
				System.out.println("inbox not found");  
				System.exit(0);  
			}  

			folder.open(Folder.READ_WRITE);  

			Message[] msg = folder.getMessages();  
			Multipart mp = null;
			BodyPart bp=null;
			String ss=null;

			for (int i = 0; i < msg.length; i++) {
				String s=msg[i].getSubject();
//				System.out.println(s);
				if(s!=null){
					if(s.contains(Integer.toString(userObject.UserDeskphoneNumber)) || s.contains(Integer.toString(userObject.UserSoftphoneNumber))){
						mp = (Multipart) msg[i].getContent();
						bp = mp.getBodyPart(0);
						ss=bp.getContent().toString();
						msg[i].setFlag(FLAGS.Flag.DELETED, true);  
					}
				}
			}
			folder.close(true);  
			store.close(); 
			message="Pass";
		}
		catch(Exception e){
			LoggerUtil.APPLICATION_LOGS.debug("Error while Executing GmailDeleteMail Keyword \n" +e.getMessage());
			message="Fail";
		}
		return message;
	}

}
