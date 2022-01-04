package com.amazon.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

import com.amazon.pageObjects.HomePage;

public class TC_HomePageTest_01 extends BaseClass
{

	int a=10;
//	@Test
//	public void HomePageTest()
//	{
//		HomePage hp=new HomePage(driver);
//		if(driver.getTitle().contains("Online Shopping site in India:"));
//		{
//			assert.assertrue(true);
//		}
//		else
//		{
//			assert.assertrue(false);
//		}
//	}
	
	@Test
	public void checkSignInTest()
	{
		HomePage hp=new HomePage(driver);
		
		boolean status=hp.checkSign();
//		SoftAssert soft=new SoftAssert();
//		soft.assertEquals(status,true);
		Assert.assertEquals(status, true);
	}
	
	@Test
	public void clickSignIn()
	{
		HomePage hp=new HomePage(driver);
		hp.SignInClick();
		System.out.println("Title....."+driver.getTitle());
		if(driver.getTitle().equals("Amazon Sign In"))
		{
			System.out.println("inside if....");
			//SoftAssert soft=new SoftAssert();
			//soft.assertTrue(true);
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("inside else...");
//			SoftAssert soft=new SoftAssert();
//			soft.assertTrue(false);
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void loginTest()
	{
		HomePage hp=new HomePage(driver);
		
		hp.SignInClick();
		
		hp.setEmail(email);
		hp.clickContinue();
		hp.setPassword(password);
		hp.signSubmit();
		
		String expected="Amazon Sign In";
		System.out.println("Sign Title:"+driver.getTitle());
		if(driver.getTitle().equals(expected))
		{
			System.out.println("Inside sign");
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void TC_Cart()
	{
		HomePage hp=new HomePage(driver);
		boolean status = hp.clickCart();
		System.out.println("status   "+status);
		Assert.assertTrue(status);
	}
	
	@Test
	public void TC_SignUp() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.signUp();
	}
}
