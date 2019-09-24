package com.sun.moviedb_48.utils;

import androidx.annotation.StringDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({
        Categories.NOW_PLAYING, Categories.NOW_PLAYING_TITLE, Categories.UPCOMING,
        Categories.UPCOMING_TITLE, Categories.POPULAR, Categories.POPULAR_TITLE,
        Categories.TOPRATED, Categories.TOPRATED_TITLE
})
public @interface Categories {
    String NOW_PLAYING = "now_playing";
    String NOW_PLAYING_TITLE = "Now Playing";
    String UPCOMING = "upcoming";
    String UPCOMING_TITLE = "Upcoming";
    String POPULAR = "popular";
    String POPULAR_TITLE = "Popular";
    String TOPRATED = "top_rated";
    String TOPRATED_TITLE = "Top Rated";
}
