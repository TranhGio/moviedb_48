package com.sun.moviedb_48.utils;

import com.sun.moviedb_48.data.source.remote.OnFetchImageListener;
import com.sun.moviedb_48.data.source.remote.fetchdata.GetImageAsyncTask;

public class Common {

    public static void getImageUrl(String url, OnFetchImageListener listener) {
        new GetImageAsyncTask(listener).execute(url);
    }
}
