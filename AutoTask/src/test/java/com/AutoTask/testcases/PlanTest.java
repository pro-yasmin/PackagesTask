package com.AutoTask.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.AutoTask.Pojo.Plan;
import com.AutoTask.base.TestBase;
import com.AutoTask.pages.PlanPage;
import com.AutoTask.testdata.TestData;

import allurerReports.AllureListener;
import io.qameta.allure.Description;


@Listeners({AllureListener.class})
public class PlanTest extends TestBase{
	
	 public PlanTest(){
			super();
			// TODO Auto-generated constructor stub
		      }

	 PlanPage planPageObj;
	 
	 @BeforeTest
	    public void beforeTest() {
	    	 
	    }
	    
	    @AfterTest
	    public void afterTest() {
	    	
	    }
	    
		@BeforeMethod
	
		public void beforeMethod() {
			setup("chrome");
			planPageObj= new PlanPage(driver,prop);
		}
		
		@AfterMethod
		public void afterMethod() {
		   tearDown() ;
		}
		
		@DataProvider(name = "testPopularPlan")
		public  Object[][] testPopularPlan() throws IOException, InvalidFormatException{
			Object[][] data= TestData.getExcelData("popularPlanData");
			return data;
		}
		
		@DataProvider(name = "testPlanCostAndCurrency")
		public  Object[][] testDataEx() throws IOException, InvalidFormatException{
			Object[][] data= TestData.getExcelData("PlansCostAndCurrencyData");
			return data;
		}
		
		
		@Test(dataProvider="testPopularPlan")
		@Description("Validate popular plan details")
		public void checkPopularPlanDetails(String countryName, String currency, String cost) {
			Reporter.log("Start test plan currency with countries");
			
			Plan planObj = new Plan(prop);
			planObj.setCountry(countryName);
			planObj.setPlanName(prop.getProperty("planClassic"));
			planObj.setCurrency(currency);
			planObj.setPlanCost(cost);
			
			Assert.assertTrue(planPageObj.checkPopularPlanDetails(planObj));
	   
			Reporter.log("End test plan currency with countries");
		}
		
		@Test(dataProvider="testPlanCostAndCurrency")
		@Description("Validate plans cost and currency")
		public void checkPlanCostAndCurrency(String countryName, String classicPlan, String litePlan, String premiumPlan) {
			Reporter.log("Start test plan currency with countries");
			
			Plan planObj = new Plan(prop);
			planObj.setCountry(countryName);
			planObj.setClassicCostAndCurrency(classicPlan);
			planObj.setLiteCostAndCurrency(litePlan);
			planObj.setPremiumCostAndCurrency(premiumPlan);
			
			Assert.assertTrue(planPageObj.checkPlanCostAndCurrency(planObj));
	   
			Reporter.log("End test plan currency with countries");
		}
}
