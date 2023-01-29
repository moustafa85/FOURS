package dashboard.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Dashboard.Pages.AlertFilterPage;
import Dashboard.Pages.Pagination;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_12_PaginationTest extends BasePage{
	
	LoginPage loginPage;
	Pagination pagination;
	TestUtils utils;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_12_PaginationTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		pagination = new Pagination();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Pagination", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("Dashboard"));
		return data;
	}
	@testrail(id = "16668,16992")
	@Test(dataProvider ="getExcelData")
	public void AlertPagination(Map<String,String>map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Dashboard -- Alerts Pagination");
		test.assignCategory("Dashboard");
		loginPage.dashboardLink();
		Thread.sleep(4000);

		WebElement Element = driver.findElement(By.xpath("//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']"));
		
		utilize.ScrollToLocation(Element);
		pagination.PageType(map.get("PageType"));
		String pgNo = map.get("PageNo");
	    int pageNo = Integer.parseInt(pgNo);
	    int LpageNo = Integer.parseInt(map.get("LastPageNo"));
	    if(pageNo<=LpageNo)
	    {
	    	for(int i=1;i<=pageNo;i++)
	    	{
	    		pagination.PageClick(i);
	    	}
	    	
	    }

}

}
