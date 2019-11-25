package cases.Ready2Teach;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_Attr {
	
	public WebDriver driver;

	public LoginPage_Attr(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By email = By.id("email");
	By pwd = By.id("password");
	By loginbutton = By.xpath("//button[@class='btn btn-block btn-lg btn-info btn-rounded']");
	By profile = By.xpath("//a[@role='button']");
	By logout = By.xpath("//a[@class='dropdown-item']");
	By Sign_in = By.xpath("//h3[@class='text-center m-b-20']");
	
	By school = By.xpath("//h1[@class='text-themecolor']");
	
	By rembrme = By.id("customCheck1");
	
	
	
	
	By alertbox = By.xpath("//div[@class='alert alert-success']");
	By school_admin = By.xpath("//button[@class='btn btn-block btn-lg btn-success btn-rounded']");
	By school_register = By.xpath("//h3[@class='text-center']");
	By subs_register = By.xpath("//button[@class='btn btn-block btn-lg btn-primary btn-rounded']");
	By subs_reg = By.xpath("//h3[contains(text(),'Teacher Registration')]");
	By sign_in_link = By.xpath("//b[contains(text(),'Sign In')]");
	By schoolbtn = By.xpath("//button[@class='btn btn-block btn-lg btn-success btn-rounded']");
	
	By schoolregis = By.xpath("//h3[@class='text-center']");
	By Subsbtn = By.xpath("//button[@class='btn btn-block btn-lg btn-primary btn-rounded']");
	By Substeach = By.xpath("//h3[contains(text(),'Teacher Registration')]");
	By SignInfgt = By.xpath("//b[contains(text(),'Sign In')]");
	
	By Admin = By.className("btn btn-block btn-lg btn-success btn-rounded");
	By schoolSignup = By.xpath("//button[@class='btn btn-info btn-lg btn-block btn-rounded text-uppercase waves-effect waves-light']");
	By fullname = By.name("contact");
	By fullnamealert =By.xpath("//ul[@id='parsley-id-5']");
	By schoolemail = By.id("school_email");
	By schoolemailalert = By.xpath("//ul[@id='parsley-id-7']");
	By phonenumbalert = By.xpath("//ul[@id='parsley-id-9']");
	By schoolpwdalert = By.xpath("//ul[@id='parsley-id-11']");
	By schoolcnfrmpwdalert = By.xpath("//ul[@id='parsley-id-13']");
	By schoolnamealert = By.xpath("//ul[@id='parsley-id-15']");
	By schooladdressalert = By.xpath("//ul[@id='parsley-id-17']");
	By schoolcountyalert = By.xpath("//ul[@id='parsley-id-19']");
	
	By schoolphnum = By.id("SchoolPhoneNum");
	By schoolcnfmph = By.id("password_confirm");
	By schoolname = By.id("school_list");
	By schoolAddr = By.xpath("//input[@id='school_address']");
	By schoolCounty = By.id("select2-school_zip-container");
	By selectSchoolCounty = By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']");
	By CountyName = By.xpath("//input[@class='select2-search__field']");
	By SchoolSignUp = By.xpath("//button[@class='btn btn-info btn-lg btn-block btn-rounded text-uppercase waves-effect waves-light']");
	By SchoolSignUpcnfm = By.xpath("//div[@class='alert alert-success']//em");
	
	
	By EmailErr = By.xpath("//li[contains(text(),'Please enter a valid email address')]");
	By PwdErr = By.xpath("//li[contains(text(),'Please enter a password')]");
	By EmailErr2 = By.xpath("//li[@class='parsley-type']");
	By loginErr = By.xpath("//div[@class='alert alert-danger']");
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPwd()
	{
		return driver.findElement(pwd);
	}
	
	public WebElement getLoginbtn()
	{
		return driver.findElement(loginbutton);
	}
	
	public WebElement getprofile()
	{
		return driver.findElement(profile);
	}
	
	public WebElement getLogout()
	{
		return driver.findElement(logout);
	}
	
	public WebElement getRembrMe()
	{
		return driver.findElement(rembrme);
	}

	public WebElement getlogincnfm()
	{
		return driver.findElement(school);
	}
	
	public WebElement getlogoutcnfm()
	{
		return driver.findElement(Sign_in);
	}
	
	public WebElement getschool()
	{
		return driver.findElement(schoolbtn);
	}		
	
	public WebElement getAdminReg()
	{
		return driver.findElement(Admin);
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
	
	public WebElement getfullname()
	{
		return driver.findElement(fullname);
	}
	
	public WebElement getschoolmail()
	{
		return driver.findElement(schoolemail);
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
	
	public WebElement getEmailErr()
	{
		return driver.findElement(EmailErr);
	}
	
	public WebElement getPwdErr()
	{
		return driver.findElement(PwdErr);
	}
	
	public WebElement getEmailErr2()
	{
		return driver.findElement(EmailErr2);
	}
	
	public WebElement getLoginErr()
	{
		return driver.findElement(loginErr);
	}
}
