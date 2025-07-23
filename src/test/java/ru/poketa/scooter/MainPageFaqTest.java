package ru.poketa.scooter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.poketa.scooter.pages.MainPage;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageFaqTest extends BaseTest {
    //Параметры для переменных и тест Вопросы о важном
    @ParameterizedTest
    @CsvFileSource(resources = "/dataFqaTest.csv", delimiter = ';')
    public void questionsAboutImportantTest(int textIndex, String expectedAnswer) {
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
        assertEquals(expectedAnswer, actualAnswer, "Ответ не совпадает для вопроса: " + questionText);
    }
}