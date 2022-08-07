package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Id;
/*Booking.java Entity for the Booking
Author: Mariam Gallie (219094837)
Date: 26 March 2022
updated: 6 August 2022
*/
@Entity
public class Booking implements Serializable {
    @NotNull
    @Id
    private String bookingNum;
    @NotNull
    private String clientNum;
    @NotNull
    private String date;


    protected Booking() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return bookingNum.equals(booking.bookingNum) && clientNum.equals(booking.clientNum) && date.equals(booking.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingNum, clientNum, date);
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