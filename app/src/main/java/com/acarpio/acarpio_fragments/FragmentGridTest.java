package com.acarpio.acarpio_fragments;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.widget.FrameLayout;
import android.widget.GridLayout;

public class FragmentGridTest extends AppCompatActivity {
    GridLayout layout;
    int row = 4;
    int column = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment_grid_test);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.gridLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        layout = findViewById(R.id.gridLayout);
        layout.setColumnCount(column);
        layout.setRowCount(row);
        layout.setPadding(5, 5, 5, 5);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                FrameLayout frameLayout = new FrameLayout(this);
                frameLayout.setId(View.generateViewId());
                frameLayout.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(i), GridLayout.spec(j)));
                frameLayout.setPadding(5, 5, 5, 5);
                layout.addView(frameLayout);

                // Load fragments based on the condition
                if (j % 2 == 0) {
                    loadFragment(new FirstFragment(), frameLayout.getId());
                } else {
                    loadFragment(new SecondFragment(), frameLayout.getId());
                }
            }
        }



    }

    private void loadFragment(Fragment fragment, int id) {
        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();


    }
}