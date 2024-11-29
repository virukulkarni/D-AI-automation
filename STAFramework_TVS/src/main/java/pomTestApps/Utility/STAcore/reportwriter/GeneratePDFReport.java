package pomTestApps.Utility.STAcore.reportwriter;

/**************************************************
#Project Name: MiTEL_MXONE - Selenium Framework


#Function Name: GeneratePDFReport()
#Description:1.  This method is responsible for generating the PDF report
#Input Parameters:
#Owner: Ashis Kumar Pradhan
#Author: Ashis Kumar Pradhan
#Date of creation: 03-July-16
#Name of person modifying: (Tester Name): Naveen Kumar Punnana
#Date of modification: Modified the report for accomodating MX-One versions from the SUT as a part of demo feedback.
â€˜**************************************************/
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import jakarta.mail.MessagingException;

import org.apache.commons.io.FileUtils;

import com.google.common.io.Resources;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import pomTestApps.STAcore.OperationExecutor;
import pomTestApps.STAcore.POMSuiteRunner;
import pomTestApps.Utility.STAcore.io.Log;
import pomTestApps.Utility.STAcore.mail.MailSender;

public class GeneratePDFReport {

	OperationExecutor OprExec = new OperationExecutor();
	POMSuiteRunner SMXONE = new POMSuiteRunner();

	private String str_filePath;
	private String str_platform = "";
	// private String pageFooter = "";
	
	File source = new File(Resources.getResource("img").getPath());
	
	private String str_headerLogo = source + "\\TVS_Motor_Company_Logo.png";
	private String str_passLogo = source + "\\Pass.jpg";
	private String str_failLogo = source + "\\fail.png";
	private String str_notRunLogo = source + "\\NotRun.jpg";
	private String str_inCompleteLogo = source + "\\Incomplete.jpg";
	// private String reportPath;
	File[] arr_listOfFolders;
	String[] arr_arrTcId;
	public static String[] arr_teststatus;
	String[] arr_arrTcDesc;

	public static String arr_testPlanName;
	public static String arr_testEnvironment;
	public static String arr_testSolution;
	public static String strTitle;

	// Place holder to store opeasy build info
	public static String strAUTBuildInfo = "";
	public static String strAUTOSInfo = "";
	public static String strAUTBrowserInfo = "";

	Anchor anchor;

	public void setListofFolder(File[] listOfFolders) {
		this.arr_listOfFolders = listOfFolders;
	}

	public void settestStatus(String[] teststatus) {
		this.arr_teststatus = teststatus;
	}

	public void setarrTcDesc(String[] arrTcDesc) {
		this.arr_arrTcDesc = arrTcDesc;
	}

	public void setarrTcId(String[] arrTcId) {
		this.arr_arrTcId = arrTcId;
	}

	public static ArrayList<ArrayList<ArrayList<String[]>>> suiteTestDetails = new ArrayList<ArrayList<ArrayList<String[]>>>();
	public static ArrayList<ArrayList<String>> suiteBrowserList = new ArrayList<ArrayList<String>>();

	public static ArrayList<Object[]> tcNameandTime = new ArrayList<Object[]>();

	Font fntDate;
	Font fontHd = FontFactory.getFont("Times", 22, Font.BOLD);;
	Font font_tabHeader = FontFactory.getFont("Times", 16, Font.BOLD);
	Font font_tabHeader1 = FontFactory.getFont("Times", 16, Font.BOLD);
	Font font_tabData = FontFactory.getFont("Calibri", 11, Font.NORMAL);
	Font font_statusPass = FontFactory.getFont("Times", 15, Font.NORMAL);
	Font font_statusFail = FontFactory.getFont("Times", 15, Font.NORMAL);
	Font font_statusIncomplete = FontFactory.getFont("Times", 15, Font.NORMAL);
	Font font_statusEnd = FontFactory.getFont("Times", 15, Font.NORMAL);
	Font font_statusNotRun = FontFactory.getFont("Times", 15, Font.NORMAL);
	Font font_summaryHeader = FontFactory.getFont("Times", 14, Font.BOLD);

	private void setFont() {
		font_tabHeader.setColor(BaseColor.BLACK);
		fontHd.setColor(BaseColor.BLUE);
		font_tabHeader1.setColor(BaseColor.BLACK);
		font_tabData.setColor(BaseColor.BLACK);
		font_statusPass.setColor(BaseColor.GREEN.darker());
		font_statusFail.setColor(BaseColor.RED.darker());
		font_statusIncomplete.setColor(BaseColor.MAGENTA.darker());
		font_statusNotRun.setColor(BaseColor.YELLOW.darker());
	}

	/**
	 * --------------------------------- HEADER - 1 SECTION
	 * STARTS---------------------------------------- The below section
	 * Represents the Header Table . 1)Logo 2)Solution Name
	 */

	private PdfPTable headerTable;
	Document document;

	@SuppressWarnings("deprecation")
	public void createPDF(String reportPath, Date startTime, Date endTime)
			throws MalformedURLException, IOException, DocumentException {

		/*
		 * Create Excel Report - Added on 25th Sept
		 */

		//str_platform = POMSuiteRunner.strSUTReleaseName + " " 
		//		+ POMSuiteRunner.strEmailNReportHeadline;
		
		str_platform = POMSuiteRunner.strEmailNReportHeadline;

		GenerateExcelReport ger = new GenerateExcelReport(reportPath, arr_listOfFolders, arr_arrTcId, arr_arrTcDesc,
				arr_teststatus, arr_testSolution);
		try {
			ger.generateexcel();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
		

		/*
		 * Create XML Report - Added on May 2022
		 */
		
		GenerateXmlReport gxr = new GenerateXmlReport(reportPath, arr_listOfFolders, arr_arrTcId, arr_arrTcDesc,
				arr_teststatus, arr_testSolution);
		
		System.out.println("Generating XML report");
		
		try {
			gxr.generatexml();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < tcNameandTime.size(); i++) {
			System.out.println("The Name of TC is " + tcNameandTime.get(i)[0]);
			System.out.println("The Start time of the TC is " + tcNameandTime.get(i)[1]);
			System.out.println("The End time of TC is " + tcNameandTime.get(i)[2]);
		}

		System.out.println("Inside Create PDF");
		System.out.println("start Time :" + startTime.getHours() + ":" + startTime.getMinutes());
		System.out.println("end Time :" + endTime.getTime());
		/**
		 * Method to create PDF report using iText
		 * 
		 * @param jsonObjArrOutput
		 * @throws IOException
		 * @throws DocumentException
		 */
		// Set the report Folder
		str_filePath = reportPath + "\\" + "Suite_Execution_Report.pdf";
		// Set the Fonts
		setFont();

		if ((arr_testPlanName == null) || (arr_testPlanName.isEmpty())) {
			arr_testPlanName = "Test Plan";
		}

		if ((arr_testEnvironment == null) || (arr_testEnvironment.isEmpty())) {
			arr_testEnvironment = "Test Environment";
		}

		if ((arr_testSolution == null) || (arr_testSolution.isEmpty())) {
			arr_testSolution = "SOLUTION";
		}
		// Define the Document and its name
		// document = new Document(PageSize.A4.rotate());
		document = new Document(PageSize.A4.rotate());
		Font bold = new Font();
		bold.setStyle(22);

		PdfWriter.getInstance(document, new FileOutputStream(str_filePath));
		document.open();

		document.addCreator("TVS Motor Automation Suite");
		document.addAuthor("TVS Motor Automation Team");
		document.addTitle("Test Suite Report");

		// Header Table
		headerTable = new PdfPTable(1);
		headerTable.setSplitLate(true);
		headerTable.setWidthPercentage(100);
		headerTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		headerTable.getDefaultCell().setVerticalAlignment(Element.ALIGN_TOP);

		// Set Date
		PdfPCell clDate = new PdfPCell();
		clDate.setUseDescender(true);

		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY");
		Date date = new Date();

		Font fntDate = FontFactory.getFont("Times", 15, Font.BOLD);
		fntDate.setColor(BaseColor.BLACK);
		Paragraph pDate = new Paragraph(String.format(dateFormat.format(date)), fntDate);

		// Header
		Image imgLogo = Image.getInstance(String.format(str_headerLogo, "0120903"));
		imgLogo.scaleAbsolute(100, 150);
		PdfPCell clHdLogo = new PdfPCell();
		clHdLogo.setBackgroundColor(BaseColor.WHITE);
		clHdLogo.setVerticalAlignment(Element.ALIGN_MIDDLE);
		clHdLogo.setHorizontalAlignment(Element.ALIGN_CENTER);
		clHdLogo.addElement(imgLogo);
		clHdLogo.setBorder(4);

		// Font fontHd = FontFactory.getFont("Times-Roman", 25, Font.BOLD);
		str_platform = str_platform;
		Paragraph pHdText = new Paragraph(String.format(str_platform), fontHd);
		fontHd.setColor(WebColors.getRGBColor("#6C94E6"));
		pHdText.setAlignment(Element.ALIGN_CENTER);
		PdfPCell clHdText = new PdfPCell();
		clHdText.setBackgroundColor(BaseColor.WHITE);
		clHdText.setVerticalAlignment(Element.ALIGN_MIDDLE);
		clHdText.setHorizontalAlignment(Element.ALIGN_CENTER);
		clHdText.setUseAscender(true);
		clHdText.addElement(pHdText);
		clHdText.setBorder(0);
		clHdText.setPaddingTop(2);

		PdfPTable tbTop = new PdfPTable(2);
		tbTop.addCell(clHdLogo);
		tbTop.addCell(clHdText);

		float[] hdColWidths = new float[] { 10f, 40f };
		tbTop.setWidths(hdColWidths);

		// Add header
		headerTable.addCell(tbTop);
		document.add(headerTable);
		// ***********************************************HEADER 1 TABLE
		// ENDS*******************************************************

		/***********************************
		 * HEADER 2 TABLE STARTS***************************** TEST PLAN,
		 * EXECUTION DATE, ENVIRONMENT HEAD DETAILS, Version of PM, SNM & RPM
		 *********************************************************************************************************/

		document.add(new Paragraph("\n"));
		PdfPTable Header2 = new PdfPTable(3);
		Header2.setWidthPercentage(100f);
		/*
		 * //Header2.s Header2.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		 */
		PdfPCell h2Cell1 = new PdfPCell();
		PdfPCell h2Cell2 = new PdfPCell();
		PdfPCell h2Cell3 = new PdfPCell();
		/*
		 * PdfPCell h2Cell4 = new PdfPCell(); PdfPCell h2Cell5 = new PdfPCell();
		 * PdfPCell h2Cell6 = new PdfPCell();
		 */
		// PdfPCell h2Cell7 = new PdfPCell();

		h2Cell1.setBorder(Rectangle.NO_BORDER);
		h2Cell2.setBorder(Rectangle.NO_BORDER);
		h2Cell3.setBorder(Rectangle.NO_BORDER);
		/*
		 * h2Cell4.setBorder(Rectangle.NO_BORDER);
		 * h2Cell5.setBorder(Rectangle.NO_BORDER);
		 * h2Cell6.setBorder(Rectangle.NO_BORDER);
		 */
		// h2Cell7.setBorder(Rectangle.NO_BORDER);

		/*
		 * Paragraph chnk1 = new Paragraph("Test Plan");
		 * chnk1.setFont(font_tabHeader1);
		 * chnk1.setAlignment(Element.ALIGN_LEFT);
		 */
		Paragraph chnk1 = new Paragraph("Execution Date");
		chnk1.setFont(font_tabHeader1);
		chnk1.setAlignment(Element.ALIGN_LEFT);
		/*
		 * Paragraph chnk3 = new Paragraph("Environment");
		 * chnk3.setFont(font_tabHeader1);
		 * chnk3.setAlignment(Element.ALIGN_RIGHT);
		 */

		/* Paragraph phr1 = new Paragraph(arr_testPlanName); */
		Paragraph chnk3 = new Paragraph(pDate);
		/* Paragraph phr3 = new Paragraph(arr_testEnvironment); */

		/* phr1.setAlignment(Element.ALIGN_LEFT); */
		chnk3.setAlignment(Element.ALIGN_RIGHT);
		/* phr3.setAlignment(Element.ALIGN_RIGHT); */

		h2Cell1.addElement(chnk1);
		/* h2Cell2.addElement(chnk1); */
		h2Cell3.addElement(chnk3);
		/* h2Cell4.addElement(phr1); */
		/* h2Cell5.addElement(phr); */
		/* h2Cell6.addElement(phr3); */
		// h2Cell7.addElement(new Paragraph("\n"));

		Header2.addCell(h2Cell1);
		Header2.addCell(h2Cell2);
		Header2.addCell(h2Cell3);

		/*
		 * Header2.addCell(h2Cell4); Header2.addCell(h2Cell5);
		 * Header2.addCell(h2Cell6);
		 */

		document.add(new LineSeparator());
		document.add(Header2);
		document.add(new Paragraph("\n"));
		document.add(new LineSeparator());
		document.add(new Paragraph("\n"));

		// *****************************************************HEADER 2 TABLE
		// ENDS*****************************************

		/*********************************************
		 * Application RPM Version details start here.
		 */

		PdfPTable VersionColHeader = new PdfPTable(2);

		VersionColHeader.setWidthPercentage(50f);

		String strSUTVersion = "Application Version " + strAUTBuildInfo;

		Chunk Verchunk1 = new Chunk(strSUTVersion, font_tabHeader);
		Verchunk1.setLocalDestination("Application Version");
		Paragraph VersionSummary = new Paragraph();
		VersionSummary.add(Verchunk1);
		VersionSummary.setAlignment(Element.ALIGN_CENTER);

		PdfPCell sumCol00 = new PdfPCell();
		sumCol00.setColspan(2);
		sumCol00.addElement(VersionSummary);
		sumCol00.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
		sumCol00.setVerticalAlignment(Element.ALIGN_MIDDLE);
		sumCol00.setHorizontalAlignment(Element.ALIGN_CENTER);
		sumCol00.setPaddingBottom(12);
		VersionColHeader.addCell(sumCol00);
		/*
		 * VersionColHeader.addCell(sumCol011);
		 * VersionColHeader.addCell(sumCol012);
		 * VersionColHeader.addCell(sumCol13);
		 * VersionColHeader.addCell(sumCol14);
		 * VersionColHeader.addCell(sumCol15);
		 * VersionColHeader.addCell(sumCol16);
		 * VersionColHeader.addCell(sumCol17);
		 * VersionColHeader.addCell(sumCol18);
		 * VersionColHeader.addCell(sumCol19);
		 * VersionColHeader.addCell(sumCol111);
		 * VersionColHeader.addCell(sumCol112);
		 * VersionColHeader.addCell(sumCol113);
		 */

		document.add(VersionColHeader);

		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));

		/*********************************************
		 * EXECUTION SUMMARY REPORT TABLE STARTS THE BELOW SECTIONS DEALS WITH
		 * THE EXECUTION SUMMARY DETAILS 1)EXECUTION START TIME 2)EXECUTION END
		 * TIME 3)TOTAL TEST CASES EXECUTED 4)TESTCASES PASSED 5)TESTCASES
		 * FAILED 6)TEST CASES NOT RUN 7)TEST CASES INCOMPLETE
		 * 
		 * 
		 * 
		 * 
		 */
		// EXECUTION SUMMARY DETAILS

		Paragraph Summary1 = new Paragraph(String.format("Start Time : "), font_summaryHeader);
		Summary1.setAlignment(Element.ALIGN_LEFT);
		PdfPCell sumCol1 = new PdfPCell();
		sumCol1.setVerticalAlignment(Element.ALIGN_LEFT);
		sumCol1.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
		sumCol1.setUseAscender(true);
		sumCol1.addElement(Summary1);

		Paragraph Value1 = new Paragraph(
				String.format(startTime.getHours() + ":" + startTime.getMinutes() + ":" + startTime.getSeconds()),
				font_tabData);
		Value1.setAlignment(Element.ALIGN_CENTER);
		PdfPCell sumCol2 = new PdfPCell();
		sumCol2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		sumCol2.setBackgroundColor(BaseColor.WHITE);
		sumCol2.setUseAscender(true);
		sumCol2.addElement(Value1);

		Paragraph Summary1a = new Paragraph(String.format("End Time : "), font_summaryHeader);
		Summary1a.setAlignment(Element.ALIGN_LEFT);
		PdfPCell sumCol1a = new PdfPCell();
		sumCol1a.setVerticalAlignment(Element.ALIGN_LEFT);
		sumCol1a.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
		sumCol1a.setUseAscender(true);
		sumCol1a.addElement(Summary1a);

		Paragraph Value1a = new Paragraph(
				String.format(endTime.getHours() + ":" + endTime.getMinutes() + ":" + endTime.getSeconds()),
				font_tabData);
		Value1a.setAlignment(Element.ALIGN_CENTER);
		PdfPCell sumCol2a = new PdfPCell();
		sumCol2a.setVerticalAlignment(Element.ALIGN_MIDDLE);
		sumCol2a.setBackgroundColor(BaseColor.WHITE);
		sumCol2a.setUseAscender(true);
		sumCol2a.addElement(Value1a);

		Paragraph Summary1b = new Paragraph(String.format("Duration : "), font_summaryHeader);
		Summary1a.setAlignment(Element.ALIGN_LEFT);
		PdfPCell sumCol1b = new PdfPCell();
		sumCol1b.setVerticalAlignment(Element.ALIGN_LEFT);
		sumCol1b.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
		sumCol1b.setUseAscender(true);
		sumCol1b.addElement(Summary1b);

		Paragraph Value1b = new Paragraph(String.format(this.calculatetimeDiff(startTime, endTime)), font_tabData);
		Value1b.setAlignment(Element.ALIGN_CENTER);
		PdfPCell sumCol2b = new PdfPCell();
		sumCol2b.setVerticalAlignment(Element.ALIGN_MIDDLE);
		sumCol2b.setBackgroundColor(BaseColor.WHITE);
		sumCol2b.setUseAscender(true);
		sumCol2b.addElement(Value1b);

		Paragraph Summary2 = new Paragraph(String.format("Total Test Cases Executed :"), font_summaryHeader);
		Summary2.setAlignment(Element.ALIGN_LEFT);
		PdfPCell sumCol3 = new PdfPCell();
		sumCol3.setVerticalAlignment(Element.ALIGN_LEFT);
		sumCol3.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
		sumCol3.setUseAscender(true);
		sumCol3.addElement(Summary2);

		Paragraph Value2 = new Paragraph(String.format(Integer.toString(arr_listOfFolders.length)), font_tabData);
		Value2.setAlignment(Element.ALIGN_CENTER);
		PdfPCell sumCol4 = new PdfPCell();
		sumCol4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		sumCol4.setBackgroundColor(BaseColor.WHITE);
		sumCol4.setUseAscender(true);
		sumCol4.addElement(Value2);

		Paragraph Summary3 = new Paragraph(String.format("Total Test Cases Passed :"), font_summaryHeader);
		Summary3.setAlignment(Element.ALIGN_LEFT);
		PdfPCell sumCol5 = new PdfPCell();
		sumCol5.setVerticalAlignment(Element.ALIGN_LEFT);
		sumCol5.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
		sumCol5.setUseAscender(true);
		sumCol5.addElement(Summary3);

		Paragraph Value3 = new Paragraph(String.format(Integer.toString(getStatusFromArray(arr_teststatus, "Pass"))),
				font_tabData);
		Value3.setAlignment(Element.ALIGN_CENTER);
		PdfPCell sumCol6 = new PdfPCell();
		sumCol6.setVerticalAlignment(Element.ALIGN_MIDDLE);
		sumCol6.setBackgroundColor(BaseColor.WHITE);
		sumCol6.setUseAscender(true);
		sumCol6.addElement(Value3);

		Paragraph Summary4 = new Paragraph(String.format("Total Test Cases Failed :"), font_summaryHeader);
		Summary4.setAlignment(Element.ALIGN_LEFT);
		PdfPCell sumCol7 = new PdfPCell();
		sumCol7.setVerticalAlignment(Element.ALIGN_LEFT);
		sumCol7.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
		sumCol7.setUseAscender(true);
		sumCol7.addElement(Summary4);

		Paragraph Value4 = new Paragraph(String.format(Integer.toString(getStatusFromArray(arr_teststatus, "Fail"))),
				font_tabData);
		Value4.setAlignment(Element.ALIGN_CENTER);
		PdfPCell sumCol8 = new PdfPCell();
		sumCol8.setVerticalAlignment(Element.ALIGN_MIDDLE);
		sumCol8.setBackgroundColor(BaseColor.WHITE);
		sumCol8.setUseAscender(true);
		sumCol8.addElement(Value4);

		Paragraph Summary5 = new Paragraph(String.format("Total Test Cases Not Run:"), font_summaryHeader);
		Summary5.setAlignment(Element.ALIGN_LEFT);
		PdfPCell sumCol9 = new PdfPCell();
		sumCol9.setVerticalAlignment(Element.ALIGN_LEFT);
		sumCol9.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
		sumCol9.setUseAscender(true);
		sumCol9.addElement(Summary5);

		Paragraph Value5 = new Paragraph(String.format(Integer.toString(getStatusFromArray(arr_teststatus, "NotRun"))),
				font_tabData);
		Value5.setAlignment(Element.ALIGN_CENTER);
		PdfPCell sumCol10 = new PdfPCell();
		sumCol10.setVerticalAlignment(Element.ALIGN_MIDDLE);
		sumCol10.setBackgroundColor(BaseColor.WHITE);
		sumCol10.setUseAscender(true);
		sumCol10.addElement(Value5);

		Paragraph Summary6 = new Paragraph(String.format("Total Test Cases Incomplete:"), font_summaryHeader);
		Summary6.setAlignment(Element.ALIGN_LEFT);
		PdfPCell sumCol11 = new PdfPCell();
		sumCol11.setVerticalAlignment(Element.ALIGN_LEFT);
		sumCol11.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
		sumCol11.setUseAscender(true);
		sumCol11.addElement(Summary6);

		Paragraph Value6 = new Paragraph(
				String.format(Integer.toString(getStatusFromArray(arr_teststatus, "Incomplete"))), font_tabData);
		Value6.setAlignment(Element.ALIGN_CENTER);
		PdfPCell sumCol12 = new PdfPCell();
		sumCol12.setVerticalAlignment(Element.ALIGN_MIDDLE);
		sumCol12.setBackgroundColor(BaseColor.WHITE);
		sumCol12.setUseAscender(true);
		sumCol12.addElement(Value6);

		PdfPTable sumColHeader = new PdfPTable(2);

		sumColHeader.setWidthPercentage(50f);

		Chunk chunk1 = new Chunk("Execution Summary", font_tabHeader);
		chunk1.setLocalDestination("Summary");
		Paragraph Summary = new Paragraph();
		Summary.add(chunk1);
		Summary.setAlignment(Element.ALIGN_CENTER);

		PdfPCell sumCol0 = new PdfPCell();
		sumCol0.setColspan(2);
		sumCol0.addElement(Summary);
		sumCol0.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
		sumCol0.setVerticalAlignment(Element.ALIGN_MIDDLE);
		sumCol0.setHorizontalAlignment(Element.ALIGN_CENTER);
		sumCol0.setPaddingBottom(12);
		sumColHeader.addCell(sumCol0);
		sumColHeader.addCell(sumCol1);
		sumColHeader.addCell(sumCol2);
		sumColHeader.addCell(sumCol1a);
		sumColHeader.addCell(sumCol2a);
		sumColHeader.addCell(sumCol1b);
		sumColHeader.addCell(sumCol2b);
		sumColHeader.addCell(sumCol3);
		sumColHeader.addCell(sumCol4);
		sumColHeader.addCell(sumCol5);
		sumColHeader.addCell(sumCol6);
		sumColHeader.addCell(sumCol7);
		sumColHeader.addCell(sumCol8);
		sumColHeader.addCell(sumCol9);
		sumColHeader.addCell(sumCol10);
		sumColHeader.addCell(sumCol11);
		sumColHeader.addCell(sumCol12);

		document.add(sumColHeader);

		document.add(new Paragraph("\n"));
		document.add(new LineSeparator());
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));

		;
		// ****************************************EXECUTION SUMMARY HEADER
		// TABLE ENDS***********************************************************

		/**************************************
		 * TEST SUITE REPORT STARTS THIS TABLE CONTAINS INFORMATION OF EXECUTION
		 * DETAILS OF ALL TEST CASES 1)SL NO 2)TEST CASE ID 3)TEST CASE DESC
		 * 4)STATUS
		 * 
		 */
		// Report Column Header

		document.add(new LineSeparator());
		document.add(new Paragraph("\n\n\n"));

		Image imgLogoPass = Image.getInstance(String.format(str_passLogo, "0120903"));
		imgLogoPass.scaleAbsolute(20f, 20f);
		imgLogoPass.setAlignment(Element.ALIGN_LEFT);
		imgLogoPass.setAlignment(Element.ALIGN_BOTTOM);

		Image imgLogoFail = Image.getInstance(String.format(str_failLogo, "0120903"));
		imgLogoFail.scaleAbsolute(15f, 15f);
		imgLogoFail.setAlignment(Element.ALIGN_LEFT);
		imgLogoFail.setAlignment(Element.ALIGN_BOTTOM);

		Image imgLogoNotRun = Image.getInstance(String.format(str_notRunLogo, "0120903"));
		imgLogoNotRun.scaleAbsolute(20f, 20f);
		imgLogoNotRun.setAlignment(Element.ALIGN_LEFT);
		imgLogoNotRun.setAlignment(Element.ALIGN_BOTTOM);

		Image imgLogoIncomplete = Image.getInstance(String.format(str_inCompleteLogo, "0120903"));
		imgLogoIncomplete.scaleAbsolute(20f, 20f);
		imgLogoIncomplete.setAlignment(Element.ALIGN_LEFT);
		imgLogoIncomplete.setAlignment(Element.ALIGN_BOTTOM);

		Paragraph pHdCol1 = new Paragraph(String.format("SNo"), font_tabHeader);
		pHdCol1.setAlignment(Element.ALIGN_CENTER);
		PdfPCell clHdCol1 = new PdfPCell();
		clHdCol1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		clHdCol1.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
		clHdCol1.setPadding(2);
		clHdCol1.setPaddingTop(2);
		clHdCol1.setPaddingBottom(2);
		clHdCol1.setUseAscender(true);
		clHdCol1.addElement(pHdCol1);

		// ------------VIRU Adding TC ID--------START---------
		Paragraph pHdCol1a = new Paragraph(String.format("Testcase ID"), font_tabHeader);
		pHdCol1a.setAlignment(Element.ALIGN_CENTER);
		PdfPCell clHdCol1tcid = new PdfPCell();
		clHdCol1tcid.setVerticalAlignment(Element.ALIGN_MIDDLE);
		clHdCol1tcid.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
		clHdCol1tcid.setPadding(2);
		clHdCol1tcid.setPaddingTop(2);
		clHdCol1tcid.setPaddingBottom(2);
		clHdCol1tcid.setUseAscender(true);
		clHdCol1tcid.addElement(pHdCol1a);
		// ------------VIRU Adding TC ID--------END---------

		Paragraph pHdCol2 = new Paragraph(String.format("Test Case Name"), font_tabHeader);
		pHdCol2.setAlignment(Element.ALIGN_CENTER);
		PdfPCell clHdCol2 = new PdfPCell();
		clHdCol2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		clHdCol2.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
		clHdCol2.setPadding(2);
		clHdCol2.setPaddingTop(2);
		clHdCol2.setPaddingBottom(2);
		clHdCol2.setUseAscender(true);
		clHdCol2.addElement(pHdCol2);

		Paragraph pHdCol2a = new Paragraph(String.format("Test Case Description"), font_tabHeader);
		pHdCol2a.setAlignment(Element.ALIGN_CENTER);
		PdfPCell clHdCol2a = new PdfPCell();
		clHdCol2a.setVerticalAlignment(Element.ALIGN_MIDDLE);
		clHdCol2a.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
		clHdCol2a.setPaddingTop(2);
		clHdCol2a.setPaddingBottom(2);
		clHdCol2a.setPadding(2);
		clHdCol2a.setUseAscender(true);
		clHdCol2a.addElement(pHdCol2a);

		Paragraph pHdCol3 = new Paragraph(String.format("Status"), font_tabHeader);
		pHdCol3.setAlignment(Element.ALIGN_CENTER);
		PdfPCell clHdCol3 = new PdfPCell();
		clHdCol3.setVerticalAlignment(Element.ALIGN_MIDDLE);
		clHdCol3.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
		clHdCol3.setPaddingTop(2);
		clHdCol3.setPaddingBottom(2);
		clHdCol3.setUseAscender(true);
		clHdCol3.addElement(pHdCol3);

		PdfPTable tbColHeader = new PdfPTable(5);
		tbColHeader.setWidthPercentage(100f);
		float[] columnWidths = { 0.5f, 1f, 1.5f, 4f, 1.5f };
		tbColHeader.setWidths(columnWidths);
		tbColHeader.addCell(clHdCol1);
		tbColHeader.addCell(clHdCol1tcid);
		tbColHeader.addCell(clHdCol2);
		tbColHeader.addCell(clHdCol2a);
		tbColHeader.addCell(clHdCol3);

		for (int i = 0; i < arr_listOfFolders.length; i++) {
			Log.info("Value of I" + i);

			// To add SNo
			Paragraph pHdCol4 = new Paragraph(String.format(Integer.toString(i + 1)), font_tabData);
			pHdCol4.setAlignment(Element.ALIGN_CENTER);
			PdfPCell clHdCol4 = new PdfPCell();
			clHdCol4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			clHdCol4.setBackgroundColor(BaseColor.WHITE);

			clHdCol4.setUseAscender(true);
			clHdCol4.addElement(pHdCol4);

			// To add Testcase ID - Viru
			Paragraph pHdCol4tcid = new Paragraph(String.format(arr_arrTcId[i]), font_tabData);
			pHdCol4tcid.setAlignment(Element.ALIGN_CENTER);
			PdfPCell clHdCol4tcid = new PdfPCell();
			clHdCol4tcid.setVerticalAlignment(Element.ALIGN_MIDDLE);
			clHdCol4tcid.setBackgroundColor(BaseColor.WHITE);

			clHdCol4tcid.setUseAscender(true);
			clHdCol4tcid.addElement(pHdCol4tcid);

			// To add Testcase Name
			Paragraph pHdCol5a = new Paragraph();
			Chunk chnk = new Chunk(arr_listOfFolders[i].getName());
			chnk.setUnderline(0.1f, -2f);
			anchor = new Anchor(chnk);
			anchor.setReference("#" + arr_listOfFolders[i].getName());

			// pHdCol5.setHyphenation(PdfAction.gotoLocalPage(listOfFolders[i].getName(),
			// false));

			pHdCol5a.add(anchor);
			pHdCol5a.setFont(font_tabData);
			pHdCol5a.setAlignment(Element.ALIGN_CENTER);

			PdfPCell clHdCol5a = new PdfPCell();
			clHdCol5a.setPadding(5);

			clHdCol5a.setVerticalAlignment(Element.ALIGN_MIDDLE);
			clHdCol5a.setBackgroundColor(BaseColor.WHITE);
			clHdCol5a.setUseAscender(true);
			clHdCol5a.addElement(pHdCol5a);

			// To add Testcase Description
			Paragraph pHdCol5 = new Paragraph(String.format(arr_arrTcDesc[i]), font_tabData);
			pHdCol5.setFont(font_tabData);
			pHdCol2.setAlignment(Element.ALIGN_CENTER);
			PdfPCell clHdCol5 = new PdfPCell();
			clHdCol5.setPadding(5);
			clHdCol5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			clHdCol5.setBackgroundColor(BaseColor.WHITE);
			clHdCol5.setUseAscender(true);
			clHdCol5.addElement(pHdCol5);

			// Status Column in the Suite Report
			PdfPCell clHdCol6 = new PdfPCell();
			clHdCol6.setHorizontalAlignment(Element.ALIGN_LEFT);
			clHdCol6.setVerticalAlignment(Element.ALIGN_BOTTOM);
			clHdCol6.setBackgroundColor(BaseColor.WHITE);
			clHdCol6.setUseAscender(true);

			if (arr_teststatus[i].equalsIgnoreCase("Pass")) {

				Paragraph pHdCol6 = new Paragraph(String.format(arr_teststatus[i].trim()), font_statusPass);

				Phrase phr = new Phrase("             ");
				phr.add(pHdCol6);
				phr.add(" ");
				phr.add(new Chunk(imgLogoPass, 0, 0));
				clHdCol6.addElement(phr);

			} else if (arr_teststatus[i].equalsIgnoreCase("Fail")) {

				Paragraph pHdCol6 = new Paragraph(String.format(arr_teststatus[i].trim()), font_statusFail);
				Phrase phr = new Phrase("             ");
				phr.add(pHdCol6);
				phr.add(" ");
				phr.add(new Chunk(imgLogoFail, 0, 0));
				clHdCol6.addElement(phr);

			} else if (arr_teststatus[i].equalsIgnoreCase("Incomplete")) {

				Paragraph pHdCol6 = new Paragraph(String.format(arr_teststatus[i].trim()), font_statusIncomplete);
				pHdCol6.setAlignment(Element.ALIGN_LEFT);
				Phrase phr = new Phrase("             ");
				phr.add(pHdCol6);
				phr.add(" ");
				phr.add(new Chunk(imgLogoIncomplete, 0, 0));
				clHdCol6.addElement(phr);

			} else {

				Paragraph pHdCol6 = new Paragraph(String.format(arr_teststatus[i].trim()), font_statusNotRun);
				Phrase phr = new Phrase("             ");
				phr.add(pHdCol6);
				phr.add(" ");
				phr.add(new Chunk(imgLogoNotRun, 0, 0));
				// clHdCol6.addElement(pHdCol6);
				clHdCol6.addElement(phr);
			}

			tbColHeader.addCell(clHdCol4);
			tbColHeader.addCell(clHdCol4tcid);
			tbColHeader.addCell(clHdCol5a);
			tbColHeader.addCell(clHdCol5);
			tbColHeader.addCell(clHdCol6);

		}

		document.add(tbColHeader);

		document.add(new LineSeparator());
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));

		// ***************************************************TEST SUITE TABLE
		// ENDS*****************************************
		/**************************
		 * THIS SECTION CONTAINS THE DATA FOR INDIVIDUAL TEST CASES WITH STEP
		 * DETAILS 0) TEST CASE ID ANCHOR 1)SL NO 2)TEST STEP DESCRIPTION
		 * 3)STATUS
		 * 
		 */
		// INDIVIDUAL TEST CASE DETAILS

		int tcNum = 0;
		Iterator<ArrayList<ArrayList<String[]>>> itr = suiteTestDetails.iterator();
		System.out.println("No of test cases " + suiteTestDetails.size());

		while (itr.hasNext()) {

			document.newPage();
			document.add(new LineSeparator());
			document.add(new Paragraph("\n"));

			document.add(new Paragraph("\n"));
			ArrayList<ArrayList<String[]>> testCaseDetail = itr.next();
			System.out.println("No of test cases in each browser " + testCaseDetail.size());

			Iterator<ArrayList<String[]>> itr2 = testCaseDetail.iterator();

			PdfPTable tcdata1 = new PdfPTable(2);
			tcdata1.setWidthPercentage(50f);

			PdfPCell tcheader = this.createCell("TEST CASE SUMMARY", font_summaryHeader, Element.ALIGN_CENTER,
					Element.ALIGN_CENTER, WebColors.getRGBColor("#6C94E6"));
			tcheader.setColspan(2);
			;
			Anchor anchorTarget = new Anchor((String) tcNameandTime.get(tcNum)[0]);
			anchorTarget.setName((String) tcNameandTime.get(tcNum)[0]);

			// Table Representing Test Case name and No of Steps
			Paragraph targetParagraph1 = new Paragraph("TEST CASE ID: ");
			targetParagraph1.setFont(font_summaryHeader);
			// targetParagraph1.add(anchorTarget);
			targetParagraph1.setAlignment(Element.ALIGN_CENTER);
			System.out.println("Adding document for " + anchorTarget.getName());

			PdfPCell coltcid1 = new PdfPCell();
			coltcid1.setHorizontalAlignment(Element.ALIGN_CENTER);
			// coltcid.setBackgroundColor(BaseColor.CYAN.darker());
			coltcid1.setUseAscender(true);
			coltcid1.addElement(targetParagraph1);
			coltcid1.setBackgroundColor(BaseColor.WHITE);

			Paragraph targetParagraph = new Paragraph();
			targetParagraph.setFont(font_tabData);
			targetParagraph.add(anchorTarget);
			targetParagraph.setAlignment(Element.ALIGN_CENTER);
			System.out.println("Adding document for " + anchorTarget.getName());

			PdfPCell coltcid = new PdfPCell();
			coltcid.setHorizontalAlignment(Element.ALIGN_CENTER);
			// coltcid.setBackgroundColor(BaseColor.CYAN.darker());
			coltcid.setUseAscender(true);
			coltcid.addElement(targetParagraph);
			coltcid.setBackgroundColor(BaseColor.WHITE);
			System.out.println("Test case number is " + tcNum);
			// System.out.println("Size of the arraylist
			// "+testCaseDetail.get(0).size());
			int num_Steps = 0;
			try {
				num_Steps = testCaseDetail.get(0).size();
				System.out.println("Num steps " + num_Steps);
			} catch (Exception e) {
				// e.printStackTrace();
				num_Steps = 0;
			}

			Paragraph nGParagraph = new Paragraph("No of Steps : ".toUpperCase());
			nGParagraph.setFont(font_summaryHeader);
			nGParagraph.setAlignment(Element.ALIGN_CENTER);
			PdfPCell coltcns = new PdfPCell();
			coltcns.setHorizontalAlignment(Element.ALIGN_CENTER);
			// coltcid.setBackgroundColor(BaseColor.CYAN.darker());
			coltcns.setUseAscender(true);
			coltcns.addElement(nGParagraph);
			coltcns.setBackgroundColor(BaseColor.WHITE);

			Paragraph nGParagraph2 = new Paragraph(String.format(Integer.toString(num_Steps)));
			nGParagraph2.setFont(font_tabData);
			nGParagraph2.setAlignment(Element.ALIGN_CENTER);
			PdfPCell coltcns2 = new PdfPCell();
			coltcns2.setHorizontalAlignment(Element.ALIGN_CENTER);
			// coltcid.setBackgroundColor(BaseColor.CYAN.darker());
			coltcns2.setUseAscender(true);
			coltcns2.addElement(nGParagraph2);
			coltcns2.setBackgroundColor(BaseColor.WHITE);

			Paragraph pstartTime = new Paragraph("Start Time : ".toUpperCase());
			pstartTime.setFont(font_summaryHeader);
			pstartTime.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cStartTime = new PdfPCell();
			coltcns.setHorizontalAlignment(Element.ALIGN_CENTER);
			// coltcid.setBackgroundColor(BaseColor.CYAN.darker());
			cStartTime.setUseAscender(true);
			cStartTime.addElement(pstartTime);
			cStartTime.setBackgroundColor(BaseColor.WHITE);

			Paragraph pstartTimeval = new Paragraph(tcNameandTime.get(tcNum)[1].toString());
			pstartTimeval.setFont(font_tabData);
			pstartTimeval.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cStartTimeval = new PdfPCell();
			cStartTimeval.setHorizontalAlignment(Element.ALIGN_CENTER);
			// coltcid.setBackgroundColor(BaseColor.CYAN.darker());
			cStartTimeval.setUseAscender(true);
			cStartTimeval.addElement(pstartTimeval);
			cStartTimeval.setBackgroundColor(BaseColor.WHITE);

			Paragraph pendTime = new Paragraph("end Time : ".toUpperCase());
			pendTime.setFont(font_summaryHeader);
			pendTime.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cendTime = new PdfPCell();
			coltcns.setHorizontalAlignment(Element.ALIGN_CENTER);
			// coltcid.setBackgroundColor(BaseColor.CYAN.darker());
			cendTime.setUseAscender(true);
			cendTime.addElement(pendTime);
			cendTime.setBackgroundColor(BaseColor.WHITE);

			Paragraph pendTimeval = new Paragraph(tcNameandTime.get(tcNum)[2].toString());
			pendTimeval.setFont(font_tabData);
			pendTimeval.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cendTimeval = new PdfPCell();
			cendTimeval.setHorizontalAlignment(Element.ALIGN_CENTER);
			// coltcid.setBackgroundColor(BaseColor.CYAN.darker());
			cendTimeval.setUseAscender(true);
			cendTimeval.addElement(pendTimeval);
			cendTimeval.setBackgroundColor(BaseColor.WHITE);

			Paragraph peTimeDiff = new Paragraph("Duration : ".toUpperCase());
			peTimeDiff.setFont(font_summaryHeader);
			peTimeDiff.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cTimeDiff = new PdfPCell();
			cTimeDiff.setHorizontalAlignment(Element.ALIGN_CENTER);
			// coltcid.setBackgroundColor(BaseColor.CYAN.darker());
			cTimeDiff.setUseAscender(true);
			cTimeDiff.addElement(peTimeDiff);
			cTimeDiff.setBackgroundColor(BaseColor.WHITE);

			Date sTime = (Date) tcNameandTime.get(tcNum)[1];
			Date eTime = (Date) tcNameandTime.get(tcNum)[2];
			Paragraph pTimeDiffval = new Paragraph(this.calculatetimeDiff(sTime, eTime));
			pTimeDiffval.setFont(font_tabData);
			pTimeDiffval.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cTimeDiffval = new PdfPCell();
			cTimeDiffval.setHorizontalAlignment(Element.ALIGN_CENTER);
			// coltcid.setBackgroundColor(BaseColor.CYAN.darker());
			cTimeDiffval.setUseAscender(true);
			cTimeDiffval.addElement(pTimeDiffval);
			cTimeDiffval.setBackgroundColor(BaseColor.WHITE);

			tcdata1.addCell(tcheader);
			tcdata1.addCell(coltcid1);
			tcdata1.addCell(coltcid);
			// tcdata1.addCell(this.createCell(anchorTarget, font_tabData,
			// Element.ALIGN_CENTER, Element.ALIGN_CENTER, BaseColor.WHITE));
			tcdata1.addCell(coltcns);
			tcdata1.addCell(coltcns2);

			tcdata1.addCell(cStartTime);
			tcdata1.addCell(cStartTimeval);

			tcdata1.addCell(cendTime);
			tcdata1.addCell(cendTimeval);

			tcdata1.addCell(cTimeDiff);
			tcdata1.addCell(cTimeDiffval);

			document.add(tcdata1);

			tcNum++;
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("\n"));

			// *********** Table Ends*****************/
			while (itr2.hasNext()) {

				PdfPTable tcdata = new PdfPTable(3);
				tcdata.setWidthPercentage(100f);

				ArrayList<String[]> testCaseDetailrun = itr2.next();
				System.out.println("No of steps " + testCaseDetailrun.size());

				Iterator<String[]> itr3 = testCaseDetailrun.iterator();
				int i = 1;

				Paragraph pHdCol11 = new Paragraph(String.format("Sl No"), font_tabHeader);
				pHdCol11.setAlignment(Element.ALIGN_CENTER);
				PdfPCell clHdCol11 = new PdfPCell();
				clHdCol11.setVerticalAlignment(Element.ALIGN_MIDDLE);
				clHdCol11.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
				clHdCol11.setUseAscender(true);
				clHdCol11.addElement(pHdCol11);

				Paragraph pHdCol12 = new Paragraph(String.format("Step Description"), font_tabHeader);
				pHdCol12.setAlignment(Element.ALIGN_CENTER);
				PdfPCell clHdCol12 = new PdfPCell();
				clHdCol12.setVerticalAlignment(Element.ALIGN_MIDDLE);
				clHdCol12.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
				clHdCol12.setUseAscender(true);
				clHdCol12.addElement(pHdCol12);

				Paragraph pHdCol13 = new Paragraph(String.format("Status"), font_tabHeader);
				pHdCol13.setAlignment(Element.ALIGN_CENTER);
				PdfPCell clHdCol13 = new PdfPCell();
				clHdCol13.setVerticalAlignment(Element.ALIGN_MIDDLE);
				clHdCol13.setBackgroundColor(WebColors.getRGBColor("#6C94E6"));
				clHdCol13.setUseAscender(true);
				clHdCol13.addElement(pHdCol13);
				// document.add(new Paragraph(tcName.get(tcNum)));

				tcdata.addCell(clHdCol11);
				tcdata.addCell(clHdCol12);
				tcdata.addCell(clHdCol13);

				while (itr3.hasNext()) {

					String[] status = itr3.next();

					Paragraph pHdCol7 = new Paragraph(String.format(Integer.toString(i++)), font_tabData);
					pHdCol7.setAlignment(Element.ALIGN_CENTER);
					PdfPCell clHdCol7 = new PdfPCell();
					clHdCol7.setVerticalAlignment(Element.ALIGN_MIDDLE);
					clHdCol7.setBackgroundColor(BaseColor.WHITE);
					clHdCol7.setUseAscender(true);
					clHdCol7.addElement(pHdCol7);

					Paragraph pHdCol8 = new Paragraph(String.format(status[0]), font_tabData);
					pHdCol8.setAlignment(Element.ALIGN_CENTER);
					PdfPCell clHdCol8 = new PdfPCell();
					clHdCol8.setVerticalAlignment(Element.ALIGN_MIDDLE);
					clHdCol8.setBackgroundColor(BaseColor.WHITE);
					clHdCol8.setUseAscender(true);
					clHdCol8.addElement(pHdCol8);

					Paragraph pHdCol9;
					if (status[1].equalsIgnoreCase("Pass")) {
						pHdCol9 = new Paragraph(String.format(status[1]), font_statusPass);
					} else if (status[1].equalsIgnoreCase("Fail")) {
						pHdCol9 = new Paragraph(String.format(status[1]), font_statusFail);
					} else {
						pHdCol9 = new Paragraph(String.format(status[1]), font_statusEnd);
					}
					pHdCol9.setAlignment(Element.ALIGN_CENTER);
					PdfPCell clHdCol9 = new PdfPCell();
					clHdCol9.setVerticalAlignment(Element.ALIGN_MIDDLE);
					clHdCol9.setBackgroundColor(BaseColor.WHITE);
					clHdCol9.setUseAscender(true);

					clHdCol9.addElement(pHdCol9);
					// tcdata.addCell(new Paragraph("\n"));
					tcdata.addCell(clHdCol7);
					tcdata.addCell(clHdCol8);
					tcdata.addCell(clHdCol9);
					System.out.println("*********************************");
					System.out.println("Value is " + status[0]);
					System.out.println("Value is " + status[1]);
					System.out.println("Value is " + status[2]);
					System.out.println("*********************************");

				}
				document.add(tcdata);
				document.add(new Paragraph("\n"));
			}
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("\n"));

			Chunk chunk2 = new Chunk("Go to Summary".toUpperCase());
			chunk2.setUnderline(0.1f, -2f);
			chunk2.setLocalGoto("Summary");
			/*
			 * Anchor anchor2 =new Anchor(chunk2); anchor2.setReference(
			 * "#Execution Summary"); System.out.println("***************** "
			 * +anchor2.getReference());
			 */
			Paragraph linkSummary = new Paragraph(chunk2);

			linkSummary.setAlignment(Element.ALIGN_CENTER);

			document.add(linkSummary);
			document.add(new Paragraph("\n"));

			document.add(new LineSeparator());

			// document.add(new Paragraph("\n"));
		}
		// document.add(new LineSeparator());
		Paragraph footer = new Paragraph("END", fontHd);
		footer.setAlignment(Element.ALIGN_CENTER);

		document.add(footer);
		document.add(new Paragraph("\n"));
		document.add(new LineSeparator());
		document.close();

		// Sending PDF mail after suite execution
		Properties prop = System.getProperties();
		String strPropertiesFile =  Resources.getResource("AUTOMATION.properties").getPath();
		FileReader file = new FileReader(strPropertiesFile);		
		prop.load(file);
		
		/*
		 *  Authro: Viru
		 *  Jenkins Opeasy pipeline requirement
		 *  Copy the xls file from the reports folder to a new folder to be picked up by Jenkins
		 * */
		
		String srcReportPath = reportPath + "//SuiteExecutionReport.xls";
		String destReportPath = "C://ReportForJenkins//SuiteExecutionReport.xls";

		String srcPDFReportPath = reportPath + "//Suite_Execution_Report.pdf";
		String destPDFReportPath = "C://ReportForJenkins//Suite_Execution_Report.pdf";
		
		File source = new File(srcReportPath);
		File dest = new File(destReportPath);

		File pdfsource = new File(srcPDFReportPath);
		File pdfdest = new File(destPDFReportPath);
		
		try {
		    FileUtils.copyFile(source, dest);
		    FileUtils.copyFile(pdfsource, pdfdest);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		if ((POMSuiteRunner.strSendEmail.toLowerCase().equals("true"))) {
			try {
				// MaliSender.SendMail(prop.getProperty("to.mail.id"));
				MailSender.SendMail(POMSuiteRunner.strEmailRecipients);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}

	// **********************************************************************END
	// OF REPORT ***********************************************

	public static int getStatusFromArray(String[] status, String value) {
		int occurrences = Collections.frequency(Arrays.asList(status), value);
		return occurrences;
	}
	
	public static List<Serializable> getTestcasesOfStatus(String[] status, String value) {
		return  Arrays.asList((status), value);
	}

	private PdfPCell createCell(String text, Font font, int pAllign, int cHAllign, BaseColor cBColor) {
		Paragraph nGParagraph = new Paragraph(text);
		nGParagraph.setFont(font);
		nGParagraph.setAlignment(pAllign);
		PdfPCell coltcns = new PdfPCell();
		coltcns.setHorizontalAlignment(cHAllign);
		coltcns.setUseAscender(true);
		coltcns.addElement(nGParagraph);
		coltcns.setBackgroundColor(cBColor);
		return coltcns;
	}

	private String calculatetimeDiff(Date startTime, Date endTime) {
		long diff = endTime.getTime() - startTime.getTime();
		int diffsec = (int) (diff / (1000));
		int min = diffsec / 60;
		int sec = diffsec % 60;
		String differenceTime = min + " mins," + sec + " sec";
		return differenceTime;

	}

}
