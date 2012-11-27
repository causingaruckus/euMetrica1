package com.eumetrica.project1.patient;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.eumetrica.project1.R;

public class MeasuresActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measures);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_measures, menu);
        return true;
    }
}
