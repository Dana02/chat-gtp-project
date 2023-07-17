package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BingHomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger = LogManager.getLogger(BingHomePage.class);

    private By searchBox = By.id("sb_form_q");
    private By searchButton = By.id("search_icon");
    private By chatLink = By.id("codex");
    private By hamburgerMenu = By.id("id_sc");
    private By settings = By.xpath("//div[text()='Settings']");
    private By more = By.xpath("//div[text()='More']");
    private By englishLanguageButton = By.xpath("//a[text()='English']");
    private By acceptCookiesButton = By.xpath("//a[text()='Accept']");

    public BingHomePage() {
        this.driver = DriverFactory.getInstance().getDriver();
        wait = new WebDriverWait(driver, 5);
    }

    public void enterSearchTerm(String searchTerm) {
        driver.findElement(searchBox).sendKeys(searchTerm);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public void search(String searchTerm) {
        enterSearchTerm(searchTerm);
        clickSearch();
    }

    public void clickChatLink() {
        driver.findElement(chatLink).click();
    }

    public void navigateToSettings() {
        WebElement hamburgerMenuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenu));
        hamburgerMenuElement.click();

        WebElement settingsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(settings));
        settingsElement.click();

        WebElement moreElement = wait.until(ExpectedConditions.visibilityOfElementLocated(more));
        moreElement.click();
    }

    public void selectEnglishLanguage() {
        WebElement englishLanguageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(englishLanguageButton));
        englishLanguageElement.click();
    }

    public void acceptCookies() {
        WebElement acceptCookiesElement = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookiesButton));
        acceptCookiesElement.click();
    }
}
