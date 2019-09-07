package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowseBooksPage extends BasePage {

    @FindBy(xpath = "//div[@class='init-right']//input[@type='submit']")
    private WebElement btnGo;

    public BrowseBooksPage(WebDriver wd) {
        super(wd);
    }

    public void clickGo() {
        waitElementToClick(btnGo);
        btnGo.click();
        waitForPageLoad();
    }
}
