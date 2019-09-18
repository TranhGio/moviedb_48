package com.sun.moviedb_48.data.repository;

import com.sun.moviedb_48.data.model.Movie;
import com.sun.moviedb_48.data.source.MoviesDataSource;
import com.sun.moviedb_48.data.source.OnFetchDataJsonListener;
import com.sun.moviedb_48.utils.Categories;

public class MovieRepository {
    private static MovieRepository sInstance;
    private MoviesDataSource.RemoteDataSource mRemote;
    private MoviesDataSource.LocalDataSource mLocal;

    private MovieRepository(MoviesDataSource.RemoteDataSource remoteDataSource,
            MoviesDataSource.LocalDataSource localDataSource) {
        mRemote = remoteDataSource;
        mLocal = localDataSource;
    }

    public static MovieRepository getInstance(MoviesDataSource.RemoteDataSource remoteDataSource,
            MoviesDataSource.LocalDataSource localDataSource) {
        if (sInstance == null) {
            sInstance = new MovieRepository(remoteDataSource, localDataSource);
        }
        return sInstance;
    }

    public void getMovieByGenre(Categories categories,OnFetchDataJsonListener<Movie> listener) {
        mRemote.getMovieByCategories(categories,listener);
    }
}
