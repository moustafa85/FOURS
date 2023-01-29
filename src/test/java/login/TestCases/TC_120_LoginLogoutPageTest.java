package login.TestCases;

import java.io.IOException;

import logout.Pages.LogoutPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import login.Pages.LoginPage;
import profile.Pages.UserProfilePage;

public class TC_120_LoginLogoutPageTest extends BasePage {
	
	LoginPage loginPage;
	UserProfilePage profile;
	LogoutPage logoutPage;
	
	public TC_120_LoginLogoutPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		profile = new UserProfilePage();
		logoutPage = new LogoutPage();
	}
	
	@Test
	public void loginTesting() throws IOException, InterruptedException {
		test = extent.createTest("Login Page Test");
		test.assignCategory("Login");

		if (loginPage.validateTitle().contains("Login")==false){
			loginPage.dashboardLink();
			logoutPage.LogoutClick();
		}
		if (!loginPage.login(prop.getProperty("username"), prop.getProperty("password"))){
			test.fail("Failed Login");
			Assert.fail("Failed Login");
		}

		if (logoutPage.LogoutClick())
			test.pass("User Logged Out successfully");
		else {
			test.fail("Failed Logout");
			Assert.fail("Failed Logout");
		}

	}

}
