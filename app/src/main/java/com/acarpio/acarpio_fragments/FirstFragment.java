package com.acarpio.acarpio_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    Button button;
    public Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, (ViewGroup) container, false);

        button = view.findViewById(R.id.secondfragmentbutton);
        spinner = view.findViewById(R.id.spinner);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "This is the first fragment!", Toast.LENGTH_LONG).show();
                String selectedPlanet = spinner.getSelectedItem().toString();
                Bundle args = new Bundle();
                args.putString("planetKey", selectedPlanet);
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.planets_array,
                android.R.layout.simple_spinner_item);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);






        return view;




    }

    public String getSelectedItem() {
        String text = String.valueOf(spinner.getSelectedItem());
        return text;


    }

}
