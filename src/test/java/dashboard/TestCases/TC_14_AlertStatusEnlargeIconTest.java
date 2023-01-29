package dashboard.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Dashboard.Pages.AlertStatusEnlargeIcon;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_14_AlertStatusEnlargeIconTest extends BasePage{
	
	LoginPage loginPage;
	AlertStatusEnlargeIcon enlargeIcon;
	Utilities utilize;

	public TC_14_AlertStatusEnlargeIconTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		enlargeIcon = new AlertStatusEnlargeIcon();
		utilize = new Utilities();
	}
	
	@Test
	public void EnlargeIcon() throws InterruptedException, IOException {

		test = extent.createTest("Dashboard -- Alert Status Enlarge Icon");
		test.assignCategory("Dashboard");
		loginPage.dashboardLink();
		Thread.sleep(4000);

		WebElement Element = driver.findElement(By.xpath("//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']"));
		utilize.ScrollToLocation(Element);
		enlargeIcon.enlargeIcon();
		enlargeIcon.ClearIcon();
}

}
