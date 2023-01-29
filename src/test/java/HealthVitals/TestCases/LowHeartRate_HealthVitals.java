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

public class LowHeartRate_HealthVitals extends BasePage {

    LoginPage loginPage;
    HealthAnalyticsPage healthAnalyticsPage;
    HealthVitalsPage healthVitalsPage;
    TestUtils utilswrite;
    GenerateAlerts alerts;
    AlertWindowPage alertWindowPage;
    AlertMngBasePage AlertBasePage;
    HealthVitalsListPage healthVitalsListPage;
    AlertMngBasePage alertMngBasePage;
    WorkerAlertsPage workerAlertsPage;
    WorkerBasePage workerBasePage;
    AlertPage alertPage;

    public int DataSet = -1;

    public LowHeartRate_HealthVitals() throws IOException {
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
        Object data[][] = TestUtils.dataSupplier("LowHeartRate",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("HealthAlerts"));
        return data;
    }
    @testrail(id="17454")
    @Test(dataProvider="getExcelData",priority = 0)
    public void ValidateUpdatedLowHeartRate(Map<String, String> map) throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException {
        DataSet++;
        test = extent.createTest("Health Vitals -- Validate Updated High Heart Rate dashboard after send Alert");
        loginPage.dashboardLink();
        healthAnalyticsPage.healthVitalsLink();
        healthVitalsPage.SelectSite(map.get("Site"));
        Thread.sleep(2000);
        int LowTempCountb4 = Integer.parseInt(healthAnalyticsPage.LowHeartRateCount());
        test.pass("Low Temp Alerts Count before :"+LowTempCountb4);
        if(alerts.generateHealthVitalsAlert(map.get("deviceID"),map.get("bpHigh"),map.get("bpLow"),map.get("bpHeart"),map.get("temp"),map.get("lat"),map.get("lon"))){
            test.pass("Send api request "+map.get("AlertType")+" Alert");
            if (prop.getProperty("AlertPopWindowEnabled").equals("true")){
                if (!alertWindowPage.VerifyAlertWindowDisplayed()){
                    test.fail(map.get("AlertType")+" Alert is not displayed");
                    Assert.fail(map.get("AlertType")+" Alert is not displayed");
                }
                test.pass(map.get("AlertType")+" Alert is displayed");
                alertWindowPage.validateAlertType(map.get("AlertType"));
                test.pass("Alert type :"+map.get("AlertType"));
                String alertID = alertWindowPage.getAlertID_type().replaceAll("[^0-9]", "");
                utilswrite.WriteInExcel(alertID, DataSet+1, "LowHeartRate","AlertID",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("HealthAlerts"));
                alertWindowPage.CloseAlert();

            }else{
                String alertID = LastAlertQueryTest.CheckCreatedIncident(map.get("TypeID"));
                utilswrite.WriteInExcel(alertID, DataSet+1, "LowHeartRate","AlertID",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("HealthAlerts"));

            }
            healthVitalsPage.Refresh();
            healthVitalsPage.SelectSite(map.get("Site"));
            Thread.sleep(2000);
            //Validate Count number is increased by 1
            int LowTempCountAfter = Integer.parseInt(healthAnalyticsPage.LowHeartRateCount());
            if(LowTempCountAfter == LowTempCountb4+1) {
                test.pass("Validate the dashboard data is updated ");
            }else {
                test.fail("The dashboard data : Low Skin Temperature Count is not updated");
            }

        }else{
            test.fail("Send api request for "+map.get("AlertType")+" Alert Failed");
            Assert.fail("Send api request for "+map.get("AlertType")+" Alert Failed");

        }

    }

    @testrail(id="17081,17167")
    @Test(dataProvider="getExcelData",priority = 1)
    public void ValidateUpdatedLowHeartRateList(Map<String, String> map) throws InterruptedException, IOException {
        DataSet++;

        test = extent.createTest("Health Vitals -- Send "+map.get("AlertType")+" Alert");

        loginPage.dashboardLink();
        healthAnalyticsPage.healthVitalsLink();
        healthVitalsPage.SelectSite(map.get("Site"));
        Thread.sleep(2000);
        healthAnalyticsPage.LowHeartRateClick();
        Assert.assertTrue(healthVitalsListPage.ValidatePageTitle());


    }
    @testrail(id="17814,17816")
    @Test(dataProvider="getExcelData",priority = 2)
    public void ValidateLowHeartRateAlert(Map<String, String> map) throws InterruptedException, IOException {
        DataSet++;
        driver.navigate().refresh();
        test = extent.createTest("Alert Management -- Validate Low Heart Rate Alert : "+map.get("AlertID"));
        test.assignCategory("Alert Management");
        if(!alertMngBasePage.AlertMng()){
            test.fail("Failed Navigate to Alert Management Link");
            Assert.fail("Failed Navigate to Alert Management Link");
        }
        if(!alertMngBasePage.Search(map.get("AlertID"))){
            test.fail("Failed Search for Alert ID"+map.get("AlertID"));
            Assert.fail("Failed Search for Alert ID"+map.get("AlertID"));
        }
        if(!alertMngBasePage.openAlertDetailsPage()){
            test.fail("Failed Open details for Alert ID"+map.get("AlertID"));
            Assert.fail("Failed Open details for Alert ID"+map.get("AlertID"));
        } else {
            Assert.assertTrue(alertMngBasePage.getAlertDetailsPageTitle().contains(map.get("AlertID")));
            test.pass("Alert Details is displayed");
        }

    }
    @testrail(id="17123,17083")
    @Test(dataProvider = "getExcelData",priority = 3)
    public void ValidateWorkerProfile(Map<String, String> map) throws InterruptedException, IOException, AWTException {
        DataSet++;
        driver.navigate().refresh();
        test = extent.createTest("Worker Profile Health Vitals -- Validate Alert grid for alert : "+map.get("AlertID"));
        test.assignCategory("Worker Profile");
        if (!workerBasePage.WorkersModule()){
            test.fail("Failed Navigate to Worker page");
            Assert.fail("Failed Navigate to Worker page");
        }
        test.pass("Navigate to Worker page");
        if(!workerBasePage.AssignedSmartWatch(map.get("deviceID"))){
            test.fail("Failed Search for Worker By Device UID : "+map.get("deviceID"));
            Assert.fail("Failed Search for Worker By Device UID : "+map.get("deviceID"));
        }
        test.pass("Search for Worker By Device UID : "+map.get("deviceID"));
        Thread.sleep(2000);
        if (!workerBasePage.ClickFirstWorker())
        {
            test.fail("Failed Open Worker page");
            Assert.fail("Failed Open Worker page");
        }
        test.pass("Open Worker page");
        if(!workerAlertsPage.AlertsSectionDisplayed())
        {
            test.fail("Alert section is not displayed");
            Assert.fail("Alert section is not displayed");
        }
        test.pass("Alert section displayed");
        Thread.sleep(2000);
        if (!workerAlertsPage.clickExpandAlertButton()) {
            test.fail("Alert section is not Expanded");
            Assert.fail("Alert section is not Expanded");
        }
        test.pass("Alert section is Expanded");
        Thread.sleep(2000);
        if(!workerAlertsPage.ClickAlert(map.get("AlertID"))){
            test.fail("Alert : "+map.get("AlertID")+" is not Clicked");
            Assert.fail("Alert : "+map.get("AlertID")+" is not Clicked");
        }
        test.pass("Alert : "+map.get("AlertID")+" is Clicked");
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
        if (!alertPage.dashboardLink()) {
            test.fail("Failed Navigated to Dashboard Page");
            Assert.fail("Failed Navigated to Dashboard Page");
        }
        test.pass("Navigated to Dashboard Page");
        if (!alertPage.SelectSite(map.get("Site"))){
            test.fail("Failed Select the site : "+map.get("Site"));
            Assert.fail("Failed Select the site : "+map.get("Site"));
        }
        test.pass("Filter Site : "+map.get("Site")+" alert");
        Thread.sleep(2000);
        if(!alertPage.AlertClick(map.get("AlertID"))){
            test.fail("Failed Click the alert : "+map.get("AlertID"));
            Assert.fail("Failed Click the alert : "+map.get("AlertID"));
        }
        test.pass("Click Alert: "+map.get("AlertID"));
        Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);
        driver.switchTo().window(handlesList.get(handlesList.size()-1));
        Thread.sleep(2000);
        Assert.assertTrue(alertMngBasePage.getAlertDetailsPageTitle().contains(map.get("AlertID")));
        test.pass("Alert #"+map.get("AlertID")+" : Details is displayed");
        driver.switchTo().window(handlesList.get(0));


    }

    }
