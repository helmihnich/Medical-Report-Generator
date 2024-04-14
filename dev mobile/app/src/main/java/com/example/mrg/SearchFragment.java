package com.example.mrg;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.mrg.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.Objects;

public class SearchFragment extends Fragment {

    public SearchFragment() {
        // Required empty public constructor
    }
    DatePickerDialog datePickerDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        // Find TextInputEditText by its ID
        TextInputEditText date = rootView.findViewById(R.id.datte); // Corrected ID

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(requireContext(), R.style.ThemeCalendar,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"+ (month + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        // Example: Accessing the text of the TextInputEditText when a button is clicked
        Button button = rootView.findViewById(R.id.button4);
        MaterialCardView patientCardButton = rootView.findViewById(R.id.PatientCard);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from the TextInputEditText
                String text = Objects.requireNonNull(date.getText()).toString();

                // Do something with the text, such as displaying it in a Toast
                Toast.makeText(requireContext(), "Text: " + text, Toast.LENGTH_SHORT).show();
            }
        });

        // Définir un écouteur de clic pour le bouton "Patient Card"
        patientCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Appeler la méthode PatientCard lorsque le bouton est cliqué
                PatientCard();
            }
        });

        return rootView;
    }

    // Méthode pour afficher un Toast indiquant l'action "Patient Card"
    private void PatientCard() {
        Toast.makeText(requireContext(), "Text: Patient Card" , Toast.LENGTH_SHORT).show();
        replaceFragment(new PatientCard());

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
