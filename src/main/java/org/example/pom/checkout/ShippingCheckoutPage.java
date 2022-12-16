package org.example.pom.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingCheckoutPage {
    private WebDriver driver;

    private By firstName = By.name("firstname");
    private By lastName = By.name("lastname");
    private By company = By.name("company");
    private By address1 = By.name("street[0]");
    private By address2 = By.name("street[1]");
    private By address3 = By.name("street[2]");
    private By city = By.name("city");
    private By state = By.name("region_id");
    private By zip = By.name("postcode");
    private By country = By.name("country_id");
    private By telephone = By.name("telephone");


    public ShippingCheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContinue() {
        driver.findElement(By.cssSelector("button[title='Continue']")).click();
    }

    Select countrySelectElement = new Select(driver.findElement(country));

    public void insertShippingAddress(String firstName, String lastName, String company, String address1, String address2, String address3, String city, String state, String zip, String country, String telephone) {
        driver.findElement(this.firstName).sendKeys(firstName);
        driver.findElement(this.lastName).sendKeys(lastName);
        driver.findElement(this.company).sendKeys(company);
        driver.findElement(this.address1).sendKeys(address1);
        driver.findElement(this.address2).sendKeys(address2);
        driver.findElement(this.address3).sendKeys(address3);
        driver.findElement(this.city).sendKeys(city);
        driver.findElement(this.state).sendKeys(state);
        driver.findElement(this.zip).sendKeys(zip);
        driver.findElement(this.country).sendKeys(country);
        driver.findElement(this.telephone).sendKeys(telephone);
    }


}
