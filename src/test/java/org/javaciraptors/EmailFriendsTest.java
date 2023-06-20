package org.javaciraptors;

import org.javaciraptors.model.ProductPage;
import org.javaciraptors.runner.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailFriendsTest extends BaseTest {

    @Test
    public void testSendEmailWithoutLogin() {
        final String email = "111@222.com";
        final String senderEmail = "000@000.com";
        final String message = "Hello! Have a nice day!";
        final String fail = "Only registered customers can use email a friend feature";

        getDriver().findElement(
                By.xpath("//div[@class='picture']//img[@title='Show details for 14.1-inch Laptop']")).click();

        String error = new ProductPage(getDriver())
                .clickEmailFriends()
                .addFriendEmail(email)
                .addMyEmail(senderEmail)
                .addMessage(message)
                .clickSendEmail()
                .getError();

        Assert.assertEquals(error, fail);
    }
}
