package com.sun.moviedb_48.data.model;

public class Person {
    private int mPersonId;
    private String mPersonName;
    private String mPersonImage;

    public Person() {
    }

    public int getPersonId() {
        return mPersonId;
    }

    public void setPersonId(int personId) {
        mPersonId = personId;
    }

    public String getPersonName() {
        return mPersonName;
    }

    public void setPersonName(String personName) {
        mPersonName = personName;
    }

    public String getPersonImage() {
        return mPersonImage;
    }

    public void setPersonImage(String personImage) {
        mPersonImage = personImage;
    }
    public class PersonEntry{
        public static final String CREDIT = "credit";
        public static final String CAST_ID = "cast_id";
        public static final String CAST = "cast";
        public static final String CREW = "crew";
    }
}
