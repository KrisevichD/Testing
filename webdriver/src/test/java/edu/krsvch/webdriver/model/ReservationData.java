package edu.krsvch.webdriver.model;


import java.util.Objects;

public class ReservationData {
    private String goingTo;
    private String checkInDate;
    private String checkOutDate;

    public ReservationData() {
    }

    public ReservationData(String goingTo, String checkInDate, String checkOutDate) {
        this.goingTo = goingTo;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getGoingTo() {
        return goingTo;
    }

    public void setGoingTo(String goingTo) {
        this.goingTo = goingTo;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservationData)) return false;
        ReservationData that = (ReservationData) o;
        return Objects.equals(getGoingTo(), that.getGoingTo()) &&
                Objects.equals(getCheckInDate(), that.getCheckInDate()) &&
                Objects.equals(getCheckOutDate(), that.getCheckOutDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGoingTo(), getCheckInDate(), getCheckOutDate());
    }

    @Override
    public String toString() {
        return "ReservationData{" +
                "goingTo='" + goingTo + '\'' +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                '}';
    }
}
