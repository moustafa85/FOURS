package login.TestCases;

import fours.Testrail.testrail;
import fours.base.BasePage;
import fours.utils.TestUtils;
import login.Pages.LoginPage;
import logout.Pages.LogoutPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import profile.Pages.UserProfilePage;

import java.io.IOException;
import java.util.Map;

public class TC_121_LoginDifferentRoles extends BasePage {

    LoginPage loginPage;
    TestUtils utilswrite;
    LogoutPage logoutPage;
    UserProfilePage userProfile;

    public int DataSet = -1;

    public TC_121_LoginDifferentRoles() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        loginPage = new LoginPage();
        utilswrite = new TestUtils();
        logoutPage = new LogoutPage();
        userProfile = new UserProfilePage();

    }

    @DataProvider
    public Object[][] getExcelData() throws IOException, InvalidFormatException {
        Object data[][] = TestUtils.dataSupplier("LoginDifferentRoles", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("Login"));
        return data;
    }
    @testrail(id = "16617,16608,16604,16597")
    @Test(dataProvider="getExcelData")
    public void loginTesting(Map<String, String> map) throws InterruptedException, IOException {
        DataSet++;

        test = extent.createTest("Login with different roles Test");
        test.assignCategory("Login");
        //Validate login page is displayed
        if (loginPage.validateTitle().contains("Login")==false){
            //IF NOT Navigate to Dashboard and logout
            loginPage.dashboardLink();
            logoutPage.LogoutClick();
        }
        //ENTER Login Credentials
        loginPage.SetUsername(map.get("Username"));
        loginPage.SetPassword(map.get("Password"));
        loginPage.loginclick();
        Thread.sleep(2000);
        //If message passed from excel then it should be error message displayed
            if(!loginPage.validateTitle().equals("Login"))
            {
                if (!userProfile.Profile()){
                    test.fail("User profile is not displayed");
                    Assert.fail("User profile is not displayed");
                }
                test.pass("User profile is displayed");
                String role = userProfile.getUserRole();
                if (userProfile.checkUserRole(map.get("Role")))
                {
                    utilswrite.WriteInExcel("Success Login for role--"+role, DataSet+1, "LoginDifferentRoles","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("Login"));
                    test.pass("Success Login for role--"+role);
                }else {
                    test.fail("Failed Login, the user logged in is not with role :"+role);
                    Assert.fail("Failed Login, the user logged in is not with role :"+role);
                }
            }else {
                test.fail("Failed Login for role: "+map.get("Role"));
                Assert.fail("Failed Login for role: "+map.get("Role"));
            }
        }
    }