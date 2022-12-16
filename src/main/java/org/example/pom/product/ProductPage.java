package org.example.pom.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private By switchSize = By.cssSelector(".swatch-option text");
    private By switchColor = By.cssSelector(".swatch-option color");
    private By etQty = By.cssSelector(".input-text.qty");
    private By addToCart = By.cssSelector("button[title='Add to Cart']");

    private List<String> sizes;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        sizes.add("dsa");
    }


    public void setQty(Integer qty) {
        driver.findElement(etQty).sendKeys(qty.toString());
    }
}
