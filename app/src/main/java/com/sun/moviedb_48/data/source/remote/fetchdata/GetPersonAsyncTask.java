package com.sun.moviedb_48.data.source.remote.fetchdata;

import android.os.AsyncTask;
import com.sun.moviedb_48.data.model.Movie;
import com.sun.moviedb_48.data.model.Person;
import com.sun.moviedb_48.data.source.remote.OnFetchDataJsonListener;
import com.sun.moviedb_48.utils.PersonType;
import java.util.ArrayList;

public class GetPersonAsyncTask extends AsyncTask<String, Void, ArrayList<Person>> {

    @PersonType
    String mPersonType;
    private OnFetchDataJsonListener<Person> mListener;
    private Exception mException;

    public GetPersonAsyncTask(String personType, OnFetchDataJsonListener<Person> listener) {
        mPersonType = personType;
        mListener = listener;
    }

    @Override
    protected ArrayList<Person> doInBackground(String... strings) {
        ArrayList<Person> people = null;
        ParseUrlToJson parseUrlToJson = new ParseUrlToJson();
        try {
            String data = parseUrlToJson.getJsonFromUrl(strings[0]);
            people = parseUrlToJson.getListPersonFromJson(data, mPersonType);
        } catch (Exception e) {
            e.printStackTrace();
            mException = e;
        }
        return people;
    }

    @Override
    protected void onPostExecute(ArrayList<Person> people) {
        super.onPostExecute(people);
        if (mException != null) {
            mListener.onError(mException);
        } else {
            mListener.onSuccess(people);
        }
    }
}
