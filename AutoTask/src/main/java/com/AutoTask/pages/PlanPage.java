package com.AutoTask.pages;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutoTask.Pojo.Plan;
import com.AutoTask.base.PageBase;

import io.qameta.allure.Step;

public class PlanPage extends PageBase{
	
	public WebDriver driver;
	public Properties properties;
	
	public PlanPage(WebDriver driver, Properties prop) {
        this.driver = driver;
		this.properties = prop;
		PageFactory.initElements(driver, this);
	}
	
    //Locators 
	@FindBy(id ="name-lite")
	WebElement litePlan;
	
	@FindBy(id="name-classic")
	WebElement classicPlan;
	
	@FindBy(id="name-premium")
	WebElement premiumPlan;
	
	@FindBy(xpath="//div[@class='trial-description']//h4")
	WebElement planName;
	
	@FindBy(xpath="//div[@class='trial-cost']//b")
	WebElement planCost;
	
	@FindBy(xpath="//div[@class='trial-cost' and not(@id)]")
	WebElement currency;
	
	@FindBy(id="country-btn")
	WebElement countryBtn;
	
	@FindBy(xpath="//div[@id='currency-lite']")
	WebElement liteCostAndCurrency;
	
	@FindBy(xpath="//div[@id='currency-classic']")
	WebElement classicCostAndCurrency;
	
	@FindBy(xpath="//div[@id='currency-premium']")
	WebElement premiumCostAndCurrency;
	
	
	//Methods
	
	@Step("select country")
	private void selectCountry(String countryName) {
		WebElement countryCard= driver.findElement(By.xpath("//span[contains(text(),"+"'"+countryName+"'"+") and contains(@id,'contry')]"));
		countryBtn.click();
		countryCard.click();
	}
	
	@Step("get currency")
	private boolean getCurrency(String actualCurrency) {
		String text= currency.getText();
		 String dateParts[] = (text).split("[/ ]", -1);
		 if (actualCurrency.equals(dateParts[2])) {
		 return true ;}
		 else {
		return false;}
	}
	
	@Step("check popular plan cost and currency")
	public boolean checkPopularPlanDetails(Plan planObj) {
		selectCountry(planObj.getCountry());
	
	    if (isMsgExistandDisplayed(driver, planName, planObj.getPlanName())&&
	    	isMsgExistandDisplayed(driver, planCost, planObj.getPlanCost())	&&
	    	getCurrency(planObj.getCurrency())) {
	    	
	    	return true;
	    }else {
	    	return false;
	    }
	    	}
	
	@Step("check plans cost and currency")
	public boolean checkPlanCostAndCurrency(Plan planObj) {
		selectCountry(planObj.getCountry());
		if(	isMsgExistandDisplayed(driver,classicCostAndCurrency, planObj.getClassicCostAndCurrency())&&
		   	isMsgExistandDisplayed(driver,liteCostAndCurrency, planObj.getLiteCostAndCurrency())&&
		    isMsgExistandDisplayed(driver,premiumCostAndCurrency, planObj.getPremiumCostAndCurrency())) {
			return true;
		}else {
		  return false;
		}
	}

		
	    
}
