package com.example.fragmentdemo;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTab2 extends Fragment{
	private View view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		view=inflater.inflate(R.layout.fragment_world, container,false);
		return view;
	}
	
	@Override
	public void onPause(){
		super.onPause();
	}
	
	@Override
	public void onResume(){
		super.onResume();
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
	}
}
