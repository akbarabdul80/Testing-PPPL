package org.example.pom.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileAccountPage {
    private WebDriver driver;

    private By boxContent = By.className("box-content");

    public ProfileAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBoxInformation() {
        return driver.findElement(boxContent).getText();
    }
}
