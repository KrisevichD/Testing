package edu.krsvch.webdriver.test;

import edu.krsvch.webdriver.model.ReservationData;
import edu.krsvch.webdriver.pageobject.HomePage;
import edu.krsvch.webdriver.pageobject.ResultPage;
import edu.krsvch.webdriver.service.ReservationDataCreator;
import edu.krsvch.webdriver.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends CommonConditions{
    private static final String TEST_DATA_CASE1_ERROR_MESSAGE_EXPECTED = "test-data.case1.error-message-expected";
    private static final String TEST_DATA_CASE2_ERROR_MESSAGE1_EXPECTED = "test-data.case2.error-message1-expected";
    private static final String TEST_DATA_CASE2_ERROR_MESSAGE2_EXPECTED = "test-data.case2.error-message2-expected";
    private static final String TEST_DATA_CASE4_ERROR_MESSAGE_EXPECTED = "test-data.case4.error-message-expected";

    @Test(description = "case 1: Search hotel without filling in parameters")
    public void searchHotelsWithEmptyParams() {
        HomePage page = new HomePage().openPage();
        ResultPage resultPage = page.search();
        Assert.assertEquals(resultPage.getErrorMessage(), TestDataReader.getTestData(TEST_DATA_CASE1_ERROR_MESSAGE_EXPECTED));
    }

    @Test(description = "case 2: Search hotel with impossible and past date in parameters")
    public void searchHotelsWithIncorrectDate() {
        HomePage page = new HomePage().openPage();
        ReservationData data = ReservationDataCreator.withParamsFromPropertiesCase2();
        ResultPage resultPage = page.fillGoingToInput(data)
                .fillCheckInInput(data)
                .fillCheckOutInput(data)
                .search();
        Assert.assertEquals(resultPage.getErrorMessage1(), TestDataReader.getTestData(TEST_DATA_CASE2_ERROR_MESSAGE1_EXPECTED));
        Assert.assertEquals(resultPage.getErrorMessage2(), TestDataReader.getTestData(TEST_DATA_CASE2_ERROR_MESSAGE2_EXPECTED));
    }

    @Test(description = "case 3: Search hotel with correct data")
    public void searchHotelsWithCorrectData() {
        HomePage page = new HomePage().openPage();
        ReservationData data = ReservationDataCreator.withParamsFromPropertiesCase3();
        ResultPage resultPage = page.fillGoingToInput(data)
                .fillCheckInInput(data)
                .fillCheckOutInput(data)
                .search();
        Assert.assertEquals(resultPage.getGoingToData(), data.getGoingTo());
    }

    @Test(description = "case 4: Search hotel with same 'flying from' and 'going to' data")
    public void searchHotelsWithSameFlyingFromAndGoingToData() {
        HomePage page = new HomePage().openPage();
        ReservationData data = ReservationDataCreator.withParamsFromPropertiesCase3();
        ResultPage resultPage = page.fillGoingToInput(data)
                .enableFlightCheckbox()
                .fillFlyingFromInput(data.getGoingTo())
                .search();
        Assert.assertEquals(resultPage.getErrorMessage3(), TestDataReader.getTestData(TEST_DATA_CASE4_ERROR_MESSAGE_EXPECTED));
    }
}