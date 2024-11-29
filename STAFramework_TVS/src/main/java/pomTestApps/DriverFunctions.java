package pomTestApps;

/**************************************************
#Project Name: MiTEL_MXONE - Selenium Framework


#Class Name: DriverFunctions()
#Description:1.  The class is responsible for opening different browsers 
#Input Parameters:
#Owner: Ashis Kumar Pradhan
#Author: Ashis Kumar Pradhan
#Date of creation: 03-July-16
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
//import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.Utility.STAcore.io.Log;

public class DriverFunctions {

	// public WebDriver driver;
	public WebDriver driver;

	// HtmlUnitDriver driver2;
	private String browser;

	private int implicitWait;
	private int pageLoadTimeOut;
	protected static DesiredCapabilities dCaps;
	public static boolean headless = false;

	public String downloads_path = System.getProperty("user.dir")+"\\Downloads_Folder\\"; 
	
	@SuppressWarnings("deprecation")
	public WebDriver openBrowser() throws IOException {
		Log.info("Is browser headless: " + headless);
		if (headless == true) {
			Log.info("Actual Browser is Headless");
			try {

				LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log",
						"org.apache.commons.logging.impl.NoOpLog");
				java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);
				java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit")
						.setLevel(java.util.logging.Level.OFF);

			//	driver.manage().window().maximize();
				Log.info("Implicit Wait is " + implicitWait);

				driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
				Log.info("Page load time out is " + pageLoadTimeOut);
				driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
				driver.manage().timeouts().setScriptTimeout(pageLoadTimeOut, TimeUnit.SECONDS);

				return driver;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		Log.info("Broswer value is " + browser);
		
//		browser = "microsoftedge";
//		browser = "opera";

		if (browser.equalsIgnoreCase("firefox")) {

			// Firefox does not require gecko driver
			
			// To be set on profile - R & D
//			String webdriver_path = (String) System.getProperty("user.dir")+"\\webdrivers\\" + "geckodriver.exe";
//			System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");
			
			// Firefox browser is launched here - Working			
//			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
//			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_PROFILE,"Automation");
			
			
			
			// Not working yet
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("browser.download.dir", downloads_path);
			options.addPreference("browser.download.folderList", 2);
			options.addPreference("browser.download.manager.showWhenStarting", false);
			options.addPreference("browser.download.dir", downloads_path);
			options.addPreference("browser.download.manager.alertOnEXEOpen", false);
			options.addPreference("browser.helperApps.neverAsk.saveToDisk",
					"application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html,text/plain,application/octet-stream");
			options.addPreference("browser.download.manager.focusWhenStarting", false);
			options.addPreference("browser.download.useDownloadDir", true);
			options.addPreference("browser.helperApps.alwaysAsk.force", false);
			options.addPreference("browser.download.manager.alertOnEXEOpen", false);
			options.addPreference("browser.download.manager.closeWhenDone", false);
			options.addPreference("browser.download.manager.showAlertOnComplete", false);
			options.addPreference("browser.download.manager.useWindow", false);
			options.addPreference("browser.download.manager.showWhenStarting", false);
			options.addPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
			
			WebDriverManager.chromedriver().setup();
			
			driver = new FirefoxDriver(options);
			
//			
//			options.setProfile(profile);
			

//			 FirefoxProfile profile = new FirefoxProfile();
//			 // String path=".\\InpFiles";
//			 String path=System.getProperty("user.dir")+"\\"+pomTestApps.STAcore.POMSuiteRunner.FileName + "\\"; 
//			 
//			 File file = new File(path);
//			  System.out.println("this directory is :" + System.getProperty("user.dir"));
//				path = file.getCanonicalPath();
//				System.out.println(path);
//			  profile.setPreference("browser.download.folderList", 2); 
//			  profile.setPreference("browser.download.manager.showWhenStarting", false); 
//			  profile.setPreference("browser.download.dir",downloads_path); 
//			  profile.setPreference("browser.download.manager.alertOnEXEOpen", false); 
//			  profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html,text/plain,application/octet-stream"); 
//			  profile.setPreference("browser.download.manager.focusWhenStarting", false); 
//			  profile.setPreference("browser.download.useDownloadDir", true); 
//			  profile.setPreference("browser.helperApps.alwaysAsk.force", false); 
//			  profile.setPreference("browser.download.manager.alertOnEXEOpen", false); 
//			  profile.setPreference("browser.download.manager.closeWhenDone", false); 
//			  profile.setPreference("browser.download.manager.showAlertOnComplete", false); 
//			  profile.setPreference("browser.download.manager.useWindow", false); 
//			  profile.setPreference("browser.download.manager.showWhenStarting",false); 
//			  profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
//			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//			capabilities.setCapability(FirefoxDriver.PROFILE, profile);
//			capabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, "true");
//			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.ACCEPT);
//			driver = new FirefoxDriver(profile);
			
			

		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Workspace\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--disable-translate");
			options.addArguments("--user-data-dir=C:\\Temp\\chrome-dev-app2");
			//options.addArguments("--start-maximised");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--allow-insecure-localhost");
			
			//Load ANDI plugin for only 508_Compliance test plans
			if(POMSuiteRunner.strTestplanName.contains("508_Compliance")) {
				options.addArguments("--load-extension=C://Automation//ANDI");	
			} else {
//				options.addArguments("--disable-extensions");
			}
			
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("load-extension"));
//			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.logfile", "C:\\Temp\\chromedriver.log");
			System.setProperty("webdriver.chrome.verboseLogging", "true");
			
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloads_path);			
			options.setExperimentalOption("prefs", chromePrefs);
			
//			
//			DesiredCapabilities cap = DesiredCapabilities.chrome();
////			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			cap.setCapability(ChromeOptions.CAPABILITY, options);
//			WebDriver driver = new ChromeDriver(cap);
//			
			WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver(options);
			
//			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			capabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
//			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
//			WebDriver driver = new ChromeDriver();
//			 driver = new ChromeDriver(capabilities);
			
		} else if (browser.matches("iexplorer") ) { // Meant for IE actually
			
			//it is used to define IE capability 

			String webdriver_path = (String) System.getProperty("user.dir")+"\\webdrivers\\" + "IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", webdriver_path);
			
			InternetExplorerOptions options = new InternetExplorerOptions()
					   .requireWindowFocus();
			  
			 //it is used to initialize the IE driver
			driver = new InternetExplorerDriver(options);
			
//			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

			// driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("microsoftedge")) {			
			driver = new EdgeDriver();			
		} else if (browser.equalsIgnoreCase("opera")) {			
//			driver = new OperaDriver();			
		}
		
		
	//	driver.manage().window().maximize();
		Log.info("Implicit Wait is " + implicitWait);
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		Log.info("Page load time out is " + pageLoadTimeOut);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
		
		return driver;
	}

	public void closebrowser() throws InterruptedException {
		Object[] windows = driver.getWindowHandles().toArray();
		for (int i = 0; i < windows.length; i++) {
			driver.switchTo().window(windows[i].toString());
			driver.close();
		}
	}

	public DriverFunctions(WebDriver driver, String browser, int implicitWait, int pageLoadTimeOut) {
		// this.driver = driver;
		this.driver = driver;
		this.browser = browser;
		this.implicitWait = implicitWait;
		this.pageLoadTimeOut = pageLoadTimeOut;

	}

	@SuppressWarnings("unused")
	private Boolean checkInstanceofPhantom() throws IOException {
		Boolean found = false;
		String pidInfo;
		Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

		String line;
		while ((line = input.readLine()) != null) {
			pidInfo = line;
			// System.out.println(pidInfo);
			if (pidInfo.contains("phantomjs.exe")) {
				found = true;
			}

		}
		return found;

	}

}
