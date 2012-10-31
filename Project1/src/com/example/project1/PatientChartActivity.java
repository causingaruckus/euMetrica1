package com.example.project1;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

public class PatientChartActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_chart);
		final ActionBar actionBar = getActionBar();
		actionBar.setTitle("Charts");
		setContentView(getChartView());
	}

	private View getChartView() {
		// init example series data
		final java.text.DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		long now = new Date().getTime();
		long day = 86400000;

		GraphViewSeries exampleSeries = new GraphViewSeries(
				new GraphViewData[] { 
						new GraphViewData(now - day * 5, .5d),
						new GraphViewData(now - day * 4.5, 1.7d),
						new GraphViewData(now - day * 4.0, 2.1d),
						new GraphViewData(now - day * 3.5, 2.5d),
						new GraphViewData(now - day * 3, 2.9d),
						new GraphViewData(now - day * 2.5, 3.2d),
						new GraphViewData(now - day * 2.0, 3.3d),
						new GraphViewData(now - day * 1.5, 3.4d),
						new GraphViewData(now - day * 1, 3.5d),
						new GraphViewData(now, 3.5d) 
						});

		GraphView graphView = new LineGraphView(this, "Vital Capacity") {

			@Override
			protected String formatLabel(double value, boolean isValueX) {

				if (isValueX) {
					return dateFormat.format(new Date((long) value));
				}
				return super.formatLabel(value, isValueX);
			}

		};
		graphView.setGravity(Gravity.CENTER);

		graphView.addSeries(exampleSeries); // data
		return graphView;

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_patient_chart, menu);
		return true;
	}
}
