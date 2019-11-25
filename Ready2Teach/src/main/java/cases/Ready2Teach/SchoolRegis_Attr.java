package cases.Ready2Teach;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SchoolRegis_Attr {

	public WebDriver driver;

	public SchoolRegis_Attr(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By schoolbtn = By.xpath("//button[@class='btn btn-block btn-lg btn-success btn-rounded']");
	By schoolSignup = By.xpath("//button[@class='btn btn-info btn-lg btn-block btn-rounded text-uppercase waves-effect waves-light']");
	By fullnamealert =By.xpath("//ul[@id='parsley-id-5']");
	By schoolemail = By.id("school_email");
	By schoolemailalert = By.xpath("//ul[@id='parsley-id-7']");
	By phonenumbalert = By.xpath("//ul[@id='parsley-id-9']");
	By schoolpwdalert = By.xpath("//ul[@id='parsley-id-11']");
	By schoolcnfrmpwdalert = By.xpath("//ul[@id='parsley-id-13']");
	By schoolnamealert = By.xpath("//ul[@id='parsley-id-15']");
	By schooladdressalert = By.xpath("//ul[@id='parsley-id-17']");
	By schoolcountyalert = By.xpath("//ul[@id='parsley-id-19']");
	By sign_in_link = By.xpath("//b[contains(text(),'Sign In')]");
	
	By fullname = By.name("contact_name");
	By schoolphnum = By.id("SchoolPhoneNum");
	By schoolcnfmph = By.id("password_confirm");
	By schoolname = By.id("school_list");
	By schoolAddr = By.xpath("//input[@id='school_address']");
	By schoolCounty = By.id("select2-school_zip-container");
	By selectSchoolCounty = By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']");
	By CountyName = By.xpath("//input[@class='select2-search__field']");
	By SchoolSignUp = By.xpath("//button[@class='btn btn-info btn-lg btn-block btn-rounded text-uppercase waves-effect waves-light']");
	By SchoolSignUpcnfm = By.xpath("//div[@class='alert alert-success']//em");
	By schoolregis = By.xpath("//h3[@class='text-center']");
	By pwd = By.id("password");
	
	By emailErr = By.xpath("//li[@class='parsley-type']");
	By pwdlengthErr = By.xpath("//li[@class='parsley-pattern']");
	By cnfmPwdMissMatch = By.xpath("//li[@class='parsley-equalto']");
	By cnfmPwdMatch = By.xpath("//li[@class='parsley-required pasley-success-msg']");
	
	public WebElement getschool()
	{
		return driver.findElement(schoolbtn);
	}		
	
	public WebElement getnewschool()
	{
		return driver.findElement(schoolSignup);
	}
	
	public WebElement getfullnamealert()
	{
		return driver.findElement(fullnamealert);
	}
	
	public WebElement getemailalert()
	{
		return driver.findElement(schoolemailalert);
	}
	
	public WebElement getphoneerr()
	{
		return driver.findElement(phonenumbalert);
	}
	
	public WebElement getphonepwderr()
	{
		return driver.findElement(schoolpwdalert);
	}
	
	public WebElement getphonecnfmpwderr()
	{
		return driver.findElement(schoolcnfrmpwdalert);
	}
	
	public WebElement getschoolnameerr()
	{
		return driver.findElement(schoolnamealert);
	}
	
	public WebElement getschoolAddrerr()
	{
		return driver.findElement(schooladdressalert);
	}
	
	public WebElement getschoolcountyerr()
	{
		return driver.findElement(schoolcountyalert);
	}
	
	public WebElement getSigininLink()
	{
		return driver.findElement(sign_in_link);
	}
	
	public WebElement getfullname()
	{
		return driver.findElement(fullname);
	}
	
	public WebElement getschoolmail()
	{
		return driver.findElement(schoolemail);
	}
	
	public WebElement getSchoolphnum()
	{
		return driver.findElement(schoolphnum);
	}
	
	public WebElement getSchoolcnfmphnm()
	{
		return driver.findElement(schoolcnfmph);
	}
	
	public WebElement getSchoolName()
	{
		return driver.findElement(schoolname);
	}
	
	public WebElement getSchoolAddr()
	{
		return driver.findElement(schoolAddr);
	}
	
	public WebElement getSchoolcounty()
	{
		return driver.findElement(schoolCounty);			
	}
	
	public List<WebElement> getSchoolCountyName()
	{
		return driver.findElements(selectSchoolCounty);
	}
	
	public WebElement getCountyName()
	{
		return driver.findElement(CountyName);
	}
	
	public WebElement getSignUP()
	{
		return driver.findElement(SchoolSignUp);
	}
	
	public WebElement getcnfrm()
	{
		return driver.findElement(SchoolSignUpcnfm);
	}
	
	public WebElement getSchoolRegistration()
	{
		return driver.findElement(schoolregis);
	}
	
	public WebElement getPwd()
	{
		return driver.findElement(pwd);
	}
	
	public WebElement getEmailValidErr()
	{
		return driver.findElement(emailErr);
	}
	
	public WebElement getpwdLengthErr()
	{
		return driver.findElement(pwdlengthErr);
	}
	
	public WebElement getCnfrmPwdMissMatch()
	{
		return driver.findElement(cnfmPwdMissMatch);
	}
	
	public WebElement getCnfmPwdMatch()
	{
		return driver.findElement(cnfmPwdMatch);
	}
}
