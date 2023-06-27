package org.javaciraptors.model.base;

import org.javaciraptors.model.component.MainHeaderComponent;
import org.openqa.selenium.WebDriver;

public abstract class BaseMainHeaderPage<Self extends BaseMainHeaderPage<?>> extends BasePage<MainHeaderComponent<Self>> {

    public BaseMainHeaderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainHeaderComponent<Self> getHeader() {
        return new MainHeaderComponent<>((Self) this);
    }
}
