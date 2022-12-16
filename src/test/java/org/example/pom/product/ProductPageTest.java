package org.example.pom.product;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.data.DataProduct;
import org.example.pom.DashboardPage;
import org.example.pom.HomePage;
import org.example.pom.account.LoginAccountPage;
import org.example.pom.checkout.ShippingCheckoutPage;
import org.example.utils.Cons;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductPageTest {
    private static WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    private ArrayList<DataProduct> dataCart = new ArrayList<>();

    @Test
    @Order(1)
    void testAddCart() {
        HomePage homePage = new HomePage(driver);
        LoginAccountPage loginAccountPage = homePage.clickLogin();
        DashboardPage dashboardPage = loginAccountPage.login("akbarabdul10@gmail.com", "Password123");

        ProductPage productPage = dashboardPage.clickProduct(0);
        productPage.setSize(Cons.SIZE_L);
        productPage.setColor(0);
        productPage.setQty(3);
        dataCart.add(new DataProduct(productPage.getTitle(), productPage.getQty()));

        productPage.addToCart();
        productPage.clickProduct(0);

        productPage.setSize(Cons.SIZE_L);
        productPage.setColor(0);
        productPage.setQty(3);
        dataCart.add(new DataProduct(productPage.getTitle(), productPage.getQty()));

        productPage.addToCart();

        productPage.clickCart();

        productPage.clickCheckout();
    }

    @Test
    @Order(2)
    void testCheckout() {
        ShippingCheckoutPage shippingCheckoutPage = new ShippingCheckoutPage(driver);

    }
}