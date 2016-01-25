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

package org.tlc.whereat.modules.pubsub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

public class Dispatcher {

    public static void register(LocalBroadcastManager bm, BroadcastReceiver br, String action){
        bm.registerReceiver(br, new IntentFilter(action));
    }

    public static void broadcast(Context ctx, Intent i){
        LocalBroadcastManager.getInstance(ctx).sendBroadcast(i);
    }

    public static void broadcast(LocalBroadcastManager bm, Context ctx, Intent i){
        LocalBroadcastManager bm_ = (bm != null) ? bm : LocalBroadcastManager.getInstance(ctx);
        bm_.sendBroadcast(i);
    }
}
