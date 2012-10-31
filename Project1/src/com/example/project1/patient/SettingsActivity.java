package com.example.project1.patient;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project1.R;

public class SettingsActivity extends Activity {
	private final String[] items = new String[] { "Camera",
			"Electro-cardiogram (EKG)", "Thermometer", "Spirometer" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		ListView settingsListView = (ListView) findViewById(R.id.settingsListView);
		ArrayList<String> settingsMenuList = new ArrayList<String>();
		settingsMenuList.addAll(Arrays.asList(items));
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				R.layout.list_item, settingsMenuList);
		settingsListView.setAdapter(listAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_settings, menu);
		return true;
	}
}
