package worker.TestCases;

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
import workers.pages.ActivateWorkerPage;
import workers.pages.WorkerBasePage;
import workers.pages.WorkerPagination;

public class TC_94_WorkerPaginationTest extends BasePage{
	
	LoginPage loginPage;
	WorkerPagination wrkPagination;
	WorkerBasePage workerBasePage;

	public TC_94_WorkerPaginationTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		wrkPagination = new WorkerPagination();
		workerBasePage = new WorkerBasePage();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Pagination",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("WorkerFilePath"));
		return data;
	}
	
	@Test(dataProvider="getExcelData")
	@testrail(id = "16650,16934")
	public void Pagination(Map<String,String> map) throws InterruptedException, IOException {


		test = extent.createTest("Worker Pagination");
		test.assignCategory("Workers");

		loginPage.dashboardLink();
		workerBasePage.WorkersModule();
		wrkPagination.PageType(map.get("PageType"));

		String pgNo = map.get("PageNo");
	    int pageNo = Integer.parseInt(pgNo);
	    
	    if(pageNo<=wrkPagination.LastPage()) 
	    {
	    	System.out.println(wrkPagination.LastPage());
	    	
	    	for(int i=2;i<=pageNo;i++)
	    	{
	    		wrkPagination.PageClick(i);
	    		System.out.println("Page --"+i);
	    	}
	    	
	    }
	    

	}

}
