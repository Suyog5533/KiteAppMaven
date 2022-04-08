package kiteAppPomClass2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage {
//create variable 
	          @FindBy(id = "userid") private WebElement UserId ;
	          @FindBy(id = "password") private WebElement Password ;
	          @FindBy(xpath = "//button[@type='submit']") private WebElement LoginButton;
	          
//create constructor
	          
	          public KiteLoginPage(WebDriver driver)
	          {
	        	  PageFactory.initElements(driver,this);
	          }
//create methods
	          
	          public void enterUserId(String uid)
	          {
	        	UserId.sendKeys(uid);  
	          }
	     
	          public void enterPassword(String pass)	
	          {
	        	  Password.sendKeys(pass);
	          }
	          public void clickLoginButton()
	          {
	        	  LoginButton.click();
	          }
}
