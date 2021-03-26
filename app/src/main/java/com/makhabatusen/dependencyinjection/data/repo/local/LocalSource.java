package com.makhabatusen.dependencyinjection.data.repo.local;

import com.makhabatusen.dependencyinjection.App;
import com.makhabatusen.dependencyinjection.data.models.Film;
import com.makhabatusen.dependencyinjection.data.source.RoomSource;

import java.util.List;

public class LocalSource implements RoomSource {

    @Override
    public void insertToFav(Film film) {
        App.appDataBase.filmDao().insertToFav(film);

    }
    @Override
    public void deleteFromFav(Film film) {
        App.appDataBase.filmDao().deleteFromFav(film);
    }

    @Override
    public List<Film> getFavoriteFilms() {
        return App.appDataBase.filmDao().getFavoriteFilms();
    }

}
