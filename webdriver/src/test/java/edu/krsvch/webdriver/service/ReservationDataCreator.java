package edu.krsvch.webdriver.service;

import edu.krsvch.webdriver.model.ReservationData;

public class ReservationDataCreator {
    private static final String TEST_DATA_CASE2_GOING_TO = "test-data.case2.going-to";
    private static final String TEST_DATA_CASE2_CHECK_IN_DATE = "test-data.case2.check-in-date";
    private static final String TEST_DATA_CASE2_CHECK_OUT_DATE = "test-data.case2.check-out-date";

    private static final String TEST_DATA_CASE3_GOING_TO = "test-data.case3.going-to";
    private static final String TEST_DATA_CASE3_CHECK_IN_DATE = "test-data.case3.check-in-date";
    private static final String TEST_DATA_CASE3_CHECK_OUT_DATE = "test-data.case3.check-out-date";

    public static ReservationData withIncorrectDate() {
        return new ReservationData(TestDataReader.getTestData(TEST_DATA_CASE2_GOING_TO)
                ,TestDataReader.getTestData(TEST_DATA_CASE2_CHECK_IN_DATE)
                ,TestDataReader.getTestData(TEST_DATA_CASE2_CHECK_OUT_DATE));
    }

    public static ReservationData withCorrectPlaceAndDate() {
        return new ReservationData(TestDataReader.getTestData(TEST_DATA_CASE3_GOING_TO)
                ,TestDataReader.getTestData(TEST_DATA_CASE3_CHECK_IN_DATE)
                ,TestDataReader.getTestData(TEST_DATA_CASE3_CHECK_OUT_DATE));
    }

    public static ReservationData withEmptyFields(){
        return new ReservationData("","","");
    }

}
