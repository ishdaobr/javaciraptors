package org.javaciraptors;

import com.github.javafaker.Faker;
import org.javaciraptors.model.MainPage;
import org.javaciraptors.model.ProductPage;
import org.javaciraptors.model.ProductReviewPage;
import org.javaciraptors.model.RegistrationPage;
import org.javaciraptors.runner.BaseTest;
import org.javaciraptors.runner.TestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductReviewTest extends BaseTest {

    private static final String FIRST_NAME = "First name";
    private static final String LAST_NAME = "Last name";
    private static String EMAIL = randomEmail();
    private static String PASSWORD = "123456";

    public static String randomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    @Test
    public void testAddReview_HappyPath() {
        final String expectedResultTitle = "Test title";
        final String expectedResultText = "Test text";
        final String expectedResultName = "From: " + FIRST_NAME;
        final String expectedResultRating = "width: 20%;";

        new MainPage(getDriver())
                .clickRegister();

        new RegistrationPage(getDriver())
                .enterFirstName(FIRST_NAME)
                .enterLastName(LAST_NAME)
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .enterConfirmPassword(PASSWORD)
                .clickRegister();

        new RegistrationPage(getDriver())
                .clickContinue();

        new MainPage(getDriver())
                .clickProduct();

        new ProductPage(getDriver())
                .addAndReadReview();

        new ProductReviewPage(getDriver())
                .enterReviewTitle("Test title")
                .enterReviewText("Test text")
                .clickRadioButton(TestUtils.Rating.radioButton1)
                .clickSubmitReview();

        String actualResultTitle = new ProductReviewPage(getDriver())
                .getReviewTitle();
        String actualResultText = new ProductReviewPage(getDriver())
                .getReviewText();
        String actualResultName = new ProductReviewPage(getDriver())
                .getReviewUserName();
        String actualResultRating = new ProductReviewPage(getDriver())
                .getReviewRating();

        Assert.assertEquals(actualResultTitle, expectedResultTitle);
        Assert.assertEquals(actualResultText, expectedResultText);
        Assert.assertEquals(actualResultName, expectedResultName);
        Assert.assertEquals(actualResultRating, expectedResultRating);
    }

}

