package com.example.project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

;

public class ImageAdapter extends ArrayAdapter<ListItemObject> {
	private final Context context;
	private final ListItemObject[] values;

	public ImageAdapter(Context context, ListItemObject[] values) {
		super(context, R.layout.follow_list_item, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.follow_list_item, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.itemTextView);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.itemImageView);
		textView.setText(values[position].getText());
		//imageView.setImageDrawable(drawable);
		return rowView;
	}
}
