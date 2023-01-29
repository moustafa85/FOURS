package Dashboard.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class Pagination extends BasePage{
	AllMethods allMethods;

	public Pagination() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}

	@FindBy(xpath = "//span[contains(@title,'15 / page')]")
	WebElement pageType;
	
	public void PageType(String page) throws InterruptedException {
		allMethods.VerifyElementDisplay(pageType);
		pageType.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+page+" / page')]")).click();
	}
	
	@FindBy(xpath = "(//a[contains(@rel,'nofollow')])[6]")
	WebElement lastPage;
	
	public int LastPage() {
		allMethods.VerifyElementDisplay(lastPage);
		String PageNo = lastPage.getText();
		int lastPageNo = Integer.parseInt(PageNo);
		System.out.println("Last page no -- "+lastPageNo);
		return lastPageNo;
	}
	
	public void PageClick(int page) throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@rel='nofollow'][contains(.,'"+page+"')]")).click();
	
	}

	
}
