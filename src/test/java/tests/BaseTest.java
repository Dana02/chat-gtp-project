package tests;

import org.example.pages.BingChatPage;
import org.example.pages.BingHomePage;
import org.example.pages.BingSearchResultPage;
import org.example.pages.BingSettingsPage;
import org.testng.annotations.AfterSuite;

public class BaseTest {
    protected BingHomePage bingHomePage;
    protected BingSearchResultPage bingSearchResultPage;
    protected BingChatPage bingChatPage;
    protected BingSettingsPage bingSettingsPage;
}
