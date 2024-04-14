package com.example.mrg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.mrg.databinding.ActivityHomeBinding;
import com.example.mrg.databinding.ActivityMainBinding;

public class home extends AppCompatActivity {
    ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragement(new SearchFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.item_search) {
                replaceFragement(new SearchFragment());
            } 
            else if (item.getItemId() == R.id.item_Profil) {
                replaceFragement(new ProfilFragment());
            } else if (item.getItemId() == R.id.item_App) {

                replaceFragement(new AppoinementFragment());
            }
            return true;
        });

    }
    private void replaceFragement(Fragment frag){
        FragmentManager frag_mang =getSupportFragmentManager();
        FragmentTransaction fragTrans =frag_mang.beginTransaction();
        fragTrans.replace(R.id.frame_layout,frag);
        fragTrans.commit();
    }
}