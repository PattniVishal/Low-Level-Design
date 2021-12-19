package com.parkingLot.model;

public class Vehicle {
    String registrationNumber;
    String color;
    VehicleType type;
    ParkingTicket parkingTicket;

    public Vehicle(String registrationNumber, String color , VehicleType type) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

    public void assignTicket(ParkingTicket ticket){
        this.parkingTicket = ticket;
    }
}
