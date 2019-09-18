package com.sun.moviedb_48.data.model;

import java.util.ArrayList;

public class Movie {
    private int mId;
    private String mTitle;
    private String mPosterPathUrl;
    private String mBackDropPathUrl;
    private float mVoteAverage;
    private String mOverView;
    private int mReleaseYear;
    private ArrayList<Genre> mGenres;

    public Movie() {
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getPosterPathUrl() {
        return mPosterPathUrl;
    }

    public void setPosterPathUrl(String posterPathUrl) {
        mPosterPathUrl = posterPathUrl;
    }

    public String getBackDropPathUrl() {
        return mBackDropPathUrl;
    }

    public void setBackDropPathUrl(String backDropPathUrl) {
        mBackDropPathUrl = backDropPathUrl;
    }

    public float getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        mVoteAverage = voteAverage;
    }

    public String getOverView() {
        return mOverView;
    }

    public void setOverView(String overView) {
        mOverView = overView;
    }

    public int getReleaseYear() {
        return mReleaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        mReleaseYear = releaseYear;
    }

    public ArrayList<Genre> getGenres() {
        return mGenres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        mGenres = genres;
    }

    public final class MovieEntry {
        public static final String MOVIE = "results";
        public static final String TITLE = "title";
        public static final String VOTE = "vote_average";
        public static final String POSTER_PATH = "poster_path";
        public static final String BACKDROP_PATH = "poster_path";
        public static final String RELEASE_DATE = "release_date";
        public static final String OVERVIEW = "overview";
    }
}
