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


import android.app.Activity;
import android.content.ComponentName;
import android.os.IBinder;

import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowToast;
import org.robolectric.util.ActivityController;

import static org.robolectric.Shadows.shadowOf;

public class ActivityHelpers {

    public static <T extends Activity> T createActivity(Class<T> activity){
        return Robolectric.buildActivity(activity).create().get();
    }

    public static <T extends Activity> T resumeActivity(Class<T> activity){
        return Robolectric.buildActivity(activity).create().resume().visible().get();
    }

    public static String nextActivity(Activity a){
        return shadowOf(shadowOf(a).getNextStartedActivity()).getComponent().getClassName();
    }

    public static String nextService(Activity a){
        return shadowOf(shadowOf(a).getNextStartedService()).getComponent().getClassName();
    }

    public static String lastToast(){
        return ShadowToast.getTextOfLatestToast();
    }

}
