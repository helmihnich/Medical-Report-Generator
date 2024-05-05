package com.example.mrg;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class AppoinementFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private PatientDbHelper dbHelper;
    private static final String ARG_PARAM2 = "param2";

    public AppoinementFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // TODO: Rename and change types of parameters
            getArguments().getString(ARG_PARAM1);
            getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_appoinement, container, false);

        // Find the EditText for the date
        final EditText editTextDate = rootView.findViewById(R.id.editTextDate);
        dbHelper = new PatientDbHelper(getContext());
        // Find the EditText for the time
        final EditText editTextTime = rootView.findViewById(R.id.editTexttime);


        // Find the ImageView for the calendar icon
        rootView.findViewById(R.id.Time2).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                // Get current date
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                // Create a DatePickerDialog and show it
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int dayOfMonth) {
                                // Update the EditText with the selected date
                                editTextDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });

        // Find the ImageView for the time icon
        rootView.findViewById(R.id.imageView4).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                // Get current time
                final Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                // Create a TimePickerDialog and show it
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
                                // Update the EditText with the selected time
                                editTextTime.setText(String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute));
                            }
                        }, hour, minute, false);
                timePickerDialog.show();
            }
        });

        // Find the button for navigating to the registration page
        Button buttonPlusText = rootView.findViewById(R.id.buttonPlusText);


            // Définir un écouteur de clic pour le bouton "Patient Card"
            buttonPlusText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Appeler la méthode PatientCard lorsque le bouton est cliqué
                    PatientRegistration();
                }


        });

        // Inside onCreateView() method of your AppoinementFragment fragment

// Fetch all patient names from the database
        List<String> patientNames = dbHelper.getAllPatientNames();

// Find the ListView in your layout
        ListView listViewPatients = rootView.findViewById(R.id.listViewPatients);

// Create an ArrayAdapter to populate the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, patientNames);

// Set the adapter to the ListView
        listViewPatients.setAdapter(adapter);


        return rootView;
    }

    private void PatientRegistration() {
        Toast.makeText(requireContext(), "Text: Patient Card" , Toast.LENGTH_SHORT).show();
        replaceFragment(new PatientRegistration());

    }
    private void replaceFragment(Fragment frag) {
        // Créer une instance de FragmentManager
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

        // Commencer une transaction de fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Remplacer le fragment actuel par le fragment PatientCard
        fragmentTransaction.replace(R.id.frame_layout,frag);

        // Valider et soumettre la transaction
        fragmentTransaction.commit();
    }

}