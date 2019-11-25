package cases.Ready2Teach;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubsTeacher_Reg_Attr {

	public WebDriver driver;
	
	public SubsTeacher_Reg_Attr(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By subs_Regis = By.xpath("//button[@class='btn btn-block btn-lg btn-primary btn-rounded']");
	By Subs_SignUp = By.xpath("//form[@id='teacher_register']//button[@class='btn btn-info btn-lg btn-block btn-rounded text-uppercase waves-effect waves-light'][contains(text(),'Sign Up')] ");
	By FullNameErr = By.xpath("//ul[@id='parsley-id-23']");
	By EmailErr = By.xpath("//li[contains(text(),'Please enter valid email address')]");
	By PhoneErr = By.xpath("//li[contains(text(),'Please enter valid mobile number')]");
	By passwordErr = By.xpath(" //li[contains(text(),'Please enter a password')]");
	By confirmPasswordErr = By.xpath("//li[contains(text(),'Please enter confirm password')]");
	By InstructortypeErr = By.xpath("//li[contains(text(),'Please select instructor type')]");
	By SubTypeErr = By.xpath("//li[contains(text(),'Please select instructor sub type')]");
	By CountyErr = By.xpath("//li[contains(text(),'Please select county')]");
	By SubsName = By.xpath("//form[@id='teacher_register']//input[@placeholder='Full Name']");
	By SubsEmail = By.xpath("//input[@id='email']");
	By SubsEmailFormatErr = By.xpath("//li[@class='parsley-type']");
	By SubsMobilenumb = By.xpath("//input[@id='TeacherPhoneNum']");
	By SubsPasswordErr = By.xpath("//input[@id='password_t']");
	By SubsPwdlengthErr = By.xpath("//li[@class='parsley-pattern']");
	By SubsPwdlengthErr2 = By.xpath(" //li[@class='parsley-length']");
	By SubsCnfmPassword = By.xpath("//input[@id='password_confirm_t']");
	By SubsCnfrmPwdErr = By.xpath("//li[@class='parsley-equalto']");
	By SubsInstructorTypeSelectAll = By.xpath("//a[@id='instructor_type_select_all']");
	By SubsVariousInstructorTypes = By.xpath("//li[@class='select2-selection__choice']");
	By SubsInstructorTypesRemoveAll = By.xpath("//a[@id='instructor_type_remove_all']");
	By SubsInstructorTypeRemoveAllCheck = By.xpath("//div[6]//div[1]//span[1]//span[1]//span[1]");
	By SubsSubTypeInstructorSelectAll = By.xpath("//a[@id='instructor_sub_type_select_all']");
	By SubsSubTypeInstructorSelectAllCheck = By.xpath("//div[7]//div[1]//span[1]//span[1]//span[1]//ul[1]");
	By SubsSubTypeInstructorRemoveAll = By.xpath("//a[@id='instructor_sub_type_remove_all']");
	By SubsSubTypeInstructorRemoveAllCheck = By.xpath("//div[7]//div[1]//span[1]//span[1]//span[1]//ul[1]");
	By SubsCounty = By.xpath("//span[@id='select2-teacher-zip-container']");
	By SubsCountyName = By.xpath("//li[@class='select2-results__option']");
	By SubscountyNameEnter = By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']");
	
	
	
	public WebElement getsubs_Reg()
	{
		return driver.findElement(subs_Regis);
	}
	
	public WebElement getSubs_SignUp()
	{
		return driver.findElement(Subs_SignUp);
	}
	
	public WebElement getFullNameErr()
	{
		return driver.findElement(FullNameErr);
	}
	
	public WebElement getEmailErr()
	{
		return driver.findElement(EmailErr);
	}
	
	public WebElement getPhoneErr()
	{
		return driver.findElement(PhoneErr);
	}
	
	public WebElement getPasswordErr()
	{
		return driver.findElement(passwordErr);
	}
	
	public WebElement getcnfrmPasswordErr()
	{
		return driver.findElement(confirmPasswordErr);
	}
	
	public WebElement getInstructorTypeErr()
	{
		return driver.findElement(InstructortypeErr);
	}
	
	public WebElement getSubTypeErr()
	{
		return driver.findElement(SubTypeErr);
	}
	
	public WebElement getCountyErr()
	{
		return driver.findElement(CountyErr);
	}
	
	public WebElement getSubsName()
	{
		return driver.findElement(SubsName);
	}
	
	public WebElement getSubsEmail()
	{
		return driver.findElement(SubsEmail);
	}
	
	public WebElement getSubsEmailFormatErr()
	{
		return driver.findElement(SubsEmailFormatErr);
	}
	
	public WebElement getSubsPassword()
	{
		return driver.findElement(SubsMobilenumb);
	}
	
	public WebElement getSubsPasswordlengthErr()
	{
		return driver.findElement(SubsPasswordErr);
	}
	
	public WebElement SubsPwdlengthErr()
	{
		return driver.findElement(SubsPwdlengthErr);
	}
	
	public WebElement SubsCnfmPassword()
	{
		return driver.findElement(SubsCnfmPassword);
	}
	
	public WebElement getSubsCnfmPasswordErr()
	{
		return driver.findElement(SubsCnfrmPwdErr);
	}
	
	public WebElement getSubsInstructorSelectAll()
	{
		return driver.findElement(SubsInstructorTypeSelectAll);
	}
	
	public List<WebElement> getSubsInstructionType()
	{
		return driver.findElements(SubsVariousInstructorTypes);
	}
	
	public WebElement SubsInstructorRemoveAll()
	{
		return driver.findElement(SubsInstructorTypesRemoveAll);
	}

	public WebElement getSubsRemoveAllCheck()
	{
		return driver.findElement(SubsInstructorTypeRemoveAllCheck);
	}
	
	public WebElement getSubsSubTypeSelectAll()
	{
		return driver.findElement(SubsSubTypeInstructorSelectAll);
	}
	
	public WebElement getSubsSubTypeSelectAllCheck()
	{
		return driver.findElement(SubsSubTypeInstructorSelectAllCheck);
	}
	
	public WebElement getSubsSubTypeRemoveAll()
	{
		return driver.findElement(SubsSubTypeInstructorRemoveAll);
	}
	
	public WebElement getSubsTypeRemoveAllCheck()
	{
		return driver.findElement(SubsSubTypeInstructorRemoveAllCheck);
	}
	
	public WebElement getSubsCounty()
	{
		return driver.findElement(SubsCounty);
	}
	
	public List<WebElement> getSubsCountyName()
	{
		return driver.findElements(SubsCountyName);
	}
	
	public WebElement getSubsCountyNameEnter()
	{
		return driver.findElement(SubscountyNameEnter);
	}
}
