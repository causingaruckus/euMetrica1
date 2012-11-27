package com.eumetrica.project1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.kinvey.KCSClient;
import com.kinvey.KinveyUser;
import com.kinvey.util.KinveyCallback;
import com.kinvey.util.ScalarCallback;

public class RegisterActivity extends Activity {
	public static final String FULL_NAME_ATTRIBUTE = "fullName";
	private Button registerButton;
	private TextView loginScreen;
	private EditText passwordEditText;
	private EditText emailEditText;
	private EditText fullNameEditText;
	private RadioButton doctorRadioButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		registerButton = (Button) findViewById(R.id.registerButton);
		registerButton.setOnClickListener(new RegisterButtonListener());
		// registerScreen = (TextView) findViewById(R.id.linkToRegister);
		// registerScreen.setOnClickListener(new LinkToRegisterListener());
		passwordEditText = (EditText) findViewById(R.id.registerPasswordEditText);
		emailEditText = (EditText) findViewById(R.id.registerEmailEditText);
		fullNameEditText = (EditText) findViewById(R.id.registerFullNameEditText);
		doctorRadioButton = (RadioButton) findViewById(R.id.doctorRadioButton);
	}

	private class RegisterButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (passwordEditText == null || emailEditText == null || fullNameEditText == null
					|| doctorRadioButton == null) {
				Toast.makeText(RegisterActivity.this, "Application Error", Toast.LENGTH_SHORT).show();
				return;
			}
			String email = emailEditText.getText().toString();
			final String fullName = fullNameEditText.getText().toString();
			String password = passwordEditText.getText().toString();

			if (email == null || email.trim().isEmpty()) {
				return;
			}
			if (fullName == null || fullName.trim().isEmpty()) {
				return;
			}
			if (password == null || password.trim().isEmpty()) {
				return;
			}

			final KCSClient kinveyClient = ((ApplicationMetrica) getApplication()).getKinveyService();
			kinveyClient.createUserWithUsername(email, password, new KinveyCallback<KinveyUser>() {
				

				@Override
				public void onSuccess(KinveyUser kinveyUser) {
					if (doctorRadioButton.isChecked()) {
						kinveyUser.setAttribute(UserRoles.USER_ROLE_ATTRIBUTE, UserRoles.DOCTOR.name());
					} else {
						kinveyUser.setAttribute(UserRoles.USER_ROLE_ATTRIBUTE, UserRoles.PATIENT.name());
					}
					kinveyUser.setAttribute(FULL_NAME_ATTRIBUTE, fullName);

					kinveyUser.saveUser(new ScalarCallback<KinveyUser>() {
						@Override
						public void onSuccess(KinveyUser kinveyUser) {
							CharSequence text = "Succefully registered, "
									+ kinveyClient.getCurrentUser().getAttribute(FULL_NAME_ATTRIBUTE) + ".";
							Toast.makeText(RegisterActivity.this, text, Toast.LENGTH_SHORT).show();
						}
					});
				}

				@Override
				public void onStart() {
					CharSequence text = "Please wait, registering, "
							+ kinveyClient.getCurrentUser().getAttribute(FULL_NAME_ATTRIBUTE) + ".";
					Toast.makeText(RegisterActivity.this, text, Toast.LENGTH_SHORT).show();
				}

				@Override
				public void onFailure(Throwable t) {
				}
			});
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_register, menu);
		return true;
	}

	public enum UserRoles {
		DOCTOR, PATIENT;

		public static boolean isDoctor(KinveyUser kinveyUser) {
			if (kinveyUser != null && kinveyUser.getAttribute(USER_ROLE_ATTRIBUTE).equals(DOCTOR.name())) {
				return true;
			}
			return false;

		}

		public static boolean isPatient(KinveyUser kinveyUser) {
			if (kinveyUser != null && kinveyUser.getAttribute(USER_ROLE_ATTRIBUTE).equals(PATIENT.name())) {
				return true;
			}
			return false;
		}

		public final static String USER_ROLE_ATTRIBUTE = "userRole";

	}
}
