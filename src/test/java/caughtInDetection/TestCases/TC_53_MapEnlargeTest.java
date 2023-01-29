package caughtInDetection.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import caughtInDetection.Pages.MapEnlarge;
import fours.base.BasePage;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_53_MapEnlargeTest extends BasePage{
	
	LoginPage loginPage;
	MapEnlarge enlarge;
	Utilities utilize;

	public TC_53_MapEnlargeTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		loginPage = new LoginPage();
		enlarge = new MapEnlarge();
		utilize = new Utilities();
	}

	/**
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@testrail(id = "16714")
	public void MapEnlarge() throws InterruptedException, IOException {
		
		test = extent.createTest("Caught-In Detection -- Map Enlarge");
		test.assignCategory("Caught in Detection");
		loginPage.dashboardLink();
		enlarge.CaughtIn();
		test.pass("Navigate to Caught in detection page");
		enlarge.MapEnlargeButton();
		test.pass("Open the map");
		enlarge.MapCloseButton();
		test.pass("Close the map");
	}

}
