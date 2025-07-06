package ru.poketa.scooter;

import org.junit.*;
import ru.poketa.scooter.pages.MainPage;

import static org.junit.Assert.*;

public class MainPageTest extends BaseTest {

    @Test
    //Тест проверки логотипа Самокат
    public void scooterLogoTest() {
        MainPage objMainPage = new MainPage(driver);
        //Переход на страницу Яндекс Самокат и ожидание загрузки страницы
        goPage(objMainPage.testPage());
        waitLoadPage(objMainPage.testPage());
        //Клик на лого Самокат и ожидание загрузки нужной страницы
        objMainPage.clickScooterLogo();
        waitLoadPage(objMainPage.testPage());
        //Ожидаемая и фактическая страницы
        String expected_url = objMainPage.testPage();
        String actual_url = driver.getCurrentUrl();
        //Сравнение страниц
        assertEquals("Страница ЯндексСамокат не открылась", expected_url, actual_url);
    }

    @Test
    //Тест проверки логотипа Яндекс
    public void yandexLogoTest() {
        MainPage objMainPage = new MainPage(driver);
        //Переход на страницу Яндекс Самокат и ожидание загрузки страницы
        goPage(objMainPage.testPage());
        waitLoadPage(objMainPage.testPage());
        //Запись id текущей вкладки и клик по логотипу Яндекс
        String mainWindow = driver.getWindowHandle();
        objMainPage.clickYandexLogo();
        //Ожидание и получение всех окон
        for (String windowHandle : objMainPage.waitAndGetAllWindows()) {
            if (!windowHandle.equals(mainWindow)) {
                //Переход на следующее окно
                objMainPage.switchPage(windowHandle);
                //Ожидаемая и фактическая страницы
                String expected_url = "https://dzen.ru/?yredirect=true";
                String actual_url = driver.getCurrentUrl();
                //Сравнение текущего и ожидаемого окна
                assertEquals("Страница Яндекс не открылась", expected_url, actual_url);
                break;
            }
        }
        //Переход на изначальную вкладку
        objMainPage.switchPage(mainWindow);
    }
}