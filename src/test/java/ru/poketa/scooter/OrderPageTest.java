package ru.poketa.scooter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.poketa.scooter.pages.MainPage;
import ru.poketa.scooter.pages.OrderPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderPageTest extends BaseTest {


    private OrderPage getOrderPage(String buttonSelect, String name, String surname, String address, String dropdownValue, String phone, int dateValue, int numberOfDaysValue, String colorValue, String textForCourierValue) {
        OrderPage objOrderPage = new OrderPage(driver);
        //Нажимаем кнопку "Заказать" в зависимости от выбора:
        //"top" - кнопка вверну (первая кнопка)
        //"down" - кнопка внизу (вторая кнопка)
        objOrderPage.clickOrderButton(buttonSelect);
        //Ввод валидных данных в поля и нажатие кнопки далее
        objOrderPage.setOrder1(name, surname, address, dropdownValue, phone);
        objOrderPage.clickCompleteButton();
        //Ввод данных в поля второй формы и нажатие кнопки "Заказать"
        //Добавлено 2 опции на выбор даты
        //1 – 1 июля 2025 / 2– 2 июля 2025
        //Значение выбора скора аренда число от 1 до 7 (кол-во дней)
        objOrderPage.setOrder2(dateValue, numberOfDaysValue, colorValue, textForCourierValue);
        objOrderPage.clicDonekButton();
        return objOrderPage;
    }

    //Параметры для переменных
    @ParameterizedTest
    @CsvFileSource(resources = "/dataOrderPageTest.csv")
    //Проверка оформления заказа
    public void orderPageTest(String buttonSelect, String name, String surname, String address, String dropdownValue, String phone, int dateValue, int numberOfDaysValue, String colorValue, String textForCourierValue) {
        MainPage objMainPage = new MainPage(driver);
        //Переход на страницу Яндекс Самокат
        goPage(objMainPage.testPage());
        //Ожидание загрузки страницы
        waitLoadPage(objMainPage.testPage());
        //Нажимаем на кнопку принятия куки (если она есть);
        objMainPage.clickCookieButton();
        //Заполнение полей данными
        OrderPage objOrderPage = getOrderPage(buttonSelect, name, surname, address, dropdownValue, phone, dateValue, numberOfDaysValue, colorValue, textForCourierValue);
        //Проверка наличия элемента "Хотите оформить заказ?"
        assertTrue(objOrderPage.checkCompleteSetOrder(), "Заказ заполен, но окно не появилось");
        //Нажатие кнопки Да
        objOrderPage.clickButtonYes();
        //Проверка наличия элемента Заказ оформлен с номером заказа
        assertTrue(objOrderPage.checkOrderComplete(), "Заказ не оформлен");
    }
}