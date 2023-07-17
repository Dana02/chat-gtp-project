package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.BingChatPage;
import org.example.pages.BingHomePage;
import org.example.utils.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChatLinkTest extends BaseTest {
    private Logger logger = LogManager.getLogger(ChatLinkTest.class);

    @BeforeClass(alwaysRun = true)
    public void setUpData() {
        logger.info("Setting up WebDriver and navigating to Bing homepage");
        DriverFactory.getInstance().setDriver(); // initialize the driver
        DriverFactory.getInstance().getDriver().get("https://www.bing.com/");
        bingHomePage = new BingHomePage();
        bingChatPage = new BingChatPage();
        bingHomePage.selectEnglishLanguage();
        bingHomePage.acceptCookies();
    }

    @Test(description = "Check chat link")
    @Description("Test Description: Click on chat link and verify pop-up information window.")
    @Severity(SeverityLevel.NORMAL)
    public void testChatLink() {
        logger.info("Starting test: testChatLink");
        bingHomePage.clickChatLink();
        boolean isChatPopupDisplayed = bingChatPage.isChatPopupDisplayed();
        Assert.assertTrue(isChatPopupDisplayed, "Chat popup is not displayed");
        logger.info("Ending test: testChatLink");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        logger.info("Quiting WebDriver");
        DriverFactory.getInstance().removeDriver(); // quit the driver
    }
}
