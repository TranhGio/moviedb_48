package com.sun.moviedb_48.data.source.remote.fetchdata;

import com.sun.moviedb_48.data.model.Movie;
import com.sun.moviedb_48.utils.Constant;
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
                    .releaseYear(Integer.parseInt(
                            jsonObjectMovie.getString(Movie.MovieEntry.RELEASE_DATE)
                                    .substring(Movie.MovieEntry.BEGIN_POSITION_YEAR,
                                            Movie.MovieEntry.END_POSITION_YEAR)))
                    .build();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movie;
    }
}
