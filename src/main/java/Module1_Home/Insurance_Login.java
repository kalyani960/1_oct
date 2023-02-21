package Module1_Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insurance_Login 
{
	//POM-I
	//1. Data members/Global Variables should be declared globally with access level private
	//by using @findby Annotation
	
	 @FindBy(xpath="//input[@name='email']")            private  WebElement Email;
	 @FindBy(xpath="//input[@id='password']")         private  WebElement Password;
	 @FindBy(xpath="//input[@type='submit']")         private  WebElement Loginbtn;
	          
	//2. Initialize within a constructor with access level public using pagefactory
	 
	 public Insurance_Login(WebDriver driver)
		{
			 PageFactory.initElements(driver, this);
	    }
	          
	//3. Utilize within a method with access level public
	 
	 public void EnterEmail(String Emailaddress)
	 {
		Email.sendKeys(Emailaddress); 
	 }
	 
	 public void Enterpassword(String pass)
	 {
		 Password.sendKeys(pass); 
	 }
	 
	 public void ClickLoginbtn()
	 {
		 Loginbtn.click();
	 }
	 
	 
}