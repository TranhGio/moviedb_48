package com.sun.moviedb_48.data.repository;

import com.sun.moviedb_48.data.model.Movie;
import com.sun.moviedb_48.data.source.MoviesDataSource;
import com.sun.moviedb_48.data.source.remote.OnFetchDataJsonListener;
import com.sun.moviedb_48.utils.Categories;

public class MovieRepository {
    private static MovieRepository sInstance;
    private MoviesDataSource.Remote mRemote;
    private MoviesDataSource.Local mLocal;

    private MovieRepository(MoviesDataSource.Remote remote,
            MoviesDataSource.Local local) {
        mRemote = remote;
        mLocal = local;
    }

    public static MovieRepository getInstance(
            MoviesDataSource.Remote remote,
            MoviesDataSource.Local local) {
        if (sInstance == null) {
            sInstance = new MovieRepository(remote, local);
        }
        return sInstance;
    }

    public void getMovieByCategories(Categories category, OnFetchDataJsonListener<Movie> listener) {
        mRemote.getMovieByCategories(category, listener);
    }
}
