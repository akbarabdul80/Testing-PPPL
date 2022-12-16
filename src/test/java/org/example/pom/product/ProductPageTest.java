package org.example.pom.product;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pom.DashboardPage;
import org.example.pom.HomePage;
import org.example.pom.account.LoginAccountPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class ProductPageTest {
    private static WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeEach
    void setUp() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void testAddCart() {
        HomePage homePage = new HomePage(driver);
        LoginAccountPage loginAccountPage = homePage.clickLogin();
        DashboardPage dashboardPage = loginAccountPage.login("akbarabdul10@gmail.com", "Password123");
        dashboardPage.clickProduct(2);

    }
}