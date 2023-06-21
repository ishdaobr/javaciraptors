package org.javaciraptors.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    @FindBy(id = "gender-male")
    private WebElement genderMaleRadiobutton;

    @FindBy(id = "gender-female")
    private WebElement genderFemaleRadiobutton;

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class = 'result']")
    private WebElement confirmationMessage;

    @FindBy(xpath = "//div[@class = 'page registration-result-page']//input")
    private WebElement continueButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage clickGenderMale() {
        genderMaleRadiobutton.click();

        return this;
    }

    public RegistrationPage clickGenderFemale() {
        genderFemaleRadiobutton.click();

        return this;
    }

    public RegistrationPage enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);

        return this;
    }

    public RegistrationPage enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);

        return this;
    }

    public RegistrationPage enterEmail(String email) {
        emailField.sendKeys(email);

        return this;
    }

    public RegistrationPage enterPassword(String password) {
        passwordField.sendKeys(password);

        return this;
    }

    public RegistrationPage enterConfirmPassword(String password) {
        confirmPasswordField.sendKeys(password);

        return this;
    }

    public RegistrationPage clickRegister() {
        registerButton.click();

        return this;
    }

//    public void registerNewUser(String firstName, String lastName, String email,
//                                String password) {
//        new MainPage(getDriver())
//                .clickRegister();
//
//        new RegistrationPage(getDriver())
//                .enterFirstName(firstName)
//                .enterLastName(lastName)
//                .enterEmail(email)
//                .enterPassword(password)
//                .enterConfirmPassword(password)
//                .clickRegister();
//    }

    public String getRegistrationConfirmationMessage() {
        return confirmationMessage.getText();

    }

    public RegistrationPage clickContinue() {
        continueButton.click();

        return this;
    }
}
