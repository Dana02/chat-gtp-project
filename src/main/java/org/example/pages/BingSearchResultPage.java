package org.example.pages;

import org.example.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BingSearchResultPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Hypothetical locator for weather information on the search result page
    private By weatherInfoLocator = By.xpath("//div[@id='wtr_cardContainer']");

    public BingSearchResultPage() {
        this.driver = DriverFactory.getInstance().getDriver();
        wait = new WebDriverWait(driver, 5);
    }

    public boolean isWeatherInfoDisplayed() {
        WebElement weatherInfoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(weatherInfoLocator));
        return weatherInfoElement.isDisplayed();
    }
}
