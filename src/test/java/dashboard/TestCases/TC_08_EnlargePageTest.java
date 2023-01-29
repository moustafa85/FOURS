package dashboard.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Dashboard.Pages.AssignedOpenAlertPage;
import Dashboard.Pages.EnlargePage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_08_EnlargePageTest extends BasePage{
	
	LoginPage loginPage;
	EnlargePage enlarge;
	TestUtils utils;
	Utilities utilize;

	public TC_08_EnlargePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		enlarge = new EnlargePage();
		utils = new TestUtils();
		utilize = new Utilities();
	}

	@testrail(id = "16676")
	@Test
	public void EnlargePage() throws InterruptedException, IOException {
		
		test = extent.createTest("Dashboard -- Enlarge Page Test");
		test.assignCategory("Dashboard");
		loginPage.dashboardLink();
		Thread.sleep(4000);
		WebElement element = driver.findElement(By.xpath("(//div[contains(.,'Mapping')])[7]"));
		utilize.ScrollToLocation(element);
		//Thread.sleep(2000);
		enlarge.Enlarge();
		//Thread.sleep(2000);
		test.pass("Enlarge Page");
		
		enlarge.closeButton();

}
}