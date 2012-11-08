package com.example.project1;

import com.example.project1.doctor.DoctorActivity;
import com.example.project1.patient.PatientActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
 	private Button loginButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		loginButton = (Button) findViewById(R.id.loginButton);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private class LoginButtonListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			
			Intent myIntent = new Intent(MainActivity.this,
					PatientActivity.class);
			startActivity(myIntent);
		}
	}
	
	private class PatientButtonListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			Intent myIntent = new Intent(MainActivity.this,
					PatientActivity.class);
			startActivity(myIntent);
		}
	}

//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		super.onActivityResult(requestCode, resultCode, data);
//		if (requestCode == CONTACT_PICKER_RESULT && resultCode == RESULT_OK
//				&& data != null) {
//
//			Uri contactData = data.getData();
//			Intent myIntent = new Intent(MainActivity.this,
//					PatientDetailsActivity.class);
//			myIntent.setData(contactData);
//			MainActivity.this.startActivity(myIntent);
//		}
//	}

	private class DoctorButtonListener implements OnClickListener {
		@Override
		public void onClick(View v) {
  
			Intent myIntent = new Intent(MainActivity.this, DoctorActivity.class);
			MainActivity.this.startActivity(myIntent);
		
		}
	}

}
