package profile.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class SecurityPasswordPage extends BasePage {
	AllMethods allMethods;
	public SecurityPasswordPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//img[contains(@alt,'avatar')]")
	WebElement ProfileIcon;
	
	@FindBy(xpath = "//li[contains(.,'Profile')]")
	WebElement Profile;
	
	public void Profile() throws InterruptedException {
		allMethods.VerifyElementDisplay(ProfileIcon);
		ProfileIcon.click();
		Thread.sleep(1000);
		allMethods.VerifyElementDisplay(Profile);
		Profile.click();
	}
	
	@FindBy(xpath = "//input[@id='basic_oldPassword']")
	WebElement oldPassword;
	
	public void OldPassword(String oldPass) throws InterruptedException {
		allMethods.VerifyElementDisplay(oldPassword);
		oldPassword.sendKeys(oldPass);
	}
	
	@FindBy(xpath = "//input[@id='basic_newPassword']")
	WebElement newPassword;
	
	public void NewPassword(String newPass) throws InterruptedException {
		allMethods.VerifyElementDisplay(newPassword);
		newPassword.sendKeys(newPass);
	}
	
	@FindBy(xpath = "//input[@id='basic_confirm']")
	WebElement cnewPassword;
	
	public void CNewPassword(String cnewPass) throws InterruptedException {
		allMethods.VerifyElementDisplay(cnewPassword);
		cnewPassword.sendKeys(cnewPass);
	}
	
	@FindBy(xpath = "(//span[contains(.,'Update')])[2]")
	WebElement update;
	
	public void Update() throws InterruptedException {
		allMethods.VerifyElementDisplay(update);
		update.click();
	}

}
