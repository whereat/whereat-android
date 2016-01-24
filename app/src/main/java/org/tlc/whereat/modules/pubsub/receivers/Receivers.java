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

import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;

import java.util.List;

public abstract class Receivers {

    protected Context mCtx;
    protected LocalBroadcastManager mLbm;
    protected List<Receivers> mReceivers;

    public Receivers(Context ctx){
        mCtx = ctx;
        mLbm = LocalBroadcastManager.getInstance(mCtx);
    }

    public Receivers(Context ctx, LocalBroadcastManager lbm){
        mCtx = ctx;
        mLbm = lbm;
    }

    public void register() {
        for (Receivers r : mReceivers) r.register();
    }

    public void unregister() {
        for (Receivers r : mReceivers) r.unregister();
    }

}
