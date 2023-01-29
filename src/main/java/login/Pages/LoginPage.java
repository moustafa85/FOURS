package login.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import fours.utils.AllMethods;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;


public class LoginPage extends BasePage {
	AllMethods allMethods;
	//Page Factory
	@FindBy(id="basic_username")
	WebElement username;
	
	@FindBy(id="basic_password")
	WebElement password;
	
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/button[1]")
	WebElement login;
	
	//Initializing the Page Objects
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	@FindBy(linkText = "Dashboard")
	WebElement Dashboard;

	public Boolean dashboardLink() {
		if(allMethods.VerifyElementDisplay(Dashboard)){
			Dashboard.click();
			driver.navigate().refresh();
			return driver.getCurrentUrl().contains("dashboard");
		}
		return false;
	}
	//Actions
	public String validateTitle() {

		String title = driver.getTitle();
		System.out.println("Title--"+title);
		return title;
	}
	
	 public  void SetUsername(String email){
		 WebDriverWait wait = new WebDriverWait(driver,5000);
		 wait.until(ExpectedConditions.visibilityOf(username));
		allMethods.VerifyElementDisplay(username);
	       username.sendKeys(Keys.CONTROL + "a");
	       username.sendKeys(Keys.DELETE);
	       username.sendKeys(email);
	   }
	 
	 public void loginclick() {
		allMethods.VerifyElementDisplay(login);
		login.click();
	 }
	 
	 public void SetPassword(String passwd){
		allMethods.VerifyElementDisplay(password);
		   password.sendKeys(Keys.CONTROL + "a");
	       password.sendKeys(Keys.DELETE);
	       password.sendKeys(passwd);
	   }
	
	public Boolean login(String uname, String pwd) throws InterruptedException {
		allMethods.VerifyElementDisplay(username);
		username.sendKeys(Keys.CONTROL + "a");
		username.sendKeys(Keys.DELETE);
		username.sendKeys(uname);
		allMethods.VerifyElementDisplay(password);
		password.sendKeys(Keys.CONTROL + "a");
		password.sendKeys(Keys.DELETE);
		password.sendKeys(pwd);
		allMethods.VerifyElementDisplay(login);
		login.click();

		return allMethods.verifyTitle("Dashboard",2000);

	}

}
