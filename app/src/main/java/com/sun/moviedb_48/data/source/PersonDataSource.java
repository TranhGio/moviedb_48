package com.sun.moviedb_48.data.source;

import com.sun.moviedb_48.data.model.Person;
import com.sun.moviedb_48.data.source.remote.OnFetchDataJsonListener;
import com.sun.moviedb_48.utils.PersonType;

public interface PersonDataSource {
    public interface Remote {
        void getPersonByMovieId(int movieId, @PersonType String personType,
                OnFetchDataJsonListener<Person> listener);
    }

    public interface Local {
    }
}
