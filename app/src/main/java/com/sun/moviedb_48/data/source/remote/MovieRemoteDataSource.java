package com.sun.moviedb_48.data.source.remote;

import com.sun.moviedb_48.data.model.Movie;
import com.sun.moviedb_48.data.source.MoviesDataSource;
import com.sun.moviedb_48.data.source.remote.fetchdata.GetMoviesByCategoriesAsyncTask;
import com.sun.moviedb_48.utils.Categories;
import com.sun.moviedb_48.utils.Constant;

public class MovieRemoteDataSource implements MoviesDataSource.Remote {

    private static MovieRemoteDataSource sInstance;

    public static MovieRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new MovieRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getMovieByCategories(@Categories String category,
            OnFetchDataJsonListener<Movie> listener) {
        String url = Constant.BASE_API_URL
                + Constant.MOVIE
                + category
                + Constant.API_KEY
                + Constant.LANGUAGE
                + Constant.PAGE_1;
        new GetMoviesByCategoriesAsyncTask(listener).execute(url);
    }
}
