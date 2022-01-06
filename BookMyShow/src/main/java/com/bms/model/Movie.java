package com.bms.model;

import com.bms.model.users.Admin;

import java.util.Date;
import java.util.List;

public class Movie extends DBObject {
    String title;
    String description;
    String language;
    String genre;
    Date releaseDate;
    List<Show> shows;
    List<Cinema> cinemas;
}
