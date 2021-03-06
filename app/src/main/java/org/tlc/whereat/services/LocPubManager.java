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

package org.tlc.whereat.services;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

public class LocPubManager {

    //TODO test this!!!!!

    public static final String TAG = LocPubManager.class.getSimpleName();

    protected Context mContext;
    protected LocationPublisher mLocationPublisher;
    protected ServiceConnection mLocationServiceConnection = getLocationServiceConnection();
    protected boolean mRunning;

    public LocPubManager(Context ctx){
        mContext = ctx;
    }


    // LIFE CYCLE METHODS

    public LocPubManager start(){
        Intent i = new Intent(mContext, LocationPublisher.class);
        mContext.startService(i);
        mRunning = true;
        return this;
    }

    public void stop(){
        Intent i = new Intent(mContext, LocationPublisher.class);
        mContext.stopService(i);
        mRunning = false;
    }


    public boolean bind(){
        Intent i = new Intent(mContext, LocationPublisher.class);
        return mContext.bindService(i, mLocationServiceConnection, Context.BIND_AUTO_CREATE);
    }

    public void unbind(){
        mContext.unbindService(mLocationServiceConnection);
    }

    private ServiceConnection getLocationServiceConnection(){
        return new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i(TAG, "Location service connected.");
                mLocationPublisher = ((LocationPublisher.LocationServiceBinder) service).getService();
            }
            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i(TAG, "Location service disconnected.");
                mLocationPublisher = null;
            }
        };
    }

    // PUBLIC METHODS

    public void ping(){
        mLocationPublisher.ping();
    }

    public boolean isRunning() { return mRunning; }

    public boolean isPolling(){
        return mLocationPublisher.isPolling();
    }

    public void poll(){
        mLocationPublisher.poll();
    }

    public void stopPolling(){
        mLocationPublisher.stopPolling();
    }

    public void clear() { mLocationPublisher.clear(); }


}
