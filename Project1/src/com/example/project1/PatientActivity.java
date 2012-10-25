package com.example.project1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PatientActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_patient, menu);
        return true;
    }
}
