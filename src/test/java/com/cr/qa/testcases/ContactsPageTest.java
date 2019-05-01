package com.cr.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cr.qa.base.TestBase;
import com.cr.qa.pages.ContactsPage;
import com.cr.qa.pages.HomePage;
import com.cr.qa.pages.LoginPage;
import com.cr.qa.util.TestUtil;

import junit.framework.Assert;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	public ContactsPageTest(){
		super();
	}
	
	//test cases should be seperated - independent with each other
	//before each test case - launch the browser and login
	//@test - execute test case
	//after each test case - close the browser

	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue("contacts label is missing on the page",contactsPage.verifyContactsLabel());
		
	}
	
	@Test(priority=2)
	public void selectContactsTest(){
		contactsPage.selectContactsByName("Mahesh");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("Mahesh");
		contactsPage.selectContactsByName("mahi");
	}
	
	@DataProvider
	public Object[][] getCRTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=4, dataProvider="getCRTestData")
	public void validateCreateNewContact(String firstName, String lastName, String company){
		homePage.clickOnContactsLink();
		//contactsPage.createNewContact("tom", "john", "calib");
		contactsPage.createNewContact(firstName, lastName, company);
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
