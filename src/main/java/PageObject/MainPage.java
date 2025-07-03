package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class MainPage {

    protected final WebDriver driver;
    //Стрелка блока "Вопросы о важном"
    private final By BUTTON_QUESTIONS = By.xpath(".//div[@id='accordion__heading-0']");
    //Верхняя кнопка заказа (справа сверху)
    private final By TOP_ORDER_BUTTON = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //Нижняя кнопка заказа (нужно сделать скрол вниз)
    private final By SCROLL_ORDER_BUTTON = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка куки файлов
    private final By COOKIE_BUTTON = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    //Дополнительные задания
    //Логотип Самоката
    private final By SCOOTER_LOGO = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']");
    //Логотип Яндекс
    private final By YANDEX_LOGO = By.xpath(".//a[@class='Header_LogoYandex__3TSOI']");
    //Кнопка статуса заказа
    private final By STATUS_ORDER_BUTTON = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Header_Link__1TAG7']");
    //Поле ввода номера заказа
    private final By NUMBER_FIELD_ORDER = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
    //Кнопка Go
    private final By GO_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");
    //Номер заказа
    private final String ORDER_NUMBER = null;

    //Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Ждём пока поле появится, скролим до него и кликаем по нему
    public void clickButtonQuestions() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(BUTTON_QUESTIONS));
        WebElement element = driver.findElement(BUTTON_QUESTIONS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , element);
        driver.findElement(BUTTON_QUESTIONS).click();
    }

    //Проверка, что после клика появился текст
    public boolean checkClickButtonQuestions() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(BUTTON_QUESTIONS));
        WebElement dropdownText = driver.findElement(BUTTON_QUESTIONS);
        return dropdownText.isDisplayed();
    }

    //Скрол и клик / клик сразу на кнопку Заказать (зависит от выбранного параметра)
    public void clickOrderButton(String option) {
        if (Objects.equals(option, "top")) {
            driver.findElement(TOP_ORDER_BUTTON).click();
        } else if (Objects.equals(option, "down")) {
            WebElement element = driver.findElement(SCROLL_ORDER_BUTTON);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                    , element);
            driver.findElement(SCROLL_ORDER_BUTTON).click();
        }
    }

    //Нажатие на кнопку принятия Куки
    public void clickCookieButton() {
        if (driver.findElement(COOKIE_BUTTON).isEnabled()) {
            driver.findElement(COOKIE_BUTTON).click();
        }
    }

    //Дополнительно задание

    //Клик на лого Самокат
    public void clickScooterLogo() {
        driver.findElement(SCOOTER_LOGO).click();
    }

    //Клик на лого Яндекс
    public void clickYandexLogo() {
        driver.findElement(YANDEX_LOGO).click();
    }

    //Клик по кнопке Статуса Заказа и ввод в поле номера заказа
    public void clickStatusOrderButtonAndSetFieldOrderNumber(String orderNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(STATUS_ORDER_BUTTON).click();
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(NUMBER_FIELD_ORDER));
        input.sendKeys(orderNumber);
    }

    //Клик по кнопке Go
    public void clickGoButton() {
        driver.findElement(GO_BUTTON).click();
    }



}
