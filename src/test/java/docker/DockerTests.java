package docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DockerTests {
	
	WebDriver driver;
	String appUrl = "https://www.google.com";
	
	@Parameters({ "browser" })
	@BeforeMethod
	public void beforeMethod(String browser) throws MalformedURLException
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
				// TODO Auto-generated catch block
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
		
		driver.get(appUrl);
	
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.close();
	}
	
	
	@Test
	public void dockertest1() {
	System.out.println("Inside First Test");
	System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());


	}
	
	@Test
	public void dockertest2() {
		System.out.println("Inside second Test");
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());


		}
	
	@Test
	public void dockertest3() {
		System.out.println("Inside third Test");
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());

       }
	
	}
