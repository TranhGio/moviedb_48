package com.sun.moviedb_48.data.source;

import com.sun.moviedb_48.data.model.Movie;
import com.sun.moviedb_48.utils.Categories;

public interface MoviesDataSource {
    public interface RemoteDataSource {
        void getMovieByCategories(Categories categories,OnFetchDataJsonListener<Movie> listener);
    }

    public interface LocalDataSource {

    }
}
