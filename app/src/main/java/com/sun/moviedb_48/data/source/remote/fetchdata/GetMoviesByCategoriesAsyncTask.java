package com.sun.moviedb_48.data.source.remote.fetchdata;

import android.os.AsyncTask;
import com.sun.moviedb_48.data.model.Movie;
import com.sun.moviedb_48.data.source.remote.OnFetchDataJsonListener;
import java.util.ArrayList;

public class GetMoviesByCategoriesAsyncTask extends AsyncTask<String, Void, ArrayList<Movie>> {

    private OnFetchDataJsonListener<Movie> mListener;
    private Exception mException;

    public GetMoviesByCategoriesAsyncTask(OnFetchDataJsonListener<Movie> listener) {
        mListener = listener;
    }

    @Override
    protected ArrayList<Movie> doInBackground(String... strings) {
        ArrayList<Movie> movies = null;
        try {
            ParseUrlToJson parseUrlToJson = new ParseUrlToJson();
            String data = parseUrlToJson.getJsonFromUrl(strings[0]);
            movies = parseUrlToJson.getListMoviesFromJson(data);
        } catch (Exception e) {
            e.printStackTrace();
            mException = e;
        }
        return movies;
    }

    @Override
    protected void onPostExecute(ArrayList<Movie> movies) {
        super.onPostExecute(movies);
        if (mException != null) {
            mListener.onError(mException);
        } else {
            mListener.onSuccess(movies);
        }
    }
}
