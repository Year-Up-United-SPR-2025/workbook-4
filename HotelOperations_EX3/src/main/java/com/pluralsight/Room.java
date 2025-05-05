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
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    public String getAvailabilityStatus() {
        return isAvailable() ? "Available" : "Not Available";
    }

    public void checkIn() {
        if (!isAvailable()) {
            System.out.println("Room is not available for check-in.");
            return;
        }
        occupied = true;
        dirty = true;
        System.out.println("Guest has checked in. Room is now occupied and dirty.");
    }

    public void checkOut() {
        if (!occupied) {
            System.out.println("Room is not currently occupied.");
            return;
        }
        occupied = false;
        System.out.println("Guest has checked out. Room is dirty and needs to be cleaned.");
    }

    public void cleanRoom() {
        if (!dirty) {
            System.out.println("Room is already clean.");
        } else {
            dirty = false;
            System.out.println("Room has been cleaned and is ready for new guests.");
        }
    }
}