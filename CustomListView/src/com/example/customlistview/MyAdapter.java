package com.example.customlistview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.customlistview.R;


public class MyAdapter extends ArrayAdapter{
	private String[] myList;
	private Context context;

	public MyAdapter(Context context, int resource, String[] objects) {
		super(context, resource, objects);
		myList = objects;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView label;
		//reuse converView if you can to speed up scrolling on listview
		if(convertView == null){
			//inflate the listview
			LayoutInflater inflator = ((Activity)context).getLayoutInflater();
			convertView = inflator.inflate(R.layout.row, parent, false);
			convertView.setTag(R.id.textView1, convertView.findViewById(R.id.textView1));
			
		}
		
		label = (TextView) convertView.getTag(R.id.textView1);
		label.setText(myList[position]);
		
		if(myList[position].contains("s")){
			label.setTextColor(Color.RED);
		}
		
		
		return convertView;
	}
	
	
	
	
	

}
