package org.example.pom.product;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.util.log.Log;

import java.io.Console;
import java.util.List;
import java.util.logging.Logger;

public class ProductPage {
    private WebDriver driver;
    private By switchSize = By.cssSelector(".swatch-option.text");
    private By switchColor = By.cssSelector(".swatch-option.color");
    private By etQty = By.cssSelector(".input-text.qty");
    private By addToCart = By.cssSelector("button[title='Add to Cart']");
    private By product = By.cssSelector(".item.product.product-item");
    private By btnCart = By.cssSelector(".action.showcart");
    private By counterCart = By.className("counter-number");

    private By btnCheckout = By.id("top-cart-btn-checkout");

    private By titleProduct = By.className("base");
    private Integer cartCount = 0;
    private Integer lastCartCount = 0;

    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WaitUtils.TIMEOUT);
    }

    public void setSize(Integer size) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(switchSize));
        driver.findElements(switchSize).get(size).click();
    }

    public void setColor(Integer color) {
        driver.findElements(switchColor).get(color).click();
    }

    public void setQty(Integer qty) {
        driver.findElement(etQty).clear();
        driver.findElement(etQty).sendKeys(qty.toString());
        cartCount = qty;
    }

    public void addToCart() {
        lastCartCount += cartCount;
        driver.findElement(addToCart).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(counterCart, lastCartCount.toString()));
    }

    public void clickProduct(Integer index) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(product));
        driver.findElements(product).get(index).click();
    }

    public void clickCart() {
        driver.findElement(btnCart).click();
    }

    public void clickCheckout() {
        driver.findElement(btnCheckout).click();
    }

    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleProduct));
        return driver.findElement(titleProduct).getText();
    }

    public String getQty() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(etQty));
        return driver.findElement(etQty).getText();
    }
}
