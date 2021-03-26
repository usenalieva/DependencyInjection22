package com.makhabatusen.dependencyinjection.frameworks.local.room.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.makhabatusen.dependencyinjection.data.models.Film;
import com.makhabatusen.dependencyinjection.frameworks.local.room.ConverterClass;
import com.makhabatusen.dependencyinjection.frameworks.local.room.dao.FilmDao;


@Database(entities = {Film.class}, version = 1)
@TypeConverters(ConverterClass.class)

public abstract class AppDataBase extends RoomDatabase {
    public abstract FilmDao filmDao();
}
