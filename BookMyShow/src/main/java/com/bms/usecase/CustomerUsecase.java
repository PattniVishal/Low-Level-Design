package com.bms.usecase;

import com.bms.model.Movie;
import com.bms.model.Show;

public interface CustomerUsecase {
    public void registerCustomer();

    public Movie searchMovieByTitle();
    public Movie searchMovieByLanguage();
    public Movie searchMovieByGenre();
    public Movie searchMovieByCity();

    public Show getShowByShowId();

    public void createBooking();
}
