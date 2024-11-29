package pomTestApps.Utility.STAcore.reportwriter;
/**************************************************
#Project Name: MiTEL_MXONE - Selenium Framework

#Function Name: GenerateExcelReport()
#Description:1.  This method is responsible for generating the excel sheet report
#Input Parameters:
#Owner: Ashis Kumar Pradhan
#Author: Ashis Kumar Pradhan
#Date of creation: 03-July-16
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/
import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class GenerateExcelReport {

	String projectPath;
	File[] listOfFolders;
	String[] arrTcDesc;
	String[] arrTcId;
	String[] teststatus;
	String arr_testSolution;
	
	public GenerateExcelReport(String projectPath,File[] listOfFolders,String[] arrTcId, String[] arrTcDesc, String[] teststatus, String arr_testSolution){
		this.projectPath=projectPath;
		this.listOfFolders=listOfFolders;
		this.arrTcId = arrTcId;
		this.arrTcDesc=arrTcDesc;		
		this.teststatus=teststatus;
		
		this.arr_testSolution=arr_testSolution;
	}
	
	
	 void generateexcel() throws IOException, RowsExceededException, WriteException{
		File file=new File(projectPath+"\\"+"SuiteExecutionReport"+arr_testSolution+".xls");
		
		WritableFont cellFont = new WritableFont(WritableFont.TIMES,15);
		cellFont.setBoldStyle(WritableFont.BOLD); 
		cellFont.setColour(Colour.BLUE);
		WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
		
	//	cellFormat.setWrap(true);
		
		WritableWorkbook workbook = Workbook.createWorkbook(file);
		workbook.createSheet("Report", 0);
		WritableSheet s1 = workbook.getSheet(0);
		Label hlabel0 = new Label(0, 0, "Ser No",cellFormat);
		Label hlabel1tcid = new Label(1, 0, "Test Case ID",cellFormat);
		Label hlabel1 = new Label(2, 0, "Test Case Name",cellFormat);
		Label hlabel2 = new Label(3, 0, "Test Case Description",cellFormat);
		Label hlabel3 = new Label(4, 0, "Component",cellFormat);
		Label hlabel4 = new Label(5, 0, "Status",cellFormat);
		Label hlabel5 = new Label(6, 0, "Comments",cellFormat);
		s1.addCell(hlabel0);
		s1.addCell(hlabel1tcid);
		s1.addCell(hlabel1);			
		s1.addCell(hlabel2);
		s1.addCell(hlabel3);
		s1.addCell(hlabel4);
		s1.addCell(hlabel5);
		
		for (int i = 0; i < listOfFolders.length; i++) {
			int j=i+1;
			Label label0 = new Label(0, j, String.valueOf(j));			
			Label label1tcid= new Label(1, j, arrTcId[i]);
			Label label1 = new Label(2, j, listOfFolders[i].getName());
			Label label2 = new Label(3, j, arrTcDesc[i]);
			Label label4 = new Label(5, j, teststatus[i]);
			Label label3 = new Label(4, j, arr_testSolution);
			
			
			s1.addCell(label0);	
			s1.addCell(label1tcid);
			s1.addCell(label1);		
			s1.addCell(label2);
			s1.addCell(label4);
			s1.addCell(label3);
			

		}
		workbook.write();
		workbook.close();
		System.out.println("Completed");
	}
	}
	


