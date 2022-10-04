package lesson6.homeWork6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.lesson6.homeWork6.StartedPage;
import org.example.lesson6.homeWork6.TranslatePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TranslateTests {
    WebDriver driver;
    TranslatePage translatePage;
    StartedPage startedPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();// просим webDriverManager установаить драйвер
    }


    @BeforeEach
    void initDriver() throws InterruptedException {//пред каждым тестом делаем все настройки
        driver = new ChromeDriver();
        startedPage = new StartedPage(driver);
        translatePage = new TranslatePage(driver);

    }

    @Test
    @DisplayName("Тест_1: Ввод валидных данных в поле ввода для исходного текста  ")
    public void test1() throws InterruptedException {
        startedPage.sendText("делать домашнее задание")//вводим валидные данные-в результате переходим на translate page
                .checkSendText();// assertion
    }
    @Test
    @DisplayName("Тест_2: Выбор альтернативного перевода  в разделе \"Словарь\" ")
    public void test2() throws InterruptedException {
        translatePage.selectValueInDictionary()
                .checkSelectValueInDictionary();// assertion
    }

    @Test
    @DisplayName("Тест_3: Выбор альтернативного варианта  в разделе \"Примеры использования\" ")
    public void test3() throws InterruptedException {
        translatePage.selectValueInExamples()
                .checkSelectValueInExamples();// assertion
    }

    @Test
    @DisplayName("Тест_4: Изменение исходного языка с помощью кнопки \"переключение направления\" ")
    public void test4() throws InterruptedException {
        translatePage.selectLanguageUsingSwapbutton()
                     .checkSelectLanguageUsingSwapbutton();// assertion
    }

    @Test
    @DisplayName("Тест_5: Изменение исходного языка с помощью кнопки \"переключение направления\" ")
    public void test5() throws InterruptedException {
        translatePage.selectLanguageInLanguageList()
                     .checkSelectLanguageInLanguageList();// assertion
    }

    @Test
    @DisplayName("Тест_6: Выбор альтернативного перевода  в дополнительном окне, появляющемся при выделении  конкретного слова в поле с исходным тестом")
    public void test6 () throws InterruptedException {
        translatePage.selectTranslateVariantOfSingleWorldInLeftPart()
                .checkSelectTranslateVariantOfSingleWorldInLeftPart();//assertion
    }

    @Test
    @DisplayName("Тест_7: Выделение соответствующего слова в левом поле  с исходным тестом при наведении на конкретное слово в правом поле с переводом текста ")
    public void test7 () throws InterruptedException {
        translatePage.highlightingCorrespondingWord()
                .checkHighlightingCorrespondingWord();//assertion
    }

    @Test
    @DisplayName("Тест_8: Выделение соответствующего слова в левом поле  с исходным тестом при наведении на конкретное слово в правом поле с переводом текста Выбор альтернативного варианта  перевода  конкретного слова в дополнительном окне, появляющемся при клике на это слово в поле с переводом")
    public void test8 () throws InterruptedException {
        translatePage.selectTranslateValueInRightPart()
                .checkSelectTranslateValueInRightPart();
    }


    @AfterEach// после каждого теста убиваем браузер
    void tearDown() {
        driver.quit();
    }
}
