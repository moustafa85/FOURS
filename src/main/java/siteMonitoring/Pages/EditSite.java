package siteMonitoring.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class EditSite extends BasePage{
	 AllMethods allMethods;
	public EditSite() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//a[contains(.,'Site Monitoring')]")
	WebElement sm;
	
	public void SM() {
		allMethods.VerifyElementDisplay(sm);
		sm.click();
	}
	
	@FindBy(xpath = "(//span[contains(@class,'ant-select-selection-item')])[1]")
	WebElement site;
	
	public void SelectSite(String Site) throws InterruptedException {
		allMethods.VerifyElementDisplay(site);
		site.click();
		Thread.sleep(1000);
		//site.sendKeys(Site);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='ant-select-tree-title'][contains(.,'"+Site+"')]")).click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[4]")
	WebElement edit;
	
	public void Edit() {
		allMethods.VerifyElementDisplay(edit);
		edit.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Edit Site')]")
	WebElement editSite;
	
	public void EditSite() {
		allMethods.VerifyElementDisplay(editSite);
		editSite.click();
	}
	
	@FindBy(xpath = "//input[@type='text'][contains(@id,'name')]")
	WebElement editName;
	
	public void EditName(String Name) {
		allMethods.VerifyElementDisplay(editName);
		editName.sendKeys(Keys.CONTROL + "a");
		editName.sendKeys(Keys.DELETE);
		editName.sendKeys(Name);
	}
	
	@FindBy(xpath = "//textarea[contains(@class,'ant-input')]")
	WebElement editSiteBoundary;
	
	public void editSiteBoundary(String Boundary) {
		allMethods.VerifyElementDisplay(editSiteBoundary);
		editSiteBoundary.sendKeys(Keys.CONTROL + "a");
		editSiteBoundary.sendKeys(Keys.DELETE);
		editSiteBoundary.sendKeys(Boundary);
	}
	
	@FindBy(xpath = "//span[contains(.,'Save Site')]")
	WebElement saveSite;
	
	public void SaveSite() {
		allMethods.VerifyElementDisplay(saveSite);
		saveSite.click();
	}

	
}
