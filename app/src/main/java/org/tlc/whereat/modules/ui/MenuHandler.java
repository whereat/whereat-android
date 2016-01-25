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

package org.tlc.whereat.modules.ui;


import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import org.tlc.whereat.R;
import org.tlc.whereat.activities.OnOffActivity;
import org.tlc.whereat.activities.MapActivity;
import org.tlc.whereat.activities.SettingsActivity;

import rx.functions.Func1;

public class MenuHandler {

    Activity mCtx;

    public MenuHandler(Activity ctx){
        mCtx = ctx;
    }

    public boolean create(Menu menu){
        mCtx.getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean select(MenuItem item, Func1<MenuItem, Boolean> fn){
        switch(item.getItemId()){
            case R.id.action_on_off:
                mCtx.startActivity(new Intent(mCtx, OnOffActivity.class));
                break;
            case R.id.action_map:
                mCtx.startActivity(new Intent(mCtx, MapActivity.class));
                break;
            case R.id.action_prefs:
                mCtx.startActivity(new Intent(mCtx, SettingsActivity.class));
                break;
        }
        return fn.call(item);
    }
}
