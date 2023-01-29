package worker.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import workers.pages.WorkerBasePage;
import workers.pages.WorkersPages;

public class TC_91_DeleteWorker extends BasePage{

	public TC_91_DeleteWorker() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	TestUtils utils;
	WorkerBasePage workerBasePage;
	Utilities utilize;
	
	

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		utils = new TestUtils();
		workerBasePage = new WorkerBasePage();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("DeleteWorker", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("WorkerFilePath"));
		return data;
	}
	@testrail(id = "39698")
	@Test(dataProvider ="getExcelData")
	public void DeleteWorkerTesting(Map<String,String> map) throws InterruptedException, IOException, AWTException {

		test = extent.createTest("Delete Worker");
		test.assignCategory("Workers");
		loginPage.dashboardLink();
		workerBasePage.WorkersModule();
		workerBasePage.StatusBoth();
		workerBasePage.Search(map.get("Search"));
		workerBasePage.deleteWorker();
		workerBasePage.deleteWorkerConfirm();

	}

}
