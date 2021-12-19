package com.parkingLot.model;

public enum VehicleType {
    BIKE(ParkingSlotType.SMALL),
    CAR(ParkingSlotType.MEDIUM),
    TRUCK(ParkingSlotType.LARGE);

    private final ParkingSlotType suitableSlotType;

    VehicleType(ParkingSlotType slotType){
        this.suitableSlotType = slotType;
    }

    public ParkingSlotType getSuitableSlotType(){
        return this.suitableSlotType;
    }
}
