
package com.makhabatusen.dependencyinjection.data.models;


import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "people")
public class Person {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("gender")
    private String gender;
    @SerializedName("age")
    private String age;
    @SerializedName("eye_color")
    private String eyeColor;
    @SerializedName("hair_color")
    private String hairColor;
    @SerializedName("films")
    private List<String> films = null;
    @SerializedName("species")
    private String species;
    @SerializedName("url")
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return
                "Name= " + name + '\n' +
                "Gender= " + gender + '\n' +
                "Age= " + age + '\n' +
                "Eye Color= " + eyeColor + '\n' +
                "Hair Color= " + hairColor ;
    }
}
