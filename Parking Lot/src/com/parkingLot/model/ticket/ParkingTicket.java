package com.parkingLot.model.ticket;

import com.parkingLot.model.parking.ParkingSlot;
import com.parkingLot.model.vehicle.Vehicle;

import java.time.LocalDateTime;

public class ParkingTicket {
    LocalDateTime issuedAt;
    TicketStatus status;

    public ParkingTicket(LocalDateTime issuedAt, TicketStatus status) {
        this.issuedAt = issuedAt;
        this.status = TicketStatus.ACTIVE;
    }

    public void closeTicket(){
        this.status = TicketStatus.CLOSED;
    }
}
