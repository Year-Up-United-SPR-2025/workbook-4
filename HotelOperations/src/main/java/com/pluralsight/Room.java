package com.pluralsight;

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
