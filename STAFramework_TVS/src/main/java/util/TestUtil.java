package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import datatable.Xlfile_Reader;
import io.appium.java_client.AppiumDriver;





public class TestUtil{

	 public static String imageName;
	 public static String imageNameIP;
	 public static String imageError;
	 public static String subject;
	 public static String from_date=null;
	 public static String to_date=null;
	 public static Xlfile_Reader datareader=null;
	
	 public static String Handeler()   
		{
		try{	
		 InetAddress ownIP = null;
			ownIP = InetAddress.getLocalHost();
			subject=ownIP.getHostAddress(); 
			
		}catch(Throwable t){
		 t.printStackTrace();
		}
		return subject;
					
		} 
	

	// returns current date and time
	public static String now(String dateFormat) {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	    return sdf.format(cal.getTime());
	    
	}
	
	// store screenshots
public static void captureScreenshot(Object driver, String currentTest) throws IOException{
		
		Calendar cal = new GregorianCalendar();
		  int month = cal.get(Calendar.MONTH);
		  int year = cal.get(Calendar.YEAR);
		  int sec =cal.get(Calendar.SECOND);
		  int min =cal.get(Calendar.MINUTE);
		  int date = cal.get(Calendar.DATE);
		  int day =cal.get(Calendar.HOUR_OF_DAY);
	     String ImageDest = System.getProperty("user.dir")+"/Reports/Html/"+LoggerUtil.strDate+"/Screenshots/";
	    
		  imageName = ImageDest+currentTest+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec;
		  imageError = currentTest+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec;
		  imageNameIP=currentTest+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec;
		  File scrFile = null;
		  if (driver.getClass().getName().contains("WebDriver")) {
			   scrFile = ((TakesScreenshot)(WebDriver)driver).getScreenshotAs(OutputType.FILE);
		  }
//		  else if (driver.getClass().getName().contains("appium")) {
//			  scrFile  = ((TakesScreenshot)(AppiumDriver<WebElement>)driver).getScreenshotAs(OutputType.FILE);
//		  }
		  FileUtils.copyFile(scrFile, new File(imageName+ ".jpeg"));
	      	      
	}





	
	// make zip of reports
	public static void zip(String filepath){
	 	try
	 	{
	 		File inFolder=new File(filepath);
	 		File outFolder=new File("Reports.zip");
	 		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
	 		BufferedInputStream in = null;
	 		byte[] data  = new byte[1000];
	 		String files[] = inFolder.list();
	 		for (int i=0; i<files.length; i++)
	 		{
	 			in = new BufferedInputStream(new FileInputStream
	 			(inFolder.getPath() + "/" + files[i]), 1000);  
	 			out.putNextEntry(new ZipEntry(files[i])); 
	 			int count;
	 			while((count = in.read(data,0,1000)) != -1)
	 			{
	 				out.write(data, 0, count);
	 			}
	 			out.closeEntry();
	 		}
	 		out.flush();
	 		out.close();
	 	
	 	}
	 	catch(Exception e)
	 	{
	 		e.printStackTrace();
	 	} 
	}	
	

		   
     public static float Round(float Rval, int Rpl) {
		  float p = (float)Math.pow(10,Rpl);
		  Rval = Rval * p;
		  float tmp = Math.round(Rval);
		  return (float)tmp/p;
		  }

    
     
     
    
     
}
