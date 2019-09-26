package com.sun.moviedb_48.data.source.remote.fetchdata;

import com.sun.moviedb_48.data.model.Movie;
import com.sun.moviedb_48.data.model.Person;
import com.sun.moviedb_48.utils.Constant;
import com.sun.moviedb_48.utils.PersonType;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseUrlToJson {

    public String getJsonFromUrl(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
        httpUrlConnection.setConnectTimeout(Constant.TIME_OUT);
        httpUrlConnection.setReadTimeout(Constant.TIME_OUT);
        httpUrlConnection.setRequestMethod(Constant.METHOD_GET);
        httpUrlConnection.connect();
        InputStream inputStream = httpUrlConnection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        httpUrlConnection.disconnect();
        reader.close();
        return builder.toString();
    }

    public ArrayList<Movie> getListMoviesFromJson(String jsonString) throws JSONException {
        ArrayList<Movie> movies = new ArrayList<>();
        JSONObject jsonObjectMovie = new JSONObject(jsonString);
        JSONArray jsonArrayMovies = jsonObjectMovie.getJSONArray(Movie.MovieEntry.RESULT);
        if (jsonArrayMovies.length() != 0) {
            for (int i = 0; i < jsonArrayMovies.length(); i++) {
                Movie movie = parseMovieFromJson(jsonArrayMovies.getJSONObject(i));
                if (movie != null) {
                    movies.add(movie);
                }
            }
        }
        return movies;
    }

    public Movie parseMovieFromJson(JSONObject jsonObjectMovie) {
        Movie movie = null;
        try {
            movie = new Movie.MovieBuilder().id(jsonObjectMovie.getInt(Movie.MovieEntry.ID))
                    .title(jsonObjectMovie.getString(Movie.MovieEntry.TITLE))
                    .posterPathUrl(jsonObjectMovie.getString(Movie.MovieEntry.POSTER_PATH))
                    .backDropPathUrl(jsonObjectMovie.getString(Movie.MovieEntry.BACKDROP_PATH))
                    .voteAverage(jsonObjectMovie.getDouble(Movie.MovieEntry.VOTE_AVERAGE))
                    .overView(jsonObjectMovie.getString(Movie.MovieEntry.OVERVIEW))
                    .releaseYear(jsonObjectMovie.getString(Movie.MovieEntry.RELEASE_DATE))
                    .build();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movie;
    }

    public ArrayList<Person> getListPersonFromJson(String jsonString,
            @PersonType String personType) {
        ArrayList<Person> people = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            if (personType.equals(PersonType.CREW)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Person.PersonEntry.CREW);
                if (jsonArray.length() != 0) {
                    Person person = parsePersonFromJson(jsonArray.getJSONObject(0));
                    if (person != null) {
                        people.add(person);
                    }
                }
            } else {
                //TODO Cast
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return people;
    }

    private Person parsePersonFromJson(JSONObject jsonObjectPerson) throws JSONException {
        Person person = null;
        if (jsonObjectPerson != null) {
            person = new Person.PersonBuilder().personId(jsonObjectPerson.getInt(
                    String.valueOf(jsonObjectPerson.getInt(Person.PersonEntry.ID))))
                    .personName(jsonObjectPerson.getString(Person.PersonEntry.NAME))
                    .personImage(jsonObjectPerson.getString(Person.PersonEntry.PROFILE_PATH))
                    .build();
        }
        return person;
    }
}
