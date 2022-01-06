package com.bms.model;

import java.util.Date;
import java.util.List;

public class Show extends DBObject {
    Date startTime;
    Date endTime;
    Movie movie;
    CinemaHall cinemaHall;
    List<ShowSeat> seats;
}
