package com.example.mrg;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PatientRegistration  extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private PatientDbHelper dbHelper;
    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextAddress;

    public PatientRegistration() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: Rename and change types of parameters
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_patient_registration, container, false);

        // Initialize views
        editTextName = view.findViewById(R.id.editTextText);
        editTextAge = view.findViewById(R.id.editTextText2);
        editTextAddress = view.findViewById(R.id.editTextText3);
        Button buttonAddPatient = view.findViewById(R.id.button);

        // Initialize the dbHelper
        dbHelper = new PatientDbHelper(getContext());

        // Set click listener for the button to add a patient
        buttonAddPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from EditText and TextView elements
                String name = editTextName.getText().toString();
                String ageStr = editTextAge.getText().toString();
                String address = editTextAddress.getText().toString();

                // Convert age string to integer
                int age = Integer.parseInt(ageStr);

                // Add patient to database
                long newRowId = dbHelper.addPatient(name, age, address);

                if (newRowId != -1) {
                    // Insertion successful
                    String message = "Patient added successfully with ID: " + newRowId;
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                    AppoinementFragment();
                } else {
                    // Insertion failed
                    Log.e("PatientRegistration", "Failed to add patient to the database.");
                }
            }
        });


        return view;
    }

    private void AppoinementFragment() {
        Toast.makeText(requireContext(), "Text: Patient Card" , Toast.LENGTH_SHORT).show();
        replaceFragment(new AppoinementFragment());

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