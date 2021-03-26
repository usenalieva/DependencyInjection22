package com.makhabatusen.dependencyinjection.data.repo.remote;

import com.makhabatusen.dependencyinjection.data.models.Film;
import com.makhabatusen.dependencyinjection.data.models.Person;
import com.makhabatusen.dependencyinjection.data.source.RetrofitSource;
import com.makhabatusen.dependencyinjection.frameworks.remote.retrofit.ResultFilm;
import com.makhabatusen.dependencyinjection.frameworks.remote.retrofit.ResultListFilms;
import com.makhabatusen.dependencyinjection.frameworks.remote.retrofit.ResultPeople;
import com.makhabatusen.dependencyinjection.frameworks.remote.retrofit.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RemoteSource implements RetrofitSource {
    @Override
    public void getFilmById(String id, ResultFilm result) {

        RetrofitBuilder.getInstance().getFilmById(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null)
                    result.onSuccessFilm(response.body());
                else result.OnFailure(String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                result.OnFailure(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void getFilms(ResultListFilms result) {
        RetrofitBuilder.getInstance().getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null)
                    result.onSuccessList(response.body());
                else result.OnFailure(String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                result.OnFailure(t.getLocalizedMessage());
            }
        });

    }

    @Override
    public void getPeople(String id, ResultPeople resultPeople) {
        RetrofitBuilder.getInstance().getPeople(id).enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                if (response.isSuccessful() && response.body() != null)
                    resultPeople.onSuccessList(response.body());
                else resultPeople.OnFailure(String.valueOf(response.code()));

            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                resultPeople.OnFailure(t.getLocalizedMessage());

            }
        });
    }
    }
