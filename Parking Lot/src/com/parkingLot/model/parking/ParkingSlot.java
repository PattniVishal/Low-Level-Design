package com.parkingLot.model.parking;

import com.parkingLot.model.vehicle.Vehicle;

public class ParkingSlot {
    ParkingSlotType type;
    ParkingSlotStatus status;
    Vehicle vehicle;

    public ParkingSlot(ParkingSlotType type) {
        this.type = type;
        this.status = ParkingSlotStatus.FREE;
    }

    public void assignVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.status = ParkingSlotStatus.OCCUPIED;
    }

    public void unassignVehicle(){
        this.vehicle = null;
        this.status = ParkingSlotStatus.FREE;
    }
}
