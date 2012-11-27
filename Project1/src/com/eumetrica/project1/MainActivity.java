package com.eumetrica.project1;

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

import com.eumetrica.project1.RegisterActivity.UserRoles;
import com.eumetrica.project1.doctor.DoctorActivity;
import com.eumetrica.project1.patient.PatientActivity;
import com.kinvey.KCSClient;
import com.kinvey.KinveyUser;
import com.kinvey.util.KinveyCallback;

public class MainActivity extends Activity {
	private Button loginButton;
	private TextView registerScreen;
	private EditText passwordEditText;
	private EditText emailEditText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		loginButton = (Button) findViewById(R.id.loginButton);
		loginButton.setOnClickListener(new LoginButtonListener());
		registerScreen = (TextView) findViewById(R.id.linkToRegister);
		registerScreen.setOnClickListener(new LinkToRegisterListener());
		passwordEditText = (EditText) findViewById(R.id.loginPasswordEditText);
		emailEditText = (EditText) findViewById(R.id.loginEmailEditText);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private class LoginButtonListener implements OnClickListener {
		@Override
		public void onClick(View v) {

			if (passwordEditText == null || emailEditText == null) {
				Toast.makeText(MainActivity.this, "Application Error", Toast.LENGTH_SHORT).show();
				return;
			}
			final String email = emailEditText.getText().toString();
			String password = passwordEditText.getText().toString();

			if (email == null || email.trim().isEmpty()) {
				showWrongCredentials();
				return;
			}
			if (password == null || password.trim().isEmpty()) {
				showWrongCredentials();
				return;
			}

			final KCSClient kinveyClient = ((ApplicationMetrica) getApplication()).getKinveyService();
			kinveyClient.loginWithUsername(email, password, new KinveyCallback<KinveyUser>() {
				public void onSuccess(KinveyUser kinveyUser) {
					String fullName = (String) kinveyUser.getAttribute(RegisterActivity.FULL_NAME_ATTRIBUTE);
					CharSequence text = "Welcome back, " + fullName + ".";
					Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
					if (UserRoles.isDoctor(kinveyUser)) {
						Intent myIntent = new Intent(MainActivity.this, DoctorActivity.class);
						startActivity(myIntent);
						return;
					} else {
						Intent myIntent = new Intent(MainActivity.this, PatientActivity.class);
						startActivity(myIntent);
						return;
					}
				}

				@Override
				public void onFailure(Throwable t) {
					CharSequence text = "Failed to login as, " + email + ".";
					Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
				}

			});
		}

	}

	private void showWrongCredentials() {
		Toast.makeText(MainActivity.this, "Wrong credentials, enter: doctor or patient", Toast.LENGTH_SHORT).show();
	}

	private class LinkToRegisterListener implements OnClickListener {
		@Override
		public void onClick(View v) {

			Intent myIntent = new Intent(MainActivity.this, RegisterActivity.class);
			startActivity(myIntent);
		}
	}

	private class PatientButtonListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			Intent myIntent = new Intent(MainActivity.this, PatientActivity.class);
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

			Intent myIntent = new Intent(MainActivity.this, DoctorActivity.class);
			MainActivity.this.startActivity(myIntent);

		}
	}

}
