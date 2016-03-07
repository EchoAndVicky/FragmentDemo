package com.example.fragmentdemo;

import android.app.Fragment;


public class FragmentFactory {
	private static FragmentFactory factory;
	private static Fragment[] fragments;
	
	private FragmentFactory(){
		fragments=new Fragment[3];
	}
	
	public static synchronized FragmentFactory getFactory(){
		if(factory==null)
			factory=new FragmentFactory();
		return factory;
	}
	
	public Fragment getInstanceByIndex(int index) {
        switch (index) {  
            case 0:  
            	if(fragments[index]==null)
            		fragments[index]=new FragmentTab0();
                break;  
            case 1: 
            	if(fragments[index]==null)
            		fragments[index] = new FragmentTab2();  
                break;  
            case 2: 
            	if(fragments[index]==null)
            		fragments[index] = new FragmentTab1();  
                break;  
        }  
        return fragments[index];  
    }  
}
