package com.sun.moviedb_48.data.source.remote;

import com.sun.moviedb_48.data.model.Person;
import com.sun.moviedb_48.data.source.PersonDataSource;
import com.sun.moviedb_48.data.source.remote.fetchdata.GetPersonAsyncTask;
import com.sun.moviedb_48.utils.Constant;
import com.sun.moviedb_48.utils.PersonType;

public class PersonRemoteDataSource implements PersonDataSource.Remote {

    private static PersonRemoteDataSource sInstance;

    public static PersonRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new PersonRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getPersonByMovieId(int movieId, @PersonType String personType,
            OnFetchDataJsonListener<Person> listener) {
        String url = Constant.BASE_API_URL
                + movieId
                + "/"
                + Person.PersonEntry.CREDIT
                + Constant.API_KEY
                + Constant.LANGUAGE
                + Constant.PAGE_1;
        new GetPersonAsyncTask(personType, listener).execute(url);
    }
}
