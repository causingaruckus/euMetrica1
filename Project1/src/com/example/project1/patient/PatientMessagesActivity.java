package com.example.project1.patient;

import com.example.project1.R;
import com.example.project1.R.layout;
import com.example.project1.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PatientMessagesActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_messages);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_patient_messages, menu);
        return true;
    }
}
