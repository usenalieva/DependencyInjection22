package com.makhabatusen.dependencyinjection.frameworks.remote.retrofit;

import com.makhabatusen.dependencyinjection.data.models.Film;

public interface ResultFilm {
    void onSuccessFilm(Film film);
    void OnFailure(String errorMsg);
}
