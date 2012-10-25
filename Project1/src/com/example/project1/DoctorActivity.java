package com.example.project1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DoctorActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_doctor, menu);
        return true;
    }
}
