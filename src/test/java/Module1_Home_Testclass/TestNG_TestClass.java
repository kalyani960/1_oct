package Module1_Home_Testclass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.Utility_class;
import Module1_Home.Insurance_Broker_Insurance_Webpage;
import Module1_Home.Insurance_Login;

public class TestNG_TestClass extends BaseClass
{

	Insurance_Login login;
	Insurance_Broker_Insurance_Webpage broker;
	int TestCaseID;
	@ BeforeClass
	public void openBrowser()
	{
		initializebrowser();
		
		//Create Object Of POM-I Class
		 login=new Insurance_Login(driver);
		 
		//Create Object Of POM-II Class  
	     broker=new Insurance_Broker_Insurance_Webpage(driver);
	}
	
	@ BeforeMethod
	public void Logintoapp() throws IOException
	{
		login.EnterEmail(Utility_class.getDatafromPF("EM"));
		login.Enterpassword(Utility_class.getDatafromPF("PSW"));
		login.ClickLoginbtn();
	}
	
	@Test(priority=1)
	public void VerifyEmailAddress() throws EncryptedDocumentException, IOException
	{
		TestCaseID=100;
	    //verify Email Address
	    String	ActualEmail=broker.GetEmail();
	 String  ExpectedTitle= Utility_class.getdatafromExcelsheet(2, 0);
	 
	 Assert.assertEquals(ActualEmail, ExpectedTitle);
	    
		
	}
	
	@Test(priority=2)
	public void VerifyTitle() throws EncryptedDocumentException, IOException
	{
		TestCaseID=101;
	String 	ActualTitle=driver.getTitle();
	
	 String ExpectedTitle=Utility_class.getdatafromExcelsheet(2, 0);
	 
	 
	 Assert.assertEquals(ActualTitle, ExpectedTitle);
		
	}
	
	
	@ AfterMethod
	public void Logoutfromapp(ITestResult Result) throws IOException
	{
		if(Result.getStatus()==ITestResult.FAILURE)
		{
			Utility_class.CaptureScreenshot(driver, TestCaseID);
		}
		broker.ClickLogout();
	}
	
	@ AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}
	
	
	
}
