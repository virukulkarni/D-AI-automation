/*----------------------------------------------------------------------------------------------------------------------

 *             THIS CLASS STORES ALL TEST CASE LEVEL KEYWORDS                                                        |

----------------------------------------------------------------------------------------------------------------------*/

package pomTestApps;

/**************************************************

#Project Name: MiTEL_MXONE - Selenium Framework





#Class Name: ReusableTestKeywords()

#Description:This Class Contains the Keywords to be used for designing test ScriptsS

#Input Parameters:

#Owner: Ashis Kumar Pradhan

#Author: Ashis Kumar Pradhan

#Date of creation: 03-July-16

#Name of person modifying: (Tester Name):

#Date of modification:

‘**************************************************/

import java.awt.AWTException;

import java.awt.Robot;

import java.awt.Toolkit;

import java.awt.datatransfer.StringSelection;

import java.awt.event.KeyEvent;

import java.io.BufferedReader;

import java.io.DataInputStream;

import java.io.File;

import java.io.FileFilter;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

//import java.io.FileReader;

import java.io.IOException;

import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import java.util.Scanner;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import org.apache.commons.io.comparator.LastModifiedFileComparator;

import org.apache.commons.io.filefilter.WildcardFileFilter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;

import org.openqa.selenium.NoAlertPresentException;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.UnhandledAlertException;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.pagefactory.interceptors.InterceptorOfASingleElement;
import pomTestApps.STAcore.DAICommon;
import pomTestApps.Test.com.automation.tvsmotor.dai.elements.OpeasyCommonPageElements;
import pomTestApps.Utility.STAcore.io.Log;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import org.openqa.selenium.interactions.Action;

public class ReusableTestKeywords extends ReusableUiCoreKeywords {

	/*----------------------------------------------------------------------------------------------------------------------
	
	 *             TEST CLASS  RESUABLE KEYWORDS STARTS HERE                                                                |
	
	           ----------------------------------------------------------------------------------------------------------------------*/

	private void unhighlight(WebElement element) throws InterruptedException {

		if (DriverFunctions.headless == true) {

			return;

		}

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', arguments[1]);",

				element, "");

	}

	// The method highlights the Element

	private void highlightElement(WebElement element)

			throws InterruptedException {

		if (DriverFunctions.headless == true) {

			return;

		}

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', arguments[1]);",

				element, "color: ; border: 5px solid yellow;");

	}

	// The method take the Screenshot of the Page. CALLED BY OTHER METHODS.

	private void takescreenshot(String Path) throws IOException {

		if (DriverFunctions.headless == true) {

			return;

		}

		// Log.info("Path inside screenshot " + Path);

		// Introduced by Viru for screen shot to be useful
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		
//		wait.until(ExpectedConditions.elementToBeClickable(
//				By.xpath(".//img[@src[contains(.,'clientLogo.gif') or contains(., 'OPeasyLogo.jpg') or contains(.,'/gmail/about/static-2.0/images/logo-gmail.png?fingerprint=c2eaf4aae389c3f885e97081bb197b97') or contains(.,'https://lh3.googleusercontent.com/ogw') or contains(.,'mail/rfr/logo_gmail_lockup') or contains(.,'data:image/png;base64') or contains(.,'crosoft_logo_564db913a7fa0ca42727161c6d031bef.svg') or contains(., 'opeasy-logo')]]")));
		// End of - Introduced by Viru for screen shot to be useful

		File scrFile = ((TakesScreenshot) driver)

				.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrFile, new File(Path));

		// To take full screenshot - Viru

		// Screenshot screenshot = new
		// AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		// ImageIO.write(screenshot.getImage(),"PNG",new File(Path));
		//
		//

	}

	// executeStep

	/**
	 * 
	 * This method can be used for any operations.Its collects the stats of the
	 * 
	 * WebElement and returns the webelement.
	 *
	 * 
	 * 
	 * @param element
	 * 
	 * @param description
	 * 
	 * @return WebElement
	 * 
	 * @throws IOException
	 * 
	 */

	public WebElement executeStep(WebElement element, String description)

			throws IOException {

		Log.info("Inside " + description);

		String[] stepDetails = new String[3];

		int xCoordinate = 0;

		int yCoordinate = 0;

		String screenshotPath = reportPathBrowser + "\\screenshots\\"

				+ serielNo + ".png";

		try {

			xCoordinate = element.getLocation().x;

			yCoordinate = element.getLocation().y;

			highlightElement(element);

			status = "Pass";

			if (screenshotOnFail.equals("Y")) {

				System.out

						.println("Only screenshot will be captured in failed cases");

			} else {

				takescreenshot(screenshotPath);

			}

			Thread.sleep(500);

			unhighlight(element);

		} catch (Exception e) {

			updateStep("Element Not Found", "Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

			Log.info("Element not found");

		} finally {

			stepDetails[0] = description;

			stepDetails[1] = status;

			stepDetails[2] = xCoordinate + "," + yCoordinate;

			serielNo++;

		}

		stepsDetails.add(stepDetails);

		return element;

	}

	/**
	 * 
	 * This method send info to the Framework for reporting purpose
	 *
	 * 
	 * 
	 * @param description
	 * 
	 * @param status
	 * 
	 * @throws Exception
	 * 
	 */

	public void updateStep(String description, String status) {

		Log.info("************" + description);

		String[] stepDetails = new String[4];

		stepDetails[0] = description;

		stepDetails[1] = status;

		stepDetails[2] = 0 + "," + 0;

		try {

			System.out.println ("Line 1 inside updatestep");
			Thread.sleep(500);

		} catch (InterruptedException e) {
			
			System.out.println ("catch inside updatestep");

			e.printStackTrace();

		}

		if (pomTestApps.BaseTestType.suiteName != "TestSetup") {

			String screenshotPath = reportPathBrowser + "\\screenshots\\"

					+ serielNo + ".png";

			// Log.info(screenshotOnFail);

			if (screenshotOnFail.equalsIgnoreCase("Y")) {

				if (status.contains("Fail")) {

					try {

						takescreenshot(screenshotPath);

					} catch (IOException e) {

						e.printStackTrace();

					}

				} else if (status.matches("Info|INFO|Warn|Warning|WARN|WARNING")) {

					try {

						takescreenshot(screenshotPath);

					} catch (IOException e) {

						e.printStackTrace();

					}

				}

			} else {

				try {

					takescreenshot(screenshotPath);

				} catch (IOException e) {

					e.printStackTrace();

				}

			}

		}

		stepsDetails.add(stepDetails);

		serielNo++;

		// System.out.println("Suite Run true: " + SuiteRunner.suiteRun);

		if (status.contains("Fail") && SuiteRunner.suiteRun == true) {

			Assert.assertTrue(false);

		}

	}

	/**
	 * 
	 * This method will validate the downloaded file
	 *
	 * 
	 * 
	 * @param url
	 * 
	 */

	public boolean isFileDownloaded(String downloadPath, String fileName) {

		boolean flag = false;

		File dir = new File(downloadPath);

		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {

			if (dir_contents[i].getName().equals(fileName))

				return flag = true;

		}

		return flag;

	}

	/*----------------------------------------------------------------------------------------------------------------------
	
	 *                                              Driver related functions                                              |
	
	           ----------------------------------------------------------------------------------------------------------------------*/

	/**
	 * 
	 * This method opens the Url in the Browser
	 *
	 * 
	 * 
	 * @param url
	 * 
	 */

	public void openUrl(String url) {

		try {
			driver.get(url);
			updateStep("Open the URL: " + url, "Pass");
		} catch (Exception e) {
			e.getStackTrace();
			updateStep("Open the URL: " + url, "Fail - Exception: " + "\n\t\t"
					+ e.getClass().getSimpleName());
		}

	}

	/**
	 * 
	 * This method transfers the control to the Child window based on Index.Base
	 * 
	 * Window has index of 0.
	 *
	 * 
	 * 
	 * @param window
	 * 
	 * @throws Exception
	 * 
	 */

	public void switchWindow(int window) throws Exception {

		try {

			Object[] windows = driver.getWindowHandles().toArray();

			driver.switchTo().window(windows[window].toString());

			updateStep("Switch Window", "Pass");

		} catch (Exception e) {

			updateStep("Switch to Window: " + window, "Fail - Exception: "

					+ "\n\t\t" + e.getClass().getSimpleName());

		}

	}

	/**
	 * 
	 * This method transfers the control to the child window based on the Title.
	 *
	 * 
	 * 
	 * @param title
	 * 
	 * @throws Exception
	 * 
	 **/

	public void switchWindow(String title) throws Exception {

		try {

			Object[] windows = driver.getWindowHandles().toArray();

			for (int i = 0; i < windows.length; i++) {

				driver.switchTo().window(windows[i].toString());

				if (driver.getTitle().trim().equalsIgnoreCase(title)) {

					updateStep("Switched to  Window " + title, "Pass");

					return;

				}

			}

		} catch (Exception e) {

			updateStep("Switch to Window: " + title, "Fail - Exception: "

					+ "\n\t\t" + e.getClass().getSimpleName());

		}

	}

	/**
	 * 
	 * This Method Clicks OK on the Javascript Alert
	 * 
	 **/

	public void alertAccept() {

		Log.info(".......Accept Alert...........");

		try {

			if (driver
					.findElements(By
							.xpath("//div[@class='ui-confirm-dialog ui-dialog ui-widget ui-widget-content ui-corner-all ui-shadow ui-hidden-container']"))
					.size() > 0) {
				// driver.findElement(By.xpath("(//*[@id[contains(.,
				// 'form1:tableQueryResults:')]])[last()-3]//span[contains(text(),
				// 'Yes')]")).click();
				driver.findElement(By.xpath("(//span[contains(text(), 'Yes')])[last()]")).click();
				Log.info("Inside alert accept");
				updateStep("Accepted Alert", "Pass");
			}

		} catch (Exception e) {

		}

	}

	// public void alertAccept() {
	//
	// Log.info(".......Accept Alert...........");
	//
	// try {
	//
	// Alert alert = driver.switchTo().alert();
	//
	// alert.accept();
	//
	// Log.info("Inside alert accept");
	//
	// updateStep("Accept Alert", "Pass");
	//
	// } catch (Exception e) {
	//
	// }
	//
	// }

	/**
	 * 
	 * This Method clicks the Cancel Button on Javascript Alert.
	 * 
	 */

	public void alertReject() {

		Log.info(".......Accept Dismiss...........");

		try {

			Alert alert = driver.switchTo().alert();

			alert.dismiss();

			;

			updateStep("Dismiss Alert", "Pass");

		} catch (Exception e) {

		}

	}

	/**
	 * 
	 * This Method Returns the Text Present on the alert
	 *
	 * 
	 * 
	 * @return String
	 * 
	 */

	@SuppressWarnings("finally")

	public String getAlertdata() {

		try {

			Log.info(".......GET ALERT DATA...........");

			Alert alert = driver.switchTo().alert();

			String text = alert.getText();

			return text;

		}

		// updateStep("Get Data Alert", "Pass");

		// System.out.println(alertText);

		// return alertText;

		catch (UnhandledAlertException e) {

			UnhandledAlertException ua = new UnhandledAlertException(Browser);

			return ua.getAlertText();

		}

	}

	/**
	 * 
	 * This Method writes into the textbox present on the alert
	 *
	 * 
	 * 
	 * @param input
	 * 
	 */

	public void setAlert(String input) {

		Log.info(".......SET ALERT DATA...........");

		try {

			Alert alert = driver.switchTo().alert();

			alert.sendKeys(input);

			alert.accept();

			updateStep("Set  Alert", "Pass");

		} catch (Exception e) {

		}

	}

	/**
	 * 
	 * This Method checks if the alert is Present.
	 *
	 * 
	 * 
	 * @return Boolean
	 * 
	 */

	public Boolean isAlertPresent() {

		Log.info(".......IS ALERT PRESENT...........");

		try {

			Alert alert = driver.switchTo().alert();

			// alert.

			updateStep("Alert  Present", "Pass");

			return true;

		} catch (NoAlertPresentException e) {

			updateStep("Alert Not Present", "Fail");

			return false;

			// } catch (UnhandledAlertException e2) {

			// updateStep("Alert Present", "Fail");

			// return true;

		}

	}

	/**
	 * 
	 * This Method checks if a webelement is Present or not.
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param description
	 * 
	 * @return Boolean
	 * 
	 */

	public Boolean isElementPresent(WebElement ele, String description) {

		Log.info(".......IS ELEMENT PRESENT...........");

		try {

			highlightElement(ele);

			updateStep("Element Found:" + description, "Pass");

			unhighlight(ele);

			return true;

		} catch (Exception e) {

			updateStep(" ElementNot Found :" + description, "Fail");

			return false;

		}

	}

	/**
	 * 
	 * This Method compares 2 values of any datatype.
	 *
	 * 
	 * 
	 * @param Expected
	 * 
	 * @param Actual
	 * 
	 * @return Generics
	 * 
	 * @throws Exception
	 * 
	 */

	public <T> T assertEquals(T Expected, T Actual) {

		try {

			Log.info(".......CHECKS IF EQUAL...........");

			Log.info("Exp :" + Expected);

			Log.info("Act :" + Actual);

			if (Expected.equals(Actual)) {

				updateStep("Validation Passed -Expected: " + Expected

						+ " Actual: " + Actual, "Pass");

			} else {

				updateStep("Validation Failed -Expected: " + Expected

						+ " Actual: " + Actual, "Fail");

			}

		} catch (Exception e) {

			updateStep("Validation Failed -Expected: " + Expected + " Actual: "

					+ Actual,
					"Fail - Exception: " + "\n\t\t"

							+ e.getClass().getSimpleName());

		}

		return Actual;

	}

	/**
	 * 
	 * This method validates if the Input is true.
	 *
	 * 
	 * 
	 * @param Result
	 * 
	 * @throws Exception
	 * 
	 */

	public void assertTrue(Boolean Result) throws Exception {

		Log.info(".......CHECKS IF TRUE...........");

		if (Result.equals(true)) {

			updateStep("Validation Passed", "Pass");

		} else {

			updateStep("Validation Failed", "Fail");

		}

	}

	/**
	 * 
	 * This Method Returns the string present in a BaseString by taking the
	 * 
	 * endpoint Strings.
	 *
	 * 
	 * 
	 * @param baseword
	 * 
	 * @param startword
	 * 
	 * @param endword
	 * 
	 * @return String
	 * 
	 */

	public String getStringValue(String baseword, String startword,

			String endword) {

		Log.info(".......getStringValue...........");

		int a = startword.length();

		int b = baseword.indexOf(startword);

		int startPoint = a + b;

		int length = baseword.substring(a + b).indexOf(endword);

		int endPoint = startPoint + length;

		// Log.info(baseword.substring(a + b));

		// Log.info(baseword.substring(a + b).indexOf(" "));

		return (baseword.substring(startPoint, endPoint));

	}

	/**
	 * 
	 * This Method transfers the control to the frame based on FrameId
	 *
	 * 
	 * 
	 * @param frameid
	 * 
	 */

	public void switchFrame(String frameid) {

		try {

			driver.switchTo().frame(frameid);

			updateStep("Switch to Frame " + frameid, "Pass");

		} catch (Exception e) {

			updateStep("Switch to Frame " + frameid, "Fail - Exception: "

					+ "\n\t\t" + e.getClass().getSimpleName());

		}

	}

	/**
	 * 
	 * This Method transfers the control to the frame present at the WebElement
	 *
	 * 
	 * 
	 * @param element
	 * 
	 */

	public void switchFrame(WebElement element) {

		Log.info("------------SWITCH FRAME-------");

		try {

			driver.switchTo().frame(element);

			updateStep("Switch to Frame ", "Pass");

		} catch (Exception e) {

			updateStep("Switch to Frame ", "Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

		}

	}

	/**
	 * 
	 * This Method Transfers the control from frames to the Default page.
	 *
	 * 
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void switchtoDefaultContent() throws IOException,

			InterruptedException {

		driver.switchTo().defaultContent();

		updateStep("Switch to Default Content ", "Pass");

	}

	/**
	 * 
	 * This Method waits for the Element to be visible till the time provided as
	 * 
	 * input.Polls every second Input time in miliseconds.
	 *
	 * 
	 * 
	 * @param element
	 * 
	 * @param time_in_ms
	 * 
	 */

	public void waitForElementPresent(WebElement element, int time_in_ms) {

		int waittime = 0;

		Boolean bln_found = false;

		while (waittime < time_in_ms) {

			try {

				highlightElement(element);

				updateStep("Element found", "Pass");

				bln_found = true;

				return;

			} catch (NoSuchElementException e) {

				waittime = waittime + 1000;

			} catch (InterruptedException e) {

			}

		}

		if (bln_found == false) {

			updateStep("Element Not  found", "Fail");

		}

	}

	/**
	 * 
	 * This method is a hard wait.
	 *
	 * 
	 * 
	 * @param time_in_ms
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void wait(int time_in_ms) throws InterruptedException {

		Thread.sleep(time_in_ms);

	}

	/**
	 * 
	 * This method enables execution of Javascript on the WebElement
	 *
	 * 
	 * 
	 * @param action
	 * 
	 * @param element
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void executeJScript(String action, WebElement element)

			throws IOException, InterruptedException {

		try {

			highlightElement(element);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript(action, element);

			unhighlight(element);

			updateStep("Javascript Command", "Pass");

		} catch (Exception e) {

			updateStep("Error in Executing Javascript", "Fail - Exception: "

					+ "\n\t\t" + e.getClass().getSimpleName());

		}

	}

	/**
	 * 
	 * This method performs Javascript Click.
	 *
	 * 
	 * 
	 * @param element
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void executeJScriptClick(WebElement element) throws IOException,

			InterruptedException {

		try {

			// highlightElement(element);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", element);

			// unhighlight(element);

			updateStep("Element Clicked", "Pass");

		} catch (Exception e) {

			updateStep("Error in Executing Javascript", "Fail - Exception: "

					+ "\n\t\t" + e.getClass().getSimpleName());

		}

	}

	/**
	 * 
	 * This method returns the text present in an element using Javascript
	 *
	 * 
	 * 
	 * @param element
	 * 
	 * @return
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	@SuppressWarnings("finally")

	public String executeJScriptGetText(WebElement element) throws IOException,

			InterruptedException {

		String text = null;

		try {

			highlightElement(element);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			text = (String) js.executeScript("return arguments[0].value;",

					element);

			unhighlight(element);

			updateStep("Javascript Command", "Pass");

		} catch (Exception e) {

			updateStep("Error in Executing Javascript", "Fail - Exception: "

					+ "\n\t\t" + e.getClass().getSimpleName());

			text = "";

		} finally {

			System.out.println("Text Returned is " + text);

			return text;

		}

	}

	/**
	 * 
	 * Returns the Title of the WebPage.
	 *
	 * 
	 * 
	 * @return String
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	@SuppressWarnings("finally")

	public String getTitle() throws IOException, InterruptedException {

		String title = null;

		try {

			updateStep("Get the Title", "Pass");

			title = driver.getTitle();

		} catch (Exception e) {

			updateStep("Get the Title", "Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

			title = "";

		} finally {

			return title;

		}

	}

	/**
	 * 
	 * Validates the WebPage Title with the expected Page Title.
	 *
	 * 
	 * 
	 * @param title
	 * 
	 * @return boolean
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public boolean assertTitle(String title) throws IOException,

			InterruptedException {

		try {

			if (driver.getTitle().contains(title)) {

				updateStep("Title Matched :" + title, "Pass");

				return true;

			} else {

				updateStep("Title Not Matched- Expected: " + title

						+ " Actual: " + driver.getTitle(), "Fail");

				return false;

			}

		} catch (Exception e) {

			updateStep("Error in getting Page Title", "Fail - Exception: "

					+ "\n\t\t" + e.getClass().getSimpleName());

			return false;

		}

	}

	/**
	 * 
	 * Similar to clicking in Back Button on the Browser.
	 *
	 * 
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void back() throws IOException, InterruptedException {

		try {

			driver.navigate().back();

			updateStep("Navigate to Previous page", "Pass");

		} catch (Exception e) {

			updateStep("Navigate to Previous page", "Fail");

		}

	}

	/**
	 * 
	 * Similar to Clicking on Next Button.
	 *
	 * 
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void forward() throws IOException, InterruptedException {

		try {

			driver.navigate().forward();

			updateStep("Navigate to Next page", "Pass");

		} catch (Exception e) {

			updateStep("Navigate to Next page", "Fail");

		}

	}

	/**
	 * 
	 * This method Refreshes the Browser.
	 *
	 * 
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void refresh() throws IOException, InterruptedException {

		try {

			driver.navigate().refresh();

			updateStep("Page Refreshed", "Pass");

		} catch (Exception e) {

			updateStep("Page Refreshed", "Fail");

		}

	}

	/*----------------------------------------------------------------------------------------------------------------------
	
	 *                                            Native Selenium Commands                                     |
	
	           ----------------------------------------------------------------------------------------------------------------------*/

	/**
	 * 
	 * This method performs Click Operation on the WebElement
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param description
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void click(WebElement ele, String description) throws IOException,

			InterruptedException {

		try {
			System.out.println ("Line 2 inside click");
			// highlightElement(ele);

			// ele.click();

			Thread.sleep(500);
			
			try {
				(new WebDriverWait(driver, Duration.ofSeconds(100))).until(ExpectedConditions.elementToBeClickable(ele)).click();
				
			  } catch (Exception e) {
				  
				  System.out.println ("Line 3 catch inside click");
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", ele);
			  }
			

			// unhighlight(ele);

			updateStep(description, "Pass");

			Log.info(description + " : Pass");

		} catch (StaleElementReferenceException sere) {
			// simply retry finding the element in the refreshed DOM
			wait(10000);
			(new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.elementToBeClickable(ele)).click();
		} catch (NoSuchElementException e) {

			updateStep(description, "Fail - Exception: " + "\n\t\t" + e.getClass().getSimpleName());

			Log.error(description + ":   Fail - Exception: " + "\n\t\t" + e.getClass().getSimpleName());

		} catch (TimeoutException e) {

			Thread.sleep(50000);

			(new WebDriverWait(driver, Duration.ofSeconds(100))).until(ExpectedConditions.elementToBeClickable(ele)).click();

			updateStep("TimeOut Exception", "Fail - Exception: " + "\n\t\t" + e.getClass().getSimpleName());

			Log.error(description + ":   Fail - Exception: " + "\n\t\t" + e.getClass().getSimpleName());

			e.printStackTrace();

			return;

		} catch (Exception e) {

			updateStep(description, "Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

			Log.error(description + ":   Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

		}

	}

	/**
	 * 
	 * This method Types the Value in the TextBox given in the WebElement.
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param Value
	 * 
	 * @param description
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void type(WebElement ele, String Value, String description)

			throws IOException, InterruptedException {

		try {

			System.out.println ("Line 1 inside type");
			// highlightElement(ele);

			(new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.elementToBeClickable(ele)).clear();
			click(ele, "Click input box");

			ele.sendKeys(Value);

			Thread.sleep(2000);

			updateStep(description, "Pass");

			// System.out.println("sysout : "+Value);

			Log.info(description + " :  Pass");

			// unhighlight(ele);

		} catch (Exception e) {

			updateStep(description, "Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

			Log.error(description + ":   Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

		}

	}

	/**
	 * 
	 * Selects a DropDown by its Value Attribute.
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param Value
	 * 
	 * @param description
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void selectDropdownByValue(WebElement ele, String Value, String description, boolean ClearspanSite)
			throws IOException, InterruptedException {

		boolean result = false;
		int attempts = 1;

		while ((attempts <= 10) || (result)) {
			try {

				// highlightElement(ele);

				Select se = new Select(ele);

				se.selectByValue(Value);

				// ele.sendKeys(Keys.TAB);

				// ele.submit();

				updateStep(description, "Pass");

				// unhighlight(ele);

				result = true;
				break;

			} catch (StaleElementReferenceException e) {
				Log.info("Cought the exception - StaleElementReferenceException at attempt: " + attempts);
				System.out.println("Cought the exception - StaleElementReferenceException at attempt: " + attempts
						+ ". Reattempting after 10 seconds ");
				Thread.sleep(10000);
				attempts++;

			} catch (Exception e) {
				updateStep(description, "Fail - Exception: " + "\n\t\t" + e.getClass().getSimpleName());
			}
		}
	}

	/**
	 * 
	 * Selects a DropDown by its Value Attribute.
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param Value
	 * 
	 * @param description
	 * @throws Exception
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	// public void selectDropDownByValueNewUI(WebElement eleDropDown, String
	// strValue, String description)
	// throws Exception {
	// if (!strValue.isEmpty()) {
	//
	// click(eleDropDown, description);
	// // Select the element by click again from the Options
	// driver.findElement(By.xpath("//li[contains(., '" + strValue +
	// "')]")).click();
	//
	// assertTrue(eleDropDown.getText() == strValue);
	// }
	//
	// }

	public void selectDropdownByValue(WebElement eleDropDown, String strValue, String description)
			throws IOException, InterruptedException {

		if (!strValue.isEmpty()) {
			try {

				String strLabelText = eleDropDown.getText();
				if (strLabelText.equals(strValue)) {
					// Do nothing
					updateStep("Item already selected in the dropDown: " + strValue, "Pass");
					return;
				}

				// Click the dropDown first
				click(eleDropDown, "Clicking on the dropDown to select: " + strValue);
				wait(5000);
				// Select the element by click again from the Options
				click(driver.findElement(By.xpath("(//li[contains(text(), '" + strValue + "')])[last()]")),
						"Selecting item from dropdown: " + strValue);
				wait(5000);
				updateStep(description, "Pass");
			} catch (Exception e) {
				updateStep("Select item from Dropdown: " + strValue + " Failed",
						"Fail - Exception: " + "\n\t\t" + e.getClass().getSimpleName());
			}
		} else {
			updateStep("Value not provided for selection", "Fail");
		}
	}

	public void selectDropdownByValue(WebElement eleDropDown, String strValue, int position, String description)
			throws IOException, InterruptedException {

		if (!strValue.isEmpty()) {
			try {

				String strLabelText = eleDropDown.getText();
				if (strLabelText.equals(strValue)) {
					// Do nothing
					updateStep("Item already selected in the dropDown: " + strValue, "Pass");
					return;
				}

				// Click the dropDown first
				click(eleDropDown, "Clicking on the dropDown to select: " + strValue);
				wait(5000);
				// Select the element by click again from the Options
				String strIndex = "";
				if (position == -1){
					strIndex = "last()";
				} else {
					strIndex = String.valueOf(position);
				}
				click(driver.findElement(By.xpath("(//li[contains(text(), '" + strValue + "')])[" + strIndex + "]")),
						"Selecting item from dropdown: " + strValue);
				wait(5000);
				updateStep(description, "Pass");
			} catch (Exception e) {
				updateStep("Select item from Dropdown: " + strValue + " Failed",
						"Fail - Exception: " + "\n\t\t" + e.getClass().getSimpleName());
			}
		} else {
			updateStep("Value not provided for selection", "Fail");
		}
	}
	
	public void selectDropdownByValue(String strEleDropDownId, String strValue, String description)
			throws IOException, InterruptedException {

		if (!strValue.isEmpty()) {
			try {
				// Click the dropDown first
				// Get text
				wait(3000);
				String xpath = strEleDropDownId + "_label";
				WebElement dropDownLabel = driver.findElement(By.id(xpath));

				String strLabelText = driver.findElement(By.id(xpath)).getText();
				if (strLabelText.equals(strValue)) {
					// Do nothing
					updateStep("Item already selected in the dropDown: " + strValue, "Pass");
					return;
				} else {

					click(dropDownLabel, "Click on dropdown: " + strEleDropDownId);
					wait(5000);

					String strXpath = "//*[@id='" + strEleDropDownId + "_items']//li[contains(.,'" + strValue + "')]";
					WebElement dropDownList = driver.findElement(By.xpath(strXpath));
					click(dropDownList, "Selecting item from dropdown: " + strValue);
					wait(2500);

					String strTitle = driver.findElement(By.id("form1:staticTextScreenName")).getText();
					if (!(strTitle.contains("Privileges"))) {
						dropDownLabel = driver.findElement(By.id(xpath));
						wait(2000);
						dropDownLabel.submit();
						wait(2000);
					}

					wait(500);

					updateStep(description, "Pass");
				}

			} catch (Exception e) {
				updateStep("Select item from Dropdown: " + strValue + " Failed",
						"Fail - Exception: " + "\n\t\t" + e.getClass().getSimpleName());
			}
		} else {
			updateStep("Value not provided for selection", "Fail");
		}
		return;
	}

	
	
	public void selectDropdownByExactValue(WebElement eleDropDown, String strValue, String description)
			throws IOException, InterruptedException {

		if (!strValue.isEmpty()) {
			try {

				String strLabelText = eleDropDown.getText();
				if (strLabelText.equals(strValue)) {
					// Do nothing
					updateStep("Item already selected in the dropDown: " + strValue, "Pass");
				} else {
					// Click the dropDown first
					click(eleDropDown, "Clicking on the dropDown to select: " + strValue);
					wait(10000);
					// Select the element by click again from the Options
					click(driver.findElement(By.xpath("(//li[text()='" + strValue + "'])")),
							"Selecting item from dropdown: " + strValue);
					wait(5000);
					updateStep(description, "Pass");
				}

			} catch (Exception e) {
				updateStep(description, "Fail - Exception: " + "\n\t\t" + e.getClass().getSimpleName());
			}
		} else {
			updateStep("Value not provided for selection", "Fail");
		}
	}

	// /*
	// * To be deleted
	// *
	// */
	// public void selectDropdownByValue(String strEleDropDownId, String
	// strItemsEleID, String strValue, String description)
	// throws IOException, InterruptedException {
	//
	// if (!strValue.isEmpty()) {
	// try {
	// // Click the dropDown first
	// click(driver.findElement(By.id(strEleDropDownId + "_label")), "Click on
	// dropdown: " + strEleDropDownId);
	// wait(2000);
	// click(driver.findElement(By.xpath(strItemsEleID)), "Selecting item from
	// dropdown: " + strValue);
	// updateStep(description, "Pass");
	//
	// } catch (Exception e) {
	// updateStep(description, "Fail - Exception: " + "\n\t\t" +
	// e.getClass().getSimpleName());
	// }
	// } else {
	// updateStep("Value not provided for selection", "Fail");
	// }
	// }

	/**
	 * 
	 * Selects a DropDown by its Value Attribute.
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param Value
	 * 
	 * @param description
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void selectDropdownByValue(WebElement ele, String Value,

			String description, String strProject) throws IOException, InterruptedException {

		try {

			highlightElement(ele);

			Select se = new Select(ele);

			se.selectByValue(Value);

			updateStep(description, "Pass");

			unhighlight(ele);

		} catch (Exception e) {

			updateStep(description, "Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

		}

	}

	/*
	 * Lib to select a radio button on page given the label of radio buttton
	 * 
	 */
	public void selectRadioButton(String strLabel) throws InterruptedException {
		// Search the label if exists
		try {
			if (driver
					.findElements(By
							.xpath("//div[@class='ui-radiobutton ui-widget']//parent::div//parent::div//following-sibling::label"))
					.size() > 0) {
				// Click the radio button adjacent to the label
				String strXpath = "(//div[@class='ui-radiobutton ui-widget']//parent::div//parent::div//following-sibling::label[contains(text(), '"
						+ strLabel + "')])[1]";
				driver.findElement(By.xpath(strXpath)).click();
				wait(3000);
				updateStep("Select Radio Button - " + strLabel + " Passed", "Pass");
				// }
			}
		} catch (NoSuchElementException e) {
			updateStep("Select Radio Button - " + strLabel + " Failed!", "Fail");
		}
		//
	}
	
	/*
	 * Lib to select a radio button on page given the label of radio buttton
	 * 
	 */
	public void selectRadioButtonByExactLabel(String strLabel) throws InterruptedException {
		// Search the label if exists
		try {
			if (driver
					.findElements(By
							.xpath("//div[@class='ui-radiobutton ui-widget']//parent::div//parent::div//following-sibling::label"))
					.size() > 0) {
				// Click the radio button adjacent to the label
				String strXpath = "(//div[@class='ui-radiobutton ui-widget']//parent::div//parent::div//following-sibling::label[text()='"
						+ strLabel + "'])";
				driver.findElement(By.xpath(strXpath)).click();
				wait(3000);
				updateStep("Select Radio Button - " + strLabel + " Passed", "Pass");
				// }
			}
		} catch (NoSuchElementException e) {
			updateStep("Select Radio Button - " + strLabel + " Failed!", "Fail");
		}
		//
	}
	
	/*
	 *  Select WorksheetCheckboxByLabel
	 */
	/*
	 * Lib to select a radio button on page given the label of radio buttton
	 * 
	 */
	public void SelectWorksheetCheckboxByLabel(String strLabel) throws InterruptedException {
		// Search the label if exists
		try {
		
				// Click the radio button adjacent to the label
				String strXpath = "//label[contains(.,'PhoneNumbers')]//parent::td//div[2]//span";
				driver.findElement(By.xpath(strXpath)).click();
				wait(3000);
				updateStep("Select Radio Button - " + strLabel + " Passed", "Pass");
				// }
		
		} catch (NoSuchElementException e) {
			updateStep("Select Radio Button - " + strLabel + " Failed!", "Fail");
		}
		//
	}

	/*
	 * Lib to select a check box on page given the id of the check box
	 * 
	 */

	public void selectCheckBox(String eleCheckBoxIDWithout_input, boolean blnSelectOrDeselect)
			throws InterruptedException {
		try {

			List<WebElement> eleCheckBoxes = driver.findElements(By.id(eleCheckBoxIDWithout_input));
			WebElement eleCheckBox = eleCheckBoxes.get(0);

			String eleCheckBoxIDHiddenElement = eleCheckBoxIDWithout_input + "_input";
			String strCheckBoxCurrentStatus = driver.findElement(By.id(eleCheckBoxIDHiddenElement))
					.getAttribute("aria-checked");
			if (strCheckBoxCurrentStatus.equals("true")) {
				updateStep("Check Box is currently checked", "Info");
				if (!blnSelectOrDeselect) {
					eleCheckBox.click();
					updateStep("Deselect Check Box Passed!", "Pass");

				}
			} else {
				updateStep("Check Box is currently not checked", "Info");
				if (blnSelectOrDeselect) {
					eleCheckBox.click();
					updateStep("Select Check Box Passed!", "Pass");
				}
			}

		} catch (NoSuchElementException e) {
			updateStep("Select / Deselect Check Box Failed!", "Fail");
		}
	}

	public boolean isCheckBoxSelected(String eleCheckBoxIDWithout) throws InterruptedException {
		try {
			String strCheckBoxCurrentStatus = driver.findElement(By.id(eleCheckBoxIDWithout))
					.getAttribute("aria-checked");
			if (strCheckBoxCurrentStatus.equals("true")) {
				updateStep("Check Box is currently checked", "Info");
				return true;
			}
		} catch (NoSuchElementException e) {
			updateStep("Select / Deselect Check Box Failed!", "Fail");
		}

		updateStep("Check Box is currently not checked", "Info");
		return false;
	}

	/*
	 * Lib to select a group check box on page given the id of the check box
	 * 
	 */

	public void selectCheckBox(String eleCheckBoxLabel, boolean blnSelectOrDeselect, String strGroup)
			throws InterruptedException, IOException {
		try {

			if (strGroup == "") {
				strGroup = "Advanced";
			}

			String strXpathToCheckbox = "//*[@id='form1:chk" + strGroup + "ExportTabs']/tbody//label[contains(text(),'"
					+ eleCheckBoxLabel + "')]";

			// List<WebElement>
			WebElement chbox = driver.findElement(By.xpath(strXpathToCheckbox));
			if (chbox != null) {
				click(chbox, "Selecting checkbox with label:" + eleCheckBoxLabel);
				wait(2000);
			}

		} catch (NoSuchElementException e) {
			updateStep("Select / Deselect Check Box Failed!", "Fail");
		}
	}

	// public void selectDropdownByValue(WebElement eleDropDown, String
	// strValue,
	// String description) throws IOException, InterruptedException {
	//
	// if (!strValue.isEmpty()) {
	//
	//// boolean result = false;
	//// int attempts = 1;
	////
	//// while ((attempts <= 10) || (result)) {
	// try {
	//
	// // highlightElement(ele);
	//
	//// ele.click();
	//
	//// wait(2000);
	//
	// //Click the dropDown first
	// click(eleDropDown, description);
	//
	// // Select the element by click again from the Options
	// driver.findElement(By.xpath("//li[contains(., '" + strValue +
	// "')]")).click();
	//
	//// Select se = new Select(ele);
	////
	//// se.selectByValue(Value);
	////
	//// ele.sendKeys(Keys.TAB);
	////
	//// ele.submit();
	//
	// updateStep(description, "Pass");
	//
	// // unhighlight(ele);
	//
	//// result = true;
	//// break;
	//
	//// } catch (StaleElementReferenceException e) {
	//// Log.info("Cought the exception - StaleElementReferenceException at
	// attempt: " + attempts);
	//// System.out.println("Cought the exception -
	// StaleElementReferenceException at attempt: " + attempts
	//// + ". Reattempting after 10 seconds ");
	//// Thread.sleep(10000);
	//// attempts++;
	////
	// } catch (Exception e) {
	// updateStep(description, "Fail - Exception: " + "\n\t\t" +
	// e.getClass().getSimpleName());
	// }
	// } else {
	// updateStep("Value not provided for selection", "Fail");
	// }
	// }

	/**
	 * 
	 * Select the Dropdown value by the index of its occurrence.
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param Value
	 * 
	 * @param description
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

/*	public void selectDropdownByIndex(WebElement eleDropDown, int intIndex, String description)
			throws IOException, InterruptedException {

		if (!strValue.isEmpty()) {
			try {
				// Click the dropDown first
				click(eleDropDown, description);

				// Select the element by click again from the Options
				driver.findElement(By.xpath("//li[contains(., '" + strValue + "')]")).click();
				updateStep(description, "Pass");

			} catch (Exception e) {
				updateStep(description, "Fail - Exception: " + "\n\t\t" + e.getClass().getSimpleName());
			}
		} else {
			updateStep("Value not provided for selection", "Fail");
		}
	}*/

	public void selectDropdownByIndex(String eleWithoutLabel, String strValue,
			String description) throws IOException, InterruptedException {

		boolean result = false;
		int attempts = 1;

//		while ((attempts <= 10) || (result)) {
			try {
				
				driver.findElement(By.id("eleWithoutLabel" + "_label")).click();
				wait(3000);
				
				driver.findElement(By.id("eleWithoutLabel" + "_" + strValue)).click();
				updateStep(description, "Pass");
				
				
//				String strLabelText = eleWithoutLabel.getText();
//				if (strLabelText.equals(strValue)) {
//					// Do nothing
//					updateStep("Item already selected in the dropDown: " + strValue, "Pass");
//				} else {
//					// Click the dropDown first
//					click(eleDropDown, "Clicking on the dropDown to select: " + strValue);
//					wait(10000);
//					// Select the element by click again from the Options
//					click(driver.findElement(By.xpath("(//li[text()='" + strValue + "'])")),
//							"Selecting item from dropdown: " + strValue);
//					wait(5000);
//					updateStep(description, "Pass");
//				}
//				
//
//				// highlightElement(ele);
//
//				Select se = new Select(ele);s sdfg
//
//				Thread.sleep(3000);
//
//				se.selectByIndex(Value);
//
//				Thread.sleep(3000);
//
//				// ele.submit();
//
//				ele.sendKeys(Keys.TAB);
//
//				// ele.submit();
//
//				updateStep(description, "Pass");
//				result = true;
//				break;

				// unhighlight(ele);

			
//			} catch (StaleElementReferenceException e) {
//				Log.info("Cought the exception - StaleElementReferenceException at attempt: " + attempts);
//				System.out.println("Cought the exception - StaleElementReferenceException at attempt: " + attempts
//						+ ". Reattempting after 10 seconds ");
//				Thread.sleep(10000);
//
//				attempts++;
			} catch (Exception e) {

				updateStep(description, "Fail - Exception: " + "\n\t\t"

						+ e.getClass().getSimpleName());

			}
//		}
	}
	
	/**
	 * 
	 * Selects DropDown by the Value displayed in the list.
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param Value
	 * 
	 * @param description
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void selectDropdownByVisibleText(WebElement eleDropDown, String strValue, String description)
			throws IOException, InterruptedException {

		if (!strValue.isEmpty()) {
			try {

				// Get the options from the drop down list
				String[] arrListItems;
				// List<WebElement> lstOptions = eleDropDown
				// .findElements(By.xpath("//*[@id=\"form1:dropDownLoginLevel_input\"]//option"));
				// if (lstOptions.size() > 0) {
				//
				// // Iterate through the list and check if the expected item
				// // is present
				// for (WebElement we : lstOptions) {
				// // dropDown.sendKeys( Keys.DOWN ); //simulate visual
				// // movement
				// // sleep(250);
				// if (we.getText().contains(strValue)) {
				// // Get the index using @value
				// String dropDownItemValue = we.getAttribute("value");
				//
				// }
				// }
				// }

				List<WebElement> lstOptions = eleDropDown.findElements(By.xpath("//option"));
				// .findElements(By.xpath("//*[@id=\"form1:dropDownLoginLevel_input\"]//option"));
				if (lstOptions.size() > 0) {
					// Iterate through the list and check if the expected item
					// is present
					for (WebElement we : lstOptions) {
						// dropDown.sendKeys( Keys.DOWN ); //simulate visual
						// movement
						// sleep(250);
						if (we.getText().contains(strValue)) {
							// Get the index using @value
							String dropDownItemValue = we.getAttribute("value");

						}
					}
				}

				// Click the dropDown first
				click(eleDropDown, "Clicking on the dropDown to select: " + strValue);
				wait(2000);

				// Select the element by click again from the Options
				driver.findElement(By.xpath("//li[contains(., '" + strValue + "')]")).click();

				wait(5000);

				updateStep(description, "Pass");

			} catch (Exception e) {
				updateStep(description, "Fail - Exception: " + "\n\t\t" + e.getClass().getSimpleName());
			}
		} else {
			updateStep("Value not provided for selection", "Fail");
		}
	}

	/*
	 * Lib only for Clearspan portal
	 */
	public void selectDropdownByVisibleText(WebElement ele, String Value,
			String description, boolean Clearspan) throws IOException, InterruptedException {

		boolean result = false;
		int attempts = 1;

		while ((attempts <= 10) || (result)) {
			try {

				// highlightElement(ele);

				Select se = new Select(ele);

				se.selectByVisibleText(Value);

				ele.sendKeys(Keys.TAB);

				ele.submit();

				updateStep(description, "Pass");

				// unhighlight(ele);
				result = true;
				break;

			} catch (StaleElementReferenceException e) {
				// Log.info("Cought the exception -
				// StaleElementReferenceException atattempt: " + attempts);
				// System.out.println("Cought the exception -
				// StaleElementReferenceException
				// at attempt: " + attempts
				// + ". Reattempting after 10 seconds ");
				Thread.sleep(10000);

				attempts++;
			} catch (Exception e) {

				updateStep(description, "Fail - Exception: " + "\n\t\t"

						+ e.getClass().getSimpleName());

			}
		}

	}

	/**
	 * 
	 * Returns the text visible on the WebElement/Label.
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param description
	 * 
	 * @return String
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public String getText(WebElement ele, String description)

			throws IOException, InterruptedException {

		String text;

		try {

			highlightElement(ele);

			text = ele.getText();

			// updateStep(description, "Pass");

			unhighlight(ele);

		} catch (Exception e) {

			text = "";

			updateStep(description, "Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

		}

		return text;

	}

	/**
	 * 
	 * Validates the text Present at the WebElement is exactly the same as
	 * 
	 * Expected.
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param expText
	 * 
	 * @return boolean
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public Boolean assertTextEquals(WebElement ele, String expText)

			throws IOException, InterruptedException {

		String actText;

		try {

			highlightElement(ele);

			actText = ele.getText();

			if (actText.equalsIgnoreCase(expText)) {

				updateStep("Text Matched :" + expText, "Pass");

				unhighlight(ele);

				return true;

			} else {

				updateStep("Text Not Matched Expected:" + expText + " Actual: "

						+ actText, "Fail");

				return false;

			}

		} catch (Exception e) {

			updateStep("Error while Retrieving Text", "Fail - Exception: "

					+ "\n\t\t" + e.getClass().getSimpleName());

			return false;

		}

	}

	/**
	 * 
	 * Validates the text Present at the WebElement is partially same as
	 * 
	 * Expected.
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param expText
	 * 
	 * @return boolean
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public Boolean assertTextContains(WebElement ele, String expText)

			throws IOException, InterruptedException {

		String actText;

		try {

			highlightElement(ele);

			actText = ele.getText();

			unhighlight(ele);

			if (actText.contains(expText)) {

				updateStep("Text Present :" + expText, "Pass");

				return true;

			} else {

				updateStep("Text Not Present- Expected:" + expText

						+ " Actual: " + actText, "Fail");

				return false;

			}

		} catch (Exception e) {

			updateStep("Error while Retrieving Text", "Fail - Exception: "

					+ "\n\t\t" + e.getClass().getSimpleName());

			return false;

		}

	}

	/*----------------------------------------------------------------------------------------------------------------------
	
	 *                                            SYNTHETIC Selenium Commands(ACTIONS CLASS)                                     |
	
	           ----------------------------------------------------------------------------------------------------------------------*/

	/**
	 * 
	 * Performs MouseOver on the Element.
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param description
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void mouseOver(WebElement ele, String description)

			throws IOException, InterruptedException {

		try {

			highlightElement(ele);

			Actions act = new Actions(driver);

			act.moveToElement(ele).build().perform();

			updateStep(description, "Pass");

			unhighlight(ele);

		} catch (Exception e) {

			updateStep(description, "Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

		}

	}

	/**
	 * 
	 * Similar to Click.Can click on Hidden Elements also.
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param description
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void clickAt(WebElement ele, String description) throws IOException,

			InterruptedException {

		try {

			highlightElement(ele);

			Actions act = new Actions(driver);

			act.click(ele).build().perform();

			updateStep(description, "Pass");

			unhighlight(ele);

		} catch (Exception e) {

			updateStep(description, "Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

		}

	}

	/**
	 * 
	 * Performs Double Click on the Element.
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param description
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void doubleClick(WebElement ele, String description)

			throws IOException, InterruptedException {

		try {

			highlightElement(ele);

			Actions act = new Actions(driver);

			act.doubleClick(ele).build().perform();

			updateStep(description, "Pass");

			unhighlight(ele);

		} catch (Exception e) {

			updateStep(description, "Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

		}

	}

	/**
	 * 
	 * Performs Right Click on the Element.
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param description
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void rightClick(WebElement ele, String description)

			throws IOException, InterruptedException {

		try {

			highlightElement(ele);

			Actions act = new Actions(driver);

			act.contextClick(ele).build().perform();

			updateStep(description, "Pass");

			unhighlight(ele);

		} catch (Exception e) {

			updateStep(description, "Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

		}

	}

	/**
	 * 
	 * Drags an Element and drops at another location.
	 *
	 * 
	 * 
	 * @param ele1
	 * 
	 * @param ele2
	 * 
	 * @param description
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void dragAndDrop(WebElement ele1, WebElement ele2, String description)

			throws IOException, InterruptedException {

		try {

			highlightElement(ele1);

			highlightElement(ele2);

			Actions act = new Actions(driver);

			act.dragAndDrop(ele1, ele2).build().perform();

			updateStep(description, "Pass");

			unhighlight(ele1);

			unhighlight(ele2);

		} catch (Exception e) {

			updateStep(description, "Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

		}

	}

	/**
	 * 
	 * Slides an element by X and Y Coordinates.
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param x
	 * 
	 * @param y
	 * 
	 * @param description
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void slideBy(WebElement ele, int x, int y, String description)

			throws IOException, InterruptedException {

		try {

			highlightElement(ele);

			Actions act = new Actions(driver);

			act.dragAndDropBy(ele, x, y).build().perform();

			updateStep(description, "Pass");

			unhighlight(ele);

		} catch (Exception e) {

			updateStep(description, "Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

		}

	}

	/**
	 * 
	 * Date:9th July This Method enables fileUpload
	 *
	 * 
	 * 
	 * @throws AWTException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void fileUploadUsingRobot(String fileName) throws AWTException,

			InterruptedException {

		StringSelection ss = new StringSelection(fileName);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);

		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_ENTER);

		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	/**
	 * 
	 * File Upload using AutoIt
	 *
	 * 
	 * 
	 * @throws IOException
	 * 
	 */

	public void fileUpload(WebElement ele, String path) throws IOException {

		File file = new File(path);

		path = file.getCanonicalPath();

		String cmd = null;

		if (driver instanceof FirefoxDriver) {

			cmd = ".\\lib\\fileuploadFF.exe";

		}

		if (driver instanceof ChromeDriver) {

			cmd = ".\\lib\\fileuploadCHROME.exe";

		}

		if (driver instanceof InternetExplorerDriver) {

			cmd = ".\\lib\\fileuploadIE.exe";

		}

		ProcessBuilder pb = new ProcessBuilder(cmd, path);

		pb.start();

		try {

			highlightElement(ele);

			updateStep("Click on Browse Button for File Upload", "Pass");

			ele.click();

			unhighlight(ele);

		} catch (Exception e) {

			updateStep("Exception while clicking Browse Button",

					"Fail - Exception: " + "\n\t\t"

							+ e.getClass().getSimpleName());

		}

	}

	/**
	 * 
	 * This Method returns the URL of the current page
	 *
	 * 
	 * 
	 * @return String
	 * 
	 */

	public String getCurrentUrl() {

		Log.info(".......Get the current url...........");

		return driver.getCurrentUrl();

	}

	/**
	 * 
	 * This Method returns the value of the WebElememt based on the attribute
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param attribute
	 * 
	 * @param description
	 * 
	 * @return String
	 * 
	 */

	public String getAttribute(WebElement ele, String attribute,

			String description) {

		Log.info(".......Get the attribute value...........");

		try {

			highlightElement(ele);

			updateStep(description, "Pass");

			unhighlight(ele);

			return ele.getAttribute(attribute);

		} catch (InterruptedException e) {

			updateStep(description, "Fail");

			return null;

		}

	}

	/*
	 * 
	 * KeyBoard Shortcut Starts here
	 * 
	 */

	/**
	 * 
	 * This method performs keyboard Event Escape
	 * 
	 */

	public void pressEscape() {

		Actions act = new Actions(driver);

		act.sendKeys(Keys.ESCAPE).build().perform();

	}

	/**
	 * 
	 * This method performs keyboard Event Enter
	 * 
	 */

	public void pressEnter() {

		Actions act = new Actions(driver);

		act.sendKeys(Keys.ENTER).build().perform();

	}

	public void endReport() {

		updateStep("End Of Execution", "END");

		super.endOfTestCase = true;

	}

	/**
	 * 
	 * Read and Write to Buffer
	 *
	 * 
	 * 
	 * @throws IOException
	 * 
	 */

	/**
	 * 
	 * This method reads the value from Buffer
	 *
	 * 
	 * 
	 * @param key
	 * 
	 * @return
	 * 
	 */

	/*
	 * public String readFromBuffer(String key) {
	 * 
	 * String value = "";
	 * 
	 * try {
	 * 
	 * value = Buffer.getBuffer(key);
	 * 
	 * } catch (Exception e) {
	 * 
	 * updateStep("Exception while Reading the key from buffer: " + key,
	 * 
	 * "Fail");
	 * 
	 * }
	 * 
	 * return value;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public void writeIntoBuffer(String key, String value) {
	 * 
	 * try {
	 * 
	 * Buffer.setBuffer(key, value);
	 * 
	 * } catch (IOException e) {
	 * 
	 * updateStep("Exception while writing the key value pair into buffer"
	 * 
	 * + key + "," + value, "Fail");
	 * 
	 * }
	 * 
	 * }
	 */

	/**
	 * 
	 * Returns a random number
	 * 
	 */

	public int generateRandomNumber(int range, int startNum) {

		Random rand = new Random();

		int val = rand.nextInt(range) + startNum;

		return val;

	}

	public void typeusingRobot(String fileName) throws AWTException,

			InterruptedException {

		StringSelection ss = new StringSelection(fileName);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(2000);

	}

	public void pressTABusingRobot() throws AWTException, InterruptedException {

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_TAB);

		robot.keyRelease(KeyEvent.VK_TAB);

	}

	public void pressTab() {

		Actions act = new Actions(driver);

		act.sendKeys(Keys.TAB).build().perform();

	}

	// public void pressEnterAndTab(WebElement webElement) {
	//
	//
	// Actions builder = new Actions(driver);
	// Action.contextClick(webElement.sendKeys(Keys.ARROW_DOWN).build())
	// .perform();
	//
	// Action enter= builder
	// .key(Keys.TAB)
	// .build();
	// enter.perform();
	//
	// Action releaseEnter= builder
	// .keyUp(Keys.ENTER)
	// .build();
	// releaseEnter.perform();
	// }

	public void pressEnterusingRobot() throws AWTException,

			InterruptedException {

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);

		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	/*----------------------------------------------------------------------------------------------------------------------
	
	 *             TEST CLASS  RESUABLE KEYWORDS ENDS HERE                                                                        |
	
	           ----------------------------------------------------------------------------------------------------------------------*/

	public void checkDependency(String tcId) {

		if (SuiteRunner.suiteRun == true) {

			// String path=reportPath+"\"+tcid"

			String status = null;

			FileInputStream fstream = null;

			try {

				System.out.println("The report Path is " + reportPathSuite

						+ "\\" + tcId + "\\" + "status.txt");

				fstream = new FileInputStream(reportPathSuite + "\\" + tcId

						+ "\\" + "status.txt");

			} catch (FileNotFoundException e) {

				e.printStackTrace();

				updateStep("The dependent test Case " + tcId + " has not run ",

						"Fail");

			}

			DataInputStream in = new DataInputStream(fstream);

			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String strLine;

			try {

				if ((strLine = br.readLine()) != null) {

					String[] data = strLine.split("###");

					status = data[0];

					// arrTcDesc[i] = data[1];

				}

			} catch (IOException e) {

				e.printStackTrace();

			}

			if (status.equalsIgnoreCase("Fail")) {

				updateStep("The dependent test Case " + tcId

						+ " has Failed:Skipping test case ", "Fail");

			}

		}

	}

	/**
	 * 
	 * Added the method for EDI Connect FTP and SFTP
	 * 
	 */

	/*
	 * public String getTrackingIdFromFTP(String tcID, String propFilePath,
	 * 
	 * String excelFilePath) {
	 * 
	 * String messageID;
	 * 
	 * FTPManager ftpMgr = new FTPManager();
	 * 
	 * ftpMgr.sendFTP(tcID, propFilePath, excelFilePath);
	 * 
	 * System.out.println("FTP Tracking ID = *********** "
	 * 
	 * + ftpMgr.getTrackingId());
	 * 
	 * messageID = ftpMgr.getTrackingId();
	 * 
	 * updateStep("Message Id is :" + messageID, "Pass");
	 * 
	 * return messageID;
	 * 
	 * }
	 */

	/*
	 * public String getTrackingIdFromSFTP(String tcID, String propFilePath,
	 * 
	 * String excelFilePath) {
	 * 
	 * String messageID;
	 * 
	 * SFTPManager sftpMgr = new SFTPManager();
	 * 
	 * sftpMgr.sendSFTP(tcID, propFilePath, excelFilePath);
	 * 
	 * System.out.println("FTP Tracking ID = *********** "
	 * 
	 * + sftpMgr.getTrackingId());
	 * 
	 * messageID = sftpMgr.getTrackingId();
	 * 
	 * updateStep("Message Id is :" + messageID, "Pass");
	 * 
	 * return messageID;
	 * 
	 * }
	 */

	/**
	 * 
	 * Retrieves the latest filename
	 * 
	 */

	public String getTheNewestFile(String filePath, String ext) {

		File theNewestFile = null;

		File dir = new File(filePath);

		FileFilter fileFilter = new WildcardFileFilter("*." + ext);

		File[] files = dir.listFiles(fileFilter);

		if (files.length > 0) {

			/** The newest file comes first **/

			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);

			theNewestFile = files[0];

		}

		System.out.println(theNewestFile.getName());

		return theNewestFile.getName();

	}

	/*----------------------------------------------------------------------------------------------------------------------
	
	 *                                            Native Selenium Commands                                     |
	
	             ----------------------------------------------------------------------------------------------------------------------*/

	/**
	 * 
	 * This method performs Download Operation
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param description
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void fileDownloadUsingRobot() throws AWTException,

			InterruptedException {

		Robot robot = new Robot();

		// For clicking on the Ok button on the dialog box

		robot.keyPress(KeyEvent.VK_ENTER);

		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_LEFT);

		robot.keyRelease(KeyEvent.VK_LEFT);

		Thread.sleep(2000);

		// For clicking on Ok button

		// robot.keyPress(KeyEvent.VK_ENTER);

		// robot.keyRelease(KeyEvent.VK_ENTER);

	}

	/*----------------------------------------------------------------------------------------------------------------------
	
	 *                                            Native Selenium Commands                                     |
	
	             ----------------------------------------------------------------------------------------------------------------------*/

	/**
	 * 
	 * This method performs Click Operation on the WebElement
	 *
	 * 
	 * 
	 * @param ele
	 * 
	 * @param description
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void clear(WebElement ele, String description) throws IOException,

			InterruptedException {

		try {

			highlightElement(ele);

			// System.out.println("1---");

			updateStep(description, "Pass");

			// System.out.println("2-----");

			unhighlight(ele);

			// System.out.println("3------");

			(new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.elementToBeClickable(ele)).clear();

			// ele.clear();

			// System.out.println("4-------");

			// Log.info(description + " : Pass");
			wait(1000);

		} catch (NoSuchElementException e) {

			updateStep(description, "Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

			Log.error(description + ":   Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

		} catch (StaleElementReferenceException sere) {

			// simply retry finding the element in the refreshed DOM
			wait(3000);
			ele.clear();

		}

		catch (TimeoutException e) {

			updateStep("TimeOut Exception", "Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

			Log.error(description + ":   Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

			e.printStackTrace();

			return;

		} catch (Exception e) {

			updateStep(description, "Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

			Log.error(description + ":   Fail - Exception: " + "\n\t\t"

					+ e.getClass().getSimpleName());

		}

	}

}