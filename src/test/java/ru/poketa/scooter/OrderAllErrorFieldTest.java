package ru.poketa.scooter;

import org.junit.Test;
import ru.poketa.scooter.pages.MainPage;
import ru.poketa.scooter.pages.OrderPage;

import static org.junit.Assert.assertTrue;

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
        //Проверка сообщения об ошибке в поле
        assertTrue("Нет сообщения об ошибке ввода поля Имя ", objOrderPage.checkErrorNameMessage());
        //Во второй части заказа нет ошибок у полей. Проверить невозможно
    }

    @Test
    //Проверка ошибок для всех полей формы заказа
    public void orderFieldSurnameTest() {
        MainPage objMainPage = new MainPage(driver);
        //Переход на страницу Яндекс Самокат
        goPage(objMainPage.testPage());
        //Ожидание загрузки страницы
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
        //Проверка сообщения об ошибке в поле
        assertTrue("Нет сообщения об ошибке ввода поля Фамилия ", objOrderPage.checkErrorSurnameMessage());
        //Во второй части заказа нет ошибок у полей. Проверить невозможно
    }

    @Test
    //Проверка ошибок для всех полей формы заказа
    public void orderFieldAddressTest() {
        MainPage objMainPage = new MainPage(driver);
        //Переход на страницу Яндекс Самокат
        goPage(objMainPage.testPage());
        //Ожидание загрузки страницы
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
        //Проверка сообщения об ошибке в поле
        assertTrue("Нет сообщения об ошибке ввода поля Адрес ", objOrderPage.checkErrorAddressMessage());
        //Во второй части заказа нет ошибок у полей. Проверить невозможно
    }

    @Test
    //Проверка ошибок для всех полей формы заказа
    public void orderFieldMetroTest() {
        MainPage objMainPage = new MainPage(driver);
        //Переход на страницу Яндекс Самокат
        goPage(objMainPage.testPage());
        //Ожидание загрузки страницы
        waitLoadPage(objMainPage.testPage());
        //Нажимаем на кнопку принятия куки (если она есть);
        objMainPage.clickCookieButton();
        OrderPage objOrderPage = new OrderPage(driver);
        //Нажимаем кнопку "Заказать" в зависимости от выбора:
        //"top" - кнопка вверну (первая кнопка)
        //"down" - кнопка внизу (вторая кнопка)
        objOrderPage.clickOrderButton("top");
        //Нажатие на кнопку Далее не заполняя поля
        objOrderPage.clickCompleteButton();
        //Проверка сообщения об ошибке в поле
        assertTrue("Нет сообщения об ошибке ввода поля Метро ", objOrderPage.checkErrorMetroMessage());
        //Во второй части заказа нет ошибок у полей. Проверить невозможно
    }

    @Test
    //Проверка ошибок для всех полей формы заказа
    public void orderFieldPhoneTest() {
        MainPage objMainPage = new MainPage(driver);
        //Переход на страницу Яндекс Самокат
        goPage(objMainPage.testPage());
        //Ожидание загрузки страницы
        waitLoadPage(objMainPage.testPage());
        //Нажимаем на кнопку принятия куки (если она есть);
        objMainPage.clickCookieButton();
        OrderPage objOrderPage = new OrderPage(driver);
        //Нажимаем кнопку "Заказать" в зависимости от выбора:
        //"top" - кнопка вверну (первая кнопка)
        //"down" - кнопка внизу (вторая кнопка)
        objOrderPage.clickOrderButton("top");
        //Нажатие на кнопку Далее не заполняя поля
        objOrderPage.clickCompleteButton();
        //Проверка сообщения об ошибке в поле
        assertTrue("Нет сообщения об ошибке ввода поля Телефон ", objOrderPage.checkErrorPhoneMessage());
        //Во второй части заказа нет ошибок у полей. Проверить невозможно
    }
}
