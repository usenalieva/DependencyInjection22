package com.makhabatusen.dependencyinjection.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.makhabatusen.dependencyinjection.App;
import com.makhabatusen.dependencyinjection.R;
import com.makhabatusen.dependencyinjection.data.models.Film;
import com.makhabatusen.dependencyinjection.databinding.FragmentHomeBinding;
import com.makhabatusen.dependencyinjection.frameworks.remote.retrofit.ResultListFilms;
import com.makhabatusen.dependencyinjection.ui.base.BaseFragment;
import com.makhabatusen.dependencyinjection.ui.details.DetailsFragment;
import com.makhabatusen.dependencyinjection.ui.details.FilmDetailsListener;

import java.util.List;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> implements FilmDetailsListener, OnFilmListener {
    private FilmAdapter adapter;
    private final String TAG = "tag";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAdapter();
        getFilms();
    }

    private void initAdapter() {
        adapter  = new FilmAdapter(this);
        adapter.setListener(this);

    }

    private void getFilms() {
        App.filmRepository.getFilms(new ResultListFilms() {
            @Override
            public void onSuccessList(List<Film> films) {
                adapter.addFilms(films);
            }

            @Override
            public void OnFailure(String errorMsg) {
                Log.e(TAG, getString(R.string.onFailure) + errorMsg );
            }
        });
    }

    @Override
    protected FragmentHomeBinding bind() {
        return FragmentHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ui.rvFilms.setAdapter(adapter);

    }

    @Override
    public void showDetails(String id) {
        navigateTo(R.id.detailsFragment,DetailsFragment.newInstance(id).getArguments());
    }

    @Override
    public void sendFilm(Film film) {
    //
    }
}
