package cases.Ready2Teach;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class School_Register extends base {
	
	@BeforeTest
	public void basePageNavigation() throws IOException
	{
		driver = InitializeDriver();
		
	}

		@Test
		public void subsregerror() throws InterruptedException
		{
			driver.get(prop.getProperty("url"));
			SchoolRegis_Attr logAtt = new SchoolRegis_Attr(driver);
			WebElement school = logAtt.getschool();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", school);
			Thread.sleep(2000);
			WebElement newSchool = logAtt.getnewschool();
			js.executeScript("arguments[0].click();", newSchool);
			
			
			Assert.assertEquals("Please enter your name", logAtt.getfullnamealert().getText());
			Assert.assertEquals("Please enter valid email address", logAtt.getemailalert().getText());
			Assert.assertEquals("Please enter a valid mobile number", logAtt.getphoneerr().getText());
			Assert.assertEquals("Please enter a password", logAtt.getphonepwderr().getText());
			Assert.assertEquals("Please enter confirm password", logAtt.getphonecnfmpwderr().getText());
			Assert.assertEquals("Please enter school name", logAtt.getschoolnameerr().getText());
			Assert.assertEquals("Please enter valid address", logAtt.getschoolAddrerr().getText());
			Assert.assertEquals("Please select county", logAtt.getschoolcountyerr().getText());

			js.executeScript("arguments[0].click();", logAtt.getSigininLink());
			/*
			log.getfullname().sendKeys("shivani");
			log.getschoolmail().sendKeys("divyanshu@covivemail.com");
			WebElement newSchool = log.getnewschool();
			js.executeScript("arguments[0].click();", newSchool);
			*/	
		}
		
		@Test
		public void schoolRegFormfill() throws InterruptedException
		{
			driver.get(prop.getProperty("url"));
			SchoolRegis_Attr logAtt = new SchoolRegis_Attr(driver);
			WebElement school = logAtt.getschool();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", school);
			String school_reg = logAtt.getSchoolRegistration().getText();
			Assert.assertEquals(school_reg.contains("School Registration"),true);
			
			logAtt.getfullname().sendKeys("vikram");
			logAtt.getschoolmail().sendKeys("vikram@convivmail.club");
			logAtt.getSchoolphnum().sendKeys("8193016324");
			logAtt.getPwd().sendKeys("Vikram@con");
			logAtt.getSchoolcnfmphnm().sendKeys("Vikram@con");
			//logAtt.getSchoolName().click();
			logAtt.getSchoolName().sendKeys("TestSchoolAuto");
			logAtt.getSchoolName().sendKeys(Keys.TAB);
			Thread.sleep(2000);
			logAtt.getSchoolAddr().sendKeys("noida");
			logAtt.getSchoolcounty().click();
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(logAtt.getCountyName()));
			logAtt.getCountyName().sendKeys("Alabama, Autauga");
			
			int countyNameList = logAtt.getSchoolCountyName().size();
			System.out.println(countyNameList);
			
			for(int i=0;i<countyNameList;i++)
			{
				String countyName = logAtt.getSchoolCountyName().get(i).getText();
				if(countyName.equalsIgnoreCase("Alabama, Autauga"))
				{
					logAtt.getSchoolCountyName().get(i).click();
					System.out.println("test");
					break;
				}
				else
				{
					System.out.println("county name");
				}	
			}
			
			wait.until(ExpectedConditions.visibilityOf(logAtt.getSignUP()));
			logAtt.getSignUP().click();
			String alertText = logAtt.getcnfrm().getText();
			Assert.assertTrue(alertText.contains("Account created successfully."));
			js.executeScript("arguments[0].click();", logAtt.getSigininLink());
		}
		
		@Test
		public void validemailErr() throws InterruptedException
		{
			driver.get(prop.getProperty("url"));
			SchoolRegis_Attr logAtt = new SchoolRegis_Attr(driver);
			WebElement school = logAtt.getschool();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", school);
			String school_reg = logAtt.getSchoolRegistration().getText();
			Assert.assertEquals(school_reg.contains("School Registration"),true);
			
			logAtt.getfullname().sendKeys("vikram");
			logAtt.getschoolmail().sendKeys("vikram");
			Thread.sleep(2000);
			String emailCnfm = logAtt.getEmailValidErr().getText();
			Assert.assertTrue(emailCnfm.contains("Please enter a valid email address"));
		}
		
		@Test
		public void pwdLengthErr()
		{
			driver.get(prop.getProperty("url"));
			SchoolRegis_Attr logAtt = new SchoolRegis_Attr(driver);
			WebElement school = logAtt.getschool();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", school);
			String school_reg = logAtt.getSchoolRegistration().getText();
			Assert.assertEquals(school_reg.contains("School Registration"),true);
			
			logAtt.getfullname().sendKeys("vikram");
			logAtt.getschoolmail().sendKeys("vikram@convivmail.club");
			logAtt.getSchoolphnum().sendKeys("8193016324");
			logAtt.getPwd().sendKeys("123456");
			String pwd = logAtt.getpwdLengthErr().getText();
			Assert.assertTrue(pwd.contains("Password must be between 8 and 16 characters long and must contain a number, an uppercase letter, and a symbol."));	
		}
		
		@Test
		public void cnfmPwdMatchErr() throws InterruptedException
		{
			driver.get(prop.getProperty("url"));
			SchoolRegis_Attr logAtt = new SchoolRegis_Attr(driver);
			WebElement school = logAtt.getschool();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", school);
			String school_reg = logAtt.getSchoolRegistration().getText();
			Assert.assertEquals(school_reg.contains("School Registration"),true);
			
			logAtt.getfullname().sendKeys("vikram");
			logAtt.getschoolmail().sendKeys("vikram@convivmail.club");
			logAtt.getSchoolphnum().sendKeys("8193016324");
			logAtt.getPwd().sendKeys("Vikram@con");
			logAtt.getSchoolcnfmphnm().sendKeys("khbhsdfh");
			Thread.sleep(2000);
			String cnfmErr = logAtt.getCnfrmPwdMissMatch().getText();
			Assert.assertTrue(cnfmErr.contains("Passwords do not match"));
			
		}
		
		@Test
		public void cnfmPwdMatch()
		{
			driver.get(prop.getProperty("url"));
			SchoolRegis_Attr logAtt = new SchoolRegis_Attr(driver);
			WebElement school = logAtt.getschool();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", school);
			String school_reg = logAtt.getSchoolRegistration().getText();
			Assert.assertEquals(school_reg.contains("School Registration"),true);
			
			logAtt.getfullname().sendKeys("vikram");
			logAtt.getschoolmail().sendKeys("vikram@convivmail.club");
			logAtt.getSchoolphnum().sendKeys("8193016324");
			logAtt.getPwd().sendKeys("Vikram@con");
			logAtt.getSchoolcnfmphnm().sendKeys("Vikram@con");
			String cnfmPwd = logAtt.getCnfmPwdMatch().getText();
			Assert.assertTrue(cnfmPwd.contains("Passwords matched"));
		}
		@AfterTest
		public void closedriver()
		{
			driver.close();
			driver = null;
		}
		
}
