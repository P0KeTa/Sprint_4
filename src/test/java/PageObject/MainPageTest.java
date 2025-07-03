package PageObject;

import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import static org.junit.Assert.*;

public class MainPageTest extends BaseTest {

    @Test
    //Тест Вопросы о важном
    public void questionsAboutImportantTest() {
        MainPage objMainPage = new MainPage(driver);
        //Переход на страницу Яндекс Самокат
        goPage("https://qa-scooter.praktikum-services.ru/");
        //Нажимание на стрелку выпадающего списка
        objMainPage.clickButtonQuestions();
        //Проверка появляется ли текст при нажатии на кнопку
        assertTrue("Текст не появляется", objMainPage.checkClickButtonQuestions());
    }

    @Test
    //Тест проверки логотипа Самокат
    public void scooterLogoTest() {
        MainPage objMainPage = new MainPage(driver);
        //Переход на страницу Яндекс Самокат
        goPage("https://qa-scooter.praktikum-services.ru/");
        //Клик на лого Самокат
        objMainPage.clickScooterLogo();
        //Ожидаем загрузки нужной страницы
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://qa-scooter.praktikum-services.ru/"));
        //Ожидаемая страницы
        String expected_url = "https://qa-scooter.praktikum-services.ru/";
        //Фактическая страница
        String actual_url = driver.getCurrentUrl();
        //Сравнение страниц
        assertEquals("Страница ЯндексСамокат не открылась", expected_url, actual_url);
    }

    @Test
    //Тест проверки логотипа Яндекс
    public void yandexLogoTest() {
        MainPage objMainPage = new MainPage(driver);
        //Переход на страницу Яндекс Самокат
        goPage("https://qa-scooter.praktikum-services.ru/");
        //Запись id текущей вкладки
        String mainWindow = driver.getWindowHandle();
        //Клик на логотим Яндекс
        objMainPage.clickYandexLogo();
        //Ожидание и получение всех окон
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.getWindowHandles().size() > 1);
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(mainWindow)) {
                //Переход на следующее окно
                driver.switchTo().window(windowHandle);
                String expected_url = "https://dzen.ru/?yredirect=true";
                String actual_url = driver.getCurrentUrl();
                //Сравнение текущего и ожидаемого окна
                assertEquals("Страница Яндекс не открылась", expected_url, actual_url);
                break;
            }
        }
        //Переход на изначальную вкладку
        driver.switchTo().window(mainWindow);
    }

}

