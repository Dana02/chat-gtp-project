package org.example.pages;

import org.example.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BingSettingsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Hypothetical locator for settings page
    private By settingsPageLocator = By.xpath("//h2[text()='Settings']");

    public BingSettingsPage() {
        this.driver = DriverFactory.getInstance().getDriver();
        wait = new WebDriverWait(driver, 5);
    }

    public boolean isSettingsPageDisplayed() {
        WebElement settingsPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(settingsPageLocator));
        return settingsPageElement.isDisplayed();
    }
}
