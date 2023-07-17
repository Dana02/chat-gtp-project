package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.BingHomePage;
import org.example.pages.BingSettingsPage;
import org.example.utils.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SettingsNavigationTest extends BaseTest {

    private Logger logger = LogManager.getLogger(SettingsNavigationTest.class);
    @BeforeClass(alwaysRun = true)
    public void setUpData() {
        logger.info("Setting up WebDriver and navigating to Bing homepage");
        DriverFactory.getInstance().setDriver(); // initialize the driver
        DriverFactory.getInstance().getDriver().get("https://www.bing.com/");
        bingHomePage = new BingHomePage();
        bingSettingsPage = new BingSettingsPage();
        bingHomePage.selectEnglishLanguage();
        bingHomePage.acceptCookies();
    }

    @Test(description = "Check settings navigation")
    @Description("Test Description: Navigate to settings and verify the settings page.")
    @Severity(SeverityLevel.NORMAL)
    public void testSettingsNavigation() {
        logger.info("Starting test: testSettingsNavigation");
        bingHomePage.navigateToSettings();
        boolean isSettingsPageDisplayed = bingSettingsPage.isSettingsPageDisplayed();
        Assert.assertTrue(isSettingsPageDisplayed, "Settings page is not displayed");
        logger.info("Ending test: testSettingsNavigation");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        logger.info("Quiting WebDriver");
        DriverFactory.getInstance().removeDriver(); // quit the driver
    }
}
