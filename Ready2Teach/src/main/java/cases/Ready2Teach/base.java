package cases.Ready2Teach;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class base {

	public static WebDriver driver; 
	public Properties prop;
	public WebDriver InitializeDriver() throws IOException {
		// TODO Auto-generated method stub
		
		prop = new Properties();
		FileInputStream fil = new FileInputStream("/home/webric103/eclipse_workspace/Ready2Teach/src/main/java/cases/Ready2Teach/data.properties");
		
		prop.load(fil);
		String browser = prop.getProperty("browser");
		
		if (browser.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "//home//webric103//drivers//chromedriver");
			driver = new ChromeDriver();
		}
		
		else if(browser.contains("firefox"))
		{
			System.setProperty("webdriver.geckodriver.driver", "//home//webric103//drivers//geckodriver");
			driver = new FirefoxDriver();
		}
		
		else if(browser.contains("opera"))
		{
			System.setProperty("webdriver.opera.driver", "/home/webric103/drivers/operadriver_linux64/operadriver");
			driver = new OperaDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}

	/*public void getScreenshot()
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/home/webric103/screenshot.png"));
	}*/
}
