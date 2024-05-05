package com.example.mrg;

public class Patient {
    public static final String TABLE_NAME = "patients";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_PLACE = "place";
    // Add more columns as needed

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_AGE + " INTEGER"
                    +COLUMN_PLACE+"TEXT"
                    // Add more columns here
                    + ")";


    private int id;
    private String name;
    private int age;
    private String place; // Assuming you want to add a place column

    // Constructor
    public Patient(int id, String name, int age, String place) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.place = place;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPlace() {
        return place;
    }

    // Setter methods (if needed)
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}

