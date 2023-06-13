package org.javaciraptors.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage clickGenderMale() {
        getDriver().findElement(By.id("gender-male")).click();

        return this;
    }

    public RegistrationPage clickGenderFemale() {
        getDriver().findElement(By.id("gender-female")).click();

        return this;
    }

    public RegistrationPage enterFirstName(String firstName) {
        getDriver().findElement(By.id("FirstName")).sendKeys(firstName);

        return this;
    }

    public RegistrationPage enterLastName(String lastName) {
        getDriver().findElement(By.id("LastName")).sendKeys(lastName);

        return this;
    }

    public RegistrationPage enterEmail(String email) {
        getDriver().findElement(By.id("Email")).sendKeys(email);

        return this;
    }

    public RegistrationPage enterPassword(String password) {
        getDriver().findElement(By.id("Password")).sendKeys(password);

        return this;
    }

    public RegistrationPage enterConfirmPassword(String password) {
        getDriver().findElement(By.id("ConfirmPassword")).sendKeys(password);

        return this;
    }

    public RegistrationPage clickRegister() {
        getDriver().findElement(By.id("register-button")).click();

        return this;
    }

    public void registerNewUser(String firstName, String lastName, String email,
                                String password) {
        new MainPage(getDriver())
                .clickRegister();

        new RegistrationPage(getDriver())
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmPassword(password)
                .clickRegister();
    }
}
