package com.sun.moviedb_48.data.source;

import com.sun.moviedb_48.data.model.Movie;
import com.sun.moviedb_48.data.model.Person;
import com.sun.moviedb_48.data.source.remote.OnFetchDataJsonListener;
import com.sun.moviedb_48.utils.Categories;
import com.sun.moviedb_48.utils.PersonType;

public interface MoviesDataSource {
    public interface Remote {
        void getMovieByCategories(@Categories String category,
                OnFetchDataJsonListener<Movie> listener);
    }

    public interface Local {

    }
}
