package edu.krsvch.webdriver.test;

import edu.krsvch.webdriver.model.Account;
import edu.krsvch.webdriver.model.ReservationData;
import edu.krsvch.webdriver.pageobject.HomePage;
import edu.krsvch.webdriver.pageobject.LastSearchesPage;
import edu.krsvch.webdriver.pageobject.ResultPage;
import edu.krsvch.webdriver.service.AccountCreator;
import edu.krsvch.webdriver.service.ReservationDataCreator;
import edu.krsvch.webdriver.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends CommonConditions{
    private static final String TEST_DATA_CASE1_ERROR_MESSAGE_EXPECTED = "test-data.case1.error-message-expected";
    private static final String TEST_DATA_CASE2_ERROR_MESSAGE1_EXPECTED = "test-data.case2.error-message1-expected";
    private static final String TEST_DATA_CASE2_ERROR_MESSAGE2_EXPECTED = "test-data.case2.error-message2-expected";
    private static final String TEST_DATA_CASE4_ERROR_MESSAGE_EXPECTED = "test-data.case4.error-message-expected";
    private static final String TEST_DATA_CASE5_ACCOUNT_NAME="test-data.case5.account-name";
    private static final String TEST_DATA_CASE9_LANGUAGE_ID="2058";

    @Test(description = "case 1: Search hotel without filling in parameters")
    public void searchHotelsWithEmptyParams() {
        HomePage page = new HomePage().openPage();
        ResultPage resultPage = page.search();
        Assert.assertEquals(resultPage.getErrorMessage(), TestDataReader.getTestData(TEST_DATA_CASE1_ERROR_MESSAGE_EXPECTED));
    }

    @Test(description = "case 2: Search hotel with impossible and past date in parameters")
    public void searchHotelsWithIncorrectDate() {
        HomePage page = new HomePage().openPage();
        ReservationData data = ReservationDataCreator.withIncorrectDate();
        ResultPage resultPage = page.fillGoingToInput(data)
                .fillCheckInInput(data)
                .fillCheckOutInput(data)
                .search();
        Assert.assertEquals(resultPage.getErrorMessage1(), TestDataReader.getTestData(TEST_DATA_CASE2_ERROR_MESSAGE1_EXPECTED));
    }

    @Test(description = "case 3: Search hotel with correct place and date")
    public void searchHotelsWithCorrectPlaceAndDate() {
        HomePage page = new HomePage().openPage();
        ReservationData data = ReservationDataCreator.withCorrectPlaceAndDate();
        ResultPage resultPage = page.fillGoingToInput(data)
                .fillCheckInInput(data)
                .fillCheckOutInput(data)
                .search();
        Assert.assertEquals(resultPage.getGoingToData(), data.getGoingTo());
    }

    @Test(description = "case 4: Search hotel with same 'flying from' and 'going to' data")
    public void searchHotelsWithSameFlyingFromAndGoingToData() {
        HomePage page = new HomePage().openPage();
        ReservationData data = ReservationDataCreator.withCorrectPlaceAndDate();
        ResultPage resultPage = page.fillGoingToInput(data)
                .enableFlightCheckbox()
                .fillFlyingFromInput(data.getGoingTo())
                .search();
        Assert.assertEquals(resultPage.getErrorMessage3(), TestDataReader.getTestData(TEST_DATA_CASE4_ERROR_MESSAGE_EXPECTED));
    }
/*
    @Test(description = "case 5: You can sign in account with correct email and password")
    public void signInWithCorrectEmailAndPassword(){
        HomePage page = new HomePage().openPage();
        Account data = AccountCreator.withCorrectData();
        HomePage homePage = page.openSignInForm()
                .fillAccountData(data)
                .signInButtonClick();
        Assert.assertEquals(homePage.getAccountName(), TestDataReader.getTestData(TEST_DATA_CASE5_ACCOUNT_NAME));
        homePage.signOut();
    }

    @Test(description = "case 6: Test that after searching you have data of your last search in your account")
    public void testTheAvailabilityOfTheLeastSearchData(){
        HomePage page = new HomePage().openPage();
        Account accountData = AccountCreator.withCorrectData();
        ReservationData reservationData = ReservationDataCreator.withCorrectPlaceAndDate();
        LastSearchesPage lastSearchesPage = page.openSignInForm()
                .fillAccountData(accountData)
                .signInButtonClick()
                .fillGoingToInput(reservationData)
                .search()
                .openLastSearches();
        Assert.assertEquals(lastSearchesPage.getLatestSearchPlace(), reservationData.getGoingTo());
        lastSearchesPage.removeLatestSearchData();
        lastSearchesPage.signOut();
    }

    @Test(description = "case 7: Test that after adding hotel to favorites you can find it in your account")
    public void testTheAvailabilityOfTheSavedHotels(){
        HomePage page = new HomePage().openPage();
        Account accountData = AccountCreator.withCorrectData();
        ReservationData reservationData = ReservationDataCreator.withCorrectPlaceAndDate();
        LastSearchesPage lastSearchesPage = page.openSignInForm()
                .fillAccountData(accountData)
                .signInButtonClick()
                .fillGoingToInput(reservationData)
                .search()
                .saveToFavorites()
                .openSavedItems();
        Assert.assertEquals(lastSearchesPage.getLatestSavedPlace(), reservationData.getGoingTo());
        lastSearchesPage.removeSavedItem();
        lastSearchesPage.signOut();
    }
*/
    @Test(description = "case 8: Input the same 'Check in' and 'Check Out' date")
    public void inputSameCheckInAndCheckOutDate() {
        HomePage page = new HomePage().openPage();
        ReservationData data = ReservationDataCreator.withCorrectPlaceAndDate();
        data.setCheckOutDate(data.getCheckInDate());
        page.fillGoingToInput(data)
                .fillCheckInInput(data)
                .fillCheckOutInput(data);
        Assert.assertNotEquals(page.getCheckOutDate(), page.getCheckInDate());
    }


    @Test(description = "case 9: Change language to spanish")
    public void changeLanguageToSpanish() {
        HomePage page = new HomePage().openPage();
        page.changeLanguage();
        Assert.assertEquals(page.getLanguageId(), TEST_DATA_CASE9_LANGUAGE_ID);
    }

    @Test(description = "case 10: Test that logo button translates to the home page ")
    public void testLogoButton() {
        HomePage page = new HomePage().openPage();
        String homeUrl = page.getUrl();
        ReservationData data = ReservationDataCreator.withCorrectPlaceAndDate();
        ResultPage resultPage = page.fillGoingToInput(data)
                .search()
                .logoButtonClick();
        Assert.assertEquals(resultPage.getUrl(), homeUrl);
    }



}