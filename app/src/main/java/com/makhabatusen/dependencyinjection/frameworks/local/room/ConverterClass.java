package com.makhabatusen.dependencyinjection.frameworks.local.room;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ConverterClass {

    @TypeConverter
    public List<String> fromType(String list) {
        Type type = new TypeToken<List<String>>(){}.getType();
        return new Gson().fromJson(list, type);
    }

    @TypeConverter
    public String toType(List<String> list) {
        return new Gson().toJson(list);
    }


}
