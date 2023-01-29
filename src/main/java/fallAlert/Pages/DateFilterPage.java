package fallAlert.Pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class DateFilterPage extends BasePage{
	AllMethods allMethods;
	public DateFilterPage() throws IOException {
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
	
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Today')])[1]")
	WebElement dateRangeClick;
	
	public void dateRangeClick() {
		allMethods.VerifyElementDisplay(dateRangeClick);
		dateRangeClick.click();
	}
	
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Today')])[2]")
	WebElement today;
	
	public void today() {
		allMethods.VerifyElementDisplay(today);
		today.click();
	}
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'7 Days')]")
	WebElement day7;
	
	public void Day7() {
		allMethods.VerifyElementDisplay(day7);
		day7.click();
	}
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'30 Days')]")
	WebElement day30;
	
	public void Day30() {
		allMethods.VerifyElementDisplay(day30);
		day30.click();
	}
	
	@FindBy(xpath = "(//input[contains(@size,'12')])[1]")
	WebElement startDate;
	
	@FindBy(xpath = "//input[@placeholder='End date']")
	WebElement endDate;
	
	  
		/*String sdate = prop.getProperty("startDate");
		String edate = prop.getProperty("AlertMngFile");
		
		//String[] elementSplit = sdate.split("-");
		
		//String sdd = elementSplit[2];
		
		//String dd = sdd.replaceFirst("^0+(?!$)", "");
		
		String[] elementSplit2 = edate.split("-");
		
		String edd = elementSplit2[2];
		
		String dd = edd.replaceFirst("^0+(?!$)", "");
	
	public void selectDate() throws InterruptedException {
		
		driver.findElement(By.xpath("(//div[@class='ant-picker-cell-inner'][contains(.,'"+dd+"')])[1]")).click();
	}*/
	
	public void TimeRange(String sdate, String dd) throws InterruptedException {
		allMethods.VerifyElementDisplay(dateRangeClick);
		dateRangeClick.click();
		allMethods.VerifyElementDisplay(startDate);
		startDate.click();
		startDate.sendKeys(Keys.CONTROL + "a");
		startDate.sendKeys(Keys.DELETE);
		startDate.sendKeys(sdate);
		allMethods.VerifyElementDisplay(endDate);
		endDate.click();
		endDate.sendKeys(Keys.CONTROL + "a");
		endDate.sendKeys(Keys.DELETE);
		endDate.sendKeys(dd);
		Thread.sleep(1000);
		endDate.sendKeys(Keys.ENTER);
		//selectDate();
		//driver.findElement(By.xpath("//td[@class='ant-picker-cell ant-picker-cell-in-view']//div[@class='ant-picker-cell-inner'][contains(.,'"+dd+"')])")).click();
//		driver.findElement(By.xpath("//td[@class='ant-picker-cell ant-picker-cell-start ant-picker-cell-in-view ant-picker-cell-range-start ant-picker-cell-range-end ant-picker-cell-range-hover-start ant-picker-cell-range-hover-end ant-picker-cell-range-hover-edge-start ant-picker-cell-today ant-picker-cell-selected']//div[@class='ant-picker-cell-inner'][contains(text(),'"+dd+"')]")).click();
	}

}
