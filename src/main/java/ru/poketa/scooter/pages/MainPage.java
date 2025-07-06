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
    //Ключ (вопросы)
    private final By buttonQuestionPrice = By.xpath(".//div[@id='accordion__heading-0']");
    private final By buttonQuestionMultipleScooters = By.xpath(".//div[@id='accordion__heading-1']");
    private final By buttonQuestionRentTime = By.xpath(".//div[@id='accordion__heading-2']");
    private final By buttonQuestionRentToday = By.xpath(".//div[@id='accordion__heading-3']");
    private final By buttonQuestionRefundScooters = By.xpath(".//div[@id='accordion__heading-4']");
    private final By buttonQuestionCharge = By.xpath(".//div[@id='accordion__heading-5']");
    private final By buttonQuestionCancelOrder = By.xpath(".//div[@id='accordion__heading-6']");
    private final By buttonQuestionAcrossMRR = By.xpath(".//div[@id='accordion__heading-7']");
    //Значение (ответ на вопрос)
    private final By answerButtonQuestionPrice = By.xpath(".//div[@id='accordion__panel-0']/p");
    private final By answerButtonQuestionMultipleScooters = By.xpath(".//div[@id='accordion__panel-1']/p");
    private final By answerButtonQuestionTime = By.xpath(".//div[@id='accordion__panel-2']/p");
    private final By answerButtonQuestionRentToday = By.xpath(".//div[@id='accordion__panel-3']/p");
    private final By answerButtonQuestionRefundScooters = By.xpath(".//div[@id='accordion__panel-4']/p");
    private final By answerButtonQuestionCharge = By.xpath(".//div[@id='accordion__panel-5']/p");
    private final By answerButtonQuestionCancelOrder = By.xpath(".//div[@id='accordion__panel-6']/p");
    private final By answerButtonQuestionAcrossMRR = By.xpath(".//div[@id='accordion__panel-7']/p");
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
                clickButtonQuestions(buttonQuestionPrice);
                faqMap.put(1, getkKeyButtonQuestionsText(answerButtonQuestionPrice));
                break;
            case 2:
                clickButtonQuestions(buttonQuestionMultipleScooters);
                faqMap.put(2, getkKeyButtonQuestionsText(answerButtonQuestionMultipleScooters));
                break;
            case 3:
                clickButtonQuestions(buttonQuestionRentTime);
                faqMap.put(3, getkKeyButtonQuestionsText(answerButtonQuestionTime));
                break;
            case 4:
                clickButtonQuestions(buttonQuestionRentToday);
                faqMap.put(4, getkKeyButtonQuestionsText(answerButtonQuestionRentToday));
                break;
            case 5:
                clickButtonQuestions(buttonQuestionRefundScooters);
                faqMap.put(5, getkKeyButtonQuestionsText(answerButtonQuestionRefundScooters));
                break;
            case 6:
                clickButtonQuestions(buttonQuestionCharge);
                faqMap.put(6, getkKeyButtonQuestionsText(answerButtonQuestionCharge));
                break;
            case 7:
                clickButtonQuestions(buttonQuestionCancelOrder);
                faqMap.put(7, getkKeyButtonQuestionsText(answerButtonQuestionCancelOrder));
                break;
            case 8:
                clickButtonQuestions(buttonQuestionAcrossMRR);
                faqMap.put(8, getkKeyButtonQuestionsText(answerButtonQuestionAcrossMRR));
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
            tmp = buttonQuestionPrice;
        } else if (textIndex == 2) {
            tmp = buttonQuestionMultipleScooters;
        }else if (textIndex == 3) {
            tmp = buttonQuestionRentTime;
        }else if (textIndex == 4) {
            tmp = buttonQuestionRentToday;
        }else if (textIndex == 5) {
            tmp = buttonQuestionRefundScooters;
        }else if (textIndex == 6) {
            tmp = buttonQuestionCharge;
        }else if (textIndex == 7) {
            tmp = buttonQuestionCancelOrder;
        }else if (textIndex == 8) {
            tmp = buttonQuestionAcrossMRR;
        }
        return tmp;
    }

    public By getkeyButtonQuestion(int textIndex) {
        By tmp = null;
        if (textIndex == 1) {
            tmp = answerButtonQuestionPrice;
        } else if (textIndex == 2) {
            tmp = answerButtonQuestionMultipleScooters;
        }else if (textIndex == 3) {
            tmp = answerButtonQuestionTime;
        }else if (textIndex == 4) {
            tmp = answerButtonQuestionRentToday;
        }else if (textIndex == 5) {
            tmp = answerButtonQuestionRefundScooters;
        }else if (textIndex == 6) {
            tmp = answerButtonQuestionCharge;
        }else if (textIndex == 7) {
            tmp = answerButtonQuestionCancelOrder;
        }else if (textIndex == 8) {
            tmp = answerButtonQuestionAcrossMRR;
        }
        return tmp;
    }

}