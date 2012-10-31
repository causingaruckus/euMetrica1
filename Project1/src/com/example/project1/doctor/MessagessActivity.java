package com.example.project1.doctor;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.example.project1.R;

public class MessagessActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagess);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_messagess, menu);
        return true;
    }
}
