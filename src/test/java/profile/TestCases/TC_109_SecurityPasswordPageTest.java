package profile.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import logout.Pages.LogoutPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import profile.Pages.SecurityPasswordPage;

public class TC_109_SecurityPasswordPageTest extends BasePage {
	
	LoginPage loginPage;
	TestUtils utils;
	SecurityPasswordPage passwordPage;
	Utilities utilize;
	LogoutPage logoutPage;
	
	public int DataSet = -1;

	public TC_109_SecurityPasswordPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		utils = new TestUtils();
		passwordPage = new SecurityPasswordPage();
		utilize = new Utilities();
		logoutPage = new LogoutPage();
	}
	
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Password", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("Login"));
		return data;
	}
	@testrail(id = "16632")
	@Test(dataProvider ="getExcelData")
	public void SecurityPasswordTesting(Map<String, String > map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Profile -- User Password");
		test.assignCategory("User Profile");

		if (loginPage.validateTitle().contains("Login")==false){
			//IF NOT Navigate to Dashboard and logout
			loginPage.dashboardLink();
			logoutPage.LogoutClick();
		}
		//ENTER Login Credentials
		loginPage.SetUsername(map.get("Username"));
		loginPage.SetPassword(map.get("Password"));
		loginPage.loginclick();
		passwordPage.Profile();
		passwordPage.OldPassword(map.get("Password"));
		passwordPage.NewPassword(map.get("NewPassword"));
		passwordPage.CNewPassword(map.get("NewPassword"));
		passwordPage.Update();

		if(utilize.getConfirmMsg().equalsIgnoreCase("Successfully updated user's password"))
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "Password","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("Login"));
			utils.WriteInExcel(map.get("NewPassword"), DataSet+1, "Password","Password",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("Login"));
			test.pass("User password updated");
		}
		else
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "Password","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("Login"));
			test.fail("User password is not updated");
			Assert.fail("User password is not updated");
		}
	}

}
