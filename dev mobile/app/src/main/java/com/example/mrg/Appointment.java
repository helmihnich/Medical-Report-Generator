package com.example.mrg;
public class Appointment {
    public static final String TABLE_NAME = "appointments";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PATIENT_ID = "patient_id";
    public static final String COLUMN_DOCTOR_ID = "doctor_id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TIME = "time";
    // Add more columns as needed

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_PATIENT_ID + " INTEGER,"
                    + COLUMN_DOCTOR_ID + " INTEGER,"
                    + COLUMN_DATE + " TEXT,"
                    + COLUMN_TIME + " TEXT,"
                    // Add more columns here
                    + "FOREIGN KEY(" + COLUMN_PATIENT_ID + ") REFERENCES " + Patient.TABLE_NAME + "(" + Patient.COLUMN_ID + "),"
                    + "FOREIGN KEY(" + COLUMN_DOCTOR_ID + ") REFERENCES " + Doctor.TABLE_NAME + "(" + Doctor.COLUMN_ID + ")"
                    + ")";


    private int id;
    private int patientId;
    private int doctorId;
    private String date;
    private String time;
    public Appointment(int id, int patientId, int doctorId, String date, String time) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    // Setter methods (if needed)
    public void setId(int id) {
        this.id = id;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

}

