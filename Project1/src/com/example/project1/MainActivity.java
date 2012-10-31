package com.example.project1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button doctorButton;
	private Button patientButton;
	private final int CONTACT_PICKER_RESULT = 1001;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		doctorButton = (Button) findViewById(R.id.doctorButton);
		patientButton = (Button) findViewById(R.id.patientButton);
		patientButton.setOnClickListener(new PatientButtonListener());
		doctorButton.setOnClickListener(new DoctorButtonListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private class PatientButtonListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			Intent myIntent = new Intent(MainActivity.this,
					PatientActivity.class);
			startActivity(myIntent);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == CONTACT_PICKER_RESULT && resultCode == RESULT_OK
				&& data != null) {

			Uri contactData = data.getData();
			Intent myIntent = new Intent(MainActivity.this,
					PatientDetailsActivity.class);
			myIntent.setData(contactData);
			MainActivity.this.startActivity(myIntent);
		}
	}

	private class DoctorButtonListener implements OnClickListener {
		@Override
		public void onClick(View v) {
  
			//public void doLaunchContactPicker(View view) {  
			    Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,  
			            Contacts.CONTENT_URI);  
			    startActivityForResult(contactPickerIntent, CONTACT_PICKER_RESULT); 
			    
			//Intent myIntent = new Intent(MainActivity.this, DoctorActivity.class);
		
		}
	}

}
