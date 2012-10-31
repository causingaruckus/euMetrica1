package com.example.project1;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DoctorActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
		ListView docListView = (ListView) findViewById( R.id.docListView );  
	    ArrayList<String> planetList = new ArrayList<String>();  
	        
	    ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout., planetList);  
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_doctor, menu);
        return true;
    }
}
