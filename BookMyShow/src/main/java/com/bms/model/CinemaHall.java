package com.bms.model;

import java.util.List;

public class CinemaHall extends DBObject {
    String name;
    List<CinemaHallSeat> seats;
    List<Show> shows;
}
