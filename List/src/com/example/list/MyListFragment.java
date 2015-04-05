package com.example.list;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class MyListFragment extends ListFragment{
	
	String[] stuff = {
			"ipsum",
			"laurum",
			"ultifathom",
			"mermelon"					
	};
	
	private ArrayList<String> stuffList = new ArrayList<>(Arrays.asList(stuff));
	ArrayAdapter <String> adapter;
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		stuff = stuffList.toArray(new String[0]);
		adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, 0, stuffList);
		setListAdapter(adapter);
		return super.onCreateView(inflater, container, savedInstanceState);
		
	}
	

	public ArrayAdapter<String> getAdapter() {
		return adapter;
	}



	public void setAdapter(ArrayAdapter<String> adapter) {
		this.adapter = adapter;
	}



	public String[] getStuff() {
		return stuff;
	}



	public void setStuff(String[] stuff) {
		this.stuff = stuff;
	}



	public ArrayList<String> getStuffList() {
		return stuffList;
	}



	public void setStuffList(ArrayList<String> stuffList) {
		this.stuffList = stuffList;
	}




	
	
}
