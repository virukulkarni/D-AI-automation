package datatable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;



public class ReadingXLS {

	public Object[][] Phonedata;
	public Object[][][] TestCaseData;
	public static int tc=1;
	
	// Constructor
	public ReadingXLS()
	{
		
		Phonedata = getPhoneDataFromConfigDB();
		TestCaseData = getTestCaseDataFromConfigDB();
	}
	
	
	
	public Object[][] getPhoneDataFromConfigDB()
	{
		//String rawData[][]= new String [100][15];
		Object[][] object = new Object[100][15];
		
		try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection( "jdbc:odbc:Driver={Driver do Microsoft Excel(*.xls)};DBQ=C:\\Users\\khemraj.c\\Desktop\\Temp\\DB\\OIG_93_97_Sanity_Config.xls");
            Connection con = DriverManager.getConnection( "jdbc:odbc:Driver={Driver do Microsoft Excel(*.xls)};DBQ="+System.getProperty("user.dir")+"\\src\\config\\Core.xls");
            Statement st = con.createStatement();       
            ResultSet rs = st.executeQuery("Select * from [Extensions$]");
 
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            int numberofRows=0;
            
            
            while(rs.next())
            {
            	
            	for(int i = 1; i <= numberOfColumns; i++)
            	{
            		object[numberofRows][i] =rs.getObject(i);
            		System.out.print(object[numberofRows][i]+", ");
            	}
            	numberofRows = numberofRows+1;
            	
            }
            
            st.close();
            con.close();
 
        } catch (Exception ex) {
            System.err.print("Exception: ");
            System.err.println(ex.getMessage());
        }
		return object;
	}
	
	public Object[][][] getTestCaseDataFromConfigDB(){
		Object[][][] phoneObject = new Object[100][100][15];
		
		try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection( "jdbc:odbc:Driver={Driver do Microsoft Excel(*.xls)};DBQ=C:\\Users\\khemraj.c\\Desktop\\Temp\\DB\\OIG_93_97_Sanity_Config.xls");
            Connection con = DriverManager.getConnection( "jdbc:odbc:Driver={Driver do Microsoft Excel(*.xls)};DBQ="+System.getProperty("user.dir")+"\\src\\config\\Core.xls");
            Statement st = con.createStatement();       
            ResultSet rs = st.executeQuery("Select * from [Suite1$] where Runmode='Y'");
            
            ResultSetMetaData rsmd = rs.getMetaData();
            //int numberOfColumns = rsmd.getColumnCount();

            
            
            while(rs.next())
            {
            	phoneObject[tc][1][1] = rs.getObject(2);
            	String testCaseName = (String) phoneObject[tc][1][1];
            	 Statement st1 = con.createStatement();
            	ResultSet rs1 = st1.executeQuery("Select * from ["+testCaseName+"$]");
        		ResultSetMetaData rsmd1 = rs1.getMetaData();
                int numberOfColumns = rsmd1.getColumnCount();
                int numberofRows=1;
                while(rs1.next())
                {
                	
	            	for(int i = 1; i <= numberOfColumns; i++)
	            	{
	            		phoneObject[tc][numberofRows][i] =rs1.getObject(i);
	            		System.out.print(phoneObject[tc][numberofRows][i]+", ");
	            	}
	            	numberofRows = numberofRows+1;
            	
                }
                tc = tc+1;
                st1.close();
            }
            
            st.close();
            con.close();
 
        } catch (Exception ex) {
            System.err.print("Exception: ");
            System.err.println(ex.getMessage());
        }
		return phoneObject;
	}
	
	public static void main(String[] args) {
		ReadingXLS Dataobj = new ReadingXLS();
	}
}
