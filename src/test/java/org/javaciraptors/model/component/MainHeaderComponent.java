package org.javaciraptors.model.component;

import org.javaciraptors.model.MainPage;
import org.javaciraptors.model.base.BaseHeaderComponent;
import org.javaciraptors.model.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainHeaderComponent<Page extends BasePage<?>> extends BaseHeaderComponent<Page> {

    @FindBy(xpath = "//img[@alt='Tricentis Demo Web Shop']")
    private WebElement logo;

    @FindBy(linkText = "Register")
    private WebElement registerButton;

    public MainHeaderComponent(Page page) {
        super(page);
    }

    public MainPage clickLogo() {
        logo.click();
        return new MainPage(getDriver());

    }

    public Page clickRegister() {
        registerButton.click();
        return getPage();

    }
}
