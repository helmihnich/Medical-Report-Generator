package com.example.mrg;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ResourceConstants {
    // Définition des constantes pour les identifiants des éléments de menu
    public static final int item_App = R.id.item_App;
    public static final int item_search = R.id.item_search;
    public static final int item_Profil = R.id.item_Profil;

    // Méthode pour remplacer un fragment par un autre fragment spécifié
    public static void replaceFragment(Fragment frag,FragmentManager fragmentManager) {

        // Commencer une transaction de fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Remplacer le fragment actuel par le fragment PatientCard
        fragmentTransaction.replace(R.id.frame_layout,frag);

        // Valider et soumettre la transaction
        fragmentTransaction.commit();
    }



}