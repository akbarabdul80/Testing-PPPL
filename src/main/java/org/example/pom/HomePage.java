package org.example.pom;

import org.example.pom.account.CreateAccountPage;
import org.example.pom.account.LoginAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    public WebDriver driver;
    public By signUp = By.linkText("Create an Account");
    public By signIn = By.linkText("Sign In");

    public By mainContent = By.id("maincontent");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateAccountPage clickSignIn() {
        driver.findElement(signUp).click();

        new WebDriverWait(driver, 10).until(webDriver -> webDriver.findElement(mainContent).isDisplayed());

        return new CreateAccountPage(driver);
    }

    public LoginAccountPage clickLogin() {
        driver.findElement(signIn).click();
        new WebDriverWait(driver, 10).until(webDriver -> webDriver.findElement(mainContent).isDisplayed());
        return new LoginAccountPage(driver);
    }


}
