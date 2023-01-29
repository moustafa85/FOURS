package device.TestCases;

import java.awt.AWTException;
import java.io.IOException;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import device.pages.BulkUpload;
import device.pages.DeviceBasePage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_107_BulkUploadTest extends BasePage{

	public TC_107_BulkUploadTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	BulkUpload bulkUpload;
	TestUtils utils;
	DeviceBasePage deviceBasePage;
	Utilities utilize;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		bulkUpload = new BulkUpload();
		utils = new TestUtils();
		utilize = new Utilities();
		deviceBasePage = new DeviceBasePage();
	}
	@testrail(id = "16638,16891,16893,16895")
	@Test
	public void bulkUpload() throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Devices - Bulk Upload");
		test.assignCategory("Devices");

		loginPage.dashboardLink();

		deviceBasePage.DeviceModule();
		bulkUpload.UploadButton();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("BulkDevices"));
		Thread.sleep(2000);
		bulkUpload.InvalidButton();
		if (!bulkUpload.next()){
			bulkUpload.close();
			test.fail("Bulk file is Invalid");
			Assert.fail("Bulk file is Invalid");
		}else{
			bulkUpload.BulkUploadButton();
			bulkUpload.close();
			test.pass("bulk Devices is successfully uploaded");
		}


	}

}
