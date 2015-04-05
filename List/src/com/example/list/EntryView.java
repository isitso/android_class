package com.example.list;



import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EntryView extends Fragment{
	
	public interface OnItemAddedListener{
		public void onStringEntered(String entry);
	}
	OnItemAddedListener mCallback;
	Button enter;
	EditText input;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view =  inflater.inflate(R.layout.entry_layout, container, true );
		
		enter = (Button)view.findViewById(R.id.enter);
		input = (EditText)view.findViewById(R.id.input);
		
		enter.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				String entry = input.getText().toString();
				mCallback.onStringEntered(entry);
				
			}});
		
		
		return view;
		
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		   try {
	            mCallback = (OnItemAddedListener) activity;
	        } catch (ClassCastException e) {
	            throw new ClassCastException(activity.toString()
	                    + " must implement OnHeadlineSelectedListener");
	        }

		
		
	}
	
	
	
	

}
