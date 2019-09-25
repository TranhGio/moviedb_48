package com.sun.moviedb_48.data.source.remote.fetchdata;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.sun.moviedb_48.data.source.remote.OnFetchImageListener;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetImageAsyncTask extends AsyncTask<String, Void, Bitmap> {

    private OnFetchImageListener mListener;
    private Exception mException;

    public GetImageAsyncTask(OnFetchImageListener listener) {
        mListener = listener;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        return loadImage(strings[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (mException != null) {
            mListener.onImageError(mException);
        } else {
            mListener.onImageLoaded(bitmap);
        }
    }

    private Bitmap loadImage(String string) {
        try {
            URL url = new URL(string);
            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.connect();
            InputStream inputStream = null;
            if (httpUrlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = httpUrlConnection.getInputStream();
            }
            return BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            mException = e;
            return null;
        }
    }
}
