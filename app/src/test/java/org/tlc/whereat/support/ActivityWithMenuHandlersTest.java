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

package org.tlc.whereat.support;

import android.view.Menu;
import android.view.MenuItem;

import org.robolectric.fakes.RoboMenuItem;
import org.tlc.whereat.R;

public class ActivityWithMenuHandlersTest {

    //FIELDS

    protected Menu menu;
    protected MenuItem main = new RoboMenuItem(R.id.action_on_off);
    protected MenuItem map = new RoboMenuItem(R.id.action_map);
    protected MenuItem prefs = new RoboMenuItem(R.id.action_prefs);

}
