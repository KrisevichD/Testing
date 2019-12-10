package edu.krsvch.webdriver.pageobject;

import edu.krsvch.webdriver.model.ReservationData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    private final static String HOME_PAGE_URL = "https://www.travelocity.com/";

    @FindBy(xpath = "//*[@id=\"hotel-destination-hp-hotel\"]")
    private WebElement goingToInput;

    @FindBy(xpath = "//*[@id=\"hotel-checkin-hp-hotel\"]    ")
    private WebElement checkInInput;

    @FindBy(xpath = "//*[@id=\"hotel-checkout-hp-hotel\"]")
    private WebElement checkOutInput;

    @FindBy(xpath = "//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[7]/label/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"hotel-add-flight-checkbox-hp-hotel\"]")
    private WebElement flightCheckbox;

    @FindBy(xpath = "//*[@id=\"hotel-flight-origin-hp-hotel\"]")
    private WebElement flyingFromInput;


    public HomePage() {
    }

    @Override
    public HomePage openPage() {
        driver.get(HOME_PAGE_URL);
        LOGGER.info("Home page opened");
        return this;
    }


    public ResultPage search() {
        searchButton.click();
        LOGGER.info("Search button was clicked");
        return new ResultPage();

    }

    public HomePage fillGoingToInput(ReservationData reservationData) {
        goingToInput.sendKeys(reservationData.getGoingTo());
        focusAway();
        LOGGER.info("Inserted " + reservationData.getGoingTo()+ " to 'Going to' field");
        return this;
    }

    public HomePage fillCheckInInput(ReservationData reservationData) {
        checkInInput.sendKeys(reservationData.getCheckInDate());
        focusAway();
        LOGGER.info("Inserted " + reservationData.getCheckInDate()+" to 'Check in' field");
        return this;

    }

    public HomePage fillCheckOutInput(ReservationData reservationData) {
        checkOutInput.sendKeys(reservationData.getCheckOutDate());
        focusAway();
        LOGGER.info("Inserted " + reservationData.getCheckOutDate()+" to 'Check out' field");
        return this;

    }

    public HomePage enableFlightCheckbox() {
        flightCheckbox.click();
        focusAway();
        LOGGER.info("Enabled 'Add flight' checkbox.");
        return new HomePage();
    }

    public HomePage fillFlyingFromInput(String flyingFrom) {
        flyingFromInput.sendKeys(flyingFrom);
        focusAway();
        LOGGER.info("Filled 'Flying from' field.");
        return this;
    }
}

