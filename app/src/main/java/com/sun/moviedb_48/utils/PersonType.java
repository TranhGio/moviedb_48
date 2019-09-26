package com.sun.moviedb_48.utils;

import androidx.annotation.StringDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({
        PersonType.CAST,PersonType.CREW
})
public @interface PersonType {
    String CAST = "cast";
    String CREW = "crew";
}
