package com.makhabatusen.dependencyinjection.data.source;

import com.makhabatusen.dependencyinjection.frameworks.remote.retrofit.ResultFilm;
import com.makhabatusen.dependencyinjection.frameworks.remote.retrofit.ResultListFilms;
import com.makhabatusen.dependencyinjection.frameworks.remote.retrofit.ResultPeople;

public interface RetrofitSource {
    void getFilmById(String id, ResultFilm result);
    void getFilms (ResultListFilms result);
    void getPeople(String id, ResultPeople resultPeople);
}
