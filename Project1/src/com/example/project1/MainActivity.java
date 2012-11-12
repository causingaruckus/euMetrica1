package com.example.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project1.doctor.DoctorActivity;
import com.example.project1.patient.PatientActivity;

public class MainActivity extends Activity {
	private Button loginButton;
	private TextView registerScreen;
	private EditText passwordTextEdit;
	private EditText emailTextEdit;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		loginButton = (Button) findViewById(R.id.loginButton);
		loginButton.setOnClickListener(new LoginButtonListener());
		registerScreen = (TextView) findViewById(R.id.linkToRegister);
		registerScreen.setOnClickListener(new LinkToRegisterListener());
		passwordTextEdit = (EditText) findViewById(R.id.passwordTextEdit);
		emailTextEdit = (EditText) findViewById(R.id.emailTextEdit);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private class LoginButtonListener implements OnClickListener {
		@Override
		public void onClick(View v) {

			if (passwordTextEdit == null || emailTextEdit == null) {

			}
			String email = emailTextEdit.getText().toString();

			if (email == null || email.trim().isEmpty()) {
				showWrongCredentials();
				return;
			}

			if (email.equalsIgnoreCase("doctor")) {
				Intent myIntent = new Intent(MainActivity.this,
						DoctorActivity.class);
				startActivity(myIntent);
				return;
			}
			if (email.equalsIgnoreCase("patient")) {
				Intent myIntent = new Intent(MainActivity.this,
						PatientActivity.class);
				startActivity(myIntent);
				return;
			}
			showWrongCredentials();

		}

	}

	private void showWrongCredentials() {
		Toast.makeText(MainActivity.this,
				"Wrong credentials, enter: doctor or patient",
				Toast.LENGTH_SHORT).show();
	}

	private class LinkToRegisterListener implements OnClickListener {
		@Override
		public void onClick(View v) {

			Intent myIntent = new Intent(MainActivity.this,
					RegisterActivity.class);
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

	// @Override
	// protected void onActivityResult(int requestCode, int resultCode, Intent
	// data) {
	// super.onActivityResult(requestCode, resultCode, data);
	// if (requestCode == CONTACT_PICKER_RESULT && resultCode == RESULT_OK
	// && data != null) {
	//
	// Uri contactData = data.getData();
	// Intent myIntent = new Intent(MainActivity.this,
	// PatientDetailsActivity.class);
	// myIntent.setData(contactData);
	// MainActivity.this.startActivity(myIntent);
	// }
	// }

	private class DoctorButtonListener implements OnClickListener {
		@Override
		public void onClick(View v) {

			Intent myIntent = new Intent(MainActivity.this,
					DoctorActivity.class);
			MainActivity.this.startActivity(myIntent);

		}
	}

}
