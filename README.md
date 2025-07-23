# UI и автотесты на Selenium

## 📋 Описание
Проект для автоматизации тестирования веб-приложения [qa-scooter.praktikum-services.ru](https://qa-scooter.praktikum-services.ru) с использованием Selenium WebDriver и JUnit.

## 🔧 Технологии
- Java 11
- Maven
- Selenium 4.33.0
- JUnit 5
- ChromeDriver
- FirefoxDriver

## 🧪 Что покрыто автотестами
- Проверка логотипов Яндекса и Самоката
- Форма заказа: позитивные сценарии
- Блок "Вопросы о важном" — проверка текста по ключам

## 🚀 Как запустить
1. Клонировать репозиторий:
   ```bash
   git clone https://github.com/P0KeTa/Sprint_4.git
2. Перейти в директорию проекта и запустить тесты:
   ```bash
   mvn clean test

## 📂 Структура проекта
- pages/ — Page Object модели
- tests/ — JUnit тесты
- test/resources/ – Файлы csv для параметризации тестов
- BaseTest.java — базовая настройка драйвера

