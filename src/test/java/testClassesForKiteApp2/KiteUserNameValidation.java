package testClassesForKiteApp2;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import libraryfiles2.*;
import kiteAppPomClass2.KiteHomePage;
import kiteAppPomClass2.KiteLoginPage;
import kiteAppPomClass2.KitePinPage;


public class KiteUserNameValidation extends baseClass
{
	KiteLoginPage login;
	KitePinPage pin;
	KiteHomePage home;
	
 @BeforeClass 
 public void lunchingBrowser()
 {
	 Reporter.log("Chrome Browser Lunch Successfully");
	 lunchBrowser();
	 login= new KiteLoginPage(driver);
	 pin = new KitePinPage(driver);
	 home = new KiteHomePage(driver);
 }
 @BeforeMethod
	 public void loginToKiteApp1() throws  IOException 
	 {
		login.enterUserId(utility.getDataExcelSheet(0, 0));
		login.enterPassword(utility.getDataExcelSheet(0, 1));
		login.clickLoginButton();
		Reporter.log("Logging Kite Account");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		pin.enterPin(utility.getDataExcelSheet(0, 2));
		pin.enterContinueButton();
		Reporter.log("Logging Successfully");
		
	 }
  @Test
  public void verifyUserName() throws EncryptedDocumentException, IOException 
  {
	 
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		String actualUserId = home.getActualUserID();
		String expectedUserId = utility.getDataExcelSheet(0, 1);
		Assert.assertEquals(actualUserId, expectedUserId,"UserID is not matching,TC is failed");
		Reporter.log("Username verified successfully");
		Reporter.log("ScreenShot taken and stored local file");
		
  }
  @AfterMethod
  public void loggingOutFromKite()
  {
	  home.logOut();
	  Reporter.log("Logging off Kite Account");
	  Reporter.log("Logout Successfully");
  }
  @AfterClass
  public void closingBrowser()
  {
	  closeBrowser();
	  Reporter.log("BrowserClosed");
  }
}
