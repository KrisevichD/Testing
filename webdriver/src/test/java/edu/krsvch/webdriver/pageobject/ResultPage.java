package edu.krsvch.webdriver.pageobject;

import edu.krsvch.webdriver.model.ReservationData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        return errorMessage3.getText();
    }

    public String getGoingToData(){
        return goingToData.getText();
    }

}
