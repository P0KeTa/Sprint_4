package ru.poketa.scooter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.poketa.scooter.pages.MainPage;
import ru.poketa.scooter.pages.StatusPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatusPageTest extends BaseTest {
    @ParameterizedTest
    @CsvSource({
            ("120687"),
            ("000")
    })
    //Проверка страницы неправильного номера заказа
    public void wrongStatusPageTest(String orderNumber) {
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
        objMainPage.setFieldOrderNumber(orderNumber);
        //Клик по кнопке Go
        objMainPage.clickGoButton();

        StatusPage objStatusPage = new StatusPage(driver);

        //Фактический результат (если страница есть, то true)
        assertTrue(objStatusPage.checkNotFoundImg(), "Страница с надписью 'Такого заказа нет' не появилась");
    }
}