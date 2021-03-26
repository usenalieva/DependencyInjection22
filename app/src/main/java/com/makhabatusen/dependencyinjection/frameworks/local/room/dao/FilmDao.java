package com.makhabatusen.dependencyinjection.frameworks.local.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.makhabatusen.dependencyinjection.data.models.Film;

import java.util.List;

@Dao
public interface FilmDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE )
    void insertToFav(Film film);

    @Delete
    void deleteFromFav(Film film);

    @Query("SELECT * FROM films")
    List<Film> getFavoriteFilms();


}
