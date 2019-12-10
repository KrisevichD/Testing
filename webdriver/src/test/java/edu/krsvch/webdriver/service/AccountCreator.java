package edu.krsvch.webdriver.service;

import edu.krsvch.webdriver.model.Account;

public class AccountCreator {
    private static final String TEST_DATA_CASE5_EMAIL = "test-data.case5.email";
    private static final String TEST_DATA_CASE5_PASSWORD = "test-data.case5.password";
    public static Account withCorrectData(){
        return new Account(TestDataReader.getTestData(TEST_DATA_CASE5_EMAIL)
                ,TestDataReader.getTestData(TEST_DATA_CASE5_PASSWORD));
    }
}
