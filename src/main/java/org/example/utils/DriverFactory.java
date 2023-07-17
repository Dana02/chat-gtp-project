package org.example.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static DriverFactory instance = null;
    ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    private DriverFactory() {
        // private to restrict initialization
    }

    public static DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public final void setDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver.set(new ChromeDriver());
    }

    public WebDriver getDriver() {
        return webDriver.get();
    }

    public final void removeDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}
