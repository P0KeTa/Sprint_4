package PageObject;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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
    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {"top", "Давид", "Тазиашвили", "Полтавская", "Бульвар Рокоссовского", "89093361234", 1, 1, "Чёрный", "Текст для курьера"},
                {"down", "Олег", "Тинькофф", "Ленина", "Черкизовская", "89093364321", 2, 2, "Серый", "Текст для курьера2"},
        };
    }

    @Test
    //Проверка оформления заказа
    public void orderPageTest() {
        //Переход на страницу Яндекс Самокат
        goPage("https://qa-scooter.praktikum-services.ru/");
        //Нажимаем на кнопку принятия куки (если она есть);
        clickCookieButton();

        OrderPage objOrderPage = new OrderPage(driver);

        //Нажимаем кнопку "Заказать" в зависимости от выбора:
        //"top" - кнопка вверну (первая кнопка)
        //"down" - кнопка внизу (вторая кнопка)
        objOrderPage.clickOrderButton(buttonSelect);
        //Ввод валидных данных в поля и нажатие кнопки далее
        objOrderPage.setOrderAndClickButton1(name, surname, address, dropdownValue, phone);
        //Ввод данных в поля второй формы и нажатие кнопки "Заказать"
        //Добавлено 2 опции на выбор даты
        //1 – 1 июля 2025 / 2– 2 июля 2025
        //Значение выбора скора аренда число от 1 до 7 (кол-во дней)
        objOrderPage.setOrderAndClickButton2(dateValue, numberOfDaysValue, colorValue, textForCourierValue);
        //Проверка наличия элемента "Хотите оформить заказ?" и нажатие кнопки Да
        objOrderPage.checkCompleteSetOrder();
        //Проверка наличия элемента Заказ оформлен с номером заказа
        assertTrue("Заказ не оформлен", objOrderPage.checkOrderComplete());
    }

    @Test
    //Проверка ошибок для всех полей формы заказа
    public void orderAllFieldTest() {
        //Переход на страницу Яндекс Самокат
        goPage("https://qa-scooter.praktikum-services.ru/");
        //Нажимаем на кнопку принятия куки (если она есть);
        clickCookieButton();

        OrderPage objOrderPage = new OrderPage(driver);

        //Нажимаем кнопку "Заказать" в зависимости от выбора:
        //"top" - кнопка вверну (первая кнопка)
        //"down" - кнопка внизу (вторая кнопка)
        objOrderPage.clickOrderButton(buttonSelect);
        //Нажатие на кнопку Далее не заполняя поля
        objOrderPage.clickCOMPLETE_BUTTON();
        //Проверка сообщения об ошибке в каждом поле
        assertTrue("Нет сообщения об ошибке ввода поля Имя ", objOrderPage.checkErrorNameMessage());
        assertTrue("Нет сообщения об ошибке ввода поля Фамилия ", objOrderPage.checkErrorSurnameMessage());
        assertTrue("Нет сообщения об ошибке ввода поля Адрес ", objOrderPage.checkErrorAddressMessage());
        assertTrue("Нет сообщения об ошибке ввода поля Метро ", objOrderPage.checkErrorMetroMessage());
        assertTrue("Нет сообщения об ошибке ввода поля Телефон ", objOrderPage.checkErrorPhoneMessage());
        //Ввод валидных данных в поля и нажатие кнопки далее
        objOrderPage.setOrderAndClickButton1(name, surname, address, dropdownValue, phone);
        //Во второй части заказа нет ошибок у полей.
        //Проверить невозможно
    }
}