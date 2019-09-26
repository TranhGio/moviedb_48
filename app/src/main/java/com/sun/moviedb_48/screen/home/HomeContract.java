package com.sun.moviedb_48.screen.home;

import com.sun.moviedb_48.base.BasePresenter;
import com.sun.moviedb_48.data.model.Movie;
import com.sun.moviedb_48.utils.Categories;
import java.util.ArrayList;

public interface HomeContract {
    interface View {
        void showMovies(ArrayList<Movie> movies, @Categories String category);

        void showError(String exceptionMessage);
    }

    interface Presenter extends BasePresenter<View> {
        void getMoviesByCategories(@Categories String category);
    }
}
