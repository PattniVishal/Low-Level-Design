package com.parkingLot.model.parking;

import com.parkingLot.model.gate.Gate;

import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> floors;
    private List<Gate> gates;

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }
}
