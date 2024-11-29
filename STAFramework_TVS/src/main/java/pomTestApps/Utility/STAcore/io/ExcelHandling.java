package pomTestApps.Utility.STAcore.io;
/**************************************************
#Project Name: MiTEL_MXONE - Selenium Framework

#Class Name: ExcelHandling()
#Description:1. This function reads the excelsheet containing test data related to test case.
#Input Parameters:File Path,Test Class Name
#Owner: Ashis Kumar Pradhan
#Author: Ashis Kumar Pradhan
#Date of creation: 03-July-16
#Name of person modifying: (Tester Name): 
#Date of modification: 
‘**************************************************/
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ExcelHandling {

	int intColumnValue;
	int intNum_Val_Row = 0;
	static String testDescription;
	Workbook wb;
	static Sheet S1;
	static int numCols = 1;
	String oldStrFilePath;
	int cellCount = 0;

	public void openExecl(String newStrFilePath, String sheetName) {
		System.out
				.println("****************************************************");
		System.out.println("New File Path ---------" + newStrFilePath);
		System.out.println("New File Path ---------" + newStrFilePath);
		System.out.println("Old File Path ---------" + oldStrFilePath);
		System.out
				.println("****************************************************");

		try {
			newStrFilePath = newStrFilePath + ".xls";
			if (numCols == 1 || (!newStrFilePath.equals(oldStrFilePath))) {
				S1 = null;
				wb = Workbook.getWorkbook(new File(newStrFilePath));
				System.out.println(wb.getNumberOfSheets() + "********");
				System.out.println(wb.getSheet(sheetName).getName());
				S1 = wb.getSheet("Sanity");
				System.out.println("Opening the Excel");
			} else {
				System.out.println("Reusing the excel");
			}
		} catch (BiffException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}
		oldStrFilePath = newStrFilePath;
		numCols++;
	}

	public Object[][] defreadExcel(String strClassName) throws BiffException,
			IOException {
		ArrayList<Integer> listrow_val = new ArrayList<Integer>();
		intNum_Val_Row = 0;
		cellCount=0;
		System.out
				.println("************************************************************");
		System.out.println("---------------Inside Read Excel---------------");
		System.out.println("No of Total Rows are " + S1.getRows());
		System.out.println("No of Total Cols are " + S1.getColumns());
		System.out.println(" Class Name is: " + strClassName);
		int rownum = S1.findCell(strClassName).getRow();
		System.out.println("The TestCase is present at  " + rownum + " row.");

		Boolean dataFound = true;
		while (dataFound.equals(true)) {
			for (int j = 0; j < S1.getColumns(); j++) {
				if (j == (S1.getColumns() - 1)) {
					dataFound = false;
				}

				try {
					if (S1.getCell(j, rownum).getContents().trim().length() <= 0) {
						dataFound = false;
					}

					else {
						System.out.println("Cellcount is :" + cellCount);
						System.out.println("Value is "
								+ S1.getCell(j, rownum).getContents());
						System.out.println("length is :"
								+ S1.getCell(j, rownum).getContents().length());

						cellCount++;
					}

				} catch (NullPointerException e) {
					dataFound = false;
				}
			}
		}

		System.out.println("No of Parameters passed to the Test Case(Including TC ID and TC Desc): "
				+ cellCount);
		
		System.out.println("No of Parameters passed to the Test Case(Including TC ID and TC Desc): "
				+ cellCount);
		/*************************************************************************
		 * get the number of Times the TC is present in the Input Excel. Store
		 * the value in the variable intNum_Val_Row
		 **************************************************************************/
		for (int j = 0; j < S1.getRows(); j++) {
			if (S1.getCell(0, j).getContents().equals(strClassName)) {
				testDescription = S1.getCell(1, j).getContents();
				
				System.out.println("Description in "+j+ " >>>>"+j);
				listrow_val.add(j);
				intNum_Val_Row++;
			}
		}

		System.out.println("Row value: "+intNum_Val_Row);
		
		System.out.println("Cell count :"+cellCount);
		
		// Reads the TC related values from the Sheet
		Object[][] arrTable = new Object[intNum_Val_Row][cellCount - 2];
		for (int i = 0; i < intNum_Val_Row; i++) {
			System.out.println("cell vlaue --"+cellCount);
			
			for (int k = 2; k < cellCount; k++) {
				if (!S1.getCell(k, listrow_val.get(i)).getContents().isEmpty()) {
					arrTable[i][k - 2] = S1.getCell(k, listrow_val.get(i))
							.getContents();
					System.out.println("inside for loop");
					System.out.println(arrTable[i][k-2]);
				}
			}

		}

		// System.out.println("No of values: " + intColumnValue);
		System.out.println(" Test Case Desc:" + testDescription);
		System.out.println(" No of Rows for the Test Case :" + intNum_Val_Row);
		
		System.out.println("Row :"+intNum_Val_Row);
		System.out
				.println("************************************************************");

		return arrTable;
	}

	public String getTestDescription() {
		System.out.println("inside getTestDescription " + testDescription);
		return testDescription;
	}
}
