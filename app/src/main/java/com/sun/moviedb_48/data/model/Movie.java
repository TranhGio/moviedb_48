package com.sun.moviedb_48.data.model;

import java.util.ArrayList;

public class Movie {
    private int mId;
    private String mTitle;
    private String mPosterPathUrl;
    private String mBackDropPathUrl;
    private double mVoteAverage;
    private String mOverView;
    private int mReleaseYear;
    private ArrayList<Genre> mGenres;

    private Movie(MovieBuilder movieBuilder) {
        mId = movieBuilder.mId;
        mTitle = movieBuilder.mTitle;
        mPosterPathUrl = movieBuilder.mPosterPathUrl;
        mBackDropPathUrl = movieBuilder.mBackDropPathUrl;
        mVoteAverage = movieBuilder.mVoteAverage;
        mOverView = movieBuilder.mOverView;
        mReleaseYear = movieBuilder.mReleaseYear;
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

    public double getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(double voteAverage) {
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

    public static class MovieBuilder {
        private int mId;
        private String mTitle;
        private String mPosterPathUrl;
        private String mBackDropPathUrl;
        private double mVoteAverage;
        private String mOverView;
        private int mReleaseYear;

        public MovieBuilder(int id, String title, String posterPathUrl, String backDropPathUrl,
                double voteAverage, String overView, int releaseYear) {
            mId = id;
            mTitle = title;
            mPosterPathUrl = posterPathUrl;
            mBackDropPathUrl = backDropPathUrl;
            mVoteAverage = voteAverage;
            mOverView = overView;
            mReleaseYear = releaseYear;
        }

        public MovieBuilder() { }

        public MovieBuilder id(int id) {
            mId = id;
            return this;
        }

        public MovieBuilder title(String title) {
            mTitle = title;
            return this;
        }

        public MovieBuilder posterPathUrl(String posterPathUrl) {
            mPosterPathUrl = posterPathUrl;
            return this;
        }

        public MovieBuilder backDropPathUrl(String backDropPathUrl) {
            mBackDropPathUrl = backDropPathUrl;
            return this;
        }

        public MovieBuilder voteAverage(double voteAverage) {
            mVoteAverage = voteAverage;
            return this;
        }

        public MovieBuilder overView(String overView) {
            mOverView = overView;
            return this;
        }

        public MovieBuilder releaseYear(int releaseYear) {
            mReleaseYear = releaseYear;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }

    public final class MovieEntry {
        public static final String RESULT = "results";
        public static final String ID = "id";
        public static final String TITLE = "title";
        public static final String VOTE_AVERAGE = "vote_average";
        public static final String POSTER_PATH = "poster_path";
        public static final String BACKDROP_PATH = "backdrop_path";
        public static final String RELEASE_DATE = "release_date";
        public static final String OVERVIEW = "overview";
        public static final int BEGIN_POSITION_YEAR = 0;
        public static final int END_POSITION_YEAR = 3;
    }
}
