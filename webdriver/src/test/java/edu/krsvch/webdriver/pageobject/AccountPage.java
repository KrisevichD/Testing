package edu.krsvch.webdriver.pageobject;

import edu.krsvch.webdriver.model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"gss-signin-email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"gss-signin-password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"gss-signin-submit\"]")
    private WebElement signInButton;

    public AccountPage() {
    }

    @Override
    public AccountPage openPage() {
        return this;
    }

    public AccountPage fillAccountData(Account data){
        waitUntil(ExpectedConditions.elementToBeClickable(emailInput));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(data.getEmail());
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(data.getPassword());
        LOGGER.info("Account data added");
        return this;
    }

    public ResultPage signInButtonClick(){
        signInButton.click();
        LOGGER.info("Sign in button clicked");
        return new ResultPage();
    }
}
