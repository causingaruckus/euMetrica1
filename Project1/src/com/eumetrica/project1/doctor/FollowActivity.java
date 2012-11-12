package com.eumetrica.project1.doctor;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.eumetrica.project1.ChartActivity;
import com.eumetrica.project1.R;

public class FollowActivity extends Activity {
	private final String[] items = new String[] { "Sara", "Tim", "Mike", "Lee" };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
		ListView docListView = (ListView) findViewById(R.id.followListView);
		ArrayList<String> docMenuList = new ArrayList<String>();
		docMenuList.addAll(Arrays.asList(items));
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				R.layout.list_item, docMenuList);
		docListView.setAdapter(listAdapter);
		
		docListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				Class<?> nextActivityClass = ChartActivity.class;
				
				if (nextActivityClass != null) {

					Intent myIntent = new Intent(FollowActivity.this,
							ChartActivity.class);
					startActivity(myIntent);
				}
			}
		});
    }

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_follow, menu);
        return true;
    }
}
