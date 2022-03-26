package src.main.java.za.ac.cput.entity;

/*Booking.java Entity for the Booking
Author: Mariam Gallie (219094837)
Date: 26 March 2022
*/

public class Booking {

    private String bookingNum;
    private String clientNum;
    private String date;

    private Booking() {
    }

    private Booking(Builder builder) {
        this.bookingNum = builder.bookingNum;
        this.clientNum = builder.clientNum;
        this.date = builder.date;
    }

    public String getBookingNum() {
        return bookingNum;
    }

    public String getClientNum() {
        return clientNum;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingNum='" + bookingNum + '\'' +
                ", clientNum='" + clientNum + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public static class Builder {
        private String bookingNum;
        private String clientNum;
        private String date;


        public Builder setBookingNum(String bookingNum) {
            this.bookingNum = bookingNum;
            return this;
        }

        public Builder setClientNum(String clientNum) {
            this.clientNum = clientNum;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder copy(Booking booking) {
            this.bookingNum = booking.bookingNum;
            this.clientNum = booking.clientNum;
            this.date = booking.date;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}