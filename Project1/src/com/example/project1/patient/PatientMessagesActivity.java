package com.example.project1.patient;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project1.ImageAdapter;
import com.example.project1.ListItemObject;
import com.example.project1.R;

public class PatientMessagesActivity extends Activity {

	private final ListItemObject[] items = new ListItemObject[] {
			new ListItemObject("Note from doctor", "face", null),
			new ListItemObject("Note from system", "warning", null),
			new ListItemObject("Today's measures", "check", null),
			new ListItemObject("Yesterday's measures", "x", null),
			new ListItemObject("Request from nurse", "right_arrow", null) };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_messages);
		ListView docListView = (ListView) findViewById(R.id.patientMessagesListView);

		ArrayAdapter<ListItemObject> listAdapter = new ImageAdapter(this, items);
		docListView.setAdapter(listAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_patient_messages, menu);
		return true;
	}
}
