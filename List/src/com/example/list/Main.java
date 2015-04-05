package com.example.list;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Main extends Activity implements EntryView.OnItemAddedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

	}

	@Override
	public void onStringEntered(String entry) {
	
		Log.i("myTag", "Entry: " + entry);
		MyListFragment mList = (MyListFragment) getFragmentManager()
				.findFragmentById(R.id.listFragment);		
		mList.getAdapter().add(entry);
		mList.getAdapter().notifyDataSetChanged();

	}

}
