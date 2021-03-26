package com.makhabatusen.dependencyinjection.data.repo;

import com.makhabatusen.dependencyinjection.data.models.Film;
import com.makhabatusen.dependencyinjection.data.repo.local.LocalSource;
import com.makhabatusen.dependencyinjection.data.repo.remote.RemoteSource;
import com.makhabatusen.dependencyinjection.frameworks.remote.retrofit.ResultFilm;
import com.makhabatusen.dependencyinjection.frameworks.remote.retrofit.ResultListFilms;
import com.makhabatusen.dependencyinjection.frameworks.remote.retrofit.ResultPeople;

import java.util.List;

public class FilmRepository {
    private final RemoteSource remoteSource;
    private final LocalSource localSource;

    public FilmRepository(RemoteSource remoteSource, LocalSource localSource) {
        this.remoteSource = remoteSource;
        this.localSource = localSource;
    }


    public void getFilmById(String id, ResultFilm result){
        remoteSource.getFilmById(id, result);
    }

    public void getFilms(ResultListFilms result){
        remoteSource.getFilms(result);
    }

    public void getPeople(String id, ResultPeople resultPeople) {
        remoteSource.getPeople(id, resultPeople);
    }

    public void insertToFav(Film film) {
        localSource.insertToFav(film);
    }

    public void deleteFromFav(Film film) {
        localSource.deleteFromFav(film);
    }

    public List<Film> getFavoriteFilms() {
        return localSource.getFavoriteFilms();
    }




}
