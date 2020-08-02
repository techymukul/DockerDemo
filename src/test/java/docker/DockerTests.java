package docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DockerTests {
	
	WebDriver driver;
	String app1Url = "https://www.flipkart.com";
	String app2Url = "https://www.facebook.com";
	String app3Url = "https://www.amazon.in";
	
	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(String browser) throws MalformedURLException
	{
		System.out.println("Browser Name is:"+browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.setCapability(ChromeOptions.CAPABILITY, options);
			options.setCapability("browserName", "chrome");
			options.setCapability("acceptSslCerts", "true");
			options.setCapability("javascriptEnabled", "true");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			options.merge(cap);
			try {
				driver = new RemoteWebDriver (new URL("http://0.0.0.0:4444/wd/hub"), options);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (browser.equalsIgnoreCase("firefox")){
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--start-maximized");
			options.setCapability("browserName", "firefox");
			options.setCapability("acceptSslCerts", "true");
			options.setCapability("javascriptEnabled", "true");
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			options.merge(cap);
			driver = new RemoteWebDriver (new URL("http://localhost:4444/wd/hub"), options);
		}
		
		
	
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}
	
	
	@Test
	public void dockertest1() {
	System.out.println("Inside First Test, testing flipkart");
	driver.get(app1Url);

	}
	
	@Test
	public void dockertest2() {
		System.out.println("Inside second Test, testing facebook");
		driver.get(app2Url);

		}
	
	@Test
	public void dockertest3() {
		System.out.println("Inside third Test, testing amazon");
		driver.get(app3Url);

       }
	
	}
