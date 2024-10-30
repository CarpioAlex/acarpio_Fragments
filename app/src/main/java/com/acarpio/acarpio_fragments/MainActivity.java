package com.acarpio.acarpio_fragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Button fragment1Button;
    private Button fragment2Button;
    private FirstFragment firstFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Only look for buttons in portrait mode
            fragment1Button = findViewById(R.id.fragment1Button);
            fragment2Button = findViewById(R.id.fragment2Button);

            // Button1 Listener
            if (fragment1Button != null) {
                fragment1Button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        firstFragment = new FirstFragment();
                        loadFragment(firstFragment, null);
                    }
                });
            }


            fragment2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (firstFragment != null && firstFragment.isVisible()) { // Verifica que esté visible
                        String selectedPlanet = firstFragment.getSelectedItem();
                        Bundle args = new Bundle();
                        args.putString("planetKey", selectedPlanet);

                        SecondFragment secondFragment = new SecondFragment();
                        loadFragment(secondFragment, args); // Pasa el Bundle
                    } else {
                        SecondFragment secondFragment = new SecondFragment();
                        loadFragment(secondFragment, null);
                    }
                }
            });

            Button activityTwo = findViewById(R.id.activityTwo);
            Intent intent = new Intent(this, FragmentGridTest.class);
            if (activityTwo != null) {
                activityTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intent);
                    }
                });
            }

        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

            if (firstFragment != null) {
                String selectedPlanet = firstFragment.getSelectedItem();
                Bundle args = new Bundle();
                args.putString("planetKey", selectedPlanet);
                loadFragment(new SecondFragment(), args);
            }
        }
    }














    private void loadFragment(Fragment fragment, Bundle args) {

        if (args != null) {
            fragment.setArguments(args);
        }

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        fragmentTransaction.commit();


    }


}