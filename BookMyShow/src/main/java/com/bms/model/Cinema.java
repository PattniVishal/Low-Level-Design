package com.bms.model;

import java.util.List;

public class Cinema extends DBObject {
    String name;
    String city;
    List<CinemaHall> halls;
}
