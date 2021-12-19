package com.parkingLot.model;

public class ParkingSlot {
    private int id;
    private boolean isOccupied;
    private ParkingSlotType slotType;
    private Vehicle vehicle;

    public ParkingSlot(int id, ParkingSlotType slotType) {
        this.id = id;
        this.isOccupied = false;
        this.slotType = slotType;
        this.vehicle = null;
    }

    public int getId() {
        return id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public ParkingSlotType getSlotType() {
        return slotType;
    }

    public void assignVehicle(Vehicle vehicle){
        if(this.slotType == vehicle.getType().getSuitableSlotType()) {
            this.vehicle = vehicle;
            this.isOccupied = true;
        }
    }

    public void usassignVehicle(){
        this.vehicle = null;
        this.isOccupied = false;
    }
}
