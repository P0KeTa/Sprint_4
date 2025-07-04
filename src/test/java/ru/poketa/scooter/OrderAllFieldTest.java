package ru.poketa.scooter;

import org.junit.Test;
import ru.poketa.scooter.data.TestData;
import ru.poketa.scooter.pages.MainPage;
import ru.poketa.scooter.pages.OrderPage;

import static org.junit.Assert.assertTrue;

public class OrderAllFieldTest extends BaseTest {

    @Test
    //Проверка ошибок для всех полей формы заказа
    public void orderAllFieldTest() {
        MainPage objMainPage = new MainPage(driver);
        //Переход на страницу Яндекс Самокат
        goPage(objMainPage.getTEST_PAGE());
        //Нажимаем на кнопку принятия куки (если она есть);
        clickCookieButton();

        OrderPage objOrderPage = new OrderPage(driver);
        TestData objTestData = new TestData();
        //Нажимаем кнопку "Заказать" в зависимости от выбора:
        //"top" - кнопка вверну (первая кнопка)
        //"down" - кнопка внизу (вторая кнопка)
        objOrderPage.clickOrderButton("top");
        //Нажатие на кнопку Далее не заполняя поля
        objOrderPage.clickCOMPLETE_BUTTON();
        //Проверка сообщения об ошибке в каждом поле
        assertTrue("Нет сообщения об ошибке ввода поля Имя ", objOrderPage.checkErrorNameMessage());
        assertTrue("Нет сообщения об ошибке ввода поля Фамилия ", objOrderPage.checkErrorSurnameMessage());
        assertTrue("Нет сообщения об ошибке ввода поля Адрес ", objOrderPage.checkErrorAddressMessage());
        assertTrue("Нет сообщения об ошибке ввода поля Метро ", objOrderPage.checkErrorMetroMessage());
        assertTrue("Нет сообщения об ошибке ввода поля Телефон ", objOrderPage.checkErrorPhoneMessage());
        //Установка значений полей
        objTestData.setName("Давид");
        objTestData.setSurname("Тазиашвили");
        objTestData.setAddress("Полтавская");
        objTestData.setDropdownValue("Бульвар Рокоссовского");
        objTestData.setPhone("89093361234");
        //Ввод валидных данных в поля и нажатие кнопки далее
        objOrderPage.setOrderAndClickButton1(objTestData.getName(), objTestData.getSurname(), objTestData.getAddress(), objTestData.getDropdownValue(), objTestData.getPhone());
        //Во второй части заказа нет ошибок у полей.
        //Проверить невозможно
    }
}
