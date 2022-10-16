package za.ac.cput.entity;

/*  DateController.java Entity for the Date
    Author: Shasta Storme Abrahams (217059376)
    Date: 26 March 2022
*/

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Date implements Serializable {
    @NotNull @Id
    private String dateNum;
    @NotNull
    private String venueAvailability;
    @NotNull
    private String venueId;
    @NotNull
    private String bookingNum;

    protected Date() {}

    private Date(Builder builder) {
        this.dateNum = builder.dateNum;
        this.venueAvailability = builder.venueAvailability;
        this.venueId = builder.venueId;
        this.bookingNum = builder.bookingNum;
    }

    public String getDateNum() {
        return dateNum;
    }

    public String getVenueAvailability() {
        return venueAvailability;
    }

    public String getVenueId() {
        return venueId;
    }

    public String getBookingNum() {
        return bookingNum;
    }

    @Override
    public String toString() {
        return "Date{" +
                "dateNum='" + dateNum + '\'' +
                ", venueAvailability='" + venueAvailability + '\'' +
                ", venueId='" + venueId + '\'' +
                ", bookingNum='" + bookingNum + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return Objects.equals(dateNum, date.dateNum) && Objects.equals(venueAvailability, date.venueAvailability) && Objects.equals(venueId, date.venueId) && Objects.equals(bookingNum, date.bookingNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateNum, venueAvailability, venueId, bookingNum);
    }

    public static class Builder {
        private String dateNum;
        private String venueAvailability;
        private String venueId;
        private String bookingNum;

        public Builder setDateNum(String dateNum) {
            this.dateNum = dateNum;
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

        public Builder setBookingNum(String bookingNum) {
            this.bookingNum = bookingNum;
            return this;
        }

        public Builder copy(Date date) {
            this.dateNum = date.dateNum;
            this.venueAvailability = date.venueAvailability;
            this.venueId = date.venueId;
            return this;
        }

        public Date build() {
            return new Date(this);
        }
    }



}
