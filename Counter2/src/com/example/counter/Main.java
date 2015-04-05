package com.example.counter;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.counter2.R;

public class Main extends Activity{
	
	private Button increment, clear;
	private TextView display;
	private int counter=0;
	private EditText input;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		increment = (Button)findViewById(R.id.increment);
		clear = (Button)findViewById(R.id.clear);
		display = (TextView)findViewById(R.id.display);
		input = (EditText)findViewById(R.id.input);
		
		
		increment.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				counter++;
				display.setText(String.valueOf(counter));
				
			}});
		
		clear.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				String value = input.getText().toString();
				if(!value.equals("")){
					counter = Integer.valueOf(value);
				}else{
					counter = 0;
				}
				display.setText(String.valueOf(counter));
				
			}});
				
	}
	
}
