
package com.makhabatusen.dependencyinjection.data.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


@Entity (tableName = "films")
public class Film implements Serializable {
    @PrimaryKey
    @SerializedName("id")
    @NonNull
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("director")
    private String director;
    @SerializedName("producer")
    private String producer;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("rt_score")
    private String rtScore;
    @SerializedName("isFavorite")
    private boolean isFavorite;
    private List<String> people = null;
    @SerializedName("species")
    private List<String> species = null;
    @SerializedName("locations")

    private List<String> locations = null;
    @SerializedName("vehicles")

    private List<String> vehicles = null;
    @SerializedName("url")
    private String url;

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public Film(@NonNull String id, String title, String description, String director, String producer, String releaseDate, String rtScore, boolean isFavorite, List<String> people, List<String> species, List<String> locations, List<String> vehicles, String url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.director = director;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.rtScore = rtScore;
        this.isFavorite = isFavorite;
        this.people = people;
        this.species = species;
        this.locations = locations;
        this.vehicles = vehicles;
        this.url = url;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRtScore() {
        return rtScore;
    }

    public void setRtScore(String rtScore) {
        this.rtScore = rtScore;
    }

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                ", producer='" + producer + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", rtScore='" + rtScore + '\'' +
                ", isFavorite=" + isFavorite +
                ", people=" + people +
                ", species=" + species +
                ", locations=" + locations +
                ", vehicles=" + vehicles +
                ", url='" + url + '\'' +
                '}';
    }
}
