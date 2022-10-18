package com.example.androidstudyapp;

import androidx.databinding.ObservableField;

public class MvvmViewModel implements IBaseViewModel {

	public ObservableField<String> mvvmVal = new ObservableField<>();
	private int nnn = 0;

	@Override
	public void onCreate() {
		mvvmVal.set("Hello World!");
	}

	@Override
	public void onResume() {
	}
	@Override
	public void onPause() {
	}

	@Override
	public void onDestroy() {

	}
	public void onActionClick() {
		nnn++;
		mvvmVal.set("value changed = " + Integer.toString(nnn));
	}

}
