package cases.Ready2Teach;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_page extends base{
	
	@BeforeTest
	public void basePageNavigation() throws IOException
	{
		driver = InitializeDriver();

	}

	@Test(dataProvider = "getdata")
	public void loginPage(String email, String passwd)
	{
		driver.get(prop.getProperty("url"));
		LoginPage_Attr logAtt = new LoginPage_Attr(driver);
		logAtt.getEmail().clear();
		logAtt.getEmail().sendKeys(email);
		logAtt.getPwd().clear();
		logAtt.getPwd().sendKeys(passwd);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement Loginbtn = logAtt.getLoginbtn();
		js.executeScript("arguments[0].click();", Loginbtn);
		
		String name = logAtt.getlogincnfm().getText();
		AssertJUnit.assertTrue(name.contains("Welcome"));
		System.out.println("Logged in Successfully."); 
		WebElement profile = logAtt.getprofile();
		js.executeScript("arguments[0].click();", profile);
			
		WebElement logoutbtn =  logAtt.getLogout();
		js.executeScript("arguments[0].click()", logoutbtn);
	
		AssertJUnit.assertEquals("Sign In", logAtt.getlogoutcnfm().getText());
		
	}
	

	@Test(dataProvider = "getdata")
	public void testRembrMe(String email, String passwd)
	{
		driver.get(prop.getProperty("url"));
		LoginPage_Attr logAtt = new LoginPage_Attr(driver);
		logAtt.getEmail().clear();
		logAtt.getEmail().sendKeys(email);
		logAtt.getPwd().clear();
		logAtt.getPwd().sendKeys(passwd);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement remMe = logAtt.getRembrMe();
		js.executeScript("arguments[0].click();", remMe);
		
		String checkenabled = String.valueOf(remMe.isSelected()); //convert the boolean into string
		AssertJUnit.assertTrue(checkenabled,true);

		if(checkenabled.contains("true"))
		{
			System.out.println("Remember me checkbox of login page is enabled.");
			
			WebElement Loginbtn = logAtt.getLoginbtn();
			js.executeScript("arguments[0].click();", Loginbtn);
			WebElement profile = logAtt.getprofile();
			js.executeScript("arguments[0].click();", profile);
			     
			WebElement logoutbtn =  logAtt.getLogout();
			js.executeScript("arguments[0].click()", logoutbtn);
			
			String Email_ID = logAtt.getEmail().getText();
			AssertJUnit.assertEquals(email,Email_ID);
			String PassWord = logAtt.getPwd().getText();
			AssertJUnit.assertEquals(passwd,PassWord);
			 if(Email_ID.equalsIgnoreCase(email) && PassWord.equalsIgnoreCase(passwd))
			 {
				 System.out.println("Remember me checkbox of login page is working properly.");
			 }
			 else
			 {
				 System.out.println("Remember me checkbox of login page is not working.");
			 }
			
					
		}
		
		else
		{
			System.out.println("Remember me is not clickable.");
		}
			
	}
	
	@Test
	public void loginErr()
	{
		driver.get(prop.getProperty("url"));
		LoginPage_Attr logAtt = new LoginPage_Attr(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement Loginbtn = logAtt.getLoginbtn();
		js.executeScript("arguments[0].click();", Loginbtn);
		String EmailErr = logAtt.getEmailErr().getText();
		AssertJUnit.assertEquals(EmailErr, "Please enter a valid email address");
		
		String Pwderr = logAtt.getPwdErr().getText();
		AssertJUnit.assertEquals(Pwderr, "Please enter a password");
	}
	
	@Test
	public void EmailloginErr()
	{
		driver.get(prop.getProperty("url"));
		LoginPage_Attr logAtt = new LoginPage_Attr(driver);
		logAtt.getEmail().clear();
		logAtt.getEmail().sendKeys("Rachna");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement Loginbtn = logAtt.getLoginbtn();
		js.executeScript("arguments[0].click();", Loginbtn);
		
		String EmailErr2 = logAtt.getEmailErr2().getText();
		AssertJUnit.assertEquals("Please enter valid email address format", EmailErr2);
	}
	
	
	@Test(dataProvider = "getLoginError")
	public void Email_PasswordErr(String email, String passwd)
	{
		driver.get(prop.getProperty("url"));
		LoginPage_Attr logAtt = new LoginPage_Attr(driver);
		logAtt.getEmail().clear();
		logAtt.getEmail().sendKeys(email);
		logAtt.getPwd().clear();
		logAtt.getPwd().sendKeys(passwd);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement Loginbtn = logAtt.getLoginbtn();
		js.executeScript("arguments[0].click();", Loginbtn);
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(logAtt.getLoginErr()));
		String error = logAtt.getLoginErr().getText();
		AssertJUnit.assertTrue(error.contains("The email address and password you entered do not match our records"));
	}
	@AfterTest
	public void closedriver()
	{
		driver.close();
		driver = null;
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data =new Object[1][2];
		data[0][0]= "2211ragini@gmail.com";//Login Email Id
		data[0][1]= "test123@r2t";//Login Password
		
		return data;
	}
	
	@DataProvider
	public Object[][] getLoginError()
	{
		Object[][] data = new Object[1][2];
		data[0][0] = "2211ragini@gmail.com";
		data[0][1] = "Ragini123";
		
		return data;
	}
	
}
