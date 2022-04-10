package za.ac.cput.entity;

/*  Date.java Entity for the Date
    Author: Shasta Storme Abrahams (217059376)
    Date: 26 March 2022
*/

public class Date {
    private String bookingNum;
    private String venueAvailability;
    private String venueId;

    private Date() {}

    private Date(Builder builder) {
        this.bookingNum = builder.bookingNum;
        this.venueAvailability = builder.venueAvailability;
        this.venueId = builder.venueId;
    }

    public String getBookingNum() {
        return bookingNum;
    }

    public String getVenueAvailability() {
        return venueAvailability;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setBookingNum(String bookingNum) {
        this.bookingNum = bookingNum;
    }

    public void setVenueAvailability(String venueAvailability) {
        this.venueAvailability = venueAvailability;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }


    @Override
    public String toString() {
        return "Date{" +
                ", bookingNum='" + bookingNum + '\'' +
                "venueAvailability='" + venueAvailability + '\'' +
                ", venueId='" + venueId + '\'' +
                '}';
    }

    public static class Builder {
        private String bookingNum;
        private String venueAvailability;
        private String venueId;

        public Builder setBookingNum(String bookingNum) {
            this.bookingNum = bookingNum;
            return this;
        }

        public Builder setVenueAvailability(String venueAvailability) {
            this.venueAvailability = venueAvailability;
            return this;
        }

        public Builder setVenueId(String venueId) {
            this.venueId = venueId;
            return this;
        }


        public Builder copy(Date date) {
            this.bookingNum = date.bookingNum;
            this.venueAvailability = date.venueAvailability;
            this.venueId = date.venueId;
            return this;
        }

        public Date build() {
            return new Date(this);
        }
    }
}
