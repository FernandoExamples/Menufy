package com.udemy.fernando.menufy.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.udemy.fernando.menufy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlertsFragment extends Fragment implements View.OnClickListener {

    TextView textViewAlert;
    FloatingActionButton fabAlert;

    public AlertsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_alerts, container, false);
        bindComponents(view);
        return view;
    }

    private void bindComponents(View view){
        textViewAlert = view.findViewById(R.id.textViewAlerts);
        fabAlert = view.findViewById(R.id.fbAlert);
        fabAlert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.alerts_dialog, null);
        final Switch switchAlert = view.findViewById(R.id.switchAlerts);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Enable or disable the Alerts using the switch");
        builder.setTitle("Alerts");

        builder.setView(view);
        builder.setPositiveButton("Acept", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(switchAlert.isChecked())
                    textViewAlert.setText("Alerts Enabled");
                else
                    textViewAlert.setText("Alerts Disabled");
            }
        });

        builder.setNegativeButton("Cancel", null);
        builder.show();
    }


}
