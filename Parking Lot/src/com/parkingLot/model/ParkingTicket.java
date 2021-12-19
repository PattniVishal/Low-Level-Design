package com.parkingLot.model;

import java.time.LocalDateTime;

public class ParkingTicket {
    String ticketId;
    Integer floorId;
    ParkingSlot parkingSlot;
    Vehicle vehicle;
    LocalDateTime issuedAt;

    public ParkingTicket(ParkingSlot parkingSlot, Integer floorId, Vehicle vehicle) {
        this.ticketId = "P1234" + floorId + parkingSlot.getId();
        this.parkingSlot = parkingSlot;
        this.floorId = floorId;
        this.vehicle = vehicle;
        this.issuedAt = LocalDateTime.now();
    }

    public String getTicketId() {
        return ticketId;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void showTicket(){

    }
}
