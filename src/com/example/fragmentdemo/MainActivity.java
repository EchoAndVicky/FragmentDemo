package com.example.fragmentdemo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.transition.ChangeTransform;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	private LinearLayout tab0,tab1,tab2;
	
	private FragmentManager fragmentManager;
	
	private Fragment currentFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
		initFragment();
	}

	private void initFragment() {
		tab0.setSelected(true);
		tabChange(0);
	}

	private void initView() {
		tab0=(LinearLayout) findViewById(R.id.tab0);
		tab0.setOnClickListener(new MyOnClickListener());
		tab0.setTag(0);
		
		tab1=(LinearLayout) findViewById(R.id.tab1);
		tab1.setOnClickListener(new MyOnClickListener());
		tab1.setTag(1);
		
		tab2=(LinearLayout) findViewById(R.id.tab2);
		tab2.setOnClickListener(new MyOnClickListener());
		tab2.setTag(2);
	}

	private class MyOnClickListener implements android.view.View.OnClickListener{

		@Override
		public void onClick(View v) {
			tabChange((Integer)v.getTag());
		}
	}
	

	private void tabChange(Integer tag) {
		tab0.setSelected(tag == 0);
        tab1.setSelected(tag == 1);
        tab2.setSelected(tag == 2);
		
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		if(currentFragment!=null)
			ft.hide(currentFragment);
		Fragment fragment = FragmentFactory.getFactory().getInstanceByIndex(tag);

		currentFragment = fragment;

        //判断此Fragment是否已经添加到FragmentTransaction事物中
        if (!fragment.isAdded()) {
            ft.add(R.id.fragment, fragment, fragment.getClass().getName());
        } else {
            ft.show(fragment);
        }
        ft.commit();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
