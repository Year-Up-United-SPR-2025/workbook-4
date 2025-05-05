package com.pluralsight;


//Room
//The Room class is responsible for knowing everything related to a hotel room. A
//room is only available if it is clean and not currently occupied. Create the class
//with the following getters:
//getNumberOfBeds()
//getPrice()
//isOccupied()
//isDirty()
//isAvailable()

public class Room {
    public int getNumberOfBeads;
    public double getPrice;
    public String isOccupied;
    public String isDirty;
    public String isAvailable;

    public Room(int getNumberOfBeads, double getPrice, String isOccupied, String isDirty, String isAvailable) {
        this.getNumberOfBeads = getNumberOfBeads;
        this.getPrice = getPrice;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
        this.isAvailable = isAvailable;
    }

    public int getGetNumberOfBeads() {
        return getNumberOfBeads;
    }

    public double getGetPrice() {
        return getPrice;
    }

    public String getIsOccupied() {
        return isOccupied;
    }

    public String getIsDirty() {
        return isDirty;
    }

    public String getIsAvailable() {
        return isAvailable;
    }
}
