package cases.Ready2Teach;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubsRegis extends base {

	@BeforeTest
	public void basePageNavigation() throws IOException
	{
		driver = InitializeDriver();		
	}
	
	
	@Test
	public void SubsRegis_Err()
	{
		driver.get(prop.getProperty("url"));
		SubsTeacher_Reg_Attr rga = new SubsTeacher_Reg_Attr(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement SubsRegis = rga.getsubs_Reg();
		js.executeScript("arguments[0].click();", SubsRegis);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(rga.getSubs_SignUp()));
		js.executeScript("arguments[0].click();", rga.getSubs_SignUp());
		
		String FullNameErr = rga.getFullNameErr().getText();
		AssertJUnit.assertTrue(FullNameErr.contains("Please enter full name"));
		String Emailerr = rga.getEmailErr().getText();
		AssertJUnit.assertTrue(Emailerr.contains("Please enter valid email address"));
		String passwordErr = rga.getPasswordErr().getText();
		AssertJUnit.assertTrue(passwordErr.contains("Please enter a password"));
		String cnfrmPasswordErr = rga.getcnfrmPasswordErr().getText();
		AssertJUnit.assertTrue(cnfrmPasswordErr.contains("Please enter confirm password"));
		String InstructorErr = rga.getInstructorTypeErr().getText();
		AssertJUnit.assertTrue(InstructorErr.contains("Please select instructor type"));
		String SubTypeErr = rga.getSubTypeErr().getText();
		AssertJUnit.assertTrue(SubTypeErr.contains("Please select instructor sub type"));
		String CountyErr = rga.getCountyErr().getText();
		AssertJUnit.assertTrue(CountyErr.contains("Please select county"));	
	}
	
	@Test(dataProvider = "EmailCheck")
	public void EmailIdErr(String SubsName, String Email) 
	{
		driver.get(prop.getProperty("url"));
		SubsTeacher_Reg_Attr rga = new SubsTeacher_Reg_Attr(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement SubsRegis = rga.getsubs_Reg();
		js.executeScript("arguments[0].click();", SubsRegis);
		
		rga.getSubsName().sendKeys(SubsName);
		rga.getSubsEmail().sendKeys(Email);

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(rga.getSubs_SignUp()));
		js.executeScript("arguments[0].click();", rga.getSubs_SignUp());
		
		String SubsEmailFormatErr = rga.getSubsEmailFormatErr().getText();
		AssertJUnit.assertTrue(SubsEmailFormatErr.contains("Please enter valid email address format"));		
	}
	
	@Test(dataProvider="passwrdErr1")
	public void PasswordErrs(String SubsName, String Email, String Phnumn, String Password)
	{
		driver.get(prop.getProperty("url"));
		SubsTeacher_Reg_Attr rga = new SubsTeacher_Reg_Attr(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement SubsRegis = rga.getsubs_Reg();
		js.executeScript("arguments[0].click();", SubsRegis);
		rga.getSubsName().sendKeys(SubsName);
		rga.getSubsEmail().sendKeys(Email);
		rga.getSubsPassword().sendKeys(Phnumn);
		rga.getSubsPasswordlengthErr().sendKeys(Password);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(rga.getSubs_SignUp()));
		js.executeScript("arguments[0].click();", rga.getSubs_SignUp());
		
		wait.until(ExpectedConditions.visibilityOf(rga.SubsPwdlengthErr()));
		String pwdlengthText = rga.SubsPwdlengthErr().getText();
		AssertJUnit.assertTrue(pwdlengthText.startsWith("Password must be"));
		
	}
	
	@Test(dataProvider = "passwordErr")
	public void PasswordvalidErr(String SubsName, String Email, String Phnumn, String Password)
	{
		driver.get(prop.getProperty("url"));
		SubsTeacher_Reg_Attr rga = new SubsTeacher_Reg_Attr(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement SubsRegis = rga.getsubs_Reg();
		js.executeScript("arguments[0].click();", SubsRegis);
		rga.getSubsName().sendKeys(SubsName);
		rga.getSubsEmail().sendKeys(Email);
		rga.getSubsPassword().sendKeys(Phnumn);
		rga.getSubsPasswordlengthErr().sendKeys(Password);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(rga.getSubs_SignUp()));
		js.executeScript("arguments[0].click();", rga.getSubs_SignUp());
	}
	
	@Test(dataProvider="cnfrmpwd")
	public void cnfrmPasswordErr(String SubsName, String Email, String Phnumn, String Password, String cnfmPwd)
	{
		driver.get(prop.getProperty("url"));
		SubsTeacher_Reg_Attr rga = new SubsTeacher_Reg_Attr(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement SubsRegis = rga.getsubs_Reg();
		js.executeScript("arguments[0].click();", SubsRegis);
		
		rga.getSubsName().sendKeys(SubsName);
		rga.getSubsEmail().sendKeys(Email);
		rga.getSubsPassword().sendKeys(Phnumn);
		rga.getSubsPasswordlengthErr().sendKeys(Password);
		rga.SubsCnfmPassword().sendKeys(cnfmPwd);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(rga.getSubs_SignUp()));
		js.executeScript("arguments[0].click();", rga.getSubs_SignUp());
		
		String CnfmPasswordErr = rga.getSubsCnfmPasswordErr().getText();
		AssertJUnit.assertTrue(CnfmPasswordErr.contains("Passwords do not match"));		
	}
	
	@Test(dataProvider="SelectAll")
	public void InstructorSelectAll(String SubsName, String Email, String Phnumn, String Password, String cnfmPwd)
	{
		driver.get(prop.getProperty("url"));
		SubsTeacher_Reg_Attr rga = new SubsTeacher_Reg_Attr(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement SubsRegis = rga.getsubs_Reg();
		js.executeScript("arguments[0].click();", SubsRegis);
		rga.getSubsName().sendKeys(SubsName);
		rga.getSubsEmail().sendKeys(Email);
		rga.getSubsPassword().sendKeys(Phnumn);
		rga.getSubsPasswordlengthErr().sendKeys(Password);
		rga.SubsCnfmPassword().sendKeys(cnfmPwd);
		rga.getSubsInstructorSelectAll().click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElements(rga.getSubsInstructionType()));
		
		rga.SubsInstructorRemoveAll().click();
		Assert.assertTrue(rga.getSubsRemoveAllCheck().getText().contains(""));
	}
	
	@Test(dataProvider="SelectAll")
	public void SubInstructorSelectAll(String SubsName, String Email, String Phnumn, String Password, String cnfmPwd) throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		SubsTeacher_Reg_Attr rga = new SubsTeacher_Reg_Attr(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement SubsRegis = rga.getsubs_Reg();
		js.executeScript("arguments[0].click();", SubsRegis);
		rga.getSubsName().sendKeys(SubsName);
		rga.getSubsEmail().sendKeys(Email);
		rga.getSubsPassword().sendKeys(Phnumn);
		rga.getSubsPasswordlengthErr().sendKeys(Password);
		rga.SubsCnfmPassword().sendKeys(cnfmPwd);
		
		js.executeScript("arguments[0].click();",rga.getSubsInstructorSelectAll());
		Thread.sleep(2000);
		WebElement SubsSubtype = rga.getSubsSubTypeSelectAll();
		js.executeScript("arguments[0].click();", SubsSubtype);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(rga.getSubsSubTypeRemoveAll()));
		rga.getSubsSubTypeRemoveAll().click();
		rga.getSubsTypeRemoveAllCheck().getText();
		AssertJUnit.assertTrue(rga.getSubsTypeRemoveAllCheck().getText().contains(""));
	}
	
	@Test(dataProvider = "signupData")
	public void SubsCounty(String SubsName, String Email, String Phnumn, String Password, String cnfmPwd, String County) throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		SubsTeacher_Reg_Attr rga = new SubsTeacher_Reg_Attr(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement SubsRegis = rga.getsubs_Reg();
		js.executeScript("arguments[0].click();", SubsRegis);
		rga.getSubsName().sendKeys(SubsName);
		rga.getSubsEmail().sendKeys(Email);
		rga.getSubsPassword().sendKeys(Phnumn);
		rga.getSubsPasswordlengthErr().sendKeys(Password);
		rga.SubsCnfmPassword().sendKeys(cnfmPwd);
		js.executeScript("arguments[0].click();",rga.getSubsInstructorSelectAll());
		Thread.sleep(2000);
		WebElement SubsSubtype = rga.getSubsSubTypeSelectAll();
		js.executeScript("arguments[0].click();", SubsSubtype);
		
		rga.getSubsCounty().click();
		
		int size = rga.getSubsCountyName().size();
		
		for(int i=0;i<size;i++)
		{
			if(rga.getSubsCountyName().get(i).getText().equals(County))
			{
				rga.getSubsCountyName().get(i).click();
				break;
			}
		}
		
		AssertJUnit.assertEquals(rga.getSubsCounty().getText(), County);
	}

	@Test(dataProvider="signupData")
	public void FinalTest(String SubsName, String Email, String Phnumn, String Password, String cnfmPwd, String County) throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		SubsTeacher_Reg_Attr rga = new SubsTeacher_Reg_Attr(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement SubsRegis = rga.getsubs_Reg();
		js.executeScript("arguments[0].click();", SubsRegis);
		rga.getSubsName().sendKeys(SubsName);
		rga.getSubsEmail().sendKeys(Email);
		rga.getSubsPassword().sendKeys(Phnumn);
		rga.getSubsPasswordlengthErr().sendKeys(Password);
		rga.SubsCnfmPassword().sendKeys(cnfmPwd);
		js.executeScript("arguments[0].click();",rga.getSubsInstructorSelectAll());
		Thread.sleep(2000);
		WebElement SubsSubtype = rga.getSubsSubTypeSelectAll();
		js.executeScript("arguments[0].click();", SubsSubtype);
		
		rga.getSubsCounty().click();
		
		int size = rga.getSubsCountyName().size();
		
		for(int i=0;i<size;i++)
		{
			if(rga.getSubsCountyName().get(i).getText().equals(County))
			{
				rga.getSubsCountyName().get(i).click();
				break;
			}
		}
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(rga.getSubs_SignUp()));
		js.executeScript("arguments[0].click();", rga.getSubs_SignUp());
		
	}
	
	@AfterTest
	public void closedriver()
	{
		driver.close();
		driver = null;
	}
	
	@DataProvider
	public Object[][] EmailCheck()
	{
		Object[][] data = new Object[1][2];
		data[0][0] = "Rachna"; //Subs Name
		data[0][1] = "Rachna"; //fill wrong Email Address
		
		return data;
	}
	
	@DataProvider
	public Object[][] passwrdErr1()
	{
		Object[][] data = new Object[1][4];
		data[0][0] = "Rachna"; //Subs Name
		data[0][1] = "Rachna@rajasoal.online"; //Subs Email
		data[0][2] = "5646545644"; //Subs Phone Number
		data[0][3] = "rachna";  //Subs Password half
	
		
		
		return data;
	}
	
	@DataProvider
	public Object[][] passwordErr()
	{
		Object[][] data = new Object[1][4];
		data[0][0] = "Rachna"; //Subs Name
		data[0][1] = "Rachna@rajasoal.online"; //Subs Email
		data[0][2] = "5646545644"; //Subs Phone Number
		data[0][3] = "Rachna@";  //Subs Password Leave at @ for check 
	
		
		
		return data;
	}
	
	@DataProvider
	public Object[][] cnfrmpwd()
	{
		Object[][] data = new Object[1][5];
		data[0][0] = "Rachna"; //Subs Name
		data[0][1] = "Rachna@rajasoal.online"; //Subs Email
		data[0][2] = "5646545644"; //Subs Phone Number
		data[0][3] = "Rachna@raja";  //Subs Password
		data[0][4] = "Rachna";		//Subs wrong Confirm Password 
		
		
		return data;
	}
	
	@DataProvider
	public Object[][] SelectAll()
	{
		Object[][] data = new Object[1][5];
		data[0][0] = "Rachna"; //Subs Name
		data[0][1] = "Rachna@rajasoal.online"; //Subs Email
		data[0][2] = "5646545644"; //Subs Phone Number
		data[0][3] = "Rachna@raja";  //Subs Password
		data[0][4] = "Rachna@raja";		//Subs Confirm Password 
		
		
		return data;
	}
	
	@DataProvider
	public Object[][] signupData()
	{
		Object[][] data = new Object[1][6];
		data[0][0] = "Rachna"; //Subs Name
		data[0][1] = "Rachna@rajasoal.online"; //Subs Email
		data[0][2] = "5646545644"; //Subs Phone Number
		data[0][3] = "Rachna@raja";  //Subs Password
		data[0][4] = "Rachna@raja";		//Subs Confirm Password 
		data[0][5] = "Alabama, Autauga";  //Subs County
		
		return data;
	}
	
	
	
}
