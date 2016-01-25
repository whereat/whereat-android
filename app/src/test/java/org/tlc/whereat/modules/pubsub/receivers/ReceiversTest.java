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

import android.app.Activity;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import static org.mockito.Mockito.*;

import org.mockito.ArgumentCaptor;
import org.robolectric.shadows.ShadowLog;

import java.util.List;

public class ReceiversTest {

    static { ShadowLog.stream = System.out; }

    Activity ctx;
    LocalBroadcastManager lbm;
    ArgumentCaptor<IntentFilter> ifArg;

    protected void addSpies(List<Receivers> rs){
        for (int i=0; i < rs.size(); i++) rs.set(i, spy(rs.get(i)));
    }

}
