package ru.poketa.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class StatusPage extends MainPage{

    private final By NOT_FOUND_IMG = By.xpath(".//img[@alt='Not found']");

    public StatusPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkNotFoundImg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(NOT_FOUND_IMG));
        return element.isDisplayed();
    }



}
