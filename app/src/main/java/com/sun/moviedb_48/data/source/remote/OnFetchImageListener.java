package com.sun.moviedb_48.data.source.remote;

import android.graphics.Bitmap;

public interface OnFetchImageListener {
    void onImageLoaded(Bitmap bitmap);

    void onImageError(Exception e);
}
