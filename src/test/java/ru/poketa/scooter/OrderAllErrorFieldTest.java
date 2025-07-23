package ru.poketa.scooter;

import org.junit.jupiter.api.Test;
import ru.poketa.scooter.pages.MainPage;
import ru.poketa.scooter.pages.OrderPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderAllErrorFieldTest extends BaseTest {

    @Test
    //Проверка ошибок для всех полей формы заказа
    public void orderFieldNameTest() {
        MainPage objMainPage = new MainPage(driver);
        //Переход на страницу Яндекс Самокат и ожидание загрузки страницы
        goPage(objMainPage.testPage());
        waitLoadPage(objMainPage.testPage());
        //Нажимаем на кнопку принятия куки (если она есть);
        mainPage.clickCookieButton();
        OrderPage objOrderPage = new OrderPage(driver);
        //Нажимаем кнопку "Заказать" в зависимости от выбора:
        //"top" - кнопка вверну (первая кнопка)
        //"down" - кнопка внизу (вторая кнопка)
        objOrderPage.clickOrderButton("top");
        //Нажатие на кнопку Далее не заполняя поля
        objOrderPage.clickCompleteButton();
        //Проверка сообщения об ошибке в каждом поле
        assertAll(
                () -> assertTrue(objOrderPage.checkErrorNameMessage(), "Нет сообщения об ошибке ввода поля Имя"),
                () -> assertTrue(objOrderPage.checkErrorSurnameMessage(), "Нет сообщения об ошибке ввода поля Фамилия"),
                () -> assertTrue(objOrderPage.checkErrorAddressMessage(), "Нет сообщения об ошибке ввода поля Адрес"),
                () -> assertTrue(objOrderPage.checkErrorMetroMessage(), "Нет сообщения об ошибке ввода поля Метро"),
                () -> assertTrue(objOrderPage.checkErrorPhoneMessage(), "Нет сообщения об ошибке ввода поля Телефон")
        );
        //Во второй части заказа нет ошибок у полей. Проверить невозможно
    }
}