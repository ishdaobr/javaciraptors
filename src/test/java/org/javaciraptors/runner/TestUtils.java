package org.javaciraptors.runner;

import org.javaciraptors.model.MainPage;
import org.javaciraptors.model.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestUtils {

    public enum Rating {
        radioButton1(By.id("addproductrating_1")),
        radioButton2(By.id("addproductrating_2")),
        radioButton3(By.id("addproductrating_3")),
        radioButton4(By.id("addproductrating_4")),
        radioButton5(By.id("addproductrating_5"));

        private final By locator;

        Rating(By locator) {
            this.locator = locator;
        }

        public By getLocator() {
            return locator;
        }
    }

    public static void registerNewUser(BaseTest baseTest, String firstName, String lastName, String email,
                                String password) {
        final WebDriver driver = baseTest.getDriver();

        new MainPage(driver)
                .clickRegister();

        new RegistrationPage(driver)
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmPassword(password)
                .clickRegister();
    }
}
