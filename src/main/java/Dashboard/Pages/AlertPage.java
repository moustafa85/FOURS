package Dashboard.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class AlertPage extends BasePage{
	AllMethods allMethods;

	public AlertPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}

	@FindBy(linkText = "Dashboard")
	WebElement Dashboard;

	public Boolean dashboardLink() {
		if(allMethods.VerifyElementClickable(Dashboard)){
			Dashboard.click();

			return driver.getCurrentUrl().contains("dashboard");
		}
		return false;
	}
	
	public Boolean AlertClick(String alert) throws InterruptedException {
		try {
			if (allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//td[contains(.,'" + alert + "')]")))) {
				allMethods.scrollToSpecificLocation(driver.findElement(By.xpath("//td[contains(.,'" + alert + "')]")));
				driver.findElement(By.xpath("//td[contains(.,'" + alert + "')]")).click();
				return true;
			} else
				return false;
		}catch (Exception e){
			return false;
		}
	}

	@FindBy(xpath = "(//span[contains(@class,'ant-select-selection-item')])[2]")
	WebElement siteDropdown;

	public Boolean SelectSite(String site) throws InterruptedException {
		if (!allMethods.VerifyElementClickable(siteDropdown))
			return false;
		siteDropdown.click();
		Thread.sleep(1000);
		if (!allMethods.VerifyElementClickable(driver.findElement(By.xpath("(//span[contains(.,'"+site+"')])[2]"))))
			return false;
		driver.findElement(By.xpath("(//span[contains(.,'"+site+"')])[2]")).click();
		return true;
	}

}
