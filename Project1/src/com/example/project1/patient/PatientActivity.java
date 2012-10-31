package com.example.project1.patient;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project1.ChartActivity;
import com.example.project1.PatientChartActivity;
import com.example.project1.R;

public class PatientActivity extends Activity {
	private final String[] items = new String[] { "Settings", "Measures",
			"Messages" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient);
		ListView patientListView = (ListView) findViewById(R.id.patientListView);
		ArrayList<String> patientMenuList = new ArrayList<String>();
		patientMenuList.addAll(Arrays.asList(items));
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				R.layout.list_item, patientMenuList);
		patientListView.setAdapter(listAdapter);
		
		patientListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				Class<?> nextActivityClass = null;
				switch (position) {
				case 0:
					nextActivityClass = SettingsActivity.class;
					break;
				case 1:
					nextActivityClass = PatientChartActivity.class;
					break;
				case 2:
					nextActivityClass = PatientMessagesActivity.class; 
					break;
				default:
					break;

				}
				if (nextActivityClass != null) {

					Intent myIntent = new Intent(PatientActivity.this,
							nextActivityClass);
					startActivity(myIntent);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_patient, menu);
		return true;
	}
}
