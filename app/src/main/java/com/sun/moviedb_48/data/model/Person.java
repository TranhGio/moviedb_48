package com.sun.moviedb_48.data.model;

public class Person {
    private int mPersonId;
    private String mPersonName;
    private String mPersonImage;

    private Person(PersonBuilder personBuilder) {

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

    public class PersonEntry {
        public static final String CREDIT = "credit";
        public static final String CAST = "cast";
        public static final String CREW = "crew";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final int NUMBER_OF_CREW = 1;
        public static final int NUMBER_OF_CAST = 10;
        public static final String PROFILE_PATH = "profile_path";
    }

    public static class PersonBuilder {
        private int mPersonId;
        private String mPersonName;
        private String mPersonImagePath;

        public PersonBuilder() {
        }

        public PersonBuilder(int personId, String personName, String personImage) {
            mPersonId = personId;
            mPersonName = personName;
            mPersonImagePath = personImage;
        }

        public PersonBuilder personId(int personId) {
            personId = personId;
            return this;
        }

        public PersonBuilder personName(String personName) {
            personName = personName;
            return this;
        }

        public PersonBuilder personImage(String personImagePath) {
            personImagePath = personImagePath;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
