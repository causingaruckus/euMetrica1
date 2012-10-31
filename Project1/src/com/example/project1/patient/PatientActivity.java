package com.example.project1.patient;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.example.project1.R;

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
