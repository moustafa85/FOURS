package fallAlert.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class ManagePage extends BasePage{
	AllMethods allMethods;

	public ManagePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//a[@href='/fallPrevention']")
	WebElement fAlert;
	
	public void FAlert() {
		allMethods.VerifyElementDisplay(fAlert);
		fAlert.click();
	}
	
	@FindBy(xpath = "//div[@role='tab'][contains(.,'Manage')]")
	WebElement manage;
	
	public void Manage() {
		allMethods.VerifyElementDisplay(manage);
		manage.click();
	}
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'][contains(.,'Both')])[1]")
	WebElement FallPrev;
	
	public void Enabled()
	{
		allMethods.VerifyElementDisplay(FallPrev);
		FallPrev.click();
		driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'][contains(.,'Enabled')])[1]")).click();
	}
	
	public void Disabled()
	{
		allMethods.VerifyElementDisplay(FallPrev);
		FallPrev.click();
		driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'][contains(.,'Disabled')])[1]")).click();
	}
	
	public void FallPrev(String st) throws InterruptedException {
		allMethods.VerifyElementDisplay(FallPrev);
		FallPrev.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+st+"')]")).click();
	}
	
	//@FindBy(xpath = "//span[@class='ant-select-selection-item'][2]")
	@FindBy(xpath = "(//span[contains(@class,'ant-select-selection-item')])[2]")
	WebElement freeFall;
	
	public void FreeFall(String st) throws InterruptedException {
		allMethods.VerifyElementDisplay(freeFall);
		freeFall.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'][contains(.,'"+st+"')])[2]")).click();
	}
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search...')]")
	WebElement search;
	
	public void search(String eid) {
		allMethods.VerifyElementDisplay(search);
		search.sendKeys(eid);
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[4]")
	WebElement fallPrevButton;
	
	public void FallPrevButton() {
		allMethods.VerifyElementDisplay(fallPrevButton);
		fallPrevButton.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[5]")
	WebElement freeFallButton;
	
	public void freeFallButton() {
		allMethods.VerifyElementDisplay(freeFallButton);
		freeFallButton.click();
	}
	
	//@FindBy(xpath = "//button[contains(@class,'ant-switch ant-popover-open')]")
	@FindBy(xpath = "(//button[contains(@type,'button')])[4]")
	WebElement fallPrevToggle;
	
	public void FallPrevToggle() {
		allMethods.VerifyElementDisplay(fallPrevToggle);
		fallPrevToggle.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[5]")
	WebElement freeFallToggle;
	
	public void FreeFallToggle() {
		allMethods.VerifyElementDisplay(freeFallToggle);
		freeFallToggle.click();
	}

}
