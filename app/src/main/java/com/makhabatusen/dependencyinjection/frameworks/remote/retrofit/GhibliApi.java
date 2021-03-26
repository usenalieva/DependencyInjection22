package com.makhabatusen.dependencyinjection.frameworks.remote.retrofit;

import com.makhabatusen.dependencyinjection.data.models.Film;
import com.makhabatusen.dependencyinjection.data.models.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GhibliApi {

    @GET(EndPoints.FILM_BY_ID)
    Call<Film> getFilmById(@Path(EndPoints.ID) String id);

    @GET (EndPoints.FILMS)
    Call <List<Film>> getFilms();

    @GET(EndPoints.PEOPLE_BY_FILM_ID)
    Call <List<Person>> getPeople(@Path(EndPoints.ID) String id);

}
