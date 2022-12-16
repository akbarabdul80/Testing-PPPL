package org.example.pom;

import org.example.pom.product.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private By product = By.className("product-item-info");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage clickProduct(Integer index) {
        driver.findElements(product).get(index).click();
        return new ProductPage(driver);
    }
}
