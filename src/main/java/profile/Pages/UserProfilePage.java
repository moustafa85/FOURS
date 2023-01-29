package profile.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class UserProfilePage extends BasePage {
	AllMethods allMethods;
	public UserProfilePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//img[contains(@alt,'avatar')]")
	WebElement ProfileIcon;
	
	@FindBy(xpath = "//li[contains(.,'Profile')]")
	WebElement Profile;
	
	@FindBy(xpath = "//li[contains(.,'Logout')]")
	WebElement logout;
	
	public Boolean Profile() throws InterruptedException {
		if (!allMethods.VerifyElementDisplay(ProfileIcon))
			return false;
		ProfileIcon.click();
		Thread.sleep(1000);
		if (!allMethods.VerifyElementDisplay(Profile))
			return false;
		Profile.click();
		return true;
	}
	
	public void Logout() throws InterruptedException {
		allMethods.VerifyElementDisplay(ProfileIcon);
		ProfileIcon.click();
		Thread.sleep(1000);
		allMethods.VerifyElementDisplay(logout);
		logout.click();
	}
	
	@FindBy(xpath = "//span[@class='anticon anticon-edit']")
	WebElement edit;
	
	public void Edit() {
		allMethods.VerifyElementDisplay(edit);
		edit.click();
	}
	
	@FindBy(xpath = "//input[@id='basic_name']")
	WebElement username;
	
	public void Name(String name) throws InterruptedException {
		allMethods.VerifyElementDisplay(username);
		username.sendKeys(Keys.CONTROL + "a");
		username.sendKeys(Keys.DELETE);
		username.sendKeys(name);
	}
	
	@FindBy(xpath = "//input[@id='basic_mobile']")
	WebElement userMobile;
	
	public void Mobile(String mobile) throws InterruptedException {
		allMethods.VerifyElementDisplay(userMobile);
		userMobile.sendKeys(Keys.CONTROL + "a");
		userMobile.sendKeys(Keys.DELETE);
		userMobile.sendKeys(mobile);
	}
	
	@FindBy(xpath = "//span[@class='ant-select-selection-item']")
	WebElement gender;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(.,'Male')]")
	WebElement g_male;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(.,'Female')]")
	WebElement g_female;
	
	public void Male() throws InterruptedException {
		allMethods.VerifyElementDisplay(gender);
		gender.click();
		Thread.sleep(1000);
		allMethods.VerifyElementDisplay(g_male);
		g_male.click();
	}
	
	public void Female() throws InterruptedException {
		allMethods.VerifyElementDisplay(gender);
		gender.click();
		Thread.sleep(1000);
		allMethods.VerifyElementDisplay(g_female);
		g_female.click();
	}
	
	@FindBy(xpath = "(//span[contains(.,'Update')])[1]")
	WebElement update;
	
	public void Update() throws InterruptedException {
		allMethods.VerifyElementDisplay(update);
		update.click();
	}
	public Boolean checkUserRole(String role){
		try {
			if (!allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//span[contains(text(),'" + role + "')]")))) {
				return false;
			}
			return true;
		}catch (Exception e){
			return false;
		}
	}

	public String getUserRole(){
		try {
			if (!allMethods.VerifyElementDisplay(driver.findElement(By.xpath("(//span[@class='ant-descriptions-item-content'])[3]")))) {
				return "";
			}
			return driver.findElement(By.xpath("(//span[@class='ant-descriptions-item-content'])[3]")).getText();
		}catch (Exception e){
			return "";
		}
	}
	
}
