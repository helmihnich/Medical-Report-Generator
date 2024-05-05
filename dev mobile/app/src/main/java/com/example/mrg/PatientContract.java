package com.example.mrg;

import android.provider.BaseColumns;


public final class PatientContract {
    private PatientContract() {}

    public static class PatientEntry implements BaseColumns {
        public static final String TABLE_NAME = "patients";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_AGE = "age";
        public static final String COLUMN_NAME_ADDRESS = "address";
    }
}
