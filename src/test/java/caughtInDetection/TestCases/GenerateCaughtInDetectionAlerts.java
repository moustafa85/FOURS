package caughtInDetection.TestCases;

import AlertMng.Pages.actions.AlertMngBasePage;
import Database.Testcases.LastAlertQueryTest;
import HealthVitals.Pages.AlertWindowPage;
import fours.Testrail.testrail;
import fours.base.BasePage;
import fours.utils.GenerateAlerts;
import fours.utils.TestUtils;
import login.Pages.LoginPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;

public class GenerateCaughtInDetectionAlerts extends BasePage {
    LoginPage loginPage;
    TestUtils utilswrite;
    GenerateAlerts alerts;
    AlertWindowPage alertWindowPage;
    AlertMngBasePage AlertBasePage;
    LastAlertQueryTest lastAlertQueryTest;
    public int DataSet = -1;

    public GenerateCaughtInDetectionAlerts() throws IOException {
        super();
    }
    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {

        loginPage = new LoginPage();
        utilswrite = new TestUtils();
        alerts = new GenerateAlerts();
        alertWindowPage = new AlertWindowPage();
        AlertBasePage = new AlertMngBasePage();
        lastAlertQueryTest = new LastAlertQueryTest();


    }

    @DataProvider
    public Object[][] getExcelData() throws IOException, InvalidFormatException {
        Object data[][] = TestUtils.dataSupplier("GenerateAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("CaughtInDetection"));
        return data;
    }

    /**
     *

     * @throws InterruptedException
     * @throws IOException
     * @throws ParseException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Test(dataProvider="getExcelData",groups = "")
    @testrail(id = "17328,16741")
    public void SendCaughtInDetectionAlert(Map<String,String> map) throws  IOException, SQLException, ClassNotFoundException {
        DataSet++;
        test = extent.createTest("Caught in Detection -- Send "+map.get("AlertType") +" Alert");
        test.assignCategory("Caught in Detection");
        loginPage.dashboardLink();
        if(alerts.generateGeofenceAlert(map.get("deviceID"),map.get("lat"),map.get("lon"))){
            test.pass("Send api request "+map.get("AlertType") +" Alert");
            if (prop.getProperty("AlertPopWindowEnabled").equals("true")) {
                if (alertWindowPage.VerifyAlertWindowDisplayed()){
                    test.pass(map.get("AlertType")+" Alert is displayed");
                    alertWindowPage.validateAlertType(map.get("AlertType"));// should return boolean and validate of the result in If else
                    test.pass("Alert type :"+map.get("AlertType"));
                    String alertID = alertWindowPage.getAlertID_type().replaceAll("[^0-9]", "");
                    utilswrite.WriteInExcel(alertID, DataSet+1, "GenerateAlerts","AlertID",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("CaughtInDetection"));
                    alertWindowPage.ViewAlertDetails();
                    test.pass("Alert Details is displayed");
                }else {
                    test.fail("Alert Window is not displayed");
                }
            }else {
                String Alert_ID =LastAlertQueryTest.CheckCreatedIncident(map.get("TypeID"));
                if (Alert_ID==null){
                    test.fail("Alert is not generated");
                }else {
                    utilswrite.WriteInExcel(Alert_ID, DataSet + 1, "GenerateAlerts", "AlertID", System.getProperty("user.dir") +"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
                    test.pass("Alert: "+Alert_ID+" is generated");
                }
            }

            }
        else {
            test.fail("Send api request to generate Alert is failed");
            Assert.fail("Send api request to generate Alert is failed");
        }




    }
}


