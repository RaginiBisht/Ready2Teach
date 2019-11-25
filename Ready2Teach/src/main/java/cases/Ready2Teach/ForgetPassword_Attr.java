package cases.Ready2Teach;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPassword_Attr {

	public WebDriver driver;

	public ForgetPassword_Attr(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By forgetpwd = By.xpath("//a[@id='to-recover']");
	By recovermail = By.xpath("//form[@id='recoverform1']//input[@placeholder='Email']");
	By resetbtn = By.xpath("//form[@id='recoverform1']//button");
	By alert = By.xpath("//div[@class='alert alert-success']");
	By schoolbtn = By.xpath("//button[@class='btn btn-block btn-lg btn-success btn-rounded']");
	By schoolregis = By.xpath("//h3[@class='text-center']");
	By Subsbtn = By.xpath("//button[@class='btn btn-block btn-lg btn-primary btn-rounded']");
	By Substeach = By.xpath("//h3[contains(text(),'Teacher Registration')]");
	By SignInfgt = By.xpath("//b[contains(text(),'Sign In')]");
	By EmailErr = By.xpath("//li[@class='parsley-type']");
	By forgetpwd_SignIn = By.xpath("//a[@id='sign_in']");
	
	public WebElement getForgetpwd()
	{
		return driver.findElement(forgetpwd);
	}
	
	public WebElement getRecoveremail()
	{
		return driver.findElement(recovermail);
	}
	
	public WebElement getReset()
	{
		return driver.findElement(resetbtn);
	}
	
	public WebElement getcheckforget()
	{
		return driver.findElement(alert);
	}
	
	public WebElement getschool()
	{
		return driver.findElement(schoolbtn);
	}		
	
	public WebElement getSchoolRegistration()
	{
		return driver.findElement(schoolregis);
	}
	
	public WebElement getSubsRegistration()
	{
		return driver.findElement(Subsbtn);
	}	
	
	public WebElement getsubsTeachreg()
	{
		return driver.findElement(Substeach);
	}
	
	public WebElement getSigninForgetpwd()
	{
		return driver.findElement(SignInfgt);
	}
	
	public WebElement getEmailErr()
	{
		return driver.findElement(EmailErr);
	}
	
	public WebElement getFogetpasswordSignIn()
	{
		return driver.findElement(forgetpwd_SignIn);
	}
}
