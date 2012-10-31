package com.example.project1.doctor;

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

import com.example.project1.R;

public class DoctorActivity extends Activity {
	private final String[] items = new String[] { "Alerts", "Messages",
			"Requests", "Following" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doctor);
		ListView docListView = (ListView) findViewById(R.id.docListView);
		ArrayList<String> docMenuList = new ArrayList<String>();
		docMenuList.addAll(Arrays.asList(items));
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				R.layout.list_item, docMenuList);
		docListView.setAdapter(listAdapter);

		docListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				Class<?> nextActivityClass = null;
				switch (position) {
				case 0:
					nextActivityClass = AlertsActivity.class;
					break;
				case 1:
					nextActivityClass = MessagesActivity.class;
					break;
				case 2:
					nextActivityClass = RequestsActivity.class; 
					break;
				case 3:
					nextActivityClass = FollowActivity.class;
					break;
				default:
					break;

				}
				if (nextActivityClass != null) {

					Intent myIntent = new Intent(DoctorActivity.this,
							nextActivityClass);
					startActivity(myIntent);
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_doctor, menu);
		return true;
	}
}
