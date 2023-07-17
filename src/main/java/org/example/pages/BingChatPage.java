package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BingChatPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger = LogManager.getLogger(BingChatPage.class);
    private By chatPopupLocator = By.xpath("//div[@id='sydneyPayWall_Content']");

    public BingChatPage() {
        this.driver = DriverFactory.getInstance().getDriver();
        wait = new WebDriverWait(driver, 5);
    }

    public boolean isChatPopupDisplayed() {
        WebElement chatPopupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(chatPopupLocator));
        return chatPopupElement.isDisplayed();
    }
}
