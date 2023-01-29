package siteMonitoring.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import siteMonitoring.Pages.GuardianPage;

public class TC_83_AudioBroadCastTest extends BasePage{

	public TC_83_AudioBroadCastTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	GuardianPage guardian;
	TestUtils utils;
	Utilities utilize;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		guardian = new GuardianPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("AudioBroadCast", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("SiteMonitoring"));
		return data;
	}
	@testrail(id = "16704")
	@Test(dataProvider ="getExcelData")
	public void AudioBroadCastTest(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Site Monitoring -- Audio BroadCast");
		test.assignCategory("Site Monitoring");

		if(!loginPage.dashboardLink()){
			test.fail("The user not navigated to Dashboard");
			Assert.fail("The user not navigated to Dashboard");}
		test.pass("The user navigated to Dashboard successfully");

		if(!guardian.SM()){
			test.fail("The user not navigated to Site Monitoring page");
			Assert.fail("The user not navigated to Site Monitoring page");}
		test.pass("The user navigated to Site Monitoring page successfully");

		if(!guardian.Guardian()){
			test.fail("The user not navigated to Video Monitoring tab");
			Assert.fail("The user not navigated to Video Monitoring tab");}
		test.pass("The user navigated to Video Monitoring tab successfully");

		if(!guardian.SelectAudio(map.get("AudioFile"))){
			test.fail("The Audio file :"+map.get("AudioFile")+" is not selected");
			Assert.fail("The Audio file :"+map.get("AudioFile")+" is not selected");}
		test.pass("The Audio file :"+map.get("AudioFile")+" is selected successfully");

		if(!guardian.BroadCastLevel(map.get("BroadCastLevel"))){
			test.fail("The Broadcast Level :"+map.get("BroadCastLevel")+" is not selected");
			Assert.fail("The Broadcast Level :"+map.get("BroadCastLevel")+" is not selected");}
		test.pass("The Broadcast Level :"+map.get("BroadCastLevel")+" is selected successfully");

		if(!guardian.BroadCastButton()){
			test.fail("The broadcast button is not clickable");
			Assert.fail("The broadcast button is not clickable");}

		test.pass("The broadcast button clicked successfully");
		if(utilize.getConfirmMsg().equals("Successfully added Command"))
		{
			if(utilize.getConfirmMsg().equals("Command Failed to execute")) {
				utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "AudioBroadCast","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("SiteMonitoring"));
				test.pass("Command Failed to execute");
			}
		}
		else
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "AudioBroadCast","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("SiteMonitoring"));
			test.fail("Command is not added");
		}
		
	}

}
