package com.acarpio.acarpio_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, (ViewGroup) container, false);

        button = view.findViewById(R.id.secondfragmentbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "This is the first fragment!", Toast.LENGTH_LONG).show();
            }
        });


        return view;



    }


}
