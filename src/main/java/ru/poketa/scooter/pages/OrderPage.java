package ru.poketa.scooter.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class OrderPage extends MainPage {

    //Поля первой части полей заказа

    //Поле Имя
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");
    //Поле Фамилия
    private final By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле Адрес
    private final By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поля Метро и значения
    private final By metroDropdown = By.xpath(".//input[@class='select-search__input']");
    private final By metroDropdownValue = By.xpath(".//div[@class='select-search__select']");
    //Поле Телефон
    private final By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private final By completeButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Поля второй части полей заказа

    //Поле Дата
    private final By inputDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле периода дней
    private final By inputRentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");
    //Поля чекбокса цвета (не обязательные)
    private final By checkboxBlack = By.xpath(".//input[@id='black']");
    private final By checkboxGrey = By.xpath(".//input[@id='grey']");
    //Поле Комментария для курьера (не обязательное)
    private final By inputTextForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка Заказать
    private final By doneButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Элемент "Хотите оформить заказ?"
    private final By windowsCheckPlaceOrder = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Хотите оформить заказ?']");
    //кнопка Да
    private final By buttonYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //Окно с номером заказа
    private final By completeOrderWindow = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    //Дополнительно задание

    //Ошибки полей первой части заказа

    private final By nameErrorMessage = By.xpath(".//div[text()='Введите корректное имя']");
    private final By surnameErrorMessage = By.xpath(".//div[text()='Введите корректную фамилию']");
    private final By addressErrorMessage = By.xpath(".//div[text()='Введите корректный адрес']");
    private final By metroErrorMessage = By.xpath(".//div[text()='Выберите станцию']");
    private final By phoneErrorMessage = By.xpath(".//div[text()='Введите корректный номер']");

    //Данные для поля с датой
    // 1 июля 2025
    private final By date1June2025 = By.xpath(".//*[contains(@class,'react-datepicker__day react-datepicker__day--001')]");
    // 2 июля 2025
    private final By date2June2025 = By.xpath(".//*[contains(@class,'react-datepicker__day react-datepicker__day--002')]");

    //Данные для поля выбора кол-ва дней

    private final By numberOfDaysOne = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");
    private final By numberOfDaysTwo = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");
    private final By numberOfDaysThree = By.xpath(".//div[@class='Dropdown-option' and text()='трое суток']");
    private final By numberOfDaysFour = By.xpath(".//div[@class='Dropdown-option' and text()='четверо суток']");
    private final By numberOfDaysFive = By.xpath(".//div[@class='Dropdown-option' and text()='пятеро суток']");
    private final By numberOfDaysSix = By.xpath(".//div[@class='Dropdown-option' and text()='шестеро суток']");
    private final By numberOfDaysSeven = By.xpath(".//div[@class='Dropdown-option' and text()='семеро суток']");

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void setOrder1(String name, String surname, String address, String dropdownValue, String phone) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputSurname).sendKeys(surname);
        driver.findElement(inputAddress).sendKeys(address);
        clickAndSetMetroDropdown(dropdownValue);
        driver.findElement(inputPhone).sendKeys(phone);
    }

    public void clickCompleteButton() {
        driver.findElement(completeButton).click();
    }

    public void setOrder2(int option, int numberOfDays, String color, String textForCourier) {
        new WebDriverWait(driver, Duration.ofSeconds(5));
        clickAndSetDate(option);
        clickAndSetRentalPeriod(numberOfDays);
        if (Objects.equals(color, "Чёрный")) {
            setDropdown(getCheckboxBlack());
        } else if (Objects.equals(color, "Серый")) {
            setDropdown(getCheckboxGrey());
        } else if (Objects.equals(color, "Чёрный и серый")) {
            setDropdown(getCheckboxBlack());
            setDropdown(getCheckboxGrey());
        }
        driver.findElement(inputTextForCourier).sendKeys(textForCourier);
    }

    public void clicDonekButton() {
        driver.findElement(doneButton).click();
    }

    public boolean checkCompleteSetOrder() {
        return driver.findElement(windowsCheckPlaceOrder).isEnabled();
    }

    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }

    public void clickAndSetMetroDropdown(String dropdownValue) {
        driver.findElement(metroDropdown).sendKeys(dropdownValue);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(metroDropdownValue)).click().perform();

    }

    public void clickAndSetDate(int option) {
        driver.findElement(inputDate).click();
        switch (option) {
            case 1:
                driver.findElement(getDate1June2025()).click();
                break;
            case 2:
                driver.findElement(getDate2June2025()).click();
                break;
        }
    }

    public void clickAndSetRentalPeriod(int numberOfDays) {
        driver.findElement(inputRentalPeriod).click();
        switch (numberOfDays) {
            case 1:
                driver.findElement(getNumberOfDaysOne()).click();
                break;
            case 2:
                driver.findElement(getNumberOfDaysTwo()).click();
                break;
            case 3:
                driver.findElement(getNumberOfDaysThree()).click();
                break;
            case 4:
                driver.findElement(getNumberOfDaysFour()).click();
                break;
            case 5:
                driver.findElement(getNumberOfDaysFive()).click();
                break;
            case 6:
                driver.findElement(getNumberOfDaysSix()).click();
                break;
            case 7:
                driver.findElement(getNumberOfDaysSeven()).click();
                break;
        }
    }

    public void setDropdown(By checkbox) {
        driver.findElement(checkbox).click();
    }

    //Геттеры

    public By getCheckboxBlack() {
        return checkboxBlack;
    }

    public By getCheckboxGrey() {
        return checkboxGrey;
    }

    public By getDate1June2025() {
        return date1June2025;
    }

    public By getDate2June2025() {
        return date2June2025;
    }

    public By getNumberOfDaysOne() {
        return numberOfDaysOne;
    }

    public By getNumberOfDaysTwo() {
        return numberOfDaysTwo;
    }

    public By getNumberOfDaysThree() {
        return numberOfDaysThree;
    }

    public By getNumberOfDaysFour() {
        return numberOfDaysFour;
    }

    public By getNumberOfDaysFive() {
        return numberOfDaysFive;
    }

    public By getNumberOfDaysSix() {
        return numberOfDaysSix;
    }

    public By getNumberOfDaysSeven() {
        return numberOfDaysSeven;
    }

    public boolean checkOrderComplete() {
        boolean isEnable = false;
        WebElement orderNumber = driver.findElement(completeOrderWindow);
        if (orderNumber.isDisplayed()) {
            isEnable = true;
            return isEnable;
        }
        return isEnable;
    }

    //Дополнительное задание

    public boolean checkErrorNameMessage() {
        return driver.findElement(nameErrorMessage).isDisplayed();
    }

    public boolean checkErrorSurnameMessage() {
        return driver.findElement(surnameErrorMessage).isDisplayed();
    }

    public boolean checkErrorAddressMessage() {
        return driver.findElement(addressErrorMessage).isDisplayed();
    }

    public boolean checkErrorMetroMessage() {
        return driver.findElement(metroErrorMessage).isDisplayed();
    }

    public boolean checkErrorPhoneMessage() {
        return driver.findElement(phoneErrorMessage).isDisplayed();
    }
}