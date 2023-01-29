package caughtInDetection.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import fours.utils.Utilities;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import caughtInDetection.Pages.Search;
import fours.base.BasePage;
import fours.utils.TestUtils;
import login.Pages.LoginPage;

public class TC_57_SearchTest extends BasePage{
	
	LoginPage loginPage;
	Search search;
	TestUtils utils;
	Utilities utilities;

	public TC_57_SearchTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		search = new Search();
		utils = new TestUtils();
		utilities = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Search",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
		return data;
	}

	/**
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@testrail(id = "16717")
	@Test(dataProvider ="getExcelData")
	public void SearchTest(Map<String,String>map) throws InterruptedException, IOException {
		test = extent.createTest("Caught-In Detection -- Last Alert");
		test.assignCategory("Caught in Detection");
		//Navigate to Dashboard page
		if (!loginPage.dashboardLink()){
			test.fail("Failed Navigate to dashboard");
			Assert.fail();}
		test.pass("Navigate to dashboard successfully");
		//Navigate to Caught In Detection Page
		if (!search.CaughtIn()){
			test.fail("Failed Navigate to Caught In Detection Page");
			Assert.fail();}
		test.pass("Navigate to Caught In detection page");
		//Click Manage Tab
		if(!search.Manage())
			test.fail("Failed Click Manage Tab");
		test.pass("Click Manage Tab");
		//filter Both Status
		if(!search.StatusBoth())
			test.fail("Failed Filter Status 'Both'");
		test.pass("Filter Status Both");
		//Enter searched key in Search bar
		if (!search.Search(map.get("Search")))
			test.fail("Failed Entering Search :"+map.get("Search"));
		test.pass("Entre Search :"+map.get("Search"));
		//Check if there are no data for the search key
		if(utilities.NoData().equals("No Data")) {
			test.fail("Searched entry not found : "+map.get("Search"));
		}else {
			//if there are data validate the search entry is found or not
			if(!search.ValidateSearchedDisplayed(map.get("Search"))){
				test.fail("Searched entry Failed");
				Assert.fail("Searched entry Failed");}

			test.pass("Searched entry displayed successfully : "+map.get("Search"));
		}

	}

}
