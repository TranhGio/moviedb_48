package com.sun.moviedb_48.utils;

import com.sun.moviedb_48.BuildConfig;

public class Constant {
    public static final String API_KEY = "?api_key=" + BuildConfig.API_KEY;
    public static final String BASE_API_URL = "https://api.themoviedb.org/3/";
    public static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/";
    public static final String IMAGE_W500 = "/w500";
    public static final String IMAGE_ORIGIN = "/original";
    public static final int TIME_OUT = 1500;
    public static final String METHOD_GET = "GET";
    public static final String MOVIE = "movie/";
    public static final String LANGUAGE = "&language=en-US";
    public static final String PAGE_1 = "&page=1";
}
