package com.sun.moviedb_48.data.source.remote;

import com.sun.moviedb_48.data.model.Movie;
import com.sun.moviedb_48.data.source.MoviesDataSource;
import com.sun.moviedb_48.data.source.OnFetchDataJsonListener;
import com.sun.moviedb_48.utils.Categories;

public class MovieRemoteDataSource implements MoviesDataSource.RemoteDataSource {

    private static MovieRemoteDataSource sInstance;

    public static MovieRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new MovieRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getMovieByCategories(Categories categories,
            OnFetchDataJsonListener<Movie> listener) {

    }
}
