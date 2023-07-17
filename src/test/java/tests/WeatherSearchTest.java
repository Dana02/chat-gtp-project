package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.BingChatPage;
import org.example.pages.BingHomePage;
import org.example.pages.BingSearchResultPage;
import org.example.utils.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WeatherSearchTest extends BaseTest {
    private Logger logger = LogManager.getLogger(WeatherSearchTest.class);
    @BeforeClass(alwaysRun = true)
    public void setUpData() {
        logger.info("Setting up WebDriver and navigating to Bing homepage");
        DriverFactory.getInstance().setDriver(); // initialize the driver
        DriverFactory.getInstance().getDriver().get("https://www.bing.com/");
        bingHomePage = new BingHomePage();
        bingSearchResultPage = new BingSearchResultPage();
        bingHomePage.selectEnglishLanguage();
        bingHomePage.acceptCookies();
    }

    @Test(description = "Check weather in Lviv")
    @Description("Test Description: Search for 'weather in Lviv' and check if the results are displayed.")
    @Severity(SeverityLevel.NORMAL)
    public void testWeatherSearch() {
        logger.info("Starting test: testWeatherSearch");
        bingHomePage.search("weather in Lviv");
        boolean isWeatherInfoDisplayed = bingSearchResultPage.isWeatherInfoDisplayed();
        Assert.assertTrue(isWeatherInfoDisplayed, "Weather information is not displayed");
        logger.info("Ending test: testWeatherSearch");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        logger.info("Quiting WebDriver");
        DriverFactory.getInstance().removeDriver(); // quit the driver
    }
}
