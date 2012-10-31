package com.example.project1.doctor;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project1.R;

public class MessagesActivity extends Activity {
	private final String[] items = new String[] { "Re: Tim's measures", "Re: Re: way to go!",
			"Fwd: your latest results", "Re: way to go!" };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
		ListView docListView = (ListView) findViewById(R.id.messageListView);
		ArrayList<String> docMenuList = new ArrayList<String>();
		docMenuList.addAll(Arrays.asList(items));
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				R.layout.list_item, docMenuList);
		docListView.setAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_messages, menu);
        return true;
    }
}
