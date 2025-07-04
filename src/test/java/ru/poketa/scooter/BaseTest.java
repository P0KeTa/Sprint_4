package ru.poketa.scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.poketa.scooter.pages.MainPage;

import java.time.Duration;
import java.util.Objects;

public class BaseTest {

    WebDriver driver;
    MainPage mainPage;

    @Before
    public void initBrowser() {
        String browser = System.getProperty("browser", "chrome"); // "chrome" — значение по умолчанию
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("firefox")) {
            startBrowserFirefox();
        }
    }

    public void startBrowserFirefox() {
        driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
        mainPage = new MainPage(driver);
    }

    public void startBrowserChrome() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        mainPage = new MainPage(driver);
    }

    public void goPage(String urlPage) {
        driver.get(urlPage);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> Objects.equals(((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState"), "complete")
        );
    }

    public void clickCookieButton() {
        mainPage.clickCookieButton();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
