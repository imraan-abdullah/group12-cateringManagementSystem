package za.ac.cput.entity;

/*
 * Venue.java
 * Entity for the Venue
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 26 March 2022
 */
public class Venue {
    private int venueID;
    private String buildingName;
    private int numberOfSeats;

    //Constructor
    private Venue(Builder builder){
        this.venueID = builder.venueID;
        this.buildingName = builder.buildingName;
        this.numberOfSeats = builder.numberOfSeats;
    }

    //Getters
    public int getVenueID() {
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

    public static class Builder{
        private int venueID;
        private String buildingName;
        private int numberOfSeats;

        //Setters
        public Builder setVenueID(int venueID) {
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

