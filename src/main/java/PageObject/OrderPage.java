package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    //Дополнительно задание

    //Ошибки полей первой части заказа

    private final By NAME_ERROR_MESSAGE = By.xpath(".//div[text()='Введите корректное имя']");
    private final By SURNAME_ERROR_MESSAGE = By.xpath(".//div[text()='Введите корректную фамилию']");
    private final By ADDRESS_ERROR_MESSAGE = By.xpath(".//div[text()='Введите корректный адрес']");
    private final By METRO_ERROR_MESSAGE = By.xpath(".//div[text()='Выберите станцию']");
    private final By PHONE_ERROR_MESSAGE = By.xpath(".//div[text()='Введите корректный номер']");

    //Ошибки полей второй части заказа.
    //Оставил поля не заполненные потому что нет ошибок во второй части заказа
    private final By DATE_ERROR_MESSAGE = By.xpath("___");
    private final By RENTAL_PERIOD_ERROR_MESSAGE = By.xpath("___");

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


    public void checkCompleteSetOrder() {
        //Проверка наличия элемента "Хотите оформить заказ?"
        driver.findElement(By.className("Order_ModalHeader__3FDaJ")).isEnabled();
        //Нахождение и нажатие кнопки "Да"
        By buttonYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
        driver.findElement(buttonYes).click();
    }

    public void clickAndSetMetroDropdown(String dropdownValue) {
        driver.findElement(METRO_DROPDOWN).sendKeys(dropdownValue);
        driver.findElement(METRO_DROPDOWN_VALUE).click();
    }

    public void clickAndSetDate(int option) {
        driver.findElement(INPUT_DATE).click();
        By setDate;
        switch (option) {
            case 1:
                // 1 июля 2025
                setDate = By.xpath(".//*[contains(@class,'react-datepicker__day react-datepicker__day--001')]");
                driver.findElement(setDate).click();
                break;
            case 2:
                // 2 июля 2025
                setDate = By.xpath(".//*[contains(@class,'react-datepicker__day react-datepicker__day--002')]");
                driver.findElement(setDate).click();
                break;
        }
    }

    public void clickAndSetRentalPeriod(int numberOfDays) {
        driver.findElement(INPUT_RENTAL_PERIOD).click();
        By setDay;
        switch (numberOfDays) {
            case 1:
                setDay = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");
                driver.findElement(setDay).click();
                break;
            case 2:
                setDay = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");
                driver.findElement(setDay).click();
                break;
            case 3:
                setDay = By.xpath(".//div[@class='Dropdown-option' and text()='трое суток']");
                driver.findElement(setDay).click();
                break;
            case 4:
                setDay = By.xpath(".//div[@class='Dropdown-option' and text()='четверо суток']");
                driver.findElement(setDay).click();
                break;
            case 5:
                setDay = By.xpath(".//div[@class='Dropdown-option' and text()='пятеро суток']");
                driver.findElement(setDay).click();
                break;
            case 6:
                setDay = By.xpath(".//div[@class='Dropdown-option' and text()='шестеро суток']");
                driver.findElement(setDay).click();
                break;
            case 7:
                setDay = By.xpath(".//div[@class='Dropdown-option' and text()='семеро суток']");
                driver.findElement(setDay).click();
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
        //Проверка наличия "номера заказа"
        boolean isEnable = false;
        WebElement isOrderNumber = driver.findElement(By.className("Order_Text__2broi"));
        if (isOrderNumber.isDisplayed()) {
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
