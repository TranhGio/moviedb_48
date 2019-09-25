package com.sun.moviedb_48.screen.home;

import com.sun.moviedb_48.data.model.Movie;
import com.sun.moviedb_48.data.model.Person;
import com.sun.moviedb_48.data.repository.MovieRepository;
import com.sun.moviedb_48.data.repository.PersonRepository;
import com.sun.moviedb_48.data.source.remote.OnFetchDataJsonListener;
import com.sun.moviedb_48.utils.Categories;
import com.sun.moviedb_48.utils.PersonType;
import java.util.ArrayList;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;
    private MovieRepository mMovieRepository;
    private PersonRepository mPersonRepository;

    HomePresenter(MovieRepository movieRepository, PersonRepository personRepository) {
        mMovieRepository = movieRepository;
        mPersonRepository = personRepository;
    }

    @Override
    public void setView(HomeContract.View view) {
        mView = view;
    }

    @Override
    public void getMoviesByCategories(String category) {
        mMovieRepository.getMovieByCategories(category, new OnFetchDataJsonListener<Movie>() {
            @Override
            public void onSuccess(ArrayList<Movie> data) {
                mView.onGetMovieByCategoriesSuccess(data);
            }

            @Override
            public void onError(Exception e) {
                mView.onGetMovieByCategoriesError(e);
            }
        });
    }

    @Override
    public void getPersonByMovieId(int movieId,@PersonType String personType) {
        mPersonRepository.getPersonByMovieId(movieId, personType, new OnFetchDataJsonListener<Person>() {
            @Override
            public void onSuccess(ArrayList<Person> people) {
                mView.onGetPersonByMovieIdSuccess(people);
            }

            @Override
            public void onError(Exception e) {
                mView.onGetPersonByMovieIdError(e);
            }
        });
    }
}
