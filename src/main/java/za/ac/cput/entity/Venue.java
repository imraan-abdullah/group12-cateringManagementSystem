package za.ac.cput.entity;

/*
 * Venue.java
 * Entity for the Venue
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 26 March 2022
 * Edited 05 August 2022
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Venue implements Serializable { //allows us to convert an Object to stream
    @NotNull @Id private String venueID;
    @NotNull private String buildingName;
    @NotNull private int numberOfSeats;

    //Constructor
    private Venue(Builder builder){
        this.venueID = builder.venueID;
        this.buildingName = builder.buildingName;
        this.numberOfSeats = builder.numberOfSeats;
    }

    public Venue() {

    }

    //Getters
    public String getVenueID() {
        return venueID;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    //toString() method
    @Override
    public String toString() {
        return "Venue{" +
                "venueID=" + venueID +
                ", buildingName='" + buildingName + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Venue venue = (Venue) o;
        return numberOfSeats == venue.numberOfSeats &&
                venueID.equals(venue.venueID) &&
                buildingName.equals(venue.buildingName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(venueID, buildingName, numberOfSeats);
    }

    public static class Builder{
        private String venueID;
        private String buildingName;
        private int numberOfSeats;

        //Setters
        public Builder setVenueID(String venueID) {
            this.venueID = venueID;
            return this;
        }

        public Builder setBuildingName(String buildingName) {
            this.buildingName = buildingName;
            return this;
        }

        public Builder setNumberOfSeats(int numberOfSeats) {
            this.numberOfSeats = numberOfSeats;
            return this;
        }

        //copy
        public Builder copy(Venue venue) {
            this.venueID = venue.venueID;
            this.buildingName = venue.buildingName;
            this.numberOfSeats = venue.numberOfSeats;
            return this;
        }

        public Venue build(){
            return new Venue(this);
        }
    }
}

