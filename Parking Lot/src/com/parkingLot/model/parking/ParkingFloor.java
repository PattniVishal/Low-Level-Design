package com.parkingLot.model.parking;

import com.parkingLot.model.electronics.CustomerInfoPortal;
import com.parkingLot.model.electronics.DisplayBoard;
import com.parkingLot.model.vehicle.Vehicle;

import java.util.*;

public class ParkingFloor {
    private String floorName;
    private DisplayBoard displayBoard;
    private CustomerInfoPortal customerInfoPortal;
    private Map<ParkingSlotType, Set<ParkingSlot>> freeSlots;
    private Map<ParkingSlotType, Set<ParkingSlot>> occupiedSlots;

    public ParkingFloor(String floorName) {
        this.floorName = floorName;
        this.displayBoard = new DisplayBoard();
        this.customerInfoPortal = new CustomerInfoPortal();
        this.freeSlots = new HashMap<>();
        this.occupiedSlots = new HashMap<>();
    }

    public void assignParkingSlot(ParkingSlot slot, Vehicle vehicle){
        // check if Vehicle can fit in the Slot
        // slot.assignVehicle()
        // remove Slot from freeSlots, add Slot to occupiedSlots
        // updateDisplayBoard
    }

    public void unassignParkingSlot(ParkingSlot slot){
        // slot.unassignVehicle()
        // remove Slot from occupiedSlots, add Slot to freeSlots
        // updateDisplayBoard
    }

    private void updateDisplayBoard(){
        // Floor Number
        // Free Slots : <SlotType, Number of free slots>
        // Occupied Slots : <SlotType, Number of occupied slots>
    }
}
