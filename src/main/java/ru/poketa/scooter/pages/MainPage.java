package ru.poketa.scooter.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MainPage {

    protected final WebDriver driver;

    //Блок "Вопросы о важном"
    //Ключ
    private final By buttonQuestion1 = By.xpath(".//div[@id='accordion__heading-0']");
    private final By buttonQuestion2 = By.xpath(".//div[@id='accordion__heading-1']");
    private final By buttonQuestion3 = By.xpath(".//div[@id='accordion__heading-2']");
    private final By buttonQuestion4 = By.xpath(".//div[@id='accordion__heading-3']");
    private final By buttonQuestion5 = By.xpath(".//div[@id='accordion__heading-4']");
    private final By buttonQuestion6 = By.xpath(".//div[@id='accordion__heading-5']");
    private final By buttonQuestion7 = By.xpath(".//div[@id='accordion__heading-6']");
    private final By buttonQuestion8 = By.xpath(".//div[@id='accordion__heading-7']");
    //Значение (текст)
    private final By keyButtonQuestion1 = By.xpath(".//div[@id='accordion__panel-0']/p");
    private final By keyButtonQuestion2 = By.xpath(".//div[@id='accordion__panel-1']/p");
    private final By keyButtonQuestion3 = By.xpath(".//div[@id='accordion__panel-2']/p");
    private final By keyButtonQuestion4 = By.xpath(".//div[@id='accordion__panel-3']/p");
    private final By keyButtonQuestion5 = By.xpath(".//div[@id='accordion__panel-4']/p");
    private final By keyButtonQuestion6 = By.xpath(".//div[@id='accordion__panel-5']/p");
    private final By keyButtonQuestion7 = By.xpath(".//div[@id='accordion__panel-6']/p");
    private final By keyButtonQuestion8 = By.xpath(".//div[@id='accordion__panel-7']/p");
    //Верхняя кнопка заказа (справа сверху)
    private final By topOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //Нижняя кнопка заказа (нужно сделать скрол вниз)
    private final By scrollOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка куки файлов
    private final By cookieButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    //Дополнительные задания
    //Логотип Самоката
    private final By scooterLogo = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']");
    //Логотип Яндекс
    private final By yandexLogo = By.xpath(".//a[@class='Header_LogoYandex__3TSOI']");
    //Кнопка статуса заказа
    private final By statusOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Header_Link__1TAG7']");
    //Поле ввода номера заказа
    private final By numberFieldOrder = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
    //Кнопка Go
    private final By goButton = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");

    //Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Cкролим до блока "вопросы о важном" и кликаем по нему
    public void clickButtonQuestions(int textIndex) {
        WebElement question = driver.findElement(getButtonQuestion(textIndex));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", question);
        driver.findElement(getButtonQuestion(textIndex)).click();
    }

    //Переопределение метода
    public void clickButtonQuestions(By buttonQuestions) {
        WebElement question = driver.findElement(buttonQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", question);
        driver.findElement(buttonQuestions).click();
    }

    //Получаем текст содержимого выпадающего списка
    public String getkKeyButtonQuestionsText(By keyButtonQuestions) {
        WebElement question = driver.findElement(keyButtonQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", question);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        question = wait.until(ExpectedConditions.visibilityOfElementLocated(keyButtonQuestions));
        return question.getText();
    }

    //Переопределение метода
    public String getkKeyButtonQuestionsText(int textIndex) {
        return driver.findElement(getkeyButtonQuestion(textIndex)).getText();
    }

    //Создаём пару ключ - значение
    public Map<Integer, String> getFaqMap(int numberButtonQuestion) {
        Map<Integer, String> faqMap = new LinkedHashMap<>();
        switch (numberButtonQuestion) {
            case 1:
                clickButtonQuestions(buttonQuestion1);
                faqMap.put(1, getkKeyButtonQuestionsText(keyButtonQuestion1));
                break;
            case 2:
                clickButtonQuestions(buttonQuestion2);
                faqMap.put(2, getkKeyButtonQuestionsText(keyButtonQuestion2));
                break;
            case 3:
                clickButtonQuestions(buttonQuestion3);
                faqMap.put(3, getkKeyButtonQuestionsText(keyButtonQuestion3));
                break;
            case 4:
                clickButtonQuestions(buttonQuestion4);
                faqMap.put(4, getkKeyButtonQuestionsText(keyButtonQuestion4));
                break;
            case 5:
                clickButtonQuestions(buttonQuestion5);
                faqMap.put(5, getkKeyButtonQuestionsText(keyButtonQuestion5));
                break;
            case 6:
                clickButtonQuestions(buttonQuestion6);
                faqMap.put(6, getkKeyButtonQuestionsText(keyButtonQuestion6));
                break;
            case 7:
                clickButtonQuestions(buttonQuestion7);
                faqMap.put(7, getkKeyButtonQuestionsText(keyButtonQuestion7));
                break;
            case 8:
                clickButtonQuestions(buttonQuestion8);
                faqMap.put(8, getkKeyButtonQuestionsText(keyButtonQuestion8));
                break;
        }
        return faqMap;
    }

    //Скрол и клик / клик сразу на кнопку Заказать (зависит от выбранного параметра)
    public void clickOrderButton(String option) {
        if (Objects.equals(option, "top")) {
            driver.findElement(topOrderButton).click();
        } else if (Objects.equals(option, "down")) {
            //Ожидание пока кнопка будет кликабельна
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(scrollOrderButton));
            WebElement element = driver.findElement(scrollOrderButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                    , element);
            element.click();
        }
    }

    //Нажатие на кнопку принятия Куки
    public void clickCookieButton() {
        if (driver.findElement(cookieButton).isEnabled()) {
            driver.findElement(cookieButton).click();
        }
    }

    //Дополнительно задание

    //Клик на лого Самокат
    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

    //Клик на лого Яндекс
    public void clickYandexLogo() {
        driver.findElement(yandexLogo).click();
    }

    //Клик по кнопке Статуса Заказа
    public void clickStatusOrderButton() {
        driver.findElement(statusOrderButton).click();
    }

    //Ввод значения в поле "Номера заказа"
    public void setFieldOrderNumber(String orderNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(numberFieldOrder));
        input.sendKeys(orderNumber);
    }

    //Клик по кнопке Go
    public void clickGoButton() {
        driver.findElement(goButton).click();
    }

    //Тестируемая страница
    public String testPage() {
        return "https://qa-scooter.praktikum-services.ru/";
    }

    //Ожидание и получение всех окон
    public Set<String> waitAndGetAllWindows() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.getWindowHandles().size() > 1);
        return driver.getWindowHandles();
    }

    //Смена вкладки
    public void switchPage(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    //Геттеры для "Вопросы о важном"

    public By getButtonQuestion(int textIndex) {
        By tmp = null;
        if (textIndex == 1) {
            tmp = buttonQuestion1;
        } else if (textIndex == 2) {
            tmp = buttonQuestion2;
        }else if (textIndex == 3) {
            tmp = buttonQuestion3;
        }else if (textIndex == 4) {
            tmp = buttonQuestion4;
        }else if (textIndex == 5) {
            tmp = buttonQuestion5;
        }else if (textIndex == 6) {
            tmp = buttonQuestion6;
        }else if (textIndex == 7) {
            tmp = buttonQuestion7;
        }else if (textIndex == 8) {
            tmp = buttonQuestion8;
        }
        return tmp;
    }

    public By getkeyButtonQuestion(int textIndex) {
        By tmp = null;
        if (textIndex == 1) {
            tmp = keyButtonQuestion1;
        } else if (textIndex == 2) {
            tmp = keyButtonQuestion2;
        }else if (textIndex == 3) {
            tmp = keyButtonQuestion3;
        }else if (textIndex == 4) {
            tmp = keyButtonQuestion4;
        }else if (textIndex == 5) {
            tmp = keyButtonQuestion5;
        }else if (textIndex == 6) {
            tmp = keyButtonQuestion6;
        }else if (textIndex == 7) {
            tmp = keyButtonQuestion7;
        }else if (textIndex == 8) {
            tmp = keyButtonQuestion8;
        }
        return tmp;
    }

}
