package libraryfiles;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class baseClass {
	protected WebDriver driver;
	public void lunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\suyog\\Desktop\\JDK SOFTWEAR LINK\\New folder\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notificattions");
		driver = new ChromeDriver(opt);
		driver.get("https://kite.zerodha.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		driver.manage().window().maximize();
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
}
