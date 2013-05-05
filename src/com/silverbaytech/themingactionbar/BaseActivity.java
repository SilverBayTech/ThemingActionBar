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

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;

public class BaseActivity extends SherlockActivity
{
	public BaseActivity()
	{
	}

	protected void setupButtons(Class<?> currentClass)
	{
		for (ButtonDetails buttonDetails : buttons)
		{
			final Class<?> activityClass = buttonDetails.getActivityClass();
			Button button = (Button) findViewById(buttonDetails.getId());
			if (button != null)
			{
				if (currentClass == activityClass)
				{
					button.setVisibility(View.GONE);
				}
				else
				{
					button.setOnClickListener(new OnClickListener()
					{
						@Override
						public void onClick(View v)
						{
							startActivity(new Intent(BaseActivity.this, activityClass));
							finish();
						}
					});
				}
			}
		}
	}

	private static ButtonDetails[] buttons =
	{
		new ButtonDetails(R.id.button_fewtabs, TabActivity.class),
		new ButtonDetails(R.id.button_manytabs, ManyTabActivity.class),
		new ButtonDetails(R.id.button_list, ListActivity.class),
		new ButtonDetails(R.id.button_menu, MenuActivity.class),
		new ButtonDetails(R.id.button_split, SplitActivity.class),
	};

	private static class ButtonDetails
	{
		private int id;
		private Class<?> activityClass;

		public ButtonDetails(int id, Class<?> activityClass)
		{
			this.id = id;
			this.activityClass = activityClass;
		}

		public int getId()
		{
			return id;
		}

		public Class<?> getActivityClass()
		{
			return activityClass;
		}
	}
}
