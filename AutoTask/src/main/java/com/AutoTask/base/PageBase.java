package com.AutoTask.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


import org.openqa.selenium.support.FindBy;

public class PageBase {

	@FindBy(id="ticker")
	WebElement loadingTicker;
	
	
	
	
	
	
	
	//methods
	public void waitUntilElementDisplayed(WebDriver driver, WebElement elementname) {
	      WebDriverWait w = new WebDriverWait(driver,30);
	      w.until(ExpectedConditions.elementToBeClickable(elementname));
	}
	
	public void waitUntilElementInvisibale(WebDriver driver, WebElement elementname) {
	      WebDriverWait w = new WebDriverWait(driver,30);
	      w.until(ExpectedConditions.invisibilityOf(elementname));
	}
	
	public void waitUntilPageLoading(WebDriver driver) {
		if(loadingTicker.isDisplayed()) {
			new WebDriverWait(driver,30).until(ExpectedConditions.invisibilityOf(loadingTicker));
		}
	}
	
	public boolean isMsgExistandDisplayed(WebDriver driver, WebElement MsgID, String ValidatedMsgTitle) {
		boolean flag = false;
		boolean isMsgDisplayed = MsgID.isDisplayed();

		if (isMsgDisplayed) {
			String ScreenMsg = "";
			ScreenMsg = MsgID.getText();

			if (ScreenMsg.contains(ValidatedMsgTitle)) {
				Reporter.log("Message: [" + ValidatedMsgTitle
						+ "] is Displayed Successfully as it is part of the screen Msg [" + ScreenMsg + "]");
				flag = true;
			} else {
				Reporter.log("Message: [" + ValidatedMsgTitle + "] is failed to be Validated with the screen Msg ["
						+ ScreenMsg + "]");
				flag = false;
			}
		} else {
			Reporter.log("Msg [" + ValidatedMsgTitle + "] Doesn't be displayed ");
			flag = false;
		}
		return flag;
	}
	
}
