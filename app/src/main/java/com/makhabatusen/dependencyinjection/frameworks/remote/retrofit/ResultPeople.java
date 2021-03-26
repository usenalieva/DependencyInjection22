package com.makhabatusen.dependencyinjection.frameworks.remote.retrofit;

import com.makhabatusen.dependencyinjection.data.models.Person;

import java.util.List;

public interface ResultPeople {
    void onSuccessList (List<Person> films);
    void OnFailure(String errorMsg);
}
