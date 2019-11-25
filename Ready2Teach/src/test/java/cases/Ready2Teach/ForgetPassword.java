package cases.Ready2Teach;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ForgetPassword extends base{

	@BeforeTest
	public void basePageNavigation() throws IOException
	{
		driver = InitializeDriver();		
	}
	

	@Test(dataProvider = "getForgetPasswordData")
	public void forgetPwd(String email,String gmailID,String gmailPassword,String Newpasswd, String CnfmPassword) throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		ForgetPassword_Attr fpa = new ForgetPassword_Attr(driver);
		WebElement ForgetPassword = fpa.getForgetpwd();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ForgetPassword);
		
		fpa.getRecoveremail().sendKeys(email);
		WebElement recover = fpa.getReset();
		js.executeScript("arguments[0].click();", recover);
		
		String alertbox = fpa.getcheckforget().getText();
		AssertJUnit.assertEquals(alertbox.startsWith("A password"),true);
		
		if(alertbox.startsWith("A password"))
		{
			System.out.println("mail is sent for forget password.check for the mail?");
		}
		else
		{
			System.out.println("check for the mail?");
		}
		
		
		
		
		WebElement Signin = fpa.getSigninForgetpwd();
		js.executeScript("arguments[0].click();", Signin);
	
		//gmail login code
		if(email.contains("gmail"))
		{
			Set<String> mainWindows = driver.getWindowHandles();
			String parent = driver.getWindowHandle();
			((JavascriptExecutor)driver).executeScript("window.open();");
			Set<String> Windows = driver.getWindowHandles();
			Windows.removeAll(mainWindows);
			String newTab = ((String)Windows.toArray()[0]);
			driver.switchTo().window(newTab);
			driver.get("https://accounts.google.com");
			driver.findElement(By.id("identifierId")).sendKeys(gmailID);
			WebElement next = driver.findElement(By.xpath("//span[@class='RveJvd snByac']"));
			js.executeScript("arguments[0].click();", next);
			
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(gmailPassword);
			js.executeScript("arguments[0].click();", next);
			
			
			driver.findElement(By.xpath("//a[@role='button']")).click();
			
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement gmail1=driver.findElement(By.xpath("//a[@id='gb23']"));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(gmail1));
			driver.findElement(By.xpath("//a[@id='gb23']")).click();
			
			Set<String> Window = driver.getWindowHandles();
			Iterator<String> it = Window.iterator();
			String parentId = it.next();
			String child1Id = it.next();
			String child2Id = it.next();
			driver.switchTo().window(child2Id);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@role='row'][1]"))));
			driver.findElement(By.xpath("//tr[@role='row'][1]")).click();
			
			int password_reset = driver.findElements(By.xpath("//div[@class='adn ads']")).size();
			driver.findElements(By.xpath("//div[@class='adn ads']")).get(password_reset-1).click();
			driver.findElement(By.xpath("//span[@class='im'] //a")).click();
		
			Set<String> Window1 = driver.getWindowHandles();
			Iterator<String> it1 = Window1.iterator();
			String parentId1 = it1.next();
			String child1Id1 = it1.next();
			String child2Id1 = it1.next();
			String child3Id1 = it1.next();
			driver.switchTo().window(child3Id1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='text-center m-b-20']")));
			String Reset_password = driver.findElement(By.xpath("//h3[@class='text-center m-b-20']")).getText();
			
			AssertJUnit.assertTrue(Reset_password.contains("Reset Password"));
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Newpasswd);
			driver.findElement(By.xpath("//input[@id='confirm_password']")).sendKeys(CnfmPassword);
			//driver.findElement(By.xpath("//button[@class='btn btn-block btn-lg btn-info btn-rounded']")).click();
			WebElement Reset = driver.findElement(By.xpath("//button[@class='btn btn-block btn-lg btn-info btn-rounded']"));
			js.executeScript("arguments[0].click();", Reset);
			String Passwordchanged = driver.findElement(By.xpath("//em[contains(text(),'Password reset has been done successfully. Please')] ")).getText();
			AssertJUnit.assertTrue(Passwordchanged.contains("Password reset has been done successfully"));
			driver.switchTo().window(parentId1);
			driver.close();
			driver.switchTo().window(child1Id1);
			driver.close();
			driver.switchTo().window(child2Id1);
			driver.close();
			driver.switchTo().window(child3Id1);
		}
		
		else
			System.out.println("Please check your email id for ");
		/*else if(email.contains("online"))
		
			Set<String> mainWindows = driver.getWindowHandles();
			String parent = driver.getWindowHandle();
			((JavascriptExecutor)driver).executeScript("window.open();");
			Set<String> Windows = driver.getWindowHandles();
			Windows.removeAll(mainWindows);
			String newTab = ((String)Windows.toArray()[0]);
			driver.switchTo().window(newTab);
			driver.get("https://emailfake.com/");
			driver.findElement(By.xpath("//input[@id='userName']")).clear();
			driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("techno");
			driver.findElement(By.xpath("//input[@id='domainName2']")).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath("//input[@id='domainName2']")).clear();
			driver.findElement(By.xpath("//input[@id='domainName2']")).sendKeys("rajasoal.online");
			driver.findElement(By.xpath("//input[@id='domainName2']")).sendKeys(Keys.ENTER);
	*/
	}
	
	@Test
	public void Forget_SignIn()
	{
		driver.get(prop.getProperty("url"));
		ForgetPassword_Attr fpa = new ForgetPassword_Attr(driver);
		WebElement ForgetPassword = fpa.getForgetpwd();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ForgetPassword);
		
		WebElement SignIn = fpa.getFogetpasswordSignIn();
		js.executeScript("arguments[0].click();", SignIn);
	}
	
	@Test
	public void forgetPasswordErr()
	{
		driver.get(prop.getProperty("url"));
		ForgetPassword_Attr fpa = new ForgetPassword_Attr(driver);
		WebElement ForgetPassword = fpa.getForgetpwd();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ForgetPassword);
		
		fpa.getRecoveremail().sendKeys("ragini");
		WebElement recover = fpa.getReset();
		js.executeScript("arguments[0].click();", recover);
		
		String EmailError = fpa.getEmailErr().getText();
		AssertJUnit.assertTrue(EmailError.contains("Please enter a valid email address"));
	}
	
	@Test
	public void ForgetPwdSchoolRegis()
	{
		driver.get(prop.getProperty("url"));
		ForgetPassword_Attr fpa = new ForgetPassword_Attr(driver);
		WebElement ForgetPassword = fpa.getForgetpwd();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ForgetPassword);
		
		WebElement school_btn = fpa.getschool();
		js.executeScript("arguments[0].click();",school_btn);
		
		String school_reg = fpa.getSchoolRegistration().getText();
		AssertJUnit.assertEquals(school_reg.contains("School Registration"),true);
	}
	
	@Test
	public void ForgetPwdSubsRegis()
	{
		driver.get(prop.getProperty("url"));
		ForgetPassword_Attr fpa = new ForgetPassword_Attr(driver);
		WebElement ForgetPassword = fpa.getForgetpwd();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ForgetPassword);
		WebElement subs_registration = fpa.getSubsRegistration();
		js.executeScript("arguments[0].click();", subs_registration);
		
		String Teacher_reg = fpa.getsubsTeachreg().getText();
		AssertJUnit.assertEquals(Teacher_reg.contains("Teacher Registration"),true);
	}
	
	@AfterTest
	public void closedriver()
	{
		driver.close();
		driver = null;
	}
	
	
	@DataProvider
	public Object[][] getForgetPasswordData()
	{
		Object[][] data = new Object[1][5];
		data[0][0] = "2211ragini@gmail.com"; //change password of this Email
		data[0][1] = "2211Ragini@gmail.com"; //gmail id
		data[0][2] = "Raginibisht@2019";  //gmail password
		data[0][3] = "Raginibisht*2019"; //New Password
		data[0][4] = "Raginibisht*2019"; //Confirm New Password
		
		return data;
	}
}
