package com.makhabatusen.dependencyinjection.ui.details;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.makhabatusen.dependencyinjection.App;
import com.makhabatusen.dependencyinjection.R;
import com.makhabatusen.dependencyinjection.data.models.Film;
import com.makhabatusen.dependencyinjection.databinding.FragmentDetailsBinding;
import com.makhabatusen.dependencyinjection.frameworks.remote.retrofit.ResultFilm;
import com.makhabatusen.dependencyinjection.ui.base.BaseFragment;
import com.makhabatusen.dependencyinjection.ui.people.PeopleFragment;

public class DetailsFragment extends BaseFragment<FragmentDetailsBinding> {
    private static final String ARG_ID_DETAILS = "id_film";
    private String filmId;
    private final String TAG = "tag";

    public static DetailsFragment newInstance(String filmId) {

        Bundle args = new Bundle();
        DetailsFragment fragment = new DetailsFragment();
        args.putString(ARG_ID_DETAILS, filmId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected FragmentDetailsBinding bind() {
        return FragmentDetailsBinding.inflate(getLayoutInflater());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getArguments() != null)
            filmId = getArguments().getString(ARG_ID_DETAILS);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getFilmDetails(filmId);

        getPeople();

    }

    private void getPeople()
    {

        ui.btnPeople.setOnClickListener(v-> {
            navigateTo(R.id.peopleFragment,PeopleFragment.newInstance(filmId).getArguments());
        });

    }

    private void getFilmDetails(String filmId) {
        App.filmRepository.getFilmById(filmId, new ResultFilm() {
            @Override
            public void onSuccessFilm(Film film) {
                ui.tvTitle.setText(film.getTitle());
                ui.tvDescription.setText(film.getDescription());
                ui.tvDirector.setText(String.format("%s %s", getString(R.string.director), film.getDirector()));
                ui.tvProducer.setText(String.format("%s %s", getString(R.string.producer), film.getProducer()));
                ui.tvReleaseDate.setText(film.getReleaseDate());
                ui.tvRate.setText(film.getRtScore());
            }

            @Override
            public void OnFailure(String errorMsg) {
                Log.e(TAG, getString(R.string.onFailure) + errorMsg);
            }
        });
    }
}
