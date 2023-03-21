package com.AutoTask.Pojo;

import java.util.Properties;

public class Plan {
	 //variables 
    public Properties properties;
    private String planName;
    private String planCost;
    private String currency;
    private String country;
    private String classicCostAndCurrency;
    private String liteCostAndCurrency;
    private String PremiumCostAndCurrency;
    
    public Plan(Properties properties) {
        this.properties = properties;
    }

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanCost() {
		return planCost;
	}

	public void setPlanCost(String planCost) {
		this.planCost = planCost;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getClassicCostAndCurrency() {
		return classicCostAndCurrency;
	}

	public void setClassicCostAndCurrency(String classicCostAndCurrency) {
		this.classicCostAndCurrency = classicCostAndCurrency;
	}

	public String getLiteCostAndCurrency() {
		return liteCostAndCurrency;
	}

	public void setLiteCostAndCurrency(String liteCostAndCurrency) {
		this.liteCostAndCurrency = liteCostAndCurrency;
	}

	public String getPremiumCostAndCurrency() {
		return PremiumCostAndCurrency;
	}

	public void setPremiumCostAndCurrency(String premiumCostAndCurrency) {
		PremiumCostAndCurrency = premiumCostAndCurrency;
	}
    
    
    

}
