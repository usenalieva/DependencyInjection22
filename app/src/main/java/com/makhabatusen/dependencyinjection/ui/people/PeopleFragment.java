package com.makhabatusen.dependencyinjection.ui.people;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.makhabatusen.dependencyinjection.App;
import com.makhabatusen.dependencyinjection.data.models.Person;
import com.makhabatusen.dependencyinjection.databinding.FragmentPeopleBinding;
import com.makhabatusen.dependencyinjection.frameworks.remote.retrofit.ResultPeople;
import com.makhabatusen.dependencyinjection.ui.base.BaseFragment;

import java.util.List;

public class PeopleFragment extends BaseFragment<FragmentPeopleBinding> {
    private static final String ARG_ID_PEOPLE = "id_person";
    private String filmId;
    private PersonAdapter adapter;

    public static PeopleFragment newInstance(String filmId) {

        Bundle args = new Bundle();
        args.putString(ARG_ID_PEOPLE, filmId);
        PeopleFragment fragment = new PeopleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getArguments() != null)
            filmId = getArguments().getString(ARG_ID_PEOPLE);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected FragmentPeopleBinding bind() {
        return FragmentPeopleBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        getPeople(filmId);

    }

    private void init() {
        adapter = new PersonAdapter();
        ui.rvPeople.setAdapter(adapter);
        ui.rvPeople.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }

    private void getPeople(String filmId) {
        App.filmRepository.getPeople(filmId, new ResultPeople() {
            @Override
            public void onSuccessList(List<Person> films) {
            adapter.addPeople(films);
            }

            @Override
            public void OnFailure(String errorMsg) {

            }
        });
    }
}
