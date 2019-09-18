package com.sun.moviedb_48.data.source;

import java.util.ArrayList;

public interface OnFetchDataJsonListener<T> {
    void onSuccess(ArrayList<T> data);

    void onError(Exception e);
}
