package com.cr.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cr.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password1;
	
	@FindBy(xpath = "")
	WebElement loginBtn;
	
	@FindBy(xpath = "")
	WebElement signUpBtn;
	
	@FindBy(xpath = "")
	WebElement crmLogo;
	
	//Initializing the Page Objects:
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password1.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}

}
