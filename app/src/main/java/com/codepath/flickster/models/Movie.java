package com.codepath.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;


import java.util.ArrayList;
import java.util.List;

@Parcel

public class Movie {


    int movieId;
    double vote_average;
    String poster_path;
    String title;
    String overview;
    String backdrop_path;

    public Movie() {
    }

    public Movie (JSONObject jsonObject) throws JSONException {
        poster_path = jsonObject.getString( "poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        backdrop_path = jsonObject.getString("backdrop_path");
        vote_average = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");

    }

    public static List<Movie>  fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i <  movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
        }

    public String getPoster_Path() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", poster_path);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdrop_path);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getVoteAverage() {
        return vote_average;
    }

    public int getMovieId() {
        return movieId;
    }
}



