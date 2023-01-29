package Dashboard.Pages;

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

public class SosAlertPage extends BasePage{
	AllMethods allMethods;

	public SosAlertPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[3]")
	WebElement sos;
	
	public void SOS() {
		allMethods.VerifyElementDisplay(sos);
		sos.click();
	}
	
	public String SOSAlertCount() {
		allMethods.VerifyElementDisplay(sos);

		String count = sos.getText();
		//System.out.println("SOS alert in Dashboard Page -- "+count);
		return count;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[4]")
	WebElement sosCount;
	
	public String SOSCount() {
		allMethods.VerifyElementDisplay(sosCount);
		String count = sosCount.getText();
		//System.out.println("SOS alert in Fall Alerts page -- "+count);
		return count;
	}
	
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Today')])[1]")
	WebElement timeRange;
	
	@FindBy(xpath = "(//input[contains(@size,'12')])[1]")
	WebElement startDate;
	
	@FindBy(xpath = "//input[@placeholder='End date']")
	WebElement endDate;
	
	String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	
	String[] elementSplit = todayDate.split("-");
	  
		String date = elementSplit[2];
		String month = elementSplit[1];
		String year = elementSplit[0];
		
		int ye = Integer.parseInt(year);
		int backYear = ye-1;
		String prevYear = Integer.toString(backYear);
		
		String prevYearDate = prevYear + "-" + month + "-" + date;
		
		String dd = date.replaceFirst("^0+(?!$)", "");
	
	public void selectDate() throws InterruptedException {
		
		driver.findElement(By.xpath("(//div[@class='ant-picker-cell-inner'][contains(.,'"+dd+"')])[1]")).click();
	}
	
	public void TimeRange() throws InterruptedException {
		allMethods.VerifyElementDisplay(timeRange);
		timeRange.click();
		allMethods.VerifyElementDisplay(startDate);
		startDate.click();
		Thread.sleep(1000);
		startDate.sendKeys(Keys.CONTROL + "a");
		startDate.sendKeys(Keys.DELETE);
		startDate.sendKeys(prevYearDate);
		allMethods.VerifyElementDisplay(endDate);
		endDate.click();
		System.out.println("TodayDate = "+todayDate);
		System.out.println("PreviousYearDate = "+prevYearDate);
		System.out.println("dd = "+dd);
		selectDate();
	}
	
}
