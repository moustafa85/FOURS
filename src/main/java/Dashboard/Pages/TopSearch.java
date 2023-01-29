package Dashboard.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class TopSearch extends BasePage{
	AllMethods allMethods;
	public TopSearch() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "(//input[@autocomplete='off'])[1]")
	WebElement search;
	
	public void Search(String alertId) throws InterruptedException {
		allMethods.VerifyElementDisplay(search);
		search.sendKeys(alertId);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+alertId+"')]")).click();
	}

}
