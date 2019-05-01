package com.cr.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cr.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactsPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("xpath of the select box")).click();
	}
	
	public void createNewContact(String ftName, String ltName, String comp){
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
}
