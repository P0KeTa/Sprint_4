package ru.poketa.scooter;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.poketa.scooter.pages.MainPage;
import ru.poketa.scooter.pages.OrderPage;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class OrderPageTest extends BaseTest {

    private final String buttonSelect;
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String dropdownValue;
    private final int dateValue;
    private final int numberOfDaysValue;
    private final String colorValue;
    private final String textForCourierValue;

    //Конструктор для параметризаци
    public OrderPageTest(String buttonSelect, String name, String surname, String address, String dropdownValue, String phone, int dateValue, int numberOfDaysValue, String colorValue, String textForCourierValue) {
        this.buttonSelect = buttonSelect;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.dropdownValue = dropdownValue;
        this.phone = phone;
        this.dateValue = dateValue;
        this.numberOfDaysValue = numberOfDaysValue;
        this.colorValue = colorValue;
        this.textForCourierValue = textForCourierValue;
    }

    //Параметры для переменных
    @Parameterized.Parameters(name = "Тестовые данные: {1},{2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}")
    public static Object[][] getSumData() {
        return new Object[][]{
                {"top", "Давид", "Тазиашвили", "Полтавская", "Бульвар Рокоссовского", "89093361234", 1, 1, "Чёрный", "Текст для курьера"},
                {"down", "Олег", "Тинькофф", "Ленина", "Черкизовская", "89093364321", 2, 2, "Серый", "Текст для курьера2"},
        };
    }

    private OrderPage getOrderPage() {
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

    @Test
    //Проверка оформления заказа
    public void orderPageTest() {
        MainPage objMainPage = new MainPage(driver);
        //Переход на страницу Яндекс Самокат
        goPage(objMainPage.testPage());
        //Ожидание загрузки страницы
        waitLoadPage(objMainPage.testPage());
        //Нажимаем на кнопку принятия куки (если она есть);
        objMainPage.clickCookieButton();
        //Заполнение полей данными
        OrderPage objOrderPage = getOrderPage();
        //Проверка наличия элемента "Хотите оформить заказ?"
        assertTrue("Заказ заполен, но окно не появилось", objOrderPage.checkCompleteSetOrder());
        //Нажатие кнопки Да
        objOrderPage.clickButtonYes();
        //Проверка наличия элемента Заказ оформлен с номером заказа
        assertTrue("Заказ не оформлен", objOrderPage.checkOrderComplete());
    }
}