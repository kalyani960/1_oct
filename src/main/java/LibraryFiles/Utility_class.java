package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Utility_class 
{

	    //Automation TE:@Kalyani
		//Date:15/02/2023
		//Day:Wed
		//Title: Fetch data from property file
	
	@Test
	public static String getDatafromPF(String key) throws IOException
	{
		//To reach upto property File
		FileInputStream file=new FileInputStream("C:\\Users\\sarvesh\\eclipse-workspace\\1Oct_MavenProject\\PropFile.Properties");
		
		//create object of properties class
		Properties prop=new Properties();
		
		//To open Property File
		prop.load(file);
		
		//To fetch data from Property file
		String value1=prop.getProperty(key);
		
		return value1;
		
	}
	
	        //Automation TE:@Kalyani
			//Date:15/02/2023
			//Day:Wed
			//Title: Fetch data from ExcelSheet
	
	    @Test
	    public static String getdatafromExcelsheet(int RowIndex, int Cellindex) throws EncryptedDocumentException, IOException
	    {
	    	//To reach upto Excelsheet
	    	FileInputStream file=new FileInputStream("C:\\Users\\sarvesh\\eclipse-workspace\\1Oct_MavenProject\\TestData\\Book2.xlsx");
	    	//To open Excelsheet and reach to particular sheet
	    Sheet	Sh=WorkbookFactory.create(file).getSheet("Sheet1");
	    
	  String value2 = Sh.getRow(RowIndex).getCell(Cellindex).getStringCellValue();
	  return value2;
	  
	    	
	    }
	    
	    public static void CaptureScreenshot(WebDriver driver,int TestCaseID) throws IOException
	    {
	    	File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	
	    	File Destination=new File("C:\\Users\\sarvesh\\eclipse-workspace\\1Oct_MavenProject\\Screenshot\\" +TestCaseID+ ".jpg");
	    	
	    	FileHandler.copy(Source, Destination);
	    	
	    }
	
	
	
	
	
}
