package com.sun.moviedb_48.data.model;

public class Genre {
    private int mId;
    private String mGenreName;

    public Genre() {
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getGenreName() {
        return mGenreName;
    }

    public void setGenreName(String genreName) {
        mGenreName = genreName;
    }

    public class GenreEntry {
        public static final String GENRE_IDS = "genre_ids";
        public static final String ID = "id";
        public static final String NAME = "name";
    }
}
