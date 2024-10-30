package com.acarpio.acarpio_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        button = view.findViewById(R.id.secondfragmentbutton);

        // Safely retrieve arguments
        Bundle args = getArguments();
        final String planetValue;

        if (args != null) {
            planetValue = args.getString("planetKey");
        } else {
            planetValue = null;
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "This is the second fragment!", Toast.LENGTH_LONG).show();
                if (planetValue != null) {

                    ImageView iv = view.findViewById(R.id.imageTarget);

                    switch (planetValue) {
                        case "Mercury":
                            iv.setImageResource(R.drawable.mercurio);
                            break;
                        case "Venus":
                            iv.setImageResource(R.drawable.venus);
                            break;
                        case "Earth":
                            iv.setImageResource(R.drawable.earth);
                            break;
                        case "Mars":
                            iv.setImageResource(R.drawable.marte);
                            break;
                        case "Jupiter":
                            iv.setImageResource(R.drawable.jupiter);
                            break;
                        case "Saturn":
                            iv.setImageResource(R.drawable.saturn);
                            break;
                        case "Uranus":
                            iv.setImageResource(R.drawable.urano);
                            break;
                    }
                } else {
                    Toast.makeText(getActivity(), "Planet value is null", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}

