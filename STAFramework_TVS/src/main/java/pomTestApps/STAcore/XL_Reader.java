package pomTestApps.STAcore;

import org.apache.poi.common.usermodel.HyperlinkType;

/**************************************************
#Project Name: MiTEL_MXONE - Selenium Framework



#Test case Name: MXONE-XL_Reader
#Description:1. Core component of data provider.
			 2. Reads and writes data into xls and xlsx files.
#Input Parameters:File Path,Test Class Name
#Owner: Naveen Kumar Punnana
#Author: Naveen Kumar Punnana
#Date of creation: 21-Oct-16
#Name of person modifying: (Tester Name): 
#Date of modification: 
�**************************************************/

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.DateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.*;
import java.util.Calendar;


public class XL_Reader {
	public  String path;
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	//private XSSFWorkbook workbook = null;
	/*private XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;*/
	 org.apache.poi.ss.usermodel.Workbook workbook = null;
	 org.apache.poi.ss.usermodel.Sheet sheet = null;
     org.apache.poi.ss.usermodel.Row row = null;
     org.apache.poi.ss.usermodel.Cell cell = null;

	//private HSSFWorkbook workbook = null;
	//private HSSFSheet  sheet = null;
	/*private HSSFRow row = null;
	private HSSFCell cell = null;*/
	
    
	
	public XL_Reader(String path) {
		this.path=path;
		try {
			//fis = new FileInputStream(path);
			System.out.println("........."+path);
			//workbook = WorkbookFactory.create(fis);
		//	workbook = new HSSFWorkbook(fis);
		//	workbook = new XSSFWorkbook(fis);
			//sheet = workbook.getSheetAt(0);
			FileInputStream stream = new FileInputStream(path);
			POIFSFileSystem f;
			f = new POIFSFileSystem(stream);
		    workbook = WorkbookFactory.create(f); 
		    sheet = workbook.getSheetAt(0);
			
			//fis.close();
		} catch (Exception e) {		
			e.printStackTrace();
		} 	
	}
	
	// returns row count from the excel sheet
	public int getRowCount(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return 0;
		else{
			
		System.out.println("The Sheet Name is :"+workbook.getSheetName(index)+"\n");
		sheet = workbook.getSheet(workbook.getSheetName(index));
		int number=sheet.getLastRowNum()+1;
		//int number=sheet.getPhysicalNumberOfRows()+1;
		//System.out.println("The Row Count is : "+number);
		return number;
		}	
	}
	
	// returns cell's data from excel sheet
	public String getCellData(String sheetName,String colName,int rowNum){
		//cell.setCellType(CellType.STRING); 
		try{
			if(rowNum <=0)
				return "";
			int index = workbook.getSheetIndex(sheetName);
			int col_Num=-1;
			if(index==-1)
				return "";
		
			sheet = workbook.getSheetAt(index);

			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){	
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num=i;

			}
			if(col_Num==-1)
				return "";
		
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			cell = row.getCell(col_Num);
		
			if(cell==null)
				return "";
			
		
			if(cell.getCellType()==CellType.STRING)
				return cell.getStringCellValue();
			
			else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA ){
			    int io= (int)cell.getNumericCellValue(); 
				String cellText  = String.valueOf(io);
				if (DateUtil.isCellDateFormatted(cell)) {
					double d = cell.getNumericCellValue();

					Calendar cal =Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText =
							(String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
							cal.get(Calendar.MONTH)+1 + "/" + 
							cellText;
		         }  
			  return cellText;
		  }else if(cell.getCellType()==CellType.BLANK)
		      return ""; 
		  else 
			  return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e){	
			e.printStackTrace();
			return "row "+rowNum+" or column "+colName +" does not exist in xls";
		}
	}
	
	// returns the data from a cell
	public String getCellData(String sheetName,int colNum,int rowNum){
		//cell.setCellType(CellType.STRING); 
		
		try{
			String st = "";
			if(rowNum <=0)
				return "";
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1)
				return "";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			cell = row.getCell(colNum);
			if(cell==null)
				return "";
		
			if(cell.getCellType()==CellType.STRING)
				return cell.getStringCellValue();
			else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA ){
		  
				int io= (int)cell.getNumericCellValue(); 
				String cellText  = String.valueOf(io);
				if (DateUtil.isCellDateFormatted(cell)) {
					double d = cell.getNumericCellValue();

					Calendar cal =Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText =
							(String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH)+1 + "/" +
							cal.get(Calendar.DAY_OF_MONTH) + "/" +
							cellText;
				}
				return cellText;
			}else if(cell.getCellType()==CellType.BLANK)
				return "";
			else 
				return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e){	
			e.printStackTrace();
			return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
		}
	}
	
	// returns true if data is set successfully else false
	public boolean setCellData(String sheetName,String colName,int rowNum, String data){
		try{
			fis = new FileInputStream(path); 
			workbook = new HSSFWorkbook(fis);

			if(rowNum<=0)
				return false;
		
			int index = workbook.getSheetIndex(sheetName);
			int colNum=-1;
			if(index==-1)
				return false;

			sheet = workbook.getSheetAt(index);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum=i;
			}
			if(colNum==-1)
				return false;
			sheet.autoSizeColumn(colNum); 
			row = sheet.getRow(rowNum-1);
			if (row == null)
				row = sheet.createRow(rowNum-1);
			cell = row.getCell(colNum);	
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue(data);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();	
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
	
	
	// returns true if data is set successfully else false
	public boolean setCellData(String sheetName,String colName,int rowNum, String data,String url){
		try{
			fis = new FileInputStream(path); 
			workbook = new HSSFWorkbook(fis);
	
			if(rowNum<=0)
				return false;
			
			int index = workbook.getSheetIndex(sheetName);
			int colNum=-1;
			if(index==-1)
				return false;
			sheet = workbook.getSheetAt(index);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
					colNum=i;
			}
			if(colNum==-1)
				return false;
			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum-1);
			if (row == null)
				row = sheet.createRow(rowNum-1);
			
			cell = row.getCell(colNum);	
			if (cell == null)
		        cell = row.createCell(colNum);
				
		    cell.setCellValue(data);
		    org.apache.poi.ss.usermodel.CreationHelper  createHelper = workbook.getCreationHelper();
		   // HSSFCreationHelper createHelper = workbook.getCreationHelper();

		    CellStyle hlink_style = workbook.createCellStyle();
		    
		    org.apache.poi.ss.usermodel.Font hlink_font = workbook.createFont();
		  //  HSSFFont hlink_font = workbook.createFont();
		    hlink_font.setUnderline(HSSFFont.U_SINGLE);
		    hlink_font.setColor(IndexedColors.BLUE.getIndex());
		    hlink_style.setFont(hlink_font);
		    
		    org.apache.poi.ss.usermodel.Hyperlink link = createHelper.createHyperlink(HyperlinkType.URL);
		    		//createHelper.createHyperlink(HSSFHyperlink.LINK_FILE);
		  //  HSSFHyperlink link = createHelper.createHyperlink(HSSFHyperlink.LINK_FILE);
		    link.setAddress(url);
		    cell.setHyperlink(link);
		    cell.setCellStyle(hlink_style);
		      
		    fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
	
		    fileOut.close();	
	
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	
	// returns true if Integer data is set successfully else false
	public boolean setIntCellData(String sheetName,String colName,int rowNum, int data){
		try{
			fis = new FileInputStream(path); 
			workbook = new HSSFWorkbook(fis);
	
			if(rowNum<=0)
				return false;
			
			int index = workbook.getSheetIndex(sheetName);
			int colNum=-1;
			if(index==-1)
				return false;		
			sheet = workbook.getSheetAt(index);

			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum=i;
			}
			if(colNum==-1)
				return false;
	
			sheet.autoSizeColumn(colNum); 
			row = sheet.getRow(rowNum-1);
			if (row == null)
				row = sheet.createRow(rowNum-1);
			
			cell = row.getCell(colNum);	
			if (cell == null)
		        cell = row.createCell(colNum);
		    cell.setCellValue(data);
	
		    fileOut = new FileOutputStream(path);
	
			workbook.write(fileOut);
	
		    fileOut.close();	
	
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	
	// returns true if Integer data is set successfully else false
		public boolean setFloatCellData(String sheetName,String colName,int rowNum, float data){
			try{
				fis = new FileInputStream(path); 
				workbook = new HSSFWorkbook(fis);
				if(rowNum<=0)
					return false;
				int index = workbook.getSheetIndex(sheetName);
				int colNum=-1;
				if(index==-1)
					return false;	
				sheet = workbook.getSheetAt(index);
				row=sheet.getRow(0);
				for(int i=0;i<row.getLastCellNum();i++){
					if(row.getCell(i).getStringCellValue().trim().equals(colName))
						colNum=i;
				}
				if(colNum==-1)
					return false;
				sheet.autoSizeColumn(colNum); 
				row = sheet.getRow(rowNum-1);
				if (row == null)
					row = sheet.createRow(rowNum-1);	
				cell = row.getCell(colNum);	
				if (cell == null)
			        cell = row.createCell(colNum);
			    cell.setCellValue(data);
			    fileOut = new FileOutputStream(path);
				workbook.write(fileOut);
			    fileOut.close();	
			}
			catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
	// returns true if sheet is created successfully else false
	public boolean addSheet(String  sheetname){		
		
		FileOutputStream fileOut;
		try {
			 workbook.createSheet(sheetname);	
			 fileOut = new FileOutputStream(path);
			 workbook.write(fileOut);
		     fileOut.close();		    
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// returns true if sheet is removed successfully else false if sheet does not exist
	public boolean removeSheet(String sheetName){		
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return false;
		
		FileOutputStream fileOut;
		try {
			workbook.removeSheetAt(index);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
		    fileOut.close();		    
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	// returns true if column is created successfully
	public boolean addColumn(String sheetName,String colName){
		try{				
			fis = new FileInputStream(path); 
			workbook = new HSSFWorkbook(fis);
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1)
				return false;	
			
			org.apache.poi.ss.usermodel.CellStyle style = workbook.createCellStyle();
			
			//HSSFCellStyle style = workbook.createCellStyle();
//			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			
			style = workbook.createCellStyle();
		    style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BRIGHT_GREEN.getIndex());
		    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			

			sheet=workbook.getSheetAt(index);	
			row = sheet.getRow(0);
			if (row == null)
				row = sheet.createRow(0);
			if(row.getLastCellNum() == -1)
				cell = row.createCell(0);
			else
				cell = row.createCell(row.getLastCellNum());
	        
			cell.setCellValue(colName);
	        cell.setCellStyle(style);
	        
	        fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
		    fileOut.close();		    

		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;	
	}
	// removes a column and all the contents
	public boolean removeColumn(String sheetName, int colNum) {
		try{
			if(!isSheetExist(sheetName))
				return false;
			fis = new FileInputStream(path); 
			workbook = new HSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetName);
			
			org.apache.poi.ss.usermodel.CellStyle style = workbook.createCellStyle();
		//	HSSFCellStyle style = workbook.createCellStyle();
//			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			
			style = workbook.createCellStyle();
		    style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BRIGHT_GREEN.getIndex());
		    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			org.apache.poi.ss.usermodel.CreationHelper createHelper = workbook.getCreationHelper();
		//	HSSFCreationHelper createHelper = workbook.getCreationHelper();
			style.setFillPattern(FillPatternType.NO_FILL);
			for(int i =0;i<getRowCount(sheetName);i++){
				row=sheet.getRow(i);	
				if(row!=null){
					cell=row.getCell(colNum);
					if(cell!=null){
						cell.setCellStyle(style);
						row.removeCell(cell);
					}
				}
			}
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
		    fileOut.close();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
  // find whether sheets exists	
	public boolean isSheetExist(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1){
			index=workbook.getSheetIndex(sheetName.toUpperCase());
				if(index==-1)
					return false;
				else
					return true;
		}
		else
			return true;
	}
	
	// returns number of columns in a sheet	
	public int getColumnCount(String sheetName){
		// check if sheet exists
		if(!isSheetExist(sheetName))
		 return -1;
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		if(row==null)
			return -1;	
		return row.getLastCellNum();	
	}
	//String sheetName, String testCaseName,String keyword ,String URL,String message
	public boolean addHyperLink(String sheetName,String screenShotColName,String testCaseName,int index,String url,String message){		
		url=url.replace('\\', '/');
		if(!isSheetExist(sheetName))
			 return false;	
	    sheet = workbook.getSheet(sheetName);
	    for(int i=2;i<=getRowCount(sheetName);i++){
	    	if(getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName)){
	    		setCellData(sheetName, screenShotColName, i+index, message,url);
	    		break;
	    	}
	    }
		return true; 
	}
	public int getCellRowNum(String sheetName,String colName,String cellValue){
		for(int i=2;i<=getRowCount(sheetName);i++){
	    	if(getCellData(sheetName,colName , i).equalsIgnoreCase(cellValue)){
	    		return i;
	    	}
	    }
		return -1;	
	}
		
	// to run this on stand alone
	public static void main(String arg[]) throws IOException{
		XL_Reader datatable = null;
		String abc="abcd";
			 datatable = new XL_Reader("C:\\Selenium2.0\\app\\test\\Framework\\AutomationBvt_Hybrid\\src\\config\\db_data.xlsx");
				for(int col=0 ;col< datatable.getColumnCount("db_data"); col++){
				}
				datatable.setCellData("Evaluation", "generated_call_id", 2, abc);	
	}
	
	
}

