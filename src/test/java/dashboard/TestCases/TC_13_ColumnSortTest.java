package dashboard.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Dashboard.Pages.ColumnSort;
import fours.base.BasePage;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_13_ColumnSortTest extends BasePage{
	
	LoginPage loginPage;
	ColumnSort sorting;
	Utilities utilize;
	
	public TC_13_ColumnSortTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		sorting = new ColumnSort();
		utilize = new Utilities();
	}
	
	@Test
	public void ColumnSorting() throws InterruptedException, IOException {
		
		
		test = extent.createTest("Dashboard -- Alert Column Sorting");
		test.assignCategory("Dashboard");
		loginPage.dashboardLink();
		Thread.sleep(4000);

		WebElement Element = driver.findElement(By.xpath("(//div[contains(.,'Alerts')])[13]"));
		utilize.ScrollToLocation(Element);
		sorting.AlertSorting();
		sorting.AlertSorting();
		sorting.CreatedAtSorting();
		sorting.CreatedAtSorting();
		sorting.TypeSorting();
		sorting.TypeSorting();
		sorting.StatusSorting();
		sorting.StatusSorting();
		sorting.WorkerSorting();
		sorting.WorkerSorting();
		sorting.LocationSorting();
		sorting.LocationSorting();
		sorting.AssignedToSorting();
		sorting.AssignedToSorting();
}

}
