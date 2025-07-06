package ru.poketa.scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.poketa.scooter.pages.MainPage;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MainPageFaqTest extends BaseTest {

    private final int textIndex;
    private final String expectedAnswer;

    public MainPageFaqTest(int textIndex, String expectedAnswer) {
        this.textIndex = textIndex;
        this.expectedAnswer = expectedAnswer;
    }

    //Параметры для переменных
    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] getSumData() {
        return new Object[][]{
                {1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    //Тест Вопросы о важном
    public void questionsAboutImportantTest() {
        MainPage objMainPage = new MainPage(driver);
        //Переход на страницу Яндекс Самокат и ожидание загрузки страницы
        goPage(objMainPage.testPage());
        waitLoadPage(objMainPage.testPage());
        //Создаём пару ключ - значение для нужного вопроса
        Map<Integer, String> faqMap = new LinkedHashMap<>(objMainPage.getFaqMap(textIndex));
        //Получаем текст кнопки
        String questionText = faqMap.get(textIndex);
        //Cкролим до блока "вопросы о важном" и кликаем по нему
        objMainPage.clickButtonQuestions(textIndex);
        //Находим соответствующий ответ
        String actualAnswer = objMainPage.getkKeyButtonQuestionsText(textIndex);
        //Сравниваем ОР и ФР
        assertEquals("Ответ не совпадает для вопроса: " + questionText, expectedAnswer, actualAnswer);
    }
}
