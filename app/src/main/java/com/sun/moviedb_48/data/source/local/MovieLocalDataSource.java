package com.sun.moviedb_48.data.source.local;

import com.sun.moviedb_48.data.source.MoviesDataSource;

public class MovieLocalDataSource implements MoviesDataSource.Local {
    private static MovieLocalDataSource sInstance;

    public static MovieLocalDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new MovieLocalDataSource();
        }
        return sInstance;
    }
}
