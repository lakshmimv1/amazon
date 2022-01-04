package com.amazon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	WebDriver ldriver;
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//span[@class=\"nav-sprite nav-logo-base\"]")
	@CacheLookup
	WebElement image;
	
	@FindBy(xpath="//span[text()=\".in\"]")
	@CacheLookup
	WebElement in;
	
	@FindBy(xpath="//span[text()='Hello, Sign in']")
	@CacheLookup
	WebElement signin;
	
	//@FindBy(How="name" using='email')
	@FindBy(xpath="//input[@name='email']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath="//input[@type='password']")
	@CacheLookup
	WebElement pw;
	
	@FindBy(xpath="//input[@id='continue']")
	@CacheLookup
	WebElement btncontinue;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	@CacheLookup
	WebElement btnsign;
	
	@FindBy(xpath="//span[@class='nav-cart-icon nav-sprite']")
	@CacheLookup
	WebElement btnCart;
	
	@FindBy(xpath="//h2[contains(text(),'Amazon Basket is empty')]")
	@CacheLookup
	WebElement cartText;
	
	@FindBy(xpath="//a[text()='Start here.']/parent::div[@id='nav-flyout-ya-newCust']")
	@CacheLookup
	WebElement clkHerelink;
	
	public void setEmail(String lemail)
	{
		email.sendKeys(lemail);
	}
	
	public void setPassword(String lpw)
	{
		pw.sendKeys(lpw);
	}
	
	public void clickContinue()
	{
		btncontinue.click();
	}
	
	public void signSubmit()
	{
		btnsign.click();
	}
	
	public boolean checkSign()
	{
		String text=signin.getText();
		if(text.equals("Hello, Sign in"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void SignInClick()
	{
		signin.click();
	}
	
	public boolean clickCart()
	{
		btnCart.click();
		
		String text=cartText.getText();
		System.out.println("text... "+text);
		if(text.equals("Your Amazon Basket is empty"))
		{
			return true;
			
		}
		else
		{
			return false;
		}
	}
	
	public void signUp() throws InterruptedException
	{
		Actions act=new Actions(ldriver);
		act.moveToElement(signin).build().perform();
		Thread.sleep(2000);
		WebElement el3=ldriver.findElement(By.xpath("//a[text()='Start here.']"));
		System.out.println("disp1   "+el3.isDisplayed());
		System.out.println("attri   "+el3.getAttribute("text"));
		el3.click();
//		System.out.println("disp1   "+clkHerelink.isDisplayed());
//		clkHerelink.click();
		System.out.println("attri   "+el3.getAttribute("text"));
//		WebElement el=ldriver.findElement(By.xpath("//div[@class='nav-signin-tooltip-footer']"));
//		boolean st=el.isDisplayed();
//		System.out.println("st   "+st);
		Thread.sleep(2000);
//		WebElement el2=ldriver.findElement(By.xpath("//span[text()='Sign in']"));
//		System.out.println("disp   "+el2.isDisplayed());
//		el2.click();
		
		//el.click();
		System.out.println("clicked   ");
		Thread.sleep(2000);
	}
}
