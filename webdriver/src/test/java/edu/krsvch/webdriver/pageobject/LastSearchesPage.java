package edu.krsvch.webdriver.pageobject;

import edu.krsvch.webdriver.model.Account;
import edu.krsvch.webdriver.model.ReservationData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LastSearchesPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/button\n")
    private WebElement accountButton;

    @FindBy(xpath = "//*[@class=\"uitk-link uitk-link-layout-default uitk-type-300\"]//*[Text()=\"Sign out\"]")
    private WebElement signOutButton;

    @FindBy(xpath = "//*[@class=\"uitk-type-300 uitk-type-bold card-title-color all-y-padding-one all-x-padding-two all-cell-fill\"]//*[Text()=\"Minsk Arena\"]")
    private WebElement latestSearch;

    @FindBy(xpath = "//*[@id=\"80001-382941131-Minsk Arena, Minsk, Belarus-553248621563233781-2019-12-31-2020-01-01\"]")
    private WebElement removeButton;

    @FindBy(xpath = "//*[@id=\"80001-382941131-8783264-hotel\"]/a")
    private WebElement latestSavedItem;

    @FindBy(xpath = "//*[@id=\"80001-382941131-8783264-hotel\"]/span/svg/svg/path")
    private WebElement removeSavedItemButton;


    public LastSearchesPage() {
    }

    @Override
    public LastSearchesPage openPage() {
        return this;
    }

    public String getLatestSearchPlace(){
        return latestSearch.getText();
    }

    public String getLatestSavedPlace(){
        return latestSavedItem.getText();
    }

    public LastSearchesPage removeLatestSearchData(){
        LOGGER.info("Latest Search was removed");
        removeButton.click();
        return this;
    }

    public LastSearchesPage removeSavedItem(){
        LOGGER.info("Latest saved item was removed");
        removeSavedItemButton.click();
        return this;
    }

    public void signOut(){
        LOGGER.info("Sign Out from account");
        accountButton.click();
        signOutButton.click();
    }
}
