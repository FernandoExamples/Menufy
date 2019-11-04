package com.udemy.fernando.menufy.fragments;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udemy.fernando.menufy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment implements View.OnClickListener{

    FloatingActionButton fabButton;

    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        bindComponents(view);
        return view;
    }

    private void bindComponents(View view){
        fabButton = view.findViewById(R.id.fbInfo);
        fabButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("This alert dialog is just an Informative Dialog");
        builder.setNeutralButton("Go it", null);
        builder.setTitle("Information");
        builder.show();
    }

}
