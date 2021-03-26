package com.makhabatusen.dependencyinjection.ui.favorites;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.makhabatusen.dependencyinjection.App;
import com.makhabatusen.dependencyinjection.R;
import com.makhabatusen.dependencyinjection.data.models.Film;
import com.makhabatusen.dependencyinjection.databinding.FragmentFavoritesBinding;
import com.makhabatusen.dependencyinjection.ui.base.BaseFragment;
import com.makhabatusen.dependencyinjection.ui.details.DetailsFragment;
import com.makhabatusen.dependencyinjection.ui.details.FilmDetailsListener;
import com.makhabatusen.dependencyinjection.ui.home.OnFilmListener;


public class FavoritesFragment extends BaseFragment<FragmentFavoritesBinding> implements FilmDetailsListener {
    private FavoritesAdapter adapter;

    public FavoritesFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FavoritesAdapter(this);

    }

    @Override
    protected FragmentFavoritesBinding bind() {
        return FragmentFavoritesBinding.inflate(getLayoutInflater());
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ui.rvFavorites.setAdapter(adapter);
        adapter.addFavFilmList(App.filmRepository.getFavoriteFilms());

    }

    @Override
    public void showDetails(String id) {
        navigateTo(R.id.detailsFragment, DetailsFragment.newInstance(id).getArguments());
    }


}
