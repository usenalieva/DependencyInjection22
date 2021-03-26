package com.makhabatusen.dependencyinjection;

import android.app.Application;

import androidx.room.Room;

import com.makhabatusen.dependencyinjection.data.repo.FilmRepository;
import com.makhabatusen.dependencyinjection.data.repo.local.LocalSource;
import com.makhabatusen.dependencyinjection.data.repo.remote.RemoteSource;
import com.makhabatusen.dependencyinjection.frameworks.local.room.database.AppDataBase;


public class App extends Application {

    public static AppDataBase appDataBase;
    public static FilmRepository filmRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        filmRepository = new FilmRepository(new RemoteSource(), new LocalSource());

        appDataBase = Room.databaseBuilder(
                this,
                AppDataBase.class,
                BuildConfig.DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
}
