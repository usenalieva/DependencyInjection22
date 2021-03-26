package com.makhabatusen.dependencyinjection.data.source;

import com.makhabatusen.dependencyinjection.data.models.Film;

import java.util.List;

public interface RoomSource {
    void insertToFav(Film film);
    void deleteFromFav(Film film);
    List<Film> getFavoriteFilms();
}
