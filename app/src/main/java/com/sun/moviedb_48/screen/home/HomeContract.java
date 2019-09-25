package com.sun.moviedb_48.screen.home;

import com.sun.moviedb_48.base.BasePresenter;
import com.sun.moviedb_48.data.model.Movie;
import com.sun.moviedb_48.data.model.Person;
import com.sun.moviedb_48.utils.Categories;
import com.sun.moviedb_48.utils.PersonType;
import java.util.ArrayList;

public interface HomeContract {
    interface View {
        void onGetMovieByCategoriesSuccess(ArrayList<Movie> movies);

        void onGetMovieByCategoriesError(Exception e);

        void onGetPersonByMovieIdSuccess(ArrayList<Person> people);

        void onGetPersonByMovieIdError(Exception e);
    }

    interface Presenter extends BasePresenter<View> {
        void getMoviesByCategories(@Categories String category);
        void getPersonByMovieId(int movieId, @PersonType String personType);
    }
}
