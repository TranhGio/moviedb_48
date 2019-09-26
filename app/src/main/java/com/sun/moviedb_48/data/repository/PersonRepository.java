package com.sun.moviedb_48.data.repository;

import com.sun.moviedb_48.data.model.Person;
import com.sun.moviedb_48.data.source.PersonDataSource;
import com.sun.moviedb_48.data.source.remote.OnFetchDataJsonListener;
import com.sun.moviedb_48.utils.PersonType;

public class PersonRepository {
    private static PersonRepository sInstance;
    private PersonDataSource.Remote mRemote;
    private PersonDataSource.Local mLocal;

    private PersonRepository(PersonDataSource.Remote remote, PersonDataSource.Local local) {
        mRemote = remote;
        mLocal = local;
    }

    public static PersonRepository getInstance(PersonDataSource.Remote remote,
            PersonDataSource.Local local) {
        if (sInstance == null) {
            sInstance = new PersonRepository(remote, local);
        }
        return sInstance;
    }

    public void getPersonByMovieId(int movieId, @PersonType String personType,
            OnFetchDataJsonListener<Person> listener) {
        mRemote.getPersonByMovieId(movieId, personType, listener);
    }
}
