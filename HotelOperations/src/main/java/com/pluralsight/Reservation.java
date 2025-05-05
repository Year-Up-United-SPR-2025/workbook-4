package com.pluralsight;

//Reservation
//The Reservation class is responsible for storing information related to a guest
//stay.
//Determine which backing variables you need to create and create a constructor to
//set initial values.
//The room type can be either "king" or "double". If the room type is "king" the
//price per night is $139.00 if the room type is "double" the price per night is
//$124.00
//If the stay is over a weekend, the price per night should increase by 10%
//Create the class with the following getters and setters:
//getRoomType()
//setRoomType(String roomType)
//getPrice()
//getNumberOfNights()
//setNumberOfNights(int numberOfNights)
//isWeekend()
//setIsWeekend(boolean isWeekend)
//getReservationTotal()

public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        setRoomType(roomType);
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public String getRoomType() {
        return roomType;
    }


    private void setRoomType(String roomType) {
        if (roomType.equalsIgnoreCase("king") || roomType.equalsIgnoreCase("double")) {
            this.roomType = roomType.toLowerCase();
        } else {
            throw new RuntimeException("You must type 'king' or 'double'");
        }
    }

    public double getPrice() {
        double basePrice = roomType.equals("king") ? 139.00 : 124.00;
        if (isWeekend) {
            basePrice *= 1.10;
        }
        return basePrice;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public double getReservationTotal() {
        return getPrice() * numberOfNights;
    }
}