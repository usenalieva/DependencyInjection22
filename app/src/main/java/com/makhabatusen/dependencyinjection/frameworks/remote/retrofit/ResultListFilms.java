package com.makhabatusen.dependencyinjection.frameworks.remote.retrofit;

import com.makhabatusen.dependencyinjection.data.models.Film;

import java.util.List;

public interface ResultListFilms {
    void onSuccessList (List<Film> films);
    void OnFailure(String errorMsg);
}
