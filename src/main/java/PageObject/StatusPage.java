package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class StatusPage extends MainPage{

    private final By NOT_FOUND_IMG = By.xpath(".//img[@alt='Not found']");

    public StatusPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkNotFoundImg() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver.findElement(NOT_FOUND_IMG).isDisplayed();
    }



}
