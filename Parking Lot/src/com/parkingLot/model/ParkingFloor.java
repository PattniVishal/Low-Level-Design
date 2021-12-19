package com.parkingLot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private int floorNumber;
    private int numberOfSlots;
    private Map<ParkingSlotType, List<ParkingSlot>> parkingSlots;
    private Map<ParkingSlotType, Integer> slotDistribution;

    public ParkingFloor(int floorNumber, int numberOfSlots) {
        this.floorNumber = floorNumber;
        this.numberOfSlots = numberOfSlots;
        setupParkingSlots();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public ParkingSlot findSlotForVehicle(Vehicle vehicle){
        ParkingSlotType slotTypeExpected = vehicle.getType().getSuitableSlotType();
        List<ParkingSlot> slots = parkingSlots.get(slotTypeExpected);
        for(ParkingSlot s: slots){
            if(!s.isOccupied()){
                return s;
            }
        }
        return null;
    }

    /* -------------------- HELPER METHODS -------------------- */
    private void setupParkingSlots(){
        initSlotDistributionMap();
        for(Map.Entry<ParkingSlotType, Integer> kv: slotDistribution.entrySet()){
            initSlots(1, kv.getValue(), kv.getKey());
        }
    }

    private void initSlotDistributionMap(){
        slotDistribution.put(ParkingSlotType.LARGE, 1);
        slotDistribution.put(ParkingSlotType.SMALL, 2);
        slotDistribution.put(ParkingSlotType.MEDIUM, this.numberOfSlots - 3);
    }

    private void initSlots(int startId, int numberOfSlots, ParkingSlotType slotType){
        List<ParkingSlot> slots = new ArrayList<>();
        for (int i = 0; i < numberOfSlots; i++) {
            slots.add(new ParkingSlot(i + startId, slotType));
        }
        parkingSlots.put(slotType, slots);
    }
}
