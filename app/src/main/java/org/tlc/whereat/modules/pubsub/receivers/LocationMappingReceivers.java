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

package org.tlc.whereat.modules.pubsub.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import org.tlc.whereat.activities.MapActivity;
import org.tlc.whereat.modules.pubsub.broadcasters.LocPubBroadcasters;
import org.tlc.whereat.model.UserLocation;
import org.tlc.whereat.modules.pubsub.Dispatcher;
import org.tlc.whereat.modules.schedule.Scheduler;

public class LocationMappingReceivers extends Receivers {

    //FIELDS

    public static final String TAG = LocationMappingReceivers.class.getSimpleName();
    protected BroadcastReceiver mMap = map();
    protected BroadcastReceiver mForget = forget();

    // CONSTRUCTOR

    public LocationMappingReceivers(Context ctx, LocalBroadcastManager lbm){
        super(ctx, lbm);
    }

    // PUBLIC METHODS

    public void register(){
        Dispatcher.register(mLbm, mMap, LocPubBroadcasters.ACTION_LOCATION_RECEIVED);
        Dispatcher.register(mLbm, mForget, Scheduler.ACTION_LOCATIONS_FORGOTTEN);
    }

    public void unregister(){
        mLbm.unregisterReceiver(mMap);
        mLbm.unregisterReceiver(mForget);
    }

    // BROADCAST RECEIVERS

    private BroadcastReceiver map(){
        return new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent i) {
                UserLocation l = i.getExtras().getParcelable(LocPubBroadcasters.ACTION_LOCATION_RECEIVED);
                ((MapActivity) mCtx).map(l);
            }
        };
    }

    private BroadcastReceiver forget(){
        return new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent i) {
                long time = i.getExtras().getLong(Scheduler.ACTION_LOCATIONS_FORGOTTEN);
                ((MapActivity) mCtx).forgetSince(time);
            }
        };
    }
}
