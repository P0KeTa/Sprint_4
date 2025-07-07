package ru.poketa.scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.poketa.scooter.pages.MainPage;
import ru.poketa.scooter.pages.StatusPage;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StatusPageTest extends BaseTest {

    private final String ORDER_NUMBER;

    public StatusPageTest(String orderNumber) {
        ORDER_NUMBER = orderNumber;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getSumData() {
        return new Object[][]{
                {"120687"},
                {"000"},
        };
    }

    @Test
    //Проверка страницы неправильного номера заказа
    public void wrongStatusPageTest() {
        MainPage objMainPage = new MainPage(driver);
        //Переход на страницу Яндекс Самокат
        goPage(objMainPage.testPage());
        //Ожидание загрузки страницы
        waitLoadPage(objMainPage.testPage());
        //Нажимаем на кнопку принятия куки (если она есть);
        objMainPage.clickCookieButton();
        //Клик по кнопке Статус заказа
        objMainPage.clickStatusOrderButton();
        //Заполнение поля Номер заказа
        objMainPage.setFieldOrderNumber(ORDER_NUMBER);
        //Клик по кнопке Go
        objMainPage.clickGoButton();

        StatusPage objStatusPage = new StatusPage(driver);

        //Фактический результат (если страница есть, то true)
        assertTrue("Страница с надписью 'Такого заказа нет' не появилась", objStatusPage.checkNotFoundImg());
    }
}