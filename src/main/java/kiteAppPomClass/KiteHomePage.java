package kiteAppPomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage {
             
	        @FindBy(xpath = "//span[@class='user-id']") private WebElement userId;
	        @FindBy(xpath="//a[@target='_self']") private WebElement logOut;
	        @FindBy(xpath="//span[@class='su-message']") private WebElement passwordMessage;
	        
	        public KiteHomePage(WebDriver driver)
	        {
	        	PageFactory.initElements(driver,this);
	        	
	        }
	        
	        public String getActualUserID() 
	        {
	        	
	        	String ActualUserId = userId.getText();
	        	return ActualUserId;
	
	        }
	        
	        public String getActualPasswordMeassge()
	        {
	        	String ActualPasswordMessage = passwordMessage.getText();
	        	return ActualPasswordMessage;
	        }
	        public void logOut() 
	        {
	        	userId.click(); 

	        	
	        	logOut.click();
	        }
}
