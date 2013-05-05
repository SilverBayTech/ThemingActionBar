/*
 * Copyright (c) 2013 Kevin Hunter
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.silverbaytech.themingactionbar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import com.actionbarsherlock.app.ActionBar;

public class ListActivity extends BaseActivity implements ActionBar.OnNavigationListener
{
	public ListActivity()
	{
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);

		SpinnerAdapter spinnerAdapter = ArrayAdapter
			.createFromResource(this,
								R.array.navigation_list,
								android.R.layout.simple_spinner_item);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setListNavigationCallbacks(spinnerAdapter, this);

		setupButtons(getClass());
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId)
	{
		return false;
	}
}
