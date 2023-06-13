package org.javaciraptors;

import org.javaciraptors.model.MainPage;
import org.javaciraptors.model.RegistrationPage;
import org.javaciraptors.runner.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class RegistrationTest extends BaseTest {

    private final static String FIRST_NAME = "First name";
    private final static String LAST_NAME = "Last name";
    private final String EMAIL = randomEmail();
    private final static String PASSWORD = "123456";

    public static String randomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    @Test
    public void testRegisterNewUser_HappyPath() {

        final String expectedResultText = "Your registration completed";

        new MainPage(getDriver())
                .clickRegister();

        new RegistrationPage(getDriver())
                .registerNewUser(FIRST_NAME, LAST_NAME, EMAIL, PASSWORD);

        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@class = 'result']")).getText(), expectedResultText);
    }
}
