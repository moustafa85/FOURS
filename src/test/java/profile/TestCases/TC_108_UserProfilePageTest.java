package profile.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import profile.Pages.UserProfilePage;

public class TC_108_UserProfilePageTest extends BasePage{
	
	LoginPage loginPage;
	TestUtils utils;
	UserProfilePage userProfile;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_108_UserProfilePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		utils = new TestUtils();
		userProfile = new UserProfilePage();
		utilize = new Utilities();
	}
	
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("UserProfile",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("Login"));
		return data;
	}

	@Test(dataProvider ="getExcelData")
	@testrail(id = "16732")
	public void UserProfileTesting(Map<String, String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("User Profile");
		test.assignCategory("User Profile");

		loginPage.dashboardLink();
		
		userProfile.Profile();
		userProfile.Edit();
		userProfile.Name(map.get("name"));
		userProfile.Mobile(map.get("mobile"));

		if(map.get("gender").equals("Male"))
		{
			userProfile.Male();
		}
		else if(map.get("gender").equals("Female"))
		{
			userProfile.Female();
		}
		
		userProfile.Update();
		

		if(utilize.getConfirmMsg().equals("Successfully updated user profile"))
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "UserProfile","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("Login"));
			test.pass("User profile is updated");
		}
		else
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "UserProfile","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("Login"));
			test.fail("User profile is not updated");
		}
	}

}
