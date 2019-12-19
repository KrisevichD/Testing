package edu.krsvch.webdriver.pageobject;

import edu.krsvch.webdriver.driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPage {
    protected final Logger LOGGER = LogManager.getRootLogger();
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    @FindBy(xpath = "//body")
    private WebElement body;

    protected WebDriver driver;

    public AbstractPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    public abstract AbstractPage openPage();

    protected void focusAway() {
        body.click();
        LOGGER.info("Focus away.");
    }
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    protected void waitUntil(ExpectedCondition<WebElement> expectedCondition) {
        LOGGER.info("Start wait until " + expectedCondition + "...");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(expectedCondition);
        LOGGER.info("Finish wait.");
    }
}
