package com.parkingLot.model.vehicle;

import com.parkingLot.model.parking.ParkingSlotType;

import java.util.Arrays;
import java.util.List;

public enum VehicleType {
    MOTORCYCLE(Arrays.asList(ParkingSlotType.MOTORCYCLE, ParkingSlotType.COMPACT, ParkingSlotType.LARGE)),
    CAR(Arrays.asList(ParkingSlotType.COMPACT, ParkingSlotType.LARGE)),
    TRUCK(Arrays.asList(ParkingSlotType.LARGE)),
    VAN(Arrays.asList(ParkingSlotType.LARGE));

    private final List<ParkingSlotType> suitableSlotTypes;

    VehicleType(List<ParkingSlotType> slotTypes){
        this.suitableSlotTypes = slotTypes;
    }

    public List<ParkingSlotType> getSuitableSlotTypes(){
        return this.suitableSlotTypes;
    }
}
