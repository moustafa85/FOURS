package caughtInDetection.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class Search extends BasePage{
	AllMethods allMethods;

	public Search() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//a[@href='/caughtInDetection']")
	WebElement caughtIn;
	
	public Boolean CaughtIn() {
		if(!allMethods.VerifyElementDisplay(caughtIn))
			return false;
		caughtIn.click();
		return true;
	}
	
	@FindBy(xpath = "//div[@role='tab'][contains(.,'Manage')]")
	WebElement manage;
	
	public Boolean Manage() {
		if(!allMethods.VerifyElementDisplay(manage))
			return false;
		manage.click();
		return true;
	}
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search...')]")
	WebElement search;
	
	public Boolean Search(String searchele) {
		if(!allMethods.VerifyElementDisplay(search))
			return false;
		search.sendKeys(searchele);
		return true;
	}
	public Boolean ValidateSearchedDisplayed(String searchable){
		try {
			if (allMethods.VerifyElementDisplay(driver.findElements(By.xpath("//td[contains(.,'" + searchable + "')]")).get(0))){
				return true;
			}
			return false;
		}catch (Exception e){
			return false;
		}

	}
	
	@FindBy(xpath = "//span[@class='ant-select-selection-item'][contains(.,'Active')]")
	WebElement status;
	
	public Boolean StatusBoth() throws InterruptedException {
		if(!allMethods.VerifyElementDisplay(status))
			return false;
		status.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'Both')]")).click();
		return true;
	}
	
	public void ActiveStatus() throws InterruptedException {
		allMethods.VerifyElementDisplay(status);
		status.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'Active')]")).click();
	}
	
	public void InactiveStatus() throws InterruptedException {
		allMethods.VerifyElementDisplay(status);
		status.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'Inactive')]")).click();
	}
	
	@FindBy(xpath = "//button[contains(@aria-checked,'true')]")
	WebElement inactivate;
	
	public void Inactivate() {
		allMethods.VerifyElementDisplay(inactivate);
		inactivate.click();
	}
	
	@FindBy(xpath = "//button[contains(@aria-checked,'false')]")
	WebElement activate;
	
	public void Activate() {
		allMethods.VerifyElementDisplay(activate);
		activate.click();
	}

}
