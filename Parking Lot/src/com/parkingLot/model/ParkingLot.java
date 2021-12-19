package com.parkingLot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    List<ParkingFloor> parkingFloors;
    Map<String, ParkingTicket> activeTickets;

    public ParkingLot(int floors, int slotsPerFloor) {
        this.capacity = floors * slotsPerFloor;
        this.parkingFloors = new ArrayList<>();
        this.activeTickets = new HashMap<>();
        for (int i = 0; i < floors; i++) {
            parkingFloors.add(new ParkingFloor(i+1, slotsPerFloor));
        }
    }

    public void park(Vehicle vehicle){
        for(ParkingFloor floor: parkingFloors){
            ParkingSlot slot = floor.findSlotForVehicle(vehicle);
            slot.assignVehicle(vehicle);
            ParkingTicket ticket = new ParkingTicket(slot, floor.getFloorNumber(), vehicle);
            activeTickets.put(ticket.getTicketId(), ticket);
            vehicle.assignTicket(ticket);
//            return ticket;
        }
    }

    public void unpark(String ticketId){
        ParkingTicket ticket = activeTickets.get(ticketId);
        ParkingSlot slot = ticket.getParkingSlot();
        slot.usassignVehicle();
        activeTickets.remove(ticketId);
        // calculate Amount
    }

    public void isSpaceAvailable(){

    }
}
