/**
 *
 * Copyright (c) 2015-present, Total Location Test Paragraph.
 * All rights reserved.
 *
 * This file is part of Where@. Where@ is free software:
 * you can redistribute it and/or modify it under the terms of
 * the GNU General Public License (GPL), either version 3
 * of the License, or (at your option) any later version.
 *
 * Where@ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. For more details,
 * see the full license at <http://www.gnu.org/licenses/gpl-3.0.en.html>
 *
 */

package org.tlc.whereat.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import org.tlc.whereat.fragments.SettingsFragment;
import org.tlc.whereat.modules.pubsub.receivers.SettingsActivityReceivers;
import org.tlc.whereat.modules.ui.MenuHandler;


public class SettingsActivity extends AppCompatActivity {

    public static String TAG = SettingsActivity.class.getCanonicalName();

    protected MenuHandler mMenu;
    protected SettingsActivityReceivers mReceivers;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMenu = new MenuHandler(this);
        mReceivers = new SettingsActivityReceivers(this);
        showFragment();
    }

    @Override
    public void onResume(){
        super.onResume();
        mReceivers.register();
    }

    @Override
    public void onPause(){
        super.onPause();
        mReceivers.unregister();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return mMenu.create(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mMenu.select(item, super::onOptionsItemSelected);
    }

    protected void showFragment(){
        getFragmentManager()
            .beginTransaction()
            .replace(
                android.R.id.content,
                new SettingsFragment(),
                "settings_fragment"
            ).commit();
    }

}

