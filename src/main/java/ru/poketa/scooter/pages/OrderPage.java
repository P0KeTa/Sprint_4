package ru.poketa.scooter.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.poketa.scooter.data.TestData;

import java.time.Duration;
import java.util.Objects;

public class OrderPage extends MainPage {

    //Поля первой части полей заказа

    //Поле Имя
    private final By INPUT_NAME = By.xpath(".//input[@placeholder='* Имя']");
    //Поле Фамилия
    private final By INPUT_SURNAME = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле Адрес
    private final By INPUT_ADDRESS = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поля Метро и значения
    private final By METRO_DROPDOWN = By.xpath(".//input[@class='select-search__input']");
    private final By METRO_DROPDOWN_VALUE = By.xpath(".//div[@class='select-search__select']");
    //Поле Телефон
    private final By INPUT_PHONE = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private final By COMPLETE_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Поля второй части полей заказа

    //Поле Дата
    private final By INPUT_DATE = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле периода дней
    private final By INPUT_RENTAL_PERIOD = By.xpath(".//div[@class='Dropdown-placeholder']");
    //Поля чекбокса цвета (не обязательные)
    private final By CHECKBOX_BLACK = By.xpath(".//input[@id='black']");
    private final By CHECKBOX_GREY = By.xpath(".//input[@id='grey']");
    //Поле Комментария для курьера (не обязательное)
    private final By INPUT_TEXT_FOR_COURIER = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка Заказать
    private final By DONE_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Элемент "Хотите оформить заказ?"
    private final By WINDOWS_CHECK_PLACE_ORDER = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Хотите оформить заказ?']");
    //кнопка Да
    private final By BUTTON_YES = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //Окно с номером заказа
    private final By COMPLETE_ORDER_WINDOW = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    //Дополнительно задание

    //Ошибки полей первой части заказа

    private final By NAME_ERROR_MESSAGE = By.xpath(".//div[text()='Введите корректное имя']");
    private final By SURNAME_ERROR_MESSAGE = By.xpath(".//div[text()='Введите корректную фамилию']");
    private final By ADDRESS_ERROR_MESSAGE = By.xpath(".//div[text()='Введите корректный адрес']");
    private final By METRO_ERROR_MESSAGE = By.xpath(".//div[text()='Выберите станцию']");
    private final By PHONE_ERROR_MESSAGE = By.xpath(".//div[text()='Введите корректный номер']");

    //Ошибки полей второй части заказа.

    /*Оставил поля не заполненные потому что нет ошибок во второй части заказа
    private final By DATE_ERROR_MESSAGE = By.xpath("___");
    private final By RENTAL_PERIOD_ERROR_MESSAGE = By.xpath("___");*/

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void setOrderAndClickButton1(String name, String surname, String address, String dropdownValue, String phone) {
        driver.findElement(INPUT_NAME).sendKeys(name);
        driver.findElement(INPUT_SURNAME).sendKeys(surname);
        driver.findElement(INPUT_ADDRESS).sendKeys(address);
        clickAndSetMetroDropdown(dropdownValue);
        driver.findElement(INPUT_PHONE).sendKeys(phone);
        driver.findElement(COMPLETE_BUTTON).click();
    }

    public void setOrderAndClickButton2(int option, int numberOfDays, String color, String textForCourier) {
        new WebDriverWait(driver, Duration.ofSeconds(5));
        clickAndSetDate(option);
        clickAndSetRentalPeriod(numberOfDays);
        if (Objects.equals(color, "Чёрный")) {
            setDropdown(getCHECKBOX_BLACK());
        } else if (Objects.equals(color, "Серый")) {
            setDropdown(getCHECKBOX_GREY());
        } else if (Objects.equals(color, "Чёрный и серый")) {
            setDropdown(getCHECKBOX_BLACK());
            setDropdown(getCHECKBOX_GREY());
        }
        driver.findElement(INPUT_TEXT_FOR_COURIER).sendKeys(textForCourier);
        driver.findElement(DONE_BUTTON).click();
    }

    public boolean checkCompleteSetOrder() {
        return driver.findElement(WINDOWS_CHECK_PLACE_ORDER).isEnabled();
    }

    public void clickBUTTON_YES(){
        driver.findElement(BUTTON_YES).click();
    };

    public void clickAndSetMetroDropdown(String dropdownValue) {
        driver.findElement(METRO_DROPDOWN).sendKeys(dropdownValue);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(METRO_DROPDOWN_VALUE)).click().perform();

    }

    public void clickAndSetDate(int option) {
        driver.findElement(INPUT_DATE).click();
        TestData objTestData = new TestData();
        switch (option) {
            case 1:
                driver.findElement(objTestData.getDATE_1_JUNE_2025()).click();
                break;
            case 2:
                driver.findElement(objTestData.getDATE_2_JUNE_2025()).click();
                break;
        }
    }

    public void clickAndSetRentalPeriod(int numberOfDays) {
        driver.findElement(INPUT_RENTAL_PERIOD).click();
        TestData objTestData = new TestData();
        switch (numberOfDays) {
            case 1:
                driver.findElement(objTestData.getNUMBER_OF_DAYS_1()).click();
                break;
            case 2:
                driver.findElement(objTestData.getNUMBER_OF_DAYS_2()).click();
                break;
            case 3:
                driver.findElement(objTestData.getNUMBER_OF_DAYS_3()).click();
                break;
            case 4:
                driver.findElement(objTestData.getNUMBER_OF_DAYS_4()).click();
                break;
            case 5:
                driver.findElement(objTestData.getNUMBER_OF_DAYS_5()).click();
                break;
            case 6:
                driver.findElement(objTestData.getNUMBER_OF_DAYS_6()).click();
                break;
            case 7:
                driver.findElement(objTestData.getNUMBER_OF_DAYS_7()).click();
                break;
        }
    }

    public By getCHECKBOX_BLACK() {
        return CHECKBOX_BLACK;
    }

    public By getCHECKBOX_GREY() {
        return CHECKBOX_GREY;
    }

    public void setDropdown(By checkbox) {
        driver.findElement(checkbox).click();
    }

    public boolean checkOrderComplete() {
        boolean isEnable = false;
        WebElement orderNumber = driver.findElement(COMPLETE_ORDER_WINDOW);
        if (orderNumber.isDisplayed()) {
            isEnable = true;
            return isEnable;
        }
        return isEnable;
    }

    //Дополнительное задание

    public void clickCOMPLETE_BUTTON() {
        driver.findElement(COMPLETE_BUTTON).click();
    }

    public boolean checkErrorNameMessage() {
        return driver.findElement(NAME_ERROR_MESSAGE).isDisplayed();
    }

    public boolean checkErrorSurnameMessage() {
        return driver.findElement(SURNAME_ERROR_MESSAGE).isDisplayed();
    }

    public boolean checkErrorAddressMessage() {
        return driver.findElement(ADDRESS_ERROR_MESSAGE).isDisplayed();
    }

    public boolean checkErrorMetroMessage() {
        return driver.findElement(METRO_ERROR_MESSAGE).isDisplayed();
    }

    public boolean checkErrorPhoneMessage() {
        return driver.findElement(PHONE_ERROR_MESSAGE).isDisplayed();
    }


}
