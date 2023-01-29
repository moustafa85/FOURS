package siteMonitoring.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class AddNewChildSite extends BasePage{
	AllMethods allMethods;

	public AddNewChildSite() throws IOException {
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
		driver.findElement(By.xpath("//span[@class='ant-select-tree-title'][contains(.,'"+Site+"')]")).click();
	}
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Add Child Site')]")
	WebElement addSite;
	
	public void AddSite() {
		allMethods.VerifyElementDisplay(addSite);
		addSite.click();
	}
	
	@FindBy(xpath = "//input[@type='text'][contains(@id,'name')]")
	WebElement name;
	
	public void Name(String Name) {
		allMethods.VerifyElementDisplay(name);
		name.sendKeys(Name);
	}
	
	@FindBy(xpath = "//textarea[contains(@class,'ant-input')]")
	WebElement siteBoundary;
	
	public void SiteBoundary(String Boundary) {
		allMethods.VerifyElementDisplay(siteBoundary);
		siteBoundary.sendKeys(Boundary);
	}
	
	@FindBy(xpath = "//div[@role='tab'][contains(.,'Site Plan')]")
	WebElement sitePlan;
	
	public void SitePlan() {
		allMethods.VerifyElementDisplay(sitePlan);
		sitePlan.click();
	}
	
	@FindBy(xpath = "//span[@class='anticon anticon-upload']")
	WebElement sitePlanUpload;
	
	/*public void SitePlanUpload(String SitePlan) {
		sitePlanUpload.sendKeys(SitePlan);
	}*/
	
	public void SitePlanUpload(String SitePlan) {
		allMethods.VerifyElementDisplay(sitePlanUpload);
		sitePlanUpload.sendKeys(SitePlan);
	}
	
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Save Site')]")
	WebElement saveSite;
	
	public void SaveSite() {
		allMethods.VerifyElementDisplay(saveSite);
		saveSite.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[2]")
	WebElement refresh;
	
	public void Refresh() {
		allMethods.VerifyElementDisplay(refresh);
		refresh.click();
	}

}
