package PageObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StatusPageTest extends BaseTest {

    private final String ORDER_NUMBER;

    public StatusPageTest(String orderNumber) {
        ORDER_NUMBER = orderNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {"123"},
                {"000"},
        };
    }

    @Test
    //Проверка страницы неправильного номера заказа
    public void wrongStatusPageTest() {
        MainPage objMainPage = new MainPage(driver);
        //Переход на страницу Яндекс Самокат
        goPage("https://qa-scooter.praktikum-services.ru/");
        //Нажимаем на кнопку принятия куки (если она есть);
        clickCookieButton();

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