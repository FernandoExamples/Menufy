package com.udemy.fernando.menufy.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.udemy.fernando.menufy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmailsFragment extends Fragment implements View.OnClickListener{

    TextView textViewEmail;
    FloatingActionButton fabEmail;

    public EmailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_emails, container, false);
        bindComponents(view);
        return view;
    }

    private void bindComponents(View view){
        textViewEmail = view.findViewById(R.id.textViewEmail);
        fabEmail = view.findViewById(R.id.fbEmail);
        fabEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.email_dialog, null);
        final EditText etEmail = view.findViewById(R.id.editTextEmail);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Type your Email Address. To be display in the middle of the screen");
        builder.setTitle("Email");
        builder.setView(view);
        builder.setPositiveButton("Acept", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String text = etEmail.getText().toString();
                textViewEmail.setText(text);
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

}
