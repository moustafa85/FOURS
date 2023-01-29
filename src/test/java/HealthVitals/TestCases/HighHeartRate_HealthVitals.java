package HealthVitals.TestCases;

import AlertMng.Pages.actions.AlertMngBasePage;
import Dashboard.Pages.AlertPage;
import Database.Testcases.LastAlertQueryTest;
import HealthVitals.Pages.AlertWindowPage;
import HealthVitals.Pages.HealthAnalyticsPage;
import HealthVitals.Pages.HealthVitalsListPage;
import HealthVitals.Pages.HealthVitalsPage;
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
import workers.pages.WorkerAlertsPage;
import workers.pages.WorkerBasePage;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HighHeartRate_HealthVitals extends BasePage {

    LoginPage loginPage;
    HealthAnalyticsPage healthAnalyticsPage;
    HealthVitalsPage healthVitalsPage;
    TestUtils utilswrite;
    GenerateAlerts alerts;
    AlertWindowPage alertWindowPage;
    AlertMngBasePage AlertBasePage;
    HealthVitalsListPage healthVitalsListPage;
    AlertMngBasePage alertMngBasePage;
    WorkerBasePage workerBasePage;
    WorkerAlertsPage workerAlertsPage;
    AlertPage alertPage;

    public int DataSet = -1;

    public HighHeartRate_HealthVitals() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        alertPage = new AlertPage();
        loginPage = new LoginPage();
        healthAnalyticsPage = new HealthAnalyticsPage();
        utilswrite = new TestUtils();
        alerts = new GenerateAlerts();
        alertWindowPage = new AlertWindowPage();
        AlertBasePage = new AlertMngBasePage();
        healthVitalsPage = new HealthVitalsPage();
        healthVitalsListPage = new HealthVitalsListPage();
        alertMngBasePage = new AlertMngBasePage();
        workerAlertsPage = new WorkerAlertsPage();
        workerBasePage = new WorkerBasePage();
    }

    @DataProvider
    public Object[][] getExcelData() throws IOException, InvalidFormatException {
        Object data[][] = TestUtils.dataSupplier("HighHeartRate",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("HealthAlerts"));
        return data;
    }
    @testrail(id="19883")
    @Test(dataProvider="getExcelData",priority = 0)
    public void ValidateUpdatedHighHeartRate(Map<String, String> map) throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException {
        DataSet++;

        test = extent.createTest("Health Vitals -- Validate Updated High Heart Rate dashboard after send Alert");
        test.assignCategory("Health Vitals");

    //Navigate to Dashboard Page
        if (!loginPage.dashboardLink()){
            test.fail("Failed Navigate to Dashboard Link");
            Assert.fail("Failed Navigate to Dashboard Link");
        }
    //Navigate to Health Vitals Page
        if(!healthAnalyticsPage.healthVitalsLink()){
            test.fail("Failed Navigate to health Vitals Link");
            Assert.fail("Failed Navigate to health Vitals Link");
        }
        //Select the site
        if (!healthVitalsPage.SelectSite(map.get("Site"))){
            test.fail("Failed Select the site : "+map.get("Site"));
            Assert.fail("Failed Select the site : "+map.get("Site"));
        }
        Thread.sleep(2000);
        //Check the High Heart Rate alerts count
        int HighHeartRateCountb4 = Integer.parseInt(healthAnalyticsPage.HighHeartRateCount());
        test.pass("High Heart Rate Alerts Count before :"+HighHeartRateCountb4);
        if (alerts.generateHealthVitalsAlert(map.get("deviceID"),map.get("bpHigh"),map.get("bpLow"),map.get("bpHeart"),map.get("temp"),map.get("lat"),map.get("lon"))){
            test.pass("Send api request "+map.get("AlertType") +" Alert");
        if (prop.getProperty("AlertPopWindowEnabled").equals("true")){
            if (alertWindowPage.VerifyAlertWindowDisplayed()){
            test.pass(map.get("AlertType")+" Alert is displayed");
            alertWindowPage.validateAlertType(map.get("AlertType"));
            test.pass("Alert type :"+map.get("AlertType"));
            String alertID = alertWindowPage.getAlertID_type().replaceAll("[^0-9]", "");
            utilswrite.WriteInExcel(alertID, DataSet+1, "HighHeartRate","AlertID",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("HealthAlerts"));
            alertWindowPage.CloseAlert();
            }else{
                test.fail(map.get("AlertType")+" Alert popup window is not displayed");

            }

        }else{
            String alertID = LastAlertQueryTest.CheckCreatedIncident(map.get("TypeID"));
            utilswrite.WriteInExcel(alertID, DataSet+1, "HighHeartRate","AlertID",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("HealthAlerts"));

        }
        //Refresh the page
        healthVitalsPage.Refresh();
        //Select the site
            if (healthVitalsPage.SelectSite(map.get("Site"))){
                test.fail("Failed Select the site : "+map.get("Site"));
                Assert.fail("Failed Select the site : "+map.get("Site"));
            }
            Thread.sleep(2000);
            //Check the High Heart Rate alerts count after alert is generated
            int HighHeartRateCountAfter = Integer.parseInt(healthAnalyticsPage.HighHeartRateCount());
            if(HighHeartRateCountAfter == HighHeartRateCountb4+1) {
                test.pass("Validate the dashboard data is updated ");
            }else {
                test.fail("The dashboard data : High Heart Rate Count is not updated");
            }

    }
    else {
        test.fail("Send api request for "+map.get("AlertType") +" Alert Failed");
        Assert.fail("Send api request for "+map.get("AlertType") +" Alert Failed");
        }}
    @testrail(id="17075,17157")
    @Test(dataProvider="getExcelData",priority = 1)
    public void ValidateUpdatedHighHeartRateList(Map<String, String> map) throws InterruptedException, IOException {
        DataSet++;

        test = extent.createTest("Health Vitals -- Send "+map.get("AlertType") +" Alert");
        test.assignCategory("Health Vitals");

        //Navigate to Health Vitals Page
        if(!healthAnalyticsPage.healthVitalsLink()){
            test.fail("Failed Navigate to health Vitals Link");
            Assert.fail("Failed Navigate to health Vitals Link");
        }
        //Select the site
        if (!healthVitalsPage.SelectSite(map.get("Site"))){
            test.fail("Failed Select the site : "+map.get("Site"));
            Assert.fail("Failed Select the site : "+map.get("Site"));
        }
        //Select the site
        if (!healthVitalsPage.SelectSite(map.get("Site"))){
            test.fail("Failed Select the site : "+map.get("Site"));
            Assert.fail("Failed Select the site : "+map.get("Site"));
        }
        Thread.sleep(2000);
        //Click Heart Rate in analytics
        healthAnalyticsPage.HighHeartRateClick();
        //Validate High Heart Rate list displayed
        Assert.assertTrue(healthVitalsListPage.ValidatePageTitle());


    }
    @testrail(id="17814,17816")
    @Test(dataProvider="getExcelData",priority = 2)
    public void ValidateHighHeartRateAlert(Map<String, String> map) throws InterruptedException, IOException {
        DataSet++;

        test = extent.createTest("Alert Management -- Validate High Heart Rate Alert : "+map.get("AlertID"));
        test.assignCategory("Alert Management");
        //Navigate to Alert Management page
        if(!alertMngBasePage.AlertMng()){
            test.fail("Failed Navigate to Alert Management Link");
            Assert.fail("Failed Navigate to Alert Management Link");
        }
        //Search For alert Id
        if(!alertMngBasePage.Search(map.get("AlertID"))){
            test.fail("Failed Search for Alert ID"+map.get("AlertID"));
            Assert.fail("Failed Search for Alert ID"+map.get("AlertID"));
        }
        //Validate alert ID displayed and Click open
        if(!alertMngBasePage.openAlertDetailsPage()){
            test.fail("Failed Open details for Alert ID"+map.get("AlertID"));
            Assert.fail("Failed Open details for Alert ID"+map.get("AlertID"));
        } else {
            Assert.assertTrue(alertMngBasePage.getAlertDetailsPageTitle().contains(map.get("AlertID")));
            test.pass("Alert Details is displayed");
        }

    }
    @testrail(id="17113")
    @Test(dataProvider = "getExcelData",priority = 3)
    public void ValidateWorkerProfile(Map<String, String> map) throws InterruptedException, IOException, AWTException {
        DataSet++;
        driver.navigate().refresh();
        test = extent.createTest("Worker Profile Health Vitals -- Validate Alert grid for alert : "+map.get("AlertID"));
        test.assignCategory("Worker Profile");
        //Navigate to workers page
        if (!workerBasePage.WorkersModule()){
            test.fail("Failed Navigate to Worker page");
            Assert.fail("Failed Navigate to Worker page");
        }
        test.pass("Navigate to Worker page");
        //Search for Worker by assigned Device (smartwatch ID)
        if(!workerBasePage.AssignedSmartWatch(map.get("deviceID"))){
            test.fail("Failed Search for Worker By Device UID : "+map.get("deviceID"));
            Assert.fail("Failed Search for Worker By Device UID : "+map.get("deviceID"));
        }
        test.pass("Search for Worker By Device UID : "+map.get("deviceID"));
        Thread.sleep(2000);
        //Open Worker details page
        if (!workerBasePage.ClickFirstWorker())
        {
            test.fail("Failed Open Worker page");
            Assert.fail("Failed Open Worker page");
        }
        test.pass("Open Worker page");
        //Validate alert section displayed
        if(!workerAlertsPage.AlertsSectionDisplayed())
        {
            test.fail("Alert section is not displayed");
            Assert.fail("Alert section is not displayed");
        }
        test.pass("Alert section displayed");
        Thread.sleep(2000);
        //Expand alerts section
        if (!workerAlertsPage.clickExpandAlertButton()) {
            test.fail("Alert section is not Expanded");
            Assert.fail("Alert section is not Expanded");
        }
        test.pass("Alert section is Expanded");
        //Search for alert id and click on it
        Thread.sleep(2000);
        if(!workerAlertsPage.ClickAlert(map.get("AlertID"))){
            test.fail("Alert : "+map.get("AlertID")+" is not Clicked");
            Assert.fail("Alert : "+map.get("AlertID")+" is not Clicked");
        }
        test.pass("Alert : "+map.get("AlertID")+" is Clicked");
        //Alert details will be open in new tab
        Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);
        driver.switchTo().window(handlesList.get(handlesList.size()-1));
        Assert.assertTrue(alertMngBasePage.getAlertDetailsPageTitle().contains(map.get("AlertID")));
        test.pass("Alert #"+map.get("AlertID")+" : Details is displayed");
        driver.switchTo().window(handlesList.get(0));
    }
    @Test(dataProvider = "getExcelData",priority = 4)
    public void ValidateDashboardAlertGrid(Map<String, String> map) throws InterruptedException, IOException, AWTException {
        DataSet++;
        driver.navigate().refresh();

        test = extent.createTest("Dashboard -- Validate Alert : "+map.get("AlertID")+" displayed in dashboard grid ");
        test.assignCategory("Dashboard");
        //Navigate to Dashboard
        if (!alertPage.dashboardLink()) {
            test.fail("Failed Navigated to Dashboard Page");
            Assert.fail("Failed Navigated to Dashboard Page");
        }
        test.pass("Navigated to Dashboard Page");
        //Select the site
        if (!alertPage.SelectSite(map.get("Site"))){
            test.fail("Failed Select the site : "+map.get("Site"));
            Assert.fail("Failed Select the site : "+map.get("Site"));
        }
        test.pass("Filter Site : "+map.get("Site")+" alert");
        Thread.sleep(2000);
        //Search and click alert ID
        if(!alertPage.AlertClick(map.get("AlertID"))){
            test.fail("Failed Click the alert : "+map.get("AlertID"));
            Assert.fail("Failed Click the alert : "+map.get("AlertID"));
        }
        test.pass("Click Alert: "+map.get("AlertID"));
        //Alert details is opened in new tab
        Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);
        driver.switchTo().window(handlesList.get(handlesList.size()-1));
        Thread.sleep(2000);
        //Validate alert ID is displayed in the title
        Assert.assertTrue(alertMngBasePage.getAlertDetailsPageTitle().contains(map.get("AlertID")));
        test.pass("Alert #"+map.get("AlertID")+" : Details is displayed");
        driver.switchTo().window(handlesList.get(0));


    }
}
