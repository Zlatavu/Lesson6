package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.lesson6.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyTShirtTest {// объявляем драйвер и wait
    WebDriver driver;
    MainPage mainPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();// просим webDriverManager установаить драйвер
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    void buyTShirtTest() throws InterruptedException {
        mainPage.clickSingInButton()// кликаем на зарегистрироваться
                // вводим логин и пароль вызвав метод ЛОГИН в LoginPage
                .login("spartalex93@test.test", "123456")
                // в navigationBlock выбираем WomenMenu  и кликаем на TShirts- переходим на страницу TShirtsPage
                .navigationBlock.hoverWomenMenuAndClickTShirts()
                //выбираем размер вызвав метот selectSizes(на вход передаем строку с расмером) на странице TShirtPage
                .selectSize("S")
                // выбираем цену вызвав метод moveLeftPriceSliderElement и передав на вход отклонение бегунка
                .moveLeftPriceSliderElement(10)
                // добавляем товар в корзину вызвав метод addToCartByName, передав на вход имя товара - переходим в SuccessBlock
                .addToCartByName("Faded")
                // выполняем проверку, сверив сумму - вызываем метод checkTotalSumma из  SuccessBlock
                .checkTotalSumma("$18.51");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
