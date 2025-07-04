package ru.poketa.scooter.data;


import org.openqa.selenium.By;

public class TestData {

    //Данные для поля с датой
    // 1 июля 2025
    private final By DATE_1_JUNE_2025 = By.xpath(".//*[contains(@class,'react-datepicker__day react-datepicker__day--001')]");
    // 2 июля 2025
    private final By DATE_2_JUNE_2025 = By.xpath(".//*[contains(@class,'react-datepicker__day react-datepicker__day--002')]");

    //Данные для поля выбора кол-ва дней

    private final By NUMBER_OF_DAYS_1 = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");
    private final By NUMBER_OF_DAYS_2 = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");
    private final By NUMBER_OF_DAYS_3 = By.xpath(".//div[@class='Dropdown-option' and text()='трое суток']");
    private final By NUMBER_OF_DAYS_4 = By.xpath(".//div[@class='Dropdown-option' and text()='четверо суток']");
    private final By NUMBER_OF_DAYS_5 = By.xpath(".//div[@class='Dropdown-option' and text()='пятеро суток']");
    private final By NUMBER_OF_DAYS_6 = By.xpath(".//div[@class='Dropdown-option' and text()='шестеро суток']");
    private final By NUMBER_OF_DAYS_7 = By.xpath(".//div[@class='Dropdown-option' and text()='семеро суток']");

    //Данные полей для теста ошибок полей
    private String name;
    private String surname;
    private String address;
    private String dropdownValue;
    private String Phone;

    //Геттеры

    public By getDATE_1_JUNE_2025() {
        return DATE_1_JUNE_2025;
    }

    public By getDATE_2_JUNE_2025() {
        return DATE_2_JUNE_2025;
    }

    public By getNUMBER_OF_DAYS_1() {
        return NUMBER_OF_DAYS_1;
    }

    public By getNUMBER_OF_DAYS_2() {
        return NUMBER_OF_DAYS_2;
    }

    public By getNUMBER_OF_DAYS_3() {
        return NUMBER_OF_DAYS_3;
    }

    public By getNUMBER_OF_DAYS_4() {
        return NUMBER_OF_DAYS_4;
    }

    public By getNUMBER_OF_DAYS_5() {
        return NUMBER_OF_DAYS_5;
    }

    public By getNUMBER_OF_DAYS_6() {
        return NUMBER_OF_DAYS_6;
    }

    public By getNUMBER_OF_DAYS_7() {
        return NUMBER_OF_DAYS_7;
    }

    //Геттеры и сеттеры для теста ошибок полей

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDropdownValue() {
        return dropdownValue;
    }

    public void setDropdownValue(String dropdownValue) {
        this.dropdownValue = dropdownValue;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

}
