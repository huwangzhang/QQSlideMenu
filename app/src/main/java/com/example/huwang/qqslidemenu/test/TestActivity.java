package com.example.huwang.qqslidemenu.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.example.huwang.qqslidemenu.R;


public class TestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
