package siteMonitoring.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class GuardianPage extends BasePage{
	AllMethods allMethods;

	public GuardianPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//a[contains(.,'Site Monitoring')]")
	WebElement sm;
	
	public Boolean SM() {
		if(!allMethods.VerifyElementDisplay(sm))
			return false;
		sm.click();
		return true;
	}
	
	@FindBy(xpath = "//div[@role='tab'][contains(.,'Video Monitoring')]")
	WebElement guardian;
	
	public Boolean Guardian() {
		if(!allMethods.VerifyElementDisplay(guardian))
			return false;
		guardian.click();
		return true;
	}
	
	@FindBy(xpath = "//div[contains(@class,'value___ln_Tc')]")
	WebElement lastAlert;
	
	public void LastAlertClick() {
		allMethods.VerifyElementDisplay(lastAlert);
		lastAlert.click();
	}
	
	public String LastAlert() {
		allMethods.VerifyElementDisplay(lastAlert);
		String count = lastAlert.getText();
		//System.out.println("Last alert in Site Monitoring Guardian Page  -- "+count);
		return count;
	}
	
	@FindBy(xpath = "//span[contains(.,'Turn On')]")
	WebElement buzzerOn;
	
	public void BuzzerOn() {
		allMethods.VerifyElementDisplay(buzzerOn);
		buzzerOn.click();
	}
	
	@FindBy(xpath = "//span[contains(text(),'Turn Off')]")
	WebElement buzzerOff;
	
	public void BuzzerOff() {
		allMethods.VerifyElementDisplay(buzzerOff);
		buzzerOff.click();
	}
	
	@FindBy(xpath = "//button[@id='ir']")
	WebElement IRSensor;
	
	public void IRSensor() {
		allMethods.VerifyElementDisplay(IRSensor);
		IRSensor.click();
	}
	
	@FindBy(xpath = "//button[@id='fire']")
	WebElement FireSensor;
	
	public void FireSensor() {
		allMethods.VerifyElementDisplay(FireSensor);
		FireSensor.click();
	}
	
	@FindBy(xpath = "//input[@id='index']")
	WebElement audio;
	
	public Boolean SelectAudio(String Audio) throws InterruptedException {
		try{
			if (!allMethods.VerifyElementDisplay(audio))
				return false;
			audio.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+Audio+"')]")).click();
			return true;

		}catch (NoSuchElementException e){
			return false;
		}
	}
	
	@FindBy(xpath = "//input[@id='index']")
	WebElement broadCastLevel;
	
	public Boolean BroadCastLevel(String BroadCast) throws InterruptedException {
		try {
			driver.findElement(By.xpath("//span[contains(.,'"+BroadCast+"')]")).click();
			return true;
		}catch (NoSuchElementException e){
			return false;
		}

	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[12]")
	WebElement broadCastButton;
	
	public Boolean BroadCastButton() {
		try{
			if (!allMethods.VerifyElementClickable(broadCastButton))
				return false;
			broadCastButton.click();
			return true;
		}catch (NoSuchElementException e){
		return false;
		}
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[12]")
	WebElement broadCastStopButton;
	
	public Boolean BroadCastStopButton() {
		try{
			if (!allMethods.VerifyElementClickable(broadCastStopButton))
				return false;
			broadCastStopButton.click();
			return true;
		}catch (NoSuchElementException e){
			return false;
		}
	}

}
