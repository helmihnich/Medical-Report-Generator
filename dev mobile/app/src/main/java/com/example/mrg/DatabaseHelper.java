package com.example.mrg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MRG.db";
    private static final int DATABASE_VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Patient.CREATE_TABLE);
        db.execSQL(Doctor.CREATE_TABLE);
        db.execSQL(Appointment.CREATE_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //-------------------Patient ------------------------------------------//

    public long addPatient(Patient patient) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Patient.COLUMN_NAME, patient.getName());
        values.put(Patient.COLUMN_AGE, patient.getAge());
        values.put(Patient.COLUMN_PLACE, patient.getPlace());

        // Inserting Row
        long id = db.insert(Patient.TABLE_NAME, null, values);
        db.close(); // Closing database connection
        return id; // Return the ID of the newly inserted row
    }
    public List<Patient> getPatientsById(int patientId) {
        List<Patient> patientsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Patient.TABLE_NAME,
                new String[]{Patient.COLUMN_ID, Patient.COLUMN_NAME, Patient.COLUMN_AGE, Patient.COLUMN_PLACE},
                Patient.COLUMN_ID + "=?",
                new String[]{String.valueOf(patientId)}, null, null, null, null);

        // Check if cursor is valid and has at least one row
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndex(Patient.COLUMN_ID);
                int nameIndex = cursor.getColumnIndex(Patient.COLUMN_NAME);
                int ageIndex = cursor.getColumnIndex(Patient.COLUMN_AGE);
                int placeIndex = cursor.getColumnIndex(Patient.COLUMN_PLACE);

                // Check if column indices are valid (not -1)
                if (idIndex != -1 && nameIndex != -1 && ageIndex != -1 && placeIndex != -1) {
                    // Retrieve patient data from cursor
                    Patient patient = new Patient(
                            cursor.getInt(idIndex),
                            cursor.getString(nameIndex),
                            cursor.getInt(ageIndex),
                            cursor.getString(placeIndex)
                    );
                    // Add patient to list
                    patientsList.add(patient);
                }
            } while (cursor.moveToNext());

            cursor.close(); // Close the cursor
        }
        return patientsList;
    }
    public List<Patient> getAllPatients() {
        List<Patient> patientsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Patient.TABLE_NAME,
                new String[]{Patient.COLUMN_ID, Patient.COLUMN_NAME, Patient.COLUMN_AGE, Patient.COLUMN_PLACE},
                null, null, null, null, null);

        // Check if cursor is valid and has at least one row
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndex(Patient.COLUMN_ID);
                int nameIndex = cursor.getColumnIndex(Patient.COLUMN_NAME);
                int ageIndex = cursor.getColumnIndex(Patient.COLUMN_AGE);
                int placeIndex = cursor.getColumnIndex(Patient.COLUMN_PLACE);

                // Check if column indices are valid (not -1)
                if (idIndex != -1 && nameIndex != -1 && ageIndex != -1 && placeIndex != -1) {
                    // Retrieve patient data from cursor
                    Patient patient = new Patient(
                            cursor.getInt(idIndex),
                            cursor.getString(nameIndex),
                            cursor.getInt(ageIndex),
                            cursor.getString(placeIndex)
                    );
                    // Add patient to list
                    patientsList.add(patient);
                }
            } while (cursor.moveToNext());

            cursor.close(); // Close the cursor
        }
        return patientsList;
    }



    //------------------Doctor---------------------------------------------------


        public long addDoctor(Doctor doctor) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(Doctor.COLUMN_NAME, doctor.getName());
            values.put(Doctor.COLUMN_SPECIALIZATION, doctor.getSpecialization());
            values.put(Doctor.COLUMN_EMAIL, doctor.getEmail());
            values.put(Doctor.COLUMN_PASSWORD, doctor.getPassword());

            long id = db.insert(Doctor.TABLE_NAME, null, values);
            db.close();
            return id;
        }

        public List<Doctor> getDoctorsById(int doctorId) {
            List<Doctor> doctorsList = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(Doctor.TABLE_NAME,
                    new String[]{Doctor.COLUMN_ID, Doctor.COLUMN_NAME, Doctor.COLUMN_SPECIALIZATION, Doctor.COLUMN_EMAIL, Doctor.COLUMN_PASSWORD},
                    Doctor.COLUMN_ID + "=?",
                    new String[]{String.valueOf(doctorId)}, null, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    int idIndex = cursor.getColumnIndex(Doctor.COLUMN_ID);
                    int nameIndex = cursor.getColumnIndex(Doctor.COLUMN_NAME);
                    int specializationIndex = cursor.getColumnIndex(Doctor.COLUMN_SPECIALIZATION);
                    int emailIndex = cursor.getColumnIndex(Doctor.COLUMN_EMAIL);
                    int passwordIndex = cursor.getColumnIndex(Doctor.COLUMN_PASSWORD);

                    if (idIndex != -1 && nameIndex != -1 && specializationIndex != -1 && emailIndex != -1 && passwordIndex != -1) {
                        Doctor doctor = new Doctor(
                                cursor.getInt(idIndex),
                                cursor.getString(nameIndex),
                                cursor.getString(specializationIndex),
                                cursor.getString(emailIndex),
                                cursor.getString(passwordIndex)
                        );
                        doctorsList.add(doctor);
                    }
                } while (cursor.moveToNext());

                cursor.close();
            }
            return doctorsList;
        }

        public List<Doctor> getAllDoctors() {
            List<Doctor> doctorsList = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(Doctor.TABLE_NAME,
                    new String[]{Doctor.COLUMN_ID, Doctor.COLUMN_NAME, Doctor.COLUMN_SPECIALIZATION, Doctor.COLUMN_EMAIL, Doctor.COLUMN_PASSWORD},
                    null, null, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    int idIndex = cursor.getColumnIndex(Doctor.COLUMN_ID);
                    int nameIndex = cursor.getColumnIndex(Doctor.COLUMN_NAME);
                    int specializationIndex = cursor.getColumnIndex(Doctor.COLUMN_SPECIALIZATION);
                    int emailIndex = cursor.getColumnIndex(Doctor.COLUMN_EMAIL);
                    int passwordIndex = cursor.getColumnIndex(Doctor.COLUMN_PASSWORD);

                    if (idIndex != -1 && nameIndex != -1 && specializationIndex != -1 && emailIndex != -1 && passwordIndex != -1) {
                        Doctor doctor = new Doctor(
                                cursor.getInt(idIndex),
                                cursor.getString(nameIndex),
                                cursor.getString(specializationIndex),
                                cursor.getString(emailIndex),
                                cursor.getString(passwordIndex)
                        );
                        doctorsList.add(doctor);
                    }
                } while (cursor.moveToNext());

                cursor.close();
            }
            return doctorsList;
        }




//------------------Appoinement --------------------------------------------------


    public long addAppointment(Appointment appointment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Appointment.COLUMN_PATIENT_ID, appointment.getPatientId());
        values.put(Appointment.COLUMN_DOCTOR_ID, appointment.getDoctorId());
        values.put(Appointment.COLUMN_DATE, appointment.getDate());
        values.put(Appointment.COLUMN_TIME, appointment.getTime());

        long id = db.insert(Appointment.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public List<Appointment> getAppointmentsByPatientId(int patientId) {
        List<Appointment> appointmentsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Appointment.TABLE_NAME,
                new String[]{Appointment.COLUMN_ID, Appointment.COLUMN_PATIENT_ID, Appointment.COLUMN_DOCTOR_ID, Appointment.COLUMN_DATE, Appointment.COLUMN_TIME},
                Appointment.COLUMN_PATIENT_ID + "=?",
                new String[]{String.valueOf(patientId)}, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndex(Appointment.COLUMN_ID);
                int patientIdIndex = cursor.getColumnIndex(Appointment.COLUMN_PATIENT_ID);
                int doctorIdIndex = cursor.getColumnIndex(Appointment.COLUMN_DOCTOR_ID);
                int dateIndex = cursor.getColumnIndex(Appointment.COLUMN_DATE);
                int timeIndex = cursor.getColumnIndex(Appointment.COLUMN_TIME);

                if (idIndex != -1 && patientIdIndex != -1 && doctorIdIndex != -1 && dateIndex != -1 && timeIndex != -1) {
                    Appointment appointment = new Appointment(
                            cursor.getInt(idIndex),
                            cursor.getInt(patientIdIndex),
                            cursor.getInt(doctorIdIndex),
                            cursor.getString(dateIndex),
                            cursor.getString(timeIndex)
                    );
                    appointmentsList.add(appointment);
                }
            } while (cursor.moveToNext());

            cursor.close();
        }
        return appointmentsList;
    }
    public List<Appointment> getAppointmentsByPatientName(String patientName) {
        List<Appointment> appointmentsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Define the SQL query for joining Appointment and Patient tables
        String query = "SELECT " +
                Appointment.TABLE_NAME + "." + Appointment.COLUMN_ID + ", " +
                Appointment.TABLE_NAME + "." + Appointment.COLUMN_PATIENT_ID + ", " +
                Appointment.TABLE_NAME + "." + Appointment.COLUMN_DOCTOR_ID + ", " +
                Appointment.TABLE_NAME + "." + Appointment.COLUMN_DATE + ", " +
                Appointment.TABLE_NAME + "." + Appointment.COLUMN_TIME +
                " FROM " + Appointment.TABLE_NAME +
                " JOIN " + Patient.TABLE_NAME +
                " ON " + Appointment.TABLE_NAME + "." + Appointment.COLUMN_PATIENT_ID +
                " = " + Patient.TABLE_NAME + "." + Patient.COLUMN_ID +
                " WHERE " + Patient.TABLE_NAME + "." + Patient.COLUMN_NAME + " = ?";

        Cursor cursor = db.rawQuery(query, new String[]{patientName});

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndex(Appointment.COLUMN_ID);
                int patientIdIndex = cursor.getColumnIndex(Appointment.COLUMN_PATIENT_ID);
                int doctorIdIndex = cursor.getColumnIndex(Appointment.COLUMN_DOCTOR_ID);
                int dateIndex = cursor.getColumnIndex(Appointment.COLUMN_DATE);
                int timeIndex = cursor.getColumnIndex(Appointment.COLUMN_TIME);

                if (idIndex != -1 && patientIdIndex != -1 && doctorIdIndex != -1 && dateIndex != -1 && timeIndex != -1) {
                    Appointment appointment = new Appointment(
                            cursor.getInt(idIndex),
                            cursor.getInt(patientIdIndex),
                            cursor.getInt(doctorIdIndex),
                            cursor.getString(dateIndex),
                            cursor.getString(timeIndex)
                    );
                    appointmentsList.add(appointment);
                }
            } while (cursor.moveToNext());

            cursor.close();
        }
        return appointmentsList;
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> appointmentsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Appointment.TABLE_NAME,
                new String[]{Appointment.COLUMN_ID, Appointment.COLUMN_PATIENT_ID, Appointment.COLUMN_DOCTOR_ID, Appointment.COLUMN_DATE, Appointment.COLUMN_TIME},
                null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndex(Appointment.COLUMN_ID);
                int patientIdIndex = cursor.getColumnIndex(Appointment.COLUMN_PATIENT_ID);
                int doctorIdIndex = cursor.getColumnIndex(Appointment.COLUMN_DOCTOR_ID);
                int dateIndex = cursor.getColumnIndex(Appointment.COLUMN_DATE);
                int timeIndex = cursor.getColumnIndex(Appointment.COLUMN_TIME);

                if (idIndex != -1 && patientIdIndex != -1 && doctorIdIndex != -1 && dateIndex != -1 && timeIndex != -1) {
                    Appointment appointment = new Appointment(
                            cursor.getInt(idIndex),
                            cursor.getInt(patientIdIndex),
                            cursor.getInt(doctorIdIndex),
                            cursor.getString(dateIndex),
                            cursor.getString(timeIndex)
                    );
                    appointmentsList.add(appointment);
                }
            } while (cursor.moveToNext());

            cursor.close();
        }
        return appointmentsList;
    }


    public List<Appointment> getNearestAppointments() {
        List<Appointment> nearestAppointments = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Définir la requête SQL pour sélectionner les rendez-vous les plus proches du temps réel
        String query = "SELECT * FROM " + Appointment.TABLE_NAME +
                " WHERE " + Appointment.COLUMN_DATE + " >= date('now')" +
                " ORDER BY " + Appointment.COLUMN_DATE + ", " + Appointment.COLUMN_TIME;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndex(Appointment.COLUMN_ID);
                int patientIdIndex = cursor.getColumnIndex(Appointment.COLUMN_PATIENT_ID);
                int doctorIdIndex = cursor.getColumnIndex(Appointment.COLUMN_DOCTOR_ID);
                int dateIndex = cursor.getColumnIndex(Appointment.COLUMN_DATE);
                int timeIndex = cursor.getColumnIndex(Appointment.COLUMN_TIME);

                if (idIndex != -1 && patientIdIndex != -1 && doctorIdIndex != -1 && dateIndex != -1 && timeIndex != -1) {
                    Appointment appointment = new Appointment(
                            cursor.getInt(idIndex),
                            cursor.getInt(patientIdIndex),
                            cursor.getInt(doctorIdIndex),
                            cursor.getString(dateIndex),
                            cursor.getString(timeIndex)
                    );
                    nearestAppointments.add(appointment);
                }
            } while (cursor.moveToNext());

            cursor.close();
        }
        return nearestAppointments;
    }


}