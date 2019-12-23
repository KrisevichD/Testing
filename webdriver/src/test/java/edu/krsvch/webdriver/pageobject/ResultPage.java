package edu.krsvch.webdriver.pageobject;

import edu.krsvch.webdriver.model.ReservationData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"hotel-destination-hp-hotel\"]")
    private WebElement goingToInput;

    @FindBy(xpath = "//*[@id=\"hotel-checkin-hp-hotel\"]    ")
    private WebElement checkInInput;

    @FindBy(xpath = "//*[@id=\"hotel-checkout-hp-hotel\"]")
    private WebElement checkOutInput;

    @FindBy(xpath = "//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[7]/label/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[1]/div/ul/li/a")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[1]/div/ul/li[1]/a")
    private WebElement errorMessage1;

    @FindBy(xpath = "//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[1]/div/ul/li[2]/a")
    private WebElement errorMessage2;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div/div/div[1]/div/section/div/form/div[1]/div/div/button")
    private WebElement goingToData;

    @FindBy(xpath = "//*[@id=\"acol-errorDiv\"]/p/strong")
    private WebElement errorMessage3;

    @FindBy(xpath = "//*[@class=\"uitk-link uitk-link-layout-default uitk-type-300\"]//*[Text()=\"Sign out\"]")
    private WebElement accountButtonPopUp;
    @FindBy(xpath = "//*[@class=\"uitk-link uitk-link-layout-default uitk-type-300\"]//*[Text()=\"List of Favorites\"]")
    private WebElement listOfFavoritesButton;
    @FindBy(xpath = "//*[@id=\"uitk-tabs-container\"]/ul/li[2]/a")
    private WebElement recentSearchesButton;

    @FindBy(xpath = "//*[@class=\"uitk-favorite-switch\"]")
    private WebElement addToFavoriteButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div/header/div/div/a")
    private WebElement logoButton;

    @Override
    public ResultPage openPage() {
        LOGGER.info("Result page opened");
        return this;
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
    public String getErrorMessage1(){
        return errorMessage1.getText();
    }
    public String getErrorMessage2(){
        return errorMessage2.getText();
    }
    public String getErrorMessage3(){
        waitUntil(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"acol-errorDiv\"]/p/strong")));
        return errorMessage3.getText();
    }

    public String getGoingToData(){
        return goingToData.getText();
    }

    public LastSearchesPage openLastSearches(){
        accountButtonPopUp.click();
        listOfFavoritesButton.click();
        recentSearchesButton.click();
        LOGGER.info("Last searches was opened");
        return new LastSearchesPage();
    }

    public LastSearchesPage openSavedItems(){
        accountButtonPopUp.click();
        listOfFavoritesButton.click();
        LOGGER.info("Saved items was opened");
        return new LastSearchesPage();
    }

    public ResultPage logoButtonClick(){
        logoButton.click();
        LOGGER.info("Logo button was clicked");
        return this;
    }

    public ResultPage saveToFavorites(){
        addToFavoriteButton.click();
        LOGGER.info("Hotel was saved to favorites");
        return this;
    }





}
