package org.example.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pom.account.CreateAccountPage;
import org.example.pom.account.LoginAccountPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class HomePageTest {

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

//    @Test
//    @Order(1)
//    void createAccount() {
//        HomePage homePage = new HomePage(driver);
//        CreateAccountPage createAccountPage = homePage.clickSignIn();
//
//        createAccountPage.setFirstName("Muhamad");
//        createAccountPage.setLastName("Akbar");
//        createAccountPage.setEmail("akbarabdul10@gmail.com");
//        createAccountPage.setPassword("Password123");
//        createAccountPage.setConfirmPassword("Password123");
//        createAccountPage.clickCreateAccount();
//    }

    @Test
    @Order(1)
    void login() {
        HomePage homePage = new HomePage(driver);
        LoginAccountPage loginAccountPage = homePage.clickLogin();
        loginAccountPage.login("akbarabdul10@gmail.com", "Password123");
    }



}